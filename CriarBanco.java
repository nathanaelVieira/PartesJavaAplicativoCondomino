package com.example.condominio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarBanco extends SQLiteOpenHelper {


    private static final String NOME_BANCO = "banco_condominio.db";
    private static final int VERSAO = 2;


    public CriarBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE cadastro ("
                + "cpf integer primary key,"
                + "nome text,"
                + "apartamento text,"
                + "torre text,"
                + "senha text)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cadastro");
        onCreate(db);
    }
}