package bean;

import model.Usuario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginMB {

    private String login, senha;
    private Usuario usuarioLogado;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public boolean estaLogado() {
        return (usuarioLogado != null);
    }

    public boolean eAdmin() {
        return (this.estaLogado() && this.getUsuarioLogado().isAdministrador());
    }

    public String verificaLogin() {
        FacesContext contexto = FacesContext.getCurrentInstance();
        UsuarioMB usuarioMB = new UsuarioMB();
        List<Usuario> listaUsuarios = usuarioMB.getListaUsuarios();
        for (Usuario usuario : listaUsuarios) {
           
            if (usuario.verificaLogin(login, senha)) {
                usuarioLogado = usuario;
                if (usuario.isAdministrador()) {
                    return ("/AccessAdm/timeline?faces-redirect=true");
                } else {
                    return ("/AccessUser/index?faces-redirect=true");
                }
            }
        }
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Login invalido!", "Usuario ou senha estão errados!");
        contexto.addMessage("idMensagem", mensagem);
        return ("/Login1");
    }

    public String realizaLogout() {
        usuarioLogado = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return ("/Login1?faces-redirect=true");
    }

}
