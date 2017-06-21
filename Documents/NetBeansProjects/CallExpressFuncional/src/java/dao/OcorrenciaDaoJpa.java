/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Chamado;
import java.util.List;
import javax.persistence.EntityManager;
import model.Ocorrencia;
import util.JpaUtil;
/**
 *
 * @author Edu
 */
public class OcorrenciaDaoJpa implements OcorrenciaDao{

    @Override
    public void salvar(Ocorrencia o) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if(o.getIdOcorrencia() == 0){
            em.persist(o);
        }else{
            em.merge(o);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(Ocorrencia o) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(o));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Ocorrencia buscarPorId(int idOcorrencia) {
        EntityManager em = JpaUtil.getEntityManager();
        Ocorrencia ocorrencia = em.find(Ocorrencia.class, idOcorrencia);
        em.close();
        return (ocorrencia);
    }

    @Override
    public List<Ocorrencia> listar() {
        EntityManager  em =JpaUtil.getEntityManager();
        List<Ocorrencia> listaOcorrencias = em.createQuery("SELECT o FROM Ocorrencia o").getResultList();
        em.close();
        return (listaOcorrencias);
    }
    
}
