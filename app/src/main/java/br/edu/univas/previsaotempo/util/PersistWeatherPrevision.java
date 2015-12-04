package br.edu.univas.previsaotempo.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.univas.previsaotempo.model.WeatherPrevision;

/**
 * Created by edilson on 12/3/15.
 */
public class PersistWeatherPrevision {

    private static PersistWeatherPrevision INSTANCE;

    private List<WeatherPrevision> previsions;

    private PersistWeatherPrevision() {
    }

    public static PersistWeatherPrevision getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersistWeatherPrevision();
        }
        return INSTANCE;
    }

    public List<WeatherPrevision> getPrevisions() {
        if (previsions == null) {
            previsions = new ArrayList<WeatherPrevision>();
        }
        return previsions;
    }

    public void setPrevisions(List<WeatherPrevision> previsions) {
        this.previsions = previsions;
    }
}
