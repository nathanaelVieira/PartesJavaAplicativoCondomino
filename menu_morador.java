package com.example.condominio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class menu_morador extends AppCompatActivity {

    private Button bt_atualizar;
    private Button bt_visitante;
    private Button bt_sair;

    Button atualizar ;
    Button visitante ;
    Button sair ;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_menu_morador);

            atualizar = (Button) findViewById(R.id.bt_atualizar);
            visitante = (Button) findViewById(R.id.bt_visitante);
            sair = (Button) findViewById(R.id.bt_sair);

            atualizar.setOnClickListener(new View.OnClickListener(){


                @Override
                public void onClick(View v) {
                    Intent it = new Intent(menu_morador.this, atualizar_cadastro.class);
                    startActivity(it);

                }
            });
            visitante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it = new Intent(menu_morador.this, autorizacao_visitante.class);
                    startActivity(it);
                }
            });
            sair.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent it = new Intent(menu_morador.this, MainActivity.class);
                    startActivity(it);
                }
            });


        }

}