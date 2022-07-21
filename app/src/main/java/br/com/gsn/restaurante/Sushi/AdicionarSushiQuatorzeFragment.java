package br.com.gsn.restaurante.Sushi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.gsn.restaurante.Database.DatabaseHelper;
import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Cardapio.SushiFragment;
import br.com.gsn.restaurante.Carrinho.Carrinho;


public class AdicionarSushiQuatorzeFragment extends Fragment {

    private TextView nome;
    private TextView preco;

    public AdicionarSushiQuatorzeFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.carrinho_fragment_adicionar_sushi_quatorze, container, false);

        nome = v.findViewById(R.id.nome);
        preco = v.findViewById(R.id.preco);

        Button btnAdicionar = v.findViewById(R.id.btAdicionar);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adicionar();
            }
        });

        Button btnCancelar = v.findViewById(R.id.btCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new SushiFragment()).commit();
            }
        });





        return v;
    }
    private void adicionar(){
        DatabaseHelper databaseHelper = new DatabaseHelper(getActivity());
        Carrinho r = new Carrinho();
        r.setNome(nome.getText().toString());
        r.setPreco(preco.getText().toString());
        databaseHelper.createCarrinho(r);
        Toast.makeText(getActivity(), "Adicionado", Toast.LENGTH_LONG).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new SushiFragment()).commit();
    }


}