package br.com.gsn.restaurante.Endereco;

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
    private EditText etRua;
    private EditText etBairro;
    private EditText etNumero;
    private EditText etAdicional;
    private DatabaseHelper databaseHelper;
    private Endereco e;



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
        View v = inflater.inflate(R.layout.endereco_fragment_editar, container, false);

        etNome = v.findViewById(R.id.nomeEndereco);
        etRua = v.findViewById(R.id.ruaEndereco);
        etBairro = v.findViewById(R.id.bairroEndereco);
        etNumero = v.findViewById(R.id.numeroEndereco);
        etAdicional = v.findViewById(R.id.adicionalEndereco);

        Bundle b = getArguments();
        int id_endereco = b.getInt("id");
        databaseHelper = new DatabaseHelper(getActivity());
        e = databaseHelper.getByIdEndereco(id_endereco);

        etNome.setText(e.getNome());
        etRua.setText(e.getRua());
        etBairro.setText(e.getBairro());
        etNumero.setText(e.getNumero());
        etAdicional.setText(e.getAdicional());

        Button btnEditar = v.findViewById(R.id.EditarEndereco);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar(id_endereco);

            }
        });
        Button btnExcluir = v.findViewById(R.id.excluirEndereco);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Deseja excluir o endereço?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir(id_endereco);
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
            Toast.makeText(getActivity(), "Por favor, informe o nome que deseja cadastrar para o endereço!", Toast.LENGTH_LONG).show();
        }else if (etRua.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe a rua do endereço!", Toast.LENGTH_LONG).show();
        }else if (etBairro.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o bairro do endereço!", Toast.LENGTH_LONG).show();
        }else if (etNumero.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o número do endereço!", Toast.LENGTH_LONG).show();
        } else {
            e = new Endereco();
            e.setId(id);
            e.setNome(etNome.getText().toString());
            e.setRua(etRua.getText().toString());
            e.setBairro(etBairro.getText().toString());
            e.setNumero(etNumero.getText().toString());
            e.setAdicional(etAdicional.getText().toString());
            databaseHelper.updateEndereco(e);
            Toast.makeText(getActivity(), "Endereço Atualizado", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.endereco_fragment, new ListarFragment()).commit();
        }
    }

    private void excluir (int id){
        e = new Endereco();
        e.setId(id);
        databaseHelper.deleteEndereco(e);
        Toast.makeText(getActivity(), "Endereço Excluido", Toast.LENGTH_LONG).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.endereco_fragment, new ListarFragment()).commit();
    }

}