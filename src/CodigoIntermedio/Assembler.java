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
    private static final long limiteSuperiorULONG= Long.parseUnsignedLong("4294967295");
    private static final int divisorCeroULONG = 0;
    private static final double divisorCeroDOUBLE = 0.0;

    public Assembler(AdministradorTercetos administradorTerceto) {
        this.codigoIntermedio = administradorTerceto.getCodigoIntermedio();
        this.administradorTerceto = administradorTerceto;
    }

    public void generarAssembler() throws IOException {

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
        data += "_limiteSuperiorULONG DD " + limiteSuperiorULONG+ '\n';
        data += "_limiteInferiorULONG DD " + limiteInferiorULONG + '\n';
        data += "_divisorCeroULONG DD " + divisorCeroULONG+ '\n';
        data += "_divisorCeroDOUBLE DD " + divisorCeroDOUBLE+ '\n';
        data += "_OverflowSuma DB \"Overflow en suma\", 0 \n";
        data += "_DivisionCero DB \"Division por cero\", 0 \n";
        while(iterador.hasMoreElements()){
            String lexema = (String)iterador.nextElement();
            switch (Main.tablaSimbolos.getDatos(lexema).getId()){
                case (Lexico.IDENTIFICADOR):
                    if (!Main.tablaSimbolos.getDatos(lexema).getUso().equals("NombreFuncion")) {
                        if (Main.tablaSimbolos.getDatos(lexema).getTipo().equals("ULONG")) {
                            if (lexema.contains("2bytes"))
                                data = data + "_" + lexema + " DW ?" + '\n';
                            else
                                data = data + "_" + lexema + " DD ?" + '\n';
                        }
                        if (Main.tablaSimbolos.getDatos(lexema).getTipo().equals("DOUBLE")) {
                            if (lexema.contains("2bytes"))
                                data = data + "_" + lexema + " DW ?" + '\n';
                            else
                                data = data + "_" + lexema + " DQ ?" + '\n';
                        }
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


        String code = "FINIT \n";
        String funcionActual = "main";

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
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

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

                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.

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
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
                            }
                        }


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
                                String op1 = t.getOperando1();
                                String op2 = t.getOperando2();

                                op1 = t.getOperando1().replace('.', '_');
                                op1 = op1.replace('-', '_');
                                op1 = op1.replace("+", "__");
                                op2 = t.getOperando2().replace('.', '_');
                                op2 = op2.replace('-', '_');
                                op2 = op2.replace("+", "__");

                                code += "FLD _" + op1 + '\n';
                                code += "FSUB _" + op2 + '\n';

                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

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
                                code += "SUB EBX, _" + t2.getResultado() + '\n'; // Sumo con el segundo registro.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String numeroTerceto1 = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto1));
                                String numeroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto2));
                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FSUB _" + t2.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

                            }
                        }

                        //Situación 4.b: Operación conmutativa entre una variable (o constante) y un registro. No conmutativa.

                        if (t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _" + t.getOperando1() + '\n'; // Muevo _varTerceto a EBX por problema de memoria, memoria
                                code += "SUB EBX, _"  + t1.getResultado() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.

                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();

                                op1 = t.getOperando1().replace('.', '_');
                                op1 = op1.replace('-', '_');
                                op1 = op1.replace("+", "__");

                                String numeroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(numeroTerceto));

                                code += "FSUB _" + t1.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
                            }
                        }

                        break;

                    case "*":

                        //Situación 1: Operación entre 2 variables y/o constantes

                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                code += "MOV EAX, _" + t.getOperando1() + '\n'; // A a EAX
                                code += "MUL _" + t.getOperando2() + '\n'; // Multiplico B con A que esta en el EAX
                                code += "MOV _var"+ t.getNumero() +", EAX"+  '\n'; // Muevo a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo el resultado en el terceto.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                    String op1 = t.getOperando1();
                                    String op2 = t.getOperando2();
                                    op1 = t.getOperando1().replace('.','_');
                                    op1 = op1.replace('-','_');
                                    op1 = op1.replace("+","__");
                                    op2 = t.getOperando2().replace('.','_');
                                    op2 = op2.replace('-','_');
                                    op2 = op2.replace("+","__");

                                    code += "FLD _" + op1 + '\n';
                                    code += "FMUL _" + op2 + '\n';

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
                                code += "MUL EBX, _"  + t.getOperando2() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op2 = t.getOperando2();
                                op2 = t.getOperando2().replace('.','_');
                                op2 = op2.replace('-','_');
                                op2 = op2.replace("+","__");

                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FMUL _" + op2 + '\n';

                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "variable");
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
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FMUL _" + t2.getResultado() + '\n';

                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "variable");

                            }

                        }

                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.

                        if (t.esVariable(1) && !t.esVariable(2)) {

                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando2().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _" + t1.getResultado() + '\n'; // Muevo _varTerceto a EBX por problema de memoria, memoria
                                code += "MUL EBX, _"  + t.getOperando1() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "MOV _var"+ t.getNumero() +", EBX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();
                                op1 = t.getOperando1().replace('.','_');
                                op1 = op1.replace('-','_');
                                op1 = op1.replace("+","__");

                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + t.getOperando1() + '\n';
                                code += "FMUL _" + t1.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

                            }

                        }

                        break;

                    case "/":

                        //Situación 1: Operación entre 2 variables y/o constantes

                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                code += "MOV EBX, _" + t.getOperando2() + '\n';
                                code += "CMP EBX, _divisorCeroULONG" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';

                                code += "MOV EAX, _" + t.getOperando1() + '\n';
                                code += "DIV _" + t.getOperando2() + '\n';

                                code += "MOV _var"+ t.getNumero() +", EAX"+  '\n'; // Muevo a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo el resultado en el terceto.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();
                                String op2 = t.getOperando2();
                                op1 = t.getOperando1().replace('.','_');
                                op1 = op1.replace('-','_');
                                op1 = op1.replace("+","__");
                                op2 = t.getOperando2().replace('.','_');
                                op2 = op2.replace('-','_');
                                op2 = op2.replace("+","__");

                                code += "FLD _" + op2 + '\n';
                                code += "FCOM _divisorCeroDOUBLE" + '\n';
                                code += "FSTSW _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var1_" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

                                code += "FLD _" + op1 + '\n';
                                code += "FDIV _" + op2 + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
                            }
                        }

                        //Situación 2: Operación entre un registro y una variable o constante

                        if (!t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _"  + t.getOperando2() + '\n';
                                code += "CMP EBX, _divisorCeroULONG" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';

                                code += "MOV EAX, _" + t1.getResultado() + '\n';
                                code += "DIV _"  + t.getOperando2() + '\n';
                                code += "MOV _var"+ t.getNumero() +", EAX"+  '\n';
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op2 = t.getOperando2();
                                op2 = t.getOperando2().replace('.','_');
                                op2 = op2.replace('-','_');
                                op2 = op2.replace("+","__");

                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + op2 + '\n';
                                code += "FCOM _divisorCeroDOUBLE" + '\n';
                                code += "FSTSW _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var1_" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FDIV _" + op2 + '\n';
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

                                code += "MOV EBX, _" + t2.getResultado() + '\n';
                                code += "CMP EBX, _divisorCeroULONG" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';

                                code += "MOV EAX, _" + t1.getResultado() + '\n';
                                code += "DIV _"  + t2.getResultado() + '\n';
                                code += "MOV _var"+ t.getNumero() +", EAX"+  '\n';

                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");

                            }
                            if (t.getTipo().equals("DOUBLE")) {

                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));
                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto2));

                                code += "FLD _" + t2.getResultado() + '\n';
                                code += "FCOM _divisorCeroDOUBLE" + '\n';
                                code += "FSTSW _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var1_" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FDIV _" + t2.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
                            }
                        }

                        //Situación 4.a: Operación conmutativa entre una variable (o constante) y un registro. Conmutativa.

                        if (t.esVariable(1) && !t.esVariable(2)) {

                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando2().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto)); //Traigo el terceto

                                code += "MOV EBX, _" + t.getOperando2() + '\n'; // Muevo _varTerceto a EBX por problema de memoria, memoria
                                code += "CMP EBX, _divisorCeroULONG" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';

                                code += "MOV EAX, _" + t1.getResultado() + '\n';
                                code += "DIV _"  + t.getOperando2() + '\n'; // Sumo en EBX lo que estaba con la variable.
                                code += "MOV _var"+ t.getNumero() +", EAX"+  '\n'; // Muevo lo del registro a la variable.
                                t.setResultado("var" + t.getNumero()); // Seteo la variable.
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "ULONG", "Variable");

                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();
                                op1 = t.getOperando1().replace('.','_');
                                op1 = op1.replace('-','_');
                                op1 = op1.replace("+","__");

                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FCOM _divisorCeroDOUBLE" + '\n';
                                code += "FSTSW _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var1_" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                code += "JZ " + "LabelDivisionCero" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var1_" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "DOUBLE", "Variable");

                                code += "FLD _" + t.getOperando1() + '\n';
                                code += "FDIV _" + t1.getResultado() + '\n';
                                code += "FSTP _" + "var" + t.getNumero() + '\n';
                                t.setResultado("var" + t.getNumero());
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero(), Lexico.IDENTIFICADOR, "DOUBLE", "Variable");
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
                                code += "MOV EBX, _" + t.getOperando2() + '\n';
                                code += "MOV _" + t.getOperando1() + ", EBX" + '\n';
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

                                code += "FLD _" + op2 + '\n';
                                code += "FSTP _" + op1 + '\n';
                            }
                        }
                        break;

                    case "ComienzaFuncion":
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

                    case "InvocacionFuncion":
                        code += "CALL " + t.getOperando1() + "\n";
                        break;

                    case "Impresion":
                        String cadena = t.getOperando1();
                        System.out.println(t.getOperando1());
                        code += "invoke MessageBox, NULL, addr _" + cadena + ", addr _" + cadena + ", MB_OK \n";
                        break;

                    case "<":
                    case ">":
                    case "==":
                    case ">=":
                    case "<=":
                    case "<>":
                        //situacion 1: (operador, var/cte, var/cte)
                        if (t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                code += "MOV EBX, _" + t.getOperando2() + '\n';
                                code += "CMP _" + t.getOperando1() + ", EBX" + '\n';
                            }

                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();
                                String op2 = t.getOperando2();
                                op1 = t.getOperando1().replace('.','_');
                                op1 = op1.replace('-','_');
                                op1 = op1.replace("+","__");
                                op2 = t.getOperando2().replace('.','_');
                                op2 = op2.replace('-','_');
                                op2 = op2.replace("+","__");

                                code += "FLD _" + op1 + '\n';
                                code += "FCOMP _" + op2 + '\n';

                                code += "FSTSW _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                        }
                        //situacion 2: (operador, registro, var/cte)
                        if (!t.esVariable(1) && t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));
                                code += "CMP " + t1.getResultado() + ", _" + t.getOperando2() + '\n';

                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String op2 = t.getOperando2();
                                op2 = t.getOperando2().replace('.','_');
                                op2 = op2.replace('-','_');
                                op2 = op2.replace("+","__");

                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FCOMP _" + op2 + '\n';


                                code += "FSTSW _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                        }
                        //situacion 3: (operador, registro, registro)
                        if (!t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto2));
                                code += "MOV EBX"  + ", _" + t2.getResultado() + '\n';
                                code += "CMP _" + t1.getResultado() + ", EBX" + '\n';

                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                String nroTerceto2 = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t2 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto2));

                                code += "FLD _" + t1.getResultado() + '\n';
                                code += "FCOMP _" + t2.getResultado() + '\n';


                                code += "FSTSW _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                        }
                        //situacion 4: (operador, var/cte, registro)

                        if (t.esVariable(1) && !t.esVariable(2)) {
                            if (t.getTipo().equals("ULONG")) {
                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));
                                code += "CMP _" + t.getOperando1() + ", " + t1.getResultado() + '\n';

                            }
                            if (t.getTipo().equals("DOUBLE")) {
                                String op1 = t.getOperando1();
                                op1 = t.getOperando1().replace('.','_');
                                op1 = op1.replace('-','_');
                                op1 = op1.replace("+","__");

                                String nroTerceto = t.getOperando2().substring(1, t.getOperando2().lastIndexOf("]"));
                                Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));

                                code += "FLD _" + op1 + '\n';


                                code += "FCOMP _" + t1.getResultado() + '\n';
                                code += "FSTSW _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "MOV AX , _" + "var" + t.getNumero() + "_2bytes" + '\n';
                                code += "SAHF" + '\n';
                                Main.tablaSimbolos.agregarSimbolo("var" + t.getNumero() + "_2bytes", Lexico.IDENTIFICADOR, "ULONG", "Variable");
                            }
                        }
                        break;

                    case "BF":
                        String nroTerceto = t.getOperando1().substring(1, t.getOperando1().lastIndexOf("]"));
                        Terceto t1 = administradorTerceto.getTerceto(Integer.parseInt(nroTerceto));
                        code += this.tipoSalto(t1.getOperador()) + " Label" + t.getOperando2() + '\n';
                        break;

                    case "BI":
                        code += "JMP Label" + t.getOperando1() + '\n';
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
        code += "LabelDivisionCero: \n";
        code += "invoke MessageBox, NULL, addr _DivisionCero, addr _DivisionCero, MB_OK \n";
        code += "FINIT\n";
        return code;
    }

    private String tipoSalto(String comparador) {
        switch (comparador) {
            case "==":
                return "JNE";
            case "<>":
                return "JE";
            case "<":
                return "JAE";
            case "<=":
                return "JA";
            case ">":
                return "JBE";
            case ">=":
                return "JB";
        }
        return null;
    }


}
