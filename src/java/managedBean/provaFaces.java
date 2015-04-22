/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
public class provaFaces implements Serializable{

    
    private Prova selectedProva;
    private Questao selectedQuestao;
    //Itens da prova
    private Item selectedItem_a;
    private Item selectedItem_b;
    private Item selectedItem_c;
    private Item selectedItem_d;
    private Item selectedItem_e;
    
    private Boolean selectCheckbox = false;
    private Boolean renderCompUpload = false;
    private Boolean renderCompText = false;

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

    public Item getSelectedItem_a() {
        return selectedItem_a;
    }

    public void setSelectedItem_a(Item selectedItem_a) {
        this.selectedItem_a = selectedItem_a;
    }

    public Item getSelectedItem_b() {
        return selectedItem_b;
    }

    public void setSelectedItem_b(Item selectedItem_b) {
        this.selectedItem_b = selectedItem_b;
    }

    public Item getSelectedItem_c() {
        return selectedItem_c;
    }

    public void setSelectedItem_c(Item selectedItem_c) {
        this.selectedItem_c = selectedItem_c;
    }

    public Item getSelectedItem_d() {
        return selectedItem_d;
    }

    public void setSelectedItem_d(Item selectedItem_d) {
        this.selectedItem_d = selectedItem_d;
    }

    public Item getSelectedItem_e() {
        return selectedItem_e;
    }

    public void setSelectedItem_e(Item selectedItem_e) {
        this.selectedItem_e = selectedItem_e;
    }

   
    
    public String startQuestao(){
      this.selectedProva = new Prova();
        this.selectedQuestao = new Questao();
       //Instancia itens das questoes
        this.selectedItem_a = new Item();
        this.selectedItem_b = new Item();
        this.selectedItem_c = new Item();
        this.selectedItem_d = new Item();
        this.selectedItem_e = new Item();
        System.out.println("Inicia Questão");
        return "/pages/questao.jsf";
    } 
    
    public provaFaces() {
        this.selectedProva = new Prova();
                
        
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
    
    
    public void carregarArquivo(FileUploadEvent event) // metodo chamado quando o arquivo acaba de carregar no serverSide
            throws FileNotFoundException, IOException {

        FacesMessage msg = new FacesMessage("Sucesso " + event.getFile().getFileName() + " foi carregado.", event.getFile()
                .getFileName() + " foi carregado."); // mensagem pra saber se ouve sucesso

       String arquivo = event.getFile().getFileName(); // pego o nome do arquivo

        String caminho = FacesContext.getCurrentInstance().getExternalContext()
                .getRealPath("\"WEB-INF/fotos/" + arquivo); // diretorio o qual vou salvar o arquivo do upload, equivale ao nome completamente qualificado

        byte[] conteudo = event.getFile().getContents();  // daqui pra baixo é somente operações de IO.
        FileOutputStream fos = new FileOutputStream(caminho);
        fos.write(conteudo);
        fos.close();
        

    }


    
}
