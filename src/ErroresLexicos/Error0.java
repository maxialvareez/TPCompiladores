package ErroresLexicos;
import Principal.*;


public class Error0 extends Accion {
    public Error0() {
    }

    @Override
    public Token ejecutar() {
        System.out.println("[ERROR LEXICO] [Linea "+ Lexico.linea + "] {El caracter que se ingreso es invalido}");
        return null;
    }
}
