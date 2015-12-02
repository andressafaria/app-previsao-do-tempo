package br.edu.univas.previsaotempo.web;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aluno0207 on 03/11/2015.
 */
public class WebTask extends AsyncTask<Integer, Integer, String> {
    //entrada: CEP
    //passo: número qualquer
    //saída: o conteúdo do json

    private static final String TAG = WebTask.class.getSimpleName();
    private Context context;
    private TextView widgetTexto;

    public WebTask(Context ctx, TextView text) {
        this.context = ctx;
        this.widgetTexto = text;
    }

    @Override
    protected String doInBackground(Integer... params) {
        Log.d(TAG, "Início de doInBackground: " + params);

        WebHelper helper = new WebHelper(context);
        String content = helper.getCEPContent();

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
            widgetTexto.setText(result);
        }
    }
}