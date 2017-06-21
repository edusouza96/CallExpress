/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.SetorDaoJpa;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import model.Setor;
import sessao.RepositorioSetor;

/**
 * REST Web Service
 *
 * @author 631420057
 */
@Path("setorWS")
public class SetorResource {
    @EJB
    private RepositorioSetor repositorioS;
    @Context
    private UriInfo context;

    public SetorResource() {
    }

   
    @GET
    @Produces("application/json")
    public List<Setor> getSetor () {
        return new SetorDaoJpa().listar();
    }

    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String adicionarSetor(Setor setor) {
        repositorioS.adicionar(setor);
        new SetorDaoJpa().salvar(setor);//testar essa linha
        return "OK";
    }
}
