package ejercicio2;

import org.junit.*;
import static org.junit.Assert.*;

public class SubstitutionCipherTest {
    private static SubstitutionCipher cipher = new SubstitutionCipher();
    
    @Test
    public void testSubstitutionCipher() {
        // Prueba de "encode"
        assertEquals("¡¡Mkñyxkjy kv Lkvóx!!",cipher.encode(10,"¡¡Cañonazo al Balón!!"));
        assertEquals("UVWXYZABCDEFGHIJKLMNOPQRST",cipher.encode(20,"ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("uvwxyzabcdefghijklmnopqrst",cipher.encode(20,"abcdefghijklmnopqrstuvwxyz"));
        // Prueba de "decode"
        assertEquals("¡¡Cañonazo al Balón!!",cipher.decode(10,"¡¡Mkñyxkjy kv Lkvóx!!"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",cipher.decode(20,"UVWXYZABCDEFGHIJKLMNOPQRST"));
        assertEquals("abcdefghijklmnopqrstuvwxyz",cipher.decode(20,"uvwxyzabcdefghijklmnopqrst"));  
    }  
}
