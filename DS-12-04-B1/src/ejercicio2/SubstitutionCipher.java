package ejercicio2;

public class SubstitutionCipher {
    
    private int suma(int c, int n) {
    /* Suma en módulo 26: c es un número del 0 al 25 */
        int total = c+n;
        if (total > 25)
            total -= 26;
        return (total);
    }
    
    private int resta(int c, int n) {
    /* Resta en módulo 26: c es un número del 0 al 25 */
        int total = c-n;
        if (total < 0)
            total += 26;
        return (total);
    }
    
    public String encode(int key, String text) {
        StringBuilder text2 = new StringBuilder(); 
        char c;
        int i;
        for (i=0; i<text.length(); i++) {
            c = text.charAt(i); //devuelve el carácter de cierta posición
            if (('A'<=c) && (c<='Z')) 
                text2.insert(i,(char)(suma(c-'A',key)+'A'));   
                /* Devuleve c más el desplazamiento 'key' en módulo 26, es 
                   decir, después de la 'Z' vuelve a empezar por la 'A' */  
            else if (('a'<=c) && (c<='z'))
                text2.insert(i,(char)(suma(c-'a',key)+'a')); 
                /* Lo mismo para las minúsculas: recibe la diferencia entre 'a' 
                   y 'c' (de 0 a 25), suma y devuelve un nuevo número de 0 a 25 
                   que indica la posición de la nueva letra respecto a la 'a' */   
            else {text2.insert(i,c); }
            /* Si es un carácter especial lo inserta sin más */
       }
        return(text2.toString());
    }
    
    public String decode(int key, String text) {
        StringBuilder text2 = new StringBuilder(); 
        char c;
        int i;
        for(i=0; i<text.length(); i++) {
            c = text.charAt(i);
            if (('A'<=c) && (c<='Z')) //mayúsculas
                text2.insert(i,(char)(resta(c-'A',key)+'A')); //resta en módulo 26 
            else if (('a'<=c) && (c<='z')) //minúsculas
                text2.insert(i,(char)(resta(c-'a',key)+'a')); //resta en módulo 26     
            else text2.insert(i,c); //carácter especial
        }
        return(text2.toString());
    }
}
