package com.example.condominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriarBanco banco;

    public BancoController(Context context) {
        banco = new CriarBanco(context);
    }

    public Cursor carregaTodosDados() {
        Cursor cursor;
        String[] campos = { "cpf", "nome", "apartamento", "torre", "senha" };
        db = banco.getReadableDatabase();
        cursor = db.query("cadastro", campos, null, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String insereDadosUsuario(String cpf, String nome, String apartamento, String torre, String senha) {
        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        valores = new ContentValues();
        valores.put("cpf", cpf);
        valores.put("nome", nome);
        valores.put("apartamento", apartamento);
        valores.put("torre", torre);
        valores.put("senha", senha);

        resultado = db.insert("cadastro", null, valores);
        db.close();

        if (resultado == -1)
            return "ERRO AO INSERIR DADOS";
        else
            return "DADOS CADASTRADOS COM SUCESSO";
    }


    public Cursor carregaDadosLogin(String cpf, String senha) {
        Cursor cursor;
        String[] campos = {"cpf", "nome", "apartamento", "torre", "senha" };
        String where = "cpf = '" + cpf + "' and senha = '" + senha + "'";
        db = banco.getReadableDatabase();
        cursor = db.query("cadastro", campos, where, null, null, null,
                null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }



}
