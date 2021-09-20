package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica18 extends Accion {

    public AccionSemantica18() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token -> " + Lexico.AND);
        return (new Token(Lexico.AND));
    }
}
