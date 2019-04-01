package com.example.intentsreceptor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView pedidos;
    String texto = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pedidos = (TextView) findViewById(R.id.pedidos);

        Intent intent= getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if(Intent.ACTION_SEND.equals(action) && type != null)
        {
            if("text/plain".equals(type)){
                texto = intent.getStringExtra(Intent.EXTRA_TEXT);
                manipularTexto(intent);
            }
        }
    }


    public void manipularTexto(Intent intent){

        if(texto != null){

            pedidos.setText("Lista de Pedidos:"+"\n" +texto);
          //  Toast.makeText(MainActivity.this,sharedText,Toast.LENGTH_LONG).show();
        }
    }
}
