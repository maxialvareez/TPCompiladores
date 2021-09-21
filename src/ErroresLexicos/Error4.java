package ErroresLexicos;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class Error4 extends Accion {

    public Error4() {
    }

    @Override
    public Token ejecutar() {

        System.out.println("Warning67 :Se espera un salto de linea despues de un signo '+'");
        buffer += Lexico.caracter;

        return null;
    }
}
