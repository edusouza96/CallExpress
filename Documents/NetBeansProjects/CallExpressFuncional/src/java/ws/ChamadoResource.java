/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import dao.ChamadoDaoJpa;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import model.Chamado;
import sessao.RepositorioChamado;


@Path("chamadoWS")
public class ChamadoResource {
    @EJB
    private RepositorioChamado repositorioC;
    @Context
    private UriInfo context;

    public ChamadoResource() {
    }

    @GET
    @Produces("application/json")
    public List<Chamado> getChamado () {
        return new ChamadoDaoJpa().listarT();
    }

    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public String adicionarSetor(Chamado chamado) {
        repositorioC.adicionar(chamado);
        new ChamadoDaoJpa().salvar(chamado);//testar essa linha
        return "OK";
    }
}
