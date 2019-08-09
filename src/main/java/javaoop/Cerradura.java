package javaoop;

public class Cerradura {

    Integer clave;
    private boolean cerrada;

    public Cerradura(){
        this.cerrada = true;
    }

    public Cerradura(Integer clave){
        this.clave = clave;
        this.cerrada = true;
    }

    public void abrir(Integer clave){
        if(clave.equals(this.clave)){
            this.cerrada = false;
        }
    }

    public void cerrar(){
        this.cerrada = true;
    }

    public boolean estaCerrada(){
        return cerrada;
    }
}
