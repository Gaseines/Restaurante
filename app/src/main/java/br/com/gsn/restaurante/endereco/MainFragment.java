package br.com.gsn.restaurante.endereco;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        if (savedInstanceState == null){
           getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.endereco_fragment, new ListarFragment()).commit();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.endereco_fragment_main, container, false);
    }
}