package br.com.gsn.restaurante.Cartao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.gsn.restaurante.R;


public class MainFragment extends Fragment {

    public MainFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cartao_fragment_main, container, false);

        if (savedInstanceState == null){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new ListarFragment()).commit();
        }

        Button btnAdicionar = v.findViewById(R.id.adicionarCartao);
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new AdicionarFragment()).commit();
            }
        });

        Button btnListar = v.findViewById(R.id.listarCartao);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.cartao_fragment, new ListarFragment()).commit();
            }
        });



        // Inflate the layout for this fragment
        return v;
    }
}