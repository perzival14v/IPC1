
package ipc1.practica12020;


public class Jugador {
    
    private String nombre;
    private int puntos=20;
    private int errores=0;    
    
    public Jugador() {
        this.puntos=20;
        this.errores=0;
    }
    
    public void agregarPuntos(int puntos) {
        this.puntos = this.puntos + puntos;
    }
    
    public void agregarError(int error){
        this.errores= this.errores + error;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = this.puntos + puntos;
    }
    
    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }
}
