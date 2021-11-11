package AccionesSemanticas;

import Principal.*;

public class AccionSemantica4 extends Accion {

    public AccionSemantica4() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        int valor = Integer.parseInt(buffer);

        if ((valor >= 0) && (valor <= Math.pow(2,32) - 1)) {
            System.out.println("[Lexico] [Linea " + Lexico.linea + "] {Se detectó un token de tipo Entero Largo Sin Signo} >> " + buffer);
            Main.tablaSimbolos.agregarSimbolo(buffer,Lexico.CTE_ULONG);
            return (new Token(buffer, Lexico.CTE_ULONG));
        }
        else{
            System.out.println("[ERROR LEXICO] [Linea " + Lexico.linea + "] {Valor de tipo UINT fuera de rango}");
            return null;

        }
    }
}


