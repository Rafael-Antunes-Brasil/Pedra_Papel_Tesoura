package rafael.com.local.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.app.appsearch.GetByDocumentIdRequest;
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

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada(0);
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada(1);
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada(2);
    }

    public void opcaoSelecionada(int opSelecionada) {
        int num = new Random().nextInt(3);

        ImageView imagem = findViewById(R.id.imgRes);

        switch (num){
            case 0:
                imagem.setImageResource(R.drawable.pedra);
              break;
            case 1:
                imagem.setImageResource(R.drawable.papel);
                break;
            case 2:
                imagem.setImageResource(R.drawable.tesoura);
                break;
        }

        TextView res = findViewById(R.id.resultado);

        if (opSelecionada == num) {
            res.setText("Empate");
        } else if ((opSelecionada == 0 && num == 2) || (opSelecionada == 2 && num == 1) ||
                (opSelecionada == 1 && num == 0)) {
            res.setText("Você Ganhou *-*");
        } else {
            res.setText("Você perdeu :(");
        }
    }

    /*
        pedra ganha tesoura
        tesoura ganha papel
        papel ganha pedra

        0 ganha 2
        2 ganha 1
        1 ganha 0
     */

}