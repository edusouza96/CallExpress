/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.OcorrenciaDaoJpa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Ocorrencia;

/**
 *
 * @author 631420057
 */
@ManagedBean
@SessionScoped
public class OcorrenciaBean {
    
    private Ocorrencia ocorrenciaSelecionada;
    
    public OcorrenciaBean() {
        ocorrenciaSelecionada = new Ocorrencia();
    }

    public Ocorrencia getOcorrenciaSelecionada() {
        return ocorrenciaSelecionada;
    }

    public void setOcorrenciaSelecionada(Ocorrencia ocorrenciaSelecionada) {
        this.ocorrenciaSelecionada = ocorrenciaSelecionada;
    }

    public List<Ocorrencia> getListaOcorrencia() {
        return new OcorrenciaDaoJpa().listar();
    }
 
    public String novaOcorrencia(){
        ocorrenciaSelecionada = new Ocorrencia();
        return("/AccessAdm/ViewEvent?faces-redirect=true");
    }

    public String adicionarOcorrencia() {
        new OcorrenciaDaoJpa().salvar(ocorrenciaSelecionada);
        return(this.novaOcorrencia());
    }

    public String editarOcorrencia(Ocorrencia o){
        ocorrenciaSelecionada = o;
        return("/AccessAdm/EditEvent?faces-redirect=true");
    }
    public String atualizarOcorrencia(){
        new OcorrenciaDaoJpa().salvar(ocorrenciaSelecionada);
        return("/AccessAdm/ViewEvent?faces-redirect=true");
    }

    public void removerOcorrencia(Ocorrencia ocorrencia){
        new OcorrenciaDaoJpa().remover(ocorrencia);
    }
}
