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
//#line 20 "Parser.java"




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
    4,    4,   21,   21,   21,   17,   17,    9,    9,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   23,
   25,   25,   26,   26,   26,   27,   13,   13,   29,   29,
   29,   10,   10,   10,   31,   31,   31,   33,   33,   33,
   32,   32,   32,   32,   32,   32,   32,   32,   32,   11,
   11,   12,   12,   12,   12,   34,   34,   34,   34,   15,
   15,   36,   36,   36,   36,   35,   37,   37,   18,   18,
   18,   38,   19,   19,   41,   41,   41,   41,   41,   41,
   39,   39,   42,   20,   20,   44,   44,   44,   44,   44,
   44,   43,   40,   40,   40,   46,   45,   45,   45,   45,
   47,   47,   47,   47,   47,   47,   47,   47,   47,   47,
   47,   47,   47,   47,   47,   47,   47,   47,   47,   47,
   47,   47,   22,   22,   48,   48,   49,   49,   28,   28,
   28,   30,   30,   30,   51,   51,   51,   51,   51,   50,
   50,   50,   50,   50,   50,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,   11,    1,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   11,    3,
    1,    2,    1,    2,    1,    2,    3,    1,    2,    2,
    3,    7,    9,    1,    1,    5,    1,    4,    5,    4,
    6,    6,    6,    6,    6,    6,    6,    8,    8,    4,
    3,    4,    4,    4,    1,    3,    4,    4,    4,    4,
    1,    3,    3,    4,    4,    3,    1,    2,    3,    1,
    1,    2,    6,    1,    5,    5,    5,    5,    5,    5,
    2,    1,    2,    6,    1,    5,    5,    5,    5,    5,
    6,    2,    2,    1,    1,    2,    8,   14,   13,    1,
    7,    7,    7,    7,    7,    7,    7,    3,    8,   12,
   12,   12,   12,   12,   12,   12,   12,   12,   12,   12,
   13,    8,    1,    3,    1,    3,    1,    3,    1,    3,
    3,    3,    3,    1,    2,    1,    1,    1,    1,    1,
    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,  104,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    9,   10,   25,    0,    0,    0,
    0,    0,   19,    0,   27,   39,   58,   64,   85,   91,
    0,    0,    0,    0,    4,    7,    0,    0,    0,  101,
   35,    0,  167,    0,  166,    0,    0,  169,    0,  164,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  112,    1,
    0,    0,   12,   11,   20,   14,   21,   15,   22,   16,
   24,   17,   23,   18,   28,   26,    0,    0,    0,    0,
    0,   33,  102,   29,    0,   34,   30,    0,   61,    0,
    0,    0,    0,   86,  165,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  173,  174,  172,  175,  170,  171,
    0,    0,   81,   13,    8,    0,    0,    0,    0,   92,
    0,   93,    0,  113,  111,    0,    0,    0,    0,    0,
    0,    0,   99,   89,   84,   87,   82,   88,   83,  162,
  163,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   80,    0,    0,    0,    0,   97,    0,   94,   90,   95,
    0,    0,    0,    0,    0,  105,  124,  125,  130,  108,
    0,  109,  107,  106,    0,    0,    0,  115,    0,   65,
    0,   67,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   96,   98,    0,    0,    0,    0,    0,  126,  123,
    0,  103,    0,    0,    0,   31,    0,   73,   74,   76,
    0,   75,   72,    0,    0,    0,    0,    0,    0,   71,
    0,    0,    0,    0,    0,  138,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   62,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   70,
   68,    0,   78,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  118,  119,    0,  120,  117,
  116,   69,   66,   63,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  100,    0,  121,
  114,    0,   40,   42,   45,   46,    0,   48,   47,   44,
   43,   41,  132,    0,    0,    0,    0,    0,    0,    0,
  135,  136,  137,    0,  134,  133,    0,  131,    0,   53,
    0,   51,   55,   49,   38,    0,    0,    0,    0,  152,
    0,    0,    0,    0,    0,  139,  127,    0,   56,   54,
   50,   52,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  142,  143,
  145,  148,  149,  150,    0,  147,  146,  144,    0,    0,
  141,  140,  151,  129,    0,  128,
};
final static short yydgoto[] = {                          6,
  184,   23,    8,    9,  185,   25,   26,   27,   28,   29,
   30,   31,   32,   33,   34,   35,   10,   48,   11,  197,
   12,   77,  343,   36,  371,  372,  373,   64,   37,   65,
  201,   38,  202,   39,  140,   40,  177,   50,   78,  186,
   13,   79,  306,  198,  187,  188,  189,   66,   67,  131,
   60,
};
final static short yysindex[] = {                       625,
  184,  -28,    0,    0, -235,    0,  212,    0,    0, -182,
  -34,    0,    0,  536,  221,  504,   42,  496,  -27,   34,
  386,  212,  658,  321,    0,    0,    0,  -33,  116,  119,
  129,  132,    0,  157,    0,    0,    0,    0,    0,    0,
  -37, -173,   50,  221,    0,    0,   76,  120,  283,    0,
    0,   80,    0,  609,    0,    3,  221,    0,   71,    0,
   71,  485,   -4,   84,   71, -193,  624,  -31,  632,   75,
   64,   77, -160, -247, -152, -121,   22,   99,    0,    0,
   76,  658,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -20,  101,  108, -173,
 -173,    0,    0,    0, -101,    0,    0,  136,    0,   84,
  -30,  -24,   18,    0,    0,  221,  221, -112,   25,  221,
 -100,  221,  221,  221,    0,    0,    0,    0,    0,    0,
  221,  130,    0,    0,    0,  -88,  373,  -86,  513,    0,
 -196,    0, -160,    0,    0,  -96,  165,  165,    5,  165,
  165,  -36,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  330,  330,   30, -193,  330,   71,   71,  624,   84,
    0,  115,  117,  -39,  124,    0,  503,    0,    0,    0,
  330,  231,  145,  140,  349,    0,    0,    0,    0,    0,
  165,    0,    0,    0,  -32, -173,  131,    0,  496,    0,
  -81,    0,  -67,  235,  154,  155,  221,  221,  685,  221,
  221,    0,    0,  156,  395,  681,  250,  221,    0,    0,
  398,    0,  -13,  391,  399,    0,  361,    0,    0,    0,
 -205,    0,    0,   33,   74,  724,  125,  128,  139,    0,
  221,  578,  413,   28,  642,    0,  221,   36,  221,  401,
   26,  405,  407,  392,  370,    0,  277,  196,  213,  214,
  149,  215,  216,  223,   39,  411,  -25,  221,  423,  580,
   47,   52,  428,   53,  243,  243,  -40,  243,  243,    0,
    0,  400,    0,  238,  460,  474,  478,  479,   -5,  481,
  486,  487,  473,  496,  496,  390,   54,  496,  482,  -17,
  483,    9,  496,  491,  276,    0,    0, -102,    0,    0,
    0,    0,    0,    0,  263,  263,  263,  263,  -26,  263,
  263,  263,  263,  280,  389,  410,  417,  436,  500,  437,
  291,  294,  -54,  298,  299,  456,  302,    0,   12,    0,
    0,  457,    0,    0,    0,    0, -185,    0,    0,    0,
    0,    0,    0,  498,  531,  548,  289,  550,  477,  563,
    0,    0,    0, -203,    0,    0,  567,    0,  409,    0,
  304,    0,    0,    0,    0,  221,  221,  221,  652,    0,
  221,  221,  570,  484,  221,    0,    0,  221,    0,    0,
    0,    0,   55,   56,   58,  634,   66,   85,   90,  221,
  575,   91,   93,  527,  535,  600,  607,  -12,  617,   27,
  636,  102,  221,  643,  644,  364,  426,  431,  447,  448,
  -50,  471,  497,  505,  653,  106,  515,  520,    0,    0,
    0,    0,    0,    0,  455,    0,    0,    0,  521,  672,
    0,    0,    0,    0,  522,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  751,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  148,    0,    0,    0,
    0,  744,    0,    0,    0,    0,    0,    0,  476,    0,
  523,    0,    0,  798,  554,   78,   82,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  754,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  532,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  296,    0,  766,  786,  368,  810,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  546,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  549,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  596,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  714,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   61,   69,    0,   16,   32,    0,  -18,   29,    0,    0,
    0,  -14,    0,    0,  778,    0,  820,  512,  791,    0,
    0,    2,  606,    0,    0,  451,    0,   -3,    0,   43,
  -42,    0,    0,    0,  -60,    0,    0,    0,  -10,   10,
    0,    0, -126,    0,  635,    0,    0,  688,  694,    0,
  -16,
};
final static int YYTABLESIZE=1079;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   58,   58,   97,  196,  364,   84,   58,  223,  435,  133,
  155,   42,   72,  142,  347,  296,  157,   63,  308,  210,
  148,   43,   46,  333,   51,   86,  139,  250,  421,   58,
   98,   99,   24,  295,  141,  320,  121,   46,   24,   58,
  115,  332,   58,  114,   44,  191,  420,   58,   74,   70,
  110,   84,  386,   24,   58,  105,   59,   61,  159,  178,
    7,   22,  146,  119,  256,  164,  277,  335,  269,   44,
  374,  387,  124,   44,   47,   45,  273,  139,  257,  293,
  179,   68,  180,   82,  276,  423,  149,  301,  342,    2,
   80,  258,  302,  304,  329,  404,  405,   46,  406,  160,
  161,   58,   58,    3,    4,   58,  409,   58,   58,   58,
  100,   59,  116,  139,   44,  101,   58,  117,  153,  108,
  203,  205,  155,  206,  136,  410,  122,  170,  123,  143,
  411,  414,  259,  415,  144,  145,  153,  138,  214,  147,
  155,  150,  425,  200,  200,  200,  440,  200,  151,  307,
  309,  310,  311,  340,  305,  153,  162,  190,  192,  193,
  194,  231,  200,  105,  167,  168,   84,  176,  166,  172,
  171,  175,  181,  207,   88,  208,  114,   90,  104,   44,
  227,  341,  211,  262,  218,  200,  263,   92,  228,  226,
   94,  100,   58,   58,   58,   58,   58,  264,   84,   46,
  222,   58,  229,   58,   44,  213,  100,  289,  234,  235,
  237,  238,  239,  217,  284,   96,  305,  244,  209,  248,
  363,   58,   85,   21,  434,  154,   58,   58,   41,   71,
   58,  156,   58,  132,   58,  195,   84,  261,  200,    3,
    4,  120,  265,  267,    3,    4,  271,  342,  272,  120,
  274,   44,  319,   58,  120,   58,    3,    4,  255,  111,
  112,   14,  120,    3,    4,   57,  113,   15,  103,  297,
   44,  300,   16,  158,   44,   17,    2,  181,  182,    3,
    4,    3,    4,   19,  183,   20,   69,    5,  120,  247,
   69,  120,   15,  163,  120,  181,   15,   16,  204,  120,
   17,   16,  120,  199,   17,  120,   84,   84,   19,   84,
   20,   84,   19,  120,   20,   73,   44,   84,  120,  120,
  120,  120,  120,  370,  120,  325,  326,  328,  381,  330,
  134,   69,  120,  137,  336,  153,  154,   15,   84,  155,
  120,  107,   16,   44,  153,   17,  153,  155,  155,  135,
  155,  120,  370,   19,  154,   20,  120,  120,  357,  120,
   44,   58,   58,   58,   58,   84,   58,   58,  120,   44,
   58,   87,  120,   58,   89,  102,  103,  393,  394,  395,
  397,   58,  398,  399,   91,   58,  402,   93,   44,  403,
  384,  120,  111,  112,  120,  219,   14,  408,   58,  113,
   44,  412,   15,  100,  100,  120,  288,   16,  156,   44,
   17,    2,   95,  182,  426,  120,    3,    4,   19,  183,
   20,   14,    5,  232,  233,  240,  156,   15,   44,   44,
   57,  252,   16,  174,  241,   17,    2,  249,  182,  253,
   14,    3,    4,   19,  183,   20,   15,    5,  327,   44,
  281,   16,  268,  285,   17,    2,   44,   18,  313,  275,
    3,    4,   19,  278,   20,  279,    5,  390,   14,  294,
  286,  287,  290,  291,   15,   44,   44,   52,   53,   16,
  292,  298,   17,    2,   55,   18,  303,   69,    3,    4,
   19,   69,   20,   15,    5,   44,   44,   15,   16,  305,
  315,   17,   16,  215,  230,   17,   69,  314,  199,   19,
  216,   20,   15,   19,  316,   20,   44,   16,  317,  318,
   17,  321,  245,   44,  246,  118,  322,  323,   19,   57,
   20,  324,  338,   69,   60,   44,  342,  376,  106,   15,
  331,  334,   44,   62,   16,   69,  283,   17,   57,  337,
  199,   15,   44,  154,  353,   19,   16,   20,  359,   17,
   69,  379,  154,  380,  154,  361,   15,   19,  362,   20,
  377,   16,  365,  366,   17,   56,  368,   69,  391,  369,
   57,   59,   19,   15,   20,  416,   69,  378,   16,  382,
   57,   17,   15,  417,  159,   83,  159,   16,  159,   19,
   17,   20,  385,  199,  110,   69,  388,   77,   19,  400,
   20,   15,  159,  159,  413,  159,   16,   69,  266,   17,
  299,  221,   57,   15,   57,  156,   69,   19,   16,   20,
  173,   17,   15,  156,  156,  254,  156,   16,  429,   19,
   17,   20,   52,   53,  282,   69,   69,  280,   19,   55,
   20,   15,   15,   57,   79,  312,   16,   16,  418,   17,
   17,  354,    3,    4,  389,  419,   69,   19,   19,   20,
   20,  108,   15,   69,  407,  422,   57,   16,   57,   15,
   17,  270,  355,  129,   16,  130,   57,   17,   19,  356,
   20,  396,   69,   69,  424,   19,   57,   20,   15,   15,
  430,  427,  428,   16,   16,  431,   17,   17,  358,  360,
  443,  439,   69,   69,   19,   19,   20,   20,   15,   15,
  242,  432,  433,   16,   16,   57,   17,   17,  367,   57,
  445,   60,  369,   69,   19,   19,   20,   20,  243,   15,
   69,   52,   53,  236,   16,  436,   15,   17,   55,  383,
    2,   16,   69,    5,   17,   19,  401,   20,   15,   69,
   52,   53,   19,   16,   20,   15,   17,   55,   57,   69,
   16,  437,  122,   17,   19,   15,   20,  212,   59,  438,
   16,   19,  260,   17,  168,  168,  168,   57,  168,  441,
  168,   19,   52,   53,  442,  444,  446,   75,   54,   55,
   49,  110,  168,  168,   77,  168,  160,  165,  160,  159,
  160,  159,  159,  159,  159,  159,  339,  169,  220,  159,
  159,  392,  159,    0,  160,  160,  161,  160,  161,    0,
  161,    0,    0,    0,   52,   53,   52,   53,  157,    0,
   76,   55,    0,   55,  161,  161,    0,  161,    0,    0,
  158,   79,    0,    0,    0,    0,  157,  157,    0,  157,
   76,   76,    0,    0,  109,   52,   53,    0,  158,  158,
    0,  158,   55,    0,    0,   76,    0,    0,    0,    0,
    0,    1,  125,  126,  127,  128,    0,    0,   52,   53,
   52,   53,    0,    0,   54,   55,    2,   55,   52,   53,
    0,    3,    4,    0,    0,   55,    0,    5,   52,   53,
    0,    0,    0,    0,   81,   55,   76,    0,    0,  152,
   76,  344,  345,  346,  348,  349,  350,  351,  352,    2,
    0,    0,    0,    0,    3,    4,    0,   52,   53,    0,
    5,   52,   53,    0,   55,    0,    0,    0,   55,    0,
    0,    0,  375,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   52,   53,    0,    0,    0,    0,    0,   55,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  168,
    0,  168,  168,  168,  168,  168,    0,    0,    0,  168,
  168,    0,  168,    0,  224,  225,    0,    0,    0,    0,
    0,  160,    0,  160,  160,  160,  160,  160,    0,    0,
    0,  160,  160,    0,  160,    0,    0,    0,    0,    0,
    0,  161,  251,  161,  161,  161,  161,  161,    0,    0,
    0,  161,  161,    0,  161,  157,  157,  157,  157,  157,
    0,    0,    0,  157,  157,    0,  157,  158,  158,  158,
  158,  158,    0,    0,    0,  158,  158,    0,  158,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         14,
   15,   16,   40,   40,   59,   24,   21,   40,   59,   41,
   41,   40,   40,   74,   41,   41,   41,   16,   59,   59,
   41,  257,    7,   41,   59,   59,  274,   41,   41,   44,
   41,   42,    1,   59,  282,   41,   41,   22,    7,   54,
   57,   59,   57,   41,   40,   41,   59,   62,   20,   18,
   54,   70,  256,   22,   69,   44,   14,   15,   41,  256,
    0,    1,   41,   62,  270,   41,   41,   59,   41,   40,
  256,  275,  266,   40,  257,    7,   41,  274,  284,   41,
  141,   40,  143,   23,   59,   59,   97,   41,  274,  272,
   22,   59,   41,   41,   41,   41,   41,   82,   41,  116,
  117,  116,  117,  277,  278,  120,   41,  122,  123,  124,
   61,   69,   42,  274,   40,   40,  131,   47,   41,   40,
  163,  164,   41,  166,   61,   41,   43,  131,   45,  282,
   41,   41,   59,   41,  256,  257,   59,   61,  181,   41,
   59,   41,   41,  162,  163,  164,   41,  166,   41,  276,
  277,  278,  279,  256,  257,  257,  269,  148,  149,  150,
  151,  204,  181,   44,  122,  123,  185,  139,  269,  258,
   41,  258,  269,   59,   59,   59,   41,   59,   59,   40,
  199,  308,   59,   59,   40,  204,   59,   59,  270,   59,
   59,   44,  207,  208,  209,  210,  211,   59,  217,  184,
  191,  216,  270,  218,   40,  177,   59,   59,  207,  208,
  209,  210,  211,  182,  257,   59,  257,  216,  258,  218,
  275,  236,  256,   40,  275,  256,  241,  242,  257,  257,
  245,  256,  247,  265,  249,  272,  255,  236,  257,  277,
  278,  267,  241,  242,  277,  278,  245,  274,  247,  267,
  249,   40,  258,  268,  267,  270,  277,  278,  227,  257,
  258,  257,  267,  277,  278,   45,  264,  263,  257,  268,
   40,  270,  268,  256,   40,  271,  272,  269,  274,  277,
  278,  277,  278,  279,  280,  281,  257,  283,  267,   40,
  257,  267,  263,  269,  267,  269,  263,  268,  269,  267,
  271,  268,  267,  274,  271,  267,  325,  326,  279,  328,
  281,  330,  279,  267,  281,  282,   40,  336,  267,  267,
  267,  267,  267,  342,  267,  294,  295,  296,   40,  298,
  256,  257,  267,  257,  303,  258,   41,  263,  357,  258,
  267,   59,  268,   40,  267,  271,  269,  266,  267,  275,
  269,  267,  371,  279,   59,  281,  267,  267,  327,  267,
   40,  376,  377,  378,  379,  384,  381,  382,  267,   40,
  385,  256,  267,  388,  256,  256,  257,  376,  377,  378,
  379,  396,  381,  382,  256,  400,  385,  256,   40,  388,
  359,  267,  257,  258,  267,  256,  257,  396,  413,  264,
   40,  400,  263,  256,  257,  267,  258,  268,   41,   40,
  271,  272,  256,  274,  413,  267,  277,  278,  279,  280,
  281,  257,  283,  270,  270,  270,   59,  263,   40,   40,
   45,   41,  268,   61,   40,  271,  272,   40,  274,   41,
  257,  277,  278,  279,  280,  281,  263,  283,   59,   40,
   59,  268,   40,  258,  271,  272,   40,  274,   59,   59,
  277,  278,  279,   59,  281,   59,  283,   59,  257,   59,
  258,  258,  258,  258,  263,   40,   40,  257,  258,  268,
  258,   59,  271,  272,  264,  274,   59,  257,  277,  278,
  279,  257,  281,  263,  283,   40,   40,  263,  268,  257,
   41,  271,  268,  273,  270,  271,  257,  270,  274,  279,
  280,  281,  263,  279,   41,  281,   40,  268,   41,   41,
  271,   41,  273,   40,  275,   41,   41,   41,  279,   45,
  281,   59,  257,  257,   59,   40,  274,   40,  256,  263,
   59,   59,   40,   40,  268,  257,  270,  271,   45,   59,
  274,  263,   40,  258,  275,  279,  268,  281,   59,  271,
  257,  273,  267,  275,  269,  275,  263,  279,  275,  281,
   40,  268,  275,  275,  271,   40,  275,  257,  275,  276,
   45,   59,  279,  263,  281,   59,  257,   40,  268,   40,
   59,  271,  263,   59,   41,  275,   43,  268,   45,  279,
  271,  281,   40,  274,   59,  257,   40,   59,  279,   40,
  281,  263,   59,   60,   40,   62,  268,  257,   41,  271,
   41,  273,   45,  263,   45,  258,  257,  279,  268,  281,
  258,  271,  263,  266,  267,  275,  269,  268,  275,  279,
  271,  281,  257,  258,  275,  257,  257,  256,  279,  264,
  281,  263,  263,   45,   59,  256,  268,  268,   59,  271,
  271,  273,  277,  278,  256,   59,  257,  279,  279,  281,
  281,   40,  263,  257,   41,   59,   45,  268,   45,  263,
  271,   40,  273,   60,  268,   62,   45,  271,  279,  273,
  281,   40,  257,  257,   59,  279,   45,  281,  263,  263,
  275,   59,   59,  268,  268,  275,  271,  271,  273,  273,
  256,   59,  257,  257,  279,  279,  281,  281,  263,  263,
   40,  275,  275,  268,  268,   45,  271,  271,  273,   45,
   59,  256,  276,  257,  279,  279,  281,  281,   58,  263,
  257,  257,  258,   59,  268,  275,  263,  271,  264,  273,
    0,  268,  257,    0,  271,  279,  273,  281,  263,  257,
  257,  258,  279,  268,  281,  263,  271,  264,   45,  257,
  268,  275,   59,  271,  279,  263,  281,  275,  256,  275,
  268,  279,   59,  271,   41,   42,   43,  256,   45,  275,
   47,  279,  257,  258,  275,  275,  275,   20,  263,  264,
   10,  256,   59,   60,  256,   62,   41,  120,   43,  256,
   45,  258,  259,  260,  261,  262,  305,  124,  184,  266,
  267,  371,  269,   -1,   59,   60,   41,   62,   43,   -1,
   45,   -1,   -1,   -1,  257,  258,  257,  258,   41,   -1,
   21,  264,   -1,  264,   59,   60,   -1,   62,   -1,   -1,
   41,  256,   -1,   -1,   -1,   -1,   59,   60,   -1,   62,
   41,   42,   -1,   -1,  256,  257,  258,   -1,   59,   60,
   -1,   62,  264,   -1,   -1,   56,   -1,   -1,   -1,   -1,
   -1,  257,  259,  260,  261,  262,   -1,   -1,  257,  258,
  257,  258,   -1,   -1,  263,  264,  272,  264,  257,  258,
   -1,  277,  278,   -1,   -1,  264,   -1,  283,  257,  258,
   -1,   -1,   -1,   -1,  257,  264,   97,   -1,   -1,  100,
  101,  316,  317,  318,  319,  320,  321,  322,  323,  272,
   -1,   -1,   -1,   -1,  277,  278,   -1,  257,  258,   -1,
  283,  257,  258,   -1,  264,   -1,   -1,   -1,  264,   -1,
   -1,   -1,  347,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,  258,   -1,   -1,   -1,   -1,   -1,  264,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,
   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,  269,   -1,  195,  196,   -1,   -1,   -1,   -1,
   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,  269,   -1,   -1,   -1,   -1,   -1,
   -1,  256,  223,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,  269,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,  269,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,   -1,  269,
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
"control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"control : error_control",
"error_control : REPEAT IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' error",
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
"funcion : FUNC IDENTIFICADOR '(' parametro ')' bloque_funcion",
"funcion : error_funcion",
"error_funcion : IDENTIFICADOR '(' parametro ')' bloque_funcion",
"error_funcion : FUNC '(' parametro ')' bloque_funcion",
"error_funcion : FUNC IDENTIFICADOR parametro ')' bloque_funcion",
"error_funcion : FUNC IDENTIFICADOR '(' ')' bloque_funcion",
"error_funcion : FUNC IDENTIFICADOR '(' parametro bloque_funcion",
"error_funcion : FUNC IDENTIFICADOR '(' parametro ')'",
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

//#line 324 "Gramatica.y"

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
//#line 786 "Parser.java"
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
//#line 12 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +val_peek(2).sval + "'}");}
break;
case 2:
//#line 13 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +val_peek(1).sval + "'}");}
break;
case 4:
//#line 17 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 5:
//#line 18 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 12:
//#line 37 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 13:
//#line 38 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 20:
//#line 51 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
//#line 52 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
//#line 53 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
//#line 54 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 55 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
//#line 63 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 68 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 31:
//#line 70 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + val_peek(4).sval +"'}");}
break;
case 33:
//#line 75 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
//#line 76 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
//#line 77 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 38:
//#line 86 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 40:
//#line 90 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
//#line 91 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 42:
//#line 92 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 43:
//#line 93 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 44:
//#line 94 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 95 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 46:
//#line 96 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 47:
//#line 97 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 48:
//#line 98 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 49:
//#line 99 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 56:
//#line 114 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 57:
//#line 117 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + val_peek(2).sval + ":= " + val_peek(0).sval +"}");}
break;
case 59:
//#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 60:
//#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 61:
//#line 124 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 68:
//#line 139 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 69:
//#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 70:
//#line 141 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 71:
//#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 72:
//#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 73:
//#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 74:
//#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 75:
//#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 76:
//#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 77:
//#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 78:
//#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 79:
//#line 152 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 80:
//#line 156 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");}
break;
case 81:
//#line 157 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");}
break;
case 82:
//#line 161 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 83:
//#line 162 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 84:
//#line 163 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 86:
//#line 167 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 87:
//#line 168 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 88:
//#line 169 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 89:
//#line 170 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 92:
//#line 179 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 93:
//#line 180 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 94:
//#line 181 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 95:
//#line 182 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 99:
//#line 192 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 100:
//#line 193 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 102:
//#line 198 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 103:
//#line 201 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 105:
//#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 106:
//#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 107:
//#line 208 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 108:
//#line 209 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 109:
//#line 210 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 110:
//#line 211 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 113:
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 116:
//#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 117:
//#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 118:
//#line 229 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 119:
//#line 230 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 120:
//#line 231 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 121:
//#line 232 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 126:
//#line 245 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 131:
//#line 255 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 132:
//#line 256 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 133:
//#line 257 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 134:
//#line 258 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 135:
//#line 259 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 136:
//#line 260 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 137:
//#line 261 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 138:
//#line 262 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 139:
//#line 263 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 140:
//#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 141:
//#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 142:
//#line 267 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 143:
//#line 268 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 144:
//#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 145:
//#line 270 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 146:
//#line 271 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 147:
//#line 272 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 148:
//#line 273 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 149:
//#line 274 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 150:
//#line 275 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 151:
//#line 276 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 152:
//#line 277 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 154:
//#line 284 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 156:
//#line 288 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 158:
//#line 292 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 160:
//#line 296 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 161:
//#line 297 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 162:
//#line 300 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 163:
//#line 301 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 165:
//#line 306 "Gramatica.y"
{chequearFactorNegado();}
break;
case 166:
//#line 307 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");}
break;
case 167:
//#line 308 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");}
break;
case 168:
//#line 309 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1371 "Parser.java"
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
