/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Item;
import model.Questao;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class exibeQuestao implements Serializable{
    
    
    private Questao selectedQuestao;
    private List<Item> itens;
    
    
}
