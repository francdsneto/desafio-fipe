package estudos.alura.springboot.desafiofipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Ano(@JsonAlias("codigo") String ano, @JsonAlias("nome") String descricao) {
}
