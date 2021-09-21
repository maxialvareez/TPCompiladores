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
            System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token de tipo Double -> " + buffer);
            Main.tSimbolos.agregarSimbolo(buffer,Lexico.CTE_DOUBLE);
            return (new Token(buffer, Lexico.CTE_DOUBLE));
        }

        else
            System.out.println("Error Lexico en linea " + Lexico.linea + ": valor de constante DOUBLE fuera de rango");
            return null;
    }
}
