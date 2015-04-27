/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;


import dao.ItemDAO;
import java.io.FileNotFoundException;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import model.Item;
import model.Questao;

@ManagedBean
@SessionScoped
 class itemFaces implements Serializable{
    
  
    private Item selectItem_a;
    private Item selectItem_b;
    private Item selectItem_c;
    private Item selectItem_d;
    private Item selectItem_e;
    private Questao selectQuestao;
    private List<Item> itens;
    @Inject
    ItemDAO itemDAO;
    
    public String startItem(){
        selectItem_a = new Item();
        selectItem_b = new Item();
        selectItem_c = new Item();
        selectItem_d = new Item();
        selectItem_e = new Item();
        selectQuestao = new Questao();
        
        System.out.println("Cadastro de Itens iniciado");
        return "/pages/itens.jsf";
    }

    public Questao getSelectQuestao() {
        return selectQuestao;
    }

    public void setSelectQuestao(Questao selectQuestao) {
        this.selectQuestao = selectQuestao;
    }

    
    public Item getSelectItem_a() {
        return selectItem_a;
    }

    public void setSelectItem_a(Item selectItem_a) {
        this.selectItem_a = selectItem_a;
    }

    public Item getSelectItem_b() {
        return selectItem_b;
    }

    public void setSelectItem_b(Item selectItem_b) {
        this.selectItem_b = selectItem_b;
    }

    public Item getSelectItem_c() {
        return selectItem_c;
    }

    public void setSelectItem_c(Item selectItem_c) {
        this.selectItem_c = selectItem_c;
    }

    public Item getSelectItem_d() {
        return selectItem_d;
    }

    public void setSelectItem_d(Item selectItem_d) {
        this.selectItem_d = selectItem_d;
    }

    public Item getSelectItem_e() {
        return selectItem_e;
    }

    public void setSelectItem_e(Item selectItem_e) {
        this.selectItem_e = selectItem_e;
    }
    
    public void preencheItem() {
        this.selectItem_a.setQuestao(selectQuestao);
        this.selectItem_b.setQuestao(selectQuestao);
        this.selectItem_c.setQuestao(selectQuestao);
        this.selectItem_d.setQuestao(selectQuestao);
        this.selectItem_e.setQuestao(selectQuestao);

    }
    
    
    
    public void addItem(){
        preencheItem();
        itemDAO.addItem(selectItem_a);
        itemDAO.addItem(selectItem_b);
        itemDAO.addItem(selectItem_c);
        itemDAO.addItem(selectItem_d);
        itemDAO.addItem(selectItem_e);
        System.out.println("Itens Inseridos");
       
       
       
    }
    
    
    
    
    
    
    
    
    
    
    
 
    
}
