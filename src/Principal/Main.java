package Principal;
import java.io.*;

import CodigoIntermedio.AdministradorTercetos;
import CodigoIntermedio.Assembler;
import Sintactico.*;
public class Main {

    private static BufferedReader codigo;
    public static TablaSimbolos tablaSimbolos = new TablaSimbolos();

    private static StringBuilder getCodigo(BufferedReader ubicacion){

        StringBuilder buffer = new StringBuilder();

        try{
            codigo = new BufferedReader(new FileReader(ubicacion.readLine()));
            String readLine;

            while ((readLine = codigo.readLine())!= null) {
                buffer.append(readLine + "\n");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }


    public static void main(String[] args) throws IOException {

        //-------------- CARGA DE ARCHIVO --------------
        InputStreamReader leer = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(leer);
        System.out.print("Ingrese la direccion del archivo: ");
        String direccion = buffer.readLine();

        InputStream is = new ByteArrayInputStream(direccion.getBytes());

        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        StringBuilder codigo = new StringBuilder(getCodigo(br));

        System.out.println("Contenido del archivo: ");
        System.out.println(codigo);


        //-------------- FIN CARGA DE ARCHIVO --------------

        AdministradorTercetos adminTercetos = new AdministradorTercetos();
        Lexico l1 = new Lexico(codigo);


        Parser p = new Parser(l1, adminTercetos);
        p.run();

        tablaSimbolos.eliminarVariablesRepetidas();
        adminTercetos.generarCodigoIntermedio();
/*
        Token t = l1.getToken();
        while (t.getId() != 0){
            l1.getToken();
        }
 */
        Assembler assembler = new Assembler(adminTercetos);
        assembler.generarAssembler();


        System.out.println("\n------ CÓDIGO INTERMEDIO ------");
        adminTercetos.printCodigoIntermedio();

        System.out.println("\n -----TABLA DE SIMBOLOS------");
        tablaSimbolos.imprimirTablaSimbolos();



    }
}
