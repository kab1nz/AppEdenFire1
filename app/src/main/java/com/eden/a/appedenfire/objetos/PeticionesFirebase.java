package com.eden.a.appedenfire.objetos;

/**
 * Created by a on 11/03/2018.
 */

public interface PeticionesFirebase {
    public void aceptarReserva(String id,int pos);
    public void rechazarReserva(String id,int pos);
    public void cancelarReserva(String id,int pos);


}
