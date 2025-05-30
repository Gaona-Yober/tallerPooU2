/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.modelo;

import java.time.LocalDate;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class Moto extends Vehiculo {

    //atrubutod
    private float cilindrada;

    //construcutor
    public Moto(float capacidadCarga, String placa, float consumoCombustible, LocalDate fechaMantenimiento, float cilindrada) {
        super(capacidadCarga, placa, consumoCombustible, fechaMantenimiento);
        this.cilindrada = cilindrada;
    }

    //get set
    public float getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrada=" + cilindrada +
                '}';
    }
}
