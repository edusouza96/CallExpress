/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Usuario;
import java.util.List;
/**
 *
 * @author Edu
 */
public interface UsuarioDao {
    public void remover(Usuario u);
    public void salvar(Usuario u);
    public Usuario buscarPorId(int idUsuario);
    public List<Usuario> listar();      
    
}
