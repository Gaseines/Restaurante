package br.com.gsn.restaurante.Cardapio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Sushi.AdicionarSushiDezesseisFragment;
import br.com.gsn.restaurante.Sushi.AdicionarSushiQuatorzeFragment;
import br.com.gsn.restaurante.Sushi.AdicionarSushiVintequatroFragment;
import br.com.gsn.restaurante.Sushi.AdicionarSushiVinteumFragment;


public class SushiFragment extends Fragment {



    public SushiFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment_sushi, container, false);


        FrameLayout adicionar1 = v.findViewById(R.id.quatorze);
        adicionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameSushi, new AdicionarSushiQuatorzeFragment()).commit();
            }
        });

        FrameLayout adicionar2 = v.findViewById(R.id.dezesseis);
        adicionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameSushi, new AdicionarSushiDezesseisFragment()).commit();
            }
        });

        FrameLayout adicionar3 = v.findViewById(R.id.vinteUm);
        adicionar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameSushi, new AdicionarSushiVinteumFragment()).commit();
            }
        });

        FrameLayout adicionar4 = v.findViewById(R.id.vinteQuatro);
        adicionar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameSushi, new AdicionarSushiVintequatroFragment()).commit();
            }
        });






        return v;
    }
}