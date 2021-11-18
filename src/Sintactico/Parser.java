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
    4,    4,   21,   21,   21,   17,   17,    9,    9,    9,
   25,   25,   25,   25,   25,   25,   25,   25,   22,   22,
   26,   26,   26,   24,   27,   27,   28,   28,   28,   29,
   13,   13,   31,   31,   31,   10,   10,   10,   33,   33,
   33,   35,   35,   35,   34,   34,   34,   34,   34,   34,
   34,   34,   34,   11,   11,   12,   12,   12,   12,   36,
   36,   36,   36,   15,   15,   38,   38,   38,   38,   37,
   39,   39,   18,   18,   18,   40,   19,   19,   43,   41,
   41,   45,   45,   45,   45,   45,   44,   44,   46,   20,
   20,   48,   48,   48,   48,   48,   48,   47,   42,   42,
   42,   50,   49,   49,   49,   49,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   51,   51,   23,   23,
   52,   52,   53,   53,   30,   30,   30,   32,   32,   32,
   55,   55,   55,   55,   55,   54,   54,   54,   54,   54,
   54,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,   10,    1,
    8,    8,    8,    8,    8,    8,    8,    9,    3,    1,
    2,    2,    3,    3,    1,    2,    1,    2,    1,    2,
    3,    1,    2,    2,    3,    7,    9,    1,    1,    5,
    1,    4,    5,    4,    6,    6,    6,    6,    6,    6,
    6,    8,    8,    4,    3,    4,    4,    4,    1,    3,
    4,    4,    4,    4,    1,    3,    3,    4,    4,    3,
    1,    2,    3,    1,    1,    2,    2,    1,    2,    5,
    1,    4,    4,    4,    4,    5,    2,    1,    2,    6,
    1,    5,    5,    5,    5,    5,    6,    2,    2,    1,
    1,    2,    8,   14,   13,    1,    7,    7,    7,    7,
    7,    7,    7,    3,    8,   12,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   12,   13,    8,    1,    3,
    1,    3,    1,    3,    1,    3,    3,    3,    3,    1,
    2,    1,    1,    1,    1,    1,    1,    1,    1,    1,
    1,
};
final static short yydefred[] = {                         0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  108,  111,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   40,   62,   68,
   89,   95,    0,    0,    0,    0,    4,    7,    0,    0,
    0,  105,   35,  109,    0,    0,    0,    0,  107,  130,
  131,  136,    0,  173,    0,  172,    0,    0,  175,    0,
  170,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   50,    0,    0,    0,    0,
    0,    0,  118,    1,    0,    0,   12,   11,   20,   14,
   21,   15,   22,   16,   24,   17,   23,   18,   28,   26,
    0,    0,    0,    0,    0,   33,  106,   29,    0,   34,
   30,    0,    0,    0,    0,  132,  129,    0,    0,   65,
    0,    0,    0,    0,   90,  171,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  179,  180,  178,  181,  176,
  177,    0,    0,   85,   13,    8,   52,    0,   51,    0,
    0,    0,    0,   96,    0,   97,    0,  119,  117,    0,
  112,  115,    0,  114,  113,    0,  103,    0,    0,    0,
    0,    0,  144,    0,    0,    0,   93,   88,   91,   86,
   92,   87,  168,  169,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   84,   53,   49,    0,    0,    0,    0,
  101,    0,   98,   94,   99,    0,  116,  110,    0,    0,
    0,  121,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   69,    0,   71,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  100,  102,    0,    0,    0,
    0,   31,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   77,   78,   80,    0,   79,
   76,    0,    0,    0,    0,    0,    0,   75,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   66,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  138,    0,    0,    0,    0,    0,    0,
    0,  141,  142,  143,    0,  140,  139,    0,  137,   74,
   72,    0,   82,    0,    0,   42,   44,   45,    0,   47,
   46,    0,   43,   41,    0,  124,  125,    0,  126,  123,
  122,    0,    0,    0,    0,  158,    0,    0,    0,    0,
    0,  145,  133,    0,   73,   70,   67,    0,   57,    0,
   55,   59,   48,   38,    0,  104,    0,  127,  120,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   60,   58,   54,   56,   39,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  148,  149,  151,  154,  155,  156,    0,  153,  152,  150,
    0,    0,  147,  146,  157,  135,    0,  134,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   50,   11,  221,
   12,   85,   91,  336,   38,   86,  370,  371,  372,   75,
   39,   76,  235,   40,  236,   41,  164,   42,  212,   52,
   13,   59,   14,   92,   15,   93,  346,  222,   60,   61,
   62,   77,   78,  152,   71,
};
final static short yysindex[] = {                       561,
  144,   76,    0,    0, -217,    0,  163,    0,    0, -186,
    4,    0,   11,    0,    0,  577,  516,  611,   26,  467,
  -30,  -31,  299,  163,  628,   72,    0,    0,    0,  134,
  137,  142,  295,  341,    0,  370,    0,    0,    0,    0,
    0,    0,  -35, -147,   21,  516,    0,    0,   32,  392,
  374,    0,    0,    0,   95,   75,   45,  291,    0,    0,
    0,    0,   78,    0,  568,    0,  329,  516,    0,   55,
    0,   55,  145,  -33,   74,   55, -161,  659,   47,  579,
  182, -165, -138,  -43,   73,    0, -150, -187, -145, -115,
   -2,  102,    0,    0,   32,  628,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -17,  110,  120, -147, -147,    0,    0,    0, -101,    0,
    0,  124,  601,  191,  516,    0,    0,  125,  549,    0,
   74,  -27,  106,  113,    0,    0,  516,  516, -102,   -3,
  516,  -98,  516,  516,  516,    0,    0,    0,    0,    0,
    0,  516,  131,    0,    0,    0,    0, -229,    0,  516,
  640,  516,  479,    0, -219,    0, -150,    0,    0,  -96,
    0,    0,  117,    0,    0,  -34,    0,  516,  534,  135,
   13,  620,    0,  516,   28,  516,    0,    0,    0,    0,
    0,    0,    0,    0,  310,  310,  212, -161,  310,   55,
   55,  659,   74,    0,    0,    0,   94,  644,   98,  132,
    0,  219,    0,    0,    0,  310,    0,    0,  -20, -147,
  119,    0,   29,  136,  -23,  516,  138,  558,   33,   36,
  140,   38,  467,    0,  -94,    0,  -91,  232,  -76,  -70,
  -50,  -37,  -42,  155,  161,    0,    0,  -66,  -15,  174,
  354,    0,  164,  467,  467,  115,   43,  467,  365,    2,
  369,  118,  467,  384,  317,    0,    0,    0, -181,    0,
    0,  408,  411,  414,   35,  417,  419,    0,  406,   19,
  409,  415,  192,  337,  352,  364,  371,  420,  390,  203,
  213,    3,  221,  222,  407,  224,  412,  416,    0,  247,
  231,  231,  231,  -38,  231,  250,  231,  231,  252,  252,
  -40,  252,  252,    0,  472,  480,  484,  259,  496,  433,
  499,    0,    0,    0, -234,    0,    0,  501,    0,    0,
    0,  425,    0,  263,  437,    0,    0,    0, -191,    0,
    0,  502,    0,    0,  287,    0,    0, -108,    0,    0,
    0,  516,  516,  516,  622,    0,  516,  516,  506,  452,
  516,    0,    0,  516,    0,    0,    0,  426,    0,  274,
    0,    0,    0,    0,  231,    0,  -29,    0,    0,   51,
   53,   60,  631,   63,   65,   67,  516,  518,   82,   92,
    0,    0,    0,    0,    0,  507,  509,  510,  512,    9,
  523,  148,  536,   93,  516,  552,  553,  285,  290,  339,
  391,  399,   80,  402,  418,  432,  570,   97,  435,  436,
    0,    0,    0,    0,    0,    0,  427,    0,    0,    0,
  453,  633,    0,    0,    0,    0,  454,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  727,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  658,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  710,    0,    0,    0,    0,    0,    0,  442,
    0,  470,    0,    0,  542,  595,  -28,   40,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  737,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  476,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  256,    0,  722,
  734,  139,  681,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  488,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  493,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  675,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   22,   49,    0,   18,   -9,    0,  -14,    6,    0,    0,
    0,  -16,    0,    0,  723,    0,  716,  421,  744,    0,
    0,  672,   27,  623,    0,    0,    0,  394,    0,  -12,
    0,   16,  674,    0,    0,    0,  -54,    0,    0,    0,
    0,    0,    0,   15,    0,    0,  475,    0,  704,    0,
    0,  621,  626,    0,  -47,
};
final static int YYTABLESIZE=1003;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         69,
   69,   69,  339,   58,  111,  220,   69,  142,   46,   84,
   81,   98,  159,  188,  119,  160,  275,  256,  348,  249,
  136,  362,   24,  172,   48,  279,  205,   88,  206,   69,
  159,   70,   72,  166,   57,  255,  213,  197,  170,   45,
  363,   48,  292,   98,   74,  124,   96,   58,   69,  413,
   46,   69,  131,  227,  163,   47,   69,  112,  113,  311,
  291,  325,   53,   69,  373,   79,   98,  412,  231,  253,
   49,  115,   94,  261,   48,  305,  262,  310,  264,  306,
  161,  114,  335,  288,   46,    2,  163,  154,  299,  193,
  194,  396,  157,  397,  165,   70,  137,  158,  161,  140,
  398,  138,  300,  401,  145,  402,   69,  403,   69,   98,
  214,   46,  215,   48,  125,   44,  144,  129,  143,  159,
   69,   69,  406,  163,   69,  173,   69,   69,   69,    3,
    4,  162,  407,  417,   46,   69,  167,  432,  427,  203,
  168,  169,  171,   69,   69,   69,  190,  378,  345,  181,
  174,  185,  241,  192,   46,  177,  244,  218,  200,  201,
  175,   69,   69,  178,  186,   69,  195,   69,  211,   69,
  199,  204,  216,  286,  226,  266,  294,  252,  267,  162,
  234,  234,  234,   23,  234,  139,  207,  209,  210,   68,
  245,   69,  100,  270,  254,  102,  258,  162,  263,  271,
  104,  234,   46,  278,  223,  225,  415,  272,  229,   69,
  230,   69,  232,   82,  281,  274,  345,  247,  265,   83,
  273,   46,  283,  234,  141,   80,   82,  117,  187,  159,
  184,   17,   83,  141,  243,  335,   18,  219,  159,   19,
  159,    3,    4,  141,  284,  285,  287,   21,  289,   22,
   87,   46,  257,  295,  260,  298,    3,    4,   46,    3,
    4,    3,    4,  141,  141,  196,   54,   16,  141,   98,
   98,   46,   98,   17,   98,  141,  318,  324,   18,  141,
   98,   19,    2,   98,   55,  234,   46,    3,    4,   21,
   56,   22,  304,    5,  141,  141,  160,  161,  357,  141,
  126,   16,  141,   98,  141,  161,  161,   17,  161,  141,
  360,  153,   18,   46,  160,   19,    2,  141,   55,  141,
  369,    3,    4,   21,   56,   22,  141,    5,   80,  141,
   46,  141,   43,  141,   17,   69,   69,   69,   69,   18,
   69,   69,   19,   68,   69,   98,   97,   69,  141,   46,
   21,   80,   22,  106,  426,  369,   46,   17,  141,  141,
  141,  189,   18,  141,  141,   19,   69,  122,  191,  135,
   69,   80,  217,   21,  123,   22,   46,   17,  380,  381,
  382,  384,   18,  385,  386,   19,  216,  389,   69,   99,
  390,   46,  101,   21,  282,   22,  162,  103,  141,  108,
   16,   63,   64,   46,  162,  162,   17,  162,   66,  400,
   46,   18,  276,  404,   19,    2,  216,   20,  277,   16,
    3,    4,   21,  290,   22,   17,    5,  293,  110,   46,
   18,  418,  121,   19,    2,  119,   20,  155,   80,    3,
    4,   21,  296,   22,   17,    5,   46,   80,  301,   18,
  118,  302,   19,   17,  303,   46,  156,  307,   18,  308,
   21,   19,   22,  182,  309,  183,  314,  312,   80,   21,
  331,   22,   46,  313,   17,   80,   46,  322,  320,   18,
  238,   17,   19,  366,  392,  233,   18,  323,   80,   19,
   21,   46,   22,  246,   17,  326,  327,   21,  329,   18,
   64,  268,   19,   80,  335,  233,   46,  342,  345,   17,
   21,  352,   22,  160,   18,   80,  333,   19,   46,  353,
  233,   17,  160,  354,  160,   21,   18,   22,   63,   19,
   80,  355,  367,  356,   61,  358,   17,   21,  361,   22,
  364,   18,  375,  376,   19,  387,   81,   80,  393,  368,
  105,   83,   21,   17,   22,   63,   64,  405,   18,  421,
   68,   19,   66,  128,  422,  408,   80,  409,  410,   21,
  411,   22,   17,   80,  224,    3,    4,   18,   68,   17,
   19,  414,  163,  233,   18,  132,  133,   19,   21,  135,
   22,  297,  134,   80,  416,   21,  107,   22,  259,   17,
  163,  163,   68,  163,   18,    3,    4,   19,   80,  315,
  419,  420,   68,  423,   17,   21,   67,   22,  129,   18,
   80,   68,   19,   68,  316,  109,   17,   80,  431,  120,
   21,   18,   22,   17,   19,  165,  317,  165,   18,  165,
  179,   19,   21,  319,   22,   68,   80,  116,  117,   21,
   73,   22,   17,  165,  165,   68,  165,   18,  180,  228,
   19,  383,  321,   80,   68,  424,   68,  330,   21,   17,
   22,  399,   80,  425,   18,   68,  428,   19,   17,  328,
  365,  391,  435,   18,   68,   21,   19,   22,   68,   80,
  332,  437,  429,   80,   21,   17,   22,   64,  208,   17,
   18,  104,  242,   19,   18,  359,  430,   19,   80,  433,
  434,   21,  368,   22,   17,   21,  104,   22,  150,   18,
  151,  164,   19,   80,  388,   63,    2,  436,  438,   17,
   21,   61,   22,  128,   18,   80,    5,   19,   90,  164,
  164,   17,  164,   81,   89,   21,   18,   22,   83,   19,
  174,  174,  174,   51,  174,  161,  174,   21,   90,   90,
  127,  198,  167,  394,  167,  377,  167,    0,  174,  174,
  202,  174,   63,   64,  166,    0,  166,    0,  166,   66,
  167,  167,   90,  167,  347,  349,  350,  351,    0,    0,
   63,   64,  166,  166,    0,  166,    0,   66,    0,  163,
  163,  163,  163,  163,    0,  132,  133,  163,  163,    0,
  163,    0,  134,    0,   63,   64,    0,    1,    0,    0,
    0,   66,  379,  130,   63,   64,   90,    0,    0,  176,
   90,   66,    2,   63,   64,   63,   64,    3,    4,   65,
   66,   65,   66,    5,    0,    0,    0,    0,    0,    0,
  165,    0,  165,  165,  165,  165,  165,   63,   64,    0,
  165,  165,    0,  165,   66,    0,    0,   63,   64,  237,
  239,    0,  240,    0,   66,    0,   63,   64,   63,   64,
    0,    0,    0,   66,   95,   66,    0,   63,   64,  248,
    0,    0,    0,    0,   66,    0,   63,   64,    0,    2,
   63,   64,    0,   66,    3,    4,    0,   66,    0,    0,
    5,  269,    0,  104,  104,    0,    0,  146,  147,  148,
  149,    0,    0,    0,  337,  338,  340,  341,    0,  343,
  344,    0,    0,    0,  250,  251,    0,    0,  164,  164,
  164,  164,  164,    0,    0,    0,  164,  164,    0,  164,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  374,    0,    0,  280,  174,    0,  174,  174,  174,
  174,  174,    0,  334,    0,  174,  174,  167,  174,  167,
  167,  167,  167,  167,    0,    0,    0,  167,  167,  166,
  167,  166,  166,  166,  166,  166,    0,  395,    0,  166,
  166,    0,  166,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         16,
   17,   18,   41,   13,   40,   40,   23,   41,   40,   40,
   20,   26,   41,   41,   44,   59,   59,   41,   59,   40,
   68,  256,    1,   41,    7,   41,  256,   22,  258,   46,
   59,   16,   17,   88,   13,   59,  256,   41,   41,  257,
  275,   24,   41,   58,   18,   55,   25,   57,   65,   41,
   40,   68,   65,   41,  274,    7,   73,   43,   44,   41,
   59,   59,   59,   80,  256,   40,   81,   59,   41,   41,
  257,   40,   24,   41,   57,   41,   41,   59,   41,   45,
   41,   61,  274,   41,   40,  272,  274,   41,  270,  137,
  138,   41,  258,   41,  282,   80,   42,  263,   59,   73,
   41,   47,  284,   41,  266,   41,  123,   41,  125,  124,
  165,   40,  167,   96,   40,   40,   43,   40,   45,  258,
  137,  138,   41,  274,  141,  111,  143,  144,  145,  277,
  278,   59,   41,   41,   40,  152,  282,   41,   59,  152,
  256,  257,   41,  160,  161,  162,   41,  256,  257,  123,
   41,  125,   59,   41,   40,  257,   59,   41,  143,  144,
   41,  178,  179,   40,   40,  182,  269,  184,  163,  186,
  269,   41,  269,   59,   40,  270,   59,   59,  270,   41,
  195,  196,  197,   40,  199,   41,  160,  161,  162,   45,
   59,  208,   59,  270,   59,   59,   59,   59,   59,  270,
   59,  216,   40,  270,  178,  179,   59,  258,  182,  226,
  184,  228,  186,  257,   41,  258,  257,  212,  233,  263,
  258,   40,   59,  238,  267,  257,  257,  257,  256,  258,
   40,  263,  263,  267,  208,  274,  268,  272,  267,  271,
  269,  277,  278,  267,  254,  255,  256,  279,  258,  281,
  282,   40,  226,  263,  228,  265,  277,  278,   40,  277,
  278,  277,  278,  267,  267,  269,  256,  257,  267,  284,
  285,   40,  287,  263,  289,  267,  286,  275,  268,  267,
  295,  271,  272,  298,  274,  300,   40,  277,  278,  279,
  280,  281,  258,  283,  267,  267,   41,  258,   40,  267,
  256,  257,  267,  318,  267,  266,  267,  263,  269,  267,
  320,  265,  268,   40,   59,  271,  272,  267,  274,  267,
  335,  277,  278,  279,  280,  281,  267,  283,  257,  267,
   40,  267,  257,  267,  263,  352,  353,  354,  355,  268,
  357,  358,  271,   45,  361,  360,  275,  364,  267,   40,
  279,  257,  281,   59,  275,  370,   40,  263,  267,  267,
  267,  256,  268,  267,  267,  271,  383,  273,  256,   41,
  387,  257,  256,  279,  280,  281,   40,  263,  352,  353,
  354,  355,  268,  357,  358,  271,  269,  361,  405,  256,
  364,   40,  256,  279,   41,  281,  258,  256,  267,   59,
  257,  257,  258,   40,  266,  267,  263,  269,  264,  383,
   40,  268,  258,  387,  271,  272,  269,  274,  258,  257,
  277,  278,  279,   59,  281,  263,  283,   59,   59,   40,
  268,  405,   59,  271,  272,   44,  274,  256,  257,  277,
  278,  279,   59,  281,  263,  283,   40,  257,   41,  268,
   59,   41,  271,  263,   41,   40,  275,   41,  268,   41,
  279,  271,  281,  273,   59,  275,  275,   59,  257,  279,
   59,  281,   40,   59,  263,  257,   40,  275,   59,  268,
  269,  263,  271,   59,   59,  274,  268,  275,  257,  271,
  279,   40,  281,  275,  263,  275,  275,  279,  275,  268,
   59,  270,  271,  257,  274,  274,   40,  258,  257,  263,
  279,   40,  281,  258,  268,  257,  270,  271,   40,   40,
  274,  263,  267,   40,  269,  279,  268,  281,   59,  271,
  257,  273,  270,  275,   59,   40,  263,  279,   40,  281,
   40,  268,   41,  257,  271,   40,   59,  257,  275,  276,
  256,   59,  279,  263,  281,  257,  258,   40,  268,  275,
   45,  271,  264,  273,  275,   59,  257,   59,   59,  279,
   59,  281,  263,  257,   41,  277,  278,  268,   45,  263,
  271,   59,   41,  274,  268,  257,  258,  271,  279,   41,
  281,  275,  264,  257,   59,  279,  256,  281,   41,  263,
   59,   60,   45,   62,  268,  277,  278,  271,  257,  273,
   59,   59,   45,  275,  263,  279,   40,  281,   40,  268,
  257,   45,  271,   45,  273,  256,  263,  257,   59,  256,
  279,  268,  281,  263,  271,   41,  273,   43,  268,   45,
   40,  271,  279,  273,  281,   45,  257,  256,  257,  279,
   40,  281,  263,   59,   60,   45,   62,  268,   58,   40,
  271,   40,  273,  257,   45,  275,   45,  256,  279,  263,
  281,   41,  257,  275,  268,   45,  275,  271,  263,  273,
  256,  256,  256,  268,   45,  279,  271,  281,   45,  257,
  275,   59,  275,  257,  279,  263,  281,  256,   59,  263,
  268,   44,   59,  271,  268,  273,  275,  271,  257,  275,
  275,  279,  276,  281,  263,  279,   59,  281,   60,  268,
   62,   41,  271,  257,  273,  256,    0,  275,  275,  263,
  279,  256,  281,   59,  268,  257,    0,  271,   23,   59,
   60,  263,   62,  256,   22,  279,  268,  281,  256,  271,
   41,   42,   43,   10,   45,   84,   47,  279,   43,   44,
   57,  141,   41,  370,   43,  345,   45,   -1,   59,   60,
  145,   62,  257,  258,   41,   -1,   43,   -1,   45,  264,
   59,   60,   67,   62,  310,  311,  312,  313,   -1,   -1,
  257,  258,   59,   60,   -1,   62,   -1,  264,   -1,  258,
  259,  260,  261,  262,   -1,  257,  258,  266,  267,   -1,
  269,   -1,  264,   -1,  257,  258,   -1,  257,   -1,   -1,
   -1,  264,  348,  256,  257,  258,  111,   -1,   -1,  114,
  115,  264,  272,  257,  258,  257,  258,  277,  278,  263,
  264,  263,  264,  283,   -1,   -1,   -1,   -1,   -1,   -1,
  256,   -1,  258,  259,  260,  261,  262,  257,  258,   -1,
  266,  267,   -1,  269,  264,   -1,   -1,  257,  258,  196,
  197,   -1,  199,   -1,  264,   -1,  257,  258,  257,  258,
   -1,   -1,   -1,  264,  257,  264,   -1,  257,  258,  216,
   -1,   -1,   -1,   -1,  264,   -1,  257,  258,   -1,  272,
  257,  258,   -1,  264,  277,  278,   -1,  264,   -1,   -1,
  283,  238,   -1,  256,  257,   -1,   -1,  259,  260,  261,
  262,   -1,   -1,   -1,  302,  303,  304,  305,   -1,  307,
  308,   -1,   -1,   -1,  219,  220,   -1,   -1,  258,  259,
  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,  269,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  339,   -1,   -1,  249,  256,   -1,  258,  259,  260,
  261,  262,   -1,  300,   -1,  266,  267,  256,  269,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
  269,  258,  259,  260,  261,  262,   -1,  375,   -1,  266,
  267,   -1,  269,
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
"control : REPEAT '(' asignacion_repeat ';' condicion ';' '-' CTE_ULONG ')' bloque_repeat",
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

//#line 611 "Gramatica.y"

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
//#line 791 "Parser.java"
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
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        System.out.println("Entro a repeat 1");
        if((val_peek(6).sval != null) && (val_peek(4).sval != null)){
             System.out.println("Entro a if 1");
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
case 39:
//#line 125 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
                 System.out.println("Entro a repeat 2");
                 System.out.println("asignacion: " + val_peek(7).sval);
                    System.out.println("condicion: " + val_peek(3).sval);
                if((val_peek(7).sval != null) && (val_peek(5).sval != null)){
                   System.out.println("Entro a if 2");

                  Terceto t = new Terceto("-", val_peek(7).sval, val_peek(3).sval);
                  t.setTipo("ULONG");
                  adminTercetos.agregarTerceto(t);
                  t = new Terceto("BI", null, null);
                  adminTercetos.agregarTerceto(t);
                  adminTercetos.desapilar(); /*para completar BF*/
                  adminTercetos.desapilarRepeat();
              }
          }
break;
case 41:
//#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 42:
//#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 43:
//#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 44:
//#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 45:
//#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 46:
//#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 47:
//#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 48:
//#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 49:
//#line 154 "Gramatica.y"
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
case 50:
//#line 171 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 51:
//#line 174 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 52:
//#line 175 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 53:
//#line 176 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 60:
//#line 191 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 61:
//#line 194 "Gramatica.y"
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
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 64:
//#line 220 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 65:
//#line 221 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 72:
//#line 235 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 73:
//#line 236 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 74:
//#line 237 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 75:
//#line 240 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 76:
//#line 241 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 77:
//#line 242 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 78:
//#line 243 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 79:
//#line 244 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 80:
//#line 245 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 81:
//#line 246 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 82:
//#line 247 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 83:
//#line 248 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 84:
//#line 252 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");}
break;
case 85:
//#line 253 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");}
break;
case 86:
//#line 257 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 87:
//#line 258 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 88:
//#line 259 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");}
break;
case 90:
//#line 263 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 91:
//#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 92:
//#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 93:
//#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 96:
//#line 275 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 97:
//#line 276 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 98:
//#line 277 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 99:
//#line 278 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 103:
//#line 288 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 104:
//#line 293 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 106:
//#line 301 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 107:
//#line 305 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(0).sval +"'" );
            if(val_peek(1).sval != null){    /*si se declaró bien*/
                ambito = ambito.substring(0,ambito.lastIndexOf("@"));
            }
         }
break;
case 109:
//#line 313 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 110:
//#line 316 "Gramatica.y"
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
case 112:
//#line 337 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 113:
//#line 338 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 114:
//#line 339 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 115:
//#line 340 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 116:
//#line 341 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 117:
//#line 344 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval);
                ds.setUso("Parametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);

                }
break;
case 119:
//#line 355 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 122:
//#line 363 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 123:
//#line 364 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 124:
//#line 365 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 125:
//#line 366 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 126:
//#line 367 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 127:
//#line 368 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 132:
//#line 381 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 137:
//#line 391 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 138:
//#line 392 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 139:
//#line 393 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 140:
//#line 394 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 141:
//#line 395 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 142:
//#line 396 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 143:
//#line 397 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 144:
//#line 398 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 145:
//#line 399 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 146:
//#line 401 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 147:
//#line 402 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 148:
//#line 403 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 149:
//#line 404 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 150:
//#line 405 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 151:
//#line 406 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 152:
//#line 407 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 153:
//#line 408 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 154:
//#line 409 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 155:
//#line 410 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 156:
//#line 411 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 157:
//#line 412 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 158:
//#line 413 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 159:
//#line 419 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 160:
//#line 420 "Gramatica.y"
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
case 161:
//#line 442 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 162:
//#line 443 "Gramatica.y"
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
case 163:
//#line 464 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 164:
//#line 465 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");

		                            Operando op1 = (Operando)val_peek(2).obj;
                                    Operando op2 = (Operando)val_peek(0).obj;
                                    if(op1 != null && op2 !=null){
                                        if (op1.getTipo().equals(op2.getTipo())){
                                            Terceto t = new Terceto(val_peek(1).sval, op1.getValor(), op2.getValor());
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
case 165:
//#line 488 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 166:
//#line 491 "Gramatica.y"
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
case 167:
//#line 511 "Gramatica.y"
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
case 168:
//#line 533 "Gramatica.y"
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
case 169:
//#line 553 "Gramatica.y"
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
case 170:
//#line 573 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 171:
//#line 577 "Gramatica.y"
{ if (chequearFactorNegado()){
                        Operando operando = (Operando) val_peek(0).obj;
                        yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                       }
                        }
break;
case 172:
//#line 582 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 173:
//#line 585 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 174:
//#line 588 "Gramatica.y"
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
case 176:
//#line 601 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 177:
//#line 602 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 178:
//#line 603 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 179:
//#line 604 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 180:
//#line 605 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 181:
//#line 606 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 1719 "Parser.java"
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
