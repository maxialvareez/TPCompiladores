package AccionesSemanticas;

import Principal.*;
public class AccionSemantica8 extends Accion {

    public AccionSemantica8() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token Cadena ->  '" +buffer +"'");
        Main.tSimbolos.agregarSimbolo(buffer, Lexico.CADENA);
        return (new Token(buffer, Lexico.CADENA));

    }
}
