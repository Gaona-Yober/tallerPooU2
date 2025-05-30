/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.modelo;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
//import java.util.Date;

/**
 *
 * @author author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class Vehiculo {

    //atributos
    private float capacidadCarga;
    private String placa;
    private float consumoCombustible;
    private LocalDate fechaMantenimiento;
    private Map<Long, Viaje> viajes;

    //constructor
    public Vehiculo(float capacidadCarga, String placa, float consumoCombustible, LocalDate fechaMantenimiento) {
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
    public void agregarViaje(Viaje viaje, Long id) {
        this.viajes.put(id, viaje);
    }
    public Viaje obtenerViajes(Long id) {
        return this.viajes.get(id);
    }

    //tostrong
    @Override
    public String toString() {
        return "Vehiculo{" +
                "capacidadCarga=" + capacidadCarga +
                ", placa='" + placa + '\'' +
                ", consumoCombustible=" + consumoCombustible +
                ", fechaMantenimiento=" + fechaMantenimiento +
                ", viajes=" + viajes +
                '}';
    }
}
