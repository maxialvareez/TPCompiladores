//package CodigoIntermedio;
//
//import Principal.Lexico;
//import Principal.Main;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Enumeration;
//import java.util.Hashtable;
//
//public class Assembler {
//
//    private ArrayList<ArrayList<Terceto>> codigoIntermedio; // ArrayList de ArrayList
//    private AdministradorTercetos administradorTerceto;
//    private boolean EAX; // Registros del procesador
//    private boolean EBX;
//    private boolean ECX;
//    private boolean EDX;
//    // TODO Hay que verificar en tiempo de ejecución division por 0, suma de enteros y recursion. Son a), b) y f)
//
//    private Hashtable<String, String> varAuxPunteros = new Hashtable<>(); // TODO ver si se usa.
//
//    public Assembler(AdministradorTercetos administradorTerceto) {
//        this.codigoIntermedio = administradorTerceto.getCodigoIntermedio();
//        this.administradorTerceto = administradorTerceto;
//        this.EAX = true; // Si es true, está libre.
//        this.EBX = true;
//        this.ECX = true;
//        this.EDX = true;
//    }
//
//    public void generarAssembler() throws IOException {
//
//        // TODO Chequear el primer bw.write y el bw.write del final
//
//        String code = this.generarCodeAssembler();
//        String data = this.generarDataAssembler();
//
//        FileOutputStream fos = new FileOutputStream(new File("output.asm"));
//
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//
//        bw.write(".386" + '\n'
//                + ".model flat, stdcall" + '\n'
//                + "option casemap :none" + '\n'
//                + "include \\masm32\\include\\windows.inc" + '\n'
//                + "include \\masm32\\include\\kernel32.inc" + '\n'
//                + "include \\masm32\\include\\user32.inc" + '\n'
//                + "includelib \\masm32\\lib\\kernel32.lib" + '\n'
//                + "includelib \\masm32\\lib\\user32.lib" + '\n'
//                + '\n' + ".data" + '\n');
//
//        bw.write(data + "\n.code\nstart: \n" + code + "invoke ExitProcess, 0\nend start");
//
//        bw.close();
//    }
//
//    public String generarDataAssembler(){
//        String data = "";
//        Enumeration iterador = Main.tablaSimbolos.getKeys();
//        //TODO agregar las validaciones en tiempo de ejecucion y los case
//
//        while(iterador.hasMoreElements()){
//            String lexema = (String)iterador.nextElement();
//            switch (Main.tablaSimbolos.getDatos(lexema).getId()){
//                //TODO
//                case (Lexico.IDENTIFICADOR):
//                    break;
//                case (Lexico.CADENA):
//                    String cadena = lexema.substring(1,lexema.length()-1).replace(' ', '_');
//                    data = data + "_" + cadena + " DB " + lexema + ", 0 \n";
//                    break;
//                case (Lexico.CTE_DOUBLE):
//                    break;
//                case (Lexico.CTE_ULONG):
//                    break;
//            }
//        }
//        return data;
//    }
//
//    public String generarCodeAssembler() {
//        String code = "FINIT \n"; //TODO Ver si esto está bien
//        String funcionActual = "main"; //TODO Funcion actual o ambito actual
//
//        for(ArrayList<Terceto> lista: codigoIntermedio) {
//            for (Terceto t : lista) {
//                switch (t.getOperador()) {
//                    case "+":
//
//                        //Situación 1: Operación entre 2 variables y/o constantes
//
//                        if (t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//                                //TODO
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//                                String op1 = t.getOperando1();
//                                String op2 = t.getOperando2();
//
//                                op1 = t.getOperando1().replace('.','_');
//                                op1 = op1.replace('-','_');
//                                op1 = op1.replace("+","__");
//                                op2 = t.getOperando2().replace('.','_');
//                                op2 = op2.replace('-','_');
//                                op2 = op2.replace("+","__");
//
//                                code += "FLD _" + op1 + '\n';
//                                code += "FADD _" + op2 + '\n';
//
//                                code += "FSTP _" + "var" + t.getNumero() + '\n';
//                                t.setResultado("var" + t.getNumero());
//                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "variable");
//
//                            }
//                        }
//
//                        //Situación 2: Operación entre un registro y una variable o constante
//
//                        if (!t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//                                //TODO
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//                                String op2 = t.getOperando2();
//
//                                //TODO los replace ??
//
//                                String numeroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
//                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto));
//
//                                // TODO esPuntero??
//                                // TODO set resultado y agregar a la tabla de simbolos.
//                            }
//                        }
//
//                        //Situación 3: Operación entre dos registros
//
//                        if (!t.esVariable(1) && !t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//                                //TODO
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                                String numeroTerceto1 = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
//                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto1));
//
//                                String numeroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
//                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto2));
//
//                                //TODO agregar code y a la tabla de simbolos
//                            }
//                        }
//
//                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.
//
//                        if (t.esVariable(1) && !t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//                                //TODO
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                                String op1 = t.getOperando1();
//
//                                //TODO Replace
//
//                                String numeroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
//                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto));
//
//                                //TODO code y agregar a la tabla de simbolos
//                            }
//                        }
//
//                        //TODO las verificaciones de la suma en tiempo de ejecución
//
//                        break;
//
//                    case "-":
//
//                        //Situación 1: Operación entre 2 variables y/o constantes
//
//                        if (t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//                        }
//
//                        //Situación 2: Operación entre un registro y una variable o constante
//
//                        if (!t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//                        }
//
//                        //Situación 3: Operación entre dos registros
//
//                        if (!t.esVariable(1) && !t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//                        }
//
//                        //Situación 4.b: Operación conmutativa entre una variable (o constante) y un registro. No conmutativa.
//
//                        if (t.esVariable(1) && !t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//                        }
//
//                        break;
//
//                    case "*":
//
//                        //Situación 1: Operación entre 2 variables y/o constantes
//
//                        if (t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//                        }
//
//                        //Situación 2: Operación entre un registro y una variable o constante
//
//                        if (!t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//
//                        }
//
//                        //Situación 3: Operación entre dos registros
//
//                        if (!t.esVariable(1) && !t.esVariable(2)) {
//
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//
//                        }
//
//                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.
//
//                        if (t.esVariable(1) && !t.esVariable(2)) {
//
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//
//                        }
//
//                        break;
//
//                    case "/":
//
//                        //Situación 1: Operación entre 2 variables y/o constantes
//
//                        if (t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//                        }
//
//                        //Situación 2: Operación entre un registro y una variable o constante
//
//                        if (!t.esVariable(1) && t.esVariable(2)) {
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//
//                        }
//
//                        //Situación 3: Operación entre dos registros
//
//                        if (!t.esVariable(1) && !t.esVariable(2)) {
//
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//
//                        }
//
//                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.
//
//                        if (t.esVariable(1) && !t.esVariable(2)) {
//
//                            if (t.getTipo().equals("ULONG")) {
//
//                            }
//
//                            if (t.getTipo().equals("DOUBLE")) {
//
//                            }
//
//                        }
//
//                        break;
//
//                }
//            }
//        }
//    }
//
//
//
//}
