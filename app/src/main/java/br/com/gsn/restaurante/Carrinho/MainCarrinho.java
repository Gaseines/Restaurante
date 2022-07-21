package br.com.gsn.restaurante.Carrinho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.gsn.restaurante.MainPerfil;
import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Cardapio.MainActivity;

public class MainCarrinho extends AppCompatActivity {

    private ImageView voltar;
    private TextView restaurante;
    private ImageButton botaoPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_carrinho);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameCarrinho, new MainFragment()).commit();
        }


        restaurante=findViewById(R.id.restauranteHome);
        restaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainCarrinho.this, MainActivity.class);
                startActivity(home);
            }
        });
        botaoPerfil=findViewById(R.id.botaoPerfil);

        botaoPerfil.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent perfil=new Intent(MainCarrinho.this, MainPerfil.class);
                startActivity(perfil);

            }
        });
        getSupportActionBar().hide();
    }
}