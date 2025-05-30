package gestor_flota_vehiculos.vista;

import gestor_flota_vehiculos.business.VehiculoFacade;
import gestor_flota_vehiculos.modelo.Camion;
import gestor_flota_vehiculos.modelo.Camioneta;
import gestor_flota_vehiculos.modelo.Moto;
import gestor_flota_vehiculos.modelo.Vehiculo;

import java.time.LocalDate;
import java.util.Scanner;

public class VehiculoView {
    private VehiculoFacade facade;
    private Scanner scanner;

    public VehiculoView(VehiculoFacade facade) {
        this.facade = facade;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println(" Menú de los vehiculos ");
            System.out.println("Presionar 1 si quiero registrar su vehiculo");
            System.out.println("Presionar 2 si quiere consultar el vehiculo");
            System.out.println("Presione 0 si quiere salir");
            System.out.print("Eliga la opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarVehiculo();
                case 2 -> consultarVehiculo();
                case 0 -> System.out.println("Saliendo del sistema de vehiculos");
                default -> System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }

    private void registrarVehiculo() {
        System.out.print("Tipos moto, camion y camioneta): ");
        String tipo = scanner.nextLine().toLowerCase();

        System.out.print("La placa: ");
        String placa = scanner.nextLine();
        System.out.print("La capacidad de carga: ");
        float capacidad = scanner.nextFloat();
        System.out.print("El consumo de combustible: ");
        float consumo = scanner.nextFloat();
        LocalDate hoy = LocalDate.now();

        Vehiculo v = null;

        switch (tipo) {
            case "moto" -> {
                System.out.print("Cilindrada: ");
                int cilindrada = scanner.nextInt();
                v = new Moto(capacidad, placa, consumo, hoy, cilindrada);
            }
            case "camion" -> {
                System.out.print("El numero de ejes: ");
                int ejes = scanner.nextInt();
                v = new Camion(capacidad, placa, consumo, hoy, ejes);
            }
            case "camioneta" -> {
                System.out.print("Es 4x4? seleccione(true/false): ");
                boolean es4x4 = scanner.nextBoolean();
                v = new Camioneta(capacidad, placa, consumo, hoy, es4x4);
            }
            default -> System.out.println("Tipo no valido");
        }

        if (v != null) {
            facade.registrarVehiculo(v);
            System.out.println("Su vehiculo se ha registrado");
        }
    }

    private void consultarVehiculo() {
        System.out.print("Placa del vehículo: ");
        String placa = scanner.nextLine();
        Vehiculo v = facade.consultarVehiculo(placa);
        if (v != null) {
            System.out.println("Vehículo encontrado: " + v.getPlaca() + " | Capacidad: " + v.getCapacidadCarga());
        } else {
            System.out.println("No se encontro el vehiculo");
        }
    }
}
