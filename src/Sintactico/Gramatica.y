%{
package Sintactico;
import Principal.*;
%}

%token IDENTIFICADOR CTE_UINT MAYOR_IGUAL MENOR_IGUAL IGUAL_IGUAL DISTINTO ASIGNACION CTE_DOUBLE CADENA AND OR IF THEN ENDIF PRINT FUNC RETURN BEGIN END BREAK ULONG DOUBLE REPEAT PRE TRY CATCH TYPEDEF UINT ENDREPEAT ELSE

%start programa


%%
programa : IDENTIFICADOR bloque_declarativo bloque_ejecutable {System.out.println("Sintactico : se leyo el programa llamado " +$1.sval);}
         | error_programa
         ;

error_programa : bloque_declarativo bloque_ejecutable {System.out.println("Error sintáctico: Linea " + Lexico.linea + "Se debe indicar un nombre para el programa");}
	       | IDENTIFICADOR bloque_ejecutable bloque_declarativo {System.out.println("Error sintáctico: Linea " + Lexico.linea + "Mal posicionamiento de sentencias declarativas");}
	       ;


bloque_declarativo : declaracion
				|bloque_declarativo declaracion
                   ;

bloque_ejecutable : BEGIN bloque_sentencias END
		  | error_bloque_ejecutable
                  ;

bloque_sentencias: sentencia_ejecucion
	| bloque_sentencias sentencia_ejecucion
	;
 

error_bloque_ejecutable : bloque_sentencias END {System.out.println("Error sintáctico: Linea " + Lexico.linea + "Se detectó un END pero falta un BEGIN para iniciar el bloque");}
				|BEGIN bloque_sentencias error {System.out.println("Error sintáctico: Linea " + Lexico.linea + "Se detectó un BEGIN per falta un END para cerrar el bloque");}
		        ;


   			 
sentencia_ejecucion : control ';'
		    		| seleccion ';'
		   	 	    | impresion ';'
		    		| invocacion ';' 
		    		| asignacion ';'
		    		| error_ejecucion
		    		;

error_ejecucion: control error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
                | seleccion error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
                | impresion error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
           	       | asignacion error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
             	 | invocacion error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
               	 ;


declaracion : tipo lista_de_variables ';'{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variables");}
    	    | tipo funcion';'
    	    | TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';'
    	    | error_declaracion
            ;


error_declaracion : tipo lista_de_variables error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
           	  |  funcion error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
           	  ;



tipo : UINT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo UINT");}
     | DOUBLE {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo DOUBLE");}
     ;

control : REPEAT'('IDENTIFICADOR'='CTE_UINT';'condicion';' CTE_UINT')' bloque_control ENDREPEAT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia REPEAT");}
	| error_control
	;

error_control : REPEAT IDENTIFICADOR '=' CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta '('");}
	 | REPEAT '('  '=' CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta el identificador ");}
	 | REPEAT'('IDENTIFICADOR   CTE_UINT';'condicion';' CTE_UINT')'bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta '='");}
	 | REPEAT'('IDENTIFICADOR'='        ';'condicion';' CTE_UINT')'bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta una constante UINT");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT   condicion';' CTE_UINT')'bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta ';'");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT';'         ';' CTE_UINT')'bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta la condición");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT';'condicion    CTE_UINT')'bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta ';'");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT';'condicion';'        ')'bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta una constante CTE_UINT");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT';'condicion';'CTE_UINT   bloque_control ENDREPEAT {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta ')'");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT';'condicion';'CTE_UINT')'               ENDREPEAT{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta el bloque de sentencias");}
	 | REPEAT'('IDENTIFICADOR'='CTE_UINT';'condicion';'CTE_UINT')' bloque_control          {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta indicar el fin del ciclo con ENDREPEAT");}
	 ;

bloque_control : sentencia_control
		  	| bloque_control sentencia_control
		  	;

sentencia_control : sentencia_ejecucion 
		    | BREAK ';'
		    | error_sentencia_control
		    ;

error_sentencia_control : BREAK error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
               	 	;

asignacion : IDENTIFICADOR ASIGNACION condicion
	   	  |error_asignacion;	
	   ;


error_asignacion : ASIGNACION condicion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta el identificador del lado izquierdo de la asignación");}
			   |IDENTIFICADOR condicion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta ':=' en la asignación");}
			   |IDENTIFICADOR ASIGNACION {System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta una expresión aritmética del lado derecho de la asignación");}
		 	  
		  ;


seleccion: IF '(' condicion ')' THEN bloque_sentencias ENDIF ';'
	 | IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias ENDIF ';'
	 | error_seleccion
	 ;

error_seleccion :    '('condicion ')' THEN bloque_sentencias ENDIF {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una seleccion mal declarado, falta el IF");}
		| IF     condicion ')' THEN bloque_sentencias ENDIF {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta '('");}
		| IF '('        ')' THEN  bloque_sentencias ENDIF {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta la condicion");}
		| IF '(' condicion    THEN bloque_sentencias  ENDIF {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta ')'");}
		| IF '(' condicion')'       bloque_sentencias ENDIF {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el THEN");}
		| IF '(' condicion ')' THEN              ENDIF {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el bloque de sentencias");}
		| IF '(' condicion ')' THEN bloque_sentencias     {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el ENDIF o ELSE");}
		| IF '(' condicion ')' THEN  bloque_sentencias  ELSE                 ENDIF{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el bloque de sentencias del ELSE");}
		| IF '(' condicion ')' THEN  bloque_sentencias  ELSE bloque_sentencias        {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el ENDIF");}
		;


impresion: PRINT '(' CADENA ')'
	 ;


invocacion : IDENTIFICADOR '(' parametro ')' {System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una invocacion al procedimiento '" + $1.sval + "'");}
	   | error_invocacion
	   ;

error_invocacion: '(' parametro ')' {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el identificador");}
		| IDENTIFICADOR parametro ')' {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el '('");}
		| IDENTIFICADOR '(' ')' {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el parametro");}
		| IDENTIFICADOR '('parametro {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el ')'");}
		;


lista_de_variables : lista_de_variables ',' IDENTIFICADOR {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo el identificador -> " + $3.sval);}
			    |IDENTIFICADOR {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo el identificador -> " + $1.sval);}
      		    | error_lista_de_variables
                   ;


error_lista_de_variables: lista_de_variables IDENTIFICADOR {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ',' entre los identificadores");}

funcion : FUNC IDENTIFICADOR'('parametro')' bloque_funcion  {System.out.println("[Parser | Linea " + Lexico.linea + "] se declaró una funcion llamada '"+ $2.sval +"'" );}
        | error_funcion
        ;


error_funcion :      IDENTIFICADOR'('parametro')' bloque_funcion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta el FUNC");}
	      | FUNC         '('parametro')' bloque_funcion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta el nombre ");}
	      | FUNC IDENTIFICADOR parametro')' bloque_funcion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta '(' ");}
	      | FUNC IDENTIFICADOR'('       ')' bloque_funcion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta el parametro ");}
	      | FUNC IDENTIFICADOR'('parametro  bloque_funcion {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta ')' ");}
	      | FUNC IDENTIFICADOR'('parametro')'              {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta bloque de sentencias ");}
	      ;

parametro : tipo IDENTIFICADOR
	  | error_parametro
	  ;


error_parametro :  tipo error {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un parámetro mal declarado, falta el nombre identificador");}
		 ;


funcion_type: FUNC '(' tipo ')' bloque_type
            ;

bloque_type: IDENTIFICADOR lista_de_variables
            ;



bloque_funcion : bloque_declarativo bloque_ejecucion_funcion
	       | bloque_declarativo TRY sentencia_ejecucion CATCH bloque_ejecutable
 	       | error_bloque_funcion
	       ;

error_bloque_funcion : bloque_declarativo sentencia_ejecucion CATCH bloque_ejecutable {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el TRY");}
		     | bloque_declarativo TRY CATCH bloque_ejecutable  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, la sentencia ejecutable despues del TRY");}
		     |  bloque_declarativo TRY sentencia_ejecucion bloque_ejecutable  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el CATCH");}
		     ;

bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '('condicion')' ';' END 
			 | BEGIN PRE ':' condicion ';' bloque_sentencias RETURN '('condicion')' END
			 | error_bloque_ejecucion_funcion
   			 ;			

error_bloque_ejecucion_funcion :       bloque_sentencias RETURN '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
				|BEGIN                   RETURN '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el bloque de sentencias ejecutables");}
				|BEGIN bloque_sentencias        '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el RETURN");}
				|BEGIN bloque_sentencias RETURN    condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta '(' ");}
				|BEGIN bloque_sentencias RETURN '('         ')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta indicar el retorno");}
				|BEGIN bloque_sentencias RETURN '('condicion    ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ')' ");}
				|BEGIN bloque_sentencias RETURN '('condicion')'     END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ';' ");}
				|BEGIN bloque_sentencias RETURN '('condicion')' ';' error  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el END ");}

				       PRE '('condicion')' bloque_sentencias RETURN '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
				|BEGIN PRE '('condicion')'                   RETURN '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el bloque de sentencias ejecutables");}
				|BEGIN PRE '('condicion')' bloque_sentencias        '('condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el RETURN");}
				|BEGIN PRE '('condicion')' bloque_sentencias RETURN    condicion')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta '(' ");}
				|BEGIN PRE '('condicion')' bloque_sentencias RETURN '('         ')' ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta indicar el retorno");}
				|BEGIN PRE '('condicion')' bloque_sentencias RETURN '('condicion    ';' END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ')' ");}
				|BEGIN PRE '('condicion')'bloque_sentencias RETURN '('condicion')'      END  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ';' ");}
				|BEGIN PRE '('condicion')'bloque_sentencias RETURN '('condicion')' ';' error  {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el END ");}

				|BEGIN PRE    condicion')' bloque_sentencias RETURN '('condicion')' ';' END {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta '(' ");}
				|BEGIN PRE '('         ')' bloque_sentencias RETURN '('condicion')' ';' END {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta la condicion del PRE");}
				|BEGIN PRE '('condicion    bloque_sentencias RETURN '('condicion')' ';' END {System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ')' ");}
				;




condicion : expresion
	  | condicion OR expresion { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
	  ;

expresion: expresionn
	    | expresion AND expresionn
	    ;

expresionn: expresionnn
		| expresionn comparador expresionnn


expresionnn: termino
	  | expresionnn '+' termino { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
	  | expresionnn '-' termino { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
	  ;

termino : termino '*' factor { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
	| termino '/' factor  { System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
	| factor
        ;


factor 	: CTE_DOUBLE {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante double -> " + $1.sval);}
        | CTE_UINT {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante uint -> " + $1.sval);}
        | '-' factor {chequearFactorNegado();}
	   | IDENTIFICADOR {System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + $1.sval);}
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
    System.out.println("Parser: " + s);
}

public void chequearFactorNegado(){
	String lexema = yylval.sval;
	int id = Main.tSimbolos.getId(lexema);
	if(id == Lexico.CTE_UINT){
		System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante UINT fuera de rango");
		Main.tSimbolos.eliminarSimbolo(lexema);
	}
	else if (id == Lexico.CTE_DOUBLE) {
		double valor = -1*Double.parseDouble(lexema.replace('d','e'));
		if(( valor > 2.2250738585272014e-308 && valor < 1.7976931348623157e+308) || (valor > -1.7976931348623157e+308 && valor < -2.2250738585072014e-308) || (valor == 0.0))
                	Main.tSimbolos.modificarSimbolo(lexema, String.valueOf(valor));
                else {
                	System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una constante DOUBLE fuera de rango");
	               	Main.tSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}
