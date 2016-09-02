package com.example.lukas.pesquisa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {

    JSONObject json = null;
    String sJson = "";
    Conectar conectar = new Conectar();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEntrar = (Button) findViewById(R.id.btnIniciar);
        Button btnProximo =  (Button) findViewById(R.id.btnProx);
        final TextView txtQuestao = (TextView) findViewById(R.id.txtQuestao);

        conectar.execute("https://raw.githubusercontent.com/lukasepramos/Pesquisa/master/jsonQuestionario.txt");



        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                try {
                    sJson = conectar.get(5000, TimeUnit.MILLISECONDS);

                  //  txtQuestao.setText("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
                //json = new JSONObject(sJson);


            }
        });

    }








}