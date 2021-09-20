package ErroresLexicos;

import Principal.Accion;
import Principal.Token;

public class Error0 extends Accion {
    public Error0() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("El caracter que se ingreso es invalido");
        return null;
    }
}
