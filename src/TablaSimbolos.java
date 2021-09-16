import java.util.Enumeration;
import java.util.Hashtable;

public class TablaSimbolos {
    private static Hashtable<String, Integer> simbolos;


    public TablaSimbolos() {
        simbolos = new Hashtable<>();
    }

    public Integer getId(String s ){
        if (simbolos.contains(s))
            return simbolos.get(s);
        else
            return null;
    }

    public void agregarSimbolo (String lexema, Integer id){
        if (simbolos.contains(lexema))
            System.out.println("El simbolo" + lexema + "ya se encuentra en la  Tabla de Simbolos");
        else
            simbolos.put(lexema,id);
    }

    public boolean existeLexema(String s){
        return simbolos.contains(s);
    }

    public void eliminarSimbolo(String lexema) {
        simbolos.remove(lexema);
    }

    public void printTablaSimbolos() {
        Enumeration iterador = simbolos.keys();
        while (iterador.hasMoreElements()) {
            String lexema = (String) iterador.nextElement();
            System.out.println("Lexema: " + lexema + ", id: " + simbolos.get(lexema));
        }
    }


}
