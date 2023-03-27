import java.io.PrintWriter;
import java.util.List;

public class HtmlGenerator {
    private PrintWriter writer;
    private String head =
            """
             <head>
                   <meta charset="utf-8">
                   <title>Top 250 filmes IMDB by Nicholas</title>
                   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
                   <style>
                   body{
                    background-color:gray;
                    display:flex;
                    flex-wrap: wrap;
                   }
                   .card-body{
                   background-color:black;
                   color:white;
                   border-radius:none;
                   }
                   .card{
                   border-radius:none;
                   }
                   
                   </style>
             
             
             </head>      
             """;
    public HtmlGenerator(PrintWriter x){
        this.writer = x;
    }

    public void generate(List<Movie> filmes){
        writer.write("<html>");
        writer.write(head);
        writer.write("<body>");
        filmes.forEach( (filme) -> {

            writer.write("           <div class=\"card\" style=\"width: 19rem; margin: 1rem\">\n" +
                    "               <img src="+filme.getImagem()+"\" class=\"card-img-top\" alt=\"...\">\n" +
                    "               <div class=\"card-body\">\n" +
                    "                    <h5 class=\"card-title text-center\">"+filme.getTitulo()+"</h5>\n" +
                    "                    <p class=\"card-text\" style=\"margin-bottom:2px\">"+"Rank: "+ filme.getRank()+"</p>\n" +
                    "                    <p class=\"card-text\" style=\"margin-bottom:2px\">"+"Ano: "+ filme.getAno()+"</p>\n" +
                    "                    <p class=\"card-text\" style=\"margin-bottom:2px\">"+"Nota: "+ filme.getImdbRating()+"</p>\n" +
                    "                </div>\n" +
                    "            </div>\n"+
                    "       </div>\n");

        });
        writer.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>");
        writer.write("\n");
        writer.write("</body>");
        writer.write("\n");
        writer.write("</html>");


    }

}
