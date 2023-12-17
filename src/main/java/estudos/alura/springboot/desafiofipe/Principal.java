package estudos.alura.springboot.desafiofipe;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import estudos.alura.springboot.desafiofipe.model.DadosModelos;
import estudos.alura.springboot.desafiofipe.model.Dado;
import estudos.alura.springboot.desafiofipe.model.Veiculo;
import estudos.alura.springboot.desafiofipe.service.ApiHandler;
import estudos.alura.springboot.desafiofipe.service.JsonConverter;
import estudos.alura.springboot.desafiofipe.util.FipeApiUrlBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner scanner;
    private ApiHandler apiHandler;
    private JsonConverter jsonConverter;
    private FipeApiUrlBuilder fipeApiUrlBuilder;

    public Principal() {
        this.scanner = new Scanner(System.in);
        this.apiHandler = new ApiHandler();
        this.jsonConverter = new JsonConverter();
        this.fipeApiUrlBuilder = new FipeApiUrlBuilder();
        this.fipeApiUrlBuilder.reset();
    }

    public void exibeMenu() {

        var tipoVeiculo = "";
        var codigoMarca = "";
        var codigoModelo = "";
        var anoApiUrlRequest = "";
        var json = "";

        System.out.println("""
        ***** OPÇÕES DE VEÍCULOS PARA BUSCA *****
        
        - CARROS
        - MOTOS
        - CAMINHOES [SEM ACENTO]
        
        Informe o tipo de veículo que deseja pesquisar:
        """);

        tipoVeiculo = scanner.nextLine();
        this.fipeApiUrlBuilder.tipoVeiculo(tipoVeiculo.toLowerCase());
        json = this.apiHandler.sendRequest(this.fipeApiUrlBuilder.visualizarMarcas());

        List<Dado> marcas = null;

        try {
            marcas = this.jsonConverter.convertToListObject(json, Dado.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");
        System.out.println("Lista de marcas e seus códigos de referência:");

        marcas.stream().forEach(m -> System.out.println("Código ["+m.codigo()+"] - "+m.nome()));

        System.out.println("");
        System.out.println("Digite o código da marca escolhida: ");

        codigoMarca = scanner.nextLine();
        this.fipeApiUrlBuilder.marca(codigoMarca);
        json = this.apiHandler.sendRequest(this.fipeApiUrlBuilder.visualizarModelos());

        DadosModelos dadosModelos = null;

        try {
            dadosModelos = this.jsonConverter.convertToSingleObject(json, DadosModelos.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");
        System.out.println("Lista de modelos:");

        dadosModelos.modelos().stream().forEach(modelo -> System.out.println("Código: "+modelo.codigo()+" - "+modelo.nome()));

        System.out.println("");
        System.out.println("Digite um trecho do nome do modelo que procura: ");

        var trechoNomeModelo = scanner.nextLine();

        dadosModelos.modelos().stream()
                .filter(modelo -> modelo.nome().toLowerCase().contains(trechoNomeModelo.toLowerCase()))
                .forEach(modelo -> System.out.println("Código: "+modelo.codigo()+" - "+modelo.nome()));


        System.out.println("");
        System.out.println("Digite o código do modelo escolhido: ");

        codigoModelo = scanner.nextLine();
        this.fipeApiUrlBuilder.modelo(codigoModelo);
        anoApiUrlRequest = this.fipeApiUrlBuilder.visualizarAnos();
        json = this.apiHandler.sendRequest(anoApiUrlRequest);

        List<Dado> anos = null;

        try {
            anos = this.jsonConverter.convertToListObject(json, Dado.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<Veiculo> veiculos = new ArrayList<>();

        String finalAnoApiUrlRequest = anoApiUrlRequest;
        anos.stream().forEach(ano -> {
            var jsonResult = this.apiHandler.sendRequest(finalAnoApiUrlRequest.concat(ano.codigo()));
            try {
                Veiculo veiculo = this.jsonConverter.convertToSingleObject(jsonResult, Veiculo.class);
                veiculos.add(veiculo);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("");
        System.out.println("Todos os veículos com os valores por ano:");
        veiculos.stream().forEach(System.out::println);

    }
}
