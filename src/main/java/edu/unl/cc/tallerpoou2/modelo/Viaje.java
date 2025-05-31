/*
 * Repositorio de Git: https://github.com/Gaona-Yober/tallerPooU2/tree/master
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.modelo;

import java.time.LocalDate;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class Viaje {

    //atributos
    private float distancia;
    private LocalDate fecha;
    private float precioCombustible; // $ / litro

    //contructor
    public Viaje(float distancia, LocalDate fecha, float precioCombustible) {
        if (distancia < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }
        if (precioCombustible < 0) {
            throw new IllegalArgumentException("El precio del combustible no puede ser negativo.");
        }
        
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

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public float getPrecioCombustible() {
        return precioCombustible;
    }

    public void setPrecioCombustible(float precioCombustible) {
        if (precioCombustible < 0) {
            throw new IllegalArgumentException("El precio del combustible no puede ser negativo.");
        }
        
        this.precioCombustible = precioCombustible;
    }
    
}
