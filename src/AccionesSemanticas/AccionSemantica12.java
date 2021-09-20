package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica12 extends Accion {

    public AccionSemantica12() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token -> " + Lexico.MAYOR_IGUAL);
        return (new Token(Lexico.MAYOR_IGUAL));
    }
}
