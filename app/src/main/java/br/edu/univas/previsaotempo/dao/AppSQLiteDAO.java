package br.edu.univas.previsaotempo.dao;

/**
 * Created by edilson on 10/20/15.
 */
public class AppSQLiteDAO implements FactoryDAO {

    private static AppSQLiteDAO instance = null;

    private AppSQLiteDAO() {
    }

    @Override
    public FactoryDAO createConnection() {
        return null;
    }

    @Override
    public void openConnection() {

    }

    @Override
    public void closeConnection() {

    }

    public static AppSQLiteDAO getInstance() {
        if (instance == null) {
            instance = new AppSQLiteDAO();
        }
        return instance;
    }
}
