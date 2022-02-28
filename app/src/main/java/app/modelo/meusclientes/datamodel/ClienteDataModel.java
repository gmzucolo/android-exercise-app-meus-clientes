package app.modelo.meusclientes.datamodel;

public class ClienteDataModel {

    //Modelo Objeto Relacional

    //1. atributo nome da tabela
    public static final String TABELA = "cliente";

    //2. atributos um para um com os nomes dos campos
    public static final String ID = "id"; //tipo de dado em sql -> integer
    public static final String NOME = "nome"; //tipo de dado em sql -> text
    public static final String TELEFONE = "telefone"; //tipo de dado em sql -> text
    public static final String EMAIL = "email"; //tipo de dado em sql -> text
    public static final String CEP = "cep"; //tipo de dado em sql -> integer
    public static final String LOGRADOURO = "logradouro"; //tipo de dado em sql -> text
    public static final String NUMERO = "número"; //tipo de dado em sql -> text
    public static final String BAIRRO = "bairro"; //tipo de dado em sql -> text
    public static final String CIDADE = "cidade"; //tipo de dado em sql -> text
    public static final String ESTADO = "estado"; //tipo de dado em sql -> text
    public static final String TERMOS = "termos"; //tipo de dado em sql -> integer

    //3. query para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    //4. método para criar o script para criar a tabela
    public static String criarTabela() {

        //concatenação de string
        queryCriarTabela += "CREATE TABLE "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, "; // nome text
        queryCriarTabela += TELEFONE+" text, "; // nome text
        queryCriarTabela += EMAIL+" text, "; // nome text
        queryCriarTabela += CEP+" integer, "; // nome text
        queryCriarTabela += LOGRADOURO+" text, "; // nome text
        queryCriarTabela += NUMERO+" text, "; // nome text
        queryCriarTabela += BAIRRO+" text, "; // nome text
        queryCriarTabela += CIDADE+" text, "; // nome text
        queryCriarTabela += ESTADO+" text, "; // nome text
        queryCriarTabela += TERMOS +" integer ";
        queryCriarTabela += ")";

        //query Criar tabela = "Parte 01 Parte 02 Parte 03 Parte 04"

        return queryCriarTabela;
    }
}
