package br.edu.univas.previsaotempo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.univas.previsaotempo.MainActivity;
import br.edu.univas.previsaotempo.R;
import br.edu.univas.previsaotempo.web.WebTaskWeatherDetails;

/**
 * Created by Andressa Faria on 04/12/2015.
 */
public class PageDetails extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String cidade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_details);

        Intent intent = getIntent();
        cidade = intent.getStringExtra("CITY");

        configureVoltar();

        getWeatherDetails();

    }

    private void getWeatherDetails() {

        TextView temperatura = (TextView) findViewById(R.id.temperatura_detail);
        TextView minDetail = (TextView) findViewById(R.id.minima_detail);
        TextView maxDetail = (TextView) findViewById(R.id.maxima_detail);
        TextView humidadeDetail = (TextView) findViewById(R.id.humidade_detail);
        TextView marDetail = (TextView) findViewById(R.id.mar_detail);
        TextView velocidadeDetail = (TextView) findViewById(R.id.velocidade_detail);
        TextView cidadeDetail = (TextView) findViewById(R.id.cidade_detail);

        cidadeDetail.setText(cidade);

        WebTaskWeatherDetails task = new WebTaskWeatherDetails(this, cidade, temperatura, minDetail,
                maxDetail, humidadeDetail, marDetail, velocidadeDetail);
        task.execute();

    }


    private void configureVoltar() {
        Log.d(TAG, "Configuring the cancel button");

        Button btVoltar = (Button) findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.i(TAG, "Button cancel clicked.");
            }
        });

        Log.i(TAG, "Successfully to configure cancel button");
    }

}
