package br.edu.univas.previsaotempo.web;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.univas.previsaotempo.MainActivity;
import br.edu.univas.previsaotempo.R;
import br.edu.univas.previsaotempo.controller.CityController;
import br.edu.univas.previsaotempo.model.City;

/**
 * Created by Andressa Faria on 04/12/2015.
 */
public class PageDetails extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CityController cityController;
    private String cidade;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_details);

        cityController = new CityController(this);

        configureComponents();

    }

    private void configureComponents() {
        configureviewDetail(cidade);
        configureVoltar();
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

    private void configureviewDetail(String cidade) {

        Log.d(TAG, "Configuring the save button");

        Button btViewDetail = (Button) findViewById(R.id.viewDetail);
        btViewDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewDetail();
            }
        });

        Log.i(TAG, "Successfully to configure save button");
    }

    private void viewDetail() {
        Log.d(TAG, "entrou para ver detalhes da cidade");

        EditText verDetail = (EditText) findViewById(R.id.edit_add_city);
        City city = buildCity(verDetail);

       // cityController.saveCity(city);
        //finish();

        Log.i(TAG, "Detalhes disponibilizados .");
    }

    @NonNull
    private City buildCity(EditText editcity){
        City city = new City();
        city.setName(editcity.getText().toString());
        return city;
    }

}
