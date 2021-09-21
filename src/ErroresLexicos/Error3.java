package ErroresLexicos;

import Principal.*;

public class Error3 extends Accion {

    public Error3() {
    }

    @Override
    public Token ejecutar() {

        System.out.println("Error Lexico: en la linea " + Lexico.linea + ": se debe colocar un signo '+' antes y despues de un salto de linea");
        Lexico.cursor --;
        while (Lexico.codigoFuente.charAt(Lexico.cursor) != '%')      //Desecha la cadena completa
            Lexico.cursor ++;

        Lexico.cursor ++;
        return null;


    }
}
