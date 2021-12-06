package ErroresLexicos;

import Principal.*;



public class Error4 extends Accion {

    public Error4() {
    }

    @Override
    public Token ejecutar() {

        Main.listaWarnings.add("[WARNING] [Linea " + Lexico.linea + "] {Se espera un salto de linea después de un signo '+'");
        buffer += Lexico.caracter;

        return null;
    }
}
