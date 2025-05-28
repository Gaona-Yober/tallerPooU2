import java.util.Date;

public class Viaje {
    private float distanciaRecorrida;
    private Date fechaInicio;
    private Date fechaFin;








    public void costoViaje(Vehiculo v){
        float costo;
        costo = distanciaRecorrida * v.precioCombustible;
    }

}
