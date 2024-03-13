/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devices;

import javax.swing.*;

/**
 *
 * @author scrab
 */

public class Desktop extends ElectronicDevice {
    String memory;
    String graphicsCard;
    String towerSize;
    String hardDriveSize;
    
    public Desktop() {
        super();
        
        // SE INICIALIZA CADA OBJETO PIDIENDO LAS ESPECIFICACIONES ESPECIFICAS
        // DEL DISPOSITIVO DESDE UN SOLO DIALOG CON MULTIPLES INPUTS
        
        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        JTextField input4 = new JTextField();
        
        Object[] fields = {
            "Memoria", input1,
            "Tarjeta gráfica", input2,
            "Tamaño de torre", input3,
            "Capacidad de disco duro", input4
        };
        
        // SE MUESTRA EL DIALOG HASTA QUE TODOS LOS INPUTS SEAN LLENADOS
        do {
            int option;
            option = JOptionPane.showConfirmDialog(
                null,
                fields,
                "Especificaciones para desktop",
                JOptionPane.DEFAULT_OPTION
            );
            if (option != 0) System.exit(0);
        } while (
            input1.getText().isEmpty()
            || input2.getText().isEmpty()
            || input3.getText().isEmpty()
            || input4.getText().isEmpty()
        );
        
        this.memory = input1.getText();
        this.graphicsCard = input2.getText();
        this.towerSize = input3.getText();
        this.hardDriveSize = input4.getText();
    }
    
    // SOBREESCRIBIR EL METODO TOSTRING PARA GENERAR UNA STRING PERSONALIZADA
    // QUE INCLUYA LAS ESPECIFICACIONES DEL DISPOSITIVO
    @Override
    public String toString() {
        return (
            "Fabricante: " + this.manufacturer + "\n" +
            "Modelo: " + this.model + "\n" +
            "Microprocesador: " + this.microprocessor + "\n" +
            "Memoria: " + this.memory + "\n" +
            "Tarjeta gráfica: " + this.graphicsCard + "\n" +
            "Tamaño de torre: " + this.towerSize + "\n" +
            "Capacidad de disco duro: " + this.hardDriveSize
        );
    }
}
