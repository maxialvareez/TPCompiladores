public class Lexico {

    private int F = 100;

    public static char caracter;
    public static int linea;
    public static int cursor;

    //PALABRAS RESERVADAS
    public static final int IF = 0;
    public static final int THEN = 1;
    public static final int ENDIF = 2;
    public static final int PRINT = 3;
    public static final int FUNC = 4;
    public static final int RETURN = 5;
    public static final int BEGIN = 6;
    public static final int END = 7;
    public static final int BREAK = 8;
    public static final int ULONG = 9;
    public static final int DOUBLE = 10;
    public static final int REPEAT = 11;

    //OPERADORES

    public static final int MAS = 12; //si se recibiera un identificador que se llame asi, lo tomaria como una palabra reservada


    //ACCIONES SEMANTICAS

    //ERRORES


    private int [][] matrizTransiciones;

    private AccionSemantica[][] matrizAcciones;



}
