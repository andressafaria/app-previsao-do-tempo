package br.edu.univas.previsaotempo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.univas.previsaotempo.controller.CityController;
import br.edu.univas.previsaotempo.model.City;
import br.edu.univas.previsaotempo.view.PageViewActivity;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private CityController cityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityController = new CityController(this);
        configureButtons();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    private void configureButtons () {
        configureButtonAddCity();
        configureButtonGoToWeather();
    }

    private void configureButtonAddCity() {
        Button bt = (Button) findViewById(R.id.btAddCity);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCity();
            }
        });
    }

    private void addCity() {
        EditText cityText = (EditText) findViewById(R.id.add_city_home);
        City city = new City();
        city.setName(cityText.getText().toString());
        cityController.saveCity(city);
        cityText.setText(null, null);
        //WebTaskWeather task = new WebTaskWeather(getApplicationContext(), city.getName());
        //task.execute();
        showToast("Successo ao cadastrar nova cidade!");
    }

    private void showToast(CharSequence message) {
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, message, duration);
        toast.show();
    }


    private void configureButtonGoToWeather() {
        Button bt = (Button) findViewById(R.id.btGoToWeather);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWeather();
            }
        });
    }

    private void goToWeather() {
        Intent intent = new Intent(this, PageViewActivity.class);
        startActivity(intent);

    }
}
