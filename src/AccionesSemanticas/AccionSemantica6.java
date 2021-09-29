package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica6 extends Accion {

    public AccionSemantica6() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico] [Linea " + Lexico.linea + "] {Se detectó un token de un caracter} >> " + Lexico.caracter);
        return (new Token( Lexico.caracter));
    }
}
