package estudos.alura.springboot.desafiofipe.util;

public class FipeApiUrlBuilder {

    private final String URL_BASE_API = "https://parallelum.com.br/fipe/api/v1";
    private String requestUrl;

    public FipeApiUrlBuilder() {
        this.reset();
    }

    public void reset() {
        this.requestUrl = URL_BASE_API;
    }

    public void tipoVeiculo(String tipo) {
        this.requestUrl = this.requestUrl.concat("/").concat(tipo);
    }

    public String visualizarMarcas() {
        this.requestUrl = this.requestUrl.concat("/marcas/");
        return this.requestUrl;
    }

    public String marca(String codigo) {
        this.requestUrl = this.requestUrl.concat(codigo);
        return this.requestUrl;
    }

    public String visualizarModelos() {
        this.requestUrl = this.requestUrl.concat("/modelos/");
        return this.requestUrl;
    }

    public String modelo(String codigo) {
        this.requestUrl = this.requestUrl.concat(codigo);
        return this.requestUrl;
    }

    public String visualizarAnos() {
        this.requestUrl = this.requestUrl.concat("/anos/");
        return this.requestUrl;
    }

    public String ano(String ano) {
        this.requestUrl = this.requestUrl.concat(ano);
        return this.requestUrl;
    }

}
