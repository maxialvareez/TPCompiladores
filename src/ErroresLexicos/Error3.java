package ErroresLexicos;

import Principal.*;

public class Error3 extends Accion {

    public Error3() {
    }

    @Override
    public Token ejecutar() {

        buffer = buffer + Lexico.caracter;   //Se simularia agregar el +. //TODO CONSULTAR
        System.out.println("Warning: en la linea" + Lexico.linea + ": se debe colocar un signo '+' antes y despues de un salto de linea");
        return null;
    }
}
