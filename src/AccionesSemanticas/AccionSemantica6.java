package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica6 extends Accion {

    public AccionSemantica6() {
    }

    @Override
    public Token ejecutar() {

        return (new Token((int) Lexico.caracter));
    }
}
