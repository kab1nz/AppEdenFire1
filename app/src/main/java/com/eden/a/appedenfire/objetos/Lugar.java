package com.eden.a.appedenfire.objetos;

/**
 * Created by a on 12/03/2018.
 */

public class Lugar extends UserId{
    private int id;
    private String nombreLugar;
    private String descripcionLugar;
    private double ratingLugar;
    private String image;

    public Lugar(){}
    public Lugar(int id, String nombreLugar, String descripcionLugar, double ratingLugar, String image) {
        this.id = id;
        this.nombreLugar = nombreLugar;
        this.descripcionLugar = descripcionLugar;
        this.ratingLugar = ratingLugar;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public String getDescripcionLugar() {
        return descripcionLugar;
    }

    public void setDescripcionLugar(String descripcionLugar) {
        this.descripcionLugar = descripcionLugar;
    }

    public double getRatingLugar() {
        return ratingLugar;
    }

    public void setRatingLugar(double ratingLugar) {
        this.ratingLugar = ratingLugar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
