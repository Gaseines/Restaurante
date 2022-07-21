package br.com.gsn.restaurante.Carrinho;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.com.gsn.restaurante.Database.DatabaseHelper;
import br.com.gsn.restaurante.R;


public class MainFragment extends Fragment {


    private Button ex;
    private DatabaseHelper databaseHelper;
    private Carrinho r;

    public MainFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.carrinho_fragment_main, container, false);

        if (savedInstanceState == null){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.carrinho_fragment, new ListarFragment()).commit();
        }



        return v;
    }


}