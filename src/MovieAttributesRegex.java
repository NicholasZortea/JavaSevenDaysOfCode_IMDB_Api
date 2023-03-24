import java.util.regex.*;


public class MovieAttributesRegex {
    private String textoAEncontrar;


    public MovieAttributesRegex(String texto){
        this.textoAEncontrar = texto;
    }

    public Matcher getMetcher(String padraoRegex){
        Pattern padrao = Pattern.compile(padraoRegex);
        Matcher matcher = padrao.matcher(this.textoAEncontrar);
        return matcher;
    }

    public String getTextoAEncontrar() {
        return textoAEncontrar;
    }




}
