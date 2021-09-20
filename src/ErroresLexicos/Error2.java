package ErroresLexicos;

import Principal.Accion;
import Principal.Lexico;
import Principal.Token;

public class Error2 extends Accion {

    public Error2() {
    }

    @Override
    public Token ejecutar() {
        Lexico.cursor --;
        System.out.println("Se espera un digito, un '+' , o un '-' y recibe otro caracter");
        return null;
    }
}
