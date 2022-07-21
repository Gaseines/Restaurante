package br.com.gsn.restaurante.Cardapio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import br.com.gsn.restaurante.Bebidas.AdicionarAguaFragment;
import br.com.gsn.restaurante.Bebidas.AdicionarCocaFragment;
import br.com.gsn.restaurante.Bebidas.AdicionarSucoFragment;
import br.com.gsn.restaurante.Pasteis.AdicionarLegumesFragment;
import br.com.gsn.restaurante.R;


public class BebidasFragment extends Fragment {



    public BebidasFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment_bebidas, container, false);


        FrameLayout AdicionarCoca = v.findViewById(R.id.coca);
        AdicionarCoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameBebidas, new AdicionarCocaFragment()).commit();
            }
        });

        FrameLayout AdicionarAgua = v.findViewById(R.id.agua);
        AdicionarAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameBebidas, new AdicionarAguaFragment()).commit();
            }
        });

        FrameLayout AdicionarSuco = v.findViewById(R.id.suco);
        AdicionarSuco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameBebidas, new AdicionarSucoFragment()).commit();
            }
        });




        return v;
    }
}