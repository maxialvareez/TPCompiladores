package Principal;

import java.util.Enumeration;
import java.util.Hashtable;

public class TablaSimbolos {
    private static Hashtable<String, DatosSimbolo> simbolos;


    public TablaSimbolos() {
        simbolos = new Hashtable<>();
    }


    public DatosSimbolo getDatos(String lexema) {
        if (simbolos.containsKey(lexema))
            return simbolos.get(lexema);
        else
            return null;
    }

    // ----------Agregar Simbolo (con distintas variantes)

    public void agregarSimbolo(String lexema, Integer id) {
        if (simbolos.containsKey(lexema))
            System.out.println("El identificador " + lexema + " ya existe");
        else {
            DatosSimbolo ds = new DatosSimbolo();
            ds.setId(id);
            simbolos.put(lexema, ds);
        }
    }

    public void agregarSimbolo(String lexema, Integer id, String tipo) {
        if (simbolos.containsKey(lexema))
            System.out.println("El identificador " + lexema + " ya existe");
        else {
            DatosSimbolo ds = new DatosSimbolo();
            ds.setId(id);
            ds.setTipo(tipo);
            simbolos.put(lexema, ds);
        }
    }

    public void agregarSimbolo(String lexema, Integer id, String tipo, String uso) {
        if (simbolos.containsKey(lexema))
            System.out.println("El identificador " + lexema + " ya existe");
        else {
            DatosSimbolo ds = new DatosSimbolo();
            ds.setId(id);
            ds.setTipo(tipo);
            ds.setUso(uso);
            simbolos.put(lexema, ds);
        }
    }

    // -----------

    public Integer getId(String lexema){
        if (simbolos.containsKey(lexema)){
            return simbolos.get(lexema).getId();
        }
        else
            return null;
    }

    public void setDatosSimbolo(String lexema, DatosSimbolo ds) {
       simbolos.replace(lexema,ds);
    }

    public boolean existeLexema(String lexema) {
        return simbolos.containsKey(lexema);
    }

    public void eliminarSimbolo(String lexema) {
        simbolos.remove(lexema);
    }


    public String verificarAmbito(String identificador, String ambito){
        String aux = identificador + "@" + ambito;
        // Verificar ambito variables
        while(!aux.equals(identificador)){
            if(simbolos.containsKey(aux)){
                return aux;
            }
            aux = aux.substring(0,aux.lastIndexOf("@")); // al ser por ejemplo x @ Ambito1 @ Ambito2 , elimina el ultimo ambito y sigue buscando, subiendo hasta el ambito principal (que seria el programa)
        }
        // Verificar ambito parametros
        String[] func = ambito.split("@");  // se obtiene un arreglo de los distintos ambitos ( ej: a1 @ a2 @ a3 => [a1] [a2] [a3] )
        for(int i = 1; i<func.length; i++){
            aux = identificador + "@" +func[i];
            if(simbolos.containsKey(aux) && simbolos.get(aux).getUso().equals("nombreParametro")){
                return aux;
            }
        }
        return null;
    }


    public void imprimirTablaSimbolos() {
        Enumeration iterador = simbolos.keys();
        while (iterador.hasMoreElements()) {
            String lexema = (String) iterador.nextElement();
            DatosSimbolo ds = simbolos.get(lexema);
            if(lexema.contains("@") || (!lexema.contains("@") && simbolos.get(lexema).getId() != 257)) {
                System.out.println("Lexema: " + lexema + ", id: " + ds.getId() + ", tipo: " + ds.getTipo() + ", uso: " + ds.getUso());

            }
        }
    }

    public void modificarSimbolo(String lexemaviejo, String lexemaNuevo) {  //Se elimina el Double anterior para ser reemplazado por un Double negado
        simbolos.remove(lexemaviejo);
        DatosSimbolo ds = new DatosSimbolo();
        ds.setId(Lexico.CTE_DOUBLE);
        ds.setTipo("DOUBLE");
        simbolos.put(lexemaNuevo, ds);
    }

    public void reemplazarLexema(String lexema, String nuevoLexema){
        DatosSimbolo ds = simbolos.get(lexema);
       eliminarSimbolo(lexema);
        simbolos.put(nuevoLexema, ds);
    }

    public Enumeration getKeys(){
        return simbolos.keys();
    }


}
