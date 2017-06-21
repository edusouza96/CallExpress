
package sessao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import model.Setor;

@Stateless
public class RepositorioSetor {
    private List<Setor> listaSetor;
    public RepositorioSetor(){
        listaSetor = new ArrayList<>();
        //listaSetor.add(new Setor("TI", 3, 301));
    }

    public void adicionar(Setor s){
        listaSetor.add(s);
    }
    
    public List<Setor> getSetors(){
        return (listaSetor);
    }
}
