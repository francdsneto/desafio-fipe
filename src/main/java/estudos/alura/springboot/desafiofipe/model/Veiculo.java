package estudos.alura.springboot.desafiofipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(@JsonAlias("Valor") String valor,
                      @JsonAlias("Marca") String marca,
                      @JsonAlias("Modelo") String modelo,
                      @JsonAlias("AnoModelo") Integer ano,
                      @JsonAlias("Combustivel") String combustivel,
                      @JsonAlias("CodigoFipe") String codigoFipe,
                      @JsonAlias("MesReferencia") String mesReferencia,
                      @JsonAlias("SiglaCombustivel") char siglaCombustivel
) {
}
