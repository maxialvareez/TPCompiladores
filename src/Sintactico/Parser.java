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
    0,    0,    0,    3,    3,    3,    1,    1,    2,    2,
    5,    5,    6,    6,    6,    6,    8,    8,    8,    8,
    8,    8,   14,   14,   14,   14,   14,    7,    7,    7,
   16,    4,    4,    4,    4,   21,   21,   17,   17,    9,
    9,   25,   25,   25,   25,   25,   25,   25,   25,   22,
   22,   26,   26,   26,   23,   24,   28,   28,   29,   29,
   29,   30,   13,   13,   32,   32,   32,   10,   36,   10,
   10,   34,   34,   39,   35,   35,   35,   40,   40,   40,
   37,   37,   37,   37,   37,   37,   37,   11,   11,   12,
   12,   12,   12,   41,   41,   41,   41,   15,   15,   42,
   42,   45,   44,   44,   44,   43,   46,   46,   18,   18,
   18,   47,   19,   19,   50,   48,   48,   52,   52,   52,
   52,   52,   52,   51,   51,   53,   20,   49,   49,   49,
   55,   54,   54,   54,   54,   54,   57,   57,   57,   57,
   57,   57,   57,   57,   57,   57,   57,   57,   57,   57,
   57,   57,   57,   56,   56,   58,   58,   58,   58,   58,
   38,   59,   59,   60,   60,   27,   27,   31,   31,   31,
   33,   33,   33,   62,   62,   62,   62,   62,   61,   61,
   61,   61,   61,   61,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    3,    1,    2,    3,    1,
    1,    2,    2,    3,    4,    4,    2,    2,    2,    2,
    2,    1,    2,    2,    2,    2,    2,    1,    2,    1,
    2,    3,    2,    6,    1,    3,    2,    1,    1,    9,
    1,    8,    8,    8,    8,    8,    8,    8,    9,    3,
    1,    2,    2,    3,    1,    3,    1,    2,    1,    2,
    1,    2,    3,    1,    2,    2,    3,    5,    0,    8,
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
    0,    0,   38,   39,    0,    0,    0,    3,    7,    0,
    0,   35,    0,  114,  117,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   10,   11,   28,    0,
    0,    0,    0,    0,   22,    0,   30,   41,   64,    0,
   71,   73,   93,    0,   99,  101,    0,    0,    4,    8,
    0,    0,    0,  111,   37,   33,  115,    0,    0,    0,
    0,    0,  113,  129,  130,    0,  136,  155,    0,  176,
    0,  175,    0,    0,  178,    0,  173,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   51,  102,  100,
    0,  164,    0,    0,    0,    0,    0,    6,    1,    0,
   13,   12,   23,   17,   24,   18,   25,   19,   27,   20,
   26,   21,   31,   29,    0,    0,    0,  103,    0,    0,
    0,    0,    0,   36,  112,   32,    0,    0,    0,    0,
    0,    0,    0,  131,  128,    0,    0,   67,    0,    0,
    0,    0,   94,  174,    0,    0,    0,   75,    0,   77,
    0,    0,    0,   89,    0,   14,    9,    0,   53,    0,
   52,    0,    0,    0,    0,  182,  183,  181,  184,    0,
    0,  179,  180,    0,   74,   72,    0,    0,    0,  107,
    0,  104,   98,    0,    0,  125,    0,    0,    0,    0,
    0,  109,    0,    0,  143,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   97,   92,   95,   90,   96,   91,
  171,  172,    0,   82,   84,    0,   83,   88,   15,   16,
   54,   50,    0,   55,    0,    0,    0,  105,    0,    0,
    0,    0,  165,   81,  106,  108,  126,  124,  118,    0,
    0,  119,  122,    0,  121,  120,    0,    0,    0,    0,
    0,    0,    0,  157,  159,    0,  158,  156,    0,    0,
    0,    0,   85,   68,    0,    0,    0,    0,    0,    0,
    0,    0,   34,  123,  116,    0,    0,    0,    0,    0,
    0,    0,  153,    0,    0,  160,  154,    0,    0,   80,
   78,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   79,   76,   86,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  132,  140,  141,
  142,    0,  139,  138,    0,    0,    0,    0,    0,    0,
  137,    0,   87,   70,    0,   43,   45,   46,    0,   48,
   47,   44,   42,    0,  144,  133,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   59,    0,   57,   61,   49,
   40,    0,  135,  149,  150,  151,    0,  148,  147,  146,
  145,   62,   60,   56,   58,  110,    0,  152,  134,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   53,   11,  241,
   12,   87,  223,  346,   38,   88,   92,  367,  368,  369,
   93,   39,   94,   40,  149,  266,   41,   95,   42,  150,
   43,   44,  118,   45,   46,  181,   54,   13,   63,   14,
  185,   15,  186,   64,   65,   66,   67,   68,   96,   97,
  174,   77,
};
final static short yysindex[] = {                       304,
   88, -239,    0,    0, -216,    0,   88,    0,    0, -160,
  -44,    0,  -34,    0,    0,  159,  414,  -37,   28,  107,
   29,  210,  414,   46,  383,  219,    0,    0,    0,  -43,
   55,   57,   74,   79,    0,   97,    0,    0,    0, -174,
    0,    0,    0, -178,    0,    0,   31,   30,    0,    0,
   80,  -30,    5,    0,    0,    0,    0,  -15,   -2,  105,
   27,  238,    0,    0,    0,   72,    0,    0,  126,    0,
  380,    0,  119,  414,    0,  102,    0,  102,  242,  139,
  -40,  107,   65, -128, -116,  -48,   93,    0,    0,    0,
 -123,    0,  558,  102,    1, -100,  -96,    0,    0,  383,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  242,  391, -184,    0, -230, -230,
 -230,  -23, -230,    0,    0,    0,  -74,  141,    6,  257,
  414,  310,  414,    0,    0,  146,  371,    0,  103,    4,
   32,   33,    0,    0,  414,  414,  371,    0,  -77,    0,
  158,  -75,  155,    0,  272,    0,    0,  -72,    0, -139,
    0,  414,  487,  414,  -64,    0,    0,    0,    0,  414,
  414,    0,    0,  414,    0,    0,  414,  414,  -69,    0,
  372,    0,    0,  -68,  156,    0,  -70,  173,   -7,  178,
  293,    0,  414,  457,    0,  414,  291,  292,  322,  477,
  352,  356,  414,  312,    0,    0,    0,    0,    0,    0,
    0,    0,  321,    0,    0,  124,    0,    0,    0,    0,
    0,    0,  340,    0,  499,  341,  345,    0,  102,  102,
  103,  -96,    0,    0,    0,    0,    0,    0,    0,  361,
  347,    0,    0,   35,    0,    0,  368,  485,  373,   37,
  379,  167,  387,    0,    0,   38,    0,    0,  392,  394,
   98,  342,    0,    0,  152,  160,  185,  187,  -50,  191,
  195, -230,    0,    0,    0,  398,  401,   39,  403,  411,
  414,  467,    0,  414,  414,    0,    0,  412,  414,    0,
    0,  112,  184,  242,  410,  434,  436,  -28,  438,  439,
  442,  209,  211,  213,  -47,  217,  218,  455,  496,  463,
   40,  474,  233,  483,    0,    0,    0,  271,  261,  259,
  259,  259,  -39,  259,  259,  259,  475,    0,    0,    0,
    0, -198,    0,    0,  480,  486,   42,  491,  493,  497,
    0,  498,    0,    0,  351,    0,    0,    0, -172,    0,
    0,    0,    0,  285,    0,    0,  302,  311,  313,  -24,
  315,  319,  320,  323,  116,    0,  193,    0,    0,    0,
    0,  309,    0,    0,    0,    0, -193,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -16,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  579,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   82,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  622,    0,
    0,    0,    0,    0,    0,  117,    0,  118,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   91,  634,    0,   -4,  -36,    0,    0,  597,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  133,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  325,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  646,  658,
  444,   59,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  335,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  335,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  547,    0,    0,
};
final static short yygindex[] = {                         0,
  138,   63,    0,  666,  713,    0,  -26,   -1,    0,    0,
    0,   -9,    0,    0,  585,    0,  -90,  239,    0,    0,
    0,  526, -137, -215,    0,    0, -112,    0,  248,    0,
  -31,    0,    3,  598,  -76,    0,    0,  651,    0,    0,
    0,    0,  -73,    0,    0,    0,    0,    0,    0,    0,
  -62,    0,    0,  563,    0,  567,    0,    0,    0,  449,
    0,  -52,
};
final static int YYTABLESIZE=960;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        102,
  154,  349,   23,  152,  162,   23,   75,   75,  298,  123,
  162,  332,  324,   75,   56,  104,  189,   47,   76,   78,
   90,  144,  162,   60,   23,  226,  227,  127,  184,  187,
  184,  184,  184,  243,  377,  102,  161,  131,  179,  139,
   48,  176,   60,  183,  206,  196,    3,    4,  127,  224,
  224,  224,  148,  148,  161,  132,  102,  355,  188,  190,
  191,   75,  388,  126,   75,  233,   23,   81,   86,   49,
  119,  182,  208,  210,  216,  275,  356,  280,  287,  305,
  339,  389,  360,  370,   60,   23,   99,  269,  148,  116,
  120,  228,  211,  212,  115,  116,   51,  304,  184,  163,
  359,  345,  102,  117,   23,  347,  348,  350,  351,  352,
  353,   52,  224,  106,  180,  108,  221,  163,  222,  121,
  213,   75,   75,   75,  148,  110,  244,   23,  102,  159,
  137,  167,  110,  371,  160,   75,   75,  112,   24,  265,
  110,  161,  231,  145,  133,  170,   23,  171,  146,  167,
   61,  164,   75,   75,   75,  114,  291,   82,  165,  143,
   75,   75,  100,   23,   75,   73,  177,   75,   75,  178,
  316,  102,  229,  230,  383,   66,   65,  102,   23,  236,
  193,  301,  192,   75,   75,  203,   75,  237,  238,  148,
   75,   63,  214,   75,  217,  218,  239,   23,   73,    2,
  234,  240,  220,   74,    3,    4,  284,  297,   84,  116,
    5,   55,  103,  242,   85,   75,  318,  319,  245,  162,
  158,   57,   16,   23,  153,  102,  122,  331,   17,  323,
  162,   79,   23,   18,  345,  102,   19,    2,   75,   58,
  125,   16,    3,    4,   21,   59,   22,   17,    5,   23,
  376,  161,   18,    3,    4,   19,  175,  128,   23,  205,
  124,  125,   16,   21,   59,   22,  148,  148,   17,    3,
    4,   75,   75,   18,   75,   75,   19,   23,  194,   75,
  195,   23,  134,   16,   21,   84,   22,  207,  209,   17,
  274,   85,  175,  286,   18,  175,   23,   19,    2,   75,
   58,   98,   16,    3,    4,   21,   59,   22,   17,    5,
  105,   23,  107,   18,  163,  197,   19,    2,  366,   20,
  156,   16,    3,    4,   21,  163,   22,   17,    5,  109,
   23,   23,   18,  246,  111,   19,    2,  110,  110,  157,
  366,    3,    4,   21,   16,   22,  167,    5,  167,  200,
   17,   23,  113,  290,   74,   18,  167,  167,   19,    2,
   23,   20,  254,   16,    3,    4,   21,  315,   22,   17,
    5,  382,   66,   65,   18,  140,  141,   19,    2,  263,
   16,   23,  142,    3,    4,   21,   17,   22,   63,    5,
   23,   18,  257,  264,   19,   16,  258,  147,  267,  270,
  272,   17,   21,  271,   22,  273,   18,  151,  276,   19,
   23,   23,  147,  279,   16,   69,   70,   21,  281,   22,
   17,   71,   72,   16,   74,   18,  285,  215,   19,   17,
   23,  147,  288,  289,   18,  293,   21,   19,   22,  282,
   16,  283,  295,  294,  296,   21,   17,   22,  299,   16,
  320,   18,  300,  317,   19,   17,  302,  147,   74,  303,
   18,  306,   21,   19,   22,   89,   16,  384,  365,  307,
  313,   21,   17,   22,  321,   16,  322,   18,  325,  326,
   19,   17,  327,  328,  166,  329,   18,  330,   21,   19,
   22,  333,  334,  101,   16,  335,  248,   21,   16,   22,
   17,   74,  166,  338,   17,   18,  309,  341,   19,   18,
  136,   74,   19,   16,  340,  147,   21,  255,   22,   17,
   21,   74,   22,  342,   18,  277,  343,   19,   16,   74,
  344,   74,  345,  354,   17,   21,  336,   22,  357,   18,
   74,  372,   19,   74,  358,  225,  219,   16,   16,  361,
   21,  362,   22,   17,   17,  363,  364,  268,   18,   18,
    1,   19,   19,  251,  253,  386,   69,   70,   16,   21,
   21,   22,   22,   72,   17,    2,  373,   16,    2,   18,
    3,    4,   19,   17,  260,  374,    5,  375,   18,  378,
   21,   19,   22,  379,  380,  261,    5,  381,   16,   21,
  170,   22,  171,   72,   17,  127,   91,   16,   69,   18,
  387,  163,   19,   17,  385,   80,  292,  172,   18,  173,
   21,   19,   22,  135,  130,  232,  365,   16,   16,   21,
    0,   22,    0,   17,   17,  138,   69,   70,   18,   18,
    0,   19,   19,   72,    0,    0,  235,   16,    0,   21,
   21,   22,    0,   17,    2,    0,    0,    0,   18,    3,
    4,   19,  177,  177,  177,    5,  177,    0,  177,   21,
   69,   70,   50,    0,  168,    0,  168,   72,  168,    0,
  177,  177,    0,  177,    0,    0,  169,    0,  169,   50,
  169,    0,  168,  168,    0,  168,    0,    0,  170,  166,
  170,  166,  170,    0,  169,  169,    0,  169,    0,  166,
  166,    0,    0,   69,   70,    0,  170,  170,    0,  170,
   72,    0,    0,   69,   70,   62,   50,    0,    0,    0,
   72,    0,   83,   69,   70,    0,    0,    0,    0,    0,
   72,   69,   70,   69,   70,    0,    0,   50,   72,    0,
   72,    0,   69,   70,    0,   69,   70,    0,    0,   72,
    0,    0,   72,    0,    0,   50,    0,    0,    0,    0,
  129,    0,    0,   62,    0,    0,    0,    0,    0,    0,
    0,  199,  201,  202,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  155,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  166,  167,  168,  169,
    0,    0,    0,   50,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  198,  247,  249,    0,  250,    0,    0,  204,
  256,    0,    0,  259,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  177,    0,  177,
  177,  177,  177,  177,    0,    0,    0,  177,  177,  168,
    0,  168,  168,  168,  168,  168,    0,    0,  278,  168,
  168,  169,    0,  169,  169,  169,  169,  169,    0,  252,
    0,  169,  169,  170,    0,  170,  170,  170,  170,  170,
    0,    0,    0,  170,  170,  262,    0,    0,    0,    0,
    0,  308,  310,    0,  311,  312,    0,    0,    0,  314,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  337,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         26,
   41,   41,   40,   80,   41,   40,   16,   17,   59,   40,
   59,   59,   41,   23,   59,   59,   40,  257,   16,   17,
   22,   74,   59,   58,   40,  163,  164,   44,  119,  120,
  121,  122,  123,   41,   59,   62,   41,   40,  115,   71,
  257,   41,   58,  117,   41,   40,  277,  278,   44,  162,
  163,  164,   79,   80,   59,   58,   83,  256,  121,  122,
  123,   71,  256,   59,   74,  178,   40,   40,   40,    7,
   40,  256,   41,   41,  151,   41,  275,   41,   41,   41,
   41,  275,   41,  256,   58,   40,   24,  225,  115,  274,
   61,  165,  145,  146,  269,  274,  257,   59,  189,   41,
   59,  274,  129,  282,   40,  321,  322,  323,  324,  325,
  326,  272,  225,   59,  116,   59,  256,   59,  258,   40,
  147,  131,  132,  133,  151,   44,  189,   40,  155,  258,
   59,   41,   59,  349,  263,  145,  146,   59,    1,  216,
   59,  258,  174,   42,   40,   43,   40,   45,   47,   59,
   13,   59,  162,  163,  164,   59,   59,   20,  282,   41,
  170,  171,   25,   40,  174,   40,  267,  177,  178,  266,
   59,  198,  170,  171,   59,   59,   59,  204,   40,  181,
   40,  272,  257,  193,  194,   40,  196,  256,  257,  216,
  200,   59,  270,  203,  270,   41,   41,   40,   40,  272,
  270,  272,  275,   45,  277,  278,   40,  258,  257,  274,
  283,  256,  256,   41,  263,  225,  293,  294,   41,  256,
   83,  256,  257,   40,  265,  252,  257,  275,  263,  258,
  267,  269,   40,  268,  274,  262,  271,  272,  248,  274,
  257,  257,  277,  278,  279,  280,  281,  263,  283,   40,
  275,  256,  268,  277,  278,  271,  256,  273,   40,  256,
  256,  257,  257,  279,  280,  281,  293,  294,  263,  277,
  278,  281,  282,  268,  284,  285,  271,   40,  273,  289,
  275,   40,  256,  257,  279,  257,  281,  256,  256,  263,
  256,  263,  256,  256,  268,  256,   40,  271,  272,  309,
  274,  256,  257,  277,  278,  279,  280,  281,  263,  283,
  256,   40,  256,  268,  256,   59,  271,  272,  345,  274,
  256,  257,  277,  278,  279,  267,  281,  263,  283,  256,
   40,   40,  268,   41,  256,  271,  272,  256,  257,  275,
  367,  277,  278,  279,  257,  281,  256,  283,  258,   40,
  263,   40,  256,  256,   45,  268,  266,  267,  271,  272,
   40,  274,   41,  257,  277,  278,  279,  256,  281,  263,
  283,  256,  256,  256,  268,  257,  258,  271,  272,  256,
  257,   40,  264,  277,  278,  279,  263,  281,  256,  283,
   40,  268,   41,  270,  271,  257,   41,  274,   59,   59,
   40,  263,  279,   59,  281,   59,  268,  269,   41,  271,
   40,   40,  274,   41,  257,  257,  258,  279,   40,  281,
  263,  263,  264,  257,   45,  268,   40,  270,  271,  263,
   40,  274,   41,   40,  268,  284,  279,  271,  281,  273,
  257,  275,  258,  284,  258,  279,  263,  281,  258,  257,
   41,  268,  258,  270,  271,  263,   59,  274,   45,   59,
  268,   59,  279,  271,  281,  256,  257,  275,  276,   59,
   59,  279,  263,  281,   41,  257,   41,  268,   41,   41,
  271,  263,   41,  275,   41,  275,  268,  275,  279,  271,
  281,  275,  275,  275,  257,   41,   40,  279,  257,  281,
  263,   45,   59,   41,  263,  268,   40,  275,  271,  268,
  273,   45,  271,  257,   41,  274,  279,   41,  281,  263,
  279,   45,  281,   41,  268,   41,  256,  271,  257,   45,
  270,   45,  274,   59,  263,  279,   41,  281,   59,  268,
   45,  257,  271,   45,   59,   59,  275,  257,  257,   59,
  279,   59,  281,  263,  263,   59,   59,   59,  268,  268,
  257,  271,  271,  273,  273,  257,  257,  258,  257,  279,
  279,  281,  281,  264,  263,  272,  275,  257,    0,  268,
  277,  278,  271,  263,  273,  275,  283,  275,  268,  275,
  279,  271,  281,  275,  275,  275,    0,  275,  257,  279,
   43,  281,   45,  269,  263,   59,   22,  257,  284,  268,
  372,   86,  271,  263,  367,   18,  275,   60,  268,   62,
  279,  271,  281,   61,   58,  177,  276,  257,  257,  279,
   -1,  281,   -1,  263,  263,  256,  257,  258,  268,  268,
   -1,  271,  271,  264,   -1,   -1,  275,  257,   -1,  279,
  279,  281,   -1,  263,  272,   -1,   -1,   -1,  268,  277,
  278,  271,   41,   42,   43,  283,   45,   -1,   47,  279,
  257,  258,    7,   -1,   41,   -1,   43,  264,   45,   -1,
   59,   60,   -1,   62,   -1,   -1,   41,   -1,   43,   24,
   45,   -1,   59,   60,   -1,   62,   -1,   -1,   41,  256,
   43,  258,   45,   -1,   59,   60,   -1,   62,   -1,  266,
  267,   -1,   -1,  257,  258,   -1,   59,   60,   -1,   62,
  264,   -1,   -1,  257,  258,   13,   61,   -1,   -1,   -1,
  264,   -1,   20,  257,  258,   -1,   -1,   -1,   -1,   -1,
  264,  257,  258,  257,  258,   -1,   -1,   82,  264,   -1,
  264,   -1,  257,  258,   -1,  257,  258,   -1,   -1,  264,
   -1,   -1,  264,   -1,   -1,  100,   -1,   -1,   -1,   -1,
   58,   -1,   -1,   61,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  131,  132,  133,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   82,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  259,  260,  261,  262,
   -1,   -1,   -1,  158,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  130,  193,  194,   -1,  196,   -1,   -1,  137,
  200,   -1,   -1,  203,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
   -1,  258,  259,  260,  261,  262,   -1,   -1,  248,  266,
  267,  256,   -1,  258,  259,  260,  261,  262,   -1,  197,
   -1,  266,  267,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  213,   -1,   -1,   -1,   -1,
   -1,  281,  282,   -1,  284,  285,   -1,   -1,   -1,  289,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  309,
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
"sentencia_ejecutable : asignacion ';'",
"sentencia_ejecutable : error_ejecutable",
"error_ejecutable : control error",
"error_ejecutable : seleccion error",
"error_ejecutable : impresion error",
"error_ejecutable : asignacion error",
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
"asignacion : IDENTIFICADOR ASIGNACION expresion",
"asignacion : error_asignacion",
"error_asignacion : ASIGNACION termino",
"error_asignacion : IDENTIFICADOR termino",
"error_asignacion : IDENTIFICADOR ASIGNACION error",
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

//#line 953 "Gramatica.y"

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
//#line 771 "Parser.java"
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
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 5:
//#line 20 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 6:
//#line 21 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Falta el bloque de ejecución en el programa");}
break;
case 13:
//#line 40 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 14:
//#line 41 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 15:
//#line 42 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se pueden incluir declaraciones en el bloque ejecutable}");}
break;
case 16:
//#line 43 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se pueden incluir declaraciones en el bloque ejecutable}");}
break;
case 23:
//#line 56 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 57 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 25:
//#line 58 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 26:
//#line 59 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 27:
//#line 60 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 31:
//#line 68 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 32:
//#line 73 "Gramatica.y"
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
case 34:
//#line 97 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"'}");
    	        if (val_peek(1).sval.equals(val_peek(4).sval)){
    	            String nuevoLexema = val_peek(4).sval+ "@" + ambito;
    	            if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(val_peek(4).sval, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("TypeDef");
                        ds.setTipo(val_peek(2).sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                    }
                    else
                         Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] { La funcion "+ val_peek(4).sval +" ya esta declarada}");
    	        }
                else
                    Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {" + val_peek(5).sval + " y " + val_peek(1).sval +" deben tener el mismo nombre}");

    	        }
break;
case 36:
//#line 119 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 37:
//#line 120 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 38:
//#line 126 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 39:
//#line 128 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 40:
//#line 131 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if((val_peek(6).sval != null) && (val_peek(4).sval != null)){
            Terceto t = new Terceto("+", val_peek(6).sval, val_peek(2).sval);
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            t = new Terceto("BI", null, null);
            adminTercetos.agregarTerceto(t);
            adminTercetos.desapilar(); /*para completar BF*/
            adminTercetos.desapilarRepeat();
            t = new Terceto("Label"+adminTercetos.cantidadTercetos(),null,null);
            adminTercetos.agregarTerceto(t);
        }
        /*TODO ELSE*/
    }
break;
case 42:
//#line 149 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 43:
//#line 150 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 44:
//#line 151 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 152 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 46:
//#line 153 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 47:
//#line 154 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 48:
//#line 155 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 49:
//#line 156 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 50:
//#line 159 "Gramatica.y"
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
case 51:
//#line 179 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 52:
//#line 182 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 53:
//#line 183 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 54:
//#line 184 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 55:
//#line 188 "Gramatica.y"
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
case 62:
//#line 215 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 63:
//#line 218 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion de " + val_peek(2).sval +"}");
            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(2).sval, ambito);
            /*TODO MUCHOS ELSE*/
            if(ambitoVariable != null){
                String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                Operando op = (Operando)val_peek(0).obj;
                if(op != null && tipoIdentificador != null){
                     String valorOp = op.getValor();
                        if(valorOp!= null && !valorOp.contains("[")){
                            if(Main.tablaSimbolos.getDatos(valorOp).getUso() != null && Main.tablaSimbolos.getDatos(ambitoVariable).getUso() != null)
                                if(Main.tablaSimbolos.getDatos(valorOp).getUso().equals("NombreFuncion") && Main.tablaSimbolos.getDatos(ambitoVariable).getUso().equals("VariableTypeDef"))
                                    Main.tablaSimbolos.getDatos(ambitoVariable).setFuncionReferenciada(valorOp);

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
                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + val_peek(2).sval +" no fue declarada}");
            }


        }
break;
case 65:
//#line 258 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 66:
//#line 259 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 67:
//#line 260 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 68:
//#line 264 "Gramatica.y"
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
//#line 273 "Gramatica.y"
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
//#line 284 "Gramatica.y"
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
//#line 297 "Gramatica.y"
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
case 74:
//#line 310 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 78:
//#line 318 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 79:
//#line 319 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 80:
//#line 320 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 81:
//#line 323 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 82:
//#line 324 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 83:
//#line 325 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 84:
//#line 326 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 85:
//#line 327 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 86:
//#line 329 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 87:
//#line 330 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 88:
//#line 335 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");
           Terceto t = new Terceto("Impresion", val_peek(1).sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 89:
//#line 340 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 90:
//#line 347 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");

               if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo() == "ULONG"){
                        if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                            Terceto t = new Terceto("InvocacionFuncion", funcionRef, null);
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
//#line 383 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo() == "DOUBLE"){
                          if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                            String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                            Terceto t = new Terceto("InvocacionFuncion", funcionRef, null);
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
//#line 418 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null && val_peek(3).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    String ambitoParametro = Main.tablaSimbolos.verificarAmbito(val_peek(1).sval, ambito);

                    if(ambitoFuncion != null){
                        if (ambitoParametro != null){
                             String nombreParametro = Main.tablaSimbolos.getDatos(ambitoFuncion).getParametro();
                                if (Main.tablaSimbolos.getDatos(nombreParametro).getTipo().equals(Main.tablaSimbolos.getDatos(ambitoParametro).getTipo())){
                                     if (!Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada().equals("")){
                                        String funcionRef = Main.tablaSimbolos.getDatos(ambitoFuncion).getFuncionReferenciada();
                                        Terceto t = new Terceto("InvocacionFuncion", funcionRef, null);
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
//#line 468 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 95:
//#line 469 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 96:
//#line 470 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 97:
//#line 471 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
//#line 474 "Gramatica.y"
{adminTercetos.desapilar();
                                        Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                        adminTercetos.agregarTerceto(t);}
break;
case 100:
//#line 481 "Gramatica.y"
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
//#line 492 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 103:
//#line 495 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 104:
//#line 496 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 105:
//#line 497 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 109:
//#line 507 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 110:
//#line 512 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 112:
//#line 520 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 113:
//#line 524 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(1).sval +"'" );
            if(val_peek(1).sval != null && val_peek(0).sval != null ){ /*si se declaró bien y se cumplen los PRE (en caso de haberlos)*/
                if (val_peek(0).sval.equals("PRE")){
                   ambito = ambito.substring(0,ambito.lastIndexOf("@"));

                    Terceto t = new Terceto("RetornoFuncion", val_peek(0).sval, null);
                    adminTercetos.agregarTerceto(t);
                    t = new Terceto("FinFuncion", val_peek(1).sval, null);
                    adminTercetos.agregarTerceto(t);

                    yyval = new ParserVal(val_peek(1).sval);
            }
                else {
                    ambito = ambito.substring(0,ambito.lastIndexOf("@"));

                    Terceto t = new Terceto("RetornoFuncion", val_peek(0).sval, null);
                    adminTercetos.agregarTerceto(t);

                    t = new Terceto("FinFuncion", val_peek(1).sval, null);
                    adminTercetos.agregarTerceto(t);
                    yyval = new ParserVal(val_peek(1).sval);
            }
           }
            else

                 yyval = new ParserVal(null);
         }
break;
case 115:
//#line 554 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 116:
//#line 557 "Gramatica.y"
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
//#line 588 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta indicar el tipo}");}
break;
case 119:
//#line 589 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 120:
//#line 590 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 121:
//#line 591 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 122:
//#line 592 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 123:
//#line 593 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 124:
//#line 596 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);
                }
break;
case 126:
//#line 606 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 127:
//#line 610 "Gramatica.y"
{
            System.out.println("*************************"+ val_peek(4).sval);
            if (val_peek(4).sval != null){
                 lista_variables = (ArrayList<String>)val_peek(0).obj;
                 if (lista_variables != null){
                 for(String lexema: lista_variables){
                     String nuevoLexema = lexema + "@" + ambito;
                     if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                         Main.tablaSimbolos.reemplazarLexema(lexema, nuevoLexema);
                         DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                         ds.setUso("VariableTypeDef");
                         ds.setTipo(val_peek(4).sval);
                         Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                     }
                     else{
                         Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable de función " + lexema + " en este ámbito}");
                         Main.tablaSimbolos.eliminarSimbolo(lexema);

                                     }
                         }
                         }
                         }
                   yyval= new ParserVal(val_peek(1).sval);
                         }
break;
case 128:
//#line 641 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 129:
//#line 647 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 130:
//#line 653 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 131:
//#line 656 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 132:
//#line 660 "Gramatica.y"
{
                             Operando op = (Operando)val_peek(3).obj;
                             if (op != null){
                                  yyval = new ParserVal(op.getValor());
                              }
                                 else
                                     yyval = new ParserVal (null);
                      }
break;
case 133:
//#line 669 "Gramatica.y"
{
                        Operando op = (Operando)val_peek(3).obj;
                        if (op != null){
                             yyval = new ParserVal(op.getValor());
                         }
                            else
                                yyval = new ParserVal (null);
                 }
break;
case 134:
//#line 678 "Gramatica.y"
{
			            if (val_peek(8).sval != null && val_peek(3).sval != null){
			                yyval = new ParserVal (val_peek(3).sval);
			            }
			            else
			                yyval = new ParserVal (null);
			 }
break;
case 135:
//#line 685 "Gramatica.y"
{
                        if (val_peek(7).sval != null && val_peek(3).sval != null){
                            yyval = new ParserVal (val_peek(3).sval);
                        }
                        else
                             yyval = new ParserVal (null);
             }
break;
case 136:
//#line 693 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 137:
//#line 696 "Gramatica.y"
{Main.listaErrores.add("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 138:
//#line 697 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 139:
//#line 698 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 140:
//#line 699 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 141:
//#line 700 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 142:
//#line 701 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 143:
//#line 702 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 144:
//#line 703 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 145:
//#line 705 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 146:
//#line 706 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 147:
//#line 707 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 148:
//#line 708 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 149:
//#line 709 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 150:
//#line 710 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 151:
//#line 711 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 152:
//#line 712 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 153:
//#line 713 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 154:
//#line 717 "Gramatica.y"
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
case 156:
//#line 730 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 157:
//#line 731 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 158:
//#line 732 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 159:
//#line 733 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 160:
//#line 734 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 161:
//#line 739 "Gramatica.y"
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
//#line 751 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 163:
//#line 754 "Gramatica.y"
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
//#line 777 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 165:
//#line 779 "Gramatica.y"
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
//#line 800 "Gramatica.y"
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
//#line 820 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 168:
//#line 824 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 169:
//#line 827 "Gramatica.y"
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
//#line 847 "Gramatica.y"
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
//#line 869 "Gramatica.y"
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
//#line 889 "Gramatica.y"
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
//#line 909 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 174:
//#line 913 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) val_peek(0).obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 175:
//#line 918 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 176:
//#line 921 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 177:
//#line 924 "Gramatica.y"
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
//#line 933 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocacion de funcion}");
                       if(val_peek(0).sval != null){
                           String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(0).sval, ambito);
                           yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                       }
                       /*TODO ELSE*/
                     }
break;
case 179:
//#line 943 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 180:
//#line 944 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 181:
//#line 945 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 182:
//#line 946 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 183:
//#line 947 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 184:
//#line 948 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 2054 "Parser.java"
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
