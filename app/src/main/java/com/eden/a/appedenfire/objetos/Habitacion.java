package com.eden.a.appedenfire.objetos;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by usuario on 07/03/2018.
 */

public class Habitacion extends UserId {
    String key;
     int estado;
    String nombre;
    String apellido;
    String email;
    String fechaentrada;
    String fechasalida;
    int nhabitaciones;
    int precio;
    String tipo;

    public Map<String, Boolean> stars = new HashMap<>();

    public Habitacion() {
    }
    public Habitacion(String key,int reserva) {
        this.key=key;
        this.estado=reserva;
    }


    public Habitacion(String nombre, String apellido, String email, String fechaentrada, String fechasalida, int nhabitaciones, int precio, String tipo,int reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.nhabitaciones = nhabitaciones;
        this.precio = precio;
        this.tipo = tipo;
        this.estado=reserva;
    }
    public boolean comprobarCampos(String nombre, String apellido, String email, String fechaentrada, String fechasalida, int nhabitaciones, int precio, String tipo){

        if(nombre.isEmpty()||apellido.isEmpty()||email.isEmpty()||fechaentrada.isEmpty()||fechasalida.isEmpty()||String.valueOf(nhabitaciones).isEmpty() || String.valueOf(precio).isEmpty()){
            return false;
        }else
            return true;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(String fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public String getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(String fechasalida) {
        this.fechasalida = fechasalida;
    }

    public int getNhabitaciones() {
        return nhabitaciones;
    }

    public void setNhabitaciones(int nhabitaciones) {
        this.nhabitaciones = nhabitaciones;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public int getReserva() {
        return estado;
    }

    public void setReserva(int reserva) {
        this.estado = reserva;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        return "Prediccion{" +
            "Nombre='" + nombre + '\'' +
            ", Apellido='" + apellido + '\'' +
            ", Email=" + email +
            ", FechaEntrada=" + fechaentrada +
            ", FechaSalida=" + fechasalida +
            ", Precio=" + precio +
            ", NºHabitaciones=" + nhabitaciones +
            ", Tipo=" + tipo +
            '}';
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("key", key);
        result.put("estado", estado);


        return result;
    }
}
