/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.modelo;

import java.time.LocalDateTime;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class Viaje {

    //atributos
    private float distancia;
    private LocalDateTime fecha;
    private float precioCombustible;

    //contructor
    public Viaje(float distancia, LocalDateTime fecha, float precioCombustible) {
        this.distancia = distancia;
        this.fecha = fecha;
        this.precioCombustible = precioCombustible;
    }

    //get set

    public float getDistancia() {
        return distancia;
    }
    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public float getPrecioCombustible() {
        return precioCombustible;
    }
    public void setPrecioCombustible(float precioCombustible) {
        this.precioCombustible = precioCombustible;
    }

    @Override
    public String toString() {
        return "Viaje{" +
                "distancia=" + distancia +
                ", fecha=" + fecha +
                ", precioCombustible=" + precioCombustible +
                '}';
    }
}
