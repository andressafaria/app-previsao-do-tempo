package br.edu.univas.previsaotempo.dao;

import android.provider.BaseColumns;

/**
 * Created by edilson on 10/20/15.
 */
public class AppContractDAO extends ContractDAO {

    public static final String CITY_TABLE = "CITY";

    public static final String [] COLUMN_NAMES = {
            Column.ID, Column.NAME
    };

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String NAME = "NAME";
    }
}
