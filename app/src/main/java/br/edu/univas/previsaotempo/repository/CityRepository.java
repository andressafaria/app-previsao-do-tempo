package br.edu.univas.previsaotempo.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.edu.univas.previsaotempo.dao.AppContractDAO;
import br.edu.univas.previsaotempo.model.City;

/**
 * Created by edilson on 10/20/15.
 */
public class CityRepository extends AppDBHelper implements AppRepository<City> {

    private static final String TAG = CityRepository.class.getSimpleName();

    public CityRepository(Context context) {
        super(context);
    }

    @Override
    public void save(City entity) {

        Log.d(TAG, "Saving city " + entity.toString());

        ContentValues values = new ContentValues();
        values.put(AppContractDAO.Column.NAME , entity.getName());
        SQLiteDatabase db = super.getWritableDatabase();
        db.insert(AppContractDAO.CITY_TABLE, null, values);

        Log.i(TAG, "Successfully saving city : " + entity.toString());
    }

    @Override
    public List<City> findAll() {

        Log.d(TAG, "Retrieve all cities");

        Cursor cursor = findAllAsCursor();
        List<City> list = new ArrayList<City>();

        if(cursor.moveToFirst()) {
            do {
                City city = new City();
                //vo.setId(cursor.getInt(0));
                city.setName(cursor.getString(1));

                list.add(city);
            } while(cursor.moveToNext());
        }
        cursor.close();

        Log.i(TAG, "Successfully retrieve all city");
        return list;
    }


    public Cursor findAllAsCursor() {

        Log.d(TAG, "Retrieve all cities as cursor");

        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(AppContractDAO.CITY_TABLE);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = qb.query(db, AppContractDAO.COLUMN_NAMES,
                null, null, null, null, null);

        Log.i(TAG, "Successfully retrieve all city as cursor");
        return cursor;
    }
}
