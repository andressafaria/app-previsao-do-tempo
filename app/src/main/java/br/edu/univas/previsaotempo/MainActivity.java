package br.edu.univas.previsaotempo;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.univas.previsaotempo.controller.CityController;
import br.edu.univas.previsaotempo.dao.AppContractDAO;
import br.edu.univas.previsaotempo.view.PageViewActivity;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CityController cityController;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityController = new CityController(this);
        configureButtons();
        configureListView();
    }

    private void configureListView() {

        Log.d(TAG, "Configuring the list of items");

        ListView listView = (ListView) findViewById(R.id.list_cities);
        Cursor cursor = cityController.findAll();
        String [] from = new String [] {
                AppContractDAO.Column.NAME,
                };

        int [] to = new int [] {R.id.txt_city_list};

        adapter = new SimpleCursorAdapter(
                this, R.layout.item_list, cursor, from, to);
        adapter.setViewBinder(new CityBinder());
        listView.setAdapter(adapter);

        Log.i(TAG, "Successfully configure the list of items");
    }



    @Override
    protected void onPostResume() {

        Log.d(TAG, "Backing to mainActivity. Reload the listView");

        super.onPostResume();
        configureListView();

        Log.i(TAG, "Successfully to reload the listView");
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

        //Log.d(TAG, "Add Button clicked");

        Intent intent = new Intent(this, AddNewCity.class);
        startActivity(intent);

        //Log.i(TAG, "Successfully to open add register activity");

        //EditText cityText = (EditText) findViewById(R.id.add_city_home);
        //City city = new City();
        //city.setName(cityText.getText().toString());
        //cityController.saveCity(city);
        //cityText.setText(null, null);
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

    /**
     * Suport class for list item
     */
    class CityBinder implements SimpleCursorAdapter.ViewBinder {

        @Override
        public boolean setViewValue(View view, Cursor cursor, int i) {
            switch (view.getId()) {
                case R.id.txt_city_list: {
                    CharSequence city = cursor.getString(i);
                    ((TextView) view).setText(city);
                    return true;
                }
            }
            return false;
        }
    }
}
