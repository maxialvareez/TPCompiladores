package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica4 extends Accion {

    public AccionSemantica4() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        int valor = Integer.parseInt(buffer);

        if ((valor >= 0) && (valor <= Math.pow(2,32) - 1))
            return (new Token(buffer, Lexico.CTE_UINT));

        else{
            System.out.println("Error Lexico en linea " + Lexico.linea + ": hay un valor de tipo UINT fuera de rango");
            return null;

        }
    }
}


