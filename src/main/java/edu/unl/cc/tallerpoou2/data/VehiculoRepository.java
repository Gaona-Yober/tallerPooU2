/*
 * Repositorio de Git: https://github.com/Gaona-Yober/tallerPooU2/tree/master
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.data;

import edu.unl.cc.tallerpoou2.modelo.Vehiculo;
import edu.unl.cc.tallerpoou2.modelo.Viaje;
import java.util.Collection;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class VehiculoRepository {
    private final Map<Long, Vehiculo> vehiculos;
    static private final Map<String, Float> costosMantenimiento = new HashMap<>();; // tipo -> costo base

    public VehiculoRepository() {
        vehiculos = new HashMap<>();

        // Inicializar costos de mantenimiento por tipo de vehículo
        costosMantenimiento.put("Moto", 20f);
        costosMantenimiento.put("Camioneta", 35f);
        costosMantenimiento.put("Camion", 50f);
    }

    public Vehiculo agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("Vehículo no válido.");
        }
        
        Long id = generarIdVehiculo(vehiculo);
        vehiculos.put(id, vehiculo);
        return vehiculo;
    }

    public Viaje agregarViaje(Vehiculo vehiculo, Viaje viaje) {
        vehiculo.agregarViaje(viaje);
        return viaje;
    }
    
    public Vehiculo buscarPorPlaca(String placa) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía.");
        }

        return obtenerTodosVehiculos().stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vehículo con placa '" + placa + "' no encontrado."));
    }

    public float getCostoMantenimiento(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("Vehículo no válido.");
        }
        String tipo = vehiculo.getClass().getSimpleName();
        return costosMantenimiento.getOrDefault(tipo, 30f);
    }
    
    public Collection<Vehiculo> obtenerTodosVehiculos() {
        return vehiculos.values();
    }

    private Long generarIdVehiculo(Vehiculo vehiculo) {
        return (long) vehiculo.getPlaca().hashCode();
    }
}
