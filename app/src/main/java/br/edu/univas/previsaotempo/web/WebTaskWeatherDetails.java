package br.edu.univas.previsaotempo.web;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import br.edu.univas.previsaotempo.R;
import br.edu.univas.previsaotempo.model.WeatherPrevision;
import br.edu.univas.previsaotempo.util.ConvertJSONToWeatherPrevision;

/**
 * Created by Aluno0207 on 03/11/2015.
 */
public class WebTaskWeatherDetails extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = WebTaskWeatherDetails.class.getSimpleName();
    private Context context;
    private String city;
    private TextView temperatura;
    private TextView minDetail;
    private TextView maxDetail;
    private TextView humidadeDetail;
    private TextView marDetail;
    private TextView velocidadeDetail;

    public WebTaskWeatherDetails(Context context,
                                 String city,
                                 TextView temperatura,
                                 TextView minDetail,
                                 TextView maxDetail,
                                 TextView humidadeDetail,
                                 TextView marDetail,
                                 TextView velocidadeDetail) {
        this.context = context;
        this.city = city;
        this.temperatura = temperatura;
        this.minDetail = minDetail;
        this.maxDetail = maxDetail;
        this.humidadeDetail = humidadeDetail;
        this.marDetail = marDetail;
        this.velocidadeDetail = velocidadeDetail;
    }

    @Override
    protected String doInBackground(Integer... params) {
        Log.d(TAG, "Início de doInBackground: " + params);

        WebHelper helper = new WebHelper(context);
        String content = helper.getCityContent(city);

        Log.d(TAG, "Fim de doInBackground: " + content);
        return content;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "Valores de onProgressUpdate: " + values);
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "Valores de onPostExecute: " + result);
        if(result == null) {
            //Toast.makeText(context, "Lique sua internet.", Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(context, "Conteúdo atualizado.", Toast.LENGTH_SHORT).show();
            WeatherPrevision weatherPrevision = ConvertJSONToWeatherPrevision.convert(result);

            temperatura.setText(String.valueOf(weatherPrevision.getTemperatura()));
            minDetail.setText(String.valueOf(weatherPrevision.getTemperaturaMinima()));
            maxDetail.setText(String.valueOf(weatherPrevision.getTemperaturaMaxima()));
            humidadeDetail.setText(String.valueOf(weatherPrevision.getHumidade()));
            marDetail.setText(String.valueOf(weatherPrevision.getNivelMar()));
            velocidadeDetail.setText(String.valueOf(weatherPrevision.getVelocidadeAr()));

            Log.i(TAG, "RESULT: " + result);
        }
    }
}