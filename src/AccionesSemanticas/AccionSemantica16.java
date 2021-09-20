package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica16 extends Accion {

    public AccionSemantica16() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token -> " + Lexico.ASIGNACION);
        return (new Token(Lexico.ASIGNACION));
    }
}
