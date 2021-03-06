package CodigoIntermedio;

import Principal.*;

public class Terceto {
    private int numero;
    private String operador;
    private String operando1;
    private String operando2;
    private String resultado; // resultado de la operación del terceto
    private String tipo;  // tipo del resultado de la operación (por ejemplo si es la suma de dos enteros, será entero)
    private String ambitoInvocacion;
    private String varibleAuxiliar;

    public Terceto(String operador, String operando1, String operando2) {
        this.operador = operador;
        this.operando1 = operando1;
        this.operando2 = operando2;
        this.resultado = null;
        this.tipo = null;
        this.ambitoInvocacion = null;
        this.varibleAuxiliar = null;

    }

    public String getVaribleAuxiliar() {
        return varibleAuxiliar;
    }

    public Terceto setVaribleAuxiliar(String varibleAuxiliar) {
        this.varibleAuxiliar = varibleAuxiliar;
        return this;
    }

    public String getAmbitoInvocacion() {
        return ambitoInvocacion;
    }

    public Terceto setAmbitoInvocacion(String ambitoInvocacion) {
        this.ambitoInvocacion = ambitoInvocacion;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public String getOperador() {
        return operador;
    }

    public String getOperando1() {
        return operando1;
    }

    public String getOperando2() {
        return operando2;
    }

    public String getResultado() {
        return resultado;
    }

    public String getTipo() {
        return tipo;
    }

    public Terceto setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public Terceto setOperador(String operador) {
        this.operador = operador;
        return this;
    }

    public Terceto setOperando1(String operando1) {
        this.operando1 = operando1;
        return this;
    }

    public Terceto setOperando2(String operando2) {
        this.operando2 = operando2;
        return this;
    }

    public Terceto setResultado(String resultado) {
        this.resultado = resultado;
        return this;
    }

    public Terceto setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }


    public boolean esVariable(int op) {
        if (op == 1)
            return !operando1.contains("]");
        else
            return !operando2.contains("]");
    }

}
