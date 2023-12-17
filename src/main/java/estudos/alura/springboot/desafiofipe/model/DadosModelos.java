package estudos.alura.springboot.desafiofipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosModelos {

    @JsonAlias("modelos")
    private List<Modelo> modelos;

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }

    public record Modelo(@JsonAlias("codigo") String codigo, @JsonAlias("nome") String nome) {}

}
