/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.business;

import edu.unl.cc.tallerpoou2.data.VehiculoRepository;
import edu.unl.cc.tallerpoou2.modelo.Vehiculo;
import edu.unl.cc.tallerpoou2.modelo.Viaje;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class VehiculoFacade {
    public static float precioCombustible;
    private final VehiculoRepository vehiculoRepository;

    public VehiculoFacade(float precioCombustible) {
        this.precioCombustible = precioCombustible;
        this.vehiculoRepository = new VehiculoRepository();;
    }

    public static void setPrecioCombustible(float precioCombustible) {
        if (precioCombustible < 0) {
            throw new IllegalArgumentException("El precio del combustible no puede ser negativo.");
        }
        VehiculoFacade.precioCombustible = precioCombustible;
    }
    
    public Vehiculo registrarVehiculo(Vehiculo vehiculo){
            Vehiculo vehiculoPersisted = vehiculoRepository.agregarVehiculo(vehiculo);
            return vehiculoPersisted;
    }
    
    public float calcularCostoViaje(Vehiculo vehiculo, Viaje viaje){
	if (viaje.getDistancia() < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }

	float consumo = vehiculo.getConsumoCombustible();
        float costoBase = viaje.getDistancia() * consumo * precioCombustible;

	// Costo adicional por tipo de vehículo
        float incrementoTipo = 0f;
        if (vehiculo instanceof Camioneta && vehiculo.getEs4x4()) {
            incrementoTipo = 0.2f * costoBase; // 20% extra
        }

	float costoMantenimiento = vehiculoRepository.getCostoMantenimiento(vehiculo);
	
	// Asociar el viaje
        vehiculoRepository.agregarViaje(vehiculo, viaje);

        float costoTotal = costoBase + incrementoTipo + costoMantenimiento;

        return costoTotal;
    }

    public void actualizarMantenimiento(LocalDate fecha, Vehiculo vehiculo){
        vehiculo.setFechaMantenimiento(fecha);
    }
    
    public boolean verificarMantenimiento(Vehiculo vehiculo) {
        LocalDate hoy = LocalDate.now();
        return ChronoUnit.MONTHS.between(vehiculo.getFechaMantenimiento(), hoy) > 6;
    }
    
//    public List<Vehiculo> listarVehiculos() {
//        return repository.getTodosVehiculos().stream().collect(Collectors.toList());
//    }
}
