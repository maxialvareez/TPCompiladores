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
    5,    6,    6,    7,    7,    7,   10,    8,    8,    8,
    8,    8,    8,   16,   16,   16,   16,   16,    4,    4,
    4,    4,   21,   21,   21,   17,   17,   11,   11,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   23,
   25,   25,   26,   26,   26,   27,   15,   15,   29,   29,
   29,   12,   12,   12,   31,   31,   31,   33,   33,   33,
   32,   32,   32,   32,   32,   32,   32,   32,   32,   13,
   14,   14,   35,   35,   35,   35,    9,    9,   38,   38,
   38,   38,   37,   37,   39,   39,   18,   18,   18,   40,
   19,   19,   42,   42,   42,   42,   42,   42,   36,   36,
   43,   20,   20,   45,   45,   45,   45,   45,   45,   44,
   41,   41,   41,   47,   46,   46,   46,   46,   48,   48,
   48,   48,   48,   48,   48,   48,   48,   48,   48,   48,
   48,   48,   48,   48,   48,   48,   48,   48,   48,   48,
   22,   22,   49,   49,   50,   50,   28,   28,   28,   30,
   30,   30,   34,   34,   34,   34,   34,   51,   51,   51,
   51,   51,   51,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    1,    2,    1,    2,    2,    2,    2,
    2,    2,    1,    2,    2,    2,    2,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,   11,    1,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   10,    3,
    1,    2,    1,    2,    1,    2,    3,    1,    2,    2,
    2,    7,    9,    1,    1,    5,    1,    4,    5,    4,
    6,    6,    6,    6,    6,    6,    6,    8,    8,    4,
    4,    1,    3,    3,    3,    3,    4,    1,    3,    3,
    3,    4,    3,    3,    1,    2,    3,    1,    1,    2,
    6,    1,    5,    5,    5,    5,    5,    5,    2,    1,
    2,    6,    1,    5,    5,    5,    5,    5,    6,    2,
    2,    1,    1,    2,    8,   14,   13,    1,    7,    7,
    7,    7,    7,    7,    7,    3,    8,   12,   12,   12,
   12,   12,   12,   12,   12,   12,   12,   12,   13,    8,
    1,    3,    1,    3,    1,    3,    1,    3,    3,    3,
    3,    1,    2,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,  102,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    9,   10,    0,    0,   16,    0,
    0,    0,    0,    0,   23,   39,   58,   64,   82,   88,
    0,    0,    0,    0,    4,    7,    0,    0,    0,   99,
   35,    0,  165,    0,  164,    0,    0,  167,    0,    0,
  162,    0,  110,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    1,    0,    0,   12,   11,    0,   17,   15,   24,   18,
   25,   19,   26,   20,   28,   21,   27,   22,    0,    0,
    0,    0,    0,    0,   33,  100,   29,    0,   34,   30,
    0,    0,   85,    0,    0,  163,  111,  109,    0,    0,
   84,    0,    0,    0,    0,    0,    0,    0,  171,  172,
  170,  173,  168,  169,    0,    0,    0,   13,    8,    0,
    0,    0,    0,   90,    0,   91,    0,    0,   89,    0,
    0,    0,    0,    0,   83,    0,   97,   86,   81,  160,
  161,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   80,    0,    0,    0,    0,    0,    0,    0,    0,   92,
   87,    0,    0,    0,    0,    0,  103,  122,  123,  128,
  106,    0,  107,  105,  104,    0,    0,    0,  113,    0,
    0,   65,    0,   67,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   94,   93,   96,    0,    0,    0,    0,
    0,  124,  121,    0,  101,    0,    0,    0,   31,    0,
   73,   74,   76,    0,   75,   72,    0,    0,    0,    0,
    0,    0,   71,    0,    0,    0,    0,    0,  136,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   62,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   70,   68,    0,   78,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  116,  117,
    0,  118,  115,  114,   69,   66,   63,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   98,    0,  119,  112,    0,   40,   42,   45,   46,    0,
   48,   47,   44,   43,   41,  130,    0,    0,    0,    0,
    0,    0,    0,  133,  134,  135,    0,  132,  131,    0,
  129,    0,   53,    0,   51,   55,   38,    0,    0,    0,
    0,  150,    0,    0,    0,    0,    0,  137,  125,    0,
   56,   54,   50,   52,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  140,  141,  143,  146,  147,  148,    0,  145,  144,  142,
    0,    0,  139,  138,  149,  127,    0,  126,
};
final static short yydgoto[] = {                          6,
  185,   23,    8,    9,  186,   25,   26,   27,   28,   29,
   30,   31,   32,   33,   34,   35,   59,   48,   11,  198,
   12,   79,  346,   36,  374,  375,  376,   68,   37,   69,
  203,   38,  204,   61,   39,  103,  144,   40,  179,   50,
  187,   13,   63,  309,  199,  188,  189,  190,   70,   71,
  135,
};
final static short yysindex[] = {                      -123,
  153,  -35,    0,    0, -230,    0,  176,    0,    0, -191,
   -5,    0,    0,  542,  690,  726,   47,  506,  -25,  140,
  608,  176, -101,  295,    0,    0, -258,  116,    0,  119,
  159,  354,  361,  364,    0,    0,    0,    0,    0,    0,
  -29, -160,   24,  608,    0,    0,   56,   84,  369,    0,
    0,  -11,    0,  690,    0,  559,  690,    0,  -98,   93,
    0,    4,    0, -160,   93,  571,   -3,   33,   93, -155,
  621, -136,  583,  204,   71,   61, -138, -166,   16,   98,
    0,   56, -101,    0,    0, -138,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  -22,  109,
  122, -160,  138, -160,    0,    0,    0,  -84,    0,    0,
  559,   33,    0,  143,   98,    0,    0,    0,  690,  690,
    0,  -88,  -16,  690,  -82,  690,  690,  690,    0,    0,
    0,    0,    0,    0,  690,  144,  559,    0,    0,  -69,
  379,  -68,  506,    0, -233,    0,  -77,   80,    0,   80,
   21,   80,   80,  -27,    0,  162,    0,    0,    0,    0,
    0,  315,  315,  195, -155,  315,   93,   93,  621,   33,
    0,  138,  145,  147,  -39,  149, -258,  -66,  513,    0,
    0,  315,  221,  170,   51,  322,    0,    0,    0,    0,
    0,   80,    0,    0,    0,   -7, -160,  158,    0,   80,
  506,    0,  142,    0,  156,  225,  171,  179,  690,  690,
  -31,  690,  690,    0,    0,    0,  181,  362,  702,  240,
  690,    0,    0,  389,    0,   39,  427,  430,    0,  334,
    0,    0,    0, -217,    0,    0,    5,   72,  786,   79,
   82,  127,    0,  690,  593,  447,   19,  798,    0,  608,
   29,  690,  403,   10,  431,  448,  383,  351,    0,  257,
  251,  254,  260,  132,  264,  272,  274,   42,  474,  -38,
  690,  481,  610,   45,   53,  483,   57,  267,  267,   31,
  267,  267,    0,    0,  384,    0,  278,  503,  509,  510,
  518,  -19,  519,  523,  527,  514,  506,  506,  378,   66,
  506,  516,  -24,  521,  -49,  506,  522,  312,    0,    0,
  -91,    0,    0,    0,    0,    0,    0,  303,  303,  303,
  303,  -37,  303,  303,  303,  303,  309,  395,  416,  425,
  437,  529,  446,  317,  331,  -51,  332,  343,  458,  349,
    0,    3,    0,    0,  465,    0,    0,    0,    0,  303,
    0,    0,    0,    0,    0,    0,  589,  591,  604,  266,
  607,  477,  614,    0,    0,    0, -193,    0,    0,  616,
    0,  386,    0,  286,    0,    0,    0,  690,  690,  690,
  814,    0,  608,  690,  622,  486,  690,    0,    0,  690,
    0,    0,    0,    0,   83,   86,  110,  620,  111,  112,
  120,  690,  624,  126,  128,  611,  612,  613,  626,   -9,
  627,   -1,  632,  129,  690,  633,  643,  392,  394,  400,
  405,  436,  -47,  445,  449,  463,  653,  131,  480,  487,
    0,    0,    0,    0,    0,    0,  467,    0,    0,    0,
  489,  692,    0,    0,    0,    0,  498,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  775,    0,    0,    0,    6,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  577,    0,    0,    0,
    0,  848,    0,  387,    0,    0,    0,    0,    0,  421,
    0,    0,    0,    0,  422,    0,    0,  720,  748,   36,
   78,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  796,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  451,    0,    0,  457,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  115,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  432,    0,  860,  872,  586,  762,
    0,  457,    0,    0,    0,    0,  515,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  476,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  497,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  512,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  738,    0,    0,    0,    0,    0,    0,    0,  539,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   48,   77,    0,    9,  108,    0,  -18,  732,  655,    0,
    0,    0,    0,  -14,    0,    0,  950,  493,  792,    0,
    0,    2,  617,    0,    0,  435,    0,  -10,    0,   74,
 -127,    0,    0,  807,    0, 1122,  -52,    0,    0,    0,
  -50,    0,    0, -207,    0,  619,    0,    0,  687,  684,
    0,
};
final static int YYTABLESIZE=1259;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         58,
   58,   58,  299,  350,   42,   85,   58,  367,   64,  338,
   99,  437,  197,   57,   76,   46,  336,   67,  150,  212,
  298,  323,  180,   86,  164,  146,   43,  239,  111,   58,
   46,  423,  226,  149,  335,  205,  207,  125,  208,   58,
  143,   58,   58,  112,  121,   14,  108,    7,   22,  422,
  280,   58,  259,   51,  217,   85,  147,  425,   58,  272,
   44,  192,  388,  261,   14,   47,  260,  123,  279,  276,
   83,  310,  312,  313,  314,  126,  151,  127,  234,  253,
    2,  389,  296,   45,  102,  304,   72,   60,   65,  311,
   44,   46,  181,  305,  151,  104,   58,  307,   81,  191,
  193,  194,  195,  344,   58,   58,  332,  143,   24,   58,
  128,   58,   58,   58,   24,  145,    3,    4,  153,   44,
   58,  142,   58,  406,  170,   74,  407,  108,  136,   24,
  262,  140,  287,    1,  119,  143,  153,  265,  148,  120,
  266,  225,  107,  202,  202,  202,   60,  202,    2,  152,
  408,  411,  412,    3,    4,   82,   83,  117,  118,    5,
  413,   83,  153,  202,  343,  308,  416,   85,  417,  427,
    2,  442,  157,   83,   88,    3,    4,   90,  155,   44,
  162,    5,  230,  159,  171,  267,  166,  202,  173,  176,
  292,  182,   21,   46,   58,   58,   58,   58,   58,  167,
  168,   85,  200,  209,   58,  210,   58,  213,  214,  221,
  237,  238,  240,  241,  242,   44,  229,   92,  211,  182,
  247,   41,  251,  366,   58,   52,   53,  436,  124,   58,
   58,   75,   55,   58,   44,   58,  345,   58,  322,   85,
  264,  202,  124,   44,  196,  268,  270,    3,    4,  274,
  124,  275,  163,  277,    3,    4,   58,  124,   58,  106,
   44,   14,   14,  124,   44,    3,    4,  182,   14,    3,
    4,  124,  300,   14,  303,   14,   14,   14,   14,  250,
   14,   14,  124,   15,   14,  124,   14,  308,   16,   14,
  220,   17,    2,  151,  183,  124,   44,    3,    4,   19,
  184,   20,  151,    5,  151,  383,  222,   14,  124,   85,
   85,  124,   85,   15,   85,    3,    4,  141,   16,  124,
   85,   17,    2,  124,  183,   44,  373,    3,    4,   19,
  184,   20,  124,    5,   44,  153,   14,  258,  124,  105,
  106,   85,   15,  153,  153,  124,  153,   16,  124,  124,
   17,    2,  124,  183,   44,  373,    3,    4,   19,  184,
   20,   44,    5,   58,   58,   58,   58,   85,   58,   58,
   83,   87,   58,   44,   89,   58,  124,  124,  124,  395,
  396,  397,  399,   58,  400,  401,  124,   58,  404,  291,
   44,  405,  124,  124,  124,  124,   73,  124,  124,  410,
   58,  244,   15,  414,  328,  329,  331,   16,  333,   14,
   17,  231,   94,  339,   91,   15,  428,   44,   19,   96,
   16,   77,   98,   17,    2,  232,   18,  110,  252,    3,
    4,   19,   14,   20,   44,    5,  330,  360,   15,  175,
  235,  284,  316,   16,  392,   61,   17,    2,  236,   18,
  243,   73,    3,    4,   19,   44,   20,   15,    5,  138,
   73,  278,   16,  206,   44,   17,   15,  255,  201,  386,
  256,   16,  152,   19,   17,   20,   44,   73,  139,   60,
   59,   73,   19,   15,   20,   44,  271,   15,   16,  281,
  152,   17,   16,  218,  233,   17,   73,   44,  201,   19,
  219,   20,   15,   19,   44,   20,  282,   16,  288,   57,
   17,  289,  248,   73,  249,   86,   44,  290,   19,   15,
   20,  293,   73,  308,   16,   44,  286,   17,   15,  294,
  201,  295,  297,   16,  108,   19,   17,   20,  381,  301,
  382,  306,   73,  318,   19,   44,   20,  317,   15,  319,
  320,   73,   44,   16,   95,   77,   17,   15,  321,  324,
  393,  372,   16,  325,   19,   17,   20,  326,  341,   84,
   79,   73,  327,   19,  334,   20,  345,   15,   73,  337,
  340,   56,   16,  356,   15,   17,   57,  362,  201,   16,
   73,  364,   17,   19,  224,   20,   15,   49,   64,  113,
   19,   16,   20,   57,   17,  365,  368,   73,  257,   93,
   64,  122,   19,   15,   20,   57,   95,  369,   16,   97,
   98,   17,  137,  371,  109,  285,  154,   57,  378,   19,
  379,   20,   64,  269,   73,   98,  174,   57,  283,  315,
   15,  391,   61,  380,  154,   16,  384,   64,   17,   64,
  302,   73,   57,  387,   57,  390,   19,   15,   20,   64,
  409,  402,   16,  415,   57,   17,  431,  357,  432,  418,
  419,  420,   73,   19,  433,   20,   60,   59,   15,  434,
  133,   73,  134,   16,  421,  424,   17,   15,  358,  152,
  426,  429,   16,   73,   19,   17,   20,  359,  152,   15,
  152,  430,   73,   19,   16,   20,   57,   17,   15,  361,
  435,  441,   86,   16,   73,   19,   17,   20,  363,  438,
   15,   73,  445,  439,   19,   16,   20,   15,   17,   64,
  370,  108,   16,   73,   57,   17,   19,  440,   20,   15,
  372,  245,   73,   19,   16,   20,   57,   17,   15,  385,
  447,   78,   77,   16,  443,   19,   17,   20,  403,  246,
  155,  444,   73,  446,   19,   66,   20,   79,   15,   73,
   57,   95,  448,   16,    2,   15,   17,   95,  155,  155,
   16,  155,   95,   17,   19,   95,   20,  215,  157,   95,
  157,   19,  157,   95,   49,    5,  120,  178,   52,   53,
  342,   49,  156,  223,   54,   55,  157,  157,  394,  157,
  165,  169,    0,    0,    0,   52,   53,    0,    3,    4,
  156,  156,   55,  156,    0,   64,    0,   52,   53,    0,
   57,    0,   98,   98,   55,    3,    4,  273,    0,   52,
   53,    0,   57,  154,  263,   54,   55,    3,    4,   52,
   53,  154,  154,  398,  154,    0,   55,    0,   57,    3,
    4,    0,  114,  116,   52,   53,   52,   53,    0,    3,
    4,   55,    0,   55,  177,    0,   52,   53,    0,  129,
  130,  131,  132,   55,    3,    4,    3,    4,  166,  166,
  166,    0,  166,    0,  166,    0,    3,    4,    0,    0,
  158,    0,  158,    0,  158,    0,  166,  166,    0,  166,
  216,    0,  159,    0,  159,    0,  159,  114,  158,  158,
    0,  158,    0,    0,    0,  160,  161,    0,    0,    0,
  159,  159,    0,  159,    0,  347,  348,  349,  351,  352,
  353,  354,  355,  114,    0,    0,   52,   53,    0,   10,
   10,    0,    0,   55,    0,    0,   10,    0,   52,   53,
    0,    0,    0,    0,    0,   55,  377,    0,    0,    0,
    0,   10,   10,    0,    0,    0,    0,  155,  155,  155,
  155,  155,   52,   53,    0,  155,  155,    0,  155,   55,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  157,    0,  157,  157,  157,  157,  157,
    0,    0,    0,  157,  157,    0,  157,    0,    0,  156,
  156,  156,  156,  156,    0,    0,    0,  156,  156,    0,
  156,    0,   10,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   52,   53,    0,    0,    0,    0,    0,   55,
    0,  154,    0,    0,   52,   53,    0,    0,    0,    0,
    0,   55,    0,    0,    0,    0,    0,    0,    0,    0,
   52,   53,    0,    0,    0,    0,    0,   55,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   10,    0,   10,
   10,   10,   10,  166,    0,  166,  166,  166,  166,  166,
    0,    0,    0,  166,  166,  158,  166,  158,  158,  158,
  158,  158,    0,    0,    0,  158,  158,  159,  158,  159,
  159,  159,  159,  159,   10,   62,    0,  159,  159,    0,
  159,   10,   80,    0,    0,  227,  228,    0,    0,   10,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  100,  101,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   62,    0,  254,    0,  115,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   62,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  151,    0,    0,    0,    0,  156,    0,    0,    0,    0,
    0,    0,  158,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  172,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         14,
   15,   16,   41,   41,   40,   24,   21,   59,   40,   59,
   40,   59,   40,   45,   40,    7,   41,   16,   41,   59,
   59,   41,  256,  282,   41,   78,  257,   59,   40,   44,
   22,   41,   40,   86,   59,  163,  164,   41,  166,   54,
  274,   56,   57,   54,   41,   40,   44,    0,    1,   59,
   41,   66,  270,   59,  182,   74,   41,   59,   73,   41,
   40,   41,  256,   59,   59,  257,  284,   66,   59,   41,
   23,  279,  280,  281,  282,   43,   41,   45,  206,   41,
  272,  275,   41,    7,   61,   41,   40,   14,   15,   59,
   40,   83,  145,   41,   59,   40,  111,   41,   22,  150,
  151,  152,  153,  311,  119,  120,   41,  274,    1,  124,
  266,  126,  127,  128,    7,  282,  277,  278,   41,   40,
  135,   61,  137,   41,  135,   18,   41,   44,  265,   22,
   59,   61,  260,  257,   42,  274,   59,   59,   41,   47,
   59,  192,   59,  162,  163,  164,   73,  166,  272,   41,
   41,   41,   41,  277,  278,  257,   42,  256,  257,  283,
   41,   47,   41,  182,  256,  257,   41,  186,   41,   41,
  272,   41,  257,   59,   59,  277,  278,   59,   41,   40,
  269,  283,  201,   41,   41,   59,  269,  206,  258,  258,
   59,  269,   40,  185,  209,  210,  211,  212,  213,  126,
  127,  220,   41,   59,  219,   59,  221,   59,  275,   40,
  209,  210,  211,  212,  213,   40,   59,   59,  258,  269,
  219,  257,  221,  275,  239,  257,  258,  275,  267,  244,
  245,  257,  264,  248,   40,  250,  274,  252,  258,  258,
  239,  260,  267,   40,  272,  244,  245,  277,  278,  248,
  267,  250,  269,  252,  277,  278,  271,  267,  273,  257,
   40,  256,  257,  267,   40,  277,  278,  269,  263,  277,
  278,  267,  271,  268,  273,  270,  271,  257,  273,   40,
  275,  276,  267,  263,  279,  267,  281,  257,  268,  284,
  183,  271,  272,  258,  274,  267,   40,  277,  278,  279,
  280,  281,  267,  283,  269,   40,  256,  257,  267,  328,
  329,  267,  331,  263,  333,  277,  278,  257,  268,  267,
  339,  271,  272,  267,  274,   40,  345,  277,  278,  279,
  280,  281,  267,  283,   40,  258,  257,  230,  267,  256,
  257,  360,  263,  266,  267,  267,  269,  268,  267,  267,
  271,  272,  267,  274,   40,  374,  277,  278,  279,  280,
  281,   40,  283,  378,  379,  380,  381,  386,  383,  384,
  256,  256,  387,   40,  256,  390,  267,  267,  267,  378,
  379,  380,  381,  398,  383,  384,  267,  402,  387,  258,
   40,  390,  267,  267,  267,  267,  257,  267,  267,  398,
  415,   40,  263,  402,  297,  298,  299,  268,  301,  257,
  271,  270,   59,  306,  256,  263,  415,   40,  279,   59,
  268,  282,   59,  271,  272,  270,  274,   59,   40,  277,
  278,  279,  257,  281,   40,  283,   59,  330,  263,   61,
  270,   59,   59,  268,   59,   59,  271,  272,  270,  274,
  270,  257,  277,  278,  279,   40,  281,  263,  283,  256,
  257,   59,  268,  269,   40,  271,  263,   41,  274,  362,
   41,  268,   41,  279,  271,  281,   40,  257,  275,   59,
   59,  257,  279,  263,  281,   40,   40,  263,  268,   59,
   59,  271,  268,  273,  270,  271,  257,   40,  274,  279,
  280,  281,  263,  279,   40,  281,   59,  268,  258,   59,
  271,  258,  273,  257,  275,   59,   40,  258,  279,  263,
  281,  258,  257,  257,  268,   40,  270,  271,  263,  258,
  274,  258,   59,  268,   59,  279,  271,  281,  273,   59,
  275,   59,  257,   41,  279,   40,  281,  270,  263,   41,
   41,  257,   40,  268,   40,   59,  271,  263,   41,   41,
  275,  276,  268,   41,  279,  271,  281,   41,  257,  275,
   59,  257,   59,  279,   59,  281,  274,  263,  257,   59,
   59,   40,  268,  275,  263,  271,   45,   59,  274,  268,
  257,  275,  271,  279,  273,  281,  263,   59,   40,   41,
  279,  268,  281,   45,  271,  275,  275,  257,  275,  256,
   40,   41,  279,  263,  281,   45,  256,  275,  268,  256,
   44,  271,   40,  275,  256,  275,   41,   45,   40,  279,
   40,  281,   40,   41,  257,   59,  258,   45,  256,  256,
  263,  256,  256,   40,   59,  268,   40,   40,  271,   40,
   41,  257,   45,   40,   45,   40,  279,  263,  281,   40,
   41,   40,  268,   40,   45,  271,  275,  273,  275,   59,
   59,   59,  257,  279,  275,  281,  256,  256,  263,  275,
   60,  257,   62,  268,   59,   59,  271,  263,  273,  258,
   59,   59,  268,  257,  279,  271,  281,  273,  267,  263,
  269,   59,  257,  279,  268,  281,  256,  271,  263,  273,
  275,   59,  256,  268,  257,  279,  271,  281,  273,  275,
  263,  257,  256,  275,  279,  268,  281,  263,  271,   40,
  273,  256,  268,  257,   45,  271,  279,  275,  281,  263,
  276,   40,  257,  279,  268,  281,   45,  271,  263,  273,
   59,   20,  256,  268,  275,  279,  271,  281,  273,   58,
   41,  275,  257,  275,  279,   40,  281,  256,  263,  257,
   45,  257,  275,  268,    0,  263,  271,  263,   59,   60,
  268,   62,  268,  271,  279,  271,  281,  275,   41,  275,
   43,  279,   45,  279,  256,    0,   59,  143,  257,  258,
  308,   10,   41,  185,  263,  264,   59,   60,  374,   62,
  124,  128,   -1,   -1,   -1,  257,  258,   -1,  277,  278,
   59,   60,  264,   62,   -1,   40,   -1,  257,  258,   -1,
   45,   -1,  256,  257,  264,  277,  278,   40,   -1,  257,
  258,   -1,   45,  258,   59,  263,  264,  277,  278,  257,
  258,  266,  267,   40,  269,   -1,  264,   -1,   45,  277,
  278,   -1,   56,   57,  257,  258,  257,  258,   -1,  277,
  278,  264,   -1,  264,  143,   -1,  257,  258,   -1,  259,
  260,  261,  262,  264,  277,  278,  277,  278,   41,   42,
   43,   -1,   45,   -1,   47,   -1,  277,  278,   -1,   -1,
   41,   -1,   43,   -1,   45,   -1,   59,   60,   -1,   62,
  179,   -1,   41,   -1,   43,   -1,   45,  111,   59,   60,
   -1,   62,   -1,   -1,   -1,  119,  120,   -1,   -1,   -1,
   59,   60,   -1,   62,   -1,  319,  320,  321,  322,  323,
  324,  325,  326,  137,   -1,   -1,  257,  258,   -1,    0,
    1,   -1,   -1,  264,   -1,   -1,    7,   -1,  257,  258,
   -1,   -1,   -1,   -1,   -1,  264,  350,   -1,   -1,   -1,
   -1,   22,   23,   -1,   -1,   -1,   -1,  258,  259,  260,
  261,  262,  257,  258,   -1,  266,  267,   -1,  269,  264,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,  269,   -1,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,
  269,   -1,   83,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  257,  258,   -1,   -1,   -1,   -1,   -1,  264,
   -1,  102,   -1,   -1,  257,  258,   -1,   -1,   -1,   -1,
   -1,  264,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  257,  258,   -1,   -1,   -1,   -1,   -1,  264,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  148,   -1,  150,
  151,  152,  153,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  256,  269,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,  269,  258,
  259,  260,  261,  262,  185,   14,   -1,  266,  267,   -1,
  269,  192,   21,   -1,   -1,  196,  197,   -1,   -1,  200,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   41,   42,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   52,   -1,  226,   -1,   56,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   73,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   99,   -1,   -1,   -1,   -1,  104,   -1,   -1,   -1,   -1,
   -1,   -1,  111,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  137,
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
"sentencia_ejecucion : sentencia_ejecutable",
"sentencia_ejecucion : try_catch ';'",
"sentencia_ejecucion : error_sentencia_ejecucion",
"error_sentencia_ejecucion : try_catch error",
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
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')'",
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
"error_asignacion : IDENTIFICADOR ASIGNACION",
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
"invocacion : IDENTIFICADOR '(' factor ')'",
"invocacion : error_invocacion",
"error_invocacion : '(' parametro ')'",
"error_invocacion : IDENTIFICADOR parametro ')'",
"error_invocacion : IDENTIFICADOR '(' ')'",
"error_invocacion : IDENTIFICADOR '(' parametro",
"try_catch : TRY sentencia_ejecutable CATCH bloque_catch",
"try_catch : error_try_catch",
"error_try_catch : sentencia_ejecutable CATCH bloque_catch",
"error_try_catch : TRY CATCH bloque_catch",
"error_try_catch : TRY sentencia_ejecutable bloque_catch",
"error_try_catch : TRY sentencia_ejecutable CATCH error",
"bloque_catch : BEGIN bloque_1 END",
"bloque_catch : BEGIN try_catch END",
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

//#line 320 "Gramatica.y"

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
//#line 820 "Parser.java"
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
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN per falta un END para cerrar el bloque}");}
break;
case 17:
//#line 48 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 59 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 25:
//#line 60 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 26:
//#line 61 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 27:
//#line 62 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
//#line 63 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 67 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 31:
//#line 69 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + val_peek(4).sval +"'}");}
break;
case 33:
//#line 74 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
//#line 75 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
//#line 76 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 38:
//#line 85 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 40:
//#line 89 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
//#line 90 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 42:
//#line 91 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 43:
//#line 92 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 44:
//#line 93 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 94 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 46:
//#line 95 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 47:
//#line 96 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 48:
//#line 97 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 49:
//#line 98 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 56:
//#line 113 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 57:
//#line 116 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + val_peek(2).sval + ":= " + val_peek(0).sval +"}");}
break;
case 59:
//#line 121 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 60:
//#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 61:
//#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 68:
//#line 138 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 69:
//#line 139 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 70:
//#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 71:
//#line 143 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 72:
//#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 73:
//#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 74:
//#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 75:
//#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 76:
//#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 77:
//#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 78:
//#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 79:
//#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 81:
//#line 159 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 83:
//#line 163 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 84:
//#line 164 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 85:
//#line 165 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 86:
//#line 166 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 89:
//#line 175 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra TRY}");}
break;
case 90:
//#line 176 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 91:
//#line 177 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 92:
//#line 178 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 94:
//#line 182 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 97:
//#line 189 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 98:
//#line 190 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 100:
//#line 195 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 101:
//#line 197 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 103:
//#line 202 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 104:
//#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 105:
//#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 106:
//#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 107:
//#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 108:
//#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 111:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 114:
//#line 223 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 115:
//#line 224 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 116:
//#line 225 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 117:
//#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 118:
//#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 119:
//#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 124:
//#line 241 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 129:
//#line 251 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 130:
//#line 252 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 131:
//#line 253 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 132:
//#line 254 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 133:
//#line 255 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 134:
//#line 256 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 135:
//#line 257 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 136:
//#line 258 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 137:
//#line 259 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 138:
//#line 261 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 139:
//#line 262 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 140:
//#line 263 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 141:
//#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 142:
//#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 143:
//#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 144:
//#line 267 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 145:
//#line 268 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 146:
//#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 147:
//#line 270 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 148:
//#line 271 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 149:
//#line 272 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 150:
//#line 273 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 152:
//#line 280 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 154:
//#line 284 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 156:
//#line 288 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 158:
//#line 292 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 159:
//#line 293 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 160:
//#line 296 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 161:
//#line 297 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 163:
//#line 302 "Gramatica.y"
{chequearFactorNegado();}
break;
case 164:
//#line 303 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");}
break;
case 165:
//#line 304 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");}
break;
case 166:
//#line 305 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1393 "Parser.java"
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
