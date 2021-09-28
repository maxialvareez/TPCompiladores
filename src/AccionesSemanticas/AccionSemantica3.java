package AccionesSemanticas;

import Principal.*;

public class AccionSemantica3 extends Accion {

    public AccionSemantica3() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor--;

        if (Lexico.palabrasReservadas.containsKey(buffer)) {
            System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token de Palabra Reservada -> " + buffer);
            return (new Token(Lexico.palabrasReservadas.get(buffer)));
        }

        else {
                if (buffer.length() > 22) {
                    buffer = buffer.substring(0, 22);
                    System.out.println("Warning: en la linea " + Lexico.linea + " un identificador superó el limite de 22 caracteres, por lo que fue cortado");
                }
                if (!Main.tSimbolos.existeLexema(buffer)) {
                    Main.tSimbolos.agregarSimbolo(buffer, Lexico.IDENTIFICADOR);
                }
                System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token de identificador -> " + buffer);
                return new Token(buffer, Lexico.IDENTIFICADOR);
            }
    }
}