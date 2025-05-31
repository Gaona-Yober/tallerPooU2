/*
 * Repositorio de Git: https://github.com/Gaona-Yober/tallerPooU2/tree/master
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.modelo;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public abstract class Vehiculo {
    
    private long generadorViajeId;

    //atributos
    private float capacidadCarga;
    private String placa;
    private float consumoCombustible;
    private LocalDate fechaMantenimiento;
    private Map<Long, Viaje> viajes;

    //constructor
    public Vehiculo(float capacidadCarga, String placa, float consumoCombustible, LocalDate fechaMantenimiento) {
        if (capacidadCarga < 0 || consumoCombustible < 0) {
            throw new IllegalArgumentException("Capacidad de carga y consumo no pueden ser negativos.");
        }
        
        this.generadorViajeId = 1;
        this.capacidadCarga = capacidadCarga;
        this.placa = placa;
        this.consumoCombustible = consumoCombustible;
        this.fechaMantenimiento = fechaMantenimiento;
        this.viajes = new HashMap<>();
    }

    //getters and seterrs


    public float getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(float capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getConsumoCombustible() {
        return consumoCombustible;
    }

    public void setConsumoCombustible(float consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }

    public LocalDate getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(LocalDate fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public Map<Long, Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(Map<Long, Viaje> viajes) {
        this.viajes = viajes;
    }

    //metodos
    public void agregarViaje(Viaje viaje) {
        if (viaje.getDistancia() < 0 || viaje.getPrecioCombustible()< 0) {
            throw new IllegalArgumentException("Distancia y precio de combustible no pueden ser negativos.");
        }
        
        long idViaje = generadorViajeId++;
        this.viajes.put(idViaje, viaje);
    }
    
    //tostring
    @Override
    public String toString() {
        return "Placa: " + placa +
               " | Capacidad: " + capacidadCarga +
               " | Consumo: " + consumoCombustible +
               " | Último mantenimiento: " + fechaMantenimiento;
    }
}
