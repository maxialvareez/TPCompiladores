package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica14 extends Accion {

    public AccionSemantica14() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico] [Linea " + Lexico.linea + "] {Token detectado} >>  :=");
        return (new Token(Lexico.ASIGNACION));
    }
}
