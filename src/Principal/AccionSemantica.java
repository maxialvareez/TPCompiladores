package Principal;

public abstract class AccionSemantica {

    private String buffer = "";    //Se crea el buffer vacio para luego en caso de ser necesario ir cargandose


    public abstract Token ejecutar();

}
