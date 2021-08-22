import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Java11HttpClient {

    public APODModel makeClientApiCallSync(String urlAsString) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create(urlAsString))
                                         .header("accept", "application/json")
                                         .build();

        HttpResponse<Supplier<APODModel>> response = client.send(request, new JsonBodyHandler<>(APODModel.class));

        return response.body().get();
    }

    public APODModel makeClientApiCallASync(String urlAsString) throws InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create(urlAsString))
                                         .header("accept", "application/json")
                                         .build();

        CompletableFuture<HttpResponse<Supplier<APODModel>>> responseFuture = client.sendAsync(request,
                                                                                               new JsonBodyHandler<>(
                                                                                                       APODModel.class));


        HttpResponse<Supplier<APODModel>> response = responseFuture.get();

        return response.body().get();
    }
}
