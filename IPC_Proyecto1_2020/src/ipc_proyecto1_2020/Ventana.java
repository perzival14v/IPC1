package ipc_proyecto1_2020;

import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{      
    
    private JPanel panel = new JPanel();
    
    Ventana(int ancho, int alto){
        this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        this.panel.setLayout(null);
    }    

    public JPanel getPanel() {
        return panel;
    }
}