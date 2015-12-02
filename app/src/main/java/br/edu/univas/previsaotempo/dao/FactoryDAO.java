package br.edu.univas.previsaotempo.dao;

/**
 * Created by edilson on 10/20/15.
 */
public interface FactoryDAO {

    FactoryDAO createConnection();
    void openConnection();
    void closeConnection();

}
