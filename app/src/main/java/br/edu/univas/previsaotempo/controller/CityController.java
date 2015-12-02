package br.edu.univas.previsaotempo.controller;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import br.edu.univas.previsaotempo.model.City;
import br.edu.univas.previsaotempo.service.CityService;

/**
 * Created by edilson on 10/20/15.
 */
public class CityController {

    private static final String TAG = CityController.class.getSimpleName();

    private CityService cityService;

    public CityController(Context context) {
        cityService = new CityService(context);
    }

    public Cursor findAll() {
        Log.d(TAG, "Retrieving the all register from service");
        return cityService.findAll();
    }

    public void saveCity(City city) {
        Log.d(TAG, "Saving the register: " + city.toString());
        cityService.saveAgency(city);
    }
}
