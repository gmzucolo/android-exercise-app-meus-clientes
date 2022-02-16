package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    //Modelo Objeto Relacional

    //1. atributo nome da tabela
    public static final String TABELA = "cliente";

    //2. atriubutos um para um com os nomes dos campos
    public static final String ID = "id"; //tipo de dado em sql -> integer
    public static final String NOME = "nome"; //tipo de dado em sql -> text
    public static final String EMAIL = "email"; //tipo de dado em sql -> text

    //3. query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    //4. método para criar o script para criar a tabela
    public static String criarTabela() {

        //concatenação de string
        queryCriarTabela += "CREATE TABLE " + TABELA + " (";
        queryCriarTabela += ID + " integer primary key autoincrement, ";
        queryCriarTabela += NOME + " text, ";
        queryCriarTabela += EMAIL + " text ";
        queryCriarTabela += ")";

        //query Criar tabela = "Parte 01 Parte 02 Parte 03 Parte 04"

        return queryCriarTabela;
    }
}
