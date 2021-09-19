package AccionesSemanticas;

import Principal.*;

public class AccionSemantica2 extends Accion {

    public AccionSemantica2() {
    }

    @Override
    public Token ejecutar() {
        buffer = buffer + Lexico.caracter;
        return null;
    }
}
