# Questões do desafio-capgemini
Resposta aos desafios de seleção da Capgemini
***
### Orientações e Tecnologias.

#### Tecnologias utilizadas:

* Linguagem de programação: **JAVA**
* Teste Unitário: **JUnit**
* Documentação: **javadoc**

#### Orientações para rodar a aplicação e organização:

* O projeto está organizado em 3 pacotes, 1 para cada questão;

* Dentro de cada pacote existe 2 classes, conforme segue:
* (1) Os algoritmos com os **métodos** para as soluções do desafio proposto estão nas seguintes classes:
  * PrimeiraQuestao, SegundaQuestao, TerceiraQuestao

* (2) O método **MAIN** e o **Teste Unitário** estão nas seguintes Classes:
  * PrimeiraQuestaoTest, SegundaQuestaoTest, TerceiraQuestaoTest;
  * **A aplicação deve ser rodada nestas Classes;**

* Para rodar a aplicação proceder executando como **Java Application** e **JUnite Test** separadamente;

* Para alterar os valores de teste já presentes nos códigos, proceder executando primeiramente como **Java Application** e copiar o resultado para inserir nas variáveis de *resultadoEsperado* no teste do **JUnit**.

#### Explicando as classes:

* A classe **PrimeiraQuestao** possui 1 método, *imprimeEscada()*, e é esse método que será executado no MAIN da classe **PrimeiraQuestaoTest**;

* A classe **SegundaQuestao** possui 2 métodos. O método *verificaRequisito()* é usado dentro do método *verificaTamanho()* e este é o método principal que vai ser executado no MAIN da classe **SegundaQuestaoTest**.

* A classe **TerceiraQuestao** possui 3 métodos. Os métodos *procuraAnagrama()* e *retiraEspaco()* são usados dentro do método *contaAnagrama()*, e este é o método principal que vai ser executado no MAIN da classe **TerceiraQuestaoTest**.

***
