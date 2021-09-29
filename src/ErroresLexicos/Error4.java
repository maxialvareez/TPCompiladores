package ErroresLexicos;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class Error4 extends Accion {

    public Error4() {
    }

    @Override
    public Token ejecutar() {

        System.out.println("[WARNING] [Linea " + Lexico.linea + "] {Se espera un salto de linea después de un signo '+'");
        buffer += Lexico.caracter;

        return null;
    }
}
