package br.edu.univas.previsaotempo;

import android.os.Bundle;
import android.os.PersistableBundle;
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
 * Created by root on 04/12/15.
 */
public class AddNewCity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CityController cityController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cidade);

        cityController = new CityController(this);

        configureComponents();

    }

    private void configureComponents() {
        configureAddCity();
        configureCancel();
    }

    private void configureCancel() {
        Log.d(TAG, "Configuring the cancel button");

        Button btCancel = (Button) findViewById(R.id.bt_cancel_city);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Log.i(TAG, "Button cancel clicked.");
            }
        });

        Log.i(TAG, "Successfully to configure cancel button");
    }

    private void configureAddCity() {

        Log.d(TAG, "Configuring the save button");

        Button btSave = (Button) findViewById(R.id.btAddCity);
        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCity();
            }
        });

        Log.i(TAG, "Successfully to configure save button");
    }

    private void saveCity() {
        Log.d(TAG, "entrou para salvar cidade");

        EditText editcity = (EditText) findViewById(R.id.edit_add_city);
        City city = buildCity(editcity);

        cityController.saveCity(city);
        finish();

        Log.i(TAG, "Cidade salva com sucesso.");
    }

    @NonNull
    private City buildCity(EditText editcity){
        City city = new City();
        city.setName(editcity.getText().toString());
        return city;
    }
}
