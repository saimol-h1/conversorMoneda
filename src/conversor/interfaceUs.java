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
                    ventanaCorrespondiente = new JFrame("Conversor de moneda");
                    JTextField textField = new JTextField(10);
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Introduce un número:"));
                    panel.add(textField);
                    JButton okButton = new JButton("OK");
                    okButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ventanaCorrespondiente.dispose();
                            String texto = textField.getText();
                            double numero = Double.parseDouble(texto);
                            double resultado = numero * 1.23; // Conversión a dólares
                            JOptionPane.showMessageDialog(null, numero + " euros son " + resultado + " dólares.");
                        }
                    });
                    JButton cancelButton = new JButton("Cancelar");
                    cancelButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ventanaCorrespondiente.dispose();
                        }
                    });
                    panel.add(okButton);
                    panel.add(cancelButton);
                    ventanaCorrespondiente.add(panel);
                } else if (opcionSeleccionada == 1) {
                    ventanaCorrespondiente = new JFrame("Conversor de Temperatura");
                    JTextField textField = new JTextField(10);
                    JPanel panel = new JPanel();
                    panel.add(new JLabel("Introduce un número:"));
                    panel.add(textField);
                    JButton okButton = new JButton("OK");
                    okButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ventanaCorrespondiente.dispose();
                            String texto = textField.getText();
                            double numero = Double.parseDouble(texto);
                            double resultado = numero * 1.23; // Conversión a dólares
                            JOptionPane.showMessageDialog(null, numero + " euros son " + resultado + " dólares.");
                        }
                    });
                    JButton cancelButton = new JButton("Cancelar");
                    cancelButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            ventanaCorrespondiente.dispose();
                        }
                    });
                    panel.add(okButton);
                    panel.add(cancelButton);
                    ventanaCorrespondiente.add(panel);
                }

                ventanaCorrespondiente.setSize(400, 300);
                ventanaCorrespondiente.setLocationRelativeTo(null);
                ventanaCorrespondiente.setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String seleccion = (String) comboBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Seleccionaste " + seleccion);
    }
}
