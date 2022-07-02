package br.com.gsn.restaurante.cartao;

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
import br.com.gsn.restaurante.endereco.Endereco;


public class AdicionarFragment extends Fragment {

    private EditText etNome;
    private EditText etNumero;
    private EditText etData;
    private EditText etTitular;
    private EditText etCod;


    public AdicionarFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cartao_fragment_adicionar, container, false);

        etNome = v.findViewById(R.id.nomeCartao);
        etNumero = v.findViewById(R.id.numeroCartao);
        etData = v.findViewById(R.id.dataCartao);
        etTitular = v.findViewById(R.id.titularCartao);
        etCod = v.findViewById(R.id.codCartao);


        Button btnSalvar = v.findViewById(R.id.salvarCartao);
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
            Toast.makeText(getActivity(), "Por favor, informe a bandeira do cartão!", Toast.LENGTH_LONG).show();
        }else if (etNumero.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o número do cartão!", Toast.LENGTH_LONG).show();
        }else if (etData.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe a data de vencimento do cartão!", Toast.LENGTH_LONG).show();
        }else if (etTitular.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o títular do cartão!", Toast.LENGTH_LONG).show();
        } else if (etCod.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Por favor, informe o código de segurança do cartão!", Toast.LENGTH_LONG).show();
        } else {
            DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
            Cartao c = new Cartao();
            c.setNome(etNome.getText().toString());
            c.setNumero(etNumero.getText().toString());
            c.setData(etData.getText().toString());
            c.setTitular(etTitular.getText().toString());
            c.setCod(etCod.getText().toString());
            databaseHelper.createCartao(c);
            Toast.makeText(getActivity(), "Cartão Salvo", Toast.LENGTH_LONG).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new ListarFragment()).commit();
        }
    }

}