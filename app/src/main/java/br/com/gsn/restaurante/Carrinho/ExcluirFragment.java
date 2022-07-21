package br.com.gsn.restaurante.Carrinho;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


public class ExcluirFragment extends Fragment {


    private Carrinho r;
    private DatabaseHelper databaseHelper;
    private TextView tvNome;
    private TextView tvPreco;

    public ExcluirFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.carrinho_fragment_excluir, container, false);

        tvNome =v.findViewById(R.id.nomeCarrinho);
        tvPreco =v.findViewById(R.id.precoCarrinho);

        Bundle b = getArguments();
        int id_carrinho = b.getInt("id");
        databaseHelper = new DatabaseHelper(getActivity());
        r = databaseHelper.getByIdCarrinho(id_carrinho);

        tvPreco.setText(r.getPreco());
        tvNome.setText(r.getNome());

        Button btnVoltar = v.findViewById(R.id.btVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.carrinho_fragment, new ListarFragment()).commit();
            }
        });

        Button btnExcluir = v.findViewById(R.id.btExcluir);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Deseja excluir o item?");
                builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir(id_carrinho);
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
    private void excluir (int id){
        r = new Carrinho();
        r.setId(id);
        databaseHelper.deleteCarrinho(r);
        Toast.makeText(getActivity(), "Item Excluido", Toast.LENGTH_SHORT).show();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.carrinho_fragment, new ListarFragment()).commit();
    }
}