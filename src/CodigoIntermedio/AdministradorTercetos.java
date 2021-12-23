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
    private ArrayList<ArrayList<Terceto>> codigoIntermedio = new ArrayList<>();
    private List<String> invocaciones = new ArrayList<>();

    public AdministradorTercetos() {
    }

    public Terceto getTerceto(int nroTerceto) {
        return tercetos.get(nroTerceto);
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
        for (ArrayList<Terceto> a : codigoIntermedio) {
            for (Terceto t : a) {
                System.out.println(t.getNumero() + ". (" + t.getOperador() + ", " + t.getOperando1() + ", " + t.getOperando2() + ", " + t.getAmbitoInvocacion() +")");
            }
        }
    }

    public void imprimirTercetos(){
        for(Terceto t : tercetos)
            System.out.println(t.getNumero() + ". (" + t.getOperador() + ", " + t.getOperando1() + ", " + t.getOperando2() + ", " + t.getTipo() + ", " + t.getAmbitoInvocacion() + ")" );
    }

    public void agregarFuncion(String funcion) {
        funciones.put(funcion, tercetos.size() - 1);
    }


    public void generarCodigoIntermedio(int inicio, int finalFuncion, String funcion, int index) {
        ArrayList<Terceto> aux = new ArrayList<>();
        codigoIntermedio.add(index, new ArrayList<>());
        Hashtable<String, Integer> funcs = new Hashtable<>();

        for (int i = inicio; i <= finalFuncion; i++) {
            Terceto t = tercetos.get(i);


            if (t.getOperador().equals("InvocacionFuncion") ) {
                String funcionInvocada = t.getOperando1();
                aux.add(t);
                i++;
                aux.add(tercetos.get(i));
                addFuncion(funciones.get(funcionInvocada), this.buscarFinFuncion(funcionInvocada), funcionInvocada, index + 1, aux);
                System.out.println("\n------ CÓDIGO INTERMEDIO ------");
                System.out.println("---INVOCA---");
                imprimirInvocaciones();
                invocaciones.clear();
            }
            while ((t.getOperador().equals("ComienzaFuncion") && !t.getOperando1().equals(funcion)) && (i <= finalFuncion)) {
                String operando = t.getOperando1();
                if (tercetos.get(this.buscarFinFuncion(t.getOperando1())-1).getOperador().equals("RetornoFuncion")) {
                  funcs.put(operando,this.buscarFinFuncion(t.getOperando1())-1);
                }
                i = this.buscarFinFuncion(t.getOperando1()) + 1;

                if (i <= finalFuncion) {
                    t = tercetos.get(i);
                }

            }
            if (t.getOperando1() != null){

                if (funcs.containsKey(t.getOperando1()) && !t.getOperador().equals("InvocacionFuncion")) {
                    t.setOperando1("[" + funcs.get(t.getOperando1()) + "]");
                }
        }
            if (t.getOperando2() != null) {
                if (funcs.containsKey(t.getOperando2())&& !t.getOperador().equals("InvocacionFuncion")) {
                    t.setOperando2("[" + funcs.get(t.getOperando2()) + "]");
                }
            }
           if (i <= finalFuncion && !t.getOperador().equals("InvocacionFuncion")) {
                aux.add(t);
            }
        }
        codigoIntermedio.set(index, aux);
    }

    public void addFuncion(int inicio, int fin, String funcion, int index,ArrayList<Terceto> aux ){
        int finfunc = -1;
        int comienzafunc = -1;
        for(int i =inicio; i <= fin ; i++){
            Terceto t = tercetos.get(i);
            System.out.println(t.getOperador()+ " , "+ t.getOperando1() + " , " + t.getOperando2() );
            String operando1 = t.getOperando1();
            if (!t.getOperador().contains("Label"))
                if (operando1.contains("@"))
                    operando1 = operando1.substring(0,operando1.indexOf("@"));
            String func = funcion;
            if (func.contains("@"))
                func = func.substring(0,func.indexOf("@") );
            System.out.println("Func: "+ func);
            if (t.getOperador().equals("InvocacionFuncion") && !invocaciones.contains(operando1)){
                if (t.getAmbitoInvocacion() != null ) {
                    System.out.println(func);
                    System.out.println(t.getAmbitoInvocacion());
                        invocaciones.add(t.getAmbitoInvocacion());
                }
                    aux.add(t);
                    Terceto t1 = tercetos.get(i+1);
                    aux.add(t1);
                    i++;
                    finfunc = buscarFinFuncion(t.getOperando1());
                    comienzafunc = buscarComienzoFuncion(t.getOperando1());

                    addFuncion(comienzafunc,finfunc, t.getOperando1(),index, aux);

            }
            else {
                if (invocaciones.contains(operando1) && !func.equals(operando1)) {
                    System.out.println("Operando: "+ operando1);
                    System.out.println("Func: "+ func);
                    System.out.println("Funcion: " + funcion);
                    System.out.println("ERROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOR");
                    Main.listaErrores.add("ERROR POR INVOCACION");

                }
                if (t.getOperador().equals("ComienzaFuncion") && !t.getOperando1().equals(funcion)){
                    i = buscarFinFuncion(t.getOperando1()) ;
                }
                else
                    aux.add(t);
            }
        }
    }

    public void generarCodigoIntermedio(){
        this.generarCodigoIntermedio(0, tercetos.size() - 1, "main", 0);
    }

    public int buscarComienzoFuncion(String funcion) {
        for (Terceto t : tercetos) {
            if (t.getOperador().equals("ComienzaFuncion") && t.getOperando1().equals(funcion)) {
                return t.getNumero();
            }
        }
        return 0;
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
