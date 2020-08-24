package ipc1.practica12020;

public class Historial{
    private Jugador[] todosJugadores = new Jugador[0];
    private Jugador[] jugadoresPerdedores = new Jugador[0];
    private Jugador[] jugadoresGanadores = new Jugador[0];

    public Jugador[] getTodosJugadores() {
        return todosJugadores;
    }

    public void setTodosJugadores(Jugador[] todosJugadores) {
        this.todosJugadores = todosJugadores;
    }

    public Jugador[] getJugadoresPerdedores() {
        return jugadoresPerdedores;
    }

    public void setJugadoresPerdedores(Jugador[] jugadoresPerdedores) {
        this.jugadoresPerdedores = jugadoresPerdedores;
    }

    public Jugador[] getJugadoresGanadores() {
        return jugadoresGanadores;
    }

    public void setJugadoresGanadores(Jugador[] jugadoresGanadores) {
        this.jugadoresGanadores = jugadoresGanadores;
    }
    
    
    public Historial() {        
    }
   
    public void agregarUsuario(int opcion,Jugador jugador){
        
        switch (opcion) {
            case 1:
                Jugador[] copia = new Jugador[this.todosJugadores.length];
                copia = this.todosJugadores;        
                this.todosJugadores = new Jugador[this.todosJugadores.length+1];
        
                    for (int i = 0; i < copia.length; i++) {
                        this.todosJugadores[i]=copia[i];
                    }
        
                this.todosJugadores[copia.length]=jugador;
                break;
            case 2:
                copia = new Jugador[this.jugadoresPerdedores.length];
                copia = this.jugadoresPerdedores;        
                this.jugadoresPerdedores = new Jugador[this.jugadoresPerdedores.length+1];
        
                    for (int i = 0; i < copia.length; i++) {
                        this.jugadoresPerdedores[i]=copia[i];
                    }
        
                this.jugadoresPerdedores[copia.length]=jugador;
                break;
            case 3:
                copia = new Jugador[this.jugadoresGanadores.length];
                copia = this.jugadoresGanadores;        
                this.jugadoresGanadores = new Jugador[this.jugadoresGanadores.length+1];
        
                    for (int i = 0; i < copia.length; i++) {
                        this.jugadoresGanadores[i]=copia[i];
                    }
        
                this.jugadoresGanadores[copia.length]=jugador;
                break;
            default:
                throw new AssertionError();
        }                
    }
    
    public void ordenarJugadores(){
        for (int i = 0; i < this.todosJugadores.length; i++) {
            if(this.todosJugadores.length==1){
                
            }else{
            if(i<this.todosJugadores.length-1){
                if(this.todosJugadores[i].getPuntos()<this.todosJugadores[i+1].getPuntos()){
                    Jugador copia = new Jugador();
                    copia = this.todosJugadores[i];
                    this.todosJugadores[i]=this.todosJugadores[i+1];
                    this.todosJugadores[i+1]=copia;                    
                    i=0;
                }
            }else{
                if(this.todosJugadores[i-1].getPuntos()<this.todosJugadores[i].getPuntos()){
                    Jugador copia = new Jugador();
                    copia = this.todosJugadores[i-1];
                    this.todosJugadores[i-1]=this.todosJugadores[i];
                    this.todosJugadores[i]=copia;                    
                    i=0;
                }
            }
        }
        }
            
    }       
    
}
