import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Movie implements Comparable<Movie> {

    private String id;
    private String rank;
    private String titulo;
    private String tituloCompleto;
    private String ano;
    private String imagem;

    private String crew;
    private String imdbRating;
    private String imdbRatingCount;


    Movie(){

    }
    Movie(String id, String rank, String titulo, String tituloCompleto, String ano, String imagem, String crew, String imdbRating, String imdbRatingCount){
        this.id = id;
        this.rank = rank;
        this.titulo = titulo;
        this.tituloCompleto = tituloCompleto;
        this.ano = ano;
        this.imagem = imagem;
        this.crew = crew;
        this.imdbRating = imdbRating;
        this.imdbRatingCount = imdbRatingCount;
    }


    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloCompleto() {
        return tituloCompleto;
    }

    public void setTituloCompleto(String tituloCompleto) {
        this.tituloCompleto = tituloCompleto;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCrew() {
        return crew;
    }

    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbRatingCount() {
        return imdbRatingCount;
    }

    public void setImdbRatingCount(String imdbRatingCount) {
        this.imdbRatingCount = imdbRatingCount;
    }

    public void getOutputAttributes(){
        System.out.println("ID: " + this.getId());
        System.out.println("Rank: " + this.getRank());
        System.out.println("Titulo: " + this.getTitulo());
        System.out.println("Titulo Completo: " + this.getTituloCompleto());
        System.out.println("Ano: " + this.getAno());
        System.out.println("Imagem: " + this.getImagem());
        System.out.println("Crew: " + this.getCrew());
        System.out.println("ImdbRating: " + this.getImdbRating());
        System.out.println("ImdbRatingCount: " + this.getImdbRatingCount());
    }

    public void addMovies(Matcher ID, Matcher RANK, Matcher TITLE, Matcher FULLTITLE, Matcher YEAR, Matcher IMAGE, Matcher CREW, Matcher IMDBRATING, Matcher IMDBRATINGCOUNT, List<Movie> filmes, String response){
        while (ID.find() && RANK.find() && TITLE.find() && FULLTITLE.find() && YEAR.find() && IMAGE.find() && CREW.find() && IMDBRATING.find() && IMDBRATINGCOUNT.find()) {
            String id = response.substring(ID.start() + 6, ID.end() - 2);
            String rank = response.substring(RANK.start() + 8, RANK.end() - 2);
            String titulo = response.substring(TITLE.start() + 9, TITLE.end() - 13);
            String tituloCompleto = response.substring(FULLTITLE.start() + 13, FULLTITLE.end() - 8);
            String ano = response.substring(YEAR.start() + 8, YEAR.end() - 1);
            String imagem = response.substring(IMAGE.start(), IMAGE.end());
            String crew = response.substring(CREW.start() +7 , CREW.end()-1);
            String imdbRating = response.substring(IMDBRATING.start() +13 , IMDBRATING.end() -1 );
            String imdbRatingCount = response.substring(IMDBRATINGCOUNT.start() +18 , IMDBRATINGCOUNT.end() -1);
            Movie movie = new Movie(id, rank, titulo, tituloCompleto, ano, imagem, crew, imdbRating, imdbRatingCount);
            filmes.add(movie);
        }

    }



    @Override
    public int compareTo(Movie movie) {
        return Integer.parseInt(this.getImdbRatingCount()) - Integer.parseInt(movie.getImdbRatingCount());
    }
}
