package estudos.alura.springboot.desafiofipe.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiHandler {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public String sendRequest(String url) {

        client = HttpClient.newBuilder().build();

        request = HttpRequest.newBuilder()
                .uri(URI.create(url)).build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            client.close();
        }

    }
}
