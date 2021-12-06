package ErroresLexicos;

import Principal.*;



public class Error6 extends Accion {

    public Error6() {
    }

    @Override
    public Token ejecutar() {


        buffer += "|";
        Lexico.cursor --;
        Main.listaWarnings.add("[WARNING] [Linea " + Lexico.linea + "] {Se espera un | y recibe otro caracter]");
        return (new Token(Lexico.OR));
    }
}
