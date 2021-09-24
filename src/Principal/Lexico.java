package Principal;


import AccionesSemanticas.*;
import ErroresLexicos.*;

import java.util.Hashtable;

public class Lexico {

    private int F = 100;

    public static StringBuilder codigoFuente;
    public static char caracter;
    public static int linea;
    public static int cursor;
    public static Hashtable<String,Integer> palabrasReservadas;

    //TOKENS SIN ASCII
    public static final int IDE = 257;
    public static final int CTE_UINT = 258;
    public static final int MAYOR_IGUAL = 259; // >=
    public static final int MENOR_IGUAL = 260; // <=
    public static final int IGUAL_IGUAL = 261; // ==
    public static final int DISTINTO = 262;   // <>
    public static final int ASIGNACION = 263; // :=
    public static final int CTE_DOUBLE = 264;
    public static final int CADENA = 265;
    public static final int AND = 266;  // &&
    public static final int OR = 267; // ||


    //PALABRAS RESERVADAS
    public static final int IF = 268;
    public static final int THEN = 269;
    public static final int ENDIF = 270;
    public static final int PRINT = 271;
    public static final int FUNC = 272;
    public static final int RETURN = 273;
    public static final int BEGIN = 274;
    public static final int END = 275;
    public static final int BREAK = 276;
    public static final int ULONG = 277;
    public static final int DOUBLE = 278;
    public static final int REPEAT = 279;
    public static final int PRE = 280;
    public static final int TRY = 281;
    public static final int CATCH = 282;
    public static final int TYPEDEF = 283;
    public static final int UINT = 284;
    public static final int ENDREPEAT = 285;

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
    Accion as13 = new AccionSemantica13();
    Accion as14 = new AccionSemantica14();
    Accion as15 = new AccionSemantica15();
    Accion as16 = new AccionSemantica16();


    //ERRORES

    Accion err1 = new Error1();
    Accion err2 = new Error2();
    Accion err3 = new Error3();
    Accion err4 = new Error4();
    Accion err5 = new Error5();
    Accion err6 = new Error6();


    private int [][] matrizTransiciones = {
             // 0   1   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16  17  18  19
             // L   l   d   E   _   +   -   %   =   <   >   *   :   &   |   .  bl  tb  \n  otros
              { 1,  1,  2,  1,  1,  F,  F, 10, 15, 13, 14,  8, 16, 17, 18,  4,  0,  0,  0,  F}, //0
              { 1,  1,  1,  1,  1,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //1
              { F,  F,  2,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  3,  F,  F,  F,  F}, //2
              { F,  F,  3,  5,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F,  F}, //3
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
            // 0     1     2     3     4     5     6     7    8     9    10    11    12    13     14    15   16     17    18    19
            // L     l     d     E     _     +     -     %    =     <     >     *     :     &      |     .   bl     tb    \n    otros
            { as1,  as1,  as1,  as1,  as1,  as6,  as6, as10, null, null, null, null, null, null, null,  as1, null, null, null,  as6}, //0
            { as2,  as2,  as2,  as2,  as2,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3,  as3}, //1
            { as4,  as4,  as2,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as4,  as2,  as4,  as4,  as4,  as4}, //2
            { as5,  as5,  as2,  as2,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5}, //3
            {err1, err1,  as2, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1}, //4
            {err2, err2,  as2, err2, err2,  as2,  as2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2, err2}, //5
            {err1, err1,  as2, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1, err1}, //6
            { as5,  as5,  as2,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5,  as5}, //7
            { as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7, null,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7}, //8
            {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, //9
            { as2,  as2,  as2,  as2,  as2, null,  as2,  as8,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2,  as2, err3,  as2}, //10
            {err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, err4, null, err4}, //11
            {err3, err3, err3, err3, err3, null, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3, err3}, //12
            { as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,   as9, as7, as11,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7}, //13
            { as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7, as12,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7}, //14
            { as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7, as13,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7}, //15
            { as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7, as14,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7,  as7}, //16
            {err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, err5, as15, err5, err5, err5, err5, err5, err5}, //17
            {err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, err6, as16, err6, err6, err6, err6, err6}, //18
    };

    public Lexico(StringBuilder codigo) {


        linea = 1;
        cursor = 0;
        this.codigoFuente = codigo;

        caracter = codigoFuente.charAt(cursor);

        palabrasReservadas = new Hashtable<>();
        palabrasReservadas.put("IF",IF);
        palabrasReservadas.put("THEN",THEN);
        palabrasReservadas.put("ENDIF",ENDIF);
        palabrasReservadas.put("PRINT",PRINT);
        palabrasReservadas.put("FUNC",FUNC);
        palabrasReservadas.put("RETURN",RETURN);
        palabrasReservadas.put("BEGIN",BEGIN);
        palabrasReservadas.put("END",END);
        palabrasReservadas.put("BREAK",BREAK);
        palabrasReservadas.put("ULONG",ULONG);
        palabrasReservadas.put("DOUBLE",DOUBLE);
        palabrasReservadas.put("REPEAT",REPEAT);
        palabrasReservadas.put("PRE",PRE);
        palabrasReservadas.put("TRY",TRY);
        palabrasReservadas.put("CATCH",CATCH);
        palabrasReservadas.put("TYPEDEF",TYPEDEF);
        palabrasReservadas.put("UINT",UINT);
        palabrasReservadas.put ("ENDREPEAT", ENDREPEAT);

    }


    public Token getToken() {
        int estadoActual = 0;
        int columna = -1;
        Token token = null;

        while ( (cursor < codigoFuente.length())) { // Mientras no llegue al final del código fuente.
            caracter = codigoFuente.charAt(cursor);
            cursor++;
            columna = getColumna(caracter);
            if (columna != -1) { // Si no es un caracter inválido
                if (matrizAcciones[estadoActual][columna] != null) // Acción semántica
                    token = matrizAcciones[estadoActual][columna].ejecutar();
                estadoActual = matrizTransiciones[estadoActual][columna];
                if ((estadoActual == F) && (token != null))// Si llegue a final y hay un token que retornar
                    return token;
                else if (estadoActual == -1)
                    return token;
                if (estadoActual == F)
                    estadoActual = 0;
            } else {
                return new Error0().ejecutar(); // Error caracter inválido
            }
            if (caracter == '\n')
                linea++;
        }
        return new Token(0); // Token = 0 de fin de archivo
    }

    private int getColumna(char caracter) {


        if (caracter == 69)
            return 3 ; // 'E'
        if ((caracter >= 65) && (caracter <= 90))
            return 0; // Letras Mayúsculas
        if ((caracter >= 97) && (caracter <= 122))
            return 1; // Letras Minúsculas
        if ((caracter >= 48) && (caracter <= 57))
            return 2; // Dígitos
        if (caracter == 95)
            return 4; // _
        if (caracter == 43)
            return 5; // +
        if (caracter == 45)
            return 6; // -
        if (caracter == 37)
            return 7; // %
        if (caracter == 61)
            return 8; // =
        if (caracter == 60)
            return 9; // <
        if (caracter == 62)
            return 10; // >
        if (caracter == 42)
            return 11; //*
        if (caracter == 58)
            return 12; //:
        if (caracter==38)
            return 13; //&
        if (caracter == 124)
            return 14; //|
        if (caracter == 46)
            return 15; // .
        if ((caracter == 32))
            return 16; // Blanco
        if (caracter == 9)
            return 17; // TAB
        if (caracter == 10 )
            return 18; // \n
        if (caracter == 34 || caracter == 44 || caracter == 47 || caracter == 41 || caracter == 40 || caracter == 123 || caracter == 125 || caracter == 59 ||caracter == 33)
            return 19; // 'Otros'

        return -1; // Caracter no válido.
    }
}




