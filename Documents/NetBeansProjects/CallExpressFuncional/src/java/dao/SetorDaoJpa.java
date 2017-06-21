/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Setor;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;
/**
 *
 * @author Edu
 */
public class SetorDaoJpa implements SetorDao{

    @Override
    public void remover(Setor s) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(s));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void salvar(Setor s) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if(s.getIdSetor() == 0){
            em.persist(s);
        }else{
            em.merge(s);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Setor buscarPorId(int idSetor) {
        EntityManager em = JpaUtil.getEntityManager();
        Setor setor = em.find(Setor.class, idSetor);
        em.close();
        return (setor);
    }

    @Override
    public List<Setor> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Setor> listaSetores = em.createQuery("SELECT s FROM Setor s").getResultList();       
        em.close();
        return (listaSetores);
    }
    
}
