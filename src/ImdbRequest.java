import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbRequest {
    private String key;
    private String url;

    public ImdbRequest(String key, String url){
        this.key = key;
        this.url = url;
    }

    public static String RetornaCorpoJson (String key, String url) throws IOException, InterruptedException {
        String URL = url;
        String KEY = key;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(url + key))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }

}
