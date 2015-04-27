/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ItemDAO;
import dao.QuestaoDAO;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Item;
import model.Prova;
import model.Questao;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class QuestaoFaces implements Serializable{

    
    private Prova selectedProva;
    private Questao selectedQuestao;
    private List<Questao> questoes;
//Itens da prova
    private Item selectedItem;
    
   
    
    //Componentes para renderização
    private Boolean selectCheckbox = false;
    private Boolean renderCompUpload = false;
    private Boolean renderCompText = false;

    //Chamada dos DAO's
    @EJB
    private QuestaoDAO questaoDAO;
   
  
    
    public Boolean getRenderCompUpload() {
        return renderCompUpload;
    }

    public void setRenderCompUpload(Boolean renderCompUpload) {
        this.renderCompUpload = renderCompUpload;
    }

    public Boolean getRenderCompText() {
        return renderCompText;
    }

    public void setRenderCompText(Boolean renderCompText) {
        this.renderCompText = renderCompText;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
    
    
    

    public Boolean getSelectCheckbox() {
        return selectCheckbox;
    }

    public void setSelectCheckbox(Boolean selectCheckbox) {
        this.selectCheckbox = selectCheckbox;
    }
    

    public Prova getSelectedProva() {
        return selectedProva;
    }

    public void setSelectedProva(Prova selectedProva) {
        this.selectedProva = selectedProva;
    }

    public Questao getSelectedQuestao() {
        return selectedQuestao;
    }

    public void setSelectedQuestao(Questao selectedQuestao) {
        this.selectedQuestao = selectedQuestao;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        this.selectedItem = selectedItem;
    }

    
   
    
    public String startQuestao(){
      this.selectedProva = new Prova();
        this.selectedQuestao = new Questao();
       //Instancia itens das questoes
        this.selectedItem = new Item();
        incrementaNumQuestao();
      
        System.out.println("Inicia Questão");
        return "/pages/questao.jsf";
    } 
    
    public QuestaoFaces() {
        this.selectedProva = new Prova();
        
    }
    
    
    public void addQuestao(){
      // incrementaNumQuestao();
        questaoDAO.addquestao(selectedQuestao);
        
        
        System.out.println("Questão Inserida");
    }
    
    
  
    
    public int findNumQuestao(){
      int num = questaoDAO.getUltimaQuestao();
       return num;
       
    }
    
    
    
   // FacesContext fc = FacesContext.getCurrentInstance();
    //HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
    //Integer valor = session.setAttribute(this.selectedQuestao.getNumQuestao());
    
    /*   RECUPERANDO VALOR
    HttpServletRequest request = (HttpServletRequest) req;
    HttpSession session = (HttpSession) request.getSession();
    Integer idUsuarioSession = session.getAttribute("NUM");*/
    
   
    
    
    public void incrementaNumQuestao(){
        
        
        Integer num = findNumQuestao();
        if(num.equals(0)){
            num = 1;
          this.selectedQuestao.setNumQuestao(num);
        
        }
        else{
           
            num+=1;
            this.selectedQuestao.setNumQuestao(num);
            
        }
        
    }
    
    
   
    public List<Questao> findAllQuestaoes(){
        questoes = new ArrayList<>();
        questoes = questaoDAO.getAllQuestoes();
        
        return questoes;
        
    }
    
  



    
}
