/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.unl.cc.tallerpoou2.vista;

/**
 *
 * @author Gaona Yober, Palma Wilson, Ortega Fernando, Chimbo Camila
 */


import edu.unl.cc.tallerpoou2.business.VehiculoFacade;
import edu.unl.cc.tallerpoou2.data.VehiculoRepository;
import edu.unl.cc.tallerpoou2.vista.VehiculoView;

public class Main {
    public static void main(String[] args) {
        VehiculoRepository repository = new VehiculoRepository();
        VehiculoFacade facade = new VehiculoFacade(repository);
        VehiculoView view = new VehiculoView(facade);
        view.mostrarMenu();
    }
}