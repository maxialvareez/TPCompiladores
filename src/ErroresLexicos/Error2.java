package ErroresLexicos;

import Principal.*;

public class Error2 extends Accion {

    public Error2() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        Main.listaErrores.add("[ERROR LEXICO] [Linea " +Lexico.linea + "] {Se espera un digito, un '+' , o un '-' y recibe otro caracter}");
        return null;
    }
}
