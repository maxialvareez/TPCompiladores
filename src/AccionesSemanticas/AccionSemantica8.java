package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica8 extends Accion {

    public AccionSemantica8() {
    }

    @Override
    public Token ejecutar() {

        return (new Token(buffer, Lexico.CADENA));

    }
}
