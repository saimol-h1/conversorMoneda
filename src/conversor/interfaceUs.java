package conversor;

import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class interfaceUs extends JFrame implements ActionListener{
    private JComboBox<String> comboBox;
    private JFrame ventanaCorrespondiente;

    public static void main(String[] args) {
        interfaceUs frame = new interfaceUs();
        frame.setVisible(true);
    }
    public interfaceUs() {
        setTitle("Menu");
        setSize(400,150);

        String[] opciones = {"Conversor de moneda", "Conversor de Temperatura"};
        comboBox = new JComboBox<>(opciones);
        comboBox.addActionListener(this);
        add(comboBox);
        JLabel label = new JLabel("Selecciona una opción:");
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(comboBox);

        JLabel label1 = new JLabel("Selecciona una opción de convercion:");
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("Aceptar");
        panel.add(label);
        panel.add(comboBox);
        panel.add(button1);
        add(panel);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcionSeleccionada = comboBox.getSelectedIndex();

                if (opcionSeleccionada == 0) {
                    mostrarVentanaConversorMoneda();
                } else if (opcionSeleccionada == 1) {
                    mostrarVentanaConversorTemperatura();
                }

                ventanaCorrespondiente.setSize(400, 200);
                ventanaCorrespondiente.setLocationRelativeTo(null);
                ventanaCorrespondiente.setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String seleccion = (String) comboBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Seleccionaste " + seleccion);
    }

    private void mostrarVentanaConversorMoneda() {
        ventanaCorrespondiente = new JFrame("Conversor de moneda");

        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField textFieldCantidad = new JTextField();
        inputPanel.add(new JLabel("Introduce la cantidad a convertir:"));
        inputPanel.add(textFieldCantidad);

        JComboBox<String> comboBoxMonedaOrigen = new JComboBox<>(new String[]{"Peso Colombiano"});
        inputPanel.add(new JLabel("Moneda de origen:"));
        inputPanel.add(comboBoxMonedaOrigen);

        JComboBox<String> comboBoxMonedaDestino = new JComboBox<>(new String[]{"Dólar", "Euro", "Libra Esterlina", "Yen Japonés", "Won sul-coreano"});
        inputPanel.add(new JLabel("Moneda de destino:"));
        inputPanel.add(comboBoxMonedaDestino);

        panel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancelar");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        ventanaCorrespondiente.add(panel);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaCorrespondiente.dispose();
            }
        });

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double cantidad = Double.parseDouble(textFieldCantidad.getText());
                    String monedaOrigen = (String) comboBoxMonedaOrigen.getSelectedItem();
                    String monedaDestino = (String) comboBoxMonedaDestino.getSelectedItem();
                    double resultado = ConversorMoneda.convertirDesdeCOP(monedaDestino, cantidad);
                    JOptionPane.showMessageDialog(ventanaCorrespondiente, String.format("%.2f %s son %.2f %s", cantidad, monedaOrigen, resultado, monedaDestino));
                    int respuesta = JOptionPane.showConfirmDialog(ventanaCorrespondiente, "¿Desea realizar otra conversión?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Cerrar la ventana actual y volver al menú principal
                        ventanaCorrespondiente.dispose();
                    } else {
                        // Cerrar completamente el programa
                        JOptionPane.showMessageDialog(ventanaCorrespondiente, "Programa finalizado.");
                        System.exit(0);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventanaCorrespondiente, "Error: la cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ventanaCorrespondiente.pack();
        ventanaCorrespondiente.setLocationRelativeTo(null);
        ventanaCorrespondiente.setVisible(true);
    }
    private void mostrarVentanaConversorTemperatura() {
        ventanaCorrespondiente = new JFrame("Conversor de temperatura");

        JPanel panel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField textFieldCantidad = new JTextField();
        inputPanel.add(new JLabel("Introduce la temperatura a convertir:"));
        inputPanel.add(textFieldCantidad);

        JComboBox<String> comboBoxtemperaturaOrigen = new JComboBox<>(new String[]{"Celsius"});
        inputPanel.add(new JLabel("Unidad de origen:"));
        inputPanel.add(comboBoxtemperaturaOrigen);

        JComboBox<String> comboBoxtemperaturaDestino = new JComboBox<>(new String[]{"Fahrenheit", "Kelvin"});
        inputPanel.add(new JLabel("Unidad de destino:"));
        inputPanel.add(comboBoxtemperaturaDestino);

        panel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancelar");

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        ventanaCorrespondiente.add(panel);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaCorrespondiente.dispose();
            }
        });

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double cantidad = Double.parseDouble(textFieldCantidad.getText());
                    String temperaturaOrigen = (String) comboBoxtemperaturaOrigen.getSelectedItem();
                    String temperaturaDestino = (String) comboBoxtemperaturaDestino.getSelectedItem();
                    double resultado = ConversorTemperatura.convertirACualquierUnidadDesdeCelsius(temperaturaDestino, ConversorTemperatura.convertirACelsiusDesdeCualquierUnidad(temperaturaOrigen, cantidad));
                    JOptionPane.showMessageDialog(ventanaCorrespondiente, String.format("%.2f grados %s son %.2f grados %s", cantidad, temperaturaOrigen, resultado, temperaturaDestino));
                    int respuesta = JOptionPane.showConfirmDialog(ventanaCorrespondiente, "¿Desea realizar otra conversión?", "Confirmación", JOptionPane.YES_NO_CANCEL_OPTION);

                    if (respuesta == JOptionPane.YES_OPTION) {
                        // Cerrar la ventana actual y volver al menú principal
                        ventanaCorrespondiente.dispose();
                    } else {
                        // Cerrar completamente el programa
                        JOptionPane.showMessageDialog(ventanaCorrespondiente, "Programa finalizado.");
                        System.exit(0);
                    }
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(ventanaCorrespondiente, "Error: la cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ventanaCorrespondiente.pack();
        ventanaCorrespondiente.setLocationRelativeTo(null);
        ventanaCorrespondiente.setVisible(true);

    }




}
