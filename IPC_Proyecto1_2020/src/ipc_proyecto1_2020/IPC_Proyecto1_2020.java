package ipc_proyecto1_2020;
        
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
        
public class IPC_Proyecto1_2020 {
    
    public static JButton[] botonMenu = new JButton[19];
    public static JLabel[] etiquetaMenu = new JLabel[14];
    
    public static void main(String[] args) {
        Ventana inicio = new Ventana(1400,600);
        inicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        for (int i = 0; i < botonMenu.length; i++) {
            botonMenu[i] = new JButton();            
        }
        for (int i = 0; i < etiquetaMenu.length; i++) {
            etiquetaMenu[i] = new JLabel();            
        }
        
        
        //CONFIGURACION Y UBIACIONES DE LOS COMPONENTES
        //ETIQUETAS
        //Columna 1
        etiquetaMenu[0].setText("EasyMath");
        etiquetaMenu[0].setBounds(5,5,125,20);
        etiquetaMenu[1].setText("Aritmetica");
        etiquetaMenu[1].setBounds(5,30,125,20);
        //Columna 2
        etiquetaMenu[2].setText("Algebra");
        etiquetaMenu[2].setBounds(200, 5, 125, 20);
        etiquetaMenu[3].setText("Ecuaciones");
        etiquetaMenu[3].setBounds(225,30,125,20);
        etiquetaMenu[4].setText("Factorizacion");
        etiquetaMenu[4].setBounds(225, 150, 125, 20);
        //Columna 3
        etiquetaMenu[5].setText("Trigonometria");
        etiquetaMenu[5].setBounds(500, 5, 125, 20);
        etiquetaMenu[6].setText("Funciones Trigonometricas");
        etiquetaMenu[6].setBounds(525, 30, 200, 20); 
        etiquetaMenu[7].setText("Angulos");
        etiquetaMenu[7].setBounds(525, 200, 125, 20);
        //Columna 4
        etiquetaMenu[8].setText("Calculo");
        etiquetaMenu[8].setBounds(775, 5, 125, 20);
        etiquetaMenu[9].setText("Calculo Diferencial");
        etiquetaMenu[9].setBounds(800, 30, 125, 20);
        etiquetaMenu[10].setText("Calculo Integral");
        etiquetaMenu[10].setBounds(800, 110, 125, 20);
        //Columna 5
        etiquetaMenu[11].setText("Algebra Lineal");
        etiquetaMenu[11].setBounds(1050, 5, 125, 20);
        etiquetaMenu[12].setText("Operaciones con Matrices");
        etiquetaMenu[12].setBounds(1075, 30, 150, 20);
        etiquetaMenu[13].setText("Operaciones con Matrices");
        etiquetaMenu[13].setBounds(1075, 200, 150, 20);
        
        
        
        
        //BOTONES
        //Columna 1
        botonMenu[0].setText("Calculadora");        
        botonMenu[0].setBounds(5,70,125,25);
        
        //Columna 2
        botonMenu[1].setText("Ecuacion Cuadratica");
        botonMenu[1].setBounds(225, 70, 200, 25);
        botonMenu[2].setText("Sistema de Ecuaciones");
        botonMenu[2].setBounds(225, 110, 200, 25);
        botonMenu[3].setText("Binomio Cuadrado");
        botonMenu[3].setBounds(225, 175, 200, 25);
        botonMenu[4].setText("Diferencia de Cuadrados");
        botonMenu[4].setBounds(225, 210, 200, 25);
        botonMenu[5].setText("Suma y Diferencia de Cubos");
        botonMenu[5].setBounds(225, 245, 200, 25);
        
        //Columna 3
        botonMenu[6].setText("Seno");
        botonMenu[6].setBounds(525, 70, 150, 25);
        botonMenu[7].setText("Coseno");
        botonMenu[7].setBounds(525, 110, 150, 25);
        botonMenu[8].setText("Tangente");
        botonMenu[8].setBounds(525, 150, 150, 25);
        botonMenu[9].setText("Longitud de Arco");
        botonMenu[9].setBounds(525, 245, 150, 25);
        
        //Columna 4
        botonMenu[10].setText("Casos de derivacion");
        botonMenu[10].setBounds(800, 70, 175, 25);
        botonMenu[11].setText("Casos de Integracion");
        botonMenu[11].setBounds(800, 150, 175, 25);
        botonMenu[12].setText("Sumas de Riemann");
        botonMenu[12].setBounds(800, 200, 175, 25);
        
        //Columna 5
        botonMenu[13].setText("Traspuesta");
        botonMenu[13].setBounds(1075, 70, 195, 25);
        botonMenu[14].setText("Inversa");
        botonMenu[14].setBounds(1075, 110, 195, 25);
        botonMenu[15].setText("Determinante");
        botonMenu[15].setBounds(1075, 150, 195, 25);
        botonMenu[16].setText("Operaciones entre matrices");
        botonMenu[16].setBounds(1075, 245, 195, 25);
        
        //Parte Baja
        botonMenu[17].setText("Favoritos");
        botonMenu[17].setBounds(875, 400, 175, 25);
        botonMenu[18].setText("Historial");
        botonMenu[18].setBounds(1075, 400, 195, 25);
        
        //AGREGAR LOS COMPONENTES AL PANEL
        //Agregar Etiquetas
        for (int i = 0; i < etiquetaMenu.length; i++) {
            inicio.getPanel().add(etiquetaMenu[i]);
        }                        
        //Agregar Botones
        for (int i = 0; i < botonMenu.length; i++) {
            inicio.getPanel().add(botonMenu[i]);
        }                        
        
        //AGREGAR EL PANEL A LA VENTANA Y HACER LA VENTANA VISIBLE.
        inicio.add(inicio.getPanel());
        inicio.setVisible(true);
        
        //Se agregan las acciones a los botones
        botonMenu[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Ventana calculadora = new Ventana(500,600);
                JButton [] botonCalculadora = new JButton[23];
                JTextField pantalla = new JTextField();
                
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 4; j++) {
                        botonCalculadora[]
                    }
                }
                
                
                
                calculadora.setVisible(true);
            }
        });
        
    }
    
}
