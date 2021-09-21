package AccionesSemanticas;

import Principal.*;

public class AccionSemantica13 extends Accion {

    public AccionSemantica13() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token ->  ==");
        return (new Token(Lexico.IGUAL_IGUAL));
    }
}
