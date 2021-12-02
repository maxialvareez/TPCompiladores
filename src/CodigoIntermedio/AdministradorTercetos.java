package CodigoIntermedio;

import java.util.ArrayList;
import java.util.Hashtable;

public class AdministradorTercetos {

    private ArrayList<Terceto> tercetos = new ArrayList<Terceto>();
    private ArrayList<Integer> pila = new ArrayList<>();

    private Hashtable<String, Integer> funciones = new Hashtable<String, Integer>();
    private ArrayList<ArrayList<Terceto>> codigoIntermedio = new ArrayList<>(5);



    public AdministradorTercetos() {
    }

    public Terceto getTerceto(int nroTerceto) {
        return tercetos.get(nroTerceto);
    }

    public void agregarTerceto(Terceto t) {
        t.setNumero(tercetos.size());
        tercetos.add(t);
    }

    public int cantidadTercetos() {
        return tercetos.size();
    }

    public void apilar(int nroTerceto) {
        pila.add(nroTerceto);
    }

    public void desapilar() {
        int tercetoIncompleto = pila.get(pila.size() - 1);
        pila.remove(pila.size() - 1);
        Terceto nuevoTerceto = tercetos.get(tercetoIncompleto);
        if (nuevoTerceto.getOperador() == "BF") // Si el terceto a desapilar es un BF, se debe desapilar y completar el valor del salto que le faltaba (operando 2)
            nuevoTerceto.setOperando2(Integer.toString(tercetos.size()));
        else
            nuevoTerceto.setOperando1(Integer.toString(tercetos.size())); //Seria un BI, por ende se desapila y se completa el terceto (con el operando 1). BI solo tiene operando 1 => (BI , op1 , - )
        tercetos.set(tercetoIncompleto, nuevoTerceto);
    }

    // desapila el terceto inicial del Repeat, y agrega el terceto BI con dirección al inicio (para que haga el bucle)
    public void desapilarRepeat() {
        int nroTerceto = pila.get(pila.size() - 1);
        pila.remove(pila.size() - 1);
        Terceto nuevoTerceto = tercetos.get(tercetos.size() - 1);
        nuevoTerceto.setOperando1(Integer.toString(nroTerceto));
        tercetos.set(tercetos.size() - 1, nuevoTerceto);
    }

    public void printCodigoIntermedio() {
        for (ArrayList<Terceto> a : codigoIntermedio) {
            for (Terceto t : a) {
                System.out.println(t.getNumero() + ". (" + t.getOperador() + ", " + t.getOperando1() + ", " + t.getOperando2() + ")");
            }
        }
    }

    public void imprimirTercetos(){
        for(Terceto t : tercetos)
            System.out.println(t.getNumero() + ". (" + t.getOperador() + ", " + t.getOperando1() + ", " + t.getOperando2() + ")" );
    }

    public void agregarFuncion(String funcion) {
        funciones.put(funcion, tercetos.size() - 1);
    }



    public void generarCodigoIntermedio(int inicio, int finalFuncion, String funcion, int index) {
        ArrayList<Terceto> aux = new ArrayList<>();
        ArrayList<String> invocados = new ArrayList<>();
        codigoIntermedio.add(index, new ArrayList<>());
        for (int i = inicio; i <= finalFuncion; i++) {
            Terceto t = tercetos.get(i);
            if (t.getOperador().equals("InvocacionFuncion") && !invocados.contains(t.getOperando1())) {
                String funcionInvocada = t.getOperando1();
                generarCodigoIntermedio(funciones.get(funcionInvocada), this.buscarFinFuncion(funcionInvocada), funcionInvocada, index + 1);
                invocados.add(funcionInvocada);
            }
            while ((t.getOperador().equals("ComienzaFuncion") && !t.getOperando1().equals(funcion)) && (i <= finalFuncion)) {
                i = this.buscarFinFuncion(t.getOperando1()) + 1;
                if (i <= finalFuncion)
                    t = tercetos.get(i);
            }
            if (i <= finalFuncion) {
                aux.add(t);
            }
        }
        codigoIntermedio.set(index, aux);
    }

    public void generarCodigoIntermedio(){
        this.generarCodigoIntermedio(0, tercetos.size() - 1, "main", 0);
    }
    public int buscarFinFuncion(String funcion) {
        for (Terceto t : tercetos) {
            if (t.getOperador().equals("FinFuncion") && t.getOperando1().equals(funcion)) {
                return t.getNumero();
            }
        }
        return 0;
    }
    public ArrayList<ArrayList<Terceto>> getCodigoIntermedio() {
        return codigoIntermedio;
    }

}
