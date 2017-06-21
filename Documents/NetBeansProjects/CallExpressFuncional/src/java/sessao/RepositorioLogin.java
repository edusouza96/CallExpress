/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import model.Usuario;

@Stateless
public class RepositorioLogin {
private List<Usuario> listaUsuario;
    public RepositorioLogin(){
        listaUsuario = new ArrayList<>();
    }

    public void adicionar(Usuario u){
        listaUsuario.add(u);
    }
    
    public List<Usuario> getUsuarios(){
        return (listaUsuario);
    }
}
