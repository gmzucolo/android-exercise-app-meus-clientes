package app.modelo.meusclientes.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import app.modelo.meusclientes.api.AppUtil;
import app.modelo.meusclientes.datamodel.ClienteDataModel;
import app.modelo.meusclientes.datasource.AppDataBase;
import app.modelo.meusclientes.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {

        super(context);
        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        //Chave, Valor

        //dadoDoObjeto.put(ClienteDataModel.ID.obj.getId());
        //ID é a chave primária da tabela, logo é gerada
        //automaticamente pelo SQLite a cada novo registro
        //INCLUIR:
        //SQL -> INSERT INTO TABLE (...) VALUES (###)
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.NUMERO, obj.getNumero());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS, obj.isTermosDeUso());

        //enviar os dados (dadoDoObjeto) para classe AppDataBase
        //utilizando  um método capaz de INCLUIR o Obj no banco
        //de dados.
        return insert(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public boolean alterar(Cliente obj) {

        dadoDoObjeto = new ContentValues();
        //Chave, Valor

        //dadoDoObjeto.put(ClienteDataModel.ID.obj.getId());
        //ID é a chave primária da tabela, logo é gerada
        //automaticamente pelo SQLite a cada novo registro
        //ALTERAR:
        //SQL -> UPDATE
        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        //enviar os dados (dadoDoObjeto) para classe AppDataBase
        //utilizando  um método capaz de ALTERAR o Obj no banco
        //de dados.
        return update(ClienteDataModel.TABELA, dadoDoObjeto);

    }

    @Override
    public boolean deletar(int id) {

        return deleteByID(ClienteDataModel.TABELA, id);
    }

    @Override
    public List<Cliente> listar() {

        return getAllClientes(ClienteDataModel.TABELA);
    }

    public List<String> gerarListaDeClientesListView() {

        List<String> clientes = new ArrayList<>();

        for (Cliente obj : listar()) {

            clientes.add(obj.getId() + ". " + obj.getNome() + ", " + obj.getTelefone());
        }

        return clientes;
    }
}
