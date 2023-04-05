import java.io.IOException;
import java.util.*;
import java.util.regex.*;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a chave da api:");
        String key = scanner.next();

        //cria o objeto que faz a requisição ao imdb
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

        //cria o objeto que irá adicionar os filmes no arraylist "filmes"
        Movie ObjetoParaAdicionarOsFilmes = new Movie();
        ObjetoParaAdicionarOsFilmes.addMovies(ID, RANK, TITLE, FULLTITLE, YEAR, IMAGE, CREW, IMDBRATING, IMDBRATINGCOUNT, filmes, response);

        System.out.println("Deseja ordenar por contagem ou por nota os filmes? Digite \"n\" para notas ou \"c\" para contagem");
        String resposta = scanner.next();
        if(resposta.equals("c")) {
            try {
                Collections.sort(filmes, Comparator.reverseOrder());
            } catch (NumberFormatException ex) {
                System.out.println("Deu erro ao tentar utilizar o sort");
                ex.printStackTrace();
            }
        }else if(resposta.equals("n")){

        }else{
            System.out.println("Essa opcao nao existe");
        }
        htmlGenerator.generate(filmes);
        printWriter.close();
        filmes.forEach( (movies) -> movies.getOutputAttributes() );


    }
}