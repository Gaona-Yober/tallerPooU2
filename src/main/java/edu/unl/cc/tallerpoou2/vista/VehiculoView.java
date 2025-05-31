/*
 * Repositorio de Git: https://github.com/Gaona-Yober/tallerPooU2/tree/master
 */
package edu.unl.cc.tallerpoou2.vista;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */


import edu.unl.cc.tallerpoou2.business.VehiculoFacade;
import edu.unl.cc.tallerpoou2.modelo.Vehiculo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class VehiculoView {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final VehiculoFacade facade = new VehiculoFacade();

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String error) {
        System.err.println("Error: " + error);
    }

    public void mostrarVehiculos(Collection<Vehiculo> vehiculos) {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
            return;
        }

        System.out.println("=== Vehículos Registrados ===");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
            mostrarAlertaMantenimiento(vehiculo);
        }
    }

    public void mostrarCostoViaje(float total, float combustible, float mantenimiento) {
        System.out.printf("Costo del viaje: $%.2f\n", total);
        System.out.printf("Combustible: %.2f litros/km\n", combustible);
        System.out.printf("Mantenimiento: $%.2f\n", mantenimiento);
    }

    public void mostrarAlertaMantenimiento(Vehiculo vehiculo) {
        LocalDate fechaMantenimiento = vehiculo.getFechaMantenimiento();
        if (facade.verificarMantenimiento(vehiculo)) {
            System.out.println("¡Alerta! Mantenimiento pendiente desde " + fechaMantenimiento.format(FORMATO_FECHA));
        }
    }
}