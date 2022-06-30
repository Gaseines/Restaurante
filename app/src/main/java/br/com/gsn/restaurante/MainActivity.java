package br.com.gsn.restaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton botaoPerfil;
    private ImageButton botaoCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoPerfil=findViewById(R.id.botaoPerfil);

        botaoPerfil.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent perfil=new Intent(MainActivity.this,MainPerfil.class);
                startActivity(perfil);

            }
        });


        getSupportActionBar().hide();


    }
}