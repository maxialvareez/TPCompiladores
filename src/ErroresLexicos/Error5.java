package ErroresLexicos;

import Principal.*;



public class Error5 extends Accion {

    public Error5() {
    }

    @Override
    public Token ejecutar() {

        buffer += "&";
        Lexico.cursor --;
        Main.listaWarnings.add("[WARNING] [Linea " + Lexico.linea + "] {Se espera un & y recibe otro caracter}");
        return (new Token(Lexico.AND));
    }
}
