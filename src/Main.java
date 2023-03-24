import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //cria o objeto que faz a requisição ao imdb
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a chave da api:");
        String key = scanner.next();
        ImdbRequest requisicao = new ImdbRequest(key,"https://imdb-api.com/en/API/Top250Movies/");
        String response = requisicao.RetornaCorpoJson(requisicao.getKey(),requisicao.getUrl());


        //nome do arquivo
        String nomeArquivoHtml = "saidaEmHTML.html";
        FileWriter fileWriter = new FileWriter(nomeArquivoHtml);
        //cria o print writer
        PrintWriter printWriter = new PrintWriter(fileWriter);
        HtmlGenerator htmlGenerator = new HtmlGenerator(printWriter);





        //cria o objeto responsável por receber o padrão regex e retornar o matcher
        MovieAttributesRegex atributosRegex = new MovieAttributesRegex(response);

        //cria os matchers
        Matcher ID = atributosRegex.getMetcher("\"id\":\"tt([0-9])+\",");
        Matcher RANK = atributosRegex.getMetcher("\"rank\":\"([0-9])+\",");
        Matcher TITLE = atributosRegex.getMetcher("\"title\":\"([a-zA-Z0-9\\s\\W])+\",\"fullTitle\"");
        Matcher FULLTITLE = atributosRegex.getMetcher("\"fullTitle\":\"([a-zA-Z0-9\\s\\W])+\",\"year\"");
        Matcher YEAR = atributosRegex.getMetcher("\"year\":\"([0-9])+\"");
        Matcher IMAGE = atributosRegex.getMetcher("https://[^\"]+\\.jpg");
        Matcher CREW = atributosRegex.getMetcher("crew\":\"[^\"]+\"");
        Matcher IMDBRATING = atributosRegex.getMetcher("imDbRating\":\"[^\"]+\"");
        Matcher IMDBRATINGCOUNT = atributosRegex.getMetcher("imDbRatingCount\":\"[^\"]+\"");

        //cria o array de filmes
        List<Movie> filmes = new ArrayList<Movie>();

            while (ID.find() && RANK.find() && TITLE.find() && FULLTITLE.find() && YEAR.find() && IMAGE.find() && CREW.find() && IMDBRATING.find() && IMDBRATINGCOUNT.find()) {
                 String id = response.substring(ID.start() + 6, ID.end() - 2);
                 String rank = response.substring(RANK.start() + 8, RANK.end() - 2);
                 String titulo = response.substring(TITLE.start() + 9, TITLE.end() - 13);
                 String tituloCompleto = response.substring(FULLTITLE.start() + 13, FULLTITLE.end() - 8);
                 String ano = response.substring(YEAR.start() + 8, YEAR.end() - 1);
                 String imagem = response.substring(IMAGE.start(), IMAGE.end());
                 String crew = response.substring(CREW.start() +7 , CREW.end()-1);
                 String imdbRating = response.substring(IMDBRATING.start() +13 , IMDBRATING.end() -1 );
                 String imdbRatingCount = response.substring(IMDBRATINGCOUNT.start() +18 , IMDBRATINGCOUNT.end() -1 );
                 Movie movie = new Movie(id, rank, titulo, tituloCompleto, ano, imagem, crew, imdbRating, imdbRatingCount);
                 filmes.add(movie);
            }

            htmlGenerator.generate(filmes);
            printWriter.close();
            filmes.forEach( (movies) -> movies.getOutputAttributes() );


    }
}