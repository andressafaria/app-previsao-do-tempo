package br.edu.univas.previsaotempo.model;

import java.io.Serializable;

/**
 * Created by edilson on 12/1/15.
 */
public class City implements Serializable {

    private long id;
    private String name;

    public City() {
    }

    public City(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
