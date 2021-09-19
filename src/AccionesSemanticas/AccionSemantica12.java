package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica12 extends Accion {

    public AccionSemantica12() {
    }

    @Override
    public Token ejecutar() {

        return (new Token(Lexico.MAYOR_IGUAL));
    }
}
