/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpCustomernomenafinoana.service;

import jakarta.enterprise.context.RequestScoped;
import mg.itu.tpCustomernomenafinoana.entity.Discount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Nomena
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    /**
     * Retourne la liste des discounts dans la base de données.
     *
     * @return List
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();

    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}
