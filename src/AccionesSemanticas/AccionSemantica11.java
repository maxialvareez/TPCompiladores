package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica11 extends Accion {

    public AccionSemantica11() {
    }

    @Override
    public Token ejecutar() {

        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token ->  <>");
        return (new Token(Lexico.DISTINTO));

    }
}
