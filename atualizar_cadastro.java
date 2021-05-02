package com.example.condominio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class atualizar_cadastro extends AppCompatActivity {

    private EditText edit_cpf_pai;
    private EditText edit_tel_pai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_cadastro);

        edit_cpf_pai = (EditText) findViewById(R.id.edit_cpf_pai);


        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(edit_cpf_pai, smf);
        edit_cpf_pai.addTextChangedListener(mtw);




    }
}