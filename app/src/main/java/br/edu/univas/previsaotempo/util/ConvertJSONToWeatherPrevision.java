package br.edu.univas.previsaotempo.util;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.univas.previsaotempo.model.WeatherPrevision;

/**
 * Created by edilson on 12/3/15.
 */
public class ConvertJSONToWeatherPrevision {


    private static final float KELVIN = 273f;

    public static WeatherPrevision convert(String json) {

        WeatherPrevision weatherPrevision = new WeatherPrevision();

        if (json == null) {
            return weatherPrevision;
        }
        try {
            JSONObject jsonRoot = new JSONObject(json);
            weatherPrevision.setCidade(jsonRoot.getString("name"));
            JSONObject jsonMain = new JSONObject(jsonRoot.getString("main"));
            weatherPrevision.setTemperatura(Float.parseFloat(jsonMain.getString("temp")) - KELVIN);
            weatherPrevision.setTemperaturaMinima(Float.parseFloat(jsonMain.getString("temp_min")) - KELVIN);
            weatherPrevision.setTemperaturaMaxima(Float.parseFloat(jsonMain.getString("temp_max")) - KELVIN);
            weatherPrevision.setHumidade(Float.parseFloat(jsonMain.getString("humidity")));
            weatherPrevision.setNivelMar(Float.parseFloat(jsonMain.getString("sea_level")));
            JSONObject jsonWind = new JSONObject(jsonRoot.getString("wind"));
            weatherPrevision.setVelocidadeAr(Float.parseFloat(jsonWind.getString("speed")));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weatherPrevision;

    }
}
