
package ipc1.practica12020;

import java.util.Scanner;

public class Sopa extends Matriz{
    
    private int[][] posiciones;
    private int x=0;
    
    public Sopa(int fila, int columna) {
        super(fila, columna);
    }
        
    
    public int direccionPalabras(){
        //random1 nos indica si colocara las palabras de forma vertical o horizontal (1,0)
        int random1= (int) (Math.random()*2);
        
        return random1;
    }
    
    public int[][] direcciones(Matriz palabra,int tamañoMatriz){
        
        posiciones=new int[2][tamañoMatriz];
                                
        boolean prueba=true;
        
            //Posiciones en X
            for (int i = 0; i < tamañoMatriz; i++) {
            //random2 nos sacara las posiciones para colocar las palabras dentro de la matriz
                int random2= (int) (Math.random()*tamañoMatriz); 
                    for (int j = 0; j < tamañoMatriz; j++) {
                        if(random2==posiciones[0][j]){
                            prueba=false;
                            j=tamañoMatriz;
                        }else{
                            prueba=true;
                        }                                            
                    }
                    
                    if(prueba){
                        posiciones[0][i]=random2;
                    }else{                        
                        if(i==tamañoMatriz-1){
                                i=tamañoMatriz;
                        }
                        i--;
                        prueba=true;
                    }
            }
            //Posiciones en Y
            for (int i = 0; i < palabra.matriz[0].length; i++) {
            //random2 nos sacara las posiciones para colocar las palabras dentro de la matriz                                     
                        int random2= (int) (Math.random()*(tamañoMatriz-palabra.matriz[0][i].length()))+1;
                        posiciones[1][i]=random2;                                                                                                 
            }
            
        return posiciones;
    }
    
    public void  iniciarSopa(Matriz palabras,String [] abecedario, Jugador jugador, Historial historial){
        //1 es vertical, 0 es horizontal
        
        posiciones = direcciones(palabras, this.matriz[0].length);
        int contadorPalabras = palabras.matriz[0].length;        
        Scanner entrada = new Scanner(System.in);
        
        //Se llena la matriz con letras aleatorias
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                int random = (int) (Math.random()*27);
                this.matriz[i][j]=" |"+abecedario[random]+"| ";                
            }            
        }
        int random=(int)(Math.random()*(this.matriz[0].length-palabras.matriz[0][0].length()));
        int letras=0;
        
        //Palabra 1 puesta en la primera fila de forma horizontal en cualquier posicion       
            for (int j = random; j < this.matriz[0].length; j++) {
                if(letras<palabras.matriz[0][0].length()){
                    this.matriz[0][j]=" |"+Character.toString(palabras.matriz[0][0].charAt(letras)).toUpperCase()+"| ";
                    letras++;
                }else{
                    j=this.matriz[0].length;
                }
            }
        //Colocar todas las demas palabras en forma opuesta    
        int aux=1;        
        
        for (int x = 0; x < palabras.matriz[0].length; x++) {                    
                x = posiciones[0][aux];
            int y = posiciones[1][aux];                                    
            if(aux<palabras.matriz[0].length){
               int a = palabras.matriz[0][aux].length();
               for (int i = 0; i < a; i++) {
                this.matriz[y+i][x]=" |"+Character.toString(palabras.matriz[0][aux].charAt(i)).toUpperCase() + "| ";
               }
               aux++;
               x=0;
            }else{
                x=palabras.matriz[0].length;
            }                                          
        }        
        
        //Inicia el Juego
        do {            
            //Imprimir la sopa de letras
            System.out.print("Puntos: " +jugador.getPuntos()+"\t Errores: "+jugador.getErrores()+"\t Palabras restantes: "+contadorPalabras+"\n");
            for (int i = 0; i < this.matriz.length; i++) {
                for (int j = 0; j < this.matriz[0].length; j++) {
                    System.out.print(this.matriz[i][j]);             
                }
                System.out.println("");            
            }
            System.out.println("Ingrese una palabra dentro de la sopa de letras");
            String palabraAdivinada = entrada.nextLine();
            boolean condicion=true;
            
            for (int i = 0; i < palabras.matriz[0].length; i++) {
                boolean b=palabraAdivinada.equalsIgnoreCase(palabras.matriz[0][i]);
                //Si encuentra la palabra en forma horizontal
                if(b && i==0){                                                                                                                                                             
                    for (int j = random; j < palabras.matriz[0][0].length()+random; j++) {
                        this.matriz[0][j]=" |"+"$"+ "| ";                                
                    }                                                                      
                        condicion=false;
                        System.out.println("Palabra encontrada \n");
                        jugador.agregarPuntos(palabras.matriz[0][0].length());
                        contadorPalabras--;
                }else{
                    //Si encuentra alguna otra palabra
                    if(b){
                        //PALABRA ENCONTRADA SE ELIMINA PALABRA                                                        
                        for (int x = 0; x < palabras.matriz[0].length; x++) {                    
                            int z = posiciones[0][i];
                            int y = posiciones[1][i];                                                                
                            int a = palabras.matriz[0][i].length();
                                for (int j = 0; j < a; j++) {
                                    this.matriz[y+j][z]=" |"+"$"+ "| ";                                
                                }                    
                        }        
                    
                        condicion=false;
                        System.out.println("Palabra encontrada \n");
                        jugador.agregarPuntos(palabras.matriz[0][i].length());
                        contadorPalabras--;
                    }
                }
            }
            if(condicion){
                    //PALABRA NO ENCONTRADA ERROR
                    System.out.println("Palabra no encontrada \n");
                    jugador.agregarError(1);
                    jugador.agregarPuntos(-5);
            }
            
            
        } while (contadorPalabras!=0 && jugador.getErrores()!=3);
        
        if(jugador.getErrores()==3){
            System.out.println("\n FIN DEL JUEGO \n");
            historial.agregarUsuario(1, jugador);
            historial.agregarUsuario(2, jugador);
            
        }else if(contadorPalabras==0){
            System.out.println("\n ¡FELICIDADES ENCONTRASTE TODAS LAS PALABRAS! \n");
            historial.agregarUsuario(1, jugador);
            historial.agregarUsuario(3, jugador);
        }
        
        
    }
            
}
