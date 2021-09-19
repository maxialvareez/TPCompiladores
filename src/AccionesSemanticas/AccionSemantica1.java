package AccionesSemanticas;


import Principal.*;


public class AccionSemantica1 extends Accion {

    public AccionSemantica1() {
    }

    @Override
    public Token ejecutar() {
        buffer = Character.toString(Lexico.caracter);
        return null;
    }
}
