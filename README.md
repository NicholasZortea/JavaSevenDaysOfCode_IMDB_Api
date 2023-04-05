# JavaSevenDaysOfCode_IMDB_Api
![Imagem com 10 pôsters de filmes](https://user-images.githubusercontent.com/78584142/227519861-38c41970-e591-4f88-8f62-16a6aed69943.png)
![status-Concluido-green](https://user-images.githubusercontent.com/78584142/230166544-ddbb0065-df1b-41ef-87ab-be359c6258a7.svg)

<h1 allign="center"> Descrição </h1>
Este projeto foi feito com base no desafio do #7DaysOfCode em Java, no qual o objetivo inicial é o de gerar uma página html com os top 250 filmes fornecidos pela API do IMDB

<h1 allign="center"> Classes e tecnologias utilizadas </h1>
Para realizar a requisição a API do IMDB foram utilizadas as classes <strong>URI , HttpClient, HttpRequest, HttpResponse</strong>;<br>
Para parsear o arquivo json retornado dessa requisição, fiz uso de <strong> regex, patterns e matchers</strong>;<br>
Para gerar o html foram utilizadas as classes <strong>PrintWriter, FileWriter</strong>;<br>
Para a estilização do html fiz uso de <strong>BootStrap</strong> onde utilizei os cards para criar os filmes;<br>

<h1 allign="center"> Futuras implementações </h1>
Ainda preciso implementar a opção de ordenar os filmes por um critério diferente do rank fornecido pelo imdb, como ordenar por mais votações; - [x] Concluído
<br>
Preciso melhorar a estilização dos cards, visto que eles estão com o layout em grid, mas estão um pouco bugados e também preciso deixar a página como um todo mais bonita; - [x] Concluído
<br>
