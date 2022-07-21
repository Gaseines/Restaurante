package br.com.gsn.restaurante.Cardapio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import br.com.gsn.restaurante.Lanches.AdicionarAlcatraFragment;
import br.com.gsn.restaurante.Lanches.AdicionarBaconFragment;
import br.com.gsn.restaurante.Lanches.AdicionarDuploFragment;
import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Lanches.AdicionarTradicionalFragment;


public class LanchesFragment extends Fragment {




    public LanchesFragment() {


    }





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.home_fragment_lanches, container, false);


        FrameLayout adicionarTr = v.findViewById(R.id.tradicional);
        adicionarTr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLanches, new AdicionarTradicionalFragment()).commit();
            }
        });

        FrameLayout adicionarTrDuplo = v.findViewById(R.id.Tduplo);
        adicionarTrDuplo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLanches, new AdicionarDuploFragment()).commit();
            }
        });

        FrameLayout adicionarBacon = v.findViewById(R.id.bacon);
        adicionarBacon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLanches, new AdicionarBaconFragment()).commit();
            }
        });

        FrameLayout adicionarAlcatra = v.findViewById(R.id.Alcatra);
        adicionarAlcatra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLanches, new AdicionarAlcatraFragment()).commit();
            }
        });


        return v;
    }


}