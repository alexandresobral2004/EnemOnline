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
import model.Disciplina;

/**
 *
 * @author cedsobral
 */
@Stateless
public class disciplinaDAO {
    
    
    public void adddisciplina(Disciplina disciplina) {
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.persist(disciplina);
    }
    
    public void editDisciplina(Disciplina disciplina){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.merge(disciplina);
    }
    public void delDisciplina(Disciplina disciplina){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Disciplina a = em.merge(disciplina);
        em.remove(a);
    }
    
    public Disciplina findDisciplinaByID(int id){
        return JPAUtil.getInstance().getEntity(Disciplina.class, id);
    }
    
    public List<Disciplina> findAllDisciplinas(){
        return JPAUtil.getInstance().getList(Disciplina.class, "SELECT d FROM Disciplina d");
    }
  
}
