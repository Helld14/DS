package ejercicio4;

import org.junit.*;
import static org.junit.Assert.*;

public class PartidoTest {
    private static Partido P, PE, P1, P2, P3;
    
    /*
     * Inicializamos las instancias que vamos a utilizar 
     */
    @BeforeClass
    public static void setUpClass() throws Exception {
        P1 = new Partido("Camp Nou","2010-04-28");
        P2 = new Partido("Camp Nou","2010-04-28");
        P3 = new Partido("Camp Nou","2010-04-28");  
        PE = new Partido("Camp Nou","2010-04-28"); 
    }
    
    /*
     * Comprobamos que el constructor no permite introducir una fecha mal.
     */
    @Test(expected = IllegalArgumentException.class)
    public void creacionIncorrecta() throws IllegalArgumentException {
        P = new Partido("Camp Nou","28-04-2010");
    }
    
    /*
     * Comprobamos que cada uno de los métodos no permite realizar ciertas 
     * operaciones en el estado incorrecto.
     */
    @Test(expected = Exception.class)
    public void testException1() throws Exception {
        PE.ganador();
    }
    @Test(expected = Exception.class)
    public void testException2() throws Exception {
        PE.terminar();    
    } 
    @Test(expected = Exception.class)
    public void testException3() throws Exception {
        PE.tantoVisitante();
    }   
    @Test(expected = Exception.class)
    public void testException4() throws Exception {
        PE.tantoLocal();
    }
    @Test(expected = Exception.class)
    public void testException5() throws Exception {
        PE.comenzar();
    }    
    @Test(expected = Exception.class)
    public void testException6() throws Exception {
        PE.fijarEquipos("Barça","Depor");
        PE.fijarEquipos("Depor","Barça");  //no se pueden volver a fijar
    }
    
    /*
     * Comprobamos los datos del partido en el que empatan ambos equipos.
     */
    @Test
    public void testPartido1() throws Exception {
        /* 
         * En el estado EN_ESPERA
         */
        assertEquals( "Ubicación: Camp Nou"                   
                    + "\nFecha: 2010-04-28"
                    + "\nEl partido está en espera, aún no se han concretado los equipos"
                    , P1.datos());
        /* 
         * En el estado NO_JUGADO
         */
        P1.fijarEquipos("Barça","Depor");                       
        assertEquals( "Ubicación: Camp Nou"
                    + "\nFecha: 2010-04-28"
                    + "\nEl partido aún no se ha jugado"
                    + "\nEquipo local: Barça"
                    + "\nEquipo visitante: Depor" 
                    , P1.datos()
        );
        /* 
         * En el estado EN_JUEGO
         */
        P1.comenzar();                                          
        P1.tantoLocal();
        P1.tantoVisitante();
        assertEquals( "Ubicación: Camp Nou"
                    + "\nFecha: 2010-04-28"
                    + "\nEl partido está en juego"
                    + "\nEquipo local: Barça"
                    + "\nTantos locales: 1"
                    + "\nEquipo visitante: Depor"
                    + "\nTantos visitantes: 1"
                    , P1.datos()
        );
        /* 
         * En el estado FINALIZADO
         */
        P1.terminar();                                          
        assertEquals( "Ubicación: Camp Nou"
                    + "\nFecha: 2010-04-28"
                    + "\nEl partido ha finalizado"
                    + "\nEquipo local: Barça"
                    + "\nTantos locales: 1"
                    + "\nEquipo visitante: Depor"
                    + "\nTantos visitantes: 1"
                    , P1.datos()
        );
        assertEquals("Empate",P1.ganador());
    }
    
    /*
     * Comprobamos los datos del partido en el que gana el equipo local.
     */
    @Test
    public void testPartido2() throws Exception { 
        P2.fijarEquipos("Barça","Depor");  
        P2.comenzar();                                          
        P2.tantoLocal();
        P2.terminar();                                          
        assertEquals("Barça",P2.ganador());
    }
    
    /*
     * Comprobamos los datos del partido en el que gana el equipo visitante.
     */
    @Test
    public void testPartido3() throws Exception {
        P3.fijarEquipos("Barça","Depor");  
        P3.comenzar();                                          
        P3.tantoVisitante();
        P3.terminar();                                          
        assertEquals("Depor",P3.ganador());
    }
}
