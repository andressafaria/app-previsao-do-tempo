package br.edu.univas.previsaotempo.repository;

import java.util.List;
import java.util.Set;

/**
 * Created by edilson on 10/20/15.
 */
public interface AppRepository<T> {

    void save(T entity);
    List<T> findAll();
}
