package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

import java.util.Locale;

public class AccionSemantica5 extends Accion {

    public AccionSemantica5() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor--;
        double valor = Double.parseDouble(buffer);
        if ((valor > 2.2250738585072014E-308 && valor < 1.7976931348623157E+308) || (valor > -1.7976931348623157E+308 && valor < -2.2250738585072014E-308) || (valor == 0.0)) {
            System.out.println("[Lexico] [Linea " + Lexico.linea + "] {Se detectó un token de tipo Double} >> " + buffer);

            Main.tablaSimbolos.agregarSimbolo(buffer,Lexico.CTE_DOUBLE, "DOUBLE");
            return (new Token(buffer, Lexico.CTE_DOUBLE));
        }

        else
            Main.listaErrores.add("[ERROR LEXICO] [Linea " + Lexico.linea + "] {Valor de constante DOUBLE fuera de rango}");
            return null;
    }
}
