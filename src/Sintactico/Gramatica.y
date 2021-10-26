%{
package Sintactico;
import Principal.*;
%}

%token IDENTIFICADOR CTE_ULONG MAYOR_IGUAL MENOR_IGUAL IGUAL_IGUAL DISTINTO ASIGNACION CTE_DOUBLE CADENA AND OR IF THEN ENDIF PRINT FUNC RETURN BEGIN END BREAK ULONG DOUBLE REPEAT PRE TRY CATCH TYPEDEF ELSE

%start programa


%%
programa : IDENTIFICADOR bloque_declarativo bloque_ejecutable {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +$1.sval + "'}");}
         |IDENTIFICADOR  bloque_ejecutable {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +$1.sval + "'}");}
         | error_programa
         ;

error_programa : bloque_declarativo bloque_ejecutable {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
	       | IDENTIFICADOR bloque_ejecutable bloque_declarativo {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
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
 

error_bloque_ejecutable : bloque_sentencias END {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
				|BEGIN bloque_sentencias error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
		        ;


sentencia_ejecutable: control ';'
                        | seleccion ';'
                        | impresion ';'
                        | invocacion ';'
                        | asignacion ';'
                        |error_ejecucion
                        ;


error_ejecucion: control error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
                |seleccion error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
                | impresion error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
           	    | asignacion error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
             	| invocacion error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
               	 ;

sentencia_ejecucion : sentencia_ejecutable
                      |try_catch ';'
                      |error_sentencia_ejecucion
		    		;

error_sentencia_ejecucion: 	try_catch error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
                           ;



declaracion : tipo lista_de_variables ';'{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
    	    | tipo funcion ';'
    	    | TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + $2.sval +"'}");}
    	    | error_declaracion
            ;


error_declaracion : tipo lista_de_variables error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
           	  | tipo funcion error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
           	  | funcion ';' {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + $1.sval + "}");}
           	  ;



tipo : ULONG
     | DOUBLE
     ;

control : REPEAT'('IDENTIFICADOR '=' CTE_ULONG';'condicion';' CTE_ULONG')' bloque_repeat {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
	| error_control
	;

error_control : REPEAT IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
	 | REPEAT '('  '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
	 | REPEAT'('IDENTIFICADOR   CTE_ULONG';'condicion';' CTE_ULONG')'bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
	 | REPEAT'('IDENTIFICADOR '='       ';'condicion';' CTE_ULONG')'bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
	 | REPEAT'('IDENTIFICADOR '=' CTE_ULONG   condicion';' CTE_ULONG')'bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
	 | REPEAT'('IDENTIFICADOR '=' CTE_ULONG';'         ';' CTE_ULONG')'bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
	 | REPEAT'('IDENTIFICADOR '=' CTE_ULONG';'condicion    CTE_ULONG')'bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
	 | REPEAT'('IDENTIFICADOR '=' CTE_ULONG';'condicion';'        ')'bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
	 | REPEAT'('IDENTIFICADOR '=' CTE_ULONG';'condicion';'CTE_ULONG   bloque_repeat {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
	 | REPEAT'('IDENTIFICADOR '=' CTE_ULONG';'condicion';'CTE_ULONG')' error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
	 ;

bloque_repeat: BEGIN bloque_control END
            ;

bloque_control : sentencia_control
		  	| bloque_control sentencia_control
		  	;

sentencia_control : sentencia_ejecucion 
		    | BREAK ';'
		    | error_sentencia_control
		    ;

error_sentencia_control : BREAK error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
               	 	;

asignacion : IDENTIFICADOR ASIGNACION expresion2  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + $1.sval + ":= " + $3.sval +"}");}
	   	  |error_asignacion;
	   ;


error_asignacion : ASIGNACION termino {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
			   |IDENTIFICADOR termino {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
			   |IDENTIFICADOR ASIGNACION error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
		 	  
		  ;


seleccion: IF '(' condicion ')' THEN bloque_if ENDIF
	 | IF '(' condicion ')' THEN bloque_if ELSE bloque_if ENDIF
	 | error_seleccion
	 ;

bloque_if : sentencia_ejecucion
            | BEGIN sentencia_ejecucion bloque_sentencias END ';'
            | error_bloque_if
            ;

error_bloque_if: BEGIN sentencia_ejecucion END ';' {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
                | BEGIN sentencia_ejecucion bloque_sentencias END error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
                | BEGIN sentencia_ejecucion END error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
                ;

error_seleccion :    '('condicion ')' THEN bloque_if ENDIF {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
		| IF     condicion ')' THEN bloque_if ENDIF {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
		| IF '('        ')' THEN  bloque_if ENDIF {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
		| IF '(' condicion    THEN bloque_if  ENDIF {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
		| IF '(' condicion')'       bloque_if ENDIF {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
		| IF '(' condicion ')' THEN              ENDIF {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
		| IF '(' condicion ')' THEN bloque_if     {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
		| IF '(' condicion ')' THEN  bloque_if  ELSE                 ENDIF{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
		| IF '(' condicion ')' THEN  bloque_if  ELSE bloque_if        {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
		;


impresion: PRINT '(' CADENA ')'  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + $3.sval  + "'}");}
           | PRINT '('  ')'  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + $3.sval  + "'}");}
	 ;


invocacion : IDENTIFICADOR '(' CTE_ULONG ')' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + $1.sval + "'}");}
            | IDENTIFICADOR '(' CTE_DOUBLE ')' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + $1.sval + "'}");}
            |IDENTIFICADOR '(' IDENTIFICADOR ')' {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + $1.sval + "'}");}
	        | error_invocacion
	        ;

error_invocacion: IDENTIFICADOR '(' ')' {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
		| IDENTIFICADOR '('CTE_ULONG error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
		| IDENTIFICADOR '('CTE_DOUBLE error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
		| IDENTIFICADOR '('IDENTIFICADOR error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
		;

try_catch: TRY sentencia_ejecutable CATCH bloque_catch
           |error_try_catch
            ;



error_try_catch:    TRY  CATCH bloque_catch  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
                   | TRY sentencia_ejecutable bloque_catch  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
                   | TRY sentencia_ejecutable CATCH error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
                   | TRY try_catch CATCH bloque_catch {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
                   ;

bloque_catch: BEGIN bloque_1 END
            ;

bloque_1: sentencia_ejecutable
          |bloque_1 sentencia_ejecutable
	      ;

lista_de_variables : lista_de_variables ',' IDENTIFICADOR {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + $3.sval);}
			        |IDENTIFICADOR {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + $1.sval + "}");}
      		        | error_lista_de_variables
                    ;


error_lista_de_variables: lista_de_variables IDENTIFICADOR {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
                        ;

funcion : FUNC IDENTIFICADOR'('parametro')' bloque_funcion  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ $2.sval +"'" );}
        | error_funcion
        ;


error_funcion :      IDENTIFICADOR'('parametro')' bloque_funcion {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
	      | FUNC         '('parametro')' bloque_funcion {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
	      | FUNC IDENTIFICADOR parametro')' bloque_funcion {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
	      | FUNC IDENTIFICADOR'('       ')' bloque_funcion {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
	      | FUNC IDENTIFICADOR'('parametro  bloque_funcion {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
	      | FUNC IDENTIFICADOR'('parametro')'              {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
	      ;

parametro : tipo IDENTIFICADOR
	  | error_parametro
	  ;


error_parametro :  tipo error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
		 ;


funcion_type: FUNC '(' tipo ')' ';' bloque_type
            |error_funcion_type
            ;

error_funcion_type:  '(' tipo ')' ';' bloque_type {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
                    |FUNC  tipo ')' ';' bloque_type {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
                    |FUNC '('  ')' ';' bloque_type {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
                    |FUNC '(' tipo  ';' bloque_type {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
                    |FUNC '(' tipo ')'  bloque_type {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
                    |FUNC '(' tipo ')' ';' error  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
                    ;

bloque_type: IDENTIFICADOR lista_de_variables
            ;



bloque_funcion : bloque_declarativo bloque_ejecucion_funcion
           | bloque_ejecucion_funcion
 	       | error_bloque_funcion
	       ;

error_bloque_funcion : bloque_declarativo error {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
		     ;


bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '('condicion')' ';' END 
			 | BEGIN PRE ':' '(' condicion ')' ';' bloque_sentencias RETURN '('condicion')' ';' END
			 | BEGIN PRE ':' '(' condicion ')' ';' RETURN '('condicion')' ';' END
			 | error_bloque_ejecucion_funcion
   			 ;			

error_bloque_ejecucion_funcion :       bloque_sentencias RETURN '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
				|BEGIN                   RETURN '('condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
				|BEGIN bloque_sentencias        '('condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
				|BEGIN bloque_sentencias RETURN    condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
				|BEGIN bloque_sentencias RETURN '('         ')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
				|BEGIN bloque_sentencias RETURN '('condicion    ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
				|BEGIN bloque_sentencias RETURN '('condicion')'     END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
				|BEGIN bloque_sentencias  END {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
				|BEGIN bloque_sentencias RETURN '('condicion')' ';' error  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}

				|      PRE '('condicion')' ';' bloque_sentencias RETURN '('condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
				|BEGIN PRE    condicion')' ';' bloque_sentencias RETURN '('condicion')' ';' END {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
                |BEGIN PRE '('         ')' ';' bloque_sentencias RETURN '('condicion')' ';' END {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
                |BEGIN PRE '('condicion   ';' bloque_sentencias RETURN '('condicion')' ';' END {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
				|BEGIN PRE '('condicion')'  bloque_sentencias RETURN '('condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
				|BEGIN PRE '('condicion')' ';'                   RETURN '('condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
				|BEGIN PRE '('condicion')' ';' bloque_sentencias        '('condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
				|BEGIN PRE '('condicion')' ';' bloque_sentencias RETURN    condicion')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
				|BEGIN PRE '('condicion')' ';'bloque_sentencias RETURN '('         ')' ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
				|BEGIN PRE '('condicion')' ';'bloque_sentencias RETURN '('condicion    ';' END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
				|BEGIN PRE '('condicion')' ';'bloque_sentencias RETURN '('condicion')'      END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
				|BEGIN PRE '('condicion')' ';'bloque_sentencias RETURN '('condicion')' ';' error  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
                |BEGIN PRE '('condicion')' ';'bloque_sentencias END  {System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
                ;




condicion : expresion
	  | condicion OR expresion {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
	  ;

expresion: expresion1
	    | expresion AND expresion1 {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
	    ;

expresion1: expresion2
		| expresion1 comparador expresion2 {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  $2.sval + "}");}


expresion2: termino
	  | expresion2 '+' termino {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
	  | expresion2 '-' termino {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
	  ;

termino : termino '*' factor {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
	| termino '/' factor  {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
	| factor
        ;


factor 	: '-' factor  {chequearFactorNegado();}
        |CTE_DOUBLE {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + $1.sval + "}");}
        | CTE_ULONG {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + $1.sval + "}");}
	    | IDENTIFICADOR {System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + $1.sval +"}");}
	    | invocacion
        ;


comparador : '<'
	   | '>'
	   | IGUAL_IGUAL
        | MAYOR_IGUAL
	   | MENOR_IGUAL
	   | DISTINTO
	   ;


%%

private Lexico lexico;
public Parser(Lexico lexico)
{
  this.lexico= lexico;
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

public void chequearFactorNegado(){
	String lexema = yylval.sval;
	int id = Main.tSimbolos.getId(lexema);
	if(id == Lexico.CTE_ULONG){
		System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una constante ULONG fuera de rango}");
		Main.tSimbolos.eliminarSimbolo(lexema);
	}
	else if (id == Lexico.CTE_DOUBLE) {
		double valor = -1*Double.parseDouble(lexema);
		if(( valor > 2.2250738585272014e-308 && valor < 1.7976931348623157e+308) || (valor > -1.7976931348623157e+308 && valor < -2.2250738585072014e-308) || (valor == 0.0))
                	Main.tSimbolos.modificarSimbolo(lexema, String.valueOf(valor));
                else {
                	System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "]  {Se detectó una constante DOUBLE fuera de rango}");
	               	Main.tSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}
