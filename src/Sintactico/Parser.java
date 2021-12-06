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
    4,    4,   21,   21,   17,   17,    9,    9,   25,   25,
   25,   25,   25,   25,   25,   25,   22,   22,   26,   26,
   26,   23,   24,   28,   28,   29,   29,   29,   30,   13,
   13,   32,   32,   32,   10,   36,   10,   10,   34,   34,
   39,   35,   35,   35,   40,   40,   40,   37,   37,   37,
   37,   37,   37,   37,   11,   11,   12,   12,   12,   12,
   41,   41,   41,   41,   15,   15,   42,   42,   45,   44,
   44,   44,   43,   46,   46,   18,   18,   18,   47,   19,
   19,   50,   48,   48,   52,   52,   52,   52,   52,   52,
   51,   51,   53,   20,   49,   49,   49,   55,   54,   54,
   54,   54,   57,   57,   57,   57,   57,   57,   57,   57,
   57,   57,   57,   57,   57,   57,   57,   57,   57,   57,
   56,   56,   58,   58,   58,   58,   58,   38,   38,   59,
   59,   27,   27,   31,   31,   31,   33,   33,   33,   61,
   61,   61,   61,   61,   60,   60,   60,   60,   60,   60,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    2,
    6,    1,    3,    2,    1,    1,    9,    1,    8,    8,
    8,    8,    8,    8,    8,    9,    3,    1,    2,    2,
    3,    1,    3,    1,    2,    1,    2,    1,    2,    3,
    1,    2,    2,    3,    5,    0,    8,    1,    3,    1,
    3,    1,    5,    1,    4,    5,    4,    4,    4,    4,
    4,    5,    7,    8,    4,    3,    4,    4,    4,    1,
    3,    4,    4,    4,    3,    1,    2,    1,    2,    2,
    3,    4,    3,    1,    2,    3,    1,    1,    2,    2,
    1,    2,    6,    1,    5,    5,    5,    5,    5,    6,
    2,    1,    2,    7,    2,    1,    1,    2,    8,   10,
    9,    1,    7,    7,    7,    7,    7,    7,    7,    3,
    8,    9,    9,    9,    9,    9,    9,    9,   10,    5,
    5,    1,    4,    4,    4,    4,    5,    1,    3,    1,
    3,    1,    3,    1,    3,    3,    3,    3,    1,    2,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   35,   36,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  111,  114,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   38,   61,    0,
   68,   70,   90,    0,   96,   98,    0,    0,    4,    7,
    0,    0,    0,  108,   34,   30,  112,    0,    0,    0,
    0,    0,  110,  126,  127,    0,  132,  152,    0,  172,
    0,  171,    0,    0,  174,    0,  169,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   48,   99,   97,    0,
    0,    0,    0,    0,    0,    1,    0,   12,   11,   20,
   14,   21,   15,   22,   16,   24,   17,   23,   18,   28,
   26,    0,    0,    0,  100,    0,    0,    0,    0,    0,
   33,  109,   29,    0,    0,    0,    0,    0,    0,    0,
  128,  125,    0,    0,   64,    0,    0,    0,    0,   91,
  170,    0,    0,    0,   72,    0,   74,    0,    0,    0,
   86,   13,    8,   50,    0,   49,    0,    0,    0,    0,
  178,  179,  177,  180,  175,  176,    0,    0,    0,   71,
    0,   69,    0,    0,  104,    0,  101,   95,    0,    0,
  122,    0,    0,    0,    0,    0,  106,    0,    0,  140,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   94,
   89,   92,   87,   93,   88,  167,  168,    0,   79,   81,
    0,   80,   85,   51,   47,    0,    0,    0,    0,    0,
  102,    0,    0,    0,    0,    0,   78,  103,  105,  123,
  121,  115,    0,    0,  116,  119,    0,  118,  117,    0,
    0,    0,    0,    0,    0,    0,  154,  156,    0,  155,
  153,    0,    0,    0,    0,   82,   65,    0,    0,    0,
    0,    0,    0,    0,    0,   31,  120,  113,    0,    0,
    0,    0,    0,    0,    0,  150,    0,    0,  157,  151,
    0,    0,   77,   75,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   76,   73,   83,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  134,  137,  138,  139,    0,  136,  135,    0,    0,    0,
    0,    0,    0,  133,    0,   84,   67,    0,   40,   42,
   43,    0,   45,   44,   41,   39,    0,  141,  129,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   56,    0,
   54,   58,   46,   37,    0,  131,  146,  147,  148,    0,
  145,  144,  143,  142,   59,   57,   53,   55,  107,    0,
  149,  130,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   53,   11,  234,
   12,   86,  216,  339,   38,   87,   91,  360,  361,  362,
   92,   39,   93,   40,  146,  259,   41,   94,   42,  147,
   43,   44,  115,   45,   46,  176,   54,   13,   63,   14,
  180,   15,  181,   64,   65,   66,   67,   68,   95,  167,
   77,
};
final static short yysindex[] = {                      -208,
   37, -222,    0,    0, -198,    0,   37,    0,    0, -205,
  104,    0,  -35,    0,    0,  405,  310,  -31,   32,  309,
   28,  173,  310,   37, -189,  185,    0,    0,    0,  132,
  139,  141,  143,  144,    0,  146,    0,    0,    0, -166,
    0,    0,    0, -252,    0,    0,  101,   64,    0,    0,
  105,   31,  474,    0,    0,    0,    0,   -1,   73,  106,
   18,  194,    0,    0,    0,   88,    0,    0,  111,    0,
  418,    0,  340,  310,    0,   90,    0,   90,  211,   69,
   -7,   95, -120, -106,  -49,   94,    0,    0,    0, -121,
  360,   72,   90,   -3, -112,    0, -189,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  211,  339, -224,    0, -185, -185, -185,  -37, -185,
    0,    0,    0,  -91,  128,   96,  223,  310,  -34,  310,
    0,    0,  129,  309,    0,   72,   75,   85,   86,    0,
    0,  310,  310,  309,    0,  -98,    0,  115,  -96,  134,
    0,    0,    0,    0, -116,    0,  310,  388,  310,  -93,
    0,    0,    0,    0,    0,    0,  310,  310,  310,    0,
  310,    0,  310,  -92,    0,  316,    0,    0, -128,  151,
    0,  -88,  152,  -28,  153,  158,    0,  310,  150,    0,
  310,  243,  244,  -20,  442,  -12,  -10,  310,  263,    0,
    0,    0,    0,    0,    0,    0,    0,  264,    0,    0,
   65,    0,    0,    0,    0,  138,  360,  454,  142,  145,
    0,   72,   90,   90, -112,  360,    0,    0,    0,    0,
    0,    0,  148,  159,    0,    0,   89,    0,    0,   -8,
  452,    4,   46,  166,  130,  167,    0,    0,   50,    0,
    0,   10,  170,  325,  283,    0,    0,  -72,  -67,  103,
  165,  -47,  180,  188, -185,    0,    0,    0,  288,  303,
  -15,  323,  357,  310,  328,    0,  310,  310,    0,    0,
  366,  310,    0,    0,  333,  147,  211,  402,  408,  414,
   71,  428,  429,  430,  197,  201,  203,  -55,  206,  209,
   40,  464,   43,   63,   58,  213,   60,    0,    0,    0,
  233,  238,  229,  229,  229,  -39,  229,  229,  229,  451,
    0,    0,    0,    0, -193,    0,    0,  460,  469,  -13,
  470,  471,  478,    0,  489,    0,    0,  284,    0,    0,
    0, -176,    0,    0,    0,    0,  292,    0,    0,  275,
  281,  294,  -44,  295,  296,  308,  318,  347,    0,  156,
    0,    0,    0,    0,  337,    0,    0,    0,    0, -190,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  100,
    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  599,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  494,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  570,    0,
    0,    0,    0,    0,    0,  353,    0,  375,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -40,  399,  516,    0,   20,    0,  600,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  380,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  317,    0,    0,    0,    0,    0,  -43,    0,    0,    0,
    0,  436,  582,  594,   98,  124,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  336,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  336,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  547,
    0,    0,
};
final static short yygindex[] = {                         0,
   77,   36,    0,   13,  627,    0,  -26,   -5,    0,    0,
    0,   -9,    0,    0,  586,    0,  607,  251,    0,    0,
    0,  539, -111,  421,    0,    0,  -62,    0,  266,    0,
  -53,    0,    8,  610,  502,    0,    0,  604,    0,    0,
    0,    0,  -87,    0,    0,    0,    0,    0,    0,    0,
  -78,    0,    0,  572,    0,  576,    0,    0,  467,    0,
  -19,
};
final static int YYTABLESIZE=906;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         99,
  160,  342,  184,  325,   23,  195,   75,   75,   23,  157,
   74,  291,  236,   75,  370,   52,   89,  136,  160,   50,
  247,  113,   60,   76,   78,  298,  178,  353,  250,  114,
  251,  177,  269,  151,   47,   99,   50,  172,   23,  183,
  185,  186,   49,  297,  272,  352,  219,  220,    1,  113,
  281,   51,  145,  145,  141,   99,   60,   23,   48,   96,
  158,   75,  348,    2,   75,  381,   52,   85,    3,    4,
  120,   81,  221,   50,    5,   60,   23,   24,  158,  363,
  328,  349,    2,  331,  382,  145,  273,    3,    4,   61,
  280,    3,    4,    5,  217,  217,  217,  338,  333,   99,
  335,   97,  112,  332,   23,  237,  262,  175,   23,   50,
  226,  317,  128,  222,  168,  201,  169,  208,   75,   75,
   75,  145,  206,  207,  117,  203,  205,  230,  231,  268,
  129,  142,   75,   75,   23,  191,  143,  154,  159,  214,
  116,  215,  155,  124,  118,  130,  134,   75,   75,   75,
   73,  156,  159,  173,   23,  217,  159,   75,   75,   75,
  160,   75,   56,   75,  161,  187,   99,  188,  198,  277,
  229,  209,   99,  212,  213,  223,  224,  227,   75,   75,
  113,   75,  161,  233,  145,   75,   23,  265,   75,  241,
  101,  232,  235,  238,   74,   23,  260,  103,  239,  105,
  263,  107,  109,  264,  111,  274,  278,   83,   75,  282,
  290,  286,   23,   84,   52,  160,  287,  266,   99,  324,
   57,   16,   69,   70,   23,  160,  160,   17,   99,   72,
  369,   75,   18,   23,  338,   19,    2,   79,   58,    3,
    4,    3,    4,   21,   59,   22,  171,    5,    3,    4,
   23,  171,  170,  171,  171,   16,  171,  150,  171,  145,
  145,   17,   23,  171,   75,   75,   18,   75,   75,   19,
  171,  125,   75,  131,   16,  158,  171,   21,   59,   22,
   17,  192,   23,   23,   83,   18,  158,  119,   19,    2,
   84,   58,   75,   16,    3,    4,   21,   59,   22,   17,
    5,  170,   23,   23,   18,  279,  171,   19,    2,  171,
   20,  359,  171,    3,    4,   21,  171,   22,  170,    5,
  256,   16,   23,   23,  171,   16,  171,   17,  316,  171,
  200,   17,   18,  359,  257,   19,   18,  148,  144,   19,
  202,  204,  144,   21,  267,   22,  295,   21,   23,   22,
  152,   16,   16,  159,   74,   23,  122,   17,   17,   55,
  288,  296,   18,   18,  159,   19,   19,  302,  189,  153,
  190,   16,   74,   21,   21,   22,   22,   17,   23,  161,
  140,  299,   18,  284,  210,   19,   16,  100,  144,  161,
  161,  309,   17,   21,  102,   22,  104,   18,  106,  108,
   19,  110,  275,   16,  276,  376,   69,   70,   21,   17,
   22,   63,   16,   72,   18,  300,  310,   19,   17,  165,
  144,  166,  289,   18,  306,   21,   19,   22,   88,   16,
  377,  358,   74,   62,   21,   17,   22,  292,   60,  162,
   18,   16,  313,   19,   73,  293,  218,   17,  314,   74,
   16,   21,   18,   22,  315,   19,   17,  162,  162,   98,
  162,   18,   74,   21,   19,   22,  133,   16,  318,  319,
  320,  321,   21,   17,   22,  322,  163,  323,   18,   16,
  326,   19,  248,  327,  144,   17,   74,  334,  336,   21,
   18,   22,  270,   19,  163,  163,   74,  163,   74,   16,
   16,   21,  338,   22,  329,   17,   17,  337,   74,  347,
   18,   18,  261,   19,   19,  244,  246,  124,  350,   16,
   16,   21,   21,   22,   22,   17,   17,  351,  354,  355,
   18,   18,  123,   19,   19,  253,  356,  107,  254,   16,
   16,   21,   21,   22,   22,   17,   17,  357,  365,  366,
   18,   18,  107,   19,   19,  367,  164,  285,  164,  358,
  164,   21,   21,   22,   22,   16,   69,   70,  368,  371,
  372,   17,   16,   72,  164,  164,   18,  164,   17,   19,
  283,  149,  373,   18,   69,   70,   19,   21,  308,   22,
  228,   72,  374,  379,   21,   16,  137,  138,    2,    5,
   66,   17,  375,  139,   69,  124,   18,   90,   63,   19,
  173,  173,  173,  174,  173,  380,  173,   21,  161,  162,
  163,  164,  165,  158,  165,  378,  165,   80,  173,  173,
   62,  173,  132,  127,  166,   60,  166,  225,  166,   62,
  165,  165,    0,  165,   69,   70,   82,    0,    0,  211,
    0,   72,  166,  166,  162,  166,  162,  162,  162,  162,
  162,   69,   70,    0,  162,  162,    0,   71,   72,    0,
    0,    0,    0,  135,   69,   70,    0,    0,    0,    0,
    0,   72,    0,    0,  126,    0,    0,   62,    0,    0,
    0,  163,    0,  163,  163,  163,  163,  163,   69,   70,
    0,  163,  163,    0,    0,   72,    0,    0,   69,   70,
   69,   70,  258,    0,    0,   72,    0,   72,    0,    0,
   69,   70,  179,  182,  179,  179,  179,   72,    0,  121,
  122,  194,  196,  197,  340,  341,  343,  344,  345,  346,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  107,
  107,    0,    0,  193,    0,    0,    0,    0,    0,    0,
  199,    0,  364,    0,    0,    0,    0,    0,    0,    0,
    0,  164,    0,  164,  164,  164,  164,  164,    0,    0,
    0,  164,  164,    0,    0,    0,    0,  311,  312,    0,
  179,  240,  242,    0,  243,    0,    0,    0,  249,    0,
    0,  252,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  245,    0,
    0,    0,    0,    0,    0,  173,    0,  173,  173,  173,
  173,  173,    0,    0,  255,  173,  173,  165,    0,  165,
  165,  165,  165,  165,  271,    0,    0,  165,  165,  166,
    0,  166,  166,  166,  166,  166,    0,    0,    0,  166,
  166,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  294,    0,    0,    0,    0,    0,  301,  303,    0,
  304,  305,    0,    0,    0,  307,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  330,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         26,
   41,   41,   40,   59,   40,   40,   16,   17,   40,   59,
   45,   59,   41,   23,   59,   59,   22,   71,   59,    7,
   41,  274,   58,   16,   17,   41,  114,   41,   41,  282,
   41,  256,   41,   41,  257,   62,   24,   41,   40,  118,
  119,  120,    7,   59,   41,   59,  158,  159,  257,  274,
   41,  257,   79,   80,   74,   82,   58,   40,  257,   24,
   41,   71,  256,  272,   74,  256,  272,   40,  277,  278,
   40,   40,  160,   61,  283,   58,   40,    1,   59,  256,
   41,  275,  272,   41,  275,  112,   41,  277,  278,   13,
   41,  277,  278,  283,  157,  158,  159,  274,   41,  126,
   41,   25,  269,   41,   40,  184,  218,  113,   40,   97,
  173,   41,   40,  167,   43,   41,   45,  144,  128,  129,
  130,  148,  142,  143,   61,   41,   41,  256,  257,   41,
   58,   42,  142,  143,   40,   40,   47,  258,   41,  256,
   40,  258,  263,   44,   40,   40,   59,  157,  158,  159,
   40,  258,   59,  266,   40,  218,   59,  167,  168,  169,
  282,  171,   59,  173,   41,  257,  193,   40,   40,   40,
  176,  270,  199,  270,   41,  168,  169,  270,  188,  189,
  274,  191,   59,  272,  211,  195,   40,   40,  198,   40,
   59,   41,   41,   41,   45,   40,   59,   59,   41,   59,
   59,   59,   59,   59,   59,   40,   40,  257,  218,   40,
  258,  284,   40,  263,  258,  256,  284,   59,  245,  275,
  256,  257,  257,  258,   40,  266,  267,  263,  255,  264,
  275,  241,  268,   40,  274,  271,  272,  269,  274,  277,
  278,  277,  278,  279,  280,  281,  267,  283,  277,  278,
   40,  267,  256,  267,  267,  257,  267,  265,  267,  286,
  287,  263,   40,  267,  274,  275,  268,  277,  278,  271,
  267,  273,  282,  256,  257,  256,  267,  279,  280,  281,
  263,   59,   40,   40,  257,  268,  267,  257,  271,  272,
  263,  274,  302,  257,  277,  278,  279,  280,  281,  263,
  283,  256,   40,   40,  268,  256,  267,  271,  272,  267,
  274,  338,  267,  277,  278,  279,  267,  281,  256,  283,
  256,  257,   40,   40,  267,  257,  267,  263,  258,  267,
  256,  263,  268,  360,  270,  271,  268,  269,  274,  271,
  256,  256,  274,  279,  256,  281,   59,  279,   40,  281,
  256,  257,  257,  256,   45,   40,  257,  263,  263,  256,
  258,   59,  268,  268,  267,  271,  271,   40,  273,  275,
  275,  257,   45,  279,  279,  281,  281,  263,   40,  256,
   41,   59,  268,   59,  270,  271,  257,  256,  274,  266,
  267,   59,  263,  279,  256,  281,  256,  268,  256,  256,
  271,  256,  273,  257,  275,   59,  257,  258,  279,  263,
  281,   59,  257,  264,  268,   59,  270,  271,  263,   60,
  274,   62,  258,  268,   59,  279,  271,  281,  256,  257,
  275,  276,   45,   59,  279,  263,  281,  258,   59,   41,
  268,  257,   41,  271,   40,  258,   59,  263,   41,   45,
  257,  279,  268,  281,   41,  271,  263,   59,   60,  275,
   62,  268,   45,  279,  271,  281,  273,  257,   41,   41,
   41,  275,  279,  263,  281,  275,   41,  275,  268,  257,
  275,  271,   41,  275,  274,  263,   45,  275,  256,  279,
  268,  281,   41,  271,   59,   60,   45,   62,   45,  257,
  257,  279,  274,  281,   41,  263,  263,  270,   45,   59,
  268,  268,   59,  271,  271,  273,  273,   44,   59,  257,
  257,  279,  279,  281,  281,  263,  263,   59,   59,   59,
  268,  268,   59,  271,  271,  273,   59,   44,  275,  257,
  257,  279,  279,  281,  281,  263,  263,   59,  257,  275,
  268,  268,   59,  271,  271,  275,   41,  275,   43,  276,
   45,  279,  279,  281,  281,  257,  257,  258,  275,  275,
  275,  263,  257,  264,   59,   60,  268,   62,  263,  271,
  256,   80,  275,  268,  257,  258,  271,  279,  256,  281,
  275,  264,  275,  257,  279,  257,  257,  258,    0,    0,
  284,  263,  256,  264,  269,   59,  268,   22,  256,  271,
   41,   42,   43,  112,   45,  365,   47,  279,  259,  260,
  261,  262,   41,   85,   43,  360,   45,   18,   59,   60,
  256,   62,   61,   58,   41,  256,   43,  171,   45,   13,
   59,   60,   -1,   62,  257,  258,   20,   -1,   -1,  148,
   -1,  264,   59,   60,  256,   62,  258,  259,  260,  261,
  262,  257,  258,   -1,  266,  267,   -1,  263,  264,   -1,
   -1,   -1,   -1,  256,  257,  258,   -1,   -1,   -1,   -1,
   -1,  264,   -1,   -1,   58,   -1,   -1,   61,   -1,   -1,
   -1,  256,   -1,  258,  259,  260,  261,  262,  257,  258,
   -1,  266,  267,   -1,   -1,  264,   -1,   -1,  257,  258,
  257,  258,  211,   -1,   -1,  264,   -1,  264,   -1,   -1,
  257,  258,  116,  117,  118,  119,  120,  264,   -1,  256,
  257,  128,  129,  130,  314,  315,  316,  317,  318,  319,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,
  257,   -1,   -1,  127,   -1,   -1,   -1,   -1,   -1,   -1,
  134,   -1,  342,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,   -1,   -1,   -1,  286,  287,   -1,
  184,  188,  189,   -1,  191,   -1,   -1,   -1,  195,   -1,
   -1,  198,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  192,   -1,
   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,  208,  266,  267,  256,   -1,  258,
  259,  260,  261,  262,  241,   -1,   -1,  266,  267,  256,
   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  265,   -1,   -1,   -1,   -1,   -1,  274,  275,   -1,
  277,  278,   -1,   -1,   -1,  282,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  302,
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

//#line 920 "Gramatica.y"

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
//#line 755 "Parser.java"
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
case 12:
//#line 39 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 13:
//#line 40 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 20:
//#line 53 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
//#line 54 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
//#line 55 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
//#line 56 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 57 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
//#line 65 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
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
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable " + lexema + " en este ámbito}");
                        Main.tablaSimbolos.eliminarSimbolo(lexema);
                    }
    	        }
    	        lista_variables.clear();
    	        }
break;
case 31:
//#line 94 "Gramatica.y"
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
    	        }
                else
                    Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {" + val_peek(5).sval + " y " + val_peek(1).sval +" deben tener el mismo nombre}");

    	        }
break;
case 33:
//#line 114 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
//#line 115 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
//#line 121 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 36:
//#line 123 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 37:
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
            t = new Terceto("Label"+adminTercetos.cantidadTercetos(),null,null);
            adminTercetos.agregarTerceto(t);
        }
    }
break;
case 39:
//#line 143 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 40:
//#line 144 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 41:
//#line 145 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 42:
//#line 146 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 43:
//#line 147 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 44:
//#line 148 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 45:
//#line 149 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 46:
//#line 150 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 47:
//#line 153 "Gramatica.y"
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
case 48:
//#line 173 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 49:
//#line 176 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 50:
//#line 177 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 51:
//#line 178 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 52:
//#line 182 "Gramatica.y"
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
case 59:
//#line 209 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 60:
//#line 212 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion de " + val_peek(2).sval +"}");
            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(2).sval, ambito);
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
                   System.out.println("TIPOOOOOOOOOOOOO: " + op.getTipo());
                   t.setTipo(op.getTipo());
                   adminTercetos.agregarTerceto(t);
                    yyval = new ParserVal(new Operando(tipoIdentificador, "[" + t.getNumero()+ "]"));
                    }
                    else{
                        Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                    }
           }
            else{
                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La variable " + val_peek(2).sval +" no fue declarada}");
            }

        }
        }
break;
case 62:
//#line 251 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 63:
//#line 252 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 64:
//#line 253 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 65:
//#line 257 "Gramatica.y"
{
            if(val_peek(3).sval != null){
                adminTercetos.desapilar();
                Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t);
                }
            }
break;
case 66:
//#line 265 "Gramatica.y"
{
	        if(val_peek(2).sval != null){
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.desapilar();
                Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t1);
                adminTercetos.apilar(t.getNumero());
            }
            }
break;
case 67:
//#line 275 "Gramatica.y"
{
                if(val_peek(6).sval != null) {
                   adminTercetos.desapilar();
                   Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                   adminTercetos.agregarTerceto(t);
            }
       }
break;
case 69:
//#line 287 "Gramatica.y"
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
case 71:
//#line 300 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 75:
//#line 308 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 76:
//#line 309 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 77:
//#line 310 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 78:
//#line 313 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 79:
//#line 314 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 80:
//#line 315 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 81:
//#line 316 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 82:
//#line 317 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 83:
//#line 319 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 84:
//#line 320 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 85:
//#line 325 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");
           Terceto t = new Terceto("Impresion", val_peek(1).sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 86:
//#line 330 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 87:
//#line 337 "Gramatica.y"
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
case 88:
//#line 373 "Gramatica.y"
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
case 89:
//#line 408 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null && val_peek(3).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    String ambitoParametro = Main.tablaSimbolos.verificarAmbito(val_peek(1).sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(ambitoFuncion).getTipo().equals(Main.tablaSimbolos.getDatos(ambitoParametro).getTipo())){
                        if (ambitoParametro != null){
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
                        else
                            Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea+ "] {El parámetro "+val_peek(1).sval+" esta fuera de alcance}");
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
//#line 455 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 92:
//#line 456 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 93:
//#line 457 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
//#line 458 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
//#line 461 "Gramatica.y"
{adminTercetos.desapilar();
                                        Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                        adminTercetos.agregarTerceto(t);}
break;
case 97:
//#line 468 "Gramatica.y"
{
                                      Terceto t = new Terceto("BI", null, null);
                                      adminTercetos.agregarTerceto(t);
                                      adminTercetos.desapilar();
                                      Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                      adminTercetos.agregarTerceto(t1);
                                      adminTercetos.apilar(t.getNumero());
}
break;
case 99:
//#line 479 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 100:
//#line 482 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 101:
//#line 483 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 102:
//#line 484 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 106:
//#line 494 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 107:
//#line 499 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 109:
//#line 507 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 110:
//#line 511 "Gramatica.y"
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
case 112:
//#line 541 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 113:
//#line 544 "Gramatica.y"
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
case 115:
//#line 575 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta indicar el tipo}");}
break;
case 116:
//#line 576 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 117:
//#line 577 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 118:
//#line 578 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 119:
//#line 579 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 120:
//#line 580 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 121:
//#line 583 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);
                }
break;
case 123:
//#line 593 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 124:
//#line 597 "Gramatica.y"
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
case 125:
//#line 628 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 126:
//#line 634 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 127:
//#line 640 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 128:
//#line 643 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 129:
//#line 647 "Gramatica.y"
{

                        if  (val_peek(3).sval != null){
                            yyval = new ParserVal (val_peek(3).sval);
                        }
                        else
                            yyval = new ParserVal (null);
             }
break;
case 130:
//#line 656 "Gramatica.y"
{
			            if (val_peek(8).sval != null && val_peek(3).sval != null){
			                yyval = new ParserVal (val_peek(3).sval);
			            }
			            else
			                yyval = new ParserVal (null);
			 }
break;
case 131:
//#line 663 "Gramatica.y"
{
                        if (val_peek(7).sval != null && val_peek(3).sval != null){
                            yyval = new ParserVal (val_peek(3).sval);
                        }
                        else
                             yyval = new ParserVal (null);
             }
break;
case 132:
//#line 671 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 133:
//#line 674 "Gramatica.y"
{Main.listaErrores.add("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 134:
//#line 675 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 135:
//#line 676 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 136:
//#line 677 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 137:
//#line 678 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 138:
//#line 679 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 139:
//#line 680 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 140:
//#line 681 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 141:
//#line 682 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 142:
//#line 684 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 143:
//#line 685 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 144:
//#line 686 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 145:
//#line 687 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 146:
//#line 688 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 147:
//#line 689 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 148:
//#line 690 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 149:
//#line 691 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 150:
//#line 692 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 151:
//#line 696 "Gramatica.y"
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
case 153:
//#line 709 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 154:
//#line 710 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 155:
//#line 711 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 156:
//#line 712 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 157:
//#line 713 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 158:
//#line 716 "Gramatica.y"
{
                            Operando op = (Operando)val_peek(0).obj;
                           if(op != null){
                               yyval = new ParserVal(op.getValor());
                           }
                           else
                                yyval = new ParserVal(null);
                        }
break;
case 159:
//#line 724 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 160:
//#line 746 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 161:
//#line 747 "Gramatica.y"
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
                                Main.listaErrores.add("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Los tipos son incompatibles}");
                                yyval = new ParserVal(null);
                             }
                        }
                        else{
                               yyval = new ParserVal(null);
                        }
        }
break;
case 162:
//#line 768 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 163:
//#line 769 "Gramatica.y"
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
case 164:
//#line 792 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 165:
//#line 795 "Gramatica.y"
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
case 166:
//#line 815 "Gramatica.y"
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
case 167:
//#line 837 "Gramatica.y"
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
case 168:
//#line 857 "Gramatica.y"
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
case 169:
//#line 877 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 170:
//#line 881 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) val_peek(0).obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 171:
//#line 886 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 172:
//#line 889 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 173:
//#line 892 "Gramatica.y"
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
case 174:
//#line 901 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocacion de funcion}");
                       if(val_peek(0).sval != null){
                           String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(0).sval, ambito);
                           yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                       }
                     }
break;
case 175:
//#line 910 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 176:
//#line 911 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 177:
//#line 912 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 178:
//#line 913 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 179:
//#line 914 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 180:
//#line 915 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 2001 "Parser.java"
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
