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

public abstract class ElectronicDevice {
    String manufacturer;
    String model;
    String microprocessor;
    
    public ElectronicDevice() {
        // SE INICIALIZA CADA OBJETO PIDIENDO LAS ESPECIFICACIONES BASE DEL
        // DISPOSITIVO DESDE UN SOLO DIALOG CON MULTIPLES INPUTS
        
        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        
        Object[] fields = {
            "Fabricante", input1,
            "Modelo", input2,
            "Microprocesador", input3
        };
        
        // SE MUESTRA EL DIALOG HASTA QUE TODOS LOS INPUTS SEAN LLENADOS
        do {
            int option;
            option = JOptionPane.showConfirmDialog(
                null,
                fields,
                "Especificaciones base",
                JOptionPane.DEFAULT_OPTION
            );
            if (option != 0) System.exit(0);
        } while (
            input1.getText().isEmpty()
            || input2.getText().isEmpty()
            || input3.getText().isEmpty()
        );
        
        this.manufacturer = input1.getText();
        this.model = input2.getText();
        this.microprocessor = input3.getText();
    }
}
