package ErroresLexicos;

import Principal.Accion;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

public class Error1 extends Accion {

    public Error1() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        Main.listaErrores.add("[ERROR LEXICO] [Linea " + Lexico.linea + "] {Se espera un digito pero se recibe un caracter que no lo es}");
        return null;
    }
}
