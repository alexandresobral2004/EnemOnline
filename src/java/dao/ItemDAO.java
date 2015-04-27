/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.JPAUtil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import model.Item;
import model.Questao;

/**
 *
 * @author cedsobral
 */
@Stateless
public class ItemDAO {

    
    public void addItem(Item item) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
         em.persist(item);
    }

    public void editItem(Item item) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.merge(item);
    }

    public void delItem(Item item) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Item a = em.merge(item);
        em.remove(a);
    }

    public Item getItemByID(int id) {
        return JPAUtil.getInstance().getEntity(Item.class, id);
    }

    public List<Item> getAllItems() {
        return JPAUtil.getInstance().getList(Item.class, "SELECT a FROM Item a");
    }
}
