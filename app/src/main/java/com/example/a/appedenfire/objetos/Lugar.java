package com.example.a.appedenfire.objetos;

/**
 * Created by a on 12/03/2018.
 */

public class Lugar extends UserId{
    private String id;
    private String nombreLugar;
    private String descripcionLugar;
    private String ratingLugar;
    private String image;

    public Lugar(){}
    public Lugar(String id, String nombreLugar, String descripcionLugar, String ratingLugar, String image) {
        this.id = id;
        this.nombreLugar = nombreLugar;
        this.descripcionLugar = descripcionLugar;
        this.ratingLugar = ratingLugar;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getRatingLugar() {
        return ratingLugar;
    }

    public void setRatingLugar(String ratingLugar) {
        this.ratingLugar = ratingLugar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
