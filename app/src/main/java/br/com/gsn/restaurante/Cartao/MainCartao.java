package br.com.gsn.restaurante.Cartao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.gsn.restaurante.Cardapio.MainActivity;
import br.com.gsn.restaurante.MainPerfil;
import br.com.gsn.restaurante.R;
import br.com.gsn.restaurante.Carrinho.MainCarrinho;

public class MainCartao extends AppCompatActivity {

    private ImageView voltar;
    private TextView restaurante;
    private ImageButton botaoCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cartao);



        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_cartao, new MainFragment()).commit();
        }

        voltar = findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(MainCartao.this, MainPerfil.class);
                startActivity(voltar);
            }
        });

        restaurante=findViewById(R.id.restauranteHome);
        restaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainCartao.this, MainActivity.class);
                startActivity(home);
            }
        });

        botaoCarrinho=findViewById(R.id.botaoCarrinho);
        botaoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carrinho = new Intent(MainCartao.this, MainCarrinho.class);
                startActivity(carrinho);
            }
        });

        getSupportActionBar().hide();

    }
}