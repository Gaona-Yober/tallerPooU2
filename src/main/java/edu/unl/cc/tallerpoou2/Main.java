/*
 * Repositorio de Git: https://github.com/Gaona-Yober/tallerPooU2/tree/master
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.unl.cc.tallerpoou2;

import edu.unl.cc.tallerpoou2.business.VehiculoFacade;
import edu.unl.cc.tallerpoou2.modelo.Vehiculo;
import edu.unl.cc.tallerpoou2.modelo.Viaje;
import edu.unl.cc.tallerpoou2.vista.VehiculoView;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final VehiculoFacade facade = new VehiculoFacade();
    private static final VehiculoView view = new VehiculoView();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 ->
                    registrarVehiculo();
                case 2 ->
                    registrarViaje();
                case 3 ->
                    actualizarMantenimiento();
                case 4 ->
                    view.mostrarVehiculos(facade.listarVehiculos());
                case 5 ->
                    view.mostrarMensaje("Saliendo del sistema...");
                default ->
                    view.mostrarError("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Gestión de Flota de Reparto ===");
        System.out.println("Autores: Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila.");
        System.out.println("====================================");
        System.out.println("1. Registrar vehículo");
        System.out.println("2. Registrar viaje");
        System.out.println("3. Actualizar mantenimiento");
        System.out.println("4. Listar vehículos");
        System.out.println("5. Salir");
    }

    private static void registrarVehiculo() {
        System.out.println("Tipo de vehículo (1: Moto, 2: Camioneta, 3: Camión): ");
        int tipo = leerEntero("");
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        float capacidad = leerFloat("Capacidad de carga (kg): ");
        float consumo = leerFloat("Consumo (l/km): ");
        LocalDate fecha = leerFecha("Fecha de último mantenimiento (YYYY-MM-DD): ");

        try {
            switch (tipo) {
                case 1 -> {
                    int cc = leerEntero("Cilindrada (cc): ");
                    facade.registrarMoto(placa, capacidad, consumo, fecha, cc);
                }
                case 2 -> {
                    boolean es4x4 = leerConfirmacion("¿Tiene tracción 4x4? (s/n): ");
                    facade.registrarCamioneta(placa, capacidad, consumo, fecha, es4x4);
                }
                case 3 -> {
                    int ejes = leerEntero("Número de ejes: ");
                    facade.registrarCamion(placa, capacidad, consumo, fecha, ejes);
                }
                default -> {
                    view.mostrarError("Tipo no válido.");
                    return;
                }
            }
            view.mostrarMensaje("Vehículo " + placa + " registrado exitosamente.");
        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }

    private static void registrarViaje() {
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        float distancia = leerFloat("Distancia del viaje (km): ");
        LocalDate fecha = leerFecha("Fecha del viaje (YYYY-MM-DD): ");
        float precioCombustible = leerFloat("Precio del Combustible ($/l): ");

        try {
            Viaje viaje = new Viaje(distancia, fecha, precioCombustible);
            float[] resultado = facade.registrarViaje(facade.buscarPorPlaca(placa), viaje);
            view.mostrarCostoViaje(resultado[0], resultado[1], resultado[2]);
            view.mostrarAlertaMantenimiento(facade.buscarPorPlaca(placa));
        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }

    private static void actualizarMantenimiento() {
        System.out.print("Placa del vehículo: ");
        String placa = sc.nextLine();
        Vehiculo vehiculo = facade.buscarPorPlaca(placa);
        LocalDate fecha = leerFecha("Nueva fecha de mantenimiento (YYYY-MM-DD): ");
        try {
            facade.actualizarMantenimiento(vehiculo, fecha);
            view.mostrarMensaje("Fecha de mantenimiento actualizada.");
        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }

    // === Utilidades ===
    private static float leerFloat(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                view.mostrarError("Debe ingresar un número válido.");
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                view.mostrarError("Debe ingresar un número entero.");
            }
        }
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                view.mostrarError("Formato de fecha inválido. Use YYYY-MM-DD.");
            }
        }
    }
    
    private static boolean leerConfirmacion(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String entrada = sc.nextLine().trim(); // Usamos trim para eliminar espacios extra
                // Usamos && para asegurar que la entrada no sea ni 's' ni 'n'
                if (!entrada.equalsIgnoreCase("s") && !entrada.equalsIgnoreCase("n")) {
                    throw new InputMismatchException("La entrada solo puede ser 's' o 'n' de Sí o No.");
                }
                return entrada.equalsIgnoreCase("s"); // Devuelve true si es 's'
            } catch (InputMismatchException e) {
                view.mostrarError(e.getMessage());
            }
        }
    }
}
