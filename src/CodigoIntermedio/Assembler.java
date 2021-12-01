package CodigoIntermedio;

import Principal.Lexico;
import Principal.Main;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Assembler {

    private ArrayList<ArrayList<Terceto>> codigoIntermedio; // ArrayList de ArrayList
    private AdministradorTercetos administradorTerceto;
    private static final int limiteInferiorULONG = 0;
    private static final long limiteSuperiorULONG= Long.parseUnsignedLong("100");

    //private Hashtable<String, String> varAuxPunteros = new Hashtable<>(); // TODO ver si se usa.

    public Assembler(AdministradorTercetos administradorTerceto) {
        this.codigoIntermedio = administradorTerceto.getCodigoIntermedio();
        this.administradorTerceto = administradorTerceto;
    }

    public void generarAssembler() throws IOException {

        // TODO Chequear el primer bw.write y el bw.write del final

        String code = this.generarCodeAssembler();
        String data = this.generarDataAssembler();

        FileOutputStream fos = new FileOutputStream(new File("output.asm"));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(".386" + '\n'
                + ".model flat, stdcall" + '\n'
                + "option casemap :none" + '\n'
                + "include \\masm32\\include\\windows.inc" + '\n'
                + "include \\masm32\\include\\kernel32.inc" + '\n'
                + "include \\masm32\\include\\user32.inc" + '\n'
                + "includelib \\masm32\\lib\\kernel32.lib" + '\n'
                + "includelib \\masm32\\lib\\user32.lib" + '\n'
                + '\n' + ".data" + '\n');

        bw.write(data + "\n.code\nstart: \n" + code + "invoke ExitProcess, 0\nend start");

        bw.close();
    }

    public String generarDataAssembler(){
        String data = "";
        Enumeration iterador = Main.tablaSimbolos.getKeys();
        //TODO agregar las validaciones en tiempo de ejecucion y los case
        data += "_limiteSuperiorULONG DD " + limiteSuperiorULONG+ '\n';
        data += "_limiteInferiorULONG DD " + limiteInferiorULONG + '\n';
        data += "_OverflowSuma DB \"Overflow en suma\", 0 \n";

        while(iterador.hasMoreElements()){
            String lexema = (String)iterador.nextElement();
            switch (Main.tablaSimbolos.getDatos(lexema).getId()){
                case (Lexico.IDENTIFICADOR):
                    if (!Main.tablaSimbolos.getDatos(lexema).getUso().equals("NombreFuncion")) {
                        if (Main.tablaSimbolos.getDatos(lexema).getTipo().equals("ULONG"))
                            if (lexema.contains("2bytes"))
                                data = data + "_" + lexema + " DW ?" + '\n';
                            else
                                data = data + "_" + lexema + " DD ?" + '\n';
                        if (Main.tablaSimbolos.getDatos(lexema).getTipo().equals("DOUBLE"))
                            data = data + "_" + lexema + " DQ ?" + '\n';
                    }
                    break;

                case (Lexico.CADENA):
                    String cadena = lexema;
                    data = data + "_" + cadena + " DB '" + lexema + "', 0 \n";
                    break;

                case (Lexico.CTE_DOUBLE):
                    String nombre = lexema.replace('.', '_');
                    nombre = nombre.replace('-', '_');
                    nombre = nombre.replace("+", "__");
                    data = data + "_" + nombre + " DQ " + lexema + '\n';
                    break;

                case (Lexico.CTE_ULONG):
                    data = data + "_" + lexema + " DD " + lexema + '\n';
                    break;
            }
        }
        return data;
    }

    public String generarCodeAssembler() {


        String code = "FINIT \n"; //TODO Ver si esto está bien
        String funcionActual = "main"; //TODO Funcion actual o ambito actual


        for (ArrayList<Terceto> lista : codigoIntermedio) {
            for (Terceto t : lista) {
                switch (t.getOperador()) {
                    case "+":

                        //Situación 1: Operación entre 2 variables y/o constantes

                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                // [+,A,B]
                                code += "MOV EBX, _" + t.getOperando1() + '\n'; // A a EBX
                                code += "ADD EBX, _" + t.getOperando2() + '\n'; // Sumo B a A en EBX
                                code += "CMP EBX, _limiteSuperiorULONG" + '\n'; // Comparo que no exceda el rango.
                                code += "JA " + "LabelOverflowSuma" + '\n'; // Si excede salto.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo el resultado en el terceto.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable"); // Agrego la variable a tabla de simbolos.
                            }
                            if (t.getTipo().equals("DOUBLE")) {

                                String op1 = t.getOperando1();
                                String op2 = t.getOperando2();

                                op1 = t.getOperando1().replace('.', '_');
                                op1 = op1.replace('-', '_');
                                op1 = op1.replace("+", "__");
                                op2 = t.getOperando2().replace('.', '_');
                                op2 = op2.replace('-', '_');
                                op2 = op2.replace("+", "__");

                                code += "FLD _" + op1 + '\n';
                                code += "FADD _" + op2 + '\n';

                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "variable");

                            }
                        }

                        //Situación 2: Operación entre un registro y una variable o constante

                        if (!t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Muevo _varTerceto a EBX por problema de memoria, memoria
                                code += "ADD EBX, _"  + t.getOperando2() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "CMP EBX, _limiteSuperiorULONG" + '\n'; // Comparo EBX con el limite superior por si se pasa.
                                code += "JA " + "LabelOverflowSuma" + '\n'; // Si se pasa, salto.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable"); // Agrego a la tabla de simbolos.
                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String op2 = t.getOperando2();
                                op2 = t.getOperando2().replace('.', '_');
                                op2 = op2.replace('-', '_');
                                op2 = op2.replace("+", "__");

                                String numeroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto));

                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
                            }
                        }

                        //Situación 3: Operación entre dos registros

                        if (!t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto1 = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto1));

                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto2));

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Agrego el primer registro.
                                code += "ADD EBX, _" + t2.getResultado() + '\n'; // Sumo con el segundo registro.
                                code += "CMP EBX, _limiteSuperiorUint" + '\n';
                                code += "JA " + "LabelOverflowSuma" + '\n';
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable"); // Agrego a la tabla de simbolos.
                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String numeroTerceto1 = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto1));
                                String numeroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto2));
                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FADD _" + t2.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
                            }
                        }

                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa. TODO

                        if (t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "CMP " + t1.getResultado() + ", _limiteSuperiorULONG" + '\n';
                                code += "JA " + "LabelOverflowSuma" + '\n';
                                t.setResultado(t1.getResultado());

                            }
                            if (t.getTipo().equals("DOUBLE")) {

                                String op1 = t.getOperando1();

                                op1 = t.getOperando1().replace('.', '_');
                                op1 = op1.replace('-', '_');
                                op1 = op1.replace("+", "__");

                                String numeroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto));

                                code += "FADD _" + t1.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "variable");
                            }
                        }

                        //TODO las verificaciones de la suma en tiempo de ejecución

                        break;

                    case "-":

                        //Situación 1: Operación entre 2 variables y/o constantes

                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                code += "MOV EBX, _" + t.getOperando1() + '\n';
                                code += "SUB EBX, _" + t.getOperando2() + '\n';
                                code += "MOV _var" + t.getNumero() + ", EBX" + '\n';

                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                                t.setResultado("var" + t.getNumero());
                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }
                        }

                        //Situación 2: Operación entre un registro y una variable o constante

                        if (!t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Muevo _varTerceto a EBX por problema de memoria, memoria
                                code += "SUB EBX, _"  + t.getOperando2() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.

                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");

                            }
                            if (t.getTipo().equals("DOUBLE")) {

                            }
                        }

                        //Situación 3: Operación entre dos registros

                        if (!t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto1 = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto1));

                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto2));

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Agrego el primer registro.
                                code += "SUB EBX, _" + t2.getResultado() + '\n'; // Sumo con el segundo registro.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                            if (t.getTipo().equals("DOUBLE")) {

                            }
                        }

                        //Situación 4.b: Operación conmutativa entre una variable (o constante) y un registro. No conmutativa. //TODO

                        if (t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {

                            }
                            if (t.getTipo().equals("DOUBLE")) {

                            }
                        }

                        break;

                    case "*":

                        //Situación 1: Operación entre 2 variables y/o constantes

                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {

                                code += "MOV EBX, _" + t.getOperando1() + '\n'; // A a EBX
                                code += "MUL EBX, _" + t.getOperando2() + '\n'; // Sumo B a A en EBX
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo el resultado en el terceto.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");

                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }
                        }

                        //Situación 2: Operación entre un registro y una variable o constante

                        if (!t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {

                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Muevo _varTerceto a EBX por problema de memoria, memoria
                                code += "MUL EBX, _"  + t.getOperando2() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");

                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }

                        }

                        //Situación 3: Operación entre dos registros

                        if (!t.esVariable(1) && !t.esVariable(2)) {

                            if (t.getTipo().equals("ULONG")) {

                                String nroTerceto1 = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto1));

                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto2));

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Agrego el primer registro.
                                code += "MUL EBX, _" + t2.getResultado() + '\n'; // Sumo con el segundo registro.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");

                            }
                            if (t.getTipo().equals("DOUBLE")) {

                            }

                        }

                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa. TODO

                        if (t.esVariable(1) && !t.esVariable(2)) {

                            if (t.getTipo().equals("ULONG")) {

                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }

                        }

                        break;

                    case "/":

                        //Situación 1: Operación entre 2 variables y/o constantes

                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {

                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }
                        }

                        //Situación 2: Operación entre un registro y una variable o constante

                        if (!t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {

                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }

                        }

                        //Situación 3: Operación entre dos registros

                        if (!t.esVariable(1) && !t.esVariable(2)) {

                            if (t.getTipo().equals("ULONG")) {

                            }
                            if (t.getTipo().equals("DOUBLE")) {

                            }

                        }

                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.

                        if (t.esVariable(1) && !t.esVariable(2)) {

                            if (t.getTipo().equals("ULONG")) {

                            }

                            if (t.getTipo().equals("DOUBLE")) {

                            }

                        }

                        break;


                    case ":=":
                        // Situacion a ( := , vble , reg )
                        if (t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));
                                code += "MOV EBX, _" + t1.getResultado() + '\n';
                                code += "MOV _" + t.getOperando1() + ", EBX" + '\n';

                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();
                                op1 = t.getOperando1().replace('.', '_');
                                op1 = op1.replace('-', '_');
                                op1 = op1.replace("+", "__");

                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));
                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FSTP _" + op1 + '\n';
                            }
                        }
                        // Situacion b ( := , vble , vble )
                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                //String ambitoFunc = t.getOperando1().substring(t.getOperando1().indexOf("@") + 1);
                                code += "MOV EBX, _" + t.getOperando2() + '\n';
                                code += "MOV _" + t.getOperando1() + ", EBX"+ '\n';
                            }
                        }
                        if (t.getTipo().equals("DOUBLE")) {
                            String op1 = t.getOperando1();
                            String op2 = t.getOperando2();
                            op1 = t.getOperando1().replace('.', '_');
                            op1 = op1.replace('-', '_');
                            op1 = op1.replace("+", "__");
                            op2 = t.getOperando2().replace('.', '_');
                            op2 = op2.replace('-', '_');
                            op2 = op2.replace("+", "__");

                            //String paramProc = t.getOperando1().substring(t.getOperando1().indexOf("@") + 1);
                            code += "FLD _" + op2 + '\n';
                            code += "FSTP _" + op1 + '\n';
                        }
                        break;

                    case "ComienzaFuncion":
                        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                        if (funcionActual.equals("main")) {
                            code += "FINIT\n";
                            code += "invoke ExitProcess, 0 \n";
                        }
                        code += t.getOperando1() + ": \n";
                        funcionActual = t.getOperando1().substring(0, t.getOperando1().indexOf("@"));
                        break;

                    case "FinFuncion":
                        code += "RET \n";
                        break;

                    case "Invocacion":
                        code += "CALL " + t.getOperando1() + "\n";
                        break;

                    case "Impresion":
                        String cadena = t.getOperando1();
                        System.out.println(t.getOperando1());
                        code += "invoke MessageBox, NULL, addr _" + cadena + ", addr _" + cadena + ", MB_OK \n";
                        break;

                    default: //Para terceto (Label..., , )
                        code += t.getOperador() + ": \n";
                        break;
                }
            }


        }



        code += "FINIT\n";
        code += "invoke ExitProcess, 0 \n";
        code += "FINIT\n";
        code += "LabelOverflowSuma: \n";
        code += "invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK \n";
        code += "FINIT\n";
        return code;


    }



}
