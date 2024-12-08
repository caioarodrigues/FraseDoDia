package com.example.frasedodia;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.frasedodia.data.PhraseFactory;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> phrases = new ArrayList<>() {{
        add("O único lugar onde o sucesso vem antes do trabalho é no dicionário.");
        add("Acredite em si mesmo e tudo será possível.");
        add("Grandes conquistas começam com pequenos passos.");
        add("Você é mais forte do que imagina. Continue avançando.");
        add("Transforme obstáculos em oportunidades e desafios em aprendizados.");
        add("Nunca é tarde para ser quem você deseja ser.");
        add("A mudança começa onde termina a sua zona de conforto.");
        add("Cada esforço é um degrau rumo ao topo. Não desista!");
        add("O futuro pertence àqueles que acreditam na beleza dos seus sonhos.");
        add("Falhar é apenas o primeiro passo para aprender e crescer.");
    }};
    private final PhraseFactory phraseFactory = PhraseFactory.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.phraseFactory.add(this.phrases);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView2);
        ListView everyPhrase = findViewById(R.id.every_phrase);

        ArrayAdapter<String> everyPhraseAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                phrases
        );
        everyPhrase.setAdapter(everyPhraseAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phrase = phraseFactory.getRandomPhrase();
                textView.setText(phrase);

                textView.setVisibility(View.VISIBLE);
                everyPhrase.setVisibility(View.GONE);
            }
        });

        Button buttonListAll = findViewById(R.id.button2);
        buttonListAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                everyPhrase.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
            }
        });
    }
}
