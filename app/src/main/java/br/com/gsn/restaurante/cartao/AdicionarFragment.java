package br.com.gsn.restaurante.cartao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.endereco.ListarFragment;


public class AdicionarFragment extends Fragment {


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

        Button btnSalvar = v.findViewById(R.id.salvarCartao);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new ListarFragment()).commit();
            }
        });



        // Inflate the layout for this fragment
        return v;
    }
}