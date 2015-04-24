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
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
    //Itens da prova
    private Item selectedItem;
   
    
    //Componentes para renderização
    private Boolean selectCheckbox = false;
    private Boolean renderCompUpload = false;
    private Boolean renderCompText = false;

    //Chamada dos DAO's
    @EJB
    private QuestaoDAO questaoDAO;
    @EJB
    private ItemDAO itemDAO;

  
    
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
        
      
        System.out.println("Inicia Questão");
        return "/pages/questao.jsf";
    } 
    
    public QuestaoFaces() {
        this.selectedProva = new Prova();
                
        
    }
    
    
    public void addQuestao(){
      
        
        
        questaoDAO.addquestao(selectedQuestao);
        this.itemDAO.addItem(selectedItem);
        System.out.println("Questão Inserida");
    }
    
    
    public void alteraComponente(){
        System.out.println("chamou altera componente");
        if(this.selectCheckbox == true){
            this.renderCompUpload = true;
            this.renderCompText = false;
        }
        else{
            this.renderCompText = true;
             this.renderCompUpload = false;
        }
    }
    
    public int findNumQuestao(){
        int num = questaoDAO.getNumQuestao().getNumQuestao();
        return num;
    }
    
    
    public void incNumQuestao(){
        int num = findNumQuestao();
        if(num == 0){
            this.selectedQuestao.setNumQuestao(1);
            
        }
        else{
           
            num+=1;
            this.selectedQuestao.setNumQuestao(num);
            
        }
    }
    
    
   private  FacesMessage msg = null;
    
    
    public void carregarArquivo(FileUploadEvent event) // metodo chamado quando o arquivo acaba de carregar no serverSide
            throws FileNotFoundException, IOException {

     this.msg = new FacesMessage("Sucesso " + event.getFile().getFileName() + " foi carregado.", event.getFile()
                .getFileName() + " foi carregado."); // mensagem pra saber se ouve sucesso

       String arquivo = event.getFile().getFileName(); // pego o nome do arquivo
        
        String caminho = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("WEB-INF//fotos//" + arquivo); // diretorio o qual vou salvar o arquivo do upload, equivale ao nome completamente qualificado

        byte[] conteudo = event.getFile().getContents();  // daqui pra baixo é somente operações de IO.
        FileOutputStream fos = new FileOutputStream(caminho);
        fos.write(conteudo);
        fos.close();
        

    }
    
  



    
}
