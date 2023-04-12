package conversor;

import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class interfaceUs extends JFrame implements ActionListener{
    private JComboBox<String> comboBox;
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
        JButton button1 = new JButton("Aceptat");
        panel.add(label);
        panel.add(comboBox);
        panel.add(button1);
        add(panel);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre la ventana para introducir el número
                JFrame introducirNumeroFrame = new JFrame("Introducir número");
                JLabel introducirNumeroLabel = new JLabel("Introduce un número:");
                JTextField introducirNumeroTextField = new JTextField(10);
                JButton introducirNumeroAceptarButton = new JButton("Aceptar");
                JPanel introducirNumeroPanel = new JPanel();
                introducirNumeroPanel.add(introducirNumeroLabel);
                introducirNumeroPanel.add(introducirNumeroTextField);
                introducirNumeroPanel.add(introducirNumeroAceptarButton);
                introducirNumeroFrame.add(introducirNumeroPanel);
                introducirNumeroFrame.pack();
                introducirNumeroFrame.setLocationRelativeTo(null);
                introducirNumeroFrame.setVisible(true);

                // Agrega un ActionListener al botón "Aceptar" de la ventana para introducir el número
                introducirNumeroAceptarButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Cierra la ventana para introducir el número
                        introducirNumeroFrame.dispose();

                        // Abre la nueva ventana con las opciones adicionales
                        JFrame nuevaVentanaFrame = new JFrame("Nueva ventana");
                        nuevaVentanaFrame.setSize(400, 300);
                        nuevaVentanaFrame.setLocationRelativeTo(null);
                        // Aquí agrega los componentes necesarios para la nueva ventana
                        nuevaVentanaFrame.setVisible(true);
                    }
                });
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String seleccion = (String) comboBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Seleccionaste " + seleccion);
    }
}
