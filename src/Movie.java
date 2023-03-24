public class Movie {

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
}
