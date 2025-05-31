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
public class Camioneta extends Vehiculo {

    //atrubutos
    private boolean es4x4;

    //constructor
    public Camioneta(float capacidadCarga, String placa,
                     float consumoCombustible, LocalDate fechaMantenimiento,
                     boolean es4x4) {
        super(capacidadCarga, placa, consumoCombustible, fechaMantenimiento);
        this.es4x4 = es4x4;
    }

    //get set
    public boolean getEs4x4() {
        return es4x4;
    }
    public void setEs4x4(boolean es4x4) {
        this.es4x4 = es4x4;
    }

    @Override
    public String toString() {
        return "Camioneta | " +
                super.toString()+ " | 4x4: " + (es4x4 ? "Sí" : "No");
    }
}
