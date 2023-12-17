package estudos.alura.springboot.desafiofipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dado(@JsonAlias("codigo") String codigo, @JsonAlias("nome") String nome) {
}
