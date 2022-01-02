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
import java.util.Enumeration;
//#line 23 "Parser.java"




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
    0,    0,    0,    3,    3,    3,    1,    1,    2,    2,
    5,    5,    6,    6,    6,    6,    8,    8,    8,    8,
    8,    8,   14,   14,   14,   14,    7,    7,    7,   16,
    4,    4,    4,    4,   21,   21,   17,   17,    9,    9,
   25,   25,   25,   25,   25,   25,   25,   25,   22,   22,
   26,   26,   26,   23,   24,   28,   28,   29,   29,   29,
   30,   13,   13,   32,   32,   32,   32,   10,   35,   10,
   10,   33,   33,   38,   34,   34,   34,   39,   39,   39,
   36,   36,   36,   36,   36,   36,   36,   11,   11,   12,
   12,   12,   12,   40,   40,   40,   40,   15,   15,   41,
   41,   44,   43,   43,   43,   42,   45,   45,   18,   18,
   18,   46,   19,   19,   49,   47,   47,   51,   51,   51,
   51,   51,   51,   50,   50,   52,   20,   48,   48,   48,
   54,   53,   53,   53,   53,   53,   56,   56,   56,   56,
   56,   56,   56,   56,   56,   56,   56,   56,   56,   56,
   56,   56,   56,   55,   55,   57,   57,   57,   57,   57,
   37,   58,   58,   59,   59,   27,   27,   31,   31,   31,
   61,   61,   61,   62,   62,   62,   62,   62,   60,   60,
   60,   60,   60,   60,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    3,    1,    2,    3,    1,
    1,    2,    2,    3,    4,    4,    2,    2,    2,    2,
    1,    1,    2,    2,    2,    2,    1,    2,    1,    2,
    3,    2,    6,    1,    3,    2,    1,    1,    9,    1,
    8,    8,    8,    8,    8,    8,    8,    9,    3,    1,
    2,    2,    3,    1,    3,    1,    2,    1,    2,    1,
    2,    4,    1,    3,    3,    3,    4,    5,    0,    8,
    1,    3,    1,    3,    1,    5,    1,    4,    5,    4,
    4,    4,    4,    4,    5,    7,    8,    4,    3,    4,
    4,    4,    1,    3,    4,    4,    4,    3,    1,    2,
    1,    2,    2,    3,    4,    3,    1,    2,    3,    1,
    1,    2,    2,    1,    2,    6,    1,    5,    5,    5,
    5,    5,    6,    2,    1,    2,    7,    2,    1,    1,
    2,    7,    8,   10,    9,    1,    7,    7,    7,    7,
    7,    7,    3,    8,    9,    9,    9,    9,    9,    9,
    9,   10,    5,    5,    1,    4,    4,    4,    4,    5,
    1,    1,    3,    1,    3,    3,    1,    1,    3,    3,
    3,    3,    1,    2,    1,    1,    1,    1,    1,    1,
    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   37,   38,    0,    0,    0,    3,    7,    0,
    0,   34,    0,  114,  117,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   10,   11,   27,    0,
    0,    0,    0,   21,   22,    0,   29,   40,   63,    0,
   71,   73,   93,    0,   99,  101,    0,    0,    4,    8,
    0,    0,    0,  111,   36,   32,  115,    0,    0,    0,
    0,    0,  113,  129,  130,    0,  136,  155,    0,  176,
    0,  175,    0,    0,  178,    0,    0,  173,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   50,  102,
  100,    0,  164,    0,    0,    0,    0,    6,    1,    0,
   13,   12,   23,   17,   24,   18,   25,   19,   26,   20,
   30,   28,    0,    0,    0,  103,    0,    0,    0,    0,
    0,   35,  112,   31,    0,    0,    0,    0,    0,    0,
    0,  131,  128,    0,    0,   66,    0,    0,    0,    0,
   94,  174,   65,    0,    0,    0,    0,   64,    0,   75,
    0,   77,    0,    0,    0,   89,    0,   14,    9,    0,
   52,    0,   51,    0,    0,    0,    0,  182,  183,  181,
  184,  179,  180,    0,   74,   72,    0,    0,    0,  107,
    0,  104,   98,    0,    0,  125,    0,    0,    0,    0,
    0,  109,    0,    0,  143,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   67,   62,   97,   92,   95,   90,
   96,   91,    0,    0,  171,  172,    0,   82,   84,    0,
   83,   88,   15,   16,   53,   49,    0,   54,    0,    0,
    0,  105,    0,    0,  165,   81,  106,  108,  126,  124,
  118,    0,    0,  119,  122,    0,  121,  120,    0,    0,
    0,    0,    0,    0,    0,  157,  159,    0,  158,  156,
    0,    0,    0,    0,   85,   68,    0,    0,    0,    0,
    0,    0,    0,    0,   33,  123,  116,    0,    0,    0,
    0,    0,    0,    0,  153,    0,    0,  160,  154,    0,
    0,   80,   78,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   79,   76,   86,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  132,
  140,  141,  142,    0,  139,  138,    0,    0,    0,    0,
    0,    0,  137,    0,   87,   70,    0,   42,   44,   45,
    0,   47,   46,   43,   41,    0,  144,  133,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   58,    0,   56,
   60,   48,   39,    0,  135,  149,  150,  151,    0,  148,
  147,  146,  145,   61,   59,   55,   57,  110,    0,  152,
  134,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   53,   11,  243,
   12,   88,  227,  348,   38,   89,   93,  369,  370,  371,
   94,   39,   40,  151,  268,   41,   95,   42,  152,   43,
   44,  116,   45,   46,  181,   54,   13,   63,   14,  185,
   15,  186,   64,   65,   66,   67,   68,   96,   97,  174,
   77,   78,
};
final static short yysindex[] = {                       -77,
   76, -224,    0,    0, -214,    0,   76,    0,    0, -180,
  105,    0,  -37,    0,    0,   -5,   -1,  -39,   26,   99,
  -36,  270,   -1,   30,  187,  277,    0,    0,    0,  112,
  118,  127,  132,    0,    0,  134,    0,    0,    0, -193,
    0,    0,    0, -172,    0,    0,   45,   46,    0,    0,
   89,  -24,  129,    0,    0,    0,    0,  116,    9,   92,
   11,  224,    0,    0,    0,   81,    0,    0,  108,    0,
  505,    0,  308,   -1,    0,   66,   53,    0,   69,  305,
  144,  -33,   99,   59, -114, -108,  -48,   93,    0,    0,
    0, -131,    0,  499,    6, -110, -106,    0,    0,  187,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  305,  435, -237,    0, -205, -205, -205,  -30,
 -205,    0,    0,    0,  -99,  121,  163,  306,   -1,   68,
   -1,    0,    0,  122,  418,    0,   79,   15,   40,   43,
    0,    0,    0,   -1,   -1,   -1,   -1,    0,  418,    0,
 -105,    0,  182, -102,  128,    0,  326,    0,    0,  471,
    0, -236,    0,   -1,  508,   -1, -104,    0,    0,    0,
    0,    0,    0,   -1,    0,    0,   -1,   -1,  -94,    0,
  172,    0,    0, -204,  138,    0,  -91,  149,  -28,  157,
  167,    0,   -1,  279,    0,   -1,  335,  354,  170,   20,
  214,  225,   -1,  371,    0,    0,    0,    0,    0,    0,
    0,    0,   53,   53,    0,    0,  388,    0,    0,  135,
    0,    0,    0,    0,    0,    0,  145,    0,  584,  154,
  164,    0,   72, -106,    0,    0,    0,    0,    0,    0,
    0,  283,  292,    0,    0,   56,    0,    0,  319,  478,
  322,   85,  332,  205,  341,    0,    0,   96,    0,    0,
  367,  370,  137,  397,    0,    0,  133,  140,  161,  169,
  -44,  174,  175, -205,    0,    0,    0,  362,  363,    5,
  382,  387,   -1,  324,    0,   -1,   -1,    0,    0,  389,
   -1,    0,    0,  146,  220,  305,  408,  416,  419,  -34,
  425,  426,  428,  155,  180,  196,  -50,  197,  199,  438,
  487,  441,  102,  444,  218,  448,    0,    0,    0,  240,
  230,  228,  228,  228,  -23,  228,  228,  228,  447,    0,
    0,    0,    0, -227,    0,    0,  449,  451,   27,  452,
  455,  456,    0,  459,    0,    0,  414,    0,    0,    0,
 -181,    0,    0,    0,    0,  250,    0,    0,  238,  246,
  249,  -14,  254,  255,  256,  260,  148,    0,  241,    0,
    0,    0,    0,  268,    0,    0,    0,    0, -225,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -21,    0,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  539,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  143,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  666,    0,
    0,    0,    0,    0,    0,    0,  550,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   39,    0,  -27,   -2,    0,    0,  546,
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
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  578,  678,    0,    0,    0,    0,    0,  263,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   62,   47,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  285,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  285,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  496,    0,
    0,
};
final static short yygindex[] = {                         0,
   58,   55,    0,  715,  692,    0,  -26,   16,    0,    0,
    0,  -11,    0,    0,  535,    0,  667,  186,    0,    0,
    0,  483, -138,  454,    0,    0,  -19,    0,  202,    0,
   25,    0,  557,  -79,    0,    0,  600,    0,    0,    0,
    0,  -85,    0,    0,    0,    0,    0,    0,    0,  -95,
    0,    0,  517,    0,  522,    0,    0,    0,  413,    0,
  -40,  -57,
};
final static int YYTABLESIZE=945;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        102,
   23,  154,   23,   87,   75,   75,  326,  156,  334,  189,
  164,   75,  245,  161,  300,  121,  142,  351,  182,  225,
   60,  226,  125,  188,  190,  191,  230,  231,  357,  183,
  390,  161,   47,  179,   73,  102,  114,   91,  162,   74,
   76,   79,   48,   74,  379,  307,  176,  358,  129,  391,
   23,  239,  240,  150,  150,  208,  162,  102,   24,   75,
  257,   49,   75,  306,   74,   82,  130,  362,   60,   23,
   61,    3,    4,  220,  372,  113,   51,   83,   99,  167,
  210,  232,  100,  212,  117,  361,  150,  163,  215,  216,
  271,   52,  347,  246,  146,  137,  277,  167,   23,  147,
  102,  114,  166,  213,  214,  163,  118,  200,  144,  115,
  145,  144,   74,  145,  144,   23,  145,   75,   75,   75,
  166,  144,  217,  145,  143,  282,  150,  148,  119,  180,
  102,  131,   75,   75,   75,   75,  289,  206,   23,  135,
  267,  160,  341,  161,  228,  228,  228,   73,  162,  163,
  167,  166,   75,   75,   75,   23,  177,  192,  235,  178,
  193,  203,   75,   56,  218,   75,   75,  221,  222,  114,
  104,  102,  125,   60,   23,  236,  106,  102,  241,    1,
  242,   75,   75,   23,   75,  108,  110,  124,   75,  244,
  110,   75,  112,  150,    2,  293,  238,  247,  233,    3,
    4,  110,  196,  269,  318,    5,  385,  248,   85,  228,
  256,   23,  272,  299,   86,  320,  321,   75,   57,   16,
   85,   23,  273,  325,  333,   17,   86,  102,  161,   80,
   18,  155,  120,   19,    2,  123,   58,  102,   75,    3,
    4,   21,   59,   22,  286,    5,    3,    4,    3,    4,
  347,   69,   70,  162,  259,   69,   70,   71,   72,   23,
  378,  175,   72,   23,  162,  260,  132,   16,  150,  150,
  207,   75,   75,   17,   75,   75,   69,   70,   18,   75,
   23,   19,    2,   72,   58,   98,   16,    3,    4,   21,
   59,   22,   17,    5,  167,  209,  167,   18,  211,   75,
   19,    2,  163,   20,  167,  167,    3,    4,   21,   23,
   22,  276,    5,  163,  158,   16,   23,  166,  250,  166,
  368,   17,  274,   74,   69,   70,   18,  166,  166,   19,
    2,   72,   16,  159,  205,    3,    4,   21,   17,   22,
  175,    5,  368,   18,   23,   23,   19,    2,  141,   20,
  275,  288,    3,    4,   21,   16,   22,  175,    5,  278,
   55,   17,  281,  311,  197,   23,   18,  103,   74,   19,
    2,  283,   16,  105,   23,    3,    4,   21,   17,   22,
  287,    5,  107,   18,  122,  123,   19,  109,  126,  111,
  265,   16,  292,   23,   21,   59,   22,   17,  110,  110,
   16,  317,   18,  384,  266,   19,   17,  290,  149,  291,
   23,   18,  153,   21,   19,   22,  295,  149,  297,   16,
  304,  305,   21,  296,   22,   17,  298,   23,   16,  330,
   18,  301,  302,   19,   17,  194,   23,  195,   16,   18,
  308,   21,   19,   22,   17,  309,  237,  315,  322,   18,
   21,  219,   19,   23,  331,  149,  323,   23,    2,  324,
   21,   16,   22,    3,    4,  327,  328,   17,  329,    5,
  332,  335,   18,  336,   23,   19,   16,  284,  337,  285,
   16,  340,   17,   21,  342,   22,   17,   18,  344,  319,
   19,   18,  343,  149,   19,  345,  134,   16,   21,  346,
   22,  347,   21,   17,   22,  356,  374,  359,   18,  360,
  363,   19,  375,  364,  365,  386,  367,  366,  279,   21,
  376,   22,   74,  377,  388,   90,   16,  338,  380,  381,
  382,   74,   17,   16,  383,   69,   70,   18,    2,   17,
   19,  144,   72,  145,   18,    5,   69,   19,   21,   74,
   22,  101,   74,   72,  127,   21,   92,   22,  172,  389,
  173,   16,   16,  136,  138,  139,  229,   17,   17,  165,
  387,  140,   18,   18,   81,   19,   19,  133,  149,  128,
   69,   70,   16,   21,   21,   22,   22,   72,   17,  234,
  168,   16,  168,   18,  168,    0,   19,   17,    0,    0,
  223,    0,   18,    0,   21,   19,   22,  253,  168,  168,
   16,  168,    0,   21,    0,   22,   17,    0,  169,    0,
  169,   18,  169,    0,   19,    0,  255,   16,   74,    0,
    0,    0,   21,   17,   22,    0,  169,  169,   18,  169,
    0,   19,  270,  262,   16,    0,    0,    0,    0,   21,
   17,   22,    0,   16,    0,   18,    0,    0,   19,   17,
    0,    0,  263,    0,   18,    0,   21,   19,   22,    0,
   16,  294,    0,    0,   16,   21,   17,   22,    0,    0,
   17,   18,    0,    0,   19,   18,    0,    0,   19,  367,
    0,   16,   21,    0,   22,    0,   21,   17,   22,    0,
    0,    0,   18,    0,   62,   19,  177,  177,  177,    0,
  177,   84,  177,   21,    0,    0,    0,    0,  170,    0,
  170,   50,  170,    0,  177,  177,    0,  177,  199,  201,
  202,    0,    0,    0,   69,   70,  170,  170,   50,  170,
    0,   72,    2,   69,   70,  224,    0,    3,    4,  127,
   72,    0,   62,    5,    0,    0,    0,  168,  169,  170,
  171,   69,   70,    0,   69,   70,    0,    0,   72,    0,
    0,   72,    0,    0,  157,   50,  349,  350,  352,  353,
  354,  355,    0,  184,  187,  184,  184,  184,    0,    0,
    0,    0,  249,  251,    0,  252,    0,   50,    0,  258,
    0,    0,  261,    0,  373,  168,    0,  168,  168,  168,
  168,  168,    0,    0,   50,  168,  168,    0,    0,  198,
    0,    0,    0,    0,    0,    0,  204,    0,    0,    0,
    0,    0,    0,  169,    0,  169,  169,  169,  169,  169,
   69,   70,    0,  169,  169,    0,    0,   72,    0,  280,
    0,    0,    0,    0,    0,  184,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   50,    0,    0,    0,    0,    0,
    0,    0,  310,  312,    0,  313,  314,    0,  254,    0,
  316,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  264,    0,
  339,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  177,    0,  177,  177,  177,  177,  177,    0,    0,
    0,  177,  177,  170,    0,  170,  170,  170,  170,  170,
  303,    0,    0,  170,  170,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         26,
   40,   81,   40,   40,   16,   17,   41,   41,   59,   40,
   59,   23,   41,   41,   59,   40,   74,   41,  256,  256,
   58,  258,   44,  119,  120,  121,  165,  166,  256,  115,
  256,   59,  257,  113,   40,   62,  274,   22,   41,   45,
   16,   17,  257,   45,   59,   41,   41,  275,   40,  275,
   40,  256,  257,   80,   81,   41,   59,   84,    1,   71,
   41,    7,   74,   59,   45,   40,   58,   41,   58,   40,
   13,  277,  278,  153,  256,  269,  257,   20,   24,   41,
   41,  167,   25,   41,   40,   59,  113,   41,  146,  147,
  229,  272,  274,  189,   42,   71,   41,   59,   40,   47,
  127,  274,   41,  144,  145,   59,   61,   40,   43,  282,
   45,   43,   45,   45,   43,   40,   45,  129,  130,  131,
   59,   43,  149,   45,   59,   41,  153,   59,   40,  114,
  157,   40,  144,  145,  146,  147,   41,   59,   40,   59,
  220,   84,   41,  258,  164,  165,  166,   40,  263,  258,
  282,   59,  164,  165,  166,   40,  267,  257,  178,  266,
   40,   40,  174,   59,  270,  177,  178,  270,   41,  274,
   59,  198,   44,   58,   40,  270,   59,  204,   41,  257,
  272,  193,  194,   40,  196,   59,   44,   59,  200,   41,
   59,  203,   59,  220,  272,   59,  181,   41,  174,  277,
  278,   59,   40,   59,   59,  283,   59,   41,  257,  229,
   41,   40,   59,  258,  263,  295,  296,  229,  256,  257,
  257,   40,   59,  258,  275,  263,  263,  254,  256,  269,
  268,  265,  257,  271,  272,  257,  274,  264,  250,  277,
  278,  279,  280,  281,   40,  283,  277,  278,  277,  278,
  274,  257,  258,  256,   41,  257,  258,  263,  264,   40,
  275,  256,  264,   40,  267,   41,  256,  257,  295,  296,
  256,  283,  284,  263,  286,  287,  257,  258,  268,  291,
   40,  271,  272,  264,  274,  256,  257,  277,  278,  279,
  280,  281,  263,  283,  256,  256,  258,  268,  256,  311,
  271,  272,  256,  274,  266,  267,  277,  278,  279,   40,
  281,  256,  283,  267,  256,  257,   40,  256,   40,  258,
  347,  263,   40,   45,  257,  258,  268,  266,  267,  271,
  272,  264,  257,  275,  256,  277,  278,  279,  263,  281,
  256,  283,  369,  268,   40,   40,  271,  272,   41,  274,
   59,  256,  277,  278,  279,  257,  281,  256,  283,   41,
  256,  263,   41,   40,   59,   40,  268,  256,   45,  271,
  272,   40,  257,  256,   40,  277,  278,  279,  263,  281,
   40,  283,  256,  268,  256,  257,  271,  256,  273,  256,
  256,  257,  256,   40,  279,  280,  281,  263,  256,  257,
  257,  256,  268,  256,  270,  271,  263,   41,  274,   40,
   40,  268,  269,  279,  271,  281,  284,  274,  258,  257,
   59,   59,  279,  284,  281,  263,  258,   40,  257,  275,
  268,  258,  258,  271,  263,  273,   40,  275,  257,  268,
   59,  279,  271,  281,  263,   59,  275,   59,   41,  268,
  279,  270,  271,   40,  275,  274,   41,   40,  272,   41,
  279,  257,  281,  277,  278,   41,   41,  263,   41,  283,
  275,  275,  268,  275,   40,  271,  257,  273,   41,  275,
  257,   41,  263,  279,   41,  281,  263,  268,   41,  270,
  271,  268,  275,  274,  271,  256,  273,  257,  279,  270,
  281,  274,  279,  263,  281,   59,  257,   59,  268,   59,
   59,  271,  275,   59,   59,  275,  276,   59,   41,  279,
  275,  281,   45,  275,  257,  256,  257,   41,  275,  275,
  275,   45,  263,  257,  275,  257,  258,  268,    0,  263,
  271,   43,  264,   45,  268,    0,  284,  271,  279,   45,
  281,  275,   45,  269,   59,  279,   22,  281,   60,  374,
   62,  257,  257,   59,  257,  258,   59,  263,  263,   87,
  369,  264,  268,  268,   18,  271,  271,   61,  274,   58,
  257,  258,  257,  279,  279,  281,  281,  264,  263,  177,
   41,  257,   43,  268,   45,   -1,  271,  263,   -1,   -1,
  275,   -1,  268,   -1,  279,  271,  281,  273,   59,   60,
  257,   62,   -1,  279,   -1,  281,  263,   -1,   41,   -1,
   43,  268,   45,   -1,  271,   -1,  273,  257,   45,   -1,
   -1,   -1,  279,  263,  281,   -1,   59,   60,  268,   62,
   -1,  271,   59,  273,  257,   -1,   -1,   -1,   -1,  279,
  263,  281,   -1,  257,   -1,  268,   -1,   -1,  271,  263,
   -1,   -1,  275,   -1,  268,   -1,  279,  271,  281,   -1,
  257,  275,   -1,   -1,  257,  279,  263,  281,   -1,   -1,
  263,  268,   -1,   -1,  271,  268,   -1,   -1,  271,  276,
   -1,  257,  279,   -1,  281,   -1,  279,  263,  281,   -1,
   -1,   -1,  268,   -1,   13,  271,   41,   42,   43,   -1,
   45,   20,   47,  279,   -1,   -1,   -1,   -1,   41,   -1,
   43,    7,   45,   -1,   59,   60,   -1,   62,  129,  130,
  131,   -1,   -1,   -1,  257,  258,   59,   60,   24,   62,
   -1,  264,  272,  257,  258,  275,   -1,  277,  278,   58,
  264,   -1,   61,  283,   -1,   -1,   -1,  259,  260,  261,
  262,  257,  258,   -1,  257,  258,   -1,   -1,  264,   -1,
   -1,  264,   -1,   -1,   83,   61,  323,  324,  325,  326,
  327,  328,   -1,  117,  118,  119,  120,  121,   -1,   -1,
   -1,   -1,  193,  194,   -1,  196,   -1,   83,   -1,  200,
   -1,   -1,  203,   -1,  351,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,  100,  266,  267,   -1,   -1,  128,
   -1,   -1,   -1,   -1,   -1,   -1,  135,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
  257,  258,   -1,  266,  267,   -1,   -1,  264,   -1,  250,
   -1,   -1,   -1,   -1,   -1,  189,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  160,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  283,  284,   -1,  286,  287,   -1,  197,   -1,
  291,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  217,   -1,
  311,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,  256,   -1,  258,  259,  260,  261,  262,
  274,   -1,   -1,  266,  267,
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
"error_programa : IDENTIFICADOR bloque_declarativo error",
"bloque_declarativo : declaracion",
"bloque_declarativo : bloque_declarativo declaracion",
"bloque_ejecutable : BEGIN bloque_sentencias END",
"bloque_ejecutable : error_bloque_ejecutable",
"bloque_sentencias : sentencia_ejecucion",
"bloque_sentencias : bloque_sentencias sentencia_ejecucion",
"error_bloque_ejecutable : bloque_sentencias END",
"error_bloque_ejecutable : BEGIN bloque_sentencias error",
"error_bloque_ejecutable : BEGIN bloque_declarativo bloque_sentencias END",
"error_bloque_ejecutable : BEGIN bloque_sentencias bloque_declarativo END",
"sentencia_ejecutable : control ';'",
"sentencia_ejecutable : seleccion ';'",
"sentencia_ejecutable : impresion ';'",
"sentencia_ejecutable : invocacion ';'",
"sentencia_ejecutable : asignacion",
"sentencia_ejecutable : error_ejecutable",
"error_ejecutable : control error",
"error_ejecutable : seleccion error",
"error_ejecutable : impresion error",
"error_ejecutable : invocacion error",
"sentencia_ejecucion : sentencia_ejecutable",
"sentencia_ejecucion : try_catch ';'",
"sentencia_ejecucion : error_sentencia_ejecucion",
"error_sentencia_ejecucion : try_catch error",
"declaracion : tipo lista_de_variables ';'",
"declaracion : funcion ';'",
"declaracion : TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"error_declaracion : funcion error",
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
"condicion_repeat : condicion_booleana",
"bloque_repeat : BEGIN bloque_control END",
"bloque_control : sentencia_control",
"bloque_control : bloque_control sentencia_control",
"sentencia_control : sentencia_ejecucion",
"sentencia_control : BREAK ';'",
"sentencia_control : error_sentencia_control",
"error_sentencia_control : BREAK error",
"asignacion : IDENTIFICADOR ASIGNACION expresion ';'",
"asignacion : error_asignacion",
"error_asignacion : ASIGNACION expresion ';'",
"error_asignacion : IDENTIFICADOR expresion ';'",
"error_asignacion : IDENTIFICADOR ASIGNACION ';'",
"error_asignacion : IDENTIFICADOR ASIGNACION expresion error",
"seleccion : IF condicion_if THEN bloque_if ENDIF",
"$$1 :",
"seleccion : IF condicion_if THEN bloque_if $$1 ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"condicion_if : '(' condicion ')'",
"condicion_if : error_condicion_if",
"error_condicion_if : '(' condicion error",
"bloque_if : sentencia_ejecucion",
"bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END ';'",
"bloque_if : error_bloque_if",
"error_bloque_if : BEGIN sentencia_ejecucion END ';'",
"error_bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END error",
"error_bloque_if : BEGIN sentencia_ejecucion END error",
"error_seleccion : condicion_if THEN bloque_if ENDIF",
"error_seleccion : IF THEN bloque_if ENDIF",
"error_seleccion : IF condicion_if bloque_if ENDIF",
"error_seleccion : IF condicion_if THEN ENDIF",
"error_seleccion : IF condicion_if THEN bloque_if error",
"error_seleccion : IF condicion_if THEN bloque_if bloque_if ELSE ENDIF",
"error_seleccion : IF condicion_if THEN bloque_if bloque_if ELSE bloque_if error",
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
"try_catch : parte_try CATCH bloque_catch",
"try_catch : error_try_catch",
"parte_try : TRY sentencia_ejecutable",
"parte_try : error_parte_try",
"error_parte_try : TRY error",
"error_try_catch : parte_try bloque_catch",
"error_try_catch : parte_try CATCH error",
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
"declaracion_funcion : tipo FUNC IDENTIFICADOR '(' parametro ')'",
"declaracion_funcion : error_declaracion_funcion",
"error_declaracion_funcion : FUNC IDENTIFICADOR '(' parametro ')'",
"error_declaracion_funcion : tipo IDENTIFICADOR '(' parametro ')'",
"error_declaracion_funcion : tipo FUNC '(' parametro ')'",
"error_declaracion_funcion : tipo FUNC IDENTIFICADOR parametro ')'",
"error_declaracion_funcion : tipo FUNC IDENTIFICADOR '(' ')'",
"error_declaracion_funcion : tipo FUNC IDENTIFICADOR '(' parametro error",
"parametro : tipo IDENTIFICADOR",
"parametro : error_parametro",
"error_parametro : tipo error",
"funcion_type : FUNC '(' tipo ')' ';' IDENTIFICADOR lista_de_variables",
"bloque_funcion : bloque_declarativo bloque_ejecucion_funcion",
"bloque_funcion : bloque_ejecucion_funcion",
"bloque_funcion : error_bloque_funcion",
"error_bloque_funcion : bloque_declarativo error",
"bloque_ejecucion_funcion : BEGIN RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN pre_condicion ';' RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : error_bloque_ejecucion_funcion",
"error_bloque_ejecucion_funcion : bloque_sentencias RETURN '(' condicion ')' ';' END",
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
"condicion : condicion_or",
"condicion_or : condicion_and",
"condicion_or : condicion_or OR condicion_and",
"condicion_and : condicion_booleana",
"condicion_and : condicion_and AND condicion_booleana",
"condicion_booleana : expresion comparador expresion",
"condicion_booleana : expresion",
"expresion : termino",
"expresion : expresion '+' termino",
"expresion : expresion '-' termino",
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

//#line 1019 "Gramatica.y"

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
//#line 773 "Parser.java"
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
//#line 15 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +val_peek(2).sval + "'}");}
break;
case 2:
//#line 16 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +val_peek(1).sval + "'}");}
break;
case 4:
//#line 20 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 5:
//#line 21 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Mal posicionamiento de sentencias declarativas");}
break;
case 6:
//#line 22 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de ejecución en el programa");}
break;
case 13:
//#line 41 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 14:
//#line 42 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 15:
//#line 43 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se pueden incluir declaraciones en el bloque ejecutable}");}
break;
case 16:
//#line 44 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se pueden incluir declaraciones en el bloque ejecutable}");}
break;
case 23:
//#line 57 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 58 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 25:
//#line 59 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 26:
//#line 61 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 30:
//#line 69 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 31:
//#line 74 "Gramatica.y"
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
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable " + lexema + " en este ámbito}");
                        Main.tablaSimbolos.eliminarSimbolo(lexema);
                    }
    	        }
    	        lista_variables.clear();
    	        }
break;
case 33:
//#line 96 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"'}");
    	        if (val_peek(1).sval.equals(val_peek(4).sval)){
    	            String nuevoLexema = val_peek(4).sval+ "@" + ambito;
    	            if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(val_peek(4).sval, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("TypeDef");
                        ds.setTipo(val_peek(2).sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                        Enumeration iterador = Main.tablaSimbolos.getKeys();
                        while (iterador.hasMoreElements()) {
                            String lexema = (String) iterador.nextElement();
                            ds = Main.tablaSimbolos.getDatos(lexema);
                            if (ds.getTipo() != null)
                                if (ds.getTipo().equals("SinAsignar"))
                                    ds.setTipo(val_peek(2).sval);
                        }
                    }
                    else
                         Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] { La funcion "+ val_peek(4).sval +" ya esta declarada}");
    	        }
                else
                    Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {" + val_peek(4).sval + " y " + val_peek(1).sval +" deben tener el mismo nombre}");

    	        }
break;
case 35:
//#line 126 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 36:
//#line 127 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 37:
//#line 133 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 38:
//#line 135 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 39:
//#line 138 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if((val_peek(6).sval != null) && (val_peek(4).sval != null)){
            Terceto t = new Terceto("+", val_peek(6).sval, val_peek(2).sval);
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            int cantidad = adminTercetos.cantidadTercetos() -1;
            t =  new Terceto(":=", val_peek(6).sval, "["+ cantidad + "]");
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            t = new Terceto("BI", null, null);
            adminTercetos.agregarTerceto(t);
             if (val_peek(0).sval != null)
                   adminTercetos.desapilar();
            adminTercetos.desapilar(); /*para completar BF*/
            adminTercetos.desapilarRepeat();
            t = new Terceto("Label"+adminTercetos.cantidadTercetos(),null,null);
            adminTercetos.agregarTerceto(t);

        
        }
        /*TODO ELSE*/
    }
break;
case 41:
//#line 164 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 42:
//#line 165 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 43:
//#line 166 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 44:
//#line 167 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 45:
//#line 168 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 46:
//#line 169 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 47:
//#line 170 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 48:
//#line 171 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 49:
//#line 174 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion del repeat: "+ val_peek(2).sval + " := "+ val_peek(0).sval + "}");
                    String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(2).sval, ambito);
                    if(ambitoVariable != null) {
                        String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                        if(tipoIdentificador.equals("ULONG")){
                            Terceto t = new Terceto(":=", ambitoVariable, val_peek(0).sval);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto("Label"+adminTercetos.cantidadTercetos(), null, null);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.apilar(t.getNumero());
                            yyval = new ParserVal(ambitoVariable);
                        }
                        else
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {los tipos son incompatibles}");
                    }
                    else
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + val_peek(2).sval +" no fue declarada}");
                    }
break;
case 50:
//#line 194 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 51:
//#line 197 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 52:
//#line 198 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ':='}");}
break;
case 53:
//#line 199 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 54:
//#line 203 "Gramatica.y"
{
                                Operando op = (Operando)val_peek(0).obj;
                                if (op != null){
                                    Terceto t = new Terceto("BF", op.getValor(), null);
                                    adminTercetos.agregarTerceto(t);
                                    adminTercetos.apilar(t.getNumero());
                                    yyval = new ParserVal(op.getValor());
                                }
                                else
                                    yyval = new ParserVal(null);
                                 }
break;
case 55:
//#line 218 "Gramatica.y"
{yyval = new ParserVal(val_peek(1).sval);}
break;
case 56:
//#line 222 "Gramatica.y"
{
            if (val_peek(0).sval != null)
                yyval = new ParserVal(val_peek(0).sval);

            else
                yyval = new ParserVal(null);
}
break;
case 57:
//#line 230 "Gramatica.y"
{
		  	    if (val_peek(0).sval != null)
                    yyval = new ParserVal(val_peek(0).sval);

                else
                    yyval = new ParserVal(null);

		  	}
break;
case 59:
//#line 243 "Gramatica.y"
{
		     Terceto t = new Terceto("BREAK",null,null);
             adminTercetos.agregarTerceto(t);
		     Terceto t1 = new Terceto("BI", null, null);
             adminTercetos.agregarTerceto(t1);
             adminTercetos.apilar(t1.getNumero());
             yyval = new ParserVal("BREAK");
		    }
break;
case 60:
//#line 251 "Gramatica.y"
{yyval = new ParserVal(null);}
break;
case 61:
//#line 254 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 62:
//#line 257 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion de " + val_peek(3).sval +"}");
            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
            /*TODO MUCHOS ELSE*/
            if(ambitoVariable != null){
                String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                Operando op = (Operando)val_peek(1).obj;
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
                    yyval = new ParserVal(new Operando(tipoIdentificador, "[" + t.getNumero()+ "]"));
                    }
                    else{
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                    }
           }
           }
            else{
                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + val_peek(3).sval +" no fue declarada}");
            }


        }
break;
case 64:
//#line 299 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 65:
//#line 300 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 66:
//#line 301 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 67:
//#line 302 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 68:
//#line 306 "Gramatica.y"
{
            if(val_peek(3).sval != null){
                adminTercetos.desapilar();
                Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t);
                }
            /*TODO ELSE*/
            }
break;
case 69:
//#line 315 "Gramatica.y"
{
	        if(val_peek(2).sval != null){
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.desapilar();
                Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t1);
                adminTercetos.apilar(t.getNumero());
            }
            /*TODO ELSE*/
            }
break;
case 70:
//#line 326 "Gramatica.y"
{
                if(val_peek(6).sval != null) {
                   adminTercetos.desapilar();
                   Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                   adminTercetos.agregarTerceto(t);
            }
            /*TODO ELSE*/
       }
break;
case 72:
//#line 339 "Gramatica.y"
{
                Operando op = (Operando)val_peek(1).obj;
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
case 74:
//#line 353 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 78:
//#line 361 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 79:
//#line 362 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 80:
//#line 363 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 81:
//#line 366 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 82:
//#line 367 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 83:
//#line 368 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 84:
//#line 369 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 85:
//#line 370 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF al final}");}
break;
case 86:
//#line 371 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 87:
//#line 372 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 88:
//#line 376 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");
           Terceto t = new Terceto("Impresion", val_peek(1).sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 89:
//#line 381 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 90:
//#line 388 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");

               if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo() == "ULONG"){
                        if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                            Terceto t = new Terceto("InvocacionFuncion", funcionRef, null);
                             if (ambito.contains("@")){
                                String ambitoInvocacion = ambito;
                                ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                t.setAmbitoInvocacion(ambitoInvocacion);
                            }
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto(":=", Main.tablaSimbolos.getDatos(funcionRef).getParametro(), val_peek(1).sval);
                            t.setTipo(Main.tablaSimbolos.getDatos(funcionRef).getTipo());
                            adminTercetos.agregarTerceto(t);
                            funcionRef = funcionRef.substring(0, funcionRef.lastIndexOf("@"));
                            yyval = new ParserVal(funcionRef);
                        }
                        else{
                            Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto(":=", Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro(), val_peek(1).sval);
                            t.setTipo(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo());
                            adminTercetos.agregarTerceto(t);
                            yyval = new ParserVal(val_peek(3).sval);
                        }
                    }
                    else
                        if(ambitoFuncion == null){
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {La función "+val_peek(3).sval+" esta fuera de alcance}");
                            yyval = new ParserVal(null);
                        }
                        else{
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {Se invocó a la función "+val_peek(3).sval+" con un parámetro de otro tipo}");
                            yyval = new ParserVal(null);
                        }
               }
            }
break;
case 91:
//#line 429 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo() == "DOUBLE"){
                          if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                            Terceto t = new Terceto("InvocacionFuncion", funcionRef, null);
                             if (ambito.contains("@")){
                                String ambitoInvocacion = ambito;
                                ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                t.setAmbitoInvocacion(ambitoInvocacion);
                            }


                            adminTercetos.agregarTerceto(t);
                            t = new Terceto(":=", Main.tablaSimbolos.getDatos(funcionRef).getParametro(), val_peek(1).sval);
                             t.setTipo(Main.tablaSimbolos.getDatos(funcionRef).getTipo());
                            adminTercetos.agregarTerceto(t);
                            funcionRef = funcionRef.substring(0, funcionRef.lastIndexOf("@"));
                            yyval = new ParserVal(funcionRef);
                        }
                        else{
                             Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                             adminTercetos.agregarTerceto(t);
                             t = new Terceto(":=",  Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro(),val_peek(1).sval);
                             t.setTipo(Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo());
                             adminTercetos.agregarTerceto(t);
                             yyval = new ParserVal(val_peek(3).sval);
                        }
                    }
                    else
                        if(ambitoFuncion == null){
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {La función "+val_peek(3).sval+" esta fuera de alcance}");
                             yyval = new ParserVal(null);
                        }
                        else{
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {Se invocó a la función "+val_peek(3).sval+" con un parámetro de otro tipo}");
                            yyval = new ParserVal(null);
                        }
                }
            }
break;
case 92:
//#line 471 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");

                 if (val_peek(1).sval != null && val_peek(3).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    String ambitoParametro = Main.tablaSimbolos.verificarAmbito(val_peek(1).sval, ambito);
                    if(ambitoFuncion != null){
                        if (ambitoParametro != null){
                             String nombreParametro = Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro();
                                if (!nombreParametro.equals("")){
                                    if (Main.tablaSimbolos.getDatos(nombreParametro).getTipo().equals(Main.tablaSimbolos.getDatos(ambitoParametro).getTipo())){
                                         if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                                            Terceto t = new Terceto("InvocacionFuncion", funcionRef, null);
                                            if (ambito.contains("@")){
                                                String ambitoInvocacion = ambito;
                                                ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                                t.setAmbitoInvocacion(ambitoInvocacion);
                                            }
                                            adminTercetos.agregarTerceto(t);
                                            String variableFuncion = Main.tablaSimbolos.getDatos(funcionRef).getParametro();
                                            t = new Terceto(":=", variableFuncion ,ambitoParametro );
                                            t.setTipo(Main.tablaSimbolos.getDatos(variableFuncion).getTipo());
                                            adminTercetos.agregarTerceto(t);
                                            funcionRef = funcionRef.substring(0, funcionRef.lastIndexOf("@"));
                                            yyval = new ParserVal(funcionRef);
                                        }
                                        else{
                                             Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                                             if (ambito.contains("@")){
                                                  String ambitoInvocacion = ambito;
                                                  ambitoInvocacion = ambitoInvocacion.substring(ambitoInvocacion.lastIndexOf("@") +1);
                                                  t.setAmbitoInvocacion(ambitoInvocacion);
                                              }

                                             adminTercetos.agregarTerceto(t);
                                             String variableFuncion = Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro();
                                             t = new Terceto(":=", variableFuncion ,ambitoParametro );
                                             t.setTipo(Main.tablaSimbolos.getDatos(variableFuncion).getTipo());
                                             adminTercetos.agregarTerceto(t);
                                             yyval = new ParserVal(val_peek(3).sval);
                                        }
                                }
                                else{
                                   Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {Se invocó a la función "+val_peek(3).sval+" con un parámetro de otro tipo}");
                                   yyval = new ParserVal(null);
                                    }
                            }
                            else{

                            }
                        }
                        else{
                             Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {El parámetro "+val_peek(1).sval+" esta fuera de alcance o no esta declarado}");
                        }
                    }
                    else{
                           Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {La función "+val_peek(3).sval+" esta fuera de alcance}");
                           yyval = new ParserVal(null);
                        }
                 }
                 else
                     yyval = new ParserVal(null);
            }
break;
case 94:
//#line 537 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 95:
//#line 538 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 96:
//#line 539 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 97:
//#line 540 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
//#line 543 "Gramatica.y"
{adminTercetos.desapilar();
                                        Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                        adminTercetos.agregarTerceto(t);}
break;
case 100:
//#line 550 "Gramatica.y"
{
                                      Terceto t = new Terceto("BI", null, null);
                                      adminTercetos.agregarTerceto(t);
                                      adminTercetos.desapilar();
                                      Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                      adminTercetos.agregarTerceto(t1);
                                      adminTercetos.apilar(t.getNumero());
}
break;
case 102:
//#line 561 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 103:
//#line 564 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 104:
//#line 565 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 105:
//#line 566 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 109:
//#line 576 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 110:
//#line 581 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 112:
//#line 589 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 113:
//#line 593 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(1).sval +"'" );
            Operando op = (Operando)val_peek(0).obj;
            if(val_peek(1).sval != null && op != null ){ /*si se declaró bien y se cumplen los PRE (en caso de haberlos)*/

                   ambito = ambito.substring(0,ambito.lastIndexOf("@"));
                    Terceto t = new Terceto("RetornoFuncion", op.getValor(), null);
                    t.setTipo(op.getTipo());
                    adminTercetos.agregarTerceto(t);
                    t = new Terceto("FinFuncion", val_peek(1).sval, null);
                    adminTercetos.agregarTerceto(t);
                    yyval = new ParserVal(val_peek(1).sval);

            }

            else
                 yyval = new ParserVal(null);
         }
break;
case 115:
//#line 613 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 116:
//#line 616 "Gramatica.y"
{
                    parametroCopiaValor = val_peek(1).sval;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = val_peek(3).sval + "@" + ambito;
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema(val_peek(3).sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("NombreFuncion");
                            ds.setTipo(val_peek(5).sval);
                            ambito = ambito + "@" + val_peek(3).sval;
                            ds.setParametro(parametroCopiaValor +"@"+ ambito);
                            Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);

                            Main.tablaSimbolos.reemplazarLexema(parametroCopiaValor, parametroCopiaValor +"@"+ ambito); /* Se agrega el ambito al parametro (nombre de la función)*/

                            Terceto t = new Terceto("ComienzaFuncion", nuevoLexema, null);
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.agregarFuncion(nuevoLexema);

                            yyval = new ParserVal(nuevoLexema);
                        }
                        else{
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La funcion '" + val_peek(3).sval + "' ya fue declarada en este ámbito}");
                            yyval = new ParserVal(null);  /* se setea null para luego comprobar si se declaró o no*/
                        }
                    }
                    parametroCopiaValor = "";
                    }
break;
case 118:
//#line 647 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta indicar el tipo}");}
break;
case 119:
//#line 648 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 120:
//#line 649 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 121:
//#line 650 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 122:
//#line 651 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 123:
//#line 652 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 124:
//#line 655 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);
                }
break;
case 126:
//#line 665 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 127:
//#line 669 "Gramatica.y"
{
            if (val_peek(4).sval != null){
                 lista_variables = (ArrayList<String>)val_peek(0).obj;
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
            yyval= new ParserVal(val_peek(1).sval);


         }
break;
case 128:
//#line 701 "Gramatica.y"
{
                Operando op = (Operando)val_peek(0).obj;
                if (op!= null)
                    yyval = new ParserVal((Operando)val_peek(0).obj);
                else
                    yyval = new ParserVal (null);
           }
break;
case 129:
//#line 708 "Gramatica.y"
{
                Operando op = (Operando)val_peek(0).obj;
                if (op != null)
                     yyval = new ParserVal((Operando)val_peek(0).obj);
                else
                    yyval = new ParserVal (null);
           }
break;
case 130:
//#line 715 "Gramatica.y"
{ yyval = new ParserVal(null);}
break;
case 131:
//#line 718 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 132:
//#line 722 "Gramatica.y"
{
                             Operando op = (Operando)val_peek(3).obj;
                             if (op != null){
                                  yyval = new ParserVal((Operando)val_peek(3).obj);
                              }
                                 else
                                     yyval = new ParserVal (null);
                      }
break;
case 133:
//#line 731 "Gramatica.y"
{
                        Operando op = (Operando)val_peek(3).obj;
                        if (op != null){
                             yyval = new ParserVal((Operando)val_peek(3).obj);
                         }
                            else
                                yyval = new ParserVal (null);
                 }
break;
case 134:
//#line 740 "Gramatica.y"
{
			            Operando op = (Operando)val_peek(3).obj;
			            if (val_peek(8).sval != null && op != null){
			                yyval = new ParserVal((Operando)val_peek(3).obj);
			            }
			            else
			                yyval = new ParserVal (null);
			 }
break;
case 135:
//#line 748 "Gramatica.y"
{
                        Operando op = (Operando)val_peek(3).obj;
                        if (val_peek(7).sval != null && op != null){
                            yyval = new ParserVal((Operando)val_peek(3).obj);
                        }
                        else
                             yyval = new ParserVal (null);
             }
break;
case 136:
//#line 757 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 137:
//#line 760 "Gramatica.y"
{Main.listaErrores.add("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 138:
//#line 761 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 139:
//#line 762 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 140:
//#line 763 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 141:
//#line 764 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 142:
//#line 765 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 143:
//#line 766 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 144:
//#line 767 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 145:
//#line 769 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 146:
//#line 770 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 147:
//#line 771 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 148:
//#line 772 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 149:
//#line 773 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 150:
//#line 774 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 151:
//#line 775 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 152:
//#line 776 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 153:
//#line 777 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 154:
//#line 781 "Gramatica.y"
{
                      Operando op = (Operando)val_peek(1).obj;
                      if (op != null){
                         Terceto t = new Terceto("BF", op.getValor(), null);
                         adminTercetos.agregarTerceto(t);
                         adminTercetos.apilar(t.getNumero());
                         yyval = new ParserVal(op.getValor());
                     }
                     else
                         yyval = new ParserVal(null);
                   }
break;
case 156:
//#line 795 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 157:
//#line 796 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 158:
//#line 797 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 159:
//#line 798 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 160:
//#line 799 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 161:
//#line 804 "Gramatica.y"
{
                            Operando op = (Operando)val_peek(0).obj;
                            if(op != null)
                                yyval = new ParserVal((Operando)val_peek(0).obj);

                            else{
                                yyval = new ParserVal(null);
                                }

                }
break;
case 162:
//#line 816 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 163:
//#line 818 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 164:
//#line 841 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 165:
//#line 843 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 166:
//#line 864 "Gramatica.y"
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
                                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                            yyval = new ParserVal(null);
                                         }
                                    }
                                    else{
                                           yyval = new ParserVal(null);
                                    }
                   }
break;
case 167:
//#line 884 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 168:
//#line 888 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 169:
//#line 891 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
      }
break;
case 170:
//#line 911 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 171:
//#line 933 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
                    }
break;
case 172:
//#line 953 "Gramatica.y"
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
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                        yyval = new ParserVal(null);
                     }
                }
                else{
                       yyval = new ParserVal(null);
                }
            }
break;
case 173:
//#line 973 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 174:
//#line 977 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) val_peek(0).obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 175:
//#line 982 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 176:
//#line 985 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 177:
//#line 988 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");
	            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(0).sval, ambito);
                	if(ambitoVariable != null)
                        yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                    else {
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + val_peek(0).sval +" no fue declarada}");
                        yyval = new ParserVal(null);
	                }
	          }
break;
case 178:
//#line 997 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocacion de funcion}");
                       if(val_peek(0).sval != null){
                           String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(0).sval, ambito);
                           if (ambitoVariable != null)
                                yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                           else
                           Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La Funcion " + val_peek(0).sval +" no fue declarada}");
                       }
                     }
break;
case 179:
//#line 1009 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 180:
//#line 1010 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 181:
//#line 1011 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 182:
//#line 1012 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 183:
//#line 1013 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 184:
//#line 1014 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 2142 "Parser.java"
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
