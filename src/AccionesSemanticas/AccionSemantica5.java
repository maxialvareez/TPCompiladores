package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Main;
import Principal.Token;

import java.math.BigDecimal;
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

            String numero = buffer;
            String exponente = buffer;
            double exp;
            double num;
            if (buffer.contains("E")){
                numero = numero.substring(0, numero.indexOf("E"));
                System.out.println("Numero antes de E : " + numero);
                num= Double.parseDouble(numero);
                exponente = exponente.substring(exponente.indexOf("E")+1,exponente.length());
                System.out.println("Numero despues de E : " + exponente);
                exp = Double.parseDouble(exponente);
                exp = Math.pow(10,exp);
                System.out.println("Numerito : " + num);
                System.out.println("Multiplicador: " + exp);

                num = num * exp;
                System.out.println("Resultado: " + num);

                buffer = String.valueOf(num);
                // TODO al usar double el resultado no es exacto. Se deberia usar BigDecimal creo
            }

            Main.tablaSimbolos.agregarSimbolo(buffer,Lexico.CTE_DOUBLE, "DOUBLE");
            return (new Token(buffer, Lexico.CTE_DOUBLE));
        }

        else
            Main.listaErrores.add("[ERROR LEXICO] [Linea " + Lexico.linea + "] {Valor de constante DOUBLE fuera de rango}");
            return null;
    }
}
