%{
package Sintactico;
import Principal.*;
import CodigoIntermedio.*;
import java.util.ArrayList;
import java.util.Enumeration;
%}

%token IDENTIFICADOR CTE_ULONG MAYOR_IGUAL MENOR_IGUAL IGUAL_IGUAL DISTINTO ASIGNACION CTE_DOUBLE CADENA AND OR IF THEN ENDIF PRINT FUNC RETURN BEGIN END BREAK ULONG DOUBLE REPEAT PRE TRY CATCH TYPEDEF ELSE

%start programa


%%
programa : IDENTIFICADOR bloque_declarativo bloque_ejecutable {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +$1.sval + "'}");}
         |IDENTIFICADOR  bloque_ejecutable {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +$1.sval + "'}");}
         | error_programa
         ;

error_programa : bloque_declarativo bloque_ejecutable {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
	       | IDENTIFICADOR bloque_ejecutable bloque_declarativo {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Mal posicionamiento de sentencias declarativas");}
	       | IDENTIFICADOR bloque_declarativo error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de ejecución en el programa");}
	       ;


bloque_declarativo : declaracion
				|bloque_declarativo declaracion
                   ;

bloque_ejecutable :BEGIN bloque_sentencias END
		  | error_bloque_ejecutable
                  ;



bloque_sentencias: sentencia_ejecucion
                |bloque_sentencias sentencia_ejecucion
	;
 

error_bloque_ejecutable : bloque_sentencias END {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
				|BEGIN bloque_sentencias error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
		        | BEGIN bloque_declarativo bloque_sentencias END {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se pueden incluir declaraciones en el bloque ejecutable}");}
		        | BEGIN bloque_sentencias bloque_declarativo END {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se pueden incluir declaraciones en el bloque ejecutable}");}
		        ;


sentencia_ejecutable: control ';'
                        | seleccion ';'
                        | impresion ';'
                        | invocacion ';'
                        | asignacion
                        | error_ejecutable
                        ;


error_ejecutable: control error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
                | seleccion error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
                | impresion error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
             	| invocacion error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
               	;

sentencia_ejecucion : sentencia_ejecutable
                      |try_catch ';'
                      |error_sentencia_ejecucion
		    		;

error_sentencia_ejecucion: 	try_catch error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
                           ;



declaracion : tipo lista_de_variables ';'{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");
    	        String tipoVariable = $1.sval;
    	        lista_variables = (ArrayList<String>)$2.obj;
    	        for(String lexema: lista_variables){
                    String nuevoLexema = lexema + "@" + ambito;
                    if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(lexema, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("Variable");
                        ds.setTipo(tipoVariable);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                    }
                    else{
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable " + lexema + " en este ámbito}");
                        Main.tablaSimbolos.eliminarSimbolo(lexema);
                    }
    	        }
    	        lista_variables.clear();
    	        }
    	    |  funcion ';'


    	    | TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + $2.sval +"'}");
    	        if ($5.sval.equals($2.sval)){
    	            String nuevoLexema = $2.sval+ "@" + ambito;
    	            if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema($2.sval, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("TypeDef");
                        ds.setTipo($4.sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                        Enumeration iterador = Main.tablaSimbolos.getKeys();
                        while (iterador.hasMoreElements()) {
                            String lexema = (String) iterador.nextElement();
                            ds = Main.tablaSimbolos.getDatos(lexema);
                            if (ds.getTipo() != null)
                                if (ds.getTipo().equals("SinAsignar"))
                                    ds.setTipo($4.sval);
                        }
                    }
                    else
                         Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] { La funcion "+ $2.sval +" ya esta declarada}");
    	        }
                else
                    Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {" + $2.sval + " y " + $5.sval +" deben tener el mismo nombre}");

    	        }

    	    | error_declaracion
            ;


error_declaracion : tipo lista_de_variables error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
           	  | funcion error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
           	  ;



tipo : ULONG
       {$$ = new ParserVal("ULONG");}
     | DOUBLE
     {$$ = new ParserVal("DOUBLE");}
     ;

control : REPEAT'(' asignacion_repeat ';'condicion_repeat';' CTE_ULONG')' bloque_repeat {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if(($3.sval != null) && ($5.sval != null)){
            Terceto t = new Terceto("+", $3.sval, $7.sval);
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            int cantidad = adminTercetos.cantidadTercetos() -1;
            t =  new Terceto(":=", $3.sval, "["+ cantidad + "]");
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            t = new Terceto("BI", null, null);
            adminTercetos.agregarTerceto(t);
             if ($9.sval != null)
                   adminTercetos.desapilar();
            adminTercetos.desapilar(); //para completar BF
            adminTercetos.desapilarRepeat();
            t = new Terceto("Label"+adminTercetos.cantidadTercetos(),null,null);
            adminTercetos.agregarTerceto(t);


        }
        //TODO ELSE
    }

	| error_control
	;

error_control : REPEAT asignacion_repeat ';' condicion_repeat ';' CTE_ULONG ')' bloque_repeat{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
	          | REPEAT '('               ';' condicion_repeat ';' CTE_ULONG ')' bloque_repeat{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
	          | REPEAT'('asignacion_repeat    condicion_repeat';' CTE_ULONG')'bloque_repeat {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
	          | REPEAT'('asignacion_repeat ';'         ';' CTE_ULONG')'bloque_repeat {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
	          | REPEAT'('asignacion_repeat ';'condicion_repeat    CTE_ULONG')'bloque_repeat {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
	          | REPEAT'('asignacion_repeat ';'condicion_repeat';'        ')'bloque_repeat {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
	          | REPEAT'('asignacion_repeat ';'condicion_repeat';'CTE_ULONG   bloque_repeat {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
	          | REPEAT'('asignacion_repeat ';'condicion_repeat';'CTE_ULONG')' error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
	          ;

asignacion_repeat: IDENTIFICADOR ASIGNACION CTE_ULONG {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion del repeat: "+ $1.sval + " := "+ $3.sval + "}");
                    String ambitoVariable = Main.tablaSimbolos.verificarAmbito($1.sval, ambito);
                    if(ambitoVariable != null) {
                        String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                        if(tipoIdentificador.equals("ULONG")){
                            Terceto t = new Terceto(":=", ambitoVariable, $3.sval);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto("Label"+adminTercetos.cantidadTercetos(), null, null);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.apilar(t.getNumero());
                            $$ = new ParserVal(ambitoVariable);
                        }
                        else
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {los tipos son incompatibles}");
                    }
                    else
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + $1.sval +" no fue declarada}");
                    }
                     | error_asignacion_repeat { $$ = new ParserVal(null); }
                    ;

error_asignacion_repeat:   ASIGNACION CTE_ULONG {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
                         | IDENTIFICADOR   CTE_ULONG {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ':='}");}
                         | IDENTIFICADOR ASIGNACION error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
                        ;


condicion_repeat: condicion_booleana{
                                Operando op = (Operando)$1.obj;
                                if (op != null){
                                    Terceto t = new Terceto("BF", op.getValor(), null);
                                    adminTercetos.agregarTerceto(t);
                                    adminTercetos.apilar(t.getNumero());
                                    $$ = new ParserVal(op.getValor());
                                }
                                else
                                    $$ = new ParserVal(null);
                                 }
                                ;



bloque_repeat: BEGIN bloque_control END {$$ = new ParserVal($2.sval);}

            ;

bloque_control : sentencia_control {
            if ($1.sval != null)
                $$ = new ParserVal($1.sval);

            else
                $$ = new ParserVal(null);
}

		  	| bloque_control sentencia_control {
		  	    if ($2.sval != null)
                    $$ = new ParserVal($2.sval);

                else
                    $$ = new ParserVal(null);

		  	}


		  	;

sentencia_control : sentencia_ejecucion 
		    | BREAK ';' {
		     Terceto t = new Terceto("BREAK",null,null);
             adminTercetos.agregarTerceto(t);
		     Terceto t1 = new Terceto("BI", null, null);
             adminTercetos.agregarTerceto(t1);
             adminTercetos.apilar(t1.getNumero());
             $$ = new ParserVal("BREAK");
		    }
		    | error_sentencia_control {$$ = new ParserVal(null);}
		    ;

error_sentencia_control : BREAK error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
               	 	;

asignacion : IDENTIFICADOR ASIGNACION expresion ';' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion de " + $1.sval +"}");
            String ambitoVariable = Main.tablaSimbolos.verificarAmbito($1.sval, ambito);
            //TODO MUCHOS ELSE
            if(ambitoVariable != null){
                String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                Operando op = (Operando)$3.obj;
                if(op != null && tipoIdentificador != null){
                     String valorOp = op.getValor();
                        if(valorOp!= null && !valorOp.contains("[")){
                            if(Main.tablaSimbolos.getDatos(valorOp).getUso() != null && Main.tablaSimbolos.getDatos(ambitoVariable).getUso() != null)
                                if(Main.tablaSimbolos.getDatos(valorOp).getUso().equals("NombreFuncion") && Main.tablaSimbolos.getDatos(ambitoVariable).getUso().equals("VariableTypeDef")){
                                    Main.tablaSimbolos.getDatos(ambitoVariable).setFuncionReferenciada(valorOp);
                                    Main.tablaSimbolos.getDatos(ambitoVariable).setParametro(Main.tablaSimbolos.getDatos(valorOp).getParametro());
                                }

                            if(Main.tablaSimbolos.getDatos(valorOp).getUso() != null && Main.tablaSimbolos.getDatos(ambitoVariable).getUso() != null)
                                if(Main.tablaSimbolos.getDatos(valorOp).getUso().equals("VariableTypeDef") && Main.tablaSimbolos.getDatos(ambitoVariable).getUso().equals("VariableTypeDef"))
                                    if(!Main.tablaSimbolos.getDatos(valorOp).getFuncionReferenciada().equals(""))
                                        Main.tablaSimbolos.getDatos(ambitoVariable).setFuncionReferenciada(Main.tablaSimbolos.getDatos(valorOp).getFuncionReferenciada());
                        }

               if (tipoIdentificador.equals(op.getTipo())){
                    Terceto t = new Terceto(":=", ambitoVariable, op.getValor());
                   t.setTipo(op.getTipo());
                   adminTercetos.agregarTerceto(t);
                    $$ = new ParserVal(new Operando(tipoIdentificador, "[" + t.getNumero()+ "]"));
                    }
                    else{
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                    }
           }
           }
            else{
                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + $1.sval +" no fue declarada}");
            }


        }
	   	  |error_asignacion;
	   ;


error_asignacion : ASIGNACION expresion  ';' {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
			   |IDENTIFICADOR expresion  ';' {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
			   |IDENTIFICADOR ASIGNACION  ';'{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
			   |IDENTIFICADOR ASIGNACION expresion error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
		  ;


seleccion: IF condicion_if THEN bloque_if ENDIF {
            if($2.sval != null){
                adminTercetos.desapilar();
                Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t);
                }
            //TODO ELSE
            }

	 | IF  condicion_if  THEN bloque_if{
	        if($2.sval != null){
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.desapilar();
                Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t1);
                adminTercetos.apilar(t.getNumero());
            }
            //TODO ELSE
            }
            ELSE bloque_if ENDIF{
                if($2.sval != null) {
                   adminTercetos.desapilar();
                   Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                   adminTercetos.agregarTerceto(t);
            }
            //TODO ELSE
       }
	 | error_seleccion
	 ;


condicion_if: '(' condicion ')'
              {
                Operando op = (Operando)$2.obj;
                if(op != null){
                    Terceto t = new Terceto("BF", op.getValor(), null);
                    adminTercetos.agregarTerceto(t);
                    adminTercetos.apilar(t.getNumero());
                    $$ = new ParserVal(op.getValor());
                }
                else
                    $$ = new ParserVal(null);
              }
            | error_condicion_if
            ;

error_condicion_if:  '(' condicion error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
                   ;

bloque_if : sentencia_ejecucion
            | BEGIN sentencia_ejecucion bloque_sentencias END ';'
            | error_bloque_if
            ;

error_bloque_if: BEGIN sentencia_ejecucion END ';' {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
                | BEGIN sentencia_ejecucion bloque_sentencias END error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
                | BEGIN sentencia_ejecucion END error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
                ;

error_seleccion :     condicion_if  THEN  bloque_if ENDIF {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
                | IF                THEN  bloque_if ENDIF {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
                | IF  condicion_if        bloque_if ENDIF {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
                | IF  condicion_if  THEN            ENDIF {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
                | IF  condicion_if  THEN  bloque_if error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF al final}");}
                | IF  condicion_if  THEN  bloque_if bloque_if ELSE           ENDIF {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
	            | IF  condicion_if  THEN  bloque_if bloque_if ELSE bloque_if error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
	            ;


impresion: PRINT '(' CADENA ')'  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + $3.sval  + "'}");
           Terceto t = new Terceto("Impresion", $3.sval, null);
           adminTercetos.agregarTerceto(t);
           }

           | PRINT '('  ')'  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + $3.sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
	 ;


invocacion : IDENTIFICADOR '(' CTE_ULONG ')' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + $1.sval + "'}");
              String s = "[";
               if ($3.sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito($1.sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo() == "ULONG"){
                        if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                            Terceto t = new Terceto(":=", Main.tablaSimbolos.getDatos(funcionRef).getParametro(), $3.sval);
                            t.setTipo(Main.tablaSimbolos.getDatos(funcionRef).getTipo());
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto("InvocacionFuncion", funcionRef, ambitoFuncion);
                             if (ambito.contains("@")){
                                String ambitoInvocacion = ambito;
                                ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                t.setAmbitoInvocacion(ambitoInvocacion);
                            }
                            adminTercetos.agregarTerceto(t);
                            funcionRef = funcionRef.substring(0, funcionRef.lastIndexOf("@"));
                            s +=adminTercetos.cantidadTercetos() -1 + "]";

                            $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo(), s));

                        }
                        else{
                            Terceto t = new Terceto(":=", Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro(), $3.sval);
                            t.setTipo(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo());
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                            adminTercetos.agregarTerceto(t);
                            s += adminTercetos.cantidadTercetos() -1+ "]";

                            $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo(), s));

                        }
                    }
                    else
                        if(ambitoFuncion == null){
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {La función "+$1.sval+" esta fuera de alcance}");
                            $$ = new ParserVal(null);
                        }
                        else{
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {Se invocó a la función "+$1.sval+" con un parámetro de otro tipo}");
                            $$ = new ParserVal(null);
                        }
               }
            }

            | IDENTIFICADOR '(' CTE_DOUBLE ')' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + $1.sval + "'}");
                 String s = "[";
                 if ($3.sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito($1.sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo() == "DOUBLE"){
                          if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();

                             Terceto t = new Terceto(":=", Main.tablaSimbolos.getDatos(funcionRef).getParametro(), $3.sval);
                             t.setTipo(Main.tablaSimbolos.getDatos(funcionRef).getTipo());
                             adminTercetos.agregarTerceto(t);
                             t = new Terceto("InvocacionFuncion", funcionRef, ambitoFuncion);
                             if (ambito.contains("@")){
                                String ambitoInvocacion = ambito;
                                ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                t.setAmbitoInvocacion(ambitoInvocacion);
                            }


                            adminTercetos.agregarTerceto(t);

                            funcionRef = funcionRef.substring(0, funcionRef.lastIndexOf("@"));
                            s += adminTercetos.cantidadTercetos() -1 + "]";

                            $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo(), s));


                        }
                        else{
                             Terceto t = new Terceto(":=",  Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro(),$3.sval);
                              t.setTipo(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo());
                              adminTercetos.agregarTerceto(t);
                             t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                             adminTercetos.agregarTerceto(t);

                            s += adminTercetos.cantidadTercetos() -1 + "]";

                                $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo(), s));

                        }
                    }
                    else
                        if(ambitoFuncion == null){
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {La función "+$1.sval+" esta fuera de alcance}");
                             $$ = new ParserVal(null);
                        }
                        else{
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {Se invocó a la función "+$1.sval+" con un parámetro de otro tipo}");
                            $$ = new ParserVal(null);
                        }
                }
            }

            |IDENTIFICADOR '(' IDENTIFICADOR ')' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + $1.sval + "'}");
                 String s = "[";
                 if ($3.sval != null && $1.sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito($1.sval, ambito);
                    String ambitoParametro = Main.tablaSimbolos.verificarAmbito($3.sval, ambito);
                    if(ambitoFuncion != null){
                        if (ambitoParametro != null){
                             String nombreParametro = Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro();
                                if (!nombreParametro.equals("")){
                                    if (Main.tablaSimbolos.getDatos(nombreParametro).getTipo().equals(Main.tablaSimbolos.getDatos(ambitoParametro).getTipo())){
                                         if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                                            String variableFuncion = Main.tablaSimbolos.getDatos(funcionRef).getParametro();
                                            Terceto t = new Terceto(":=", variableFuncion ,ambitoParametro );
                                            t.setTipo(Main.tablaSimbolos.getDatos(variableFuncion).getTipo());
                                            adminTercetos.agregarTerceto(t);
                                            t = new Terceto("InvocacionFuncion", funcionRef, ambitoFuncion);
                                            if (ambito.contains("@")){
                                                String ambitoInvocacion = ambito;
                                                ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                                t.setAmbitoInvocacion(ambitoInvocacion);
                                            }
                                            adminTercetos.agregarTerceto(t);

                                            funcionRef = funcionRef.substring(0, funcionRef.lastIndexOf("@"));
                                             s += adminTercetos.cantidadTercetos() -1 + "]";

                                                $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo(), s));


                                        }
                                        else{
                                             String variableFuncion = Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro();
                                              Terceto t = new Terceto(":=", variableFuncion ,ambitoParametro );
                                              t.setTipo(Main.tablaSimbolos.getDatos(variableFuncion).getTipo());
                                              adminTercetos.agregarTerceto(t);
                                              t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                                             if (ambito.contains("@")){
                                                  String ambitoInvocacion = ambito;
                                                  ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                                  t.setAmbitoInvocacion(ambitoInvocacion);
                                              }

                                             adminTercetos.agregarTerceto(t);

                                            s += adminTercetos.cantidadTercetos() -1 + "]";

                                               $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo(), s));


                                        }
                                }
                                else{
                                   Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {Se invocó a la función "+$1.sval+" con un parámetro de otro tipo}");
                                   $$ = new ParserVal(null);
                                    }
                            }
                            else{

                            }
                        }
                        else{
                             Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {El parámetro "+$3.sval+" esta fuera de alcance o no esta declarado}");
                        }
                    }
                    else{
                           Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {La función "+$1.sval+" esta fuera de alcance}");
                           $$ = new ParserVal(null);
                        }
                 }
                 else
                     $$ = new ParserVal(null);
            }
	        | error_invocacion
	        ;

error_invocacion: IDENTIFICADOR '(' ')' {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
		| IDENTIFICADOR '('CTE_ULONG error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
		| IDENTIFICADOR '('CTE_DOUBLE error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
		| IDENTIFICADOR '('IDENTIFICADOR error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
		;

try_catch: parte_try CATCH bloque_catch{adminTercetos.desapilar();
                                        Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                        adminTercetos.agregarTerceto(t);}
           |error_try_catch
            ;


parte_try: TRY sentencia_ejecutable {
                                      Terceto t = new Terceto("BI", null, null);
                                      adminTercetos.agregarTerceto(t);
                                      adminTercetos.desapilar();
                                      Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                      adminTercetos.agregarTerceto(t1);
                                      adminTercetos.apilar(t.getNumero());
}
            | error_parte_try;
            ;

error_parte_try: TRY error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
                ;

error_try_catch:   parte_try bloque_catch  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
                   | parte_try CATCH error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
                   | TRY try_catch CATCH bloque_catch {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
                   ;

bloque_catch: BEGIN bloque_1 END
            ;

bloque_1: sentencia_ejecutable
          |bloque_1 sentencia_ejecutable
	      ;

lista_de_variables : lista_de_variables ',' IDENTIFICADOR {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se leyo el Identificador -> " + $3.sval);
			        lista_variables = (ArrayList<String>) $1.obj;
			        lista_variables.add($3.sval);
			        $$ = new ParserVal(lista_variables);
			        }
			        |IDENTIFICADOR {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + $1.sval + "}");
			                        lista_variables.add($1.sval);
                                    $$ = new ParserVal(lista_variables);
                                    }
      		        | error_lista_de_variables
                    ;


error_lista_de_variables: lista_de_variables IDENTIFICADOR {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
                        ;

funcion :  declaracion_funcion bloque_funcion
         {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ $1.sval +"'" );
            Operando op = (Operando)$2.obj;
            if($1.sval != null && op != null ){ //si se declaró bien y se cumplen los PRE (en caso de haberlos)

                   ambito = ambito.substring(0,ambito.lastIndexOf("@"));
                    Terceto t = new Terceto("RetornoFuncion", op.getValor(),$1.sval);
                    t.setTipo(op.getTipo());
                    adminTercetos.agregarTerceto(t);
                    t = new Terceto("FinFuncion", $1.sval, null);
                    adminTercetos.agregarTerceto(t);
                    $$ = new ParserVal($1.sval);

            }

            else
                 $$ = new ParserVal(null);
         }
        | error_funcion
        ;

error_funcion : declaracion_funcion   error   {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
	      ;

declaracion_funcion: tipo FUNC IDENTIFICADOR'('parametro')'{
                    parametroCopiaValor = $5.sval;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = $3.sval + "@" + ambito;
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema($3.sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("NombreFuncion");
                            ds.setTipo($1.sval);
                            ambito = ambito + "@" + $3.sval;
                            ds.setParametro(parametroCopiaValor +"@"+ ambito);
                            Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);

                            Main.tablaSimbolos.reemplazarLexema(parametroCopiaValor, parametroCopiaValor +"@"+ ambito); // Se agrega el ambito al parametro (nombre de la función)
                            Terceto t = new Terceto("ComienzaFuncion", nuevoLexema, null);
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.agregarFuncion(nuevoLexema);

                            $$ = new ParserVal(nuevoLexema);
                        }
                        else{
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La funcion '" + $3.sval + "' ya fue declarada en este ámbito}");
                            $$ = new ParserVal(null);  // se setea null para luego comprobar si se declaró o no
                        }
                    }
                    parametroCopiaValor = "";
                    }
                    |error_declaracion_funcion
                    ;

error_declaracion_funcion:        FUNC IDENTIFICADOR'('parametro')'     {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta indicar el tipo}");}
                           |tipo   IDENTIFICADOR'('parametro')'     {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
                           |tipo FUNC           '('parametro')'     {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
                           |tipo FUNC IDENTIFICADOR parametro')'    {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
                           |tipo FUNC IDENTIFICADOR'('       ')'    {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
                           |tipo  FUNC IDENTIFICADOR'('parametro  error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
                           ;

parametro : tipo IDENTIFICADOR{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos($2.sval); // el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)
                ds.setUso("NombreParametro");
                ds.setTipo($1.sval);
                Main.tablaSimbolos.setDatosSimbolo($2.sval, ds);
                $$ = new ParserVal($2.sval);
                }
	  | error_parametro
	  ;

error_parametro :  tipo error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
		 ;


funcion_type: FUNC '(' tipo ')' ';' IDENTIFICADOR lista_de_variables{
            if ($3.sval != null){
                 lista_variables = (ArrayList<String>)$7.obj;
                 if (lista_variables != null){
                     for(String lexema: lista_variables){
                         String nuevoLexema = lexema + "@" + ambito;
                         if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                             Main.tablaSimbolos.reemplazarLexema(lexema, nuevoLexema);
                             DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                             ds.setUso("VariableTypeDef");
                             ds.setTipo("SinAsignar");
                             Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                         }
                         else{
                             Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable de función " + lexema + " en este ámbito}");
                             Main.tablaSimbolos.eliminarSimbolo(lexema);
                            }
                     }
                 }

           }
           lista_variables.clear();
            $$= new ParserVal($6.sval);


         }
         ;





bloque_funcion : bloque_declarativo bloque_ejecucion_funcion{
                Operando op = (Operando)$2.obj;
                if (op!= null)
                    $$ = new ParserVal((Operando)$2.obj);
                else
                    $$ = new ParserVal (null);
           }
           | bloque_ejecucion_funcion {
                Operando op = (Operando)$1.obj;
                if (op != null)
                     $$ = new ParserVal((Operando)$1.obj);
                else
                    $$ = new ParserVal (null);
           }
 	       | error_bloque_funcion { $$ = new ParserVal(null);}
	       ;

error_bloque_funcion : bloque_declarativo error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
		     ;


bloque_ejecucion_funcion :  BEGIN RETURN '('condicion')' ';' END{
                             Operando op = (Operando)$4.obj;
                             if (op != null){
                                  $$ = new ParserVal((Operando)$4.obj);
                              }
                                 else
                                     $$ = new ParserVal (null);
                      }

                |BEGIN bloque_sentencias RETURN '('condicion')' ';' END{
                        Operando op = (Operando)$5.obj;
                        if (op != null){
                             $$ = new ParserVal((Operando)$5.obj);
                         }
                            else
                                $$ = new ParserVal (null);
                 }

			 | BEGIN pre_condicion ';' bloque_sentencias RETURN '('condicion')' ';' END {
			            Operando op = (Operando)$7.obj;
			            if ($2.sval != null && op != null){
			                $$ = new ParserVal((Operando)$7.obj);
			            }
			            else
			                $$ = new ParserVal (null);
			 }
			 | BEGIN pre_condicion ';' RETURN '('condicion')' ';' END{
                        Operando op = (Operando)$6.obj;
                        if ($2.sval != null && op != null){
                            $$ = new ParserVal((Operando)$6.obj);
                        }
                        else
                             $$ = new ParserVal (null);
             }

			 | error_bloque_ejecucion_funcion { $$ = new ParserVal (null);}
   			 ;			

error_bloque_ejecucion_funcion :       bloque_sentencias RETURN '('condicion')' ';' END  {Main.listaErrores.add("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
				|BEGIN bloque_sentencias        '('condicion')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
				|BEGIN bloque_sentencias RETURN    condicion')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
				|BEGIN bloque_sentencias RETURN '('         ')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
				|BEGIN bloque_sentencias RETURN '('condicion    ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
				|BEGIN bloque_sentencias RETURN '('condicion')'     END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
				|BEGIN bloque_sentencias  END {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
				|BEGIN bloque_sentencias RETURN '('condicion')' ';' error  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}

				|      pre_condicion ';' bloque_sentencias RETURN '('condicion')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
				|BEGIN pre_condicion     bloque_sentencias RETURN '('condicion')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
				|BEGIN pre_condicion ';' bloque_sentencias        '('condicion')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
				|BEGIN pre_condicion ';' bloque_sentencias RETURN    condicion')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
				|BEGIN pre_condicion ';' bloque_sentencias RETURN '('         ')' ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
				|BEGIN pre_condicion ';' bloque_sentencias RETURN '('condicion    ';' END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
				|BEGIN pre_condicion ';' bloque_sentencias RETURN '('condicion')'     END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
				|BEGIN pre_condicion ';' bloque_sentencias RETURN '('condicion')' ';' error  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
                |BEGIN pre_condicion ';' bloque_sentencias END  {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
                ;


pre_condicion: PRE ':' '(' condicion ')'{
                      Operando op = (Operando)$4.obj;
                      if (op != null){
                         Terceto t = new Terceto("BF", op.getValor(), null);
                         adminTercetos.agregarTerceto(t);
                         adminTercetos.apilar(t.getNumero());
                         $$ = new ParserVal(op.getValor());
                     }
                     else
                         $$ = new ParserVal(null);
                   }
             |error_pre_condicion
             ;

error_pre_condicion:      ':''('condicion')'   {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
                    | PRE    '('condicion')'    {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
                    | PRE ':'   condicion')'     {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
                    | PRE ':''('         ')'     {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
                    | PRE ':''('condicion  error {Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
                    ;



condicion: condicion_or {
                            Operando op = (Operando)$1.obj;
                            if(op != null)
                                $$ = new ParserVal((Operando)$1.obj);

                            else{
                                $$ = new ParserVal(null);
                                }

                }
                ;

condicion_or : condicion_and  { $$ = new ParserVal((Operando)$1.obj);}

	  | condicion_or OR condicion_and{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");

	                    Operando op1 = (Operando)$1.obj;
                        Operando op2 = (Operando)$3.obj;

                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("OR", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                               $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                $$ = new ParserVal(null);
                             }
                        }
                        else{
                               $$ = new ParserVal(null);
                        }
        }
	  ;

condicion_and: condicion_booleana { $$ = new ParserVal((Operando)$1.obj);}

	    | condicion_and AND condicion_booleana {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");
	                    Operando op1 = (Operando)$1.obj;
                        Operando op2 = (Operando)$3.obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("AND", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                $$ = new ParserVal(null);
                             }
                        }
                        else{
                               $$ = new ParserVal(null);
                        }
        }
	    ;

condicion_booleana: expresion comparador expresion {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  $2.sval + "}");

		                            Operando op1 = (Operando)$1.obj;
                                    Operando op2 = (Operando)$3.obj;
                                    if(op1 != null && op2 !=null){
                                        if (op1.getTipo().equals(op2.getTipo())){
                                            Terceto t = new Terceto($2.sval, op1.getValor(), op2.getValor());
                                            t.setTipo(op1.getTipo());
                                            adminTercetos.agregarTerceto(t);
                                            $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                                        }
                                        else{
                                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                            $$ = new ParserVal(null);
                                         }
                                    }
                                    else{
                                           $$ = new ParserVal(null);
                                    }
                   }
                | expresion { $$ = new ParserVal((Operando)$1.obj);}

        ;

expresion: termino { $$ = new ParserVal((Operando)$1.obj);}

	  | expresion '+' termino
	  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");
	    Operando op1 = (Operando)$1.obj;
                        Operando op2 = (Operando)$3.obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("+", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                $$ = new ParserVal(null);
                             }
                        }
                        else{
                               $$ = new ParserVal(null);
                        }
      }
	  | expresion '-' termino
	  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");
	    Operando op1 = (Operando)$1.obj;
                        Operando op2 = (Operando)$3.obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("-", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                $$ = new ParserVal(null);
                             }
                        }
                        else{
                               $$ = new ParserVal(null);
                        }
        }
	  ;

termino : termino '*' factor
        {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");
                Operando op1 = (Operando)$1.obj;
                        Operando op2 = (Operando)$3.obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("*", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                $$ = new ParserVal(null);
                             }
                        }
                        else{
                               $$ = new ParserVal(null);
                        }
                    }
	| termino '/' factor
            {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");
                Operando op1 = (Operando)$1.obj;
                Operando op2 = (Operando)$3.obj;
                if(op1 != null && op2 !=null){
                    if (op1.getTipo().equals(op2.getTipo())){
                        Terceto t = new Terceto("/", op1.getValor(), op2.getValor());
                        t.setTipo(op1.getTipo());
                        adminTercetos.agregarTerceto(t);
                        $$ = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                    }
                    else{
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                        $$ = new ParserVal(null);
                     }
                }
                else{
                       $$ = new ParserVal(null);
                }
            }

	| factor  { $$ = new ParserVal((Operando)$1.obj);}
        ;


factor 	:  '-' factor  { if (chequearFactorNegado()){
                                  Operando operando = (Operando) $2.obj;
                                  $$ = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
        | CTE_DOUBLE {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + $1.sval + "}");
            $$ = new ParserVal(new Operando("DOUBLE", $1.sval));
        }
        | CTE_ULONG {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + $1.sval + "}");
         $$ = new ParserVal(new Operando("ULONG", $1.sval));
         }
	    | IDENTIFICADOR {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + $1.sval +"}");
	            String ambitoVariable = Main.tablaSimbolos.verificarAmbito($1.sval, ambito);
                	if(ambitoVariable != null)
                        $$ = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                    else {
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + $1.sval +" no fue declarada}");
                        $$ = new ParserVal(null);
	                }
	          }
	    | invocacion   {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocacion de funcion}");
                       Operando op = (Operando)$1.obj;

                       String nombre = op.getValor();
                       String tipo = op.getTipo();
                       if(nombre != null){

                           String ambitoVariable = Main.tablaSimbolos.verificarAmbito(nombre, ambito);
                           if (!nombre.contains("[")){
                               if (ambitoVariable != null)
                                    $$ = new ParserVal(new Operando(tipo, ambitoVariable));
                               else
                               Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La Funcion " + nombre +" no fue declarada}");
                           }
                         else
                            $$ = new ParserVal(new Operando(tipo, nombre));
                        }

                     }
        ;


comparador : '<'        { $$ = new ParserVal("<");}
	   | '>'            { $$ = new ParserVal(">");}
	   | IGUAL_IGUAL    { $$ = new ParserVal("==");}
       | MAYOR_IGUAL    { $$ = new ParserVal(">=");}
	   | MENOR_IGUAL    { $$ = new ParserVal("<=");}
	   | DISTINTO       { $$ = new ParserVal("<>");}
	   ;


%%

private Lexico lexico;
private AdministradorTercetos adminTercetos;
private String ambito;
private ArrayList<String> lista_variables;  //lista de declaración de variables
private String parametroCopiaValor;

public Parser(Lexico lexico, AdministradorTercetos adminTercetos)
{
  this.lexico= lexico;
  this.adminTercetos = adminTercetos;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
  this.parametroCopiaValor = "";
}

public int yylex(){
   Token token = this.lexico.getToken();
   if(token != null ){
   	int val =token.getId();
   	yylval = new ParserVal(token.getLexema());
   	return val;
   }
   return 0;
}

public void yyerror(String s){

}

public boolean chequearFactorNegado(){
	String lexema = yylval.sval;
	int id = Main.tablaSimbolos.getId(lexema);
	if(id == Lexico.CTE_ULONG){
	    Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una constante ULONG fuera de rango}");
		Main.tablaSimbolos.eliminarSimbolo(lexema);
	}
	else if (id == Lexico.CTE_DOUBLE) {
		double valor = -1*Double.parseDouble(lexema);
		if(( valor > 2.2250738585272014e-308 && valor < 1.7976931348623157e+308) || (valor > -1.7976931348623157e+308 && valor < -2.2250738585072014e-308) || (valor == 0.0)){
                	Main.tablaSimbolos.modificarSimbolo(lexema, String.valueOf(valor));
                	return true;
        }
        else {
            Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "]  {Se detectó una constante DOUBLE fuera de rango}");
            Main.tablaSimbolos.eliminarSimbolo(lexema);
	 	}
	}
	return false;
}
