/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Ocorrencia;
import java.util.List;

/**
 *
 * @author Edu
 */
public interface OcorrenciaDao {
    public void salvar(Ocorrencia o);
    public void remover (Ocorrencia o);
    public Ocorrencia buscarPorId(int idOcorrencia);
    public List<Ocorrencia> listar();
}
