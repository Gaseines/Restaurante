package br.com.gsn.restaurante.endereco;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.gsn.restaurante.R;


public class AdicionarFragment extends Fragment {


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

        Button btnSalvar = v.findViewById(R.id.salvarEndereco);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.endereco_fragment, new ListarFragment()).commit();
            }
        });



        // Inflate the layout for this fragment
        return v;
    }
}