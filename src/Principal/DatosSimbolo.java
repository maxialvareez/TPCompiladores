package Principal;

public class DatosSimbolo {
    private int id;  // Para buscar en palabras reservadas
    private String tipo;
    private String uso;  //indica a que hace referencia un identificador (podria ser una funcion, una variable)
    private String funcionReferenciada;
    private String parametro;  //en caso de ser funcion
    //dudas
    private boolean parametroRef;


    public DatosSimbolo() {
        this.id = 0;
        this.tipo = null;
        this.uso = null;
        this.parametroRef = false;
        this.funcionReferenciada = "";
        this.parametro = "";
    }


    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUso() {
        return uso;
    }

    public boolean isParametroRef() {
        return parametroRef;
    }

    public DatosSimbolo setId(int id) {
        this.id = id;
        return this;
    }

    public DatosSimbolo setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public DatosSimbolo setUso(String uso) {
        this.uso = uso;
        return this;
    }

    public DatosSimbolo setParametroRef(boolean parametroRef) {
        this.parametroRef = parametroRef;
        return this;
    }


}
