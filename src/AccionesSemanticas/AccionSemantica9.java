package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica9 extends Accion {

    public AccionSemantica9() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico'] [Linea " + Lexico.linea + "] {Token detectado} >>  <= ");
        return (new Token(Lexico.MENOR_IGUAL));
    /*
        if (buffer == "<=")
            return (new Token(Lexico.MENOR_IGUAL));

        if (buffer == ">=")
            return (new Token(Lexico.MAYOR_IGUAL));

        if (buffer == ":=")
            return (new Token(Lexico.ASIGNACION));

        if (buffer == "<>")
            return (new Token (Lexico.DISTINTO));

        if (buffer == "==")
            return (new Token(Lexico.IGUAL_IGUAL));

        return null;
    */
    }
}
