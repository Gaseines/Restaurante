package br.com.gsn.restaurante.Cardapio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.gsn.restaurante.MainPerfil;
import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Carrinho.MainCarrinho;

public class MainActivity extends AppCompatActivity {

    private ImageButton botaoPerfil;
    private ImageButton botaoCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new HomeFragment()).commit();
        }

        TextView btnLanches = findViewById(R.id.lanches);
        btnLanches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new LanchesFragment()).commit();
            }
        });

        TextView btnPasteis = findViewById(R.id.pasteis);
        btnPasteis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new PasteisFragment()).commit();
            }
        });

        TextView btnSushi = findViewById(R.id.sushi);
        btnSushi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new SushiFragment()).commit();
            }
        });

        TextView btnBebidas = findViewById(R.id.bebidas);
        btnBebidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new BebidasFragment()).commit();
            }
        });

        TextView btnRestaurante = findViewById(R.id.restaurante);
        btnRestaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameHorarios, new HomeFragment()).commit();
            }
        });




        botaoPerfil=findViewById(R.id.botaoPerfil);

        botaoPerfil.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent perfil=new Intent(MainActivity.this, MainPerfil.class);
                startActivity(perfil);

            }
        });

        botaoCarrinho=findViewById(R.id.botaoCarrinho);
        botaoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carrinho = new Intent(MainActivity.this, MainCarrinho.class);
                startActivity(carrinho);
            }
        });


        getSupportActionBar().hide();


    }
}