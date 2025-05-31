/*
 * Repositorio de Git: https://github.com/Gaona-Yober/tallerPooU2/tree/master
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.business;

import edu.unl.cc.tallerpoou2.data.VehiculoRepository;
import edu.unl.cc.tallerpoou2.modelo.Camion;
import edu.unl.cc.tallerpoou2.modelo.Camioneta;
import edu.unl.cc.tallerpoou2.modelo.Moto;
import edu.unl.cc.tallerpoou2.modelo.Vehiculo;
import edu.unl.cc.tallerpoou2.modelo.Viaje;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class VehiculoFacade {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoFacade() {
        this.vehiculoRepository = new VehiculoRepository();;
    }

    public VehiculoFacade(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
        Vehiculo vehiculoPersisted = vehiculoRepository.agregarVehiculo(vehiculo);
        return vehiculoPersisted;
    }

    public void registrarMoto(String placa, float capacidad, float consumo, LocalDate fecha, float cilindrada) {
        Moto moto = new Moto(capacidad, placa, consumo, fecha, cilindrada);
        vehiculoRepository.agregarVehiculo(moto);
    }

    public void registrarCamioneta(String placa, float capacidad, float consumo, LocalDate fecha, boolean es4x4) {
        Camioneta camioneta = new Camioneta(capacidad, placa, consumo, fecha, es4x4);
        vehiculoRepository.agregarVehiculo(camioneta);
    }

    public void registrarCamion(String placa, float capacidad, float consumo, LocalDate fecha, int ejes) {
        Camion camion = new Camion(capacidad, placa, consumo, fecha, ejes);
        vehiculoRepository.agregarVehiculo(camion);
    }

    public float[] registrarViaje(Vehiculo vehiculo, Viaje viaje) {
        Viaje viajePersisted = vehiculoRepository.agregarViaje(vehiculo, viaje);
        float[] resultado = calcularCostoViaje(vehiculo, viaje);
        return resultado;
    }

    public float[] calcularCostoViaje(Vehiculo vehiculo, Viaje viaje) {
        if (viaje.getDistancia() < 0) {
            throw new IllegalArgumentException("La distancia no puede ser negativa.");
        }

        float consumo = vehiculo.getConsumoCombustible();
        float costoBase = viaje.getDistancia() * consumo * viaje.getPrecioCombustible();

        // Costo adicional por tipo de vehículo
        float incrementoTipo = 0f;
        if (vehiculo instanceof Camioneta && ((Camioneta) vehiculo).getEs4x4()) {
            incrementoTipo = 0.2f * costoBase; // 20% extra
        }

        float costoMantenimiento = vehiculoRepository.getCostoMantenimiento(vehiculo);

        // Asociar el viaje
        vehiculoRepository.agregarViaje(vehiculo, viaje);

        float costoTotal = costoBase + incrementoTipo + costoMantenimiento;

        return new float[]{costoTotal, consumo, costoMantenimiento};
    }

    public void actualizarMantenimiento(Vehiculo vehiculo, LocalDate fecha) {
        vehiculo.setFechaMantenimiento(fecha);
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepository.obtenerTodosVehiculos().stream().collect(Collectors.toList());
    }
    
    public boolean verificarMantenimiento(Vehiculo vehiculo) {
        LocalDate hoy = LocalDate.now();
        return ChronoUnit.MONTHS.between(vehiculo.getFechaMantenimiento(), hoy) > 6;
    }

    public Vehiculo buscarPorPlaca(String placa) {
        return vehiculoRepository.buscarPorPlaca(placa);
    }
}
