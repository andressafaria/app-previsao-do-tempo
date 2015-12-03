package br.edu.univas.previsaotempo.web;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;


/**
 * Created by Aluno0207 on 27/10/2015.
 */
public class WebHelper {

    private static final String TAG = WebHelper.class.getSimpleName();

    private static final String URL_BASE = "http://api.openweathermap.org/data/2.5/weather";
    private static final String APPID = "APPID=10884489ff869181d1f9625aee88947e";

    private Context context;

    public WebHelper(Context ctx) {
        context = ctx;
    }


    public String getCityContent(String city) {
        if(!isNetworkAvaliable(context)) {
            return null;
        }
        String response = null;

        HttpURLConnection conn = null;
        try {

            URL url = new URL(URL_BASE + "?q=" + URLEncoder.encode(city, "UTF-8") + "&" + APPID);
            Log.i(TAG, URL_BASE + "?q=" + URLEncoder.encode(city, "UTF-8") + "&" + APPID);
            conn = (HttpURLConnection) url.openConnection();
            Log.i(TAG, "Opened connection");
            InputStream input = conn.getInputStream();
            Log.d(TAG, "INPUT: " + input);
            response = readContent(conn.getInputStream());
            Log.i(TAG, "RESPONSE: " + response);
        } catch(IOException e) {
            if(conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }

    public String getCEPContent() {

        if(!isNetworkAvaliable(context)) {
            return null;
        }
        String response = null;

        HttpURLConnection conn = null;
        try {

            URL url = new URL(URL_BASE);
            conn = (HttpURLConnection) url.openConnection();
            response = readContent(conn.getInputStream());
        } catch(IOException e) {
            if(conn != null) {
                conn.disconnect();
            }
        }
        return response;
    }

    private String readContent(InputStream in) {
        Log.d(TAG, "InputStream: " + in);
        String resp = "";
        Scanner sc = new Scanner(in);
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            Log.i(TAG, "NextLine: " + line);
            resp += line;
        }
        return resp;
    }

    public boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo ni = cm.getActiveNetworkInfo();

        Log.d(TAG, "ni: " + ni);
        if(ni != null && ni.isConnected()) {
            if(ni.getType() == ConnectivityManager.TYPE_WIFI) {
                Log.d(TAG, "Conectado via Wifi");
            } else if(ni.getType() == ConnectivityManager.TYPE_MOBILE){
                Log.d(TAG, "Conectado via mobile");
            }
            return true;
        }
        return false;
    }
}
