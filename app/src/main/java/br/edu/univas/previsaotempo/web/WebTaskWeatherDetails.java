package br.edu.univas.previsaotempo.web;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.univas.previsaotempo.model.WeatherPrevision;
import br.edu.univas.previsaotempo.util.ConvertJSONToWeatherPrevision;

/**
 * Created by Aluno0207 on 03/11/2015.
 */
public class WebTaskWeatherDetails extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = WebTaskWeatherDetails.class.getSimpleName();
    private Context context;
    private String city;
    private TextView cidade;
    private TextView temperatura;
    //TODO: INCLUIR OS DEMAIS CAMPOS DA TELA DE DETAIL

    public WebTaskWeatherDetails(Context ctx, String city, TextView cidade, TextView temperatura) {
        this.context = ctx;
        this.city = city;
        this.cidade = cidade;
        this.temperatura = temperatura;
        //INCLUIR OS DEMAIS CAMPOS DA TELA DE DETAIL
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
            Toast.makeText(context, "Lique sua internet.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Conteúdo atualizado.", Toast.LENGTH_SHORT).show();
            WeatherPrevision weatherPrevision = ConvertJSONToWeatherPrevision.convert(result);

            //TODO: PEGAR TODOS OS CAMPOS DA TELA E SETAR SEUS VALORES AQUI. ESTES CAMPOS SÃO PASSADOS COMO
            //PARÂMETROS PARA ESTA CLASSE EM SEU CONSTRUTOR
            cidade.setText(weatherPrevision.getCidade().toString());
            temperatura.setText(String.valueOf(weatherPrevision.getTemperatura()));
            Log.i(TAG, "RESULT: " + result);
        }
    }
}