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
import model.Questao;

/**
 *
 * @author cedsobral
 */
@Stateless
public class QuestaoDAO {
   
    
    public void addquestao(Questao questao){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.merge(questao);
    }
    
    public void editQuestao(Questao questao){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        em.merge(questao);
    }
    public void delQuestao(Questao questao){
        EntityManager em = JPAUtil.getInstance().getEntityManager();
        Questao a = em.merge(questao);
        em.remove(a);
    }
    
    public Questao getQuestaoByID(int id){
        return JPAUtil.getInstance().getEntity(Questao.class, id);
    }
    
    public List<Questao> getAllQuestoes(){
        return JPAUtil.getInstance().getList(Questao.class, "SELECT a FROM Questao a");
    }
    
    public int getUltimaQuestao(){
        Integer result  = JPAUtil.getInstance().getNumQuestao("select max(q.numQuestao) from Questao q");   
        return result;
    }
  
    
    
}
