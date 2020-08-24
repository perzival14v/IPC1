package ipc1.practica12020;

import java.util.Scanner;


public class Matriz {
    
    protected String[][] matriz;    
    
    public Matriz(int fila,int columna) {
        matriz = new String[fila][columna];        
    }
    
    public Matriz agregarDato(){
        
        Matriz nueva= new Matriz(this.matriz.length,this.matriz[0].length);
        Scanner entrada = new Scanner(System.in);
        String nuevaPalabra;
        for (int i = 0; i < nueva.matriz[0].length; i++) {
            System.out.println("Palabra No " + (i+1));
            nuevaPalabra=entrada.nextLine();
                if (nuevaPalabra.length()>=5&&nuevaPalabra.length()<=10) {
                    nueva.matriz[0][i]=nuevaPalabra;
                }else{
                    System.out.println("La palabra no esta en entre 5 y 10 caracteres, intentelo de nuevo");
                    i--;
            }
        }
        
        return nueva;
    }
    
    public void modificarDato(){        
        Scanner entrada = new Scanner(System.in);
        String nuevaPalabra;
        
        System.out.println("\n"+"Ingrese la palabra que desea buscar y cambiar");
        String palabraBuscada = entrada.nextLine();
        nuevaPalabra = null;
            for (int i = 0; i < this.matriz[0].length; i++) {
                if(palabraBuscada.equalsIgnoreCase(this.matriz[0][i])){                                                        
                    System.out.println("Palabra encontrada, ingrese la nueva palabra");
                    nuevaPalabra = entrada.nextLine();
                    System.out.println("Palabra modificada exitosamente");
                        if (nuevaPalabra.length()>=5&&nuevaPalabra.length()<=10) {
                            this.matriz[0][i]=nuevaPalabra;
                        }else{
                            System.out.println("La palabra no esta en entre 5 y 10 caracteres, intentelo de nuevo");
                            i--;
                        }
                }                                                        
            }
                                                
            if(nuevaPalabra==null){
                System.out.println("Palabra no encontrada");
            }                       
    }
    
    public Matriz eliminarDato(){
        Scanner entrada = new Scanner(System.in);
        String nuevaPalabra,palabraBuscada;
        
        
              
        if(this.matriz[0].length==0){
            System.out.println("Ya no existen palabras, ingrese nuevas palabras");                                                
        }else{
            Matriz copia = new Matriz(1, this.matriz[0].length-1);
            System.out.println("\n"+"Ingrese la palabra que desea eliminar");
            palabraBuscada = entrada.nextLine();
            nuevaPalabra = null;
            int a=0;            
                                                
            for (int i = 0; i < this.matriz[0].length; i++) {
                if(palabraBuscada.equalsIgnoreCase(this.matriz[0][i])){
                    nuevaPalabra="buenas";
                        for (int j = 0; j < this.matriz[0].length; j++) {                                                            
                            if(j==i){
                                if(j+1==this.matriz[0].length){
                                    j++;    
                                }else{
                                    copia.matriz[0][a]=this.matriz[0][j+1];
                                    a++;
                                    j++;
                                }                                                                                                                                
                            }else{                                                                                                                                                                                                   
                                copia.matriz[0][a]=this.matriz[0][j];
                                a++;
                            }                                                            
                        }
                        System.out.println("Palabra eliminada");
                        return copia;                                                        
                }                                                        
            }
                                                                                                
                                                
            if(nuevaPalabra==null){
                System.out.println("Palabra no encontrada");
                return this;
            }
        }
        return this;
    }
    
    
    public Matriz ordenarMayorMenor(Matriz matriz){
        
        Matriz nueva= new Matriz(matriz.matriz.length,matriz.matriz[0].length);
        String aux;
                           
            for (int i = 0; i < matriz.matriz.length; i++) {
                for (int j = 0; j < matriz.matriz[0].length; j++) {
                    if(j<matriz.matriz[0].length-1){
                        if(matriz.matriz[i][j].length()<matriz.matriz[i][j+1].length()){
                            aux=matriz.matriz[i][j];
                            matriz.matriz[i][j]=matriz.matriz[i][j+1];
                            matriz.matriz[i][j+1]=aux;
                            j=-1;
                        }
                    }else{
                        if(matriz.matriz[i][j-1].length()<matriz.matriz[i][j].length()){
                            aux=matriz.matriz[i][j];
                            matriz.matriz[i][j-1]=matriz.matriz[i][j];
                            matriz.matriz[i][j]=aux;
                            j=-1;
                        }
                    }                        
                }
            }
            
            nueva = matriz; 
            return nueva;
    }       

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }
}
