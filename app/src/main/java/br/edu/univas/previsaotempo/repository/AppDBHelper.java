package br.edu.univas.previsaotempo.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.edu.univas.previsaotempo.dao.AppContractDAO;

/**
 * Created by edilson on 10/20/15.
 */
public class AppDBHelper extends SQLiteOpenHelper {

    private static final String TAG = AppDBHelper.class.getSimpleName();

    public AppDBHelper(Context context) {
        super(context, AppContractDAO.DB_NAME, null, AppContractDAO.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Creating the table TASK.");
        String CREATE_USER_TABLE =
                "CREATE TABLE " + AppContractDAO.CITY_TABLE + " ("
                        + AppContractDAO.Column.ID + " INTEGER PRIMARY KEY, "
                        + AppContractDAO.Column.NAME + " TEXT NOT NULL "
                        + " )";

        db.execSQL(CREATE_USER_TABLE);
        Log.i(TAG, "Successfully creating table on SQLite");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
