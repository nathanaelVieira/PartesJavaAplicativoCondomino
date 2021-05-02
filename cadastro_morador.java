package com.example.condominio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class cadastro_morador extends AppCompatActivity {

  private Button registar_cadastro;
  private EditText edit_cpf_cadastro;
  private EditText editApartamento, editTorre, editNomeCompleto, editSenha, editConfirmaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_morador);

        edit_cpf_cadastro = (EditText) findViewById(R.id.edit_cpf_cadastro);
        editApartamento = (EditText) findViewById(R.id.apartamento_morador);
        editTorre = (EditText) findViewById(R.id.torre_morador);
        editNomeCompleto = (EditText) findViewById(R.id.nome_morador);
        editSenha = (EditText) findViewById(R.id.edit_senha_nova);
        editConfirmaSenha = (EditText) findViewById(R.id.edit_confirmar_senha);
        registar_cadastro = (Button) findViewById(R.id.bt_salvar_senha_nova);



        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(edit_cpf_cadastro, smf);
        edit_cpf_cadastro.addTextChangedListener(mtw);

        registar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cpfCad = edit_cpf_cadastro.getText().toString();
                String nomeCad = editNomeCompleto.getText().toString();
                String apartamentoCad = editApartamento.getText().toString();
                String torreCad = editTorre.getText().toString();
                String senhaCad = editSenha.getText().toString();
                String confirmaSenhaCad = editConfirmaSenha.getText().toString();

                BancoController bd = new BancoController(getBaseContext());
                String resultado;

                if(senhaCad.equals(confirmaSenhaCad)){
                    resultado =bd.insereDadosUsuario(cpfCad, nomeCad, apartamentoCad, torreCad, senhaCad);
                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    limparSenhas();
                } else {
                    String msg = "SENHAS NÃO SÃO IDÊNTICAS, TENTE NOVAMENTE.";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }


            }
        });

    }

    public void limparSenhas() {
        editSenha.setText("");
        editConfirmaSenha.setText("");
        editSenha.requestFocus();
        return;
    }


}