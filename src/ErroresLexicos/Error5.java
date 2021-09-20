package ErroresLexicos;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class Error5 extends Accion {

    public Error5() {
    }

    @Override
    public Token ejecutar() {

        buffer += "&";
        Lexico.cursor --;
        System.out.println("Warning:Se espera un & y recibe otra cosa");
        return (new Token(Lexico.AND));
    }
}
