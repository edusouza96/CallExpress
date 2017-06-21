
package bean;

import dao.ChamadoDaoJpa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Chamado;
import bean.LoginMB;

@ManagedBean
@SessionScoped
public class ChamadoBean {
    
    private Chamado chamadoSelecionado;
    
    public ChamadoBean() {
        chamadoSelecionado = new Chamado();
        
    }

    public Chamado getChamadoSelecionado() {
        return chamadoSelecionado;
    }

    public void setChamadoSelecionado(Chamado chamadoSelecionado) {
        this.chamadoSelecionado = chamadoSelecionado;
    }

    public List<Chamado> getListaChamado() {
        return new ChamadoDaoJpa().listar();
    }
    public List<Chamado> ListaChamadoU(String login) {
        return new ChamadoDaoJpa().listarU(login);
    }

    public String novoChamado(){
        chamadoSelecionado = new Chamado();
        return("/AccessUser/index?faces-redirect=true");
    }

    public String adicionarChamado()
    {
        new ChamadoDaoJpa().salvar(chamadoSelecionado);
        return(this.novoChamado());
    }

    public String editarChamado(Chamado c){
        chamadoSelecionado = c;
        return("/AccessAdm/EditCall?faces-redirect=true");
    }
    public String atualizarChamado()
    {
        new ChamadoDaoJpa().salvar(chamadoSelecionado);
        chamadoSelecionado = new Chamado();
        return("/AccessAdm/timeline?faces-redirect=true");
    }
    
    public String atenderChamado(Chamado c, String tecnico){
        chamadoSelecionado = c;
        if (chamadoSelecionado.getStatus().equals("Finalizado")){
            
        }else{
            if(chamadoSelecionado.getStatus().equals("Aberto")){
                chamadoSelecionado.setTecnico(tecnico);
                chamadoSelecionado.setStatus("Em atendimento");
                new ChamadoDaoJpa().salvar(chamadoSelecionado);            }
           
        }
        chamadoSelecionado = new Chamado();
        return("/AccessAdm/timeline?faces-redirect=true");
    }
    
    public String encerrarChamado(Chamado c){
        chamadoSelecionado = c;
        chamadoSelecionado.setStatus("Finalizado");
        new ChamadoDaoJpa().salvar(chamadoSelecionado);
        chamadoSelecionado = new Chamado();
        return("/AccessAdm/timeline?faces-redirect=true");
    }
    
    public void removeChamado(Chamado chamado){
        new  ChamadoDaoJpa().remover(chamado);
    }
    
}
