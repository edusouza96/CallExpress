/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Setor;
import java.util.List;
/**
 *
 * @author Edu
 */
public interface SetorDao {
    public void remover(Setor u);
    public void salvar(Setor u);
    public Setor buscarPorId(int idSetor);
    public List<Setor> listar();      
    
}
