package com.example.joquempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selectPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selectTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); // 0, 1 ,2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra" :
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel" :
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
//casos de vitoria e derrota
        if ((opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")) {

            textResultado.setText("Você perdeu :( ");

        } else if ((opcaoApp == "papel" && opcaoSelecionada == "tesoura") ||
                (opcaoApp == "pedra" && opcaoSelecionada == "papel") ||
                (opcaoApp == "tesoura" && opcaoSelecionada == "pedra")) {

            textResultado.setText("Você ganhou! :D ");

        } else {
            textResultado.setText("Empatamos ;) ");
        }


    }

}