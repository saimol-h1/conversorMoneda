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
    }

    public void actionPerformed(ActionEvent e) {
        String seleccion = (String) comboBox.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Seleccionaste " + seleccion);
    }
}
