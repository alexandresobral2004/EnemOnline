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

/**
 *
 * @author cedsobral
 */
@Entity
public class Item implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String item;
    private Boolean tipo;
    @Column(nullable = true)
    private String textoitemQuestao;
    @Column(columnDefinition = "mediumblob",nullable = true)
    private byte[] imagem;
    private Boolean resposta;
    @ManyToOne()
    private Questao questao;
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public String getTextoitemQuestao() {
        return textoitemQuestao;
    }

    public void setTextoitemQuestao(String textoitemQuestao) {
        this.textoitemQuestao = textoitemQuestao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Boolean getResposta() {
        return resposta;
    }

    public void setResposta(Boolean resposta) {
        this.resposta = resposta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.id;
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
        final Item other = (Item) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
