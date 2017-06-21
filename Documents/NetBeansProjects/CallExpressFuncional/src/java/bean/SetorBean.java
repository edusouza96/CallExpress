/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.SetorDaoJpa;
import model.Setor;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author eduardo
 */
@ManagedBean
@SessionScoped 
public class SetorBean {
    
    private Setor setorSelecionado;
    
    public SetorBean() {
        setorSelecionado = new Setor();
    }

   
    public Setor getSetorSelecionado() {
        return setorSelecionado;
    }

    public void setSetorSelecionado(Setor setorSelecionado) {
        this.setorSelecionado = setorSelecionado;
    }
    
    public List<Setor> getListaSetores() {
        return new SetorDaoJpa().listar();
    }
    
    public String novoSetor(){
        setorSelecionado =new Setor();
        return("/AccessAdm/ViewSector?faces-redirect=true");
    }

    public String adicionarSetor()
    {
        new SetorDaoJpa().salvar(setorSelecionado);
        return(this.novoSetor());
    }

    public String editarSetor(Setor s){
        setorSelecionado = s;
        return("/AccessAdm/EditSector?faces-redirect=true");
    }
    public String atualizarSetor()
    {
        new SetorDaoJpa().salvar(setorSelecionado);
        return("/AccessAdm/ViewSector?faces-redirect=true");
    }

    public void removerSetor(Setor setor){
        new SetorDaoJpa().remover(setor);
    }
    
}
