/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.business;

import edu.unl.cc.tallerpoou2.data.VehiculoRepository;
import edu.unl.cc.tallerpoou2.modelo.Vehiculo;
import edu.unl.cc.tallerpoou2.modelo.Viaje;
import java.time.LocalDate;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class VehiculoFacade {
    public static float precioCombustible;
    private final VehiculoRepository vehiculoRepository = new VehiculoRepository();
    
    public Vehiculo registrarVehiculo(Vehiculo vehiculo){
            Vehiculo vehiculoPersisted = vehiculoRepository.save(vehiculo);
            return vehiculoPersisted;
    }
    
    public float calcularCostoViaje(Vehiculo vehiculo, Viaje viaje){
        float Costo = viaje.getDistancia() * 
                vehiculo.getConsumoCombustible() * 
                VehiculoFacade.precioCombustible + 
                vehiculoRepository.findCostoMantenimiento(vehiculo.getClass().getName());
        return Costo;
    }

    public void actualizarMantenimiento(LocalDate fecha, Vehiculo vehiculo){
        vehiculo.setFechaMantenimiento(fecha);
    }
}
