/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.data;

import edu.unl.cc.tallerpoou2.modelo.Vehiculo;
import edu.unl.cc.tallerpoou2.modelo.Viaje;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class VehiculoRepository {
    private final Map<Long, Vehiculo> vehiculos = new HashMap<>();
    private final Map<String, Float> mantenimiento = new HashMap<>();

    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        Long id = generarIdVehiculo(vehiculo);
        vehiculos.put(id, vehiculo);
        mantenimiento.put(vehiculo.getPlaca(), 0f);
        return vehiculo;
    }

    public void agregarViaje(Vehiculo vehiculo, Viaje viaje) {
        vehiculo.getViajes().put(viaje.getFechaViaje().toString(), viaje);
    }

    public float getCostoMantenimiento(Vehiculo vehiculo) {
        return mantenimiento.getOrDefault(vehiculo.getPlaca(), 0f);
    }

    public void actualizarMantenimiento(Vehiculo vehiculo, float costo) {
        mantenimiento.put(vehiculo.getPlaca(), costo);
    }

    private Long generarIdVehiculo(Vehiculo vehiculo) {
        return (long) vehiculo.getPlaca().hashCode();
    }

}
