package Principal;

public class DatosSimbolo {
    private int id;  // Para buscar en palabras reservadas
    private String tipo;
    private String uso;  //indica a que hace referencia un identificador (podria ser una funcion, una variable)
    private String parametro;  //en caso de ser funcion
    private boolean typeDef;
    private String funcionReferenciada;



    public DatosSimbolo() {
        this.id = 0;
        this.tipo = null;
        this.uso = null;
        this.parametro = "";
        this.typeDef = false;
        this.funcionReferenciada = "";

    }

    public String getFuncionReferenciada() {
        return funcionReferenciada;
    }

    public DatosSimbolo setFuncionReferenciada(String funcionReferenciada) {
        this.funcionReferenciada = funcionReferenciada;
        return this;
    }


    public boolean esTypeDef() {
        return typeDef;
    }

    public DatosSimbolo setTypeDef(boolean typeDef) {
        this.typeDef = typeDef;
        return this;
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




}
