/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Chamado;
import java.util.List;
/**
 *
 * @author Edu
 */
public interface ChamadoDao {
    public void salvar(Chamado c);
    public void remover(Chamado c);
    public Chamado buscarPorId(int idChamado);
    public List<Chamado> listar();
    public List<Chamado> listarT();
    public List<Chamado> listarU(String parametro);
}
