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
   26,   26,   23,   24,   28,   28,   29,   29,   29,   30,
   13,   13,   32,   32,   32,   10,   10,   10,   34,   34,
   39,   35,   36,   36,   36,   40,   40,   40,   37,   37,
   37,   37,   37,   37,   37,   11,   11,   12,   12,   12,
   12,   41,   41,   41,   41,   15,   15,   43,   43,   43,
   43,   42,   44,   44,   18,   18,   18,   45,   19,   19,
   48,   46,   46,   50,   50,   50,   50,   50,   49,   49,
   51,   20,   20,   53,   53,   53,   53,   53,   53,   52,
   47,   47,   47,   55,   54,   54,   54,   54,   57,   57,
   57,   57,   57,   57,   57,   57,   57,   57,   57,   57,
   57,   57,   57,   57,   57,   57,   56,   56,   58,   58,
   58,   58,   58,   38,   38,   59,   59,   27,   27,   31,
   31,   31,   33,   33,   33,   61,   61,   61,   61,   61,
   60,   60,   60,   60,   60,   60,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,    1,    8,
    8,    8,    8,    8,    8,    8,    9,    3,    1,    2,
    2,    3,    1,    3,    1,    2,    1,    2,    1,    2,
    3,    1,    2,    2,    3,    5,    7,    1,    3,    1,
    3,    1,    1,    5,    1,    4,    5,    4,    4,    4,
    4,    4,    5,    6,    7,    4,    3,    4,    4,    4,
    1,    3,    4,    4,    4,    4,    1,    3,    3,    4,
    4,    3,    1,    2,    3,    1,    1,    2,    2,    1,
    2,    5,    1,    4,    4,    4,    4,    5,    2,    1,
    2,    6,    1,    5,    5,    5,    5,    5,    6,    2,
    2,    1,    1,    2,    8,   10,    9,    1,    7,    7,
    7,    7,    7,    7,    7,    3,    8,    9,    9,    9,
    9,    9,    9,    9,   10,    5,    5,    1,    4,    4,
    4,    4,    5,    1,    3,    1,    3,    1,    3,    1,
    3,    3,    3,    3,    1,    2,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  110,  113,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   39,   62,    0,
   68,   70,   91,   97,    0,    0,    0,    0,    4,    7,
    0,    0,    0,  107,   35,  111,    0,    0,    0,    0,
    0,  109,  132,  133,    0,  138,  158,    0,  178,    0,
  177,    0,    0,  180,    0,  175,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   49,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  120,    0,    1,    0,
    0,   12,   11,   20,   14,   21,   15,   22,   16,   24,
   17,   23,   18,   28,   26,    0,    0,    0,    0,    0,
    0,   33,  108,   29,    0,   34,   30,    0,    0,    0,
    0,    0,    0,  134,  131,    0,    0,    0,   65,    0,
    0,    0,    0,   92,  176,    0,    0,    0,   73,    0,
   72,   75,    0,    0,    0,   87,   13,    8,   51,    0,
   50,    0,    0,    0,    0,   98,    0,   99,    0,  121,
  119,  184,  185,  183,  186,  181,  182,    0,    0,    0,
   71,    0,   69,  114,    0,    0,  117,    0,  116,  115,
    0,  105,    0,    0,  146,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   95,   90,   93,   88,   94,   89,
  173,  174,    0,   80,   82,    0,   81,   86,   52,   48,
    0,    0,    0,    0,    0,  103,    0,  100,   96,  101,
    0,    0,    0,    0,    0,   79,  118,  112,    0,    0,
    0,  123,    0,    0,    0,    0,    0,    0,    0,  160,
  162,    0,  161,  159,    0,    0,    0,    0,   83,   66,
    0,    0,    0,    0,    0,    0,  102,  104,    0,    0,
    0,   31,    0,    0,    0,    0,    0,    0,    0,  156,
    0,    0,  163,  157,    0,    0,   78,   76,    0,   84,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   77,   74,   85,   67,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  140,  143,  144,  145,    0,  142,  141,    0,    0,    0,
    0,    0,    0,  139,    0,    0,   41,   43,   44,    0,
   46,   45,   42,   40,    0,  126,  127,    0,  128,  125,
  124,  147,  135,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   57,    0,   55,   59,   47,   38,  106,    0,
  129,  122,  137,  152,  153,  154,    0,  151,  150,  149,
  148,   60,   58,   54,   56,  155,  136,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   74,   34,   35,   36,   37,   10,   52,   11,  241,
   12,   86,  221,  347,   38,   87,   92,  374,  375,  376,
   93,   39,   94,   40,  150,  151,   41,   95,   42,  152,
   43,  166,   44,  227,   54,   13,   62,   14,   96,   15,
   97,  356,  242,   63,   64,   65,   66,   67,   98,  178,
   76,
};
final static short yysindex[] = {                       -84,
   34,  -29,    0,    0, -220,    0,   59,    0,    0, -182,
  -15,    0,   -4,    0,    0,  401,  451,  -18,   36,  310,
  152,  -38,  -42,   59,  474,  194,    0,    0,    0,  -45,
   78,  155,  302,  348,    0,  368,    0,    0,    0, -162,
    0,    0,    0,    0,  -39, -127,   50,  451,    0,    0,
   74,  112,  370,    0,    0,    0,   84,   -9,  115,   15,
  209,    0,    0,    0,   99,    0,    0,  132,    0,  446,
    0,   46,  451,    0,   24,    0,   24,  221,  103,  -34,
  414,  122, -225, -110,  -50,  106,    0, -114, -141, -104,
  -81,  547,  101,   24,    2,  140,    0,  -80,    0,   74,
  474,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  221,  -23,  146,  148, -127,
 -127,    0,    0,    0,  -67,    0,    0,  160,  123,  240,
  451,  423,  451,    0,    0,  161,  310,  376,    0,  101,
   26,   28,   29,    0,    0,  451,  451,  310,    0,  -75,
    0,    0,  142,  -68,  165,    0,    0,    0,    0, -136,
    0,  451,  468,  451,   91,    0, -177,    0, -114,    0,
    0,    0,    0,    0,    0,    0,    0,  451,  451,  451,
    0,  451,    0,    0,  451,  -61,    0,   51,    0,    0,
  -30,    0,  451,  431,    0,  451,  241,  260,   23,  442,
   42,   47,  451,  261,    0,    0,    0,    0,    0,    0,
    0,    0,  280,    0,    0, -165,    0,    0,    0,    0,
  159,  547,  491,  267,  329,    0,  327,    0,    0,    0,
  101,   24,   24,  -80,  547,    0,    0,    0,  -32, -127,
  359,    0,   52,  460,   68,  125,  170,  151,  184,    0,
    0,  133,    0,    0,   72,  380,  405,  281,    0,    0,
  168,  175,  185,  -35,  186,  202,    0,    0,  -12,  387,
  420,    0,  408,  411,  -11,  422,  435,  451,  434,    0,
  451,  451,    0,    0,  448,  451,    0,    0,  426,    0,
 -116,  452,  484,  489,    4,  494,  504,  487,   41,  495,
  498,  278,  289,  295,  -46,  296,  297,   77,  465,   82,
  139,   89,  301,  108,    0,    0,    0,    0,  305,  305,
  305,  -26,  305,  305,  305,  323,  323,   94,  323,  323,
    0,    0,    0,    0, -236,    0,    0,  524,  527,   21,
  533,  538,  549,    0,  551,  306,    0,    0,    0, -140,
    0,    0,    0,    0,  355,    0,    0,  -72,    0,    0,
    0,    0,    0,  339,  341,  344,  -43,  346,  347,  353,
  356,  427,    0,  177,    0,    0,    0,    0,    0,    6,
    0,    0,    0,    0,    0,    0, -228,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  636,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  391,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  558,    0,    0,
    0,    0,    0,    0,  440,    0,  456,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   62,  506,  570,    0,    0,    0,   76,    0,    0,
  638,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  457,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  100,    0,    0,    0,    0,    0,    0,    0,    0,
  534,  582,  594,  120,  396,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  374,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  374,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  586,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   71,   39,    0,   44,  654,    0,  -21,  361,    0,    0,
    0,   -1,    0,    0,  624,    0,  -19,  294,  640,    0,
    0,  566, -129,  413,    0,    0,  522,    0,  283,    0,
  -53,    0,   25,  637,  -27,  399,    0,  672,    0,    0,
    0,  -57,    0,    0,    0,    0,    0,    0,   40,    0,
    0, -160,    0,  606,    0,  611,    0,    0,  488,    0,
   -8,
};
final static int YYTABLESIZE=981;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         33,
  117,   48,   73,   91,  103,   33,  156,  269,  162,  240,
   46,   33,  335,  105,  350,  387,  140,  187,   33,  362,
   33,   48,   33,  295,   33,   91,   91,  396,  298,  305,
  131,  168,  159,  224,  225,   48,   47,  160,  363,  103,
   75,   77,  183,   55,  323,   49,  397,  304,  132,  125,
   50,  154,   91,   59,   48,   33,  149,  149,   33,   33,
  103,  367,   99,  250,  145,  146,  206,   50,  208,  210,
  147,   24,   59,   23,   51,   80,   33,   33,  228,  366,
   33,  328,  253,   60,  118,  119,  144,  254,  186,    2,
  259,  238,  273,  264,  149,  101,  165,   91,   48,  327,
  191,   91,  166,   50,  260,   75,  116,  103,  276,  229,
  120,  230,  285,  121,   33,  377,  164,  338,  261,  219,
  166,  220,  341,   48,  231,  216,  213,   33,   33,  343,
   48,  149,  165,  346,  164,   33,  107,  211,  212,  317,
  167,   59,   48,  179,   50,  180,   33,  161,  345,    3,
    4,   33,  358,  318,  133,  125,  188,  137,   53,  165,
  165,   48,  196,   33,  164,  277,  357,  359,  360,  361,
  124,  138,    1,  284,  170,  171,  103,  169,  165,  342,
  184,   48,  103,  381,  355,  185,  189,    2,  190,  192,
  281,   85,    3,    4,  214,   33,   33,  382,    5,  193,
  203,  217,   33,  232,  233,  218,   83,   48,  236,  278,
  104,   33,   84,  109,   68,   69,   48,  262,   81,  270,
  271,   71,  294,  282,   17,   33,  103,   45,  334,   18,
  155,  386,   19,   48,    3,    4,  103,    3,    4,  149,
   21,  239,   22,   88,    3,    4,   33,  346,   48,  299,
   78,   56,   16,    3,    4,  182,   33,  181,   17,   33,
   48,  322,  123,   18,    3,    4,   19,    2,  182,   57,
  134,   16,    3,    4,   21,   58,   22,   17,    5,   48,
   48,  205,   18,  207,  209,   19,    2,  182,   57,  182,
   16,    3,    4,   21,   58,   22,   17,    5,  197,   48,
   48,   18,  141,  142,   19,    2,  237,   20,  182,  143,
    3,    4,   21,  182,   22,   16,    5,  166,  182,   48,
   48,   17,    3,    4,  373,  265,   18,  166,  166,   19,
    2,  164,   20,  106,  182,    3,    4,   21,  182,   22,
   81,    5,  164,  182,   33,   48,   17,   81,  182,   48,
  355,   18,  373,   17,   19,  182,  128,   53,   18,   81,
  111,   19,   21,   58,   22,   17,   48,  122,  123,   21,
   18,  153,   33,   19,  182,  165,  148,  157,   81,   81,
  181,   21,   89,   22,   17,   17,  165,  266,  283,   18,
   18,  182,   19,   19,  181,  194,  158,  195,   81,  182,
   21,   21,   22,   22,   17,  182,  113,   81,   83,   18,
  108,  215,   19,   17,   84,  148,  144,  272,   18,  286,
   21,   19,   22,  279,   81,  280,  115,  300,  127,   21,
   17,   22,  292,   81,  106,   18,  167,  290,   19,   17,
   72,  148,  293,  296,   18,   73,   21,   19,   22,  106,
   81,  394,  372,  138,  167,   21,   17,   22,   73,  297,
  301,   18,  200,  288,   19,   81,  302,   73,  102,  303,
  244,   17,   21,  309,   22,   73,   18,   81,   73,   19,
  306,  136,  251,   17,  316,  393,   73,   21,   18,   22,
   73,   19,  319,  307,  148,   73,   81,   81,   64,   21,
  274,   22,   17,   17,   73,  339,  313,   18,   18,   73,
   19,   19,   73,  247,   63,   61,   81,   81,   21,   21,
   22,   22,   17,   17,  320,  226,  223,   18,   18,  321,
   19,   19,  249,  256,  324,   73,   81,   81,   21,   21,
   22,   22,   17,   17,  325,  326,  168,   18,   18,  263,
   19,   19,  331,  329,  257,  289,  330,  110,   21,   21,
   22,   22,   81,  332,  168,  168,   81,  168,   17,  333,
  336,  337,   17,   18,  169,  344,   19,   18,  346,  355,
   19,  372,  364,   81,   21,  365,   22,  268,   21,   17,
   22,  368,  169,  169,   18,  169,  369,   19,  179,  179,
  179,  267,  179,  112,  179,   21,  176,  370,  177,  371,
  170,  379,  170,  383,  170,  384,  179,  179,  385,  179,
  388,  389,  171,  114,  171,  126,  171,  390,  170,  170,
  391,  170,  141,  142,  172,    2,  172,    5,  172,  143,
  171,  171,   69,  171,  130,   90,  106,  106,  380,   53,
  163,  167,  172,  172,   79,  172,  395,   68,   69,  291,
  287,  167,  167,   70,   71,  135,   61,  130,    0,  234,
   68,   69,    0,   82,    0,    0,   70,   71,    0,   68,
   69,  315,  392,  222,  222,  222,   71,   68,   69,    0,
   68,   69,    0,    0,   71,   64,    0,   71,   68,   69,
    0,  139,   68,   69,    0,   71,  235,   68,   69,   71,
  129,   63,   61,   61,   71,    0,   68,   69,    0,    0,
    0,   68,   69,   71,   68,   69,    0,    0,   71,    0,
  100,   71,  348,  349,  351,  352,  353,  354,    0,    0,
    0,    0,    0,    0,  222,    2,    0,   68,   69,    0,
    3,    4,    0,    0,   71,    0,    5,    0,    0,    0,
    0,  168,  378,  168,  168,  168,  168,  168,    0,    0,
    0,  168,  168,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  198,    0,    0,    0,    0,    0,  169,
  204,  169,  169,  169,  169,  169,    0,    0,    0,  169,
  169,    0,  199,  201,  202,  172,  173,  174,  175,    0,
    0,    0,    0,  179,    0,  179,  179,  179,  179,  179,
    0,    0,    0,  179,  179,  170,    0,  170,  170,  170,
  170,  170,    0,    0,    0,  170,  170,  171,    0,  171,
  171,  171,  171,  171,    0,    0,    0,  171,  171,  172,
  248,  172,  172,  172,  172,  172,    0,    0,    0,  172,
  172,    0,    0,    0,  243,  245,  258,  246,    0,    0,
    0,  252,    0,    0,  255,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  275,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  308,
  310,    0,  311,  312,    0,    0,    0,  314,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  340,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                          1,
   40,   40,   45,   23,   26,    7,   41,   40,   59,   40,
   40,   13,   59,   59,   41,   59,   70,   41,   20,  256,
   22,   40,   24,   59,   26,   45,   46,  256,   41,   41,
   40,   89,  258,  163,  164,   40,  257,  263,  275,   61,
   16,   17,   41,   59,   41,    7,  275,   59,   58,   44,
    7,   79,   72,   58,   40,   57,   78,   79,   60,   61,
   82,   41,   24,   41,   73,   42,   41,   24,   41,   41,
   47,    1,   58,   40,  257,   40,   78,   79,  256,   59,
   82,   41,   41,   13,   45,   46,   41,   41,  116,  272,
  256,   41,   41,  223,  116,   25,  274,  117,   40,   59,
  120,  121,   41,   60,  270,   81,  269,  129,   41,  167,
   61,  169,   41,   40,  116,  256,   41,   41,  284,  256,
   59,  258,   41,   40,  178,  153,  148,  129,  130,   41,
   40,  153,  274,  274,   59,  137,   59,  146,  147,  256,
  282,   58,   40,   43,  101,   45,  148,  258,   41,  277,
  278,  153,   59,  270,   40,   44,  117,   59,   59,  274,
   41,   40,   40,  165,   59,   41,  327,  328,  329,  330,
   59,   40,  257,   41,  256,  257,  198,  282,   59,   41,
   41,   40,  204,  256,  257,  266,   41,  272,   41,  257,
   40,   40,  277,  278,  270,  197,  198,  358,  283,   40,
   40,  270,  204,  179,  180,   41,  257,   40,  270,   40,
  256,  213,  263,   59,  257,  258,   40,   59,  257,  239,
  240,  264,  258,   40,  263,  227,  248,  257,  275,  268,
  265,  275,  271,   40,  277,  278,  258,  277,  278,  261,
  279,  272,  281,  282,  277,  278,  248,  274,   40,  269,
  269,  256,  257,  277,  278,  267,  258,  256,  263,  261,
   40,  258,  257,  268,  277,  278,  271,  272,  267,  274,
  256,  257,  277,  278,  279,  280,  281,  263,  283,   40,
   40,  256,  268,  256,  256,  271,  272,  267,  274,  267,
  257,  277,  278,  279,  280,  281,  263,  283,   59,   40,
   40,  268,  257,  258,  271,  272,  256,  274,  267,  264,
  277,  278,  279,  267,  281,  257,  283,  256,  267,   40,
   40,  263,  277,  278,  346,   59,  268,  266,  267,  271,
  272,  256,  274,  256,  267,  277,  278,  279,  267,  281,
  257,  283,  267,  267,  346,   40,  263,  257,  267,   40,
  257,  268,  374,  263,  271,  267,  273,  258,  268,  257,
   59,  271,  279,  280,  281,  263,   40,  256,  257,  279,
  268,  269,  374,  271,  267,  256,  274,  256,  257,  257,
  256,  279,   22,  281,  263,  263,  267,   59,  256,  268,
  268,  267,  271,  271,  256,  273,  275,  275,  257,  267,
  279,  279,  281,  281,  263,  267,   59,  257,  257,  268,
  256,  270,  271,  263,  263,  274,   41,   59,  268,   40,
  279,  271,  281,  273,  257,  275,   59,   41,   59,  279,
  263,  281,  258,  257,   44,  268,   41,  270,  271,  263,
   40,  274,  258,  258,  268,   45,  279,  271,  281,   59,
  257,  275,  276,   40,   59,  279,  263,  281,   45,  258,
   41,  268,   40,   59,  271,  257,   59,   45,  275,   59,
   40,  263,  279,   40,  281,   45,  268,  257,   45,  271,
   59,  273,   41,  263,   59,   59,   45,  279,  268,  281,
   45,  271,   41,   59,  274,   45,  257,  257,   59,  279,
   41,  281,  263,  263,   45,   41,   59,  268,  268,   45,
  271,  271,   45,  273,   59,   59,  257,  257,  279,  279,
  281,  281,  263,  263,   41,  165,   59,  268,  268,   41,
  271,  271,  273,  273,   41,   45,  257,  257,  279,  279,
  281,  281,  263,  263,   41,   59,   41,  268,  268,   59,
  271,  271,  275,   59,  275,  275,   59,  256,  279,  279,
  281,  281,  257,  275,   59,   60,  257,   62,  263,  275,
  275,  275,  263,  268,   41,  275,  271,  268,  274,  257,
  271,  276,   59,  257,  279,   59,  281,  227,  279,  263,
  281,   59,   59,   60,  268,   62,   59,  271,   41,   42,
   43,  275,   45,  256,   47,  279,   60,   59,   62,   59,
   41,  257,   43,  275,   45,  275,   59,   60,  275,   62,
  275,  275,   41,  256,   43,  256,   45,  275,   59,   60,
  275,   62,  257,  258,   41,    0,   43,    0,   45,  264,
   59,   60,  269,   62,   59,   22,  256,  257,  355,   10,
   85,  256,   59,   60,   18,   62,  374,  257,  258,  261,
  256,  266,  267,  263,  264,   60,   13,   57,   -1,  182,
  257,  258,   -1,   20,   -1,   -1,  263,  264,   -1,  257,
  258,  256,  256,  162,  163,  164,  264,  257,  258,   -1,
  257,  258,   -1,   -1,  264,  256,   -1,  264,  257,  258,
   -1,  256,  257,  258,   -1,  264,  185,  257,  258,  264,
   57,  256,  256,   60,  264,   -1,  257,  258,   -1,   -1,
   -1,  257,  258,  264,  257,  258,   -1,   -1,  264,   -1,
  257,  264,  320,  321,  322,  323,  324,  325,   -1,   -1,
   -1,   -1,   -1,   -1,  223,  272,   -1,  257,  258,   -1,
  277,  278,   -1,   -1,  264,   -1,  283,   -1,   -1,   -1,
   -1,  256,  350,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  130,   -1,   -1,   -1,   -1,   -1,  256,
  137,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,  131,  132,  133,  259,  260,  261,  262,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
  197,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,   -1,   -1,  193,  194,  213,  196,   -1,   -1,
   -1,  200,   -1,   -1,  203,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  244,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  278,
  279,   -1,  281,  282,   -1,   -1,   -1,  286,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  309,
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
"control : REPEAT '(' asignacion_repeat ';' condicion_repeat ';' CTE_ULONG ')' bloque_repeat",
"control : error_control",
"error_control : REPEAT asignacion_repeat ';' condicion_repeat ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' ';' condicion_repeat ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat condicion_repeat ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion_repeat CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion_repeat ';' ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion_repeat ';' CTE_ULONG bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion_repeat ';' CTE_ULONG ')' error",
"asignacion_repeat : IDENTIFICADOR ASIGNACION CTE_ULONG",
"asignacion_repeat : error_asignacion_repeat",
"error_asignacion_repeat : ASIGNACION CTE_ULONG",
"error_asignacion_repeat : IDENTIFICADOR CTE_ULONG",
"error_asignacion_repeat : IDENTIFICADOR ASIGNACION error",
"condicion_repeat : expresion1",
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
"seleccion : IF condicion_if THEN bloque_then ENDIF",
"seleccion : IF condicion_if THEN bloque_then ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"condicion_if : '(' condicion ')'",
"condicion_if : error_condicion_if",
"error_condicion_if : '(' condicion error",
"bloque_then : bloque_if",
"bloque_if : sentencia_ejecucion",
"bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END ';'",
"bloque_if : error_bloque_if",
"error_bloque_if : BEGIN sentencia_ejecucion END ';'",
"error_bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END error",
"error_bloque_if : BEGIN sentencia_ejecucion END error",
"error_seleccion : condicion_if THEN bloque_then ENDIF",
"error_seleccion : IF THEN bloque_then ENDIF",
"error_seleccion : IF condicion_if bloque_then ENDIF",
"error_seleccion : IF condicion_if THEN ENDIF",
"error_seleccion : IF condicion_if THEN bloque_then error",
"error_seleccion : IF condicion_if THEN bloque_then ELSE ENDIF",
"error_seleccion : IF condicion_if THEN bloque_then ELSE bloque_if error",
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
"bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN pre_condicion ';' RETURN '(' condicion ')' ';' END",
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
"error_bloque_ejecucion_funcion : pre_condicion ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' condicion ';' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' condicion ')' END",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' condicion ')' ';' error",
"error_bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias END",
"pre_condicion : PRE ':' '(' condicion ')'",
"pre_condicion : error_pre_condicion",
"error_pre_condicion : ':' '(' condicion ')'",
"error_pre_condicion : PRE '(' condicion ')'",
"error_pre_condicion : PRE ':' condicion ')'",
"error_pre_condicion : PRE ':' '(' ')'",
"error_pre_condicion : PRE ':' '(' condicion error",
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

//#line 822 "Gramatica.y"

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
//#line 782 "Parser.java"
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
case 31:
//#line 92 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"'}");
    	        System.out.println("*************** "+ val_peek(1).sval);
    	        if (val_peek(1).sval.equals(val_peek(4).sval)){
    	            String nuevoLexema = val_peek(4).sval+ "@" + ambito;
    	            if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(val_peek(4).sval, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("TypeDef");
                        ds.setTipo(val_peek(2).sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                    }
    	        }
                else
                    System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {" + val_peek(5).sval + " y " + val_peek(1).sval +" deben tener el mismo nombre}");

    	        }
break;
case 33:
//#line 113 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
//#line 114 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
//#line 115 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 36:
//#line 121 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 37:
//#line 123 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 38:
//#line 126 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if((val_peek(6).sval != null) && (val_peek(4).sval != null)){
            Terceto t = new Terceto("+", val_peek(6).sval, val_peek(2).sval);
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            t = new Terceto("BI", null, null);
            adminTercetos.agregarTerceto(t);
            adminTercetos.desapilar(); /*para completar BF*/
            adminTercetos.desapilarRepeat();
        }
    }
break;
case 40:
//#line 141 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
//#line 142 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 42:
//#line 143 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 43:
//#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 44:
//#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 46:
//#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 47:
//#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 48:
//#line 151 "Gramatica.y"
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
                    else
                        System.out.println("Error semántico: Linea " + Lexico.linea + " la variable " + val_peek(2).sval +" no fue declarada");
                    }
break;
case 49:
//#line 168 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 50:
//#line 171 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 51:
//#line 172 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 52:
//#line 173 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 53:
//#line 177 "Gramatica.y"
{
                                Operando op = (Operando)val_peek(0).obj;
                                if(op != null){
                                    Terceto t = new Terceto("BF", op.getValor(), null);
                                    adminTercetos.agregarTerceto(t);
                                    adminTercetos.apilar(t.getNumero());
                                    yyval = new ParserVal(op.getValor());
                            }
                            else
                                yyval = new ParserVal(null);
                             }
break;
case 60:
//#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 61:
//#line 207 "Gramatica.y"
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
case 63:
//#line 232 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 64:
//#line 233 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 65:
//#line 234 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 66:
//#line 238 "Gramatica.y"
{
            if(val_peek(3).sval != null){
                adminTercetos.desapilar();
                }
            }
break;
case 67:
//#line 243 "Gramatica.y"
{
	        if(val_peek(5).sval != null){
                 adminTercetos.desapilar();
                 }
	 }
break;
case 69:
//#line 253 "Gramatica.y"
{

                System.out.println("ENTRO A CONDICION *****************************");
                if(val_peek(1).sval != null){
                    System.out.println("ENTRO AL IF *****************************");
                    Terceto t = new Terceto("BF", val_peek(1).sval, null);
                    adminTercetos.agregarTerceto(t);
                    adminTercetos.apilar(t.getNumero());
                    yyval = new ParserVal(val_peek(1).sval);
                }
                else
                    yyval = new ParserVal(null);
              }
break;
case 71:
//#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 72:
//#line 272 "Gramatica.y"
{
                adminTercetos.desapilar(); /*para completar BF*/
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.apilar(t.getNumero());

            }
break;
case 76:
//#line 288 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 77:
//#line 289 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 78:
//#line 290 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 79:
//#line 293 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 80:
//#line 294 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 81:
//#line 295 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 82:
//#line 296 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 83:
//#line 297 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 84:
//#line 298 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 85:
//#line 299 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 86:
//#line 303 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");
           Terceto t = new Terceto("Impresion", val_peek(1).sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 87:
//#line 308 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 88:
//#line 315 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
               System.out.println("****************");
               if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    System.out.println(Main.tablaSimbolos.getDatos(val_peek(3).sval).getTipo());
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(val_peek(3).sval).getTipo() == "ULONG"){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                    else
                        if(ambitoFuncion == null)
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+val_peek(3).sval+" esta fuera de alcance");
                        else
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " se invocó a la función "+val_peek(3).sval+" con un parámetro de otro tipo");
               }
            }
break;
case 89:
//#line 332 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(val_peek(3).sval).getTipo() == "DOUBLE"){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                    else
                        if(ambitoFuncion == null)
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+val_peek(3).sval+" esta fuera de alcance");
                        else
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " se invocó a la función "+val_peek(3).sval+" con un parámetro de otro tipo");
                }
            }
break;
case 90:
//#line 347 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(val_peek(3).sval).getTipo() == "ULONG"){
                        String ambitoParametro = Main.tablaSimbolos.verificarAmbito(val_peek(1).sval, ambito);
                        if (ambitoParametro != null){
                            Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                            adminTercetos.agregarTerceto(t);
                        }
                    }
                    else
                        if(ambitoFuncion == null)
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+val_peek(3).sval+" esta fuera de alcance");
                        else
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " se invocó a la función "+val_peek(3).sval+" con un parámetro de otro tipo");
                 }


            }
break;
case 92:
//#line 369 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 93:
//#line 370 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
//#line 371 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
//#line 372 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
//#line 382 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 99:
//#line 383 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 100:
//#line 384 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 101:
//#line 385 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 105:
//#line 395 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 106:
//#line 400 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 108:
//#line 408 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 109:
//#line 412 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(0).sval +"'" );
            /*TODO se esta considerando solo las funciones con pre. Ver forma de hacer un if chequeando que tipo de funcion es*/
            if(val_peek(1).sval != null && val_peek(0).sval != null ){ /*si se declaró bien y se cumplen los PRE (en caso de haberlos)*/
                if (val_peek(0).sval.equals("PRE")){
                   ambito = ambito.substring(0,ambito.lastIndexOf("@"));

                    Terceto t = new Terceto("RetornoFuncion", val_peek(0).sval, null);
                    adminTercetos.agregarTerceto(t);

                     t = new Terceto("FinFuncion", val_peek(1).sval, null);
                    adminTercetos.agregarTerceto(t);
                    adminTercetos.desapilar();     /*para el PRE*/
                    yyval = new ParserVal(val_peek(0).sval);
            }
                else {
                    ambito = ambito.substring(0,ambito.lastIndexOf("@"));
                    Terceto t = new Terceto("RetornoFuncion", val_peek(0).sval, null);
                    adminTercetos.agregarTerceto(t);
            }
           }
            else
                 yyval = new ParserVal(null);
         }
break;
case 111:
//#line 438 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 112:
//#line 441 "Gramatica.y"
{
                    parametroCopiaValor = val_peek(1).sval;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = val_peek(3).sval + "@" + ambito;
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema(val_peek(3).sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("NombreFuncion");
                            Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);

                            ambito = ambito + "@" + val_peek(3).sval;
                            Main.tablaSimbolos.reemplazarLexema(parametroCopiaValor, parametroCopiaValor +"@"+ ambito); /* Se agrega el ambito al parametro (nombre de la función)*/

                            Terceto t = new Terceto("ComienzaFuncion", nuevoLexema, null);
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.agregarFuncion(nuevoLexema);

                            yyval = new ParserVal(nuevoLexema);
                        }
                        else{
                            System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La funcion '" + val_peek(3).sval + "' ya fue declarada en este ámbito}");
                            yyval = new ParserVal(null);  /* se setea null para luego comprobar si se declaró o no*/
                        }
                    }
                    parametroCopiaValor = "";
                    }
break;
case 114:
//#line 470 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 115:
//#line 471 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 116:
//#line 472 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 117:
//#line 473 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 118:
//#line 474 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 119:
//#line 477 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);
                }
break;
case 121:
//#line 487 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 122:
//#line 491 "Gramatica.y"
{
           System.out.println("Bloque type: " + val_peek(0).sval + "****************");
            if (val_peek(3).sval != null && val_peek(0).sval != null){

                   System.out.println("Le paso al principal: " + val_peek(0).sval + "****************");
                    yyval = new ParserVal(val_peek(0).sval);
                 }

            else
                yyval = new ParserVal(null);
    }
break;
case 124:
//#line 505 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 125:
//#line 506 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 126:
//#line 507 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 127:
//#line 508 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 128:
//#line 509 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 129:
//#line 510 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 130:
//#line 513 "Gramatica.y"
{
    	        lista_variables = (ArrayList<String>)val_peek(0).obj;
    	        for(String lexema: lista_variables){
                    String nuevoLexema = lexema + "@" + ambito;
                    if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(lexema, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("VariableTypeDef");
                        ds.setTipo(val_peek(1).sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                    }
                    else{
                        System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable de función " + lexema + " en este ámbito}");
                        Main.tablaSimbolos.eliminarSimbolo(lexema);

                    }
                }
                yyval = new ParserVal (val_peek(1).sval);
}
break;
case 131:
//#line 537 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 132:
//#line 543 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 133:
//#line 549 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 134:
//#line 552 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 135:
//#line 556 "Gramatica.y"
{
                        if (val_peek(6).sval != null && val_peek(3).sval != null){
                            yyval = new ParserVal ("SINPRE");
                        }
                        else
                            yyval = new ParserVal (null);
             }
break;
case 136:
//#line 564 "Gramatica.y"
{
			            if (val_peek(8).sval != null && val_peek(3).sval != null){
			                yyval = new ParserVal ("PRE");
			            }
			            else
			                yyval = new ParserVal (null);
			 }
break;
case 137:
//#line 571 "Gramatica.y"
{
                        if (val_peek(7).sval != null && val_peek(3).sval != null){
                            yyval = new ParserVal ("PRE");
                        }
                        else
                             yyval = new ParserVal (null);
             }
break;
case 138:
//#line 579 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 139:
//#line 582 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 140:
//#line 583 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 141:
//#line 584 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 142:
//#line 585 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 143:
//#line 586 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 144:
//#line 587 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 145:
//#line 588 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 146:
//#line 589 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 147:
//#line 590 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 148:
//#line 592 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 149:
//#line 593 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 150:
//#line 594 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 151:
//#line 595 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 152:
//#line 596 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 153:
//#line 597 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 154:
//#line 598 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 155:
//#line 599 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 156:
//#line 600 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 157:
//#line 604 "Gramatica.y"
{
                      if(val_peek(1).sval != null){
                         Terceto t = new Terceto("BF", val_peek(1).sval, null);
                         adminTercetos.agregarTerceto(t);
                         adminTercetos.apilar(t.getNumero());
                         yyval = new ParserVal(val_peek(1).sval);
                     }
                     else
                         yyval = new ParserVal(null);
                   }
break;
case 159:
//#line 617 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 160:
//#line 618 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 161:
//#line 619 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 162:
//#line 620 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 163:
//#line 621 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 164:
//#line 624 "Gramatica.y"
{ Operando op = (Operando)val_peek(0).obj;
                            if(op != null){
                                yyval = new ParserVal(op.getValor());
                            }
                            else
                                 yyval = new ParserVal(null);
                        }
break;
case 165:
//#line 631 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");

	                    Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("OR", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal("["+t.getNumero()+"]");
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
//#line 653 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 167:
//#line 654 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");
	                    Operando op1 = (Operando)val_peek(2).obj;
                        Operando op2 = (Operando)val_peek(0).obj;
                        if(op1 != null && op2 !=null){
                            if (op1.getTipo().equals(op2.getTipo())){
                                Terceto t = new Terceto("AND", op1.getValor(), op2.getValor());
                                t.setTipo(op1.getTipo());
                                adminTercetos.agregarTerceto(t);
                                yyval = new ParserVal("["+t.getNumero()+"]");
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
//#line 675 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 169:
//#line 676 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");

		                            Operando op1 = (Operando)val_peek(2).obj;
                                    Operando op2 = (Operando)val_peek(0).obj;
                                    if(op1 != null && op2 !=null){
                                        if (op1.getTipo().equals(op2.getTipo())){
                                            Terceto t = new Terceto(val_peek(1).sval, op1.getValor(), op2.getValor());
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
case 170:
//#line 699 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 171:
//#line 702 "Gramatica.y"
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
case 172:
//#line 722 "Gramatica.y"
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
case 173:
//#line 744 "Gramatica.y"
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
case 174:
//#line 764 "Gramatica.y"
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
case 175:
//#line 784 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 176:
//#line 788 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) val_peek(0).obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 177:
//#line 793 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 178:
//#line 796 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 179:
//#line 799 "Gramatica.y"
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
case 181:
//#line 812 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 182:
//#line 813 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 183:
//#line 814 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 184:
//#line 815 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 185:
//#line 816 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 186:
//#line 817 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 1941 "Parser.java"
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
