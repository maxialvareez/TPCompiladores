package CodigoIntermedio;


import Principal.Lexico;
import Principal.Main;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class AdministradorTercetos {

    private ArrayList<Terceto> tercetos = new ArrayList<Terceto>();
    private ArrayList<Integer> pila = new ArrayList<>();

    private Hashtable<String, Integer> funciones = new Hashtable<String, Integer>();
    private ArrayList<Terceto> codigoIntermedio = new ArrayList<>();
    private List<String> invocaciones = new ArrayList<>();

    private Hashtable<String, ArrayList<Terceto>> contenidoFunciones  = new Hashtable<String, ArrayList<Terceto>>();


    public AdministradorTercetos() {
    }

    public Terceto getTerceto(int nroTerceto) {
        return tercetos.get(nroTerceto);
    }

    public Hashtable<String, ArrayList<Terceto>> getContenidoFunciones() {
        return contenidoFunciones;
    }

    public void agregarTerceto(Terceto t) {
        t.setNumero(tercetos.size());
        tercetos.add(t);
    }

    public void imprimirInvocaciones(){
        for (String s :invocaciones)
            System.out.println(s);
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
        for (Terceto t : codigoIntermedio) {
                System.out.println(t.getNumero() + ". (" + t.getOperador() + ", " + t.getOperando1() + ", " + t.getOperando2() + ", " + t.getAmbitoInvocacion() +")");
            }
    }

    public void imprimirTercetos(){
        for(Terceto t : tercetos)
            System.out.println(t.getNumero() + ". (" + t.getOperador() + ", " + t.getOperando1() + ", " + t.getOperando2() + ", " + t.getTipo() + ", " + t.getAmbitoInvocacion() + ")" );
    }

    public void agregarFuncion(String funcion) {
        funciones.put(funcion, tercetos.size() - 1);
    }


    public void generarCodigoIntermedio(int inicio, int finalFunc, String funcion, int index) {
        for (int i = inicio; i <= finalFunc; i++) {
            Terceto t = tercetos.get(i);
            if (t.getOperador().equals("InvocacionFuncion")) {
                chequearInvocaciones(t.getOperando1());
                invocaciones.clear();
            }
            while ((t.getOperador().equals("ComienzaFuncion") && !t.getOperando1().equals(funcion)) && (i <= finalFunc)) {
                agregarContenidoFuncion (t.getNumero());
                i = this.buscarFinFuncion(t.getOperando1()) + 1;
                if (i <= finalFunc)
                    t = tercetos.get(i);
            }
            if (i <= finalFunc) {
                codigoIntermedio.add(t);
            }
        }
    }

    public int agregarContenidoFuncion (int pos){
        Terceto t = tercetos.get(pos);
        String nombreFunc = t.getOperando1();
        ArrayList<Terceto> funcs = new ArrayList<>();
        funcs.add(t);
        pos ++;
        int posAct;
        t = tercetos.get(pos);
        while (!t.getOperador().equals("FinFuncion")){
            if (t.getOperador().equals("ComienzaFuncion")) {
                posAct = agregarContenidoFuncion(pos);
                pos = posAct;
            }
            funcs.add(t);
            pos ++;
            t = tercetos.get(pos);

        }
        if (t.getOperador().equals("FinFuncion")){
            funcs.add(t);
        }
        contenidoFunciones.put(nombreFunc, funcs);
        return pos;
    }



    public void generarCodigoIntermedio(){
        this.generarCodigoIntermedio(0, tercetos.size() - 1, "main", 0);
    }

    public void imprimirFuncion(String funcion){
        ArrayList<Terceto> lista = this.contenidoFunciones.get(funcion);
        for (Terceto t : lista){
            System.out.println("( " + t.getOperador()+ " , " +  t.getOperando1()+ " , " + t.getOperando2()+ " , " + t.getAmbitoInvocacion()+ ")");
        }
    }

    public int buscarFinFuncion(String funcion) {
        for (Terceto t : tercetos) {
            if (t.getOperador().equals("FinFuncion") && t.getOperando1().equals(funcion)) {
                return t.getNumero();
            }
        }
        return 0;
    }
    public ArrayList<Terceto> getCodigoIntermedio() {
        return codigoIntermedio;
    }


    public void chequearInvocaciones(String funcion){
        ArrayList<Terceto> lista = this.contenidoFunciones.get(funcion);
        for (Terceto t : lista){
            if (t.getOperador().equals("InvocacionFuncion")){
                String nombreFuncion = funcion.substring(0, funcion.lastIndexOf("@"));
                if (!invocaciones.contains(nombreFuncion)) {
                    if (t.getAmbitoInvocacion() != null) {
                        invocaciones.add(t.getAmbitoInvocacion());
                        chequearInvocaciones(t.getOperando1());
                    }
                }
                else
                if (invocaciones.contains(nombreFuncion) && !funcion.equals(t.getOperando1())){
                    Main.listaErrores.add("[ERROR EN EJECUCIÓN]  {Se detecto una recursion mutua en las invocaciones de las funciones '" + t.getOperando1() +"' y '"+ funcion + "'");
                }
            }
        }
    }

}
