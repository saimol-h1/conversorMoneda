package conversor;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class interfaceUs extends JFrame {
    public static void main(String[] args) {
        interfaceUs frame = new interfaceUs();
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Haz hecho clic en el botón");
    }
    public interfaceUs() {
        setTitle("conversor");
        setSize(400,600);
        JButton button = new JButton("Haz clic");
        setLocationRelativeTo(null);
        add(button);
    }

}
