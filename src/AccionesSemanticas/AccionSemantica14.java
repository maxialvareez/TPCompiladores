package AccionesSemanticas;

import Principal.*;

public class AccionSemantica14 extends Accion {

    public AccionSemantica14() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token -> " + Lexico.IGUAL_IGUAL);
        return (new Token(Lexico.IGUAL_IGUAL));
    }
}
