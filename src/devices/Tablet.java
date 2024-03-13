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
public class Tablet extends ElectronicDevice {
    String screenSize;
    String screenType;
    String nandMemorySize;
    String operativeSystem;
    
    public Tablet() {
        super();
        
        // SE INICIALIZA CADA OBJETO PIDIENDO LAS ESPECIFICACIONES ESPECIFICAS
        // DEL DISPOSITIVO DESDE UN SOLO DIALOG CON MULTIPLES INPUTS
        
        JRadioButton radio1 = new JRadioButton("Capacitiva");
        JRadioButton radio2 = new JRadioButton("Resistiva");
        // SE CREA UN INPUT DE TIPO RADIO PARA EL TIPO DE PANTALLA
        ButtonGroup typeMenu = new ButtonGroup();
        typeMenu.add(radio1);
        typeMenu.add(radio2);
        
        JTextField input1 = new JTextField();
        JTextField input2 = new JTextField();
        JTextField input3 = new JTextField();
        
        Object[] fields = {
            "Tamaño de pantalla", input1,
            "¿Capacitiva/Resistiva?", radio1, radio2,
            "Tamaño de memoria NAND", input2,
            "Sistema operativo", input3
        };
        
        // SE MUESTRA EL DIALOG HASTA QUE TODOS LOS INPUTS SEAN LLENADOS
        do {
            int option;
            option = JOptionPane.showConfirmDialog(
                null,
                fields,
                "Especificaciones para tablet",
                JOptionPane.DEFAULT_OPTION
            );
            if (option != 0) System.exit(0);
        } while (
            !(radio1.isSelected() || radio2.isSelected())
            || input1.getText().isEmpty()
            || input2.getText().isEmpty()
            || input3.getText().isEmpty()
        );
        
        this.screenSize = input1.getText();
        this.screenType = radio1.isSelected()
            ? "Capacitiva"
            : radio2.isSelected()
                ? "Resistiva"
                : null;
        this.nandMemorySize = input2.getText();
        this.operativeSystem = input3.getText();
    }
    
    // SOBREESCRIBIR EL METODO TOSTRING PARA GENERAR UNA STRING PERSONALIZADA
    // QUE INCLUYA LAS ESPECIFICACIONES DEL DISPOSITIVO
    @Override
    public String toString() {
        return (
            "Fabricante: " + this.manufacturer + "\n" +
            "Modelo: " + this.model + "\n" +
            "Microprocesador: " + this.microprocessor + "\n" +
            "Tamaño diagonal de pantalla: " + this.screenSize + "\n" +
            "¿Capacitiva/Resistiva?: " + this.screenType + "\n" +
            "Tamaño memoria NAND: " + this.nandMemorySize + "\n" +
            "Sistema Operativo: " + this.operativeSystem
        );
    }
}
