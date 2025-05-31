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
public class Camion extends Vehiculo {

    //atributos
    private int numeroEjes;

    //contructor
    public Camion(float capacidadCarga, String placa, float consumoCombustible, LocalDate fechaMantenimiento, int numeroEjes) {
        super(capacidadCarga, placa, consumoCombustible, fechaMantenimiento);
        this.numeroEjes = numeroEjes;
    }

    //get and set
    public int getNumeroEjes() {
        return numeroEjes;
    }
    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String toString() {
        return "Camión | " + super.toString() + " | Ejes: " + numeroEjes;
    }
}
