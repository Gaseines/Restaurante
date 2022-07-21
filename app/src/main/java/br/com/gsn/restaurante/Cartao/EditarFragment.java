package br.com.gsn.restaurante.Cartao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.gsn.restaurante.Database.DatabaseHelper;
import br.com.gsn.restaurante.R;

public class EditarFragment extends Fragment {

    private EditText etNome;
    private EditText etNumero;
    private EditText etData;
    private EditText etTitular;
    private EditText etCod;
    private DatabaseHelper databaseHelper;
    private Cartao c;



    public EditarFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.cartao_fragment_editar, container, false);

        etNome = v.findViewById(R.id.nomeCartao);
        etNumero = v.findViewById(R.id.numeroCartao);
        etData = v.findViewById(R.id.dataCartao);
        etTitular = v.findViewById(R.id.titularCartao);
        etCod = v.findViewById(R.id.codCartao);

        Bundle b = getArguments();
        int id_cartao = b.getInt("id");
        databaseHelper = new DatabaseHelper(getActivity());
        c = databaseHelper.getByIdCartao(id_cartao);

        etNome.setText(c.getNome());
        etNumero.setText(c.getNumero());
        etData.setText(c.getData());
        etTitular.setText(c.getTitular());
        etCod.setText(c.getCod());

        Button btnEditar = v.findViewById(R.id.editarCartao);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar(id_cartao);

            }
        });
        Button btnExcluir = v.findViewById(R.id.excluirCartao);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Deseja excluir o cartão?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir(id_cartao);
                    }
                });
                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Não faz nada//
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return v;
    }

    private void editar(int id){
        if (etNome.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe a bandeira do cartão!", Toast.LENGTH_LONG).show();
        }else if (etNumero.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o número do cartão!", Toast.LENGTH_LONG).show();
        }else if (etData.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe a data de vencimento do cartão!", Toast.LENGTH_LONG).show();
        }else if (etTitular.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o títular do cartão!", Toast.LENGTH_LONG).show();
        }else if (etCod.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o código de segurança do cartão!", Toast.LENGTH_LONG).show();
        } else {
            databaseHelper = new DatabaseHelper(getActivity());
            c = new Cartao();
            c.setId(id);
            c.setNome(etNome.getText().toString());
            c.setNumero(etNumero.getText().toString());
            c.setData(etData.getText().toString());
            c.setTitular(etTitular.getText().toString());
            c.setCod(etCod.getText().toString());
            databaseHelper.updateCartao(c);
            Toast.makeText(getActivity(), "Cartão Atualizado", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new ListarFragment()).commit();
        }
    }

    private void excluir (int id){
        c = new Cartao();
        c.setId(id);
        databaseHelper.deleteCartao(c);
        Toast.makeText(getActivity(), "Cartão Excluido", Toast.LENGTH_LONG).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new ListarFragment()).commit();
    }

}