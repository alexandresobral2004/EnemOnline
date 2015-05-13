/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Util.JPAUtil;
import java.util.List;
import javax.ejb.Stateless;
import model.Questao;

/**
 *
 * @author cedsobral
 */
@Stateless
public class ExibeQuestaoDAO {
    
    
    
     public Questao getQuestaoByID(int id){
        return JPAUtil.getInstance().getEntity(Questao.class, id);
    }
     
     public List<Questao> getQuestaoPorDiscip(int id){
         
         return JPAUtil.getInstance().getQuestaobyNUM(Questao.class,"SELECT * FROM Questao  WHERE disciplina_id='"+id+"'",id);
         
     }
    
}
