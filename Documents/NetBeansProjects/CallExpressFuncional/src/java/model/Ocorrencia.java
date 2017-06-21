
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
        
@Entity
public class Ocorrencia implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOcorrencia;
    private String ocorrencia;
    private String tipoOCorrencia;
    private String tempoEstimado;

    public Ocorrencia(String ocorrencia, String tipoOCorrencia, String tempoEstimado) {
        this.ocorrencia = ocorrencia;
        this.tipoOCorrencia = tipoOCorrencia;
        this.tempoEstimado = tempoEstimado;
    }

    public Ocorrencia() {
    }

    public int getIdOcorrencia() {
        return idOcorrencia;
    }

    public void setIdOcorrencia(int idOcorrencia) {
        this.idOcorrencia = idOcorrencia;
    }

    
    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getTipoOCorrencia() {
        return tipoOCorrencia;
    }

    public void setTipoOCorrencia(String tipoOCorrencia) {
        this.tipoOCorrencia = tipoOCorrencia;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
    
    
    
}
