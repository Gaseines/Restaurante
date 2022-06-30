package br.com.gsn.restaurante;

import   androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.gsn.restaurante.endereco.MainFragment;

public class MainEndereco extends AppCompatActivity {

    private ImageView voltar;

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

        getSupportActionBar().hide();
    }
}