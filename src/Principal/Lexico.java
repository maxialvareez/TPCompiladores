package Principal;

import Principal.AccionSemantica;

public class Lexico {

    private int F = 100;

    public static char caracter;
    public static int linea;
    public static int cursor;


    //TOKENS SIN ASCII
    public static final int IDE = 257;
    public static final int CTE_UINT = 258;
    public static final int MAYOR_IGUAL = 259;
    public static final int MENOR_IGUAL = 260;
    public static final int IGUAL_IGUAL = 261;
    public static final int DISTINTO = 262;
    public static final int CTE_DOUBLE = 263;
    public static final int CADENA = 264;


    //PALABRAS RESERVADAS
    public static final int IF = 265;
    public static final int THEN = 266;
    public static final int ENDIF = 267;
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


    private int [][] matrizTransiciones = {

             // L   l   d   E   _   +   -   %   =   <   >   *   :   &   |   .  bl   tb \n  otros
              { 1,  1,  2,  1,  1,  F,  F, 10, 15, 13, 14,  8, 16, 17, 18,  4,  0,  0,  0,  F}, //0
              { 1,  1,  1,  1,  1,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //1
              { F,  F,  2,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  3,  F,  F,  F,  F}, //2
              { F,  F,  F,  F,  F,  5,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //3
              {-1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, //4
              {-1, -1, -1, -1, -1,  6,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, //5
              {-1, -1,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, //6
              { F,  F,  7,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //7
              { F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  9,  F,  F,  F,  F,  F,  F,  F,  F}, //8
              { 9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  9,  0,  9}, //9
              {10, 10, 10, 10, 10, 11, 10,  F, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 10}, //10
              {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1}, //11
              {-1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, //12
              { F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //13
              { F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //14
              { F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //15
              { F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //16
              {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  F, -1, -1, -1, -1, -1, -1}, //17
              {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  F, -1, -1, -1, -1, -1}, //18
    };



    private AccionSemantica[][] matrizAcciones;










}
