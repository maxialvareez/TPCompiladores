package AccionesSemanticas;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class AccionSemantica10 extends Accion {
//Caracter que pudo ser combinado con otro y no lo fue

    public AccionSemantica10() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        return (new Token ((int) Lexico.caracter));   // Retorna el codigo ASCII del caracter leido
    }
}
