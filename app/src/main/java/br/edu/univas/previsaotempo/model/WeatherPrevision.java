package br.edu.univas.previsaotempo.model;

import java.io.Serializable;

/**
 * Created by edilson on 12/3/15.
 */
public class WeatherPrevision implements Serializable {

    private String cidade;
    private float temperatura;
    private float temperaturaMinima;
    private float temperaturaMaxima;
    private float humidade;
    private float nivelMar;
    private float velocidadeAr;

    public WeatherPrevision() {
    }

    public WeatherPrevision(String cidade,
                            float temperatura,
                            float temperaturaMinima,
                            float temperaturaMaxima,
                            float humidade,
                            float nivelMar,
                            float velocidadeAr) {
        this.cidade = cidade;
        this.temperatura = temperatura;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.humidade = humidade;
        this.nivelMar = nivelMar;
        this.velocidadeAr = velocidadeAr;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(float temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public float getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(float temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public float getHumidade() {
        return humidade;
    }

    public void setHumidade(float humidade) {
        this.humidade = humidade;
    }

    public float getNivelMar() {
        return nivelMar;
    }

    public void setNivelMar(float nivelMar) {
        this.nivelMar = nivelMar;
    }

    public float getVelocidadeAr() {
        return velocidadeAr;
    }

    public void setVelocidadeAr(float velocidadeAr) {
        this.velocidadeAr = velocidadeAr;
    }
}
