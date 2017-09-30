package ejercicio3;

import org.junit.*;
import static org.junit.Assert.*;

public class CirculoTest {

    private static Circulo c1;
    private static Circulo c2;
    private static final double delta = 0.001;

    @BeforeClass
    public static void setUpClass() throws Exception {
        c1 = new Circulo(3);
        c2 = new Circulo(20);
    }

    /**
     * Comprobamos que no permite negativos en el radio
     */
    @Test(expected = IllegalArgumentException.class)
    public void creacionIncorrecta1() {
        new Circulo(-1);
    }

    @Test
    public void testArea() {
        assertEquals(28.274, c1.area(), delta);
        assertEquals(1256.637, c2.area(), delta);
    }

    @Test
    public void testPerimetro() {
        assertEquals(18.850, c1.perimetro(), delta);
        assertEquals(125.664, c2.perimetro(), delta);
    }
}
