/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ItemDAO;
import java.io.File;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import model.Item;
import model.Questao;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class itemFaces implements Serializable {

    private Item selectItem_a;
    private Item selectItem_b;
    private Item selectItem_c;
    private Item selectItem_d;
    private Item selectItem_e;
    private Questao selectQuestao;
    private List<Item> itens;
    private String newFileName_A;
    private String newFileName_B;
    private String newFileName_C;
    private String newFileName_D;
    private String newFileName_E;
    
    
    @Inject
    ItemDAO itemDAO;

    public String startItem() {
        selectItem_a = new Item();
        selectItem_b = new Item();
        selectItem_c = new Item();
        selectItem_d = new Item();
        selectItem_e = new Item();
        selectQuestao = new Questao();
        preencheItemQuestao();

        System.out.println("Cadastro de Itens iniciado");
        return "/pages/Itens.jsf";
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

    public String getNewFileName_A() {
        return newFileName_A;
    }

    public void setNewFileName_A(String newFileName_A) {
        this.newFileName_A = newFileName_A;
    }

    public String getNewFileName_B() {
        return newFileName_B;
    }

    public void setNewFileName_B(String newFileName_B) {
        this.newFileName_B = newFileName_B;
    }

    public String getNewFileName_C() {
        return newFileName_C;
    }

    public void setNewFileName_C(String newFileName_C) {
        this.newFileName_C = newFileName_C;
    }

    public String getNewFileName_D() {
        return newFileName_D;
    }

    public void setNewFileName_D(String newFileName_D) {
        this.newFileName_D = newFileName_D;
    }

    public String getNewFileName_E() {
        return newFileName_E;
    }

    public void setNewFileName_E(String newFileName_E) {
        this.newFileName_E = newFileName_E;
    }

  
    public void preencheItemQuestao() {
        this.selectItem_a.setItem("a");
        this.selectItem_b.setItem("b");
        this.selectItem_c.setItem("c");
        this.selectItem_d.setItem("d");
        this.selectItem_e.setItem("e");

    }
    
    public void preencheQuestao() {

        this.selectItem_a.setQuestao(this.selectQuestao);
        
        this.selectItem_b.setQuestao(this.selectQuestao);
       
        this.selectItem_c.setQuestao(this.selectQuestao);
        
        this.selectItem_d.setQuestao(this.selectQuestao);
        
        this.selectItem_e.setQuestao(this.selectQuestao);
        

    }
    
    public void preencheItemImagem() {

        this.selectItem_a.setNomeImagem(this.newFileName_A);
        this.selectItem_b.setNomeImagem(this.newFileName_B);
        this.selectItem_c.setNomeImagem(this.newFileName_C);
        this.selectItem_d.setNomeImagem(this.newFileName_D);
        this.selectItem_e.setNomeImagem(this.newFileName_E);

    }
    
    
    

    public void addItem() {
        preencheQuestao();
        preencheItemImagem();
        itemDAO.addItem(selectItem_a);
        itemDAO.addItem(selectItem_b);
        itemDAO.addItem(selectItem_c);
        itemDAO.addItem(selectItem_d);
        itemDAO.addItem(selectItem_e);
        System.out.println("Itens Inseridos");

    }

  

        UploadedFile file;

        public void handleFileUpload_A(FileUploadEvent event) {
            file = event.getFile();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.newFileName_A = servletContext.getRealPath("") + File.separator + "uploaded" + File.separator + file.getFileName();
            System.out.println("Caminho"+ newFileName_A);
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                FileOutputStream fos = new FileOutputStream(new File(newFileName_A));
                InputStream is = file.getInputstream();
                int BUFFER_SIZE = 8192;
                byte[] buffer = new byte[BUFFER_SIZE];
                int a;
                while (true) {
                    a = is.read(buffer);
                    if (a < 0) {
                        break;
                    }
                    fos.write(buffer, 0, a);
                    fos.flush();
                }
                fos.close();
                is.close();
            } catch (IOException e) {
            }
        }
        
        public void handleFileUpload_B(FileUploadEvent event) {
            file = event.getFile();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.newFileName_B = servletContext.getRealPath("") + File.separator + "uploaded" + File.separator + file.getFileName();
            System.out.println("Caminho"+ newFileName_B);
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                FileOutputStream fos = new FileOutputStream(new File(newFileName_B));
                InputStream is = file.getInputstream();
                int BUFFER_SIZE = 8192;
                byte[] buffer = new byte[BUFFER_SIZE];
                int a;
                while (true) {
                    a = is.read(buffer);
                    if (a < 0) {
                        break;
                    }
                    fos.write(buffer, 0, a);
                    fos.flush();
                }
                fos.close();
                is.close();
            } catch (IOException e) {
            }
        }
        
        public void handleFileUpload_C(FileUploadEvent event) {
            file = event.getFile();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.newFileName_C = servletContext.getRealPath("") + File.separator + "uploaded" + File.separator + file.getFileName();
            System.out.println("Caminho"+ newFileName_C);
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                FileOutputStream fos = new FileOutputStream(new File(newFileName_C));
                InputStream is = file.getInputstream();
                int BUFFER_SIZE = 8192;
                byte[] buffer = new byte[BUFFER_SIZE];
                int a;
                while (true) {
                    a = is.read(buffer);
                    if (a < 0) {
                        break;
                    }
                    fos.write(buffer, 0, a);
                    fos.flush();
                }
                fos.close();
                is.close();
            } catch (IOException e) {
            }
        }
        
        public void handleFileUpload_D(FileUploadEvent event) {
            file = event.getFile();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.newFileName_D = servletContext.getRealPath("") + File.separator + "uploaded" + File.separator + file.getFileName();
            System.out.println("Caminho"+ newFileName_D);
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                FileOutputStream fos = new FileOutputStream(new File(newFileName_D));
                InputStream is = file.getInputstream();
                int BUFFER_SIZE = 8192;
                byte[] buffer = new byte[BUFFER_SIZE];
                int a;
                while (true) {
                    a = is.read(buffer);
                    if (a < 0) {
                        break;
                    }
                    fos.write(buffer, 0, a);
                    fos.flush();
                }
                fos.close();
                is.close();
            } catch (IOException e) {
            }
        }
        
        public void handleFileUpload_E(FileUploadEvent event) {
            file = event.getFile();
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            this.newFileName_E = servletContext.getRealPath("") + File.separator + "uploaded" + File.separator + file.getFileName();
            System.out.println("Caminho"+ newFileName_E);
            FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            try {
                FileOutputStream fos = new FileOutputStream(new File(newFileName_E));
                InputStream is = file.getInputstream();
                int BUFFER_SIZE = 8192;
                byte[] buffer = new byte[BUFFER_SIZE];
                int a;
                while (true) {
                    a = is.read(buffer);
                    if (a < 0) {
                        break;
                    }
                    fos.write(buffer, 0, a);
                    fos.flush();
                }
                fos.close();
                is.close();
            } catch (IOException e) {
            }
        }
    

}
