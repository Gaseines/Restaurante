package br.com.gsn.restaurante.Carrinho;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import br.com.gsn.restaurante.Database.DatabaseHelper;
import br.com.gsn.restaurante.R;


public class ListarFragment extends Fragment {

    private DatabaseHelper databaseHelper;



    public ListarFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.carrinho_fragment_listar, container, false);


        databaseHelper = new DatabaseHelper(getActivity());
        ListView lv = v.findViewById(R.id.list_view_listar_carrinho);
        databaseHelper.getAllCarrinho(getActivity(), lv);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvId = view.findViewById(R.id.idCarrinho);
                Bundle b = new Bundle();
                b.putInt("id", Integer.parseInt(tvId.getText().toString()));

                ExcluirFragment excluir = new ExcluirFragment();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                excluir.setArguments(b);
                ft.replace(R.id.carrinho_fragment, excluir).commit();

            }
        });






        return v ;
    }
}