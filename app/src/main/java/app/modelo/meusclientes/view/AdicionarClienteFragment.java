package app.modelo.meusclientes.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    //Declarações globais de atributos - variáveis globais
    View view;
    TextView txtTitulo;
    EditText editNome, editTelefone, editEmail, editCep, editLogradouro, editNumero, editBairro, editCidade, editEstado;
    CheckBox chkTermosDeUso;
    Button btnCancelar, btnSalvar;

    Cliente novoCliente;
    ClienteController clienteController;

    public AdicionarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        iniciarComponentesDeLayout();

        escutarEventosDosBotoes();

        return view;
    }

    /**
     * Inicializar os componentes da tela para adicionar os clientes
     */
    private void iniciarComponentesDeLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.adicionar_cliente);

        editNome = view.findViewById(R.id.editNomeCompleto);
        editTelefone = view.findViewById(R.id.editTelefone);
        editEmail = view.findViewById(R.id.editEmail);
        editCep = view.findViewById(R.id.editCep);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editNumero = view.findViewById(R.id.editNumero);
        editBairro = view.findViewById(R.id.editBairro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        chkTermosDeUso = view.findViewById(R.id.chkTermosDeUso);
        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar = view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();

        clienteController = new ClienteController(getContext());
    }

    private void escutarEventosDosBotoes() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Considera que o usuario completou todos os dados
                boolean isDadosOk = true;

                //Falso/Verdadeiro
                if (TextUtils.isEmpty(editNome.getText())) {
                    isDadosOk = false;
                    editNome.setError("Digite o nome completo");
                    editNome.requestFocus();
                }

                if (TextUtils.isEmpty(editTelefone.getText())) {
                    isDadosOk = false;
                    editTelefone.setError("Digite o telefone");
                    editTelefone.requestFocus();
                }

                if (TextUtils.isEmpty(editEmail.getText())) {
                    isDadosOk = false;
                    editEmail.setError("Digite o email");
                    editEmail.requestFocus();
                }

                if (TextUtils.isEmpty(editCep.getText())) {
                    isDadosOk = false;
                    editCep.setError("Digite o cep");
                    editCep.requestFocus();
                }

                if (TextUtils.isEmpty(editLogradouro.getText())) {
                    isDadosOk = false;
                    editLogradouro.setError("Digite o logradouro");
                    editLogradouro.requestFocus();
                }

                if (TextUtils.isEmpty(editNumero.getText())) {
                    isDadosOk = false;
                    editNumero.setError("Digite o numero");
                    editNumero.requestFocus();
                }

                if (TextUtils.isEmpty(editBairro.getText())) {
                    isDadosOk = false;
                    editBairro.setError("Digite o bairro");
                    editBairro.requestFocus();
                }

                if (TextUtils.isEmpty(editCidade.getText())) {
                    isDadosOk = false;
                    editCidade.setError("Digite a cidade");
                    editCidade.requestFocus();
                }

                if (TextUtils.isEmpty(editEstado.getText())) {
                    isDadosOk = false;
                    editEstado.setError("Digite o estado");
                    editEstado.requestFocus();
                }

                if (isDadosOk) {

                    //Popular os dados no objeto cliente
                    novoCliente.setNome(editNome.getText().toString());
                    novoCliente.setTelefone(editTelefone.getText().toString());
                    novoCliente.setEmail(editEmail.getText().toString());
                    //Cast
                    novoCliente.setCep(Integer.parseInt(editCep.getText().toString()));

                    novoCliente.setLogradouro(editLogradouro.getText().toString());
                    novoCliente.setNumero(editNumero.getText().toString());
                    novoCliente.setBairro(editBairro.getText().toString());
                    novoCliente.setCidade(editCidade.getText().toString());
                    novoCliente.setEstado(editEstado.getText().toString());

                    novoCliente.setTermosDeUso(chkTermosDeUso.isChecked());

                    clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente", "dados corretos");
                } else {
                    //Notifica o usuário
                    Log.e("log_add_cliente", "dados incorretos");
                }
            }
        });
    }


}
