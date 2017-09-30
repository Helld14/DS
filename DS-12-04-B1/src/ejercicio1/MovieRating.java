package ejercicio1;

public class MovieRating {
    static String[] names = {"Cars 3", "Emoji", "Spiderman", "Dunkerque", "It", "Torrente 6"};
    static int[][] rates = {{5,1,3,2,5}, {4,2,4,2,4}, {3,2,3,5,2}, {5,5,3,3,5}, {3,4,2,2,5}, {1,5,1,5,1}};  
    
    public static double movieRating(String movie) throws Exception {
        double suma=0;
        int j, i=0;
        /* Buscamos la posición de la película en función de su nombre */
        while ((i<6) && (!movie.equals(names[i]))) {
            i++;
        } 
        if (i==6) {
            throw new Exception();
        }
        else {
            /* Sumamos las 5 puntuaciones que obtuvo */
            for (j=0; j<5; j++) {
                suma += rates[i][j];    //asignación compuesta
            }    
            /* Devolvemos la suma dividida entre el total de puntuaciones (media) */
            return (suma/5);
        }
    }
}
