package sessao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import model.Chamado;

@Stateless
public class RepositorioChamado {
    private List<Chamado> listaChamado;
    public RepositorioChamado(){
        listaChamado = new ArrayList<>();
        //listaSetor.add(new Setor("TI", 3, 301));
    }

    public void adicionar(Chamado c){
        listaChamado.add(c);
    }
    
    public List<Chamado> getChamado(){
        return (listaChamado);
    }
}
