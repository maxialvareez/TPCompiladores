package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica11 extends Accion {

    public AccionSemantica11() {
    }

    @Override
    public Token ejecutar() {

        return (new Token(Lexico.DISTINTO));

    }
}
