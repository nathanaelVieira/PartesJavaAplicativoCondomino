package com.example.condominio;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class autorizacao_visitante extends AppCompatActivity {

    EditText edit_nome;
   // EditText edit_rg;
    //EditText edit_apartamento;
   // EditText edit_torre;
    Button btnSalvar;
    ImageView ivQRCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autorizacao_visitante);

        iniciliarComponentes();
        clickButtonn();
    }


    private void clickButtonn() {
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                geraQRcode();
            }
        });
    }

    private void geraQRcode() {
        String texto0  = edit_nome.getText().toString();
       // String texto1 = edit_rg.getText().toString();
        //String texto2 = edit_apartamento.getText().toString();
        //String texto3 = edit_torre.getText().toString();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(texto0 , BarcodeFormat.QR_CODE,2000, 2000);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ivQRCode.setImageBitmap(bitmap);

        }catch (WriterException e){
            e.printStackTrace();
        }
    }
    private void iniciliarComponentes() {
        edit_nome = (EditText) findViewById(R.id.edit_nome);
       // edit_rg = (EditText) findViewById(R.id.edit_rg);
        //edit_apartamento = (EditText) findViewById(R.id.edit_apartamento);
        //edit_torre = (EditText)findViewById(R.id.edit_torre);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        ivQRCode = (ImageView) findViewById(R.id.ivQRCode);
    }
}