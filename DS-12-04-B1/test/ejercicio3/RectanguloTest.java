package ejercicio3;

import org.junit.*;
import static org.junit.Assert.*;

public class RectanguloTest {

    private static Rectangulo r1;
    private static Rectangulo r2;
    private static final double delta = 0.001;

    @BeforeClass
    public static void setUpClass() throws Exception {
        r1 = new Rectangulo(3, 5);
        r2 = new Rectangulo(20, 45);
    }

    /**
     * Comprobamos que no permite negativos en el primer argumento
     */
    @Test(expected = IllegalArgumentException.class)
    public void creacionIncorrecta1() {
        new Rectangulo(-1, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void creacionIncorrecta2() {
        new Rectangulo(3, -2);
    }

    @Test
    public void testArea() {
        assertEquals(15d, r1.area(), delta);
        assertEquals(900d, r2.area(), delta);
    }

    @Test
    public void testPerimetro() {
        assertEquals(16d, r1.perimetro(), delta);
        assertEquals(130d, r2.perimetro(), delta);
    }
}
