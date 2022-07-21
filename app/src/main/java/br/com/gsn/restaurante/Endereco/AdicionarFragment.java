package br.com.gsn.restaurante.Endereco;

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


public class AdicionarFragment extends Fragment {

    private EditText etNome;
    private EditText etRua;
    private EditText etBairro;
    private EditText etNumero;
    private EditText etAdicional;


    public AdicionarFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.endereco_fragment_adicionar, container, false);

        etNome = v.findViewById(R.id.nomeEndereco);
        etRua = v.findViewById(R.id.ruaEndereco);
        etBairro = v.findViewById(R.id.bairroEndereco);
        etNumero = v.findViewById(R.id.numeroEndereco);
        etAdicional = v.findViewById(R.id.adicionalEndereco);


        Button btnSalvar = v.findViewById(R.id.salvarEndereco);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionar();

            }
        });



        // Inflate the layout for this fragment
        return v;
    }

    private void adicionar(){
        if (etNome.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o nome que deseja cadastrar para o endereço!", Toast.LENGTH_LONG).show();
        }else if (etRua.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe a rua do endereço!", Toast.LENGTH_LONG).show();
        }else if (etBairro.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o bairro do endereço!", Toast.LENGTH_LONG).show();
        }else if (etNumero.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o número do endereço!", Toast.LENGTH_LONG).show();
        } else {
            DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
            Endereco e = new Endereco();
            e.setNome(etNome.getText().toString());
            e.setRua(etRua.getText().toString());
            e.setBairro(etBairro.getText().toString());
            e.setNumero(etNumero.getText().toString());
            e.setAdicional(etAdicional.getText().toString());
            databaseHelper.createEndereco(e);
            Toast.makeText(getActivity(), "Endereço Salvo", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.endereco_fragment, new ListarFragment()).commit();
        }
    }

}