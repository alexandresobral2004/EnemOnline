/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author cedsobral
 */
@Entity
@Table(name = "questao")
public class Questao implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texto;
    private long numQuestao;
    @Column(nullable = true)
    private byte[] imagem;
    @ManyToOne()
    private Disciplina disciplina;
    @ManyToOne()
    private Prova prova;

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }
    

    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public long getNumQuestao() {
        return numQuestao;
    }

    public void setNumQuestao(long numQuestao) {
        
        
        this.numQuestao = numQuestao;
    }

    
    
    
    
    //Busca numero de questoes no banco
    private int findNumQuestoes(){
        int qtde = 0;
        return qtde;
    }
    //incrementa a quantidade de questões
    private void IncNumQuestao(){
       int qtde = findNumQuestoes();
       
        if(qtde == 0){
            this.numQuestao = 1;
        }
        else{
            
            this.numQuestao= qtde + 1;
        }
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Questao other = (Questao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
   
}
