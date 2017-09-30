package ejercicio4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Clase partido
 */
public class Partido {
    
    private final String ubicacion; /* Establecidos por el constructor */
    private final LocalDate fecha;  /* e inmutables. */
    private String local="", visitante="";
    private int tantosLocales=0, tantosVisitantes=0;
    private EstadoEnum actual = EstadoEnum.EN_ESPERA;   //Creamos clases enumerados SIEMPRE
    
    
    /**
     * Constructor
     * 
     * @param ubicacion                     String
     * @param fecha                         String en formato aaaa-mm-dd
     * @throws IllegalArgumentException     Si la fecha no puede convertirse a LocalDate
     */
    public Partido(String ubicacion, String fecha) throws IllegalArgumentException { 
        actual = EstadoEnum.EN_ESPERA;
        this.ubicacion = ubicacion;
        try {
            this.fecha = LocalDate.parse(fecha);
        }
        catch (DateTimeParseException e) { 
             throw new IllegalArgumentException("No se ha podido convertir la fecha",e); 
        }    
    }
        
    /**
     * Dar nombre a ambos equipos
     * 
     * @param local         String
     * @param visitante     String
     * @throws Exception    Si se intenta realizar en el estado incorrecto
     */
    public void fijarEquipos(String local, String visitante) throws Exception {
        if (actual == EstadoEnum.EN_ESPERA) {
            this.local = local;
            this.visitante = visitante;
            actual = EstadoEnum.NO_JUGADO;
        }
        else throw new Exception("fijarEquipos debe realizarse en estado EN_ESPERA");
    }    
    
    /**
     * Comenzar partido
     * 
     * @throws Exception    Si se intenta realizar en el estado incorrecto
     */
    public void comenzar() throws Exception {
        if (actual == EstadoEnum.NO_JUGADO)
            actual = EstadoEnum.EN_JUEGO;
        else throw new Exception("comenzar debe realizarse en estado NO_JUGADO"); 
    }   
    
    /**
     * Sumar 1 tanto al equipo local
     * 
     * @throws Exception    Si se intenta realizar en el estado incorrecto
     */
    public void tantoLocal() throws Exception {
        if (actual == EstadoEnum.EN_JUEGO)
            tantosLocales++;
        else throw new Exception("tantoLocal debe realizarse en estado EN_JUEGO");
    }
    
    /**
     * Sumar 1 tanto al equipo visitante
     * 
     * @throws Exception    Si se intenta realizar en el estado incorrecto
     */
    public void tantoVisitante() throws Exception {
        if (actual == EstadoEnum.EN_JUEGO)
            tantosVisitantes++;
        else throw new Exception("tantoVisitante debe realizarse en estado EN_JUEGO");
    }    
    
    /**
     * Terminar el partido
     * 
     * @throws Exception    Si se intenta realizar en el estado incorrecto
     */
    public void terminar() throws Exception {
        if (actual == EstadoEnum.EN_JUEGO)
            actual = EstadoEnum.FINALIZADO;
        else throw new Exception("terminar debe realizarse en estado EN_JUEGO");
    }   
    
    /**
     * Devolver nombre del ganador
     * 
     * @return              String con el nombre del ganador o "Empate"
     * @throws Exception    Si se intenta realizar en el estado incorrecto
     */
    public String ganador() throws Exception {
        if (actual == EstadoEnum.FINALIZADO) {
            if (tantosLocales > tantosVisitantes)
                return(local);
            else if (tantosLocales < tantosVisitantes)
                return(visitante);
            else return("Empate");
        }
        else throw new Exception("ganador debe realizarse en estado TERMINADO");
    }
    
    /**
     * Devolver datos del partido
     * 
     * @return 
     */
    public String datos() { 
        switch (actual) {
            case EN_ESPERA  :   return( "Ubicación: "+ubicacion
                                        +"\nFecha: "+String.valueOf(fecha)
                                        +"\nEl partido está en espera, aún no se han concretado los equipos"
                                );
            case NO_JUGADO  :   return( "Ubicación: "+ubicacion
                                        +"\nFecha: "+String.valueOf(fecha)
                                        +"\nEl partido aún no se ha jugado"
                                        +"\nEquipo local: "+local
                                        +"\nEquipo visitante: "+visitante  
                                );
            case EN_JUEGO   :   return( "Ubicación: "+ubicacion
                                        +"\nFecha: "+String.valueOf(fecha)
                                        +"\nEl partido está en juego"
                                        +"\nEquipo local: "+local
                                        +"\nTantos locales: "+tantosLocales
                                        +"\nEquipo visitante: "+visitante
                                        +"\nTantos visitantes: "+tantosVisitantes
                                );
            default :           return( "Ubicación: "+ubicacion                             //ATENCIÓN: ESTE default DEBERIA SER UN case: FINALIZADO
                                        +"\nFecha: "+String.valueOf(fecha)                  //PERO EL TEST FALLARÍA YA QUE NUNCA ENTRARÍA EN EL default
                                        +"\nEl partido ha finalizado"
                                        +"\nEquipo local: "+local
                                        +"\nTantos locales: "+tantosLocales
                                        +"\nEquipo visitante: "+visitante
                                        +"\nTantos visitantes: "+tantosVisitantes
                                );
        }
    }
}
