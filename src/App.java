import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    private static Object InputStream;


    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes

        // var key = "k_fjtlk5gc";
        // String url = "https://imdb-api.com/en/API/Top250Movies/" + key;

        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        URI endereco = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        // extrair só os dados que interessam (titulo, poster, classificação)

        JsonParser parser = new JsonParser();

        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
       
        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Map<String, String> filme = listaDeFilmes.get(i);

            String urlImagem = // filme.get("image")
                filme.get("url")
                .replaceAll("(@+)(.*).jpg$", "$1.jpg");

            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = "saida/" + titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);
 

            System.out.println(filme.get(titulo));
            System.out.println();

        }
    }
}