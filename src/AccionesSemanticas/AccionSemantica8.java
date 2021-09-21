package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica8 extends Accion {

    public AccionSemantica8() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token Cadena -> " +"Contenido: " +buffer +" -- con id:" +Lexico.CADENA);
        return (new Token(buffer, Lexico.CADENA));

    }
}
