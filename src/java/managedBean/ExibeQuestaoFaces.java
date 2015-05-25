/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import dao.ItemDAO;
import dao.QuestaoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.Item;
import model.Questao;

/**
 *
 * @author cedsobral
 */
@ManagedBean
@SessionScoped
public class ExibeQuestaoFaces implements Serializable {

    @Inject
    QuestaoDAO quesDAO;
    @Inject
    ItemDAO itemDAO;

    private Questao selectedQuestao;
    private Item selectItem_a;
    private Item selectItem_b;
    private Item selectItem_c;
    private Item selectItem_d;
    private Item selectItem_e;
    private List<Item> itens;
    private List<Questao> questoes;
    private Boolean mostraquestao;

    public Questao getSelectedQuestao() {
        return selectedQuestao;
    }

    public void setSelectedQuestao(Questao selectedQuestao) {
        this.selectedQuestao = selectedQuestao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
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

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public Boolean getMostraquestao() {
        return mostraquestao;
    }

    public void setMostraquestao(Boolean mostraquestao) {
        this.mostraquestao = mostraquestao;
    }

    public String startQuestao() {

        selectedQuestao = new Questao();
        this.selectItem_a = new Item();
        this.selectItem_b = new Item();
        this.selectItem_c = new Item();
        this.selectItem_d = new Item();
        this.selectItem_e = new Item();
        this.itens = null;
        this.mostraquestao = false;

        System.out.println("Inicia Questao");
        return "/aluno/questoes.jsf";

    }

    public List<Questao> pegaQuestaoBanco() {
        this.questoes = new ArrayList<Questao>();
        System.out.println("ID da disciplina " + String.valueOf(selectedQuestao.getDisciplina().getID()));
        questoes = quesDAO.getQuestaoPorDiscip(selectedQuestao.getDisciplina().getID());
        return questoes;

    }

    public void carregaQuestao() {
        List<Questao> lista = pegaQuestaoBanco();
        this.selectedQuestao = lista.get(0);

        preencheItens(selectedQuestao);
        this.mostraquestao = true;
    }

    public void preencheItens(Questao q) {
        this.itens = new ArrayList<>();

        this.itens = itemDAO.getItemsQuestao(q.getId());
        this.selectItem_a = this.itens.get(0);
        this.selectItem_b = this.itens.get(1);
        this.selectItem_c = this.itens.get(2);
        this.selectItem_d = this.itens.get(3);
        this.selectItem_e = this.itens.get(4);

    }

    public void mostraQuestao() {
        this.mostraquestao = true;

    }
    
    
    private Item getItemCorreto(){
        for (int i = 0; i < itens.size(); i++) {
            if (this.itens.get(i).getResposta()) {

               return this.itens.get(i);
                

            }

        } 
        return null;
        
    }

    public FacesMessage validaItemQuestao() {
        Boolean acertou = false;
       
        for (int i = 0; i < itens.size(); i++) {
            if (this.itens.get(i).getItemMarcado() && this.itens.get(i).getResposta()) {

                acertou = true;
                

            }

        }

        if (acertou) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Resposta Correta", null);
            FacesContext.getCurrentInstance().addMessage("message", message);
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resposta Incorreta, o ítem correto é o: "+this.getItemCorreto().getItem(), null);
            FacesContext.getCurrentInstance().addMessage("message", message);

        }

        return null;

    }

}
