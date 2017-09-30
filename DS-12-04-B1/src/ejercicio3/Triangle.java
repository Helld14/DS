package ejercicio3; 

import java.util.Arrays;

/** 
 * Clase que representa a un triangulo. Se trata de una clase inmutable 
 */ 
public class Triangle { 
    /* Atributos */
    private int side0, side1, side2;
    
    /** 
     * Crea un triangulo con los lados especificados. Si el triangulo es 
     * invalido (la suma de dos lados es inferior a la longitud del lado 
     * restante , o alguno de los lados es menor o igual a cero) lanza una excepcion 
     * @param side0 lado 0 
     * @param side1 lado 1 
     * @param side2 lado 2 
     */ 
    public Triangle(int side0 , int side1 , int side2) throws IllegalArgumentException {
        if ((side0<=0) || (side1<=0) || (side2<=0)) 
            throw new IllegalArgumentException();
        else if (side0+side1<side2 || side0+side2<side1 || side1+side2<side0) 
            throw new IllegalArgumentException();
    }

    /** 
     * Constructor de copia , construye un triangulo a partir de otro 
     * @param t Triangulo a partir del cual se construye el nuevo 
     */ 
    public Triangle(Triangle t) {
        this.side0 = t.side0;
        this.side1 = t.side1;
        this.side2 = t.side2;
    }
     
    /** 
     * Devuelve un array con los lados del triangulo 
     * @return Array de 3 posiciones con los lados 
     */      
    public int[] getSides() {
        int[] arr = {this.side0,this.side1,this.side2};
        return(arr);
    }
     
    /** 
     * Devuelve el perimetro del triangulo 
     * @return Valor double que representa el perimetro 
     */      
    public double perimeter() {
        return(this.side0+this.side1+this.side2);
    }
     
    /** 
     * Devuelve el area del triangulo 
     * @return Valor double que representa el area 
     */ 
    public  double  area() {
        double semip = perimeter()/2;
        return Math.sqrt(semip * (semip - side0) * (semip - side1) * (semip - side2));
    }
     
    /** 
     * Decide si el triangulo es igual al objeto que se le pasa por parametro 
     * Dos triangulos son iguales si tienen los mismos lados , independientemente 
     * del orden 
     * @param obj Objeto 
     * @return true si el objeto es un triangulo igual al objeto actual 
     */  
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Triangle) {
            Triangle otro = (Triangle)obj;      //lo convertimos de Object a Triangle
            int[] ladosEste = this.getSides();  //cogemos los lados de este triángulo
            int[] ladosOtro = otro.getSides();  //cogemos los lados del otro triángulo
            
            Arrays.sort(ladosEste);             //ordenamos los arrays para después compararlos
            Arrays.sort(ladosOtro);
            
            return ((ladosEste[0]==ladosOtro[0]) && (ladosEste[1]==ladosOtro[1]) && (ladosEste[2]==ladosOtro[2]));
        }
        else return false;

    }
    
    /** 
     * Devuelve el codigo hash del objeto 
     * @return Valor entero que representa el codigo hash 
     */ 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.side0 + this.side1 + this.side2;
        return hash;
    }
}
