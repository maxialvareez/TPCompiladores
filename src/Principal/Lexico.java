package Principal;


import AccionesSemanticas.*;
import Errores.*;

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

    Accion as1 = new AccionSemantica1();
    Accion as2 = new AccionSemantica2();
    Accion as3 = new AccionSemantica3();
    Accion as4 = new AccionSemantica4();
    Accion as5 = new AccionSemantica5();
    Accion as6 = new AccionSemantica6();
    Accion as7 = new AccionSemantica7();
    Accion as8 = new AccionSemantica8();
    Accion as9 = new AccionSemantica9();
    Accion as10 = new AccionSemantica10();
    Accion as11 = new AccionSemantica11();
    Accion as12 = new AccionSemantica12();


    //ERRORES

    Accion err1 = new Error1();
    Accion err2 = new Error2();
    Accion err3 = new Error3();
    Accion err4 = new Error4();
    Accion err5 = new Error5();
    Accion err6 = new Error6();


    private int [][] matrizTransiciones = {

             // L   l   d   E   _   +   -   %   =   <   >   *   :   &   |   .  bl   tb \n  otros
              { 1,  1,  2,  1,  1,  F,  F, 10, 15, 13, 14,  8, 16, 17, 18,  4,  0,  0,  0,  F}, //0
              { 1,  1,  1,  1,  1,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //1
              { F,  F,  2,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  3,  F,  F,  F,  F}, //2
              { F,  F,  F,  F,  F,  5,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //3
              {-1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, //4
              {-1, -1,  7, -1, -1,  6,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, //5
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



    private Accion[][] matrizAcciones = {

            // L     l     d     E     _     +     -     %    =     <     >     *     :     &      |     .   bl     tb    \n    otros
            { as1,  as1,  as1,  as1,  as1,  as6,  as6,  as1, null, null, null, null, null, null, null,  as6, null, null, null,  as6}, //0
            { as2,  as2,  as2,  as2,  as2,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3}, //1
            { as4,  as4,  as2,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as2,  as4,  as4,  as4,  as4}, //2
            { as5,  as5,  as2,  as2,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5}, //3
            {err1, err1,  as2, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1}, //4
            {err2, err2,  as2, err2, err2,  as2,  as2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2}, //5
            {err1, err1,  as2, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1}, //6
            { as5,  as5,  as2,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5}, //7
            { as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7, null,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7}, //8
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, //9
            { as2,  as2,  as2,  as2,  as2, null,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2, err3,  as2}, //10
            {err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4,  as2, err4}, //11
            {err3, err3, err3, err3, err3, null, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3}, //12
            {as10, as10, as10, as10, as10, as10, as10, as10,  as9, as10, as11, as10, as10, as10, as10, as10, as10, as10, as10, as10}, //13
            {as13, as13, as13, as13, as13, as13, as13, as13, as12, as13, as13, as13, as13, as13, as13, as13, as13, as13, as13, as13}, //14
            {as15, as15, as15, as15, as15, as15, as15, as15, as14, as15, as15, as15, as15, as15, as15, as15, as15, as15, as15, as15}, //15
            {as17, as17, as17, as17, as17, as17, as17, as17, as16, as17, as17, as17, as17, as17, as17, as17, as17, as17, as17, as17}, //16
            {err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, as18, err5, err5, err5, err5, err5, err5}, //17
            {err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, as19, err6, err6, err6, err6, err6}, //18
    };










}
