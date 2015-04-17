/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Disciplina;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class disciplinaFaces implements Serializable{
    
    private Disciplina selectedDisci;

    public Disciplina getSelectedDisci() {
        return selectedDisci;
    }

    public void setSelectedDisci(Disciplina selectedDisci) {
        this.selectedDisci = selectedDisci;
    }
    
    
    public String startDisciplina(){
        this.selectedDisci = new Disciplina();
        return "/pages/disciplina";
    }
    
    
    
}
