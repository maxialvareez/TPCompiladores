package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica7 extends Accion {

    public AccionSemantica7() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        char valor = Lexico.codigoFuente.charAt(Lexico.cursor -1);
        System.out.println("[Lexico | Linea " + Lexico.linea + "] Se detecto un token ->  " + valor);
        return(new Token (valor));

    }
}
