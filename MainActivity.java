package com.example.condominio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edit_cpf_login, edit_senha_login;
    private Button entrar;

    Button cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_cpf_login = (EditText) findViewById(R.id.edit_cpf_login);
        cadastro = (Button) findViewById(R.id.bt_cadastro);
        entrar = (Button) findViewById(R.id.bt_entrar);
        edit_senha_login = (EditText) findViewById(R.id.edit_senha_login);

        SimpleMaskFormatter smf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtw = new MaskTextWatcher(edit_cpf_login, smf);
        edit_cpf_login.addTextChangedListener(mtw);

        entrar.setOnClickListener(this);
        cadastro.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_cadastro) {
            Intent it = new Intent(MainActivity.this, cadastro_morador.class);
            startActivity(it);
        }
        if (v.getId() == R.id.bt_entrar) {
//            Intent tela = new Intent(this, menu_morador.class);
//            startActivity(tela);
            consultaUsuarioLogin();
        }

    }

    public void consultaUsuarioLogin() {
        String Cpf = edit_cpf_login.getText().toString();
        String SenhaLogin = edit_senha_login.getText().toString();

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadosLogin(Cpf, SenhaLogin);

        if (dados.moveToFirst()) {

            // levando parametros (nome do usuario) para a tela de login
            Intent tela = new Intent(this, menu_morador.class);
            String nome = dados.getString(1);
            Bundle parametros = new Bundle();
            parametros.putString("nome", nome);
            tela.putExtras(parametros);
            startActivity(tela);
        } else {
            String msg = "Dados não encontrados no sistema!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
}
