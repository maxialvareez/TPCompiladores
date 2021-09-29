package ErroresLexicos;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class Error6 extends Accion {

    public Error6() {
    }

    @Override
    public Token ejecutar() {


        buffer += "|";
        Lexico.cursor --;
        System.out.println("[WARNING] [Linea " + Lexico.linea + "] {Se espera un | y recibe otro caracter]");
        return (new Token(Lexico.OR));
    }
}
