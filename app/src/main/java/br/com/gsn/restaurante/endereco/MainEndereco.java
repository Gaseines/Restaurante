package br.com.gsn.restaurante.endereco;

import   androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.gsn.restaurante.MainActivity;
import br.com.gsn.restaurante.MainPerfil;
import br.com.gsn.restaurante.R;

public class MainEndereco extends AppCompatActivity {

    private ImageView voltar;
    private TextView restaurante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_endereco);


        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_main, new MainFragment()).commit();
        }

        voltar=findViewById(R.id.voltar);
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent voltar = new Intent(MainEndereco.this, MainPerfil.class);
                startActivity(voltar);
            }
        });

        restaurante=findViewById(R.id.restauranteHome);
        restaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainEndereco.this, MainActivity.class);
                startActivity(home);
            }
        });

        getSupportActionBar().hide();
    }
}