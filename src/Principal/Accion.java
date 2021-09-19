package Principal;

import Principal.Token;

public abstract class Accion {

    protected String buffer = "";    //Se crea el buffer vacio para luego en caso de ser necesario ir cargandose


    public abstract Token ejecutar();

}
