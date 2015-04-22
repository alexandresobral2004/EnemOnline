/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.disciplinaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import model.Disciplina;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class disciplinaFaces implements Serializable{
    
    private Disciplina selectedDisci;
    private List<Disciplina> disciplinas;
    
    
    @Inject
    private disciplinaDAO  disciDAO;

    
    
    public Disciplina getSelectedDisci() {
        return selectedDisci;
    }

    public void setSelectedDisci(Disciplina selectedDisci) {
        this.selectedDisci = selectedDisci;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    
    
    public String startDisciplina(){
        this.selectedDisci = new Disciplina();
        return "/pages/disciplina";
    }

    
    public disciplinaFaces() {
       this.selectedDisci = new Disciplina();
    }
    
    
    
    
    public void addDisciplina(){
        disciDAO.adddisciplina(selectedDisci);
    }
    
    
    public List findAllDisciplinas(){
        this.disciplinas = new ArrayList();
        this.disciplinas = disciDAO.findAllDisciplinas();
        
        return disciplinas;
           
        
       
        
    }
    
}
