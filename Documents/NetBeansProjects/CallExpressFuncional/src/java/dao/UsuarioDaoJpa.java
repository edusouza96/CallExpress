/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;

/**
 *
 * @author Edu
 */
public class UsuarioDaoJpa implements UsuarioDao{

    @Override
    public void salvar(Usuario u) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if(u.getIdUsuario() == null){
            em.persist(u);
        }else{
            em.merge(u);
        }
        em.getTransaction().commit();
        em.close();
            
    }
    
    @Override
    public void remover(Usuario u) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(u));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Usuario buscarPorId(int idUsuario) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario = em.find(Usuario.class, idUsuario);
        em.close();
        return (usuario);
    }

    @Override
    public List<Usuario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaUsuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
        em.close();
        return (listaUsuarios);
    }
    
    
}
