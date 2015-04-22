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

/**
 *
 * @author cedsobral
 */
@Stateless
public class ProvaDAO {
    
    public void addProva(ProvaDAO prova){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.persist(prova);
    }
    
    public void editProva(ProvaDAO prova){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.merge(prova);
    }
    public void delProva(ProvaDAO prova){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        ProvaDAO a = em.merge(prova);
        em.remove(a);
    }
    
    public ProvaDAO getProvaByID(int id){
        return JPAUtil.getInstance().getEntity(ProvaDAO.class, id);
    }
    
    public List<ProvaDAO> getAllProvas(){
        return JPAUtil.getInstance().getList(ProvaDAO.class, "SELECT a FROM Prova a");
    }
    
   /* public List<Prova> getProvasPorVisita(int visita_id){
        return JPAUtil.getInstance().getProvasByVisita(Prova.class, "SELECT prova FROM Prova prova WHERE prova.visita.id= :visita_id", visita_id);
    }*/
    
    
}
