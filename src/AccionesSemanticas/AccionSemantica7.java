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
        return(new Token (Lexico.codigoFuente.charAt(Lexico.cursor -1)));   //PROBAR SI FUNCIONA

    }
}
