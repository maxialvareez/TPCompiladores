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
        System.out.println("Warning:Se espera un | y recibe otra cosa");
        return (new Token(Lexico.OR));
    }
}
