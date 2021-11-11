//### This file created by BYACC 1.8(/Java extension  1.15)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 2 "Gramatica.y"
package Sintactico;
import Principal.*;
import CodigoIntermedio.*;
import java.util.ArrayList;
//#line 22 "Parser.java"




public class Parser
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//public class ParserVal is defined in ParserVal.java


String   yytext;//user variable to return contextual strings
ParserVal yyval; //used to return semantic vals from action routines
ParserVal yylval;//the 'lval' (result) I got from yylex()
ParserVal valstk[];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
void val_init()
{
  valstk=new ParserVal[YYSTACKSIZE];
  yyval=new ParserVal();
  yylval=new ParserVal();
  valptr=-1;
}
void val_push(ParserVal val)
{
  if (valptr>=YYSTACKSIZE)
    return;
  valstk[++valptr]=val;
}
ParserVal val_pop()
{
  if (valptr<0)
    return new ParserVal();
  return valstk[valptr--];
}
void val_drop(int cnt)
{
int ptr;
  ptr=valptr-cnt;
  if (ptr<0)
    return;
  valptr = ptr;
}
ParserVal val_peek(int relative)
{
int ptr;
  ptr=valptr-relative;
  if (ptr<0)
    return new ParserVal();
  return valstk[ptr];
}
final ParserVal dup_yyval(ParserVal val)
{
  ParserVal dup = new ParserVal();
  dup.ival = val.ival;
  dup.dval = val.dval;
  dup.sval = val.sval;
  dup.obj = val.obj;
  return dup;
}
//#### end semantic value section ####
public final static short IDENTIFICADOR=257;
public final static short CTE_ULONG=258;
public final static short MAYOR_IGUAL=259;
public final static short MENOR_IGUAL=260;
public final static short IGUAL_IGUAL=261;
public final static short DISTINTO=262;
public final static short ASIGNACION=263;
public final static short CTE_DOUBLE=264;
public final static short CADENA=265;
public final static short AND=266;
public final static short OR=267;
public final static short IF=268;
public final static short THEN=269;
public final static short ENDIF=270;
public final static short PRINT=271;
public final static short FUNC=272;
public final static short RETURN=273;
public final static short BEGIN=274;
public final static short END=275;
public final static short BREAK=276;
public final static short ULONG=277;
public final static short DOUBLE=278;
public final static short REPEAT=279;
public final static short PRE=280;
public final static short TRY=281;
public final static short CATCH=282;
public final static short TYPEDEF=283;
public final static short ELSE=284;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    0,    3,    3,    1,    1,    2,    2,    5,
    5,    6,    6,    8,    8,    8,    8,    8,    8,   14,
   14,   14,   14,   14,    7,    7,    7,   16,    4,    4,
    4,    4,   21,   21,   21,   17,   17,    9,    9,   25,
   25,   25,   25,   25,   25,   25,   25,   22,   22,   26,
   26,   26,   24,   27,   27,   28,   28,   28,   29,   13,
   13,   31,   31,   31,   10,   10,   10,   33,   33,   33,
   35,   35,   35,   34,   34,   34,   34,   34,   34,   34,
   34,   34,   11,   11,   12,   12,   12,   12,   36,   36,
   36,   36,   15,   15,   38,   38,   38,   38,   37,   39,
   39,   18,   18,   18,   40,   19,   19,   43,   41,   41,
   45,   45,   45,   45,   45,   44,   44,   46,   20,   20,
   48,   48,   48,   48,   48,   48,   47,   42,   42,   42,
   50,   49,   49,   49,   49,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   51,   23,   23,   52,
   52,   53,   53,   30,   30,   30,   32,   32,   32,   55,
   55,   55,   55,   55,   54,   54,   54,   54,   54,   54,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,    1,    8,
    8,    8,    8,    8,    8,    8,    9,    3,    1,    2,
    2,    3,    3,    1,    2,    1,    2,    1,    2,    3,
    1,    2,    2,    3,    7,    9,    1,    1,    5,    1,
    4,    5,    4,    6,    6,    6,    6,    6,    6,    6,
    8,    8,    4,    3,    4,    4,    4,    1,    3,    4,
    4,    4,    4,    1,    3,    3,    4,    4,    3,    1,
    2,    3,    1,    1,    2,    2,    1,    2,    5,    1,
    4,    4,    4,    4,    5,    2,    1,    2,    6,    1,
    5,    5,    5,    5,    5,    6,    2,    2,    1,    1,
    2,    8,   14,   13,    1,    7,    7,    7,    7,    7,
    7,    7,    3,    8,   12,   12,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   13,    8,    1,    3,    1,
    3,    1,    3,    1,    3,    3,    3,    3,    1,    2,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  107,  110,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   39,   61,   67,
   88,   94,    0,    0,    0,    0,    4,    7,    0,    0,
    0,  104,   35,  108,    0,    0,    0,    0,  106,  129,
  130,  135,    0,  172,    0,  171,    0,    0,  174,    0,
  169,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   49,    0,    0,    0,    0,
    0,    0,  117,    1,    0,    0,   12,   11,   20,   14,
   21,   15,   22,   16,   24,   17,   23,   18,   28,   26,
    0,    0,    0,    0,    0,   33,  105,   29,    0,   34,
   30,    0,    0,    0,    0,  131,  128,    0,    0,   64,
    0,    0,    0,    0,   89,  170,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  178,  179,  177,  180,  175,
  176,    0,    0,   84,   13,    8,   51,    0,   50,    0,
    0,    0,    0,   95,    0,   96,    0,  118,  116,    0,
  111,  114,    0,  113,  112,    0,  102,    0,    0,    0,
    0,    0,  143,    0,    0,    0,   92,   87,   90,   85,
   91,   86,  167,  168,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   83,   52,   48,    0,    0,    0,    0,
  100,    0,   97,   93,   98,    0,  115,  109,    0,    0,
    0,  120,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   68,    0,   70,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   99,  101,    0,    0,    0,
    0,   31,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   76,   77,   79,    0,   78,
   75,    0,    0,    0,    0,    0,    0,   74,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   65,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  137,    0,    0,    0,    0,    0,    0,    0,
  140,  141,  142,    0,  139,  138,    0,  136,   73,   71,
    0,   81,    0,    0,   41,   43,   44,    0,   46,   45,
   42,   40,    0,  123,  124,    0,  125,  122,  121,    0,
    0,    0,    0,  157,    0,    0,    0,    0,    0,  144,
  132,    0,   72,   69,   66,    0,   56,    0,   54,   58,
   47,   38,  103,    0,  126,  119,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   59,   57,   53,
   55,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  147,  148,  150,  153,
  154,  155,    0,  152,  151,  149,    0,    0,  146,  145,
  156,  134,    0,  133,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   50,   11,  221,
   12,   85,   91,  335,   38,   86,  368,  369,  370,   75,
   39,   76,  235,   40,  236,   41,  164,   42,  212,   52,
   13,   59,   14,   92,   15,   93,  344,  222,   60,   61,
   62,   77,   78,  152,   71,
};
final static short yysindex[] = {                      -118,
   84,  -25,    0,    0, -212,    0,  159,    0,    0, -108,
    7,    0,   28,    0,    0,  540,  582,  177,   13,  459,
  116,   11,   67,  159,  -88,  281,    0,    0,    0,  -41,
  -40,   98,  139,  422,    0,  431,    0,    0,    0,    0,
    0,    0,  -19, -185,   15,  582,    0,    0,   42,  330,
  442,    0,    0,    0,  -37,   46,  140,  290,    0,    0,
    0,    0,   59,    0,  190,    0,   55,  582,    0,   95,
    0,   95,  387,    9,  110,   95, -160,  646,   29,  553,
  187, -241, -141,  334,   71,    0, -133, -254, -135,  -83,
   19,  117,    0,    0,   42,  -88,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   -7,  120,  126, -185, -185,    0,    0,    0,  -76,    0,
    0,  151,  143,  188,  582,    0,    0,  157,  566,    0,
  110,   -6,    6,   94,    0,    0,  582,  582,  -69,  -12,
  582,  -67,  582,  582,  582,    0,    0,    0,    0,    0,
    0,  582,  165,    0,    0,    0,    0, -153,    0,  582,
  415,  582,  479,    0, -200,    0, -133,    0,    0,  -61,
    0,    0,   97,    0,    0,  -32,    0,  582,  595,  179,
   21,  556,    0,  582,   22,  582,    0,    0,    0,    0,
    0,    0,    0,    0,  302,  302,  208, -160,  302,   95,
   95,  646,  110,    0,    0,    0,  119,  623,  123,  162,
    0,  131,    0,    0,    0,  302,    0,    0,  -17, -185,
  178,    0,   31,  263,  -15,  582,  324,  609,   34,   36,
  339,   48,  459,    0,  145,    0,  169,  223,  200,  205,
  199,  220,  146,  225,  226,    0,    0,  215,   -5,  447,
  454,    0,  437,  459,  459,  311,   49,  459,  444,   -1,
  449,  -45,  459,  450,  331,    0,    0,    0, -201,    0,
    0,  474,  475,  488,  -29,  500,  501,    0,  461,   26,
  491,  495,  217,  332,  351,  352,  384,  496,  385,  291,
  292,  -50,  297,  303,  412,  309,  446,  413,    0,  243,
  343,  343,  343,  -36,  343,  343,  343,  320,  320,  -43,
  320,  320,    0,  564,  578,  581,  255,  586,  432,  588,
    0,    0,    0, -191,    0,    0,  589,    0,    0,    0,
  451,    0,  369,  433,    0,    0,    0, -161,    0,    0,
    0,    0,  389,    0,    0,  -63,    0,    0,    0,  582,
  582,  582,  598,    0,  582,  582,  619,  458,  582,    0,
    0,  582,    0,    0,    0,  472,    0,  264,    0,    0,
    0,    0,    0,  -34,    0,    0,   50,   53,   56,  626,
   61,   82,   90,  582,  620,   92,   93,    0,    0,    0,
    0,  590,  618,  627,  638,   14,  651,  113,  660,   99,
  582,  666,  682,  469,  471,  481,  484,  485,   12,  493,
  498,  503,  690,  102,  513,  515,    0,    0,    0,    0,
    0,    0,  506,    0,    0,    0,  517,  695,    0,    0,
    0,    0,  520,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  764,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  405,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  710,    0,    0,    0,    0,    0,    0,  478,
    0,  487,    0,    0,  575,  722,  -28,   60,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  766,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  489,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  516,    0,  734,
  746,  466,  658,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  492,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  505,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  712,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
  107,   35,    0,   30,   -9,    0,  -20,  511,    0,    0,
    0,  -16,    0,    0,  754,    0,  778,  443,  770,    0,
    0,  715,   25,  572,    0,    0,    0,  434,    0,  -38,
    0,    8,  632,    0,    0,    0,  -49,    0,    0,    0,
    0,    0,    0,  -11,    0,    0, -231,    0,  743,    0,
    0,  668,  662,    0,  -27,
};
final static int YYTABLESIZE=1027;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         69,
   69,   69,   46,   58,  338,   98,   69,  220,  324,  119,
   81,  305,  158,  294,   44,  346,  157,  100,  102,  163,
  111,  158,  249,   70,   72,  256,  131,  165,  197,   69,
  158,  112,  113,  172,  188,  279,   48,   98,  166,  292,
  136,   47,   74,  255,   45,  124,  190,   58,   69,  142,
   46,   69,   79,   48,  409,  213,   69,  291,   94,  170,
   98,  227,  231,   69,  360,   53,  310,   46,  299,  154,
  423,  253,  408,  163,  261,  114,  262,  345,  347,  348,
  349,  115,  300,  361,  309,  125,   48,   70,  264,  288,
  392,    3,    4,  393,  371,  135,  394,  140,  129,  173,
  160,  397,  205,   98,  206,  145,   69,   24,   69,  193,
  194,   68,  334,  203,  376,  214,  159,  215,  160,   57,
   69,   69,  398,   23,   69,   48,   69,   69,   69,  162,
  399,   96,  402,  403,  192,   69,  137,  218,    1,  413,
  163,  138,  428,   69,   69,   69,  167,  181,   49,  185,
  200,  201,  143,    2,  144,   84,  104,  171,    3,    4,
  174,   69,   69,    2,    5,   69,  175,   69,   95,   69,
   46,  411,  168,  169,  234,  234,  234,  241,  234,   46,
  177,  244,  179,    2,  207,  209,  210,   68,    3,    4,
  178,   69,  375,  343,    5,  234,  186,  106,   46,  195,
  180,  199,  223,  225,  275,  204,  229,  216,  230,   69,
  232,   69,  265,  343,   99,  101,   73,  234,  226,   80,
  245,   68,  117,  216,  323,   17,   46,  184,  304,  158,
   18,   43,  243,   19,   68,  122,  252,  334,  158,  219,
  158,   21,  123,   22,  284,  285,  287,   46,  289,  187,
  257,  141,  260,  295,  141,  298,  196,    3,    4,    3,
    4,  189,   46,   98,   98,  141,   98,   80,   98,    3,
    4,    3,    4,   17,   98,  141,  317,   98,   18,  234,
  141,   19,   46,   54,   16,  141,  422,  141,  141,   21,
   17,   22,   87,  153,  355,   18,   98,  141,   19,    2,
  141,   55,  141,   46,    3,    4,   21,   56,   22,  358,
    5,  132,  133,  367,  141,  141,  141,  160,  134,  141,
   46,  254,  141,   63,   64,  160,  160,  141,  160,   46,
   66,    3,    4,   69,   69,   69,   69,   98,   69,   69,
   16,   46,   69,    3,    4,   69,   17,  367,  141,  191,
   46,   18,  217,  103,   19,    2,  141,   20,  141,  141,
    3,    4,   21,   69,   22,  141,    5,   69,  141,  286,
   46,   46,   82,  119,  377,  378,  379,  381,   83,  382,
  383,  216,  258,  386,   69,  141,  387,   80,  118,  141,
   46,   46,  160,   17,  105,  126,   16,  263,   18,   63,
   64,   19,   17,  274,  396,  246,   66,   18,  400,   21,
   19,    2,  141,   55,  266,   16,    3,    4,   21,   56,
   22,   17,    5,   46,   46,  414,   18,  139,  141,   19,
    2,   68,   20,   63,   64,    3,    4,   21,  267,   22,
   66,    5,  155,   80,   80,  130,   63,   64,  103,   17,
   17,   46,   46,   66,   18,   18,  272,   19,   19,   68,
  182,  156,  183,  103,   80,   21,   21,   22,   22,  270,
   17,   46,   46,  208,  271,   18,  238,  273,   19,   80,
  108,  233,  276,  277,  278,   17,   21,  281,   22,  110,
   18,  313,  268,   19,  282,  283,  233,   46,   46,   80,
  121,   21,  290,   22,  330,   17,  161,  293,  296,  364,
   18,   80,  332,   19,  301,  302,  233,   17,   46,  308,
   80,   21,   18,   22,  161,   19,   17,  353,  303,  354,
  389,   18,   88,   21,   19,   22,   63,   80,  390,  366,
  306,  307,   21,   17,   22,   62,   80,   60,   18,  311,
   80,   19,   17,  312,  319,   97,  159,   18,   80,   21,
   19,   22,  128,   82,   17,  321,  322,   80,   21,   18,
   22,  325,   19,   17,  159,  233,  343,  326,   18,   67,
   21,   19,   22,  328,   68,  116,  117,   80,   80,   21,
   82,   22,  129,   17,   17,  228,   83,   68,   18,   18,
   68,   19,   19,  350,  314,  297,  135,   80,   80,   21,
   21,   22,   22,   17,   17,  162,  334,  351,   18,   18,
  352,   19,   19,  315,  316,  356,   68,  359,  362,   21,
   21,   22,   22,  162,  162,  224,  162,  380,  365,   68,
   80,   80,   68,   63,   64,  373,   17,   17,  404,  259,
   66,   18,   18,   68,   19,   19,  318,  320,  384,  401,
  103,  103,   21,   21,   22,   22,  395,   68,   80,   80,
   68,   63,   64,  211,   17,   17,  405,  107,   66,   18,
   18,  242,   19,   19,  327,  406,  109,  331,   80,   80,
   21,   21,   22,   22,   17,   17,  407,  120,  163,   18,
   18,  329,   19,   19,  357,  150,  363,  151,  366,  410,
   21,   21,   22,   22,   80,   80,  163,  163,  412,  163,
   17,   17,  247,  161,  415,   18,   18,  388,   19,   19,
  385,  161,  161,   63,  161,   80,   21,   21,   22,   22,
  416,   17,   62,  417,   60,  418,   18,   80,  427,   19,
  173,  173,  173,  433,  173,  419,  173,   21,  420,  421,
   82,  431,  164,    2,  164,    5,  164,  424,  173,  173,
  127,  173,  425,  159,  165,   89,  165,  426,  165,   51,
  164,  164,  159,  164,  159,  374,  166,  429,  166,  430,
  166,  432,  165,  165,  434,  165,   63,   64,  161,  127,
   90,  391,   65,   66,  166,  166,  202,  166,  198,   63,
   64,    0,   63,   64,    0,   65,   66,    0,    0,   66,
   90,   90,  132,  133,    0,    0,    0,  237,  239,  134,
  240,    0,  162,  162,  162,  162,  162,    0,   63,   64,
  162,  162,    0,  162,   90,   66,    0,  248,    0,    0,
    0,   63,   64,    0,   63,   64,    0,    0,   66,    0,
    0,   66,    0,    0,    0,   63,   64,    0,    0,  269,
    0,    0,   66,  336,  337,  339,  340,  341,  342,   63,
   64,    0,   63,   64,    0,    0,   66,    0,   90,   66,
    0,  176,   90,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  146,  147,  148,  149,    0,  372,
    0,    0,    0,    0,    0,  163,  163,  163,  163,  163,
    0,    0,    0,  163,  163,    0,  163,    0,    0,    0,
    0,  333,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  173,    0,  173,  173,  173,
  173,  173,    0,    0,    0,  173,  173,  164,  173,  164,
  164,  164,  164,  164,    0,    0,    0,  164,  164,  165,
  164,  165,  165,  165,  165,  165,  250,  251,    0,  165,
  165,  166,  165,  166,  166,  166,  166,  166,    0,    0,
    0,  166,  166,    0,  166,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  280,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         16,
   17,   18,   40,   13,   41,   26,   23,   40,   59,   44,
   20,   41,   41,   59,   40,   59,  258,   59,   59,  274,
   40,  263,   40,   16,   17,   41,   65,  282,   41,   46,
   59,   43,   44,   41,   41,   41,    7,   58,   88,   41,
   68,    7,   18,   59,  257,   55,   41,   57,   65,   41,
   40,   68,   40,   24,   41,  256,   73,   59,   24,   41,
   81,   41,   41,   80,  256,   59,   41,   40,  270,   41,
   59,   41,   59,  274,   41,   61,   41,  309,  310,  311,
  312,   40,  284,  275,   59,   40,   57,   80,   41,   41,
   41,  277,  278,   41,  256,   41,   41,   73,   40,  111,
   41,   41,  256,  124,  258,  266,  123,    1,  125,  137,
  138,   45,  274,  152,  346,  165,  258,  167,   59,   13,
  137,  138,   41,   40,  141,   96,  143,  144,  145,   59,
   41,   25,   41,   41,   41,  152,   42,   41,  257,   41,
  274,   47,   41,  160,  161,  162,  282,  123,  257,  125,
  143,  144,   43,  272,   45,   40,   59,   41,  277,  278,
   41,  178,  179,  272,  283,  182,   41,  184,  257,  186,
   40,   59,  256,  257,  195,  196,  197,   59,  199,   40,
  257,   59,   40,  272,  160,  161,  162,   45,  277,  278,
   40,  208,  256,  257,  283,  216,   40,   59,   40,  269,
   58,  269,  178,  179,   59,   41,  182,  269,  184,  226,
  186,  228,  233,  257,  256,  256,   40,  238,   40,  257,
   59,   45,  257,  269,  275,  263,   40,   40,  258,  258,
  268,  257,  208,  271,   45,  273,   59,  274,  267,  272,
  269,  279,  280,  281,  254,  255,  256,   40,  258,  256,
  226,  267,  228,  263,  267,  265,  269,  277,  278,  277,
  278,  256,   40,  284,  285,  267,  287,  257,  289,  277,
  278,  277,  278,  263,  295,  267,  286,  298,  268,  300,
  267,  271,   40,  256,  257,  267,  275,  267,  267,  279,
  263,  281,  282,  265,   40,  268,  317,  267,  271,  272,
  267,  274,  267,   40,  277,  278,  279,  280,  281,  319,
  283,  257,  258,  334,  267,  267,  267,  258,  264,  267,
   40,   59,  267,  257,  258,  266,  267,  267,  269,   40,
  264,  277,  278,  350,  351,  352,  353,  358,  355,  356,
  257,   40,  359,  277,  278,  362,  263,  368,  267,  256,
   40,  268,  256,  256,  271,  272,  267,  274,  267,  267,
  277,  278,  279,  380,  281,  267,  283,  384,  267,   59,
   40,   40,  257,   44,  350,  351,  352,  353,  263,  355,
  356,  269,   59,  359,  401,  267,  362,  257,   59,  267,
   40,   40,   59,  263,  256,  256,  257,   59,  268,  257,
  258,  271,  263,  258,  380,  275,  264,  268,  384,  279,
  271,  272,  267,  274,  270,  257,  277,  278,  279,  280,
  281,  263,  283,   40,   40,  401,  268,   41,  267,  271,
  272,   45,  274,  257,  258,  277,  278,  279,  270,  281,
  264,  283,  256,  257,  257,  256,  257,  258,   44,  263,
  263,   40,   40,  264,  268,  268,  258,  271,  271,   45,
  273,  275,  275,   59,  257,  279,  279,  281,  281,  270,
  263,   40,   40,   59,  270,  268,  269,  258,  271,  257,
   59,  274,  258,  258,  270,  263,  279,   41,  281,   59,
  268,  275,  270,  271,   41,   59,  274,   40,   40,  257,
   59,  279,   59,  281,   59,  263,   41,   59,   59,   59,
  268,  257,  270,  271,   41,   41,  274,  263,   40,   59,
  257,  279,  268,  281,   59,  271,  263,  273,   41,  275,
   59,  268,   22,  279,  271,  281,   59,  257,  275,  276,
   41,   41,  279,  263,  281,   59,  257,   59,  268,   59,
   59,  271,  263,   59,   59,  275,   41,  268,  257,  279,
  271,  281,  273,   59,  263,  275,  275,  257,  279,  268,
  281,  275,  271,  263,   59,  274,  257,  275,  268,   40,
  279,  271,  281,  275,   45,  256,  257,  257,  257,  279,
  257,  281,   40,  263,  263,   40,  263,   45,  268,  268,
   45,  271,  271,   40,  273,  275,   41,  257,  257,  279,
  279,  281,  281,  263,  263,   41,  274,   40,  268,  268,
   40,  271,  271,  273,  273,   40,   45,   40,   40,  279,
  279,  281,  281,   59,   60,   41,   62,   40,  270,   45,
  257,  257,   45,  257,  258,  257,  263,  263,   59,   41,
  264,  268,  268,   45,  271,  271,  273,  273,   40,   40,
  256,  257,  279,  279,  281,  281,   41,   45,  257,  257,
   45,  257,  258,  163,  263,  263,   59,  256,  264,  268,
  268,   59,  271,  271,  273,   59,  256,  275,  257,  257,
  279,  279,  281,  281,  263,  263,   59,  256,   41,  268,
  268,  256,  271,  271,  273,   60,  256,   62,  276,   59,
  279,  279,  281,  281,  257,  257,   59,   60,   59,   62,
  263,  263,  212,  258,   59,  268,  268,  256,  271,  271,
  273,  266,  267,  256,  269,  257,  279,  279,  281,  281,
   59,  263,  256,  275,  256,  275,  268,  256,   59,  271,
   41,   42,   43,   59,   45,  275,   47,  279,  275,  275,
  256,  256,   41,    0,   43,    0,   45,  275,   59,   60,
   59,   62,  275,  258,   41,   22,   43,  275,   45,   10,
   59,   60,  267,   62,  269,  343,   41,  275,   43,  275,
   45,  275,   59,   60,  275,   62,  257,  258,   84,   57,
   23,  368,  263,  264,   59,   60,  145,   62,  141,  257,
  258,   -1,  257,  258,   -1,  263,  264,   -1,   -1,  264,
   43,   44,  257,  258,   -1,   -1,   -1,  196,  197,  264,
  199,   -1,  258,  259,  260,  261,  262,   -1,  257,  258,
  266,  267,   -1,  269,   67,  264,   -1,  216,   -1,   -1,
   -1,  257,  258,   -1,  257,  258,   -1,   -1,  264,   -1,
   -1,  264,   -1,   -1,   -1,  257,  258,   -1,   -1,  238,
   -1,   -1,  264,  302,  303,  304,  305,  306,  307,  257,
  258,   -1,  257,  258,   -1,   -1,  264,   -1,  111,  264,
   -1,  114,  115,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  259,  260,  261,  262,   -1,  338,
   -1,   -1,   -1,   -1,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,  269,   -1,   -1,   -1,
   -1,  300,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,  269,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
  269,  258,  259,  260,  261,  262,  219,  220,   -1,  266,
  267,  256,  269,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,  269,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  249,
};
}
final static short YYFINAL=6;
final static short YYMAXTOKEN=284;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,"'('","')'","'*'","'+'","','",
"'-'",null,"'/'",null,null,null,null,null,null,null,null,null,null,"':'","';'",
"'<'","'='","'>'",null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,"IDENTIFICADOR","CTE_ULONG","MAYOR_IGUAL",
"MENOR_IGUAL","IGUAL_IGUAL","DISTINTO","ASIGNACION","CTE_DOUBLE","CADENA","AND",
"OR","IF","THEN","ENDIF","PRINT","FUNC","RETURN","BEGIN","END","BREAK","ULONG",
"DOUBLE","REPEAT","PRE","TRY","CATCH","TYPEDEF","ELSE",
};
final static String yyrule[] = {
"$accept : programa",
"programa : IDENTIFICADOR bloque_declarativo bloque_ejecutable",
"programa : IDENTIFICADOR bloque_ejecutable",
"programa : error_programa",
"error_programa : bloque_declarativo bloque_ejecutable",
"error_programa : IDENTIFICADOR bloque_ejecutable bloque_declarativo",
"bloque_declarativo : declaracion",
"bloque_declarativo : bloque_declarativo declaracion",
"bloque_ejecutable : BEGIN bloque_sentencias END",
"bloque_ejecutable : error_bloque_ejecutable",
"bloque_sentencias : sentencia_ejecucion",
"bloque_sentencias : bloque_sentencias sentencia_ejecucion",
"error_bloque_ejecutable : bloque_sentencias END",
"error_bloque_ejecutable : BEGIN bloque_sentencias error",
"sentencia_ejecutable : control ';'",
"sentencia_ejecutable : seleccion ';'",
"sentencia_ejecutable : impresion ';'",
"sentencia_ejecutable : invocacion ';'",
"sentencia_ejecutable : asignacion ';'",
"sentencia_ejecutable : error_ejecucion",
"error_ejecucion : control error",
"error_ejecucion : seleccion error",
"error_ejecucion : impresion error",
"error_ejecucion : asignacion error",
"error_ejecucion : invocacion error",
"sentencia_ejecucion : sentencia_ejecutable",
"sentencia_ejecucion : try_catch ';'",
"sentencia_ejecucion : error_sentencia_ejecucion",
"error_sentencia_ejecucion : try_catch error",
"declaracion : tipo lista_de_variables ';'",
"declaracion : tipo funcion ';'",
"declaracion : TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"error_declaracion : tipo funcion error",
"error_declaracion : funcion ';'",
"tipo : ULONG",
"tipo : DOUBLE",
"control : REPEAT '(' asignacion_repeat ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"control : error_control",
"error_control : REPEAT asignacion_repeat ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion ';' ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion ';' CTE_ULONG bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion ';' CTE_ULONG ')' error",
"asignacion_repeat : IDENTIFICADOR ASIGNACION CTE_ULONG",
"asignacion_repeat : error_asignacion_repeat",
"error_asignacion_repeat : ASIGNACION CTE_ULONG",
"error_asignacion_repeat : IDENTIFICADOR CTE_ULONG",
"error_asignacion_repeat : IDENTIFICADOR ASIGNACION error",
"bloque_repeat : BEGIN bloque_control END",
"bloque_control : sentencia_control",
"bloque_control : bloque_control sentencia_control",
"sentencia_control : sentencia_ejecucion",
"sentencia_control : BREAK ';'",
"sentencia_control : error_sentencia_control",
"error_sentencia_control : BREAK error",
"asignacion : IDENTIFICADOR ASIGNACION expresion2",
"asignacion : error_asignacion",
"error_asignacion : ASIGNACION termino",
"error_asignacion : IDENTIFICADOR termino",
"error_asignacion : IDENTIFICADOR ASIGNACION error",
"seleccion : IF '(' condicion ')' THEN bloque_if ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_if ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"bloque_if : sentencia_ejecucion",
"bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END ';'",
"bloque_if : error_bloque_if",
"error_bloque_if : BEGIN sentencia_ejecucion END ';'",
"error_bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END error",
"error_bloque_if : BEGIN sentencia_ejecucion END error",
"error_seleccion : '(' condicion ')' THEN bloque_if ENDIF",
"error_seleccion : IF condicion ')' THEN bloque_if ENDIF",
"error_seleccion : IF '(' ')' THEN bloque_if ENDIF",
"error_seleccion : IF '(' condicion THEN bloque_if ENDIF",
"error_seleccion : IF '(' condicion ')' bloque_if ENDIF",
"error_seleccion : IF '(' condicion ')' THEN ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_if",
"error_seleccion : IF '(' condicion ')' THEN bloque_if ELSE ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_if ELSE bloque_if",
"impresion : PRINT '(' CADENA ')'",
"impresion : PRINT '(' ')'",
"invocacion : IDENTIFICADOR '(' CTE_ULONG ')'",
"invocacion : IDENTIFICADOR '(' CTE_DOUBLE ')'",
"invocacion : IDENTIFICADOR '(' IDENTIFICADOR ')'",
"invocacion : error_invocacion",
"error_invocacion : IDENTIFICADOR '(' ')'",
"error_invocacion : IDENTIFICADOR '(' CTE_ULONG error",
"error_invocacion : IDENTIFICADOR '(' CTE_DOUBLE error",
"error_invocacion : IDENTIFICADOR '(' IDENTIFICADOR error",
"try_catch : TRY sentencia_ejecutable CATCH bloque_catch",
"try_catch : error_try_catch",
"error_try_catch : TRY CATCH bloque_catch",
"error_try_catch : TRY sentencia_ejecutable bloque_catch",
"error_try_catch : TRY sentencia_ejecutable CATCH error",
"error_try_catch : TRY try_catch CATCH bloque_catch",
"bloque_catch : BEGIN bloque_1 END",
"bloque_1 : sentencia_ejecutable",
"bloque_1 : bloque_1 sentencia_ejecutable",
"lista_de_variables : lista_de_variables ',' IDENTIFICADOR",
"lista_de_variables : IDENTIFICADOR",
"lista_de_variables : error_lista_de_variables",
"error_lista_de_variables : lista_de_variables IDENTIFICADOR",
"funcion : declaracion_funcion bloque_funcion",
"funcion : error_funcion",
"error_funcion : declaracion_funcion error",
"declaracion_funcion : FUNC IDENTIFICADOR '(' parametro ')'",
"declaracion_funcion : error_declaracion_funcion",
"error_declaracion_funcion : IDENTIFICADOR '(' parametro ')'",
"error_declaracion_funcion : FUNC '(' parametro ')'",
"error_declaracion_funcion : FUNC IDENTIFICADOR parametro ')'",
"error_declaracion_funcion : FUNC IDENTIFICADOR '(' ')'",
"error_declaracion_funcion : FUNC IDENTIFICADOR '(' parametro error",
"parametro : tipo IDENTIFICADOR",
"parametro : error_parametro",
"error_parametro : tipo error",
"funcion_type : FUNC '(' tipo ')' ';' bloque_type",
"funcion_type : error_funcion_type",
"error_funcion_type : '(' tipo ')' ';' bloque_type",
"error_funcion_type : FUNC tipo ')' ';' bloque_type",
"error_funcion_type : FUNC '(' ')' ';' bloque_type",
"error_funcion_type : FUNC '(' tipo ';' bloque_type",
"error_funcion_type : FUNC '(' tipo ')' bloque_type",
"error_funcion_type : FUNC '(' tipo ')' ';' error",
"bloque_type : IDENTIFICADOR lista_de_variables",
"bloque_funcion : bloque_declarativo bloque_ejecucion_funcion",
"bloque_funcion : bloque_ejecucion_funcion",
"bloque_funcion : error_bloque_funcion",
"error_bloque_funcion : bloque_declarativo error",
"bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN PRE ':' '(' condicion ')' ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN PRE ':' '(' condicion ')' ';' RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : error_bloque_ejecucion_funcion",
"error_bloque_ejecucion_funcion : bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' ';' error",
"error_bloque_ejecucion_funcion : PRE '(' condicion ')' ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE condicion ')' ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' ')' ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias RETURN condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias RETURN '(' ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias RETURN '(' condicion ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias RETURN '(' condicion ')' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias RETURN '(' condicion ')' ';' error",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' ';' bloque_sentencias END",
"condicion : expresion",
"condicion : condicion OR expresion",
"expresion : expresion1",
"expresion : expresion AND expresion1",
"expresion1 : expresion2",
"expresion1 : expresion1 comparador expresion2",
"expresion2 : termino",
"expresion2 : expresion2 '+' termino",
"expresion2 : expresion2 '-' termino",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"factor : '-' factor",
"factor : CTE_DOUBLE",
"factor : CTE_ULONG",
"factor : IDENTIFICADOR",
"factor : invocacion",
"comparador : '<'",
"comparador : '>'",
"comparador : IGUAL_IGUAL",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
};

//#line 582 "Gramatica.y"

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
		System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una constante ULONG fuera de rango}");
		Main.tablaSimbolos.eliminarSimbolo(lexema);
	}
	else if (id == Lexico.CTE_DOUBLE) {
		double valor = -1*Double.parseDouble(lexema);
		if(( valor > 2.2250738585272014e-308 && valor < 1.7976931348623157e+308) || (valor > -1.7976931348623157e+308 && valor < -2.2250738585072014e-308) || (valor == 0.0)){
                	Main.tablaSimbolos.modificarSimbolo(lexema, String.valueOf(valor));
                	return true;
        }
        else {
            System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "]  {Se detectó una constante DOUBLE fuera de rango}");
            Main.tablaSimbolos.eliminarSimbolo(lexema);
	 	}
	}
	return false;
}
//#line 792 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  val_push(yylval);     //save empty value
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        if (yychar < 0)    //it it didn't work/error
          {
          yychar = 0;      //change it to default string (no -1!)
          if (yydebug)
            yylexdebug(yystate,yychar);
          }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        if (yydebug)
          debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0)   //check for under & overflow here
            {
            yyerror("stack underflow. aborting...");  //note lower case 's'
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            if (yydebug)
              debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            if (yydebug)
              debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0)   //check for under & overflow here
              {
              yyerror("Stack underflow. aborting...");  //capital 'S'
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        if (yydebug)
          {
          yys = null;
          if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          if (yys == null) yys = "illegal-symbol";
          debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          }
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    if (yydebug)
      debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    yyval = dup_yyval(yyval); //duplicate yyval if ParserVal is used as semantic value
    switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 14 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +val_peek(2).sval + "'}");}
break;
case 2:
//#line 15 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +val_peek(1).sval + "'}");}
break;
case 4:
//#line 19 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 5:
//#line 20 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 12:
//#line 39 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 13:
//#line 40 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 20:
//#line 53 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
//#line 54 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
//#line 55 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
//#line 56 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 57 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
//#line 65 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 70 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");
    	        String tipoVariable = val_peek(2).sval;
    	        lista_variables = (ArrayList<String>)val_peek(1).obj;
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
                        System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable " + lexema + " en este ámbito}");
                        Main.tablaSimbolos.eliminarSimbolo(lexema);
                    }
    	        }
    	        lista_variables.clear();
    	        }
break;
case 30:
//#line 90 "Gramatica.y"
{
       	        /*TODO : asignar tipo de funcion (Main.tablaSimbolos.get*/

    	        }
break;
case 31:
//#line 94 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + val_peek(4).sval +"'}");}
break;
case 33:
//#line 99 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
//#line 100 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
//#line 101 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 36:
//#line 107 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 37:
//#line 109 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 38:
//#line 112 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 40:
//#line 117 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
//#line 118 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 42:
//#line 119 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 43:
//#line 120 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 44:
//#line 121 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 46:
//#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 47:
//#line 124 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 48:
//#line 127 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion del repeat: "+ val_peek(2).sval + " := "+ val_peek(0).sval + "}");
                    String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(2).sval, ambito);
                    if(ambitoVariable != null) {
                        String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                        if(tipoIdentificador.equals("ULONG")){
                            Terceto t = new Terceto(":=", ambitoVariable, val_peek(0).sval);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.apilar(t.getNumero());
                            yyval = new ParserVal(ambitoVariable);
                        }
                        else
                            System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                        }
                    }
break;
case 50:
//#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 51:
//#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 52:
//#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 59:
//#line 162 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 60:
//#line 165 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + val_peek(2).sval + ":= " + val_peek(0).sval +"}");
            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(2).sval, ambito);
            if(ambitoVariable != null){
                String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                Operando op = (Operando)val_peek(0).obj;
                if(op != null)
                    if (tipoIdentificador.equals(op.getTipo())){
                    Terceto t = new Terceto(":=", ambitoVariable, op.getValor());
                    t.setTipo(op.getTipo());
                    adminTercetos.agregarTerceto(t);
                    yyval = new ParserVal(new Operando(tipoIdentificador, "[" + t.getNumero()+ "]"));
                    }
                    else{
                        System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                    }
           }
            else{
                System.out.println("Error semántico: Linea " + Lexico.linea + " la variable " + val_peek(2).sval +" no fue declarada");
            }

        }
break;
case 62:
//#line 190 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 63:
//#line 191 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 64:
//#line 192 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 71:
//#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 72:
//#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 73:
//#line 208 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 74:
//#line 211 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 75:
//#line 212 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 76:
//#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 77:
//#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 78:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 79:
//#line 216 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 80:
//#line 217 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 81:
//#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 82:
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 83:
//#line 223 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");}
break;
case 84:
//#line 224 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");}
break;
case 85:
//#line 228 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 86:
//#line 229 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 87:
//#line 230 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 89:
//#line 234 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 90:
//#line 235 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 91:
//#line 236 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 92:
//#line 237 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
//#line 246 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 96:
//#line 247 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 97:
//#line 248 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 98:
//#line 249 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 102:
//#line 259 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 103:
//#line 264 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 105:
//#line 272 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 106:
//#line 276 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(0).sval +"'" );
            if(val_peek(1).sval != null){    /*si se declaró bien*/
                ambito = ambito.substring(0,ambito.lastIndexOf("@"));
            }
         }
break;
case 108:
//#line 284 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 109:
//#line 287 "Gramatica.y"
{
                    parametroCopiaValor = (String) val_peek(1).obj;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = val_peek(3).sval + "@" + "ambito";
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema(val_peek(3).sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("Funcion");
                            Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                            ambito = ambito + "@" + val_peek(3).sval;
                            Main.tablaSimbolos.reemplazarLexema(parametroCopiaValor, parametroCopiaValor + ambito); /* Se agrega el ambito al parametro (nombre de la función)*/
                        }
                        else{
                            System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La funcion '" + val_peek(3).sval + "' ya fue declarada en este ámbito}");
                            yyval = new ParserVal(null);  /* se setea null para luego comprobar si se declaró o no*/
                        }
                    }
                    }
break;
case 111:
//#line 308 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 112:
//#line 309 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 113:
//#line 310 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 114:
//#line 311 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 115:
//#line 312 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 116:
//#line 315 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval);
                ds.setUso("Parametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);

                }
break;
case 118:
//#line 326 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 121:
//#line 334 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 122:
//#line 335 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 123:
//#line 336 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 124:
//#line 337 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 125:
//#line 338 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 126:
//#line 339 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 131:
//#line 352 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 136:
//#line 362 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 137:
//#line 363 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 138:
//#line 364 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 139:
//#line 365 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 140:
//#line 366 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 141:
//#line 367 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 142:
//#line 368 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 143:
//#line 369 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 144:
//#line 370 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 145:
//#line 372 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 146:
//#line 373 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 147:
//#line 374 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 148:
//#line 375 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 149:
//#line 376 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 150:
//#line 377 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 151:
//#line 378 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 152:
//#line 379 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 153:
//#line 380 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 154:
//#line 381 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 155:
//#line 382 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 156:
//#line 383 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 157:
//#line 384 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 158:
//#line 390 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 159:
//#line 391 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");

	                    Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("OR", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 160:
//#line 413 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 161:
//#line 414 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");
	                    Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("AND", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 162:
//#line 435 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 163:
//#line 436 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");

		    Operando op1 = (Operando)val_peek(2).obj;
                                    Operando op2 = (Operando)val_peek(0).obj;
                                    if(op1 != null && op2 !=null){
                                        if (op1.getTipo().equals(op2.getTipo())){
                                            Terceto t = new Terceto((String)val_peek(1).obj, op1.getValor(), op2.getValor());
                                            t.setTipo(op1.getTipo());
                                            adminTercetos.agregarTerceto(t);
                                            yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                                        }
                                        else{
                                            System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                                            yyval = new ParserVal(null);
                                         }
                                    }
                                    else{
                                           yyval = new ParserVal(null);
                                    }
                    }
break;
case 164:
//#line 459 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 165:
//#line 462 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");
	    Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("+", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
      }
break;
case 166:
//#line 482 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");
	    Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("-", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 167:
//#line 504 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");
                Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("*", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                            }
                            else{
                                System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
                    }
break;
case 168:
//#line 524 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");
                Operando op1 = (Operando)val_peek(2).obj;
                Operando op2 = (Operando)val_peek(0).obj;
                if(op1 != null && op2 !=null){
                    if (op1.getTipo().equals(op2.getTipo())){
                        Terceto t = new Terceto("/", op1.getValor(), op2.getValor());
                        t.setTipo(op1.getTipo());
                        adminTercetos.agregarTerceto(t);
                        yyval = new ParserVal(new Operando(op1.getTipo(), "["+t.getNumero()+"]"));
                    }
                    else{
                        System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                        yyval = new ParserVal(null);
                     }
                }
                else{
                       yyval = new ParserVal(null);
                }
            }
break;
case 169:
//#line 544 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 170:
//#line 548 "Gramatica.y"
{ if (chequearFactorNegado()){
                        Operando operando = (Operando) val_peek(0).obj;
                        yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                       }
                        }
break;
case 171:
//#line 553 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 172:
//#line 556 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 173:
//#line 559 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");
	            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(0).sval, ambito);
                	if(ambitoVariable != null)
                        yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                    else {
                    System.out.println("[Error semántico: Linea " + Lexico.linea + " la variable " + val_peek(0).sval +" no fue declarada");
                    yyval = new ParserVal(null);
	                }
	          }
break;
case 175:
//#line 572 "Gramatica.y"
{ yyval = new ParserVal(val_peek(0).sval);}
break;
case 176:
//#line 573 "Gramatica.y"
{ yyval = new ParserVal(val_peek(0).sval);}
break;
case 177:
//#line 574 "Gramatica.y"
{ yyval = new ParserVal(val_peek(0).sval);}
break;
case 178:
//#line 575 "Gramatica.y"
{ yyval = new ParserVal(val_peek(0).sval);}
break;
case 179:
//#line 576 "Gramatica.y"
{ yyval = new ParserVal(val_peek(0).sval);}
break;
case 180:
//#line 577 "Gramatica.y"
{ yyval = new ParserVal((String) val_peek(0).obj);}
break;
//#line 1683 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        if (yychar<0) yychar=0;  //clean, if necessary
        if (yydebug)
          yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
/**
 * A default run method, used for operating this parser
 * object in the background.  It is intended for extending Thread
 * or implementing Runnable.  Turn off with -Jnorun .
 */
public void run()
{
  yyparse();
}
//## end of method run() ########################################



//## Constructors ###############################################
/**
 * Default constructor.  Turn off with -Jnoconstruct .

 */
public Parser()
{
  //nothing to do
}


/**
 * Create a parser, setting the debug to true or false.
 * @param debugMe true for debugging, false for no debug.
 */
public Parser(boolean debugMe)
{
  yydebug=debugMe;
}
//###############################################################



}
//################### END OF CLASS ##############################
