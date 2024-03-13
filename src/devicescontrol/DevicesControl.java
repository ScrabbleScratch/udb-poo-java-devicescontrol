/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devicescontrol;

import javax.swing.*;
import java.util.*;
import devices.*;

/**
 *
 * @author scrab
 */
public class DevicesControl {
    /**
     * @param args the command line arguments
     */
    
//    CREAR UNA LISTA PARA ALMACENAR CADA TIPO DE DISPOSITIVO
    static List<Desktop> desktopsList = new ArrayList<>();
    static List<Laptop> laptopsList = new ArrayList<>();
    static List<Tablet> tabletsList = new ArrayList<>();
    
    public static void main(String[] args) {
        Object[] options = { "Registrar equipo", "Ver equipos", "Salir" }; // OPCIONES DEL MENU { 0, 1, 2 }
        
        // MOSTRAR MENU HASTA QUE SE PRESIONE EL BOTON DE SALIR
        do {
            int selection = JOptionPane.showOptionDialog(
                null,
                "Seleccione una opción",
                "Menú",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
            );

            switch(selection) {
                case 0:
                    registerDevice();
                    break;
                case 1:
                    viewDevices();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (true);
    }
    
    private static void registerDevice() {
        Object[] options = { "Desktops", "Laptops", "Tablets" }; // OPCIONES DEL MENU { 0, 1, 2 }
        
        // MOSTRAR DIALOG DE OPCIONES
        int selection = JOptionPane.showOptionDialog(
            null,
            "Seleccione el tipo de equipo a registrar",
            "Registro de equipo",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );
        
        // CREAR UN NUEVO OBJETO DE LA CLASE SELECCIONADA Y GUARDARLO EN LA
        // LISTA DE DISPOSITIVOS CORRESPONDIENTE
        switch(selection) {
            case 0:
                Desktop desktopDevice = new Desktop();
                desktopsList.add(desktopDevice);
                break;
            case 1:
                Laptop laptopDevice = new Laptop();
                laptopsList.add(laptopDevice);
                break;
            case 2:
                Tablet tabletDevice = new Tablet();
                tabletsList.add(tabletDevice);
                break;
            default:
                break;
        }
    }
    
    private static void viewDevices() {
        Object[] options = { "Desktops", "Laptops", "Tablets" }; // OPCIONES DEL MENU { 0, 1, 2 }
        
        // MOSTRAR DIALOG DE TYPOS DE DISPOSITIVO
        int selection = JOptionPane.showOptionDialog(
            null,
            "Seleccione el tipo de equipos a visualizar",
            "Ver equipos",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            options,
            options[0]
        );
        
        // SE CREA UNA LISTA DE STRINGS CON LOS DETALLES DE CADA DISPOSITIVO
        // DE LA CATEGORIA SELECCIONADA
        List<String> devicesDetails = new ArrayList<>();
        switch(selection) {
            case 0:
                desktopsList.forEach(desktop -> devicesDetails.add(desktop.toString()));
                break;
            case 1:
                laptopsList.forEach(laptop -> devicesDetails.add(laptop.toString()));
                break;
            case 2:
                tabletsList.forEach(tablet -> devicesDetails.add(tablet.toString()));
                break;
            default:
                return;
        }
        
        // SE MUESTRAN LOS DETALLES DE LOS DISPOSITIVOS DE LA CATEGORIA
        JOptionPane.showMessageDialog(
            null,
            String.join("\n\n", devicesDetails),
            "Dispositivos",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}
