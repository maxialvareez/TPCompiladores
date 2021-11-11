package AccionesSemanticas;

import Principal.*;

public class AccionSemantica3 extends Accion {

    public AccionSemantica3() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor--;

        if (Lexico.palabrasReservadas.containsKey(buffer)) {
            System.out.println("[Lexico] [Linea " + Lexico.linea + "] {Se detectó un token de tipo Palabra Reservada} >> " + buffer);
            return (new Token(Lexico.palabrasReservadas.get(buffer)));
        }

        else {
                if (buffer.length() > 22) {
                    buffer = buffer.substring(0, 22);
                    System.out.println("[WARNING] [Linea " + Lexico.linea + "] {Un identificador superó el limite de 22 caracteres, por lo que fue cortado}");
                }
                if (!Main.tablaSimbolos.existeLexema(buffer)) {
                    Main.tablaSimbolos.agregarSimbolo(buffer, Lexico.IDENTIFICADOR);
                }
                System.out.println("[Lexico] [Linea " + Lexico.linea + "] {Se detectó un token de tipo Identificador} >> " + buffer);
                return new Token(buffer, Lexico.IDENTIFICADOR);
            }
    }
}