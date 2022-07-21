package br.com.gsn.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.gsn.restaurante.Cardapio.MainActivity;
import br.com.gsn.restaurante.Carrinho.MainCarrinho;
import br.com.gsn.restaurante.Cartao.MainCartao;
import br.com.gsn.restaurante.Endereco.MainEndereco;

public class MainPerfil extends AppCompatActivity {

    private TextView restaurante;
    private Button editEndereco;
    private Button editCartao;
    private ImageButton botaoCarrinho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_perfil);


        //função botão home

        restaurante=findViewById(R.id.restauranteHome);

        restaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent home = new Intent(MainPerfil.this, MainActivity.class);
                startActivity(home);

                //função botão home
            }

        });

        editEndereco=findViewById(R.id.btEditEndereco);
        editEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ender = new Intent(MainPerfil.this, MainEndereco.class);
                startActivity(ender);
            }
        });

        botaoCarrinho=findViewById(R.id.botaoCarrinho);
        botaoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent carrinho = new Intent(MainPerfil.this, MainCarrinho.class);
                startActivity(carrinho);
            }
        });

        editCartao=findViewById(R.id.btEditCartao);
        editCartao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cartao = new Intent(MainPerfil.this, MainCartao.class);
                startActivity(cartao);
            }
        });



        getSupportActionBar().hide();

    }
}