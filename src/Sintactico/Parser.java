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
public final static short CTE_UINT=258;
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
public final static short UINT=284;
public final static short ENDREPEAT=285;
public final static short ELSE=286;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    3,    3,    1,    1,    2,    2,    5,    5,
    6,    6,    7,    7,    7,    7,    7,    7,   13,   13,
   13,   13,   13,    4,    4,    4,    4,   17,   17,   14,
   14,    8,    8,   20,   20,   20,   20,   20,   20,   20,
   20,   20,   20,   20,   19,   19,   21,   21,   21,   22,
   12,   12,   23,   23,   23,    9,    9,    9,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   10,   11,   11,
   26,   26,   26,   26,   15,   15,   15,   27,   16,   16,
   29,   29,   29,   29,   29,   29,   25,   25,   30,   28,
   28,   28,   32,   32,   32,   31,   31,   31,   33,   33,
   33,   33,   33,   33,   33,   34,   33,   33,   33,   33,
   33,   33,   33,   33,   33,   33,   33,   18,   18,   35,
   35,   36,   36,   37,   37,   37,   39,   39,   39,   40,
   40,   40,   40,   38,   38,   38,   38,   38,   38,
};
final static short yylen[] = {                            2,
    3,    1,    2,    3,    1,    2,    3,    1,    1,    2,
    2,    3,    2,    2,    2,    2,    2,    1,    2,    2,
    2,    2,    2,    3,    2,    5,    1,    3,    2,    1,
    1,   12,    1,   11,   11,   11,   11,   11,   11,   11,
   11,   11,   11,   11,    1,    2,    1,    2,    1,    2,
    3,    1,    2,    2,    2,    8,   10,    1,    6,    6,
    6,    6,    6,    6,    6,    8,    8,    4,    4,    1,
    3,    3,    3,    3,    3,    1,    1,    2,    6,    1,
    5,    5,    5,    5,    5,    5,    2,    1,    2,    2,
    5,    1,    4,    4,    4,    8,   11,    1,    7,    7,
    7,    7,    7,    7,    7,    0,   20,   11,   11,   11,
   11,   11,   11,   12,   11,   11,   11,    1,    3,    1,
    3,    1,    3,    1,    3,    3,    3,    3,    1,    1,
    1,    2,    1,    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   31,    0,   30,    0,    0,    2,    5,    0,
    0,   27,   80,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,    9,    0,    0,    0,    0,    0,
   18,   33,   52,   58,   70,    0,    0,    0,    0,    3,
    6,   76,    0,   77,   29,   25,  133,  131,    0,  130,
    0,    0,    0,    0,    0,   88,    0,    0,    0,    0,
  129,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,   11,   10,   19,   13,   20,   14,
   21,   15,   23,   16,   22,   17,    0,    0,    0,    0,
    0,   28,   78,   24,    0,    0,   73,    0,  132,   89,
   87,    0,   72,    0,  137,  138,  136,  139,  134,  135,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   12,    7,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   71,   75,    0,    0,    0,    0,    0,
    0,  127,  128,    0,    0,    0,    0,   68,    0,    0,
    0,    0,    0,    0,    0,   81,   92,    0,   84,    0,
   85,   83,   82,   26,    0,    0,    0,    0,    0,   69,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   90,   98,    0,   79,   61,   62,   64,    0,   63,   60,
    0,    0,    0,    0,    0,    0,   59,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   94,
    0,   95,    0,   93,   56,   66,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   91,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   57,    0,   47,    0,
   45,   49,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   50,   48,   34,   46,   36,   39,
   40,   43,    0,   42,   41,   38,   37,   35,  100,    0,
    0,    0,    0,    0,    0,    0,  103,  104,  105,    0,
  102,  101,   99,   32,    0,    0,    0,    0,    0,    0,
    0,    0,  106,   96,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  116,  108,  111,  112,  113,
    0,  110,  109,  117,   97,  115,    0,  114,    0,    0,
    0,    0,    0,    0,    0,    0,  107,
};
final static short yydgoto[] = {                          6,
  155,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,   12,   54,  270,   32,
  271,  272,   33,   34,   91,   35,   44,  156,   13,   56,
  181,  157,  182,  344,   57,   58,   59,  111,   60,   61,
};
final static short yysindex[] = {                      -188,
  206,  -25,    0, -232,    0,    0,  225,    0,    0, -229,
  -43,    0,    0,  262,  310,  108,   -5,  821,  -21,  291,
  225, -184,  344,    0,    0,   90,  111,  134,  160,  208,
    0,    0,    0,    0,    0,  -37, -208,   14,  291,    0,
    0,    0,  382,    0,    0,    0,    0,    0,  310,    0,
  -35,  310, -218, -199,   39,    0, -179,  842,   36,   61,
    0, -199,  482,  -30, -172,  294,  320,   48,   -4,  -29,
   56,    0,   71, -184,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -33,   74,   75, -235,
   76,    0,    0,    0, -145, -199,    0,   78,    0,    0,
    0,  310,    0,  310,    0,    0,    0,    0,    0,    0,
  310,  310,  310,  310,  310, -149,  -34, -146,   92,  -35,
    0,    0, -134,   60, -132, -135, -184, -208, -184,   -9,
 -184, -184,   77,    0,    0, -184, -179,  842,   36,   61,
   61,    0,    0,  821,  821,  383,  821,    0,   94,   82,
   84,  -42,   88,  821,  187,    0,    0,   96,    0, -184,
    0,    0,    0,    0,  447,  462,  466,  626,  656,    0,
  310,  310,  422,  310,  310,  666,  265,  174,  676, -138,
    0,    0, -184,    0,    0,    0,    0,   43,    0,    0,
  -38,  -36,  456,   83,   95,  107,    0,  106,   87,  691,
  695,  250,  125,  695,   91,  708,  -91,  -90,  -87,  115,
  -81,  -78,  -77,  310,  627,  310,  -27,  147,  291,    0,
  695,    0,  310,    0,    0,    0,  718,  141,  153,  155,
  156,   -8,  157,  161,  164,    4,  821,  353,  110,  821,
  753,    5,    6,    0,    9,  152,  727,  727,  727,  727,
  406,  727,  727,  727,  727,  158,  728,  745,  752,  821,
  769,  159,  -28,  267,  -41,  300,    0,  330,    0,   52,
    0,    0,   62,   64,   85,  100,  112,  124,  139,  149,
  151,  -69,  170,  183,  776,  346,  793,  358,  179,  200,
  -50,  211,  220,  223,    0,    0,    0,    0,    0,    0,
    0,    0,  172,    0,    0,    0,    0,    0,    0,  310,
  310,  175,  291,  310,  409,  310,    0,    0,    0, -190,
    0,    0,    0,    0,   11,   12,  777,   22,   24,   26,
  310,   37,    0,    0,  403,  424,  446,    3,  455,  -39,
  457,   41,  458,  251,  255,  266,  268,  272,  -23,  275,
  284,  287,  289,  295,  502,    0,    0,    0,    0,    0,
  315,    0,    0,    0,    0,    0,  310,    0,   50,  821,
  800,  526,  310,   57,  514,  306,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  342,    0,
    0,    0,    0,  362,    0,    0,  619,  585,  432,  494,
    0,  379,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  590,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  393,    0,  401,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  417,    0,    0,    0,
    0,    0,    0,    0,    0,  420,  643,  602,  568,  520,
  544,    0,    0,    0,    0,    0,    0,    0,  401,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  441,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  817,
    0,    0,    0,    0,    0,    0,    0,  451,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  452,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  453,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   42,  392,    0,   33,  -16,    0,    7,    0,    0,    0,
    0,    0,    0,  -10,    0,  507,    0,  -15,  869,    0,
  835,    0,    0,    0,   35,    0,    0,  -71,    0,    0,
    0,    0,    0,    0,  490,  496,  491,    0,   -7,   -1,
};
final static int YYTABLESIZE=1145;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   64,   67,   87,   53,   70,   97,  146,  129,  320,   53,
  118,  126,  291,  240,   37,   46,  174,  293,   69,  351,
  207,   73,  208,   70,   38,   53,   53,   42,   53,   76,
  290,  160,  252,   96,   65,  361,    2,  100,  101,   41,
   53,    7,   21,  349,  256,  264,  265,  117,   55,  266,
   99,  335,  336,   41,   71,   53,  125,  159,  161,  162,
  163,  348,  339,   74,  340,  333,  341,  102,    1,    3,
   88,   89,   73,   76,   90,    5,   53,  343,  112,  103,
  113,  353,   39,    2,  334,   98,  104,    2,  184,    3,
  370,   39,  119,    3,    4,    5,  127,  375,    4,    5,
   55,   39,  114,   39,  140,  141,   41,  115,  123,   53,
  128,  135,  142,  143,  131,  132,  134,   53,  136,  144,
  152,  130,  147,  150,   39,  153,  215,  165,  166,  168,
  169,   52,  148,  154,  170,  164,  183,  176,  179,   39,
  171,  211,  172,  204,  216,  214,  175,   63,   78,  225,
  188,   39,   52,  212,  149,  191,  192,  194,  195,  196,
  200,  180,  158,   39,  223,  213,  228,  229,  260,   80,
  230,   76,   76,  232,   76,   76,  233,  210,   39,  234,
  235,  247,   76,  217,  202,   76,  241,   41,   39,  227,
   39,   52,   82,  248,   76,  249,  250,  253,  236,  238,
  239,  254,  242,  243,  255,  309,   76,  245,   53,  310,
  267,   39,   45,   39,  327,  173,  282,  289,   84,   52,
  257,  259,  311,  261,  319,  263,   39,  154,  102,  154,
  102,   36,  102,   76,  145,   68,  102,  102,  102,  102,
    3,  285,    3,  287,    3,   20,    5,   73,    5,  251,
    5,  360,  124,  269,  269,  269,  269,  269,  269,  269,
  269,  269,    2,   76,   39,   76,   86,   76,    3,  102,
  102,  102,  102,    4,    5,  102,  269,  102,  102,  269,
  269,  269,  269,  269,  269,  269,  269,  269,  102,   39,
  102,   76,  102,   76,  325,  326,  328,  329,  330,   66,
  332,   51,   53,  102,   39,   15,   52,  102,   66,  269,
   16,  338,  205,   17,   15,  342,  102,  151,   66,   16,
   66,   19,   17,  102,   15,  292,   15,  268,  206,   16,
   19,   16,   17,  120,   17,   52,  297,  268,   52,  268,
   19,   66,   19,   47,   48,   77,  299,   15,  300,  102,
   50,  369,   16,  371,   52,   17,   66,  374,  294,   39,
  268,  102,   15,   19,   47,   48,   79,   16,   66,  301,
   17,   50,  231,  102,   15,  268,  102,   76,   19,   16,
   66,  102,   17,   39,  302,  314,   15,  268,  296,   81,
   19,   16,   39,  258,   17,   66,  304,  316,   40,  268,
   55,   15,   19,   47,   48,   66,   16,   66,  305,   17,
   50,   15,   72,   15,  268,   83,   16,   19,   16,   17,
   54,   17,   39,  306,  268,   95,  268,   19,   66,   19,
   66,   47,   48,  307,   15,  308,   15,   53,   50,   16,
   94,   16,   17,   14,   17,   39,  276,  268,  331,   15,
   19,   51,   19,  317,   16,  201,  324,   17,    2,   74,
  177,  345,   14,   85,    3,   19,   52,  178,   15,    4,
    5,  122,  122,   16,  318,   71,   17,    2,   69,   18,
  193,   14,  346,    3,   19,  321,   39,   15,    4,    5,
  122,  122,   16,  122,  322,   17,    2,  323,   18,   86,
   52,   39,    3,   19,  347,   39,   66,    4,    5,   65,
   67,   44,   15,  350,  209,  352,  354,   16,   47,   48,
   17,   66,  116,   18,   49,   50,   52,   15,   19,  356,
  355,  221,   16,  124,  124,   17,  124,  198,  124,    3,
  357,  367,  358,   19,  199,    5,  359,   47,   48,  362,
   47,   48,  124,  124,   50,  124,   49,   50,  363,  125,
  125,  364,  125,  365,  125,  373,   47,   48,    3,  366,
  368,    3,  376,   50,    5,  121,   66,    5,  125,  125,
  377,  125,   15,  126,  126,  295,  126,   16,  126,    4,
   17,  137,  220,  222,  122,  224,  133,   55,   19,  138,
   66,  139,  126,  126,    0,  126,   15,  123,  123,   66,
    0,   16,  244,    0,   17,   15,    0,   54,   75,  102,
   16,    0,   19,   17,  120,  120,  123,  123,    0,  123,
    0,   19,    0,    0,   53,    0,    0,   92,   93,   66,
    0,  121,  121,  120,    0,   15,    0,    0,   51,    0,
   16,  167,    0,   17,    0,    0,   74,    0,  118,  118,
  121,   19,   66,    0,    0,   39,    0,  237,   15,    0,
    0,   52,   71,   16,    0,   69,   17,  118,   47,   48,
    0,  268,  119,  119,   19,   50,    0,  122,  122,  122,
  122,  122,  122,  122,  122,   39,   86,  122,  122,  122,
  122,  119,  122,   66,    0,   39,   65,   67,   44,   15,
  122,    0,   47,   48,   16,   39,  185,   17,   66,   50,
    0,    0,   66,    0,   15,   19,    0,    0,   15,   16,
  219,  186,   17,   16,   39,  187,   17,    0,   47,   48,
   19,    0,    0,    0,   19,   50,    0,   39,    0,  124,
  124,  124,  124,  124,  124,  124,  124,   39,    0,  124,
  124,  124,  124,    0,  124,    0,   39,   39,    0,    0,
    0,    0,  124,    0,    0,  125,  125,  125,  125,  125,
  125,  125,  125,    0,   39,  125,  125,  125,  125,    0,
  125,   39,    0,  262,    0,    0,    0,   52,  125,  126,
  126,  126,  126,  126,  126,  126,  126,    0,   39,  126,
  126,  126,  126,    0,  126,  313,    0,  337,    0,    0,
    0,   52,  126,  123,  123,  123,  123,  123,  123,  123,
  123,    0,   39,  123,  123,  123,  123,    0,  123,   39,
  120,  120,  120,    0,    0,    0,  123,  120,    0,    0,
  120,  120,  120,  120,    0,  120,    9,  121,  121,  121,
   39,    0,    0,  120,  121,    0,    0,  121,  121,  121,
  121,    0,  121,    0,  118,  118,  118,    0,    0,    0,
  121,  118,   66,   47,   48,  118,  118,  118,   15,  118,
   50,    0,    0,   16,    0,  189,   17,  118,  119,  119,
  119,  109,    0,  110,   19,  119,    0,    0,    0,  119,
  119,  119,   66,  119,    0,    0,    0,    0,   15,    0,
    0,  119,   66,   16,    0,  190,   17,    0,   15,    0,
    0,    0,   66,   16,   19,  197,   17,    0,   15,    0,
    0,    0,    0,   16,   19,    0,   17,   66,  203,    0,
    0,   66,    0,   15,   19,    0,    0,   15,   16,    0,
    0,   17,   16,  218,   66,   17,    0,    0,   18,   19,
   15,    0,    0,   19,   66,   16,    0,  226,   17,    0,
   15,    0,    0,   66,   66,   16,   19,  246,   17,   15,
   15,    0,    0,    0,   16,   16,   19,   17,   17,    0,
  283,   66,  268,    0,    0,   19,   19,   15,   66,   47,
   48,    0,   16,    0,   15,   17,   50,  284,    0,   16,
    0,    0,   17,   19,  286,   66,    0,    0,    0,    0,
   19,   15,   66,   47,   48,    0,   16,    0,   15,   17,
   50,  288,    0,   16,    0,    0,   17,   19,  312,   66,
    0,    0,    0,    0,   19,   15,   66,    0,    0,    0,
   16,    0,   15,   17,    0,  315,    0,   16,    0,    0,
   17,   19,  372,    9,    0,    0,    0,   66,   19,    9,
    0,    0,    0,   15,    9,    0,    0,    9,   16,    9,
    0,   17,    0,    0,    0,    9,    0,    0,    0,   19,
  105,  106,  107,  108,  298,    0,    0,  298,  298,  298,
    0,  298,  298,  298,  298,  298,  273,  274,  275,  277,
  278,  279,  280,  281,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  298,    0,    0,
    0,    0,    0,    0,  303,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         15,
   16,   18,   40,   14,   20,   41,   41,   41,   59,   20,
   41,   41,   41,   41,   40,   59,   59,   59,   40,   59,
   59,  257,   59,   39,  257,   36,   37,  257,   39,   23,
   59,   41,   41,   49,   40,   59,  272,  256,  257,    7,
   51,    0,    1,   41,   41,   41,   41,   63,   14,   41,
   52,   41,   41,   21,   20,   66,   61,  129,  130,  131,
  132,   59,   41,   22,   41,  256,   41,  267,  257,  278,
   36,   37,  257,   67,   61,  284,   87,   41,   43,   41,
   45,   41,   40,  272,  275,   51,  266,  272,  160,  278,
   41,   40,  265,  278,  283,  284,   41,   41,  283,  284,
   66,   40,   42,   40,  112,  113,   74,   47,   61,  120,
   40,  257,  114,  115,   41,   41,   41,  128,   41,  269,
   61,   87,  269,  258,   40,  258,   40,  144,  145,  146,
  147,   45,   41,  269,   41,   59,   41,  154,  155,   40,
   59,   59,   59,  282,   58,   40,   59,   40,   59,   59,
  167,   40,   45,   59,  120,  171,  172,  173,  174,  175,
  177,  155,  128,   40,   40,   59,  258,  258,   59,   59,
  258,  165,  166,   59,  168,  169,  258,  193,   40,  258,
  258,   41,  176,  199,  178,  179,   40,  155,   40,  206,
   40,   45,   59,   41,  188,   41,   41,   41,  214,  215,
  216,   41,  218,  219,   41,  275,  200,  223,  219,   40,
   59,   40,  256,   40,   40,  258,   59,   59,   59,   45,
  237,  238,   40,  240,  275,  241,   40,  269,  267,  269,
  267,  257,  267,  227,  269,  257,  267,  267,  267,  267,
  278,  258,  278,  260,  278,   40,  284,  257,  284,  258,
  284,  275,  257,  247,  248,  249,  250,  251,  252,  253,
  254,  255,  272,  257,   40,  259,   59,  261,  278,  267,
  267,  267,  267,  283,  284,  267,  270,  267,  267,  273,
  274,  275,  276,  277,  278,  279,  280,  281,  267,   40,
  267,  285,  267,  287,  310,  311,  312,  313,  314,  257,
  316,   40,  313,  267,   40,  263,   45,  267,  257,  303,
  268,  327,  270,  271,  263,  331,  267,  258,  257,  268,
  257,  279,  271,  267,  263,   59,  263,  276,  286,  268,
  279,  268,  271,   40,  271,   45,  285,  276,   45,  276,
  279,  257,  279,  257,  258,  256,  285,  263,  285,  267,
  264,  367,  268,  370,   45,  271,  257,  373,   59,   40,
  276,  267,  263,  279,  257,  258,  256,  268,  257,  285,
  271,  264,  258,  267,  263,  276,  267,  371,  279,  268,
  257,  267,  271,   40,  285,   40,  263,  276,   59,  256,
  279,  268,   40,   41,  271,  257,  285,   40,    7,  276,
   59,  263,  279,  257,  258,  257,  268,  257,  285,  271,
  264,  263,   21,  263,  276,  256,  268,  279,  268,  271,
   59,  271,   40,  285,  276,   44,  276,  279,  257,  279,
  257,  257,  258,  285,  263,  285,  263,   59,  264,  268,
   59,  268,  271,  257,  271,   40,   41,  276,   40,  263,
  279,   59,  279,  275,  268,  282,  285,  271,  272,   59,
  274,   59,  257,  256,  278,  279,   45,  281,  263,  283,
  284,   40,   41,  268,  275,   59,  271,  272,   59,  274,
   59,  257,   59,  278,  279,  275,   40,  263,  283,  284,
   59,   60,  268,   62,  275,  271,  272,  275,  274,   59,
   45,   40,  278,  279,   59,   40,  257,  283,  284,   59,
   59,   59,  263,   59,   59,   59,   59,  268,  257,  258,
  271,  257,   41,  274,  263,  264,   45,  263,  279,  275,
  280,  282,  268,   40,   41,  271,   43,  273,   45,  278,
  275,   40,  275,  279,  280,  284,  275,  257,  258,  275,
  257,  258,   59,   60,  264,   62,  263,  264,  275,   40,
   41,  275,   43,  275,   45,   40,  257,  258,  278,  275,
  256,  278,   59,  264,  284,  256,  257,  284,   59,   60,
  275,   62,  263,   40,   41,  256,   43,  268,   45,    0,
  271,  102,  201,  202,  275,  204,   90,  256,  279,  104,
  257,  111,   59,   60,   -1,   62,  263,   40,   41,  257,
   -1,  268,  221,   -1,  271,  263,   -1,  256,  275,  267,
  268,   -1,  279,  271,   40,   41,   59,   60,   -1,   62,
   -1,  279,   -1,   -1,  256,   -1,   -1,  256,  257,  257,
   -1,   40,   41,   59,   -1,  263,   -1,   -1,  256,   -1,
  268,  269,   -1,  271,   -1,   -1,  256,   -1,   40,   41,
   59,  279,  257,   -1,   -1,   40,   -1,   41,  263,   -1,
   -1,   45,  256,  268,   -1,  256,  271,   59,  257,  258,
   -1,  276,   40,   41,  279,  264,   -1,  256,  257,  258,
  259,  260,  261,  262,  263,   40,  256,  266,  267,  268,
  269,   59,  271,  257,   -1,   40,  256,  256,  256,  263,
  279,   -1,  257,  258,  268,   40,  270,  271,  257,  264,
   -1,   -1,  257,   -1,  263,  279,   -1,   -1,  263,  268,
   40,  270,  271,  268,   40,  270,  271,   -1,  257,  258,
  279,   -1,   -1,   -1,  279,  264,   -1,   40,   -1,  256,
  257,  258,  259,  260,  261,  262,  263,   40,   -1,  266,
  267,  268,  269,   -1,  271,   -1,   40,   40,   -1,   -1,
   -1,   -1,  279,   -1,   -1,  256,  257,  258,  259,  260,
  261,  262,  263,   -1,   40,  266,  267,  268,  269,   -1,
  271,   40,   -1,   41,   -1,   -1,   -1,   45,  279,  256,
  257,  258,  259,  260,  261,  262,  263,   -1,   40,  266,
  267,  268,  269,   -1,  271,   40,   -1,   41,   -1,   -1,
   -1,   45,  279,  256,  257,  258,  259,  260,  261,  262,
  263,   -1,   40,  266,  267,  268,  269,   -1,  271,   40,
  256,  257,  258,   -1,   -1,   -1,  279,  263,   -1,   -1,
  266,  267,  268,  269,   -1,  271,   40,  256,  257,  258,
   40,   -1,   -1,  279,  263,   -1,   -1,  266,  267,  268,
  269,   -1,  271,   -1,  256,  257,  258,   -1,   -1,   -1,
  279,  263,  257,  257,  258,  267,  268,  269,  263,  271,
  264,   -1,   -1,  268,   -1,  270,  271,  279,  256,  257,
  258,   60,   -1,   62,  279,  263,   -1,   -1,   -1,  267,
  268,  269,  257,  271,   -1,   -1,   -1,   -1,  263,   -1,
   -1,  279,  257,  268,   -1,  270,  271,   -1,  263,   -1,
   -1,   -1,  257,  268,  279,  270,  271,   -1,  263,   -1,
   -1,   -1,   -1,  268,  279,   -1,  271,  257,  273,   -1,
   -1,  257,   -1,  263,  279,   -1,   -1,  263,  268,   -1,
   -1,  271,  268,  273,  257,  271,   -1,   -1,  274,  279,
  263,   -1,   -1,  279,  257,  268,   -1,  270,  271,   -1,
  263,   -1,   -1,  257,  257,  268,  279,  270,  271,  263,
  263,   -1,   -1,   -1,  268,  268,  279,  271,  271,   -1,
  273,  257,  276,   -1,   -1,  279,  279,  263,  257,  257,
  258,   -1,  268,   -1,  263,  271,  264,  273,   -1,  268,
   -1,   -1,  271,  279,  273,  257,   -1,   -1,   -1,   -1,
  279,  263,  257,  257,  258,   -1,  268,   -1,  263,  271,
  264,  273,   -1,  268,   -1,   -1,  271,  279,  273,  257,
   -1,   -1,   -1,   -1,  279,  263,  257,   -1,   -1,   -1,
  268,   -1,  263,  271,   -1,  273,   -1,  268,   -1,   -1,
  271,  279,  273,  257,   -1,   -1,   -1,  257,  279,  263,
   -1,   -1,   -1,  263,  268,   -1,   -1,  271,  268,  273,
   -1,  271,   -1,   -1,   -1,  279,   -1,   -1,   -1,  279,
  259,  260,  261,  262,  270,   -1,   -1,  273,  274,  275,
   -1,  277,  278,  279,  280,  281,  248,  249,  250,  251,
  252,  253,  254,  255,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  303,   -1,   -1,
   -1,   -1,   -1,   -1,  276,
};
}
final static short YYFINAL=6;
final static short YYMAXTOKEN=286;
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
null,null,null,null,null,null,"IDENTIFICADOR","CTE_UINT","MAYOR_IGUAL",
"MENOR_IGUAL","IGUAL_IGUAL","DISTINTO","ASIGNACION","CTE_DOUBLE","CADENA","AND",
"OR","IF","THEN","ENDIF","PRINT","FUNC","RETURN","BEGIN","END","BREAK","ULONG",
"DOUBLE","REPEAT","PRE","TRY","CATCH","TYPEDEF","UINT","ENDREPEAT","ELSE",
};
final static String yyrule[] = {
"$accept : programa",
"programa : IDENTIFICADOR bloque_declarativo bloque_ejecutable",
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
"sentencia_ejecucion : control ';'",
"sentencia_ejecucion : seleccion ';'",
"sentencia_ejecucion : impresion ';'",
"sentencia_ejecucion : invocacion ';'",
"sentencia_ejecucion : asignacion ';'",
"sentencia_ejecucion : error_ejecucion",
"error_ejecucion : control error",
"error_ejecucion : seleccion error",
"error_ejecucion : impresion error",
"error_ejecucion : asignacion error",
"error_ejecucion : invocacion error",
"declaracion : tipo lista_de_variables ';'",
"declaracion : funcion ';'",
"declaracion : TYPEDEF IDENTIFICADOR '=' funcion ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"error_declaracion : funcion error",
"tipo : UINT",
"tipo : DOUBLE",
"control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
"control : error_control",
"error_control : REPEAT IDENTIFICADOR '=' CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' '=' CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' ';' CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' condicion CTE_UINT ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' condicion ';' ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' condicion ';' CTE_UINT bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' condicion ';' CTE_UINT ')' ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control",
"bloque_control : sentencia_control",
"bloque_control : bloque_control sentencia_control",
"sentencia_control : sentencia_ejecucion",
"sentencia_control : BREAK ';'",
"sentencia_control : error_sentencia_control",
"error_sentencia_control : BREAK error",
"asignacion : IDENTIFICADOR ASIGNACION condicion",
"asignacion : error_asignacion",
"error_asignacion : ASIGNACION condicion",
"error_asignacion : IDENTIFICADOR condicion",
"error_asignacion : IDENTIFICADOR ASIGNACION",
"seleccion : IF '(' condicion ')' THEN bloque_sentencias ENDIF ';'",
"seleccion : IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias ENDIF ';'",
"seleccion : error_seleccion",
"error_seleccion : '(' condicion ')' THEN bloque_sentencias ENDIF",
"error_seleccion : IF condicion ')' THEN bloque_sentencias ENDIF",
"error_seleccion : IF '(' ')' THEN bloque_sentencias ENDIF",
"error_seleccion : IF '(' condicion THEN bloque_sentencias ENDIF",
"error_seleccion : IF '(' condicion ')' bloque_sentencias ENDIF",
"error_seleccion : IF '(' condicion ')' THEN ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_sentencias",
"error_seleccion : IF '(' condicion ')' THEN bloque_sentencias ELSE ENDIF",
"error_seleccion : IF '(' condicion ')' THEN bloque_sentencias ELSE bloque_sentencias",
"impresion : PRINT '(' CADENA ')'",
"invocacion : IDENTIFICADOR '(' parametro ')'",
"invocacion : error_invocacion",
"error_invocacion : '(' parametro ')'",
"error_invocacion : IDENTIFICADOR parametro ')'",
"error_invocacion : IDENTIFICADOR '(' ')'",
"error_invocacion : IDENTIFICADOR '(' parametro",
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
"bloque_funcion : bloque_declarativo bloque_ejecucion_funcion",
"bloque_funcion : bloque_declarativo TRY sentencia_ejecucion CATCH bloque_ejecutable",
"bloque_funcion : error_bloque_funcion",
"error_bloque_funcion : bloque_declarativo sentencia_ejecucion CATCH bloque_ejecutable",
"error_bloque_funcion : bloque_declarativo TRY CATCH bloque_ejecutable",
"error_bloque_funcion : bloque_declarativo TRY sentencia_ejecucion bloque_ejecutable",
"bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN PRE ':' condicion ';' bloque_sentencias RETURN '(' condicion ')' END",
"bloque_ejecucion_funcion : error_bloque_ejecucion_funcion",
"error_bloque_ejecucion_funcion : bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ';' END",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' END",
"$$1 :",
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias RETURN '(' condicion ')' ';' error $$1 PRE '(' condicion ')' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias RETURN condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias RETURN '(' ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias RETURN '(' condicion ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias RETURN '(' condicion ')' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion ')' bloque_sentencias RETURN '(' condicion ')' ';' error",
"error_bloque_ejecucion_funcion : BEGIN PRE condicion ')' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' ')' bloque_sentencias RETURN '(' condicion ')' ';' END",
"error_bloque_ejecucion_funcion : BEGIN PRE '(' condicion bloque_sentencias RETURN '(' condicion ')' ';' END",
"condicion : expresion",
"condicion : condicion OR expresion",
"expresion : expresionn",
"expresion : expresion AND expresionn",
"expresionn : expresionnn",
"expresionn : expresionn comparador expresionnn",
"expresionnn : termino",
"expresionnn : expresionnn '+' termino",
"expresionnn : expresionnn '-' termino",
"termino : termino '*' factor",
"termino : termino '/' factor",
"termino : factor",
"factor : CTE_DOUBLE",
"factor : CTE_UINT",
"factor : '-' factor",
"factor : IDENTIFICADOR",
"comparador : '<'",
"comparador : '>'",
"comparador : IGUAL_IGUAL",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
};

//#line 255 "Gramatica.y"

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
//#line 733 "Parser.java"
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
{System.out.println("Sintactico : se leyo el programa llamado " +val_peek(2).sval);}
break;
case 3:
//#line 16 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + "Se debe indicar un nombre para el programa");}
break;
case 4:
//#line 17 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + "Mal posicionamiento de sentencias declarativas");}
break;
case 11:
//#line 34 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + "Se detectó un END pero falta un BEGIN para iniciar el bloque");}
break;
case 12:
//#line 35 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + "Se detectó un BEGIN per falta un END para cerrar el bloque");}
break;
case 19:
//#line 48 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 20:
//#line 49 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 21:
//#line 50 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 22:
//#line 51 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 23:
//#line 52 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 24:
//#line 56 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se detectó una declaracion de variables");}
break;
case 28:
//#line 62 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 29:
//#line 63 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 30:
//#line 68 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo UINT");}
break;
case 31:
//#line 69 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó un tipo DOUBLE");}
break;
case 32:
//#line 72 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó una sentencia REPEAT");}
break;
case 34:
//#line 76 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta '('");}
break;
case 35:
//#line 77 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta el identificador ");}
break;
case 36:
//#line 78 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta '='");}
break;
case 37:
//#line 79 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta una constante UINT");}
break;
case 38:
//#line 80 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta ';'");}
break;
case 39:
//#line 81 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta la condición");}
break;
case 40:
//#line 82 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta ';'");}
break;
case 41:
//#line 83 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta una constante CTE_UINT");}
break;
case 42:
//#line 84 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta ')'");}
break;
case 43:
//#line 85 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta el bloque de sentencias");}
break;
case 44:
//#line 86 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un REPEAT mal declarado, falta indicar el fin del ciclo con ENDREPEAT");}
break;
case 50:
//#line 98 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 53:
//#line 106 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta el identificador del lado izquierdo de la asignación");}
break;
case 54:
//#line 107 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta ':=' en la asignación");}
break;
case 55:
//#line 108 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " falta una expresión aritmética del lado derecho de la asignación");}
break;
case 59:
//#line 118 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una seleccion mal declarado, falta el IF");}
break;
case 60:
//#line 119 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta '('");}
break;
case 61:
//#line 120 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta la condicion");}
break;
case 62:
//#line 121 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta ')'");}
break;
case 63:
//#line 122 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el THEN");}
break;
case 64:
//#line 123 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el bloque de sentencias");}
break;
case 65:
//#line 124 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el ENDIF o ELSE");}
break;
case 66:
//#line 125 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el bloque de sentencias del ELSE");}
break;
case 67:
//#line 126 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un IF mal declarado, falta el ENDIF");}
break;
case 69:
//#line 134 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una invocacion al procedimiento '" + val_peek(3).sval + "'");}
break;
case 71:
//#line 138 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el identificador");}
break;
case 72:
//#line 139 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el '('");}
break;
case 73:
//#line 140 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el parametro");}
break;
case 74:
//#line 141 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una invocación mal declarada, falta el ')'");}
break;
case 75:
//#line 145 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 76:
//#line 146 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyo el identificador -> " + val_peek(0).sval);}
break;
case 78:
//#line 151 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ',' entre los identificadores");}
break;
case 79:
//#line 153 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se declaró una funcion llamada '"+ val_peek(4).sval +"'" );}
break;
case 81:
//#line 158 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta el FUNC");}
break;
case 82:
//#line 159 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta el nombre ");}
break;
case 83:
//#line 160 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta '(' ");}
break;
case 84:
//#line 161 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta el parametro ");}
break;
case 85:
//#line 162 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta ')' ");}
break;
case 86:
//#line 163 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una funcion mal declarada, falta bloque de sentencias ");}
break;
case 89:
//#line 170 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un parámetro mal declarado, falta el nombre identificador");}
break;
case 93:
//#line 179 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el TRY");}
break;
case 94:
//#line 180 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, la sentencia ejecutable despues del TRY");}
break;
case 95:
//#line 181 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el CATCH");}
break;
case 99:
//#line 189 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 100:
//#line 190 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 101:
//#line 191 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el RETURN");}
break;
case 102:
//#line 192 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta '(' ");}
break;
case 103:
//#line 193 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta indicar el retorno");}
break;
case 104:
//#line 194 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ')' ");}
break;
case 105:
//#line 195 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ';' ");}
break;
case 106:
//#line 196 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el END ");}
break;
case 107:
//#line 198 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 108:
//#line 199 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 109:
//#line 200 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el RETURN");}
break;
case 110:
//#line 201 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta '(' ");}
break;
case 111:
//#line 202 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta indicar el retorno");}
break;
case 112:
//#line 203 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ')' ");}
break;
case 113:
//#line 204 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ';' ");}
break;
case 114:
//#line 205 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el END ");}
break;
case 115:
//#line 207 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta '(' ");}
break;
case 116:
//#line 208 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta la condicion del PRE");}
break;
case 117:
//#line 209 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta ')' ");}
break;
case 119:
//#line 216 "Gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 125:
//#line 228 "Gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una suma");}
break;
case 126:
//#line 229 "Gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una resta");}
break;
case 127:
//#line 232 "Gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una multiplicacion");}
break;
case 128:
//#line 233 "Gramatica.y"
{ System.out.println("[Parser | Linea " + Lexico.linea + "] se realizó una division");}
break;
case 130:
//#line 238 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante double -> " + val_peek(0).sval);}
break;
case 131:
//#line 239 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó la constante uint -> " + val_peek(0).sval);}
break;
case 132:
//#line 240 "Gramatica.y"
{chequearFactorNegado();}
break;
case 133:
//#line 241 "Gramatica.y"
{System.out.println("[Parser | Linea " + Lexico.linea + "] se leyó el identificador -> " + val_peek(0).sval);}
break;
//#line 1230 "Parser.java"
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
