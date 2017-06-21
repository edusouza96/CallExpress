package bean;

import dao.UsuarioDaoJpa;
import model.Usuario;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped 
public class UsuarioMB {
    
    private Usuario usuarioSelecionado;

    public UsuarioMB() {
        usuarioSelecionado = new Usuario();
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getListaUsuarios() {
        return new UsuarioDaoJpa().listar();
    }    

    public String novoUsuario(){
        usuarioSelecionado=new Usuario();
        return("/AccessAdm/ViewUser?faces-redirect=true");
    }

    public String adicionarUsuario() {
        new UsuarioDaoJpa().salvar(usuarioSelecionado);
        return(this.novoUsuario());
    }

    public String editarUsuario(Usuario u){
        usuarioSelecionado = u;
        return("/AccessAdm/EditUser?faces-redirect=true");
    }
    public String atualizarUsuario() {
        new UsuarioDaoJpa().salvar(usuarioSelecionado);
        return("/AccessAdm/ViewUser?faces-redirect=true");
    }

    public void removerUsuario(Usuario usuario){
        new UsuarioDaoJpa().remover(usuario);
    }

}
