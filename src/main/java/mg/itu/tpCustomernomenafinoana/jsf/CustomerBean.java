/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.itu.tpCustomernomenafinoana.jsf;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.itu.tpCustomernomenafinoana.entity.Customer;
import mg.itu.tpCustomernomenafinoana.service.CustomerManager;

/**
 * Backing bean pour la page JSF customerList.
 *
 * @author Nomena
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {

    private List<Customer> customerList;
    private List<String> nameList;
    private List<String> stateList;

    @Inject
    private CustomerManager customerManager;

    /**
     * Creates a new instance of CustomerBean
     */
    public CustomerBean() {
    }

    /**
     * Retourne la liste des clients pour affichage dans une DataTable.
     *
     * @return List<Customer>
     */
    public List<Customer> getCustomers() {
        if (customerList == null) {
            customerList = customerManager.getAllCustomers();
        }
        return customerList;
    }

    /**
     * Retourne la liste des noms sans doublant.
     *
     * @return List<String>
     */
    public List<String> getNames() {
        if (nameList == null) {
            nameList = customerManager.getAllNames();
        }
        return nameList;
    }

    /**
     * Retourne la liste des etats sans doublant.
     *
     * @return List<String>
     */
    public List<String> getStates() {
        if (stateList == null) {
            stateList = customerManager.getAllStates();
        }
        return stateList;
    }

}
