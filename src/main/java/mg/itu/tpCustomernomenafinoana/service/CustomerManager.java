/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpCustomernomenafinoana.service;

import mg.itu.tpCustomernomenafinoana.entity.Customer;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

/**
 * Gère la persistance des Customers..
 *
 * @author Nomena
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    @Transactional
    public void persist(Customer customer) {
        em.persist(customer);
    }

    /**
     * Retourne la liste des clients dans la base de données.
     *
     * @return List
     */
    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();

    }

    /**
     * Mise à jour des information sur un client.
     *
     * @param customer
     * @return
     */
    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    /**
     * Retourne la liste des noms dans la base de données sans doublant.
     *
     * @return List<String>
     */
    public List<String> getAllNames() {
        Query query = em.createNamedQuery("Customer.findAllNames");
        return query.getResultList();
    }

    /**
     * Retourne la liste des etats dans la base de données sans doublant.
     *
     * @return List<String>
     */
    public List<String> getAllStates() {
        Query query = em.createNamedQuery("Customer.findAllStates");
        return query.getResultList();
    }

    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }

}
