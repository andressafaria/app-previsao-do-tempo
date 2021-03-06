package br.edu.univas.previsaotempo.service;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import br.edu.univas.previsaotempo.model.City;
import br.edu.univas.previsaotempo.repository.CityRepository;

/**
 * Created by edilson on 10/20/15.
 */
public class CityService {

    private static final String TAG = CityService.class.getSimpleName();

    private CityRepository cityRepository;

    public CityService(Context context) {
        cityRepository = new CityRepository(context);
    }

    public Cursor findAll() {
        Log.d(TAG, "Retrieving the all register from DAO");
        return cityRepository.findAllAsCursor();
    }

    public void saveCity(City city) {
        Log.d(TAG, "Saving the register in DAO");
        if (!isCityAvailable(city)) {
            //TODO: throw an exception
        }
        cityRepository.save(city);
        Log.i(TAG, "Successfully to save city");
    }

    private boolean isCityAvailable(City city) {
        //TODO: implementar a lógica para chamar o webservice.
        //city.setId(Codigo_cidade_web_service);
        return true;
    }
}
