package ipc1.practica12020;

import java.util.Scanner;


public class IPC1Practica12020 {    
    
    public static void main(String[] args) {
        
        int tamañoMatriz;
        Scanner entrada = new Scanner(System.in);
        Jugador usuario;
        Matriz palabras = new Matriz(1,5);        
        palabras.matriz[0][0]="Javier";
        palabras.matriz[0][1]="Adios";
        palabras.matriz[0][2]="Letras";
        palabras.matriz[0][3]="Helados";
        palabras.matriz[0][4]="Andres";
        String[] abecedario = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O","P","Q","R","S","T","U","V","W","X","Y","Z"};        
        Sopa sopa1;
        Historial historial = new Historial();
        int a = 0;
        do { 
        System.out.println("\n1) Nueva Partida.");
        System.out.println("2) Historial de Partidas.");        
        System.out.println("3) Salir.");
                
        a = Integer.parseInt(entrada.nextLine());
                                                   
        switch(a){
            case 1:
                System.out.println("");
                usuario = new Jugador();
                System.out.println("Ingrese su nombre de usuario");
                usuario.setNombre(entrada.nextLine());
                do{
                    System.out.println("Ingrese el tamaño del tablero");
                    tamañoMatriz = Integer.parseInt(entrada.nextLine());
                    if(tamañoMatriz<=10){
                        System.out.println("El tamaño minimo es: 11, intentelo de nuevo");
                    }
                }while(tamañoMatriz<=10);
                                
                int opcion,opcion2;
                do { 
                    System.out.println("\n"+"1) Menu Palabras");
                    System.out.println("2) Jugar");
                    System.out.println("3) Terminar Partida");
                    opcion = Integer.parseInt(entrada.nextLine());
                
                                                                   
                        switch(opcion){
                            case 1:
                                do {                                                                                                    
                                    System.out.println("\n"+"1) Insertar");
                                    System.out.println("2) Modificar");
                                    System.out.println("3) Eliminar");
                                    System.out.println("4) Salir");
                                    opcion2=Integer.parseInt(entrada.nextLine());
                                        switch(opcion2){
                                            case 1:
                                                //Insertar
                                                System.out.println("\n"+"Ingrese el numero de palabras que desea insertar");
                                                palabras = new Matriz(1,Integer.parseInt(entrada.nextLine()));                                               
                                                palabras = palabras.agregarDato();
                                                opcion2=5;                                                  
                                                break;
                                            case 2:
                                                //Modificar
                                                palabras.modificarDato();
                                                opcion2=5;                                               
                                                break;
                                            case 3:
                                                //Eliminar
                                                palabras = palabras.eliminarDato();
                                                opcion2=5;
                                                break;
                                            case 4:
                                                break;                                                
                                            default:
                                                System.out.println("Opcion Incorrecta intentelo de nuevo"+"\n"); 
                                                break;
                                    }
                                } while (opcion2<0||opcion2>4);
                                                                                                
                                opcion=5;
                                
                                break;
                            case 2:
                                //Jugar                                                                                                                                
                                if(palabras.matriz[0].length==0){
                                    System.out.println("No se han ingresado palabras para jugar");
                                    opcion = 5;
                                }else{                                                                                                            
                                    sopa1 = new Sopa(tamañoMatriz,tamañoMatriz);
                                    palabras=palabras.ordenarMayorMenor(palabras);
                                    //NOTA AGREGAR SOLO UNA PALABRA EN HORIZONTAL O VERTICAL Y TODAS LAS DEMAS EN POSICION OPUESTA
                                    System.out.println("");
                                    sopa1.iniciarSopa(palabras,abecedario,usuario,historial);
                                    a=5;
                                }
                                
                                break;
                            case 3:
                                //Terminar Partida
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Opcion Incorrecta intentelo de nuevo"+"\n");                                 
                                break;
                    }                    
                } while (opcion<0||opcion>3);
                
                break;
            case 2:
                System.out.println("\n1) Mostrar Puntuaciones mas altas.");
                System.out.println("2) Mostrar jugadores que no encontraron todas las palabras.");
                System.out.println("3) Mostrar jugadores que encontraron todas las palabras.");
                System.out.println("4) Mostrar información de estudiante.");
                
                int opcion3 = Integer.parseInt(entrada.nextLine());
                
                    switch(opcion3){
                        case 1:
                            historial.ordenarJugadores();
                            
                            if(historial.getTodosJugadores().length<3 && historial.getTodosJugadores().length!=0){
                                for (int i = 0; i < historial.getTodosJugadores().length; i++) {
                                    System.out.println("\nNombre. \tPuntos.");
                                    System.out.println(historial.getTodosJugadores()[i].getNombre() + "\t"+ historial.getTodosJugadores()[i].getPuntos());
                                }
                            }else if(historial.getTodosJugadores().length == 0){
                                System.out.println("\nNo hay datos");
                            }else{                            
                                for (int i = 0; i < 3; i++) {
                                    System.out.println("\nNombre. \tPuntos.");
                                    System.out.println(historial.getTodosJugadores()[i].getNombre() + "\t"+ historial.getTodosJugadores()[i].getPuntos());
                                }
                            }
                            
                            a=5;
                            break;
                        case 2:                                                       
                            if(historial.getJugadoresPerdedores().length==0){
                                System.out.println("\nNo hay datos");
                            }else{
                                System.out.println("\nNombre.");
                                for (int i = 0; i < historial.getJugadoresPerdedores().length; i++) {                                    
                                    System.out.println(historial.getJugadoresPerdedores()[i].getNombre());
                                }
                            }
                            a=5;
                            break;
                        case 3:
                            if(historial.getJugadoresGanadores().length==0){
                                System.out.println("\nNo hay datos");
                            }else{
                                System.out.println("\nNombre.");
                                for (int i = 0; i < historial.getJugadoresGanadores().length; i++) {                                    
                                    System.out.println(historial.getJugadoresGanadores()[i].getNombre());
                                }
                            }
                            a=5;
                            break;
                        case 4:
                            System.out.println("\nJavier Andres Valdez Gonzalez, Carnet: 201700703, seccion: B");
                            a=5;
                            break;
                    }
                
                break;            
            case 3:
                System.exit(0);
                break;
            default:
                break;
                
        }
    } while (a<0||a>3);
        
    }
    
}
