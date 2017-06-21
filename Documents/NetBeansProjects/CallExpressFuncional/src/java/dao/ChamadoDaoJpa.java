/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Chamado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JpaUtil;

/**
 *
 * @author Edu
 */
public class ChamadoDaoJpa implements ChamadoDao{

    @Override
    public void salvar(Chamado c) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if(c.getIdOcorrencia() == 0){
            em.persist(c);
        }else{
            em.merge(c);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(Chamado c) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(c));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Chamado buscarPorId(int idChamado) {
        EntityManager em = JpaUtil.getEntityManager();
        Chamado chamado = em.find(Chamado.class, idChamado);
        em.close();
        return (chamado);
    }

    @Override
    public List<Chamado> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Chamado c WHERE c.status <> :parametro ORDER BY c.idOcorrencia");
        query.setParameter("parametro", "Finalizado" );        
        List<Chamado> listaChamados = query.getResultList(); 
        em.close();
        return (listaChamados);
    }

    @Override
    public List<Chamado> listarU(String parametro) {
        EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Chamado c WHERE c.usuario = :parametro ORDER BY c.idOcorrencia");
        query.setParameter("parametro", parametro );        
        List<Chamado> listaChamados = query.getResultList(); 
        em.close();
        return (listaChamados);
    }

    @Override
    public List<Chamado> listarT() {
         EntityManager em = JpaUtil.getEntityManager();
        Query query = em.createQuery("SELECT c FROM Chamado c ");
        List<Chamado> listaChamados = query.getResultList(); 
        em.close();
        return (listaChamados);
    }
    
}
