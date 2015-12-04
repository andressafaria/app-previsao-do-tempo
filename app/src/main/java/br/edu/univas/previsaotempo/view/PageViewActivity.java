package br.edu.univas.previsaotempo.view;

import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.edu.univas.previsaotempo.R;
import br.edu.univas.previsaotempo.controller.CityController;
import br.edu.univas.previsaotempo.model.WeatherPrevision;
import br.edu.univas.previsaotempo.util.PersistWeatherPrevision;

public class PageViewActivity extends FragmentActivity {

    private MyPageAdapter pageAdapter;
    private CityController cityController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_view);

        cityController = new CityController(this);

        List<Fragment> fragments = getFragments();
        pageAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);
        ViewPager pager = (ViewPager)findViewById(R.id.viewpager);
        pager.setAdapter(pageAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_view, menu);
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

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        List<String> cities = new ArrayList<String>();

        Cursor cursor = cityController.findAll();

        cursor.moveToFirst();
        do {
            String city = cursor.getString(1); //array de cidades
            cities.add(city);
        } while(cursor.moveToNext());

        List<WeatherPrevision> previsions = PersistWeatherPrevision.getInstance().getPrevisions();

        for (String city: cities) {
            fList.add(MyFragment.newInstance(city));
        }
//        fList.add(MyFragment.newInstance("Fragment 1"));
//        fList.add(MyFragment.newInstance("Fragment 2"));
//        fList.add(MyFragment.newInstance("Fragment 3"));
        return fList;
    }



}
