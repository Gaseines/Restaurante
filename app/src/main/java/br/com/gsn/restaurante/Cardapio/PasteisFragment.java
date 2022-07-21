package br.com.gsn.restaurante.Cardapio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import br.com.gsn.restaurante.Pasteis.AdicionarCarneFragment;
import br.com.gsn.restaurante.Pasteis.AdicionarLegumesFragment;
import br.com.gsn.restaurante.Pasteis.AdicionarNordesteFragment;
import br.com.gsn.restaurante.Pasteis.AdicionarPortuguesaFragment;
import br.com.gsn.restaurante.R;


public class PasteisFragment extends Fragment {



    public PasteisFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment_pasteis, container, false);

        FrameLayout adicionarCarne = v.findViewById(R.id.carne);
        adicionarCarne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framePasteis, new AdicionarCarneFragment()).commit();
            }
        });

        FrameLayout adicionarPortuguesa = v.findViewById(R.id.portuguesa);
        adicionarPortuguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framePasteis, new AdicionarPortuguesaFragment()).commit();
            }
        });

        FrameLayout adicionarNordeste = v.findViewById(R.id.nordeste);
        adicionarNordeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framePasteis, new AdicionarNordesteFragment()).commit();
            }
        });

        FrameLayout adicionarLegumes = v.findViewById(R.id.legumes);
        adicionarLegumes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.framePasteis, new AdicionarLegumesFragment()).commit();
            }
        });






        return v;
    }
}