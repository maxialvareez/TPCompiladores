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






//#line 2 "gramatica.y"
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
public final static short ENDREPEAT=284;
public final static short ELSE=285;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    0,    3,    3,    1,    1,    2,    2,    5,    5,
    6,    6,    7,    7,    7,    7,    7,    7,   13,   13,
   13,   13,   13,    4,    4,    4,    4,   18,   18,   18,
   14,   14,    8,    8,   21,   21,   21,   21,   21,   21,
   21,   21,   21,   21,   21,   20,   20,   22,   22,   22,
   23,   12,   12,   24,   24,   24,    9,    9,    9,   25,
   25,   25,   25,   25,   25,   25,   25,   25,   10,   11,
   11,   27,   27,   27,   27,   15,   15,   15,   28,   16,
   16,   30,   30,   30,   30,   30,   30,   26,   26,   31,
   17,   32,   29,   29,   29,   34,   34,   34,   33,   33,
   33,   35,   35,   35,   35,   35,   35,   35,   36,   35,
   35,   35,   35,   35,   35,   35,   35,   35,   35,   35,
   19,   19,   37,   37,   38,   38,   39,   39,   39,   41,
   41,   41,   42,   42,   42,   42,   40,   40,   40,   40,
   40,   40,
};
final static short yylen[] = {                            2,
    3,    1,    2,    3,    1,    2,    3,    1,    1,    2,
    2,    3,    2,    2,    2,    2,    2,    1,    2,    2,
    2,    2,    2,    3,    3,    6,    1,    3,    3,    2,
    1,    1,   12,    1,   11,   11,   11,   11,   11,   11,
   11,   11,   11,   11,   11,    1,    2,    1,    2,    1,
    2,    3,    1,    2,    2,    2,    8,   10,    1,    6,
    6,    6,    6,    6,    6,    6,    8,    8,    4,    4,
    1,    3,    3,    3,    3,    3,    1,    1,    2,    6,
    1,    5,    5,    5,    5,    5,    5,    2,    1,    2,
    5,    2,    2,    5,    1,    4,    4,    4,    8,   11,
    1,    7,    7,    7,    7,    7,    7,    7,    0,   20,
   11,   11,   11,   11,   11,   11,   12,   11,   11,   11,
    1,    3,    1,    3,    1,    3,    1,    3,    3,    3,
    3,    1,    1,    1,    2,    1,    1,    1,    1,    1,
    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   31,   32,    0,    0,    0,    2,    5,    0,
    0,   27,   81,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,    9,    0,    0,    0,    0,    0,
   18,   34,   53,   59,   71,    0,    0,    0,    0,    3,
    6,    0,    0,    0,   78,   30,  136,  134,    0,  133,
    0,    0,    0,    0,    0,   89,    0,    0,    0,    0,
  132,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,   11,   10,   19,   13,   20,   14,
   21,   15,   23,   16,   22,   17,    0,    0,    0,    0,
    0,    0,   28,   79,   24,    0,   29,   25,    0,   74,
    0,  135,   90,   88,    0,   73,    0,  140,  141,  139,
  142,  137,  138,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   12,    7,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   72,    0,   76,    0,    0,
    0,    0,    0,    0,  130,  131,    0,    0,    0,    0,
   69,    0,    0,    0,    0,    0,    0,    0,    0,   82,
   95,   85,    0,   86,   84,   83,    0,    0,    0,    0,
    0,    0,    0,    0,   70,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   93,  101,   80,    0,
   26,   62,   63,   65,    0,   64,   61,    0,    0,    0,
    0,    0,    0,    0,   60,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   97,
    0,   98,    0,   96,    0,   57,   67,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   94,    0,    0,   91,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   77,    0,   58,    0,   48,    0,   46,   50,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   51,   49,   35,   47,   37,    0,   40,   41,
   44,    0,   43,   42,   39,   38,   36,  103,    0,    0,
    0,    0,    0,    0,    0,  106,  107,  108,    0,  105,
  104,  102,   33,    0,    0,    0,    0,    0,    0,    0,
    0,  109,   99,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  119,  111,  114,  115,  116,    0,
  113,  112,  120,  100,  118,    0,  117,    0,    0,    0,
    0,    0,    0,    0,    0,  110,
};
final static short yydgoto[] = {                          6,
  159,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  168,   12,   54,  287,
   32,  288,  289,   33,   34,   91,   35,   45,  160,   13,
   56,  259,  187,  161,  188,  363,   57,   58,   59,  114,
   60,   61,
};
final static short yysindex[] = {                      -168,
   71,  -29,    0,    0, -218,    0,  241,    0,    0, -232,
   -4,    0,    0,  864,  363,  385,    7,  852,  -27,  317,
  241, -156,  639,    0,    0,  -44,   24,   47,   95,  110,
    0,    0,    0,    0,    0,  -34, -215,   -1,  317,    0,
    0,   38,  320,  124,    0,    0,    0,    0,  363,    0,
   -9,  363, -190, -197,   40,    0, -187,  922,  -12,   11,
    0, -197,  620,  -25, -181,  897,  406,   35,   83,  -20,
   49,    0,   38, -156,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   13,   50,   51, -215,
   58, -215,    0,    0,    0, -150,    0,    0, -197,    0,
   67,    0,    0,    0,  363,    0,  363,    0,    0,    0,
    0,    0,    0,  363,  363,  363,  363,  363, -157,  -38,
 -152,   82,   -9,    0,    0, -140,  137, -133, -143, -156,
 -156,   30, -156, -156, -144,    0,   89,    0, -156, -187,
  922,  -12,   11,   11,    0,    0,  852,  852,  443,  852,
    0,   94,   78,   79, -118,  -42,   86,  852,  216,    0,
    0,    0, -156,    0,    0,    0,  106,   88, -156,  649,
  664,  668,  683,  687,    0,  363,  363,   90,  -37,  363,
  363,  702,  270,  266,  706, -141,    0,    0,    0, -215,
    0,    0,    0,    0,  -31,    0,    0,  -45,   60,  363,
  346,   65,   70,   77,    0,  108,  112,  723,  732,  243,
  111,  732,  109,   96,  747, -105,  -99,   80,  -95,   -7,
  -90,  -87,  -86,  363,  755,  363,  -18,  486,  317,    0,
  732,    0,  363,    0,  -84,    0,    0,  757,  133,  138,
  -81,  140,  141,  -23,  143,  146,  148,    3,  852,  334,
  101,  852,  881,    5,   10,    0,   18,  -79,    0,  131,
  772,  772,  150,  772,  772,  361,  772,  772,  772,  772,
  142,  781,  782,  801,  852,  805,  144,  -22,  145,  -14,
  147,    0,  -32,    0,  194,    0,   -5,    0,    0,   21,
  772,   25,   62,  135,  136,  153,  160,  177,  184,  -80,
  154,  156,  820,  157,  832,  162,  -70,  -68,  -52,  -67,
  -60,  122,    0,    0,    0,    0,    0,  201,    0,    0,
    0,  772,    0,    0,    0,    0,    0,    0,  363,  363,
  490,  317,  363,  382,  363,    0,    0,    0, -226,    0,
    0,    0,    0,   27,   28,  900,   31,   44,   45,  363,
   54,    0,    0,  367,  368,  374,  -21,  376,   -2,  379,
   56,  390,  171,  190,  191,  199,  200,   61,  207,  217,
  221,  226,  232,  451,    0,    0,    0,    0,    0,  220,
    0,    0,    0,    0,    0,  363,    0,   57,  852,  833,
  470,  363,   59,  457,  253,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  579,    0,    0,    0,    0,    0,    0,  313,    0,
    0,    0,    0,  359,    0,    0,  612,  430,  571,  499,
    0,  383,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  532,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  395,    0,
  400,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  403,
    0,    0,    0,    0,    0,    0,    0,    0,  408,  632,
  462,  595,  523,  547,    0,    0,    0,    0,    0,    0,
    0,  400,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  419,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  845,    0,    0,    0,    0,
    0,    0,    0,    0,  427,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  446,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  477,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  449,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   42,  436,    0,   29,  -16,    0,   91,    0,    0,    0,
    0,    0,    0,  -10,  288,  537,    0,    0,  -15,  943,
    0,  898,    0,    0,    0, 1112,    0,    0,  -58,    0,
    0,    0,    0,    0,    0,    0,  447,  444,  439,    0,
  -28,  -24,
};
final static int YYTABLESIZE=1237;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   64,   67,  149,   53,   70,   87,  339,   52,   39,   53,
   37,   96,   69,  216,   78,  121,  180,  267,  309,  368,
  129,  201,  252,   70,   42,   53,   53,  102,   53,  352,
  115,  100,  116,   99,   39,   41,  308,  367,   38,    2,
   53,    7,   21,  271,  311,  279,   65,  120,  353,   41,
  280,  244,  117,  131,   46,   53,  370,  118,  281,   90,
   39,    3,    4,   74,   39,  103,  104,  354,  355,  105,
  163,  358,  162,  164,  165,  166,   53,   92,  107,  135,
  106,   53,   80,  122,  359,  360,  143,  144,    1,  130,
  133,  134,  145,  146,  362,  126,  372,  389,  136,  394,
   73,   39,   41,    2,  189,   82,  138,  139,    3,    4,
   20,  147,   53,   76,    5,    2,  150,  153,  217,  380,
    3,    4,  151,  221,  157,  158,    5,  167,  222,  169,
  170,  171,  173,  174,  175,  223,  176,  177,  241,  178,
  212,  182,  185,  128,  181,  190,  191,  224,  200,  235,
  233,  225,  239,   84,  236,  195,   52,   76,  240,  275,
  198,  199,  242,  202,  203,  204,  208,  245,   86,  226,
  246,  247,  258,  261,   39,   39,  263,  282,  262,  213,
  264,  265,   98,  268,  218,  220,  269,   41,  270,  284,
  291,  227,   39,  329,  328,  330,  333,  156,  238,   39,
  300,  335,  307,  310,  336,  312,  337,  340,  248,  250,
  251,   77,  254,  255,  341,  179,   39,  257,   53,   47,
   48,  105,  338,   39,   94,   66,   50,   36,  105,   68,
  148,   15,  272,  274,  266,  276,   16,  278,  214,   17,
   39,  105,    3,    4,  105,  105,  105,   19,  105,  186,
  243,   66,  314,  215,  158,   39,  303,   15,  305,  105,
   76,   76,   16,   76,   76,   17,  158,    3,    4,  105,
  285,  105,   76,   19,  210,   76,  105,   66,  315,   79,
   39,   66,   39,   15,  105,   76,   73,   15,   16,    3,
    4,   17,   16,  105,  105,   17,  285,  105,   76,   19,
  285,    2,   81,   19,  317,   39,    3,    4,  319,   39,
  105,  105,    5,  344,  345,  347,  348,  349,   66,  351,
  105,   53,  105,  105,   15,  105,  105,   14,   76,   16,
  357,  105,   17,   15,  361,  379,  105,  285,   16,  127,
   19,   17,    2,  105,   18,  320,  105,    3,    4,   19,
   83,  286,  286,    5,  286,  286,  286,  286,  286,  286,
  286,   52,   76,   96,   76,   85,   76,  105,   47,   48,
  388,   56,  390,   39,  273,   50,  393,  286,   95,   97,
  286,  286,  286,  286,  286,  286,  286,  286,  286,  286,
   52,   66,   66,   76,  154,   76,  342,   15,   15,  155,
   39,  294,   16,   16,  219,   17,   17,   52,  286,   66,
  285,  285,  286,   19,   19,   15,   66,   55,  321,  323,
   16,  350,   15,   17,   63,  364,  365,   16,  285,   52,
   17,   19,  366,   66,  369,  285,  324,  371,   19,   15,
   66,   54,   40,  325,   16,   39,   15,   17,  373,  313,
  374,   16,  285,   52,   17,   19,   72,   66,   75,  285,
  326,   72,   19,   15,  375,  376,   70,  327,   16,  123,
  123,   17,   14,  377,  378,  387,  285,   87,   15,   19,
   76,  381,   39,   16,  343,   66,   17,    2,  123,  183,
  386,  382,    3,    4,   19,  383,  184,   14,    5,   66,
  384,  124,  124,   15,   68,   15,  385,   45,   16,  392,
   16,   17,    2,   17,   18,  395,   18,    3,    4,   19,
  124,   19,   66,    5,  231,  253,   66,  396,   15,  346,
   52,    4,   15,   16,   52,   92,   17,   16,  127,  127,
   17,  127,  206,  127,   19,  283,   44,  209,   19,  207,
  141,  140,  142,    0,    0,    0,    0,  127,  127,    0,
  127,    0,  128,  128,    0,  128,    0,  128,   56,    0,
    0,    0,    0,   47,   48,   93,   94,    0,    0,    0,
   50,  128,  128,    0,  128,    0,  129,  129,    0,  129,
   66,  129,    0,    3,    4,    0,   15,    0,    0,    0,
  105,   16,   47,   48,   17,  129,  129,    0,  129,   50,
  125,  125,   19,    0,   55,    0,    0,   66,    0,   47,
   48,    0,   77,   15,    0,    0,   50,    0,   16,  125,
  125,   17,  125,    0,  126,  126,  285,   77,   54,   19,
    0,   47,   48,    0,  230,  232,    0,  234,   50,    0,
   52,  121,  121,  126,  126,   75,  126,    0,   72,    0,
  119,  124,   66,   70,   52,    0,  256,    0,   15,    0,
  121,  122,  122,   16,   87,    0,   17,    0,   39,    0,
  125,    0,   66,    0,   19,  123,  123,  123,   39,    0,
  122,    0,  123,    0,    0,  123,  123,  123,  123,   66,
  123,   68,    0,   39,   45,   15,    0,   39,  123,    0,
   16,  172,    0,   17,    0,    0,    0,  124,  124,  124,
    0,   19,   39,    0,  124,    0,   39,  124,  124,  124,
  124,    0,  124,    0,    0,    0,    0,    0,    0,    0,
  124,   39,   47,   48,    0,   39,   47,   48,    0,   50,
    0,    0,    0,   50,  127,  127,  127,  127,  127,  127,
  127,  127,  229,    0,  127,  127,  127,  127,    0,  127,
    0,   39,    0,    0,    0,    0,    0,  127,  128,  128,
  128,  128,  128,  128,  128,  128,   39,    0,  128,  128,
  128,  128,    0,  128,    0,  249,   39,    0,    0,   52,
    0,  128,  129,  129,  129,  129,  129,  129,  129,  129,
    0,   39,  129,  129,  129,  129,    0,  129,    0,    0,
   39,   39,    0,    0,    0,  129,  125,  125,  125,  125,
  125,  125,  125,  125,   77,   77,  125,  125,  125,  125,
   39,  125,    0,    0,   39,    0,    0,    0,    0,  125,
  126,  126,  126,  126,  126,  126,  126,  126,    0,  332,
  126,  126,  126,  126,    0,  126,    0,  121,  121,  121,
    0,   39,   39,  126,  121,    0,   47,   48,  121,  121,
  121,    0,  121,   50,    9,    0,    0,  122,  122,  122,
  121,   39,    0,    0,  122,   66,    0,    0,  122,  122,
  122,   15,  122,   51,    0,   66,   16,    0,   52,   17,
  122,   15,    0,   75,    0,    0,   16,   19,  192,   17,
   66,  277,    0,    0,   66,   52,   15,   19,    0,    0,
   15,   16,    0,  193,   17,   16,  123,  194,   17,   66,
  356,   52,   19,   66,   52,   15,   19,    0,    0,   15,
   16,    0,  196,   17,   16,    0,  197,   17,   66,    0,
    0,   19,   66,    0,   15,   19,    0,    0,   15,   16,
    0,  205,   17,   16,    0,    0,   17,    0,  211,   66,
   19,  112,    0,  113,   19,   15,    0,    0,   66,    0,
   16,    0,    0,   17,   15,  228,    0,    0,    0,   16,
    0,   19,   17,   66,    0,   18,    0,    0,    0,   15,
   19,   47,   48,   66,   16,    0,  237,   17,   50,   15,
    0,    0,    0,    0,   16,   19,  260,   17,   66,    0,
    0,    0,    0,    0,   15,   19,    0,   66,   66,   16,
    0,    0,   17,   15,   15,    0,    0,  285,   16,   16,
   19,   17,   17,  301,  302,    0,    0,   66,    0,   19,
   19,   66,    0,   15,    0,    0,    0,   15,   16,    0,
    0,   17,   16,  304,    0,   17,   66,  306,    0,   19,
    0,    0,   15,   19,    0,    0,    0,   16,   66,   66,
   17,    0,  331,    0,   15,   15,    0,    0,   19,   16,
   16,    9,   17,   17,  334,  391,    0,    9,   66,    0,
   19,   19,    9,    0,   15,    9,    0,    9,    0,   16,
   47,   48,   17,    9,    0,   55,   49,   50,    0,    0,
   19,   71,    0,    0,    0,    0,    0,   47,   48,    0,
    3,    4,    0,    0,   50,    0,    0,   88,   89,    0,
    0,    0,    0,   47,   48,    0,   47,   48,    0,   49,
   50,    0,  101,   50,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    3,    4,    0,    0,   55,    0,    0,
  108,  109,  110,  111,  316,    0,    0,  316,    0,  316,
  316,    0,  316,  316,  316,  316,  316,    0,  132,    0,
    0,    0,    0,  137,  290,    0,  292,  293,  295,  296,
  297,  298,  299,    0,    0,  316,    0,    0,    0,  316,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  318,  152,    0,  322,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         15,
   16,   18,   41,   14,   20,   40,   59,   45,   40,   20,
   40,   44,   40,   59,   59,   41,   59,   41,   41,   41,
   41,   59,   41,   39,  257,   36,   37,   52,   39,  256,
   43,   41,   45,   49,   40,    7,   59,   59,  257,  272,
   51,    0,    1,   41,   59,   41,   40,   63,  275,   21,
   41,   59,   42,   41,   59,   66,   59,   47,   41,   61,
   40,  277,  278,   22,   40,  256,  257,   41,   41,  267,
   41,   41,  131,  132,  133,  134,   87,   40,  266,   90,
   41,   92,   59,  265,   41,   41,  115,  116,  257,   41,
   41,   41,  117,  118,   41,   61,   41,   41,   41,   41,
  257,   40,   74,  272,  163,   59,  257,   41,  277,  278,
   40,  269,  123,   23,  283,  272,  269,  258,   59,   59,
  277,  278,   41,   59,  258,  269,  283,  272,   59,   41,
  147,  148,  149,  150,   41,   59,   59,   59,   59,  258,
  282,  158,  159,   61,   59,   40,   59,   40,   59,   41,
   40,   40,  258,   59,   59,  172,   45,   67,  258,   59,
  176,  177,  258,  179,  180,  181,  183,  258,   59,   58,
  258,  258,  257,   41,   40,   40,  258,  257,   41,  190,
   41,   41,   59,   41,  200,  201,   41,  159,   41,   59,
   41,  207,   40,   40,  275,   40,   40,   61,  215,   40,
   59,   40,   59,   59,  275,   59,  275,  275,  224,  225,
  226,  256,  228,  229,  275,  258,   40,  233,  229,  257,
  258,  267,  275,   40,  257,  257,  264,  257,  267,  257,
  269,  263,  249,  250,  258,  252,  268,  253,  270,  271,
   40,  267,  277,  278,  267,  267,  267,  279,  267,  159,
  258,  257,   59,  285,  269,   40,  273,  263,  275,  267,
  170,  171,  268,  173,  174,  271,  269,  277,  278,  267,
  276,  267,  182,  279,  184,  185,  267,  257,  284,  256,
   40,  257,   40,  263,  267,  195,  257,  263,  268,  277,
  278,  271,  268,  267,  267,  271,  276,  267,  208,  279,
  276,  272,  256,  279,  284,   40,  277,  278,  284,   40,
  267,  267,  283,  329,  330,  331,  332,  333,  257,  335,
  267,  332,  267,  267,  263,  267,  267,  257,  238,  268,
  346,  267,  271,  263,  350,  275,  267,  276,  268,  257,
  279,  271,  272,  267,  274,  284,  267,  277,  278,  279,
  256,  261,  262,  283,  264,  265,  266,  267,  268,  269,
  270,   45,  272,   44,  274,  256,  276,  267,  257,  258,
  386,   59,  389,   40,   41,  264,  392,  287,   59,  256,
  290,  291,  292,  293,  294,  295,  296,  297,  298,  299,
   45,  257,  257,  303,  258,  305,  275,  263,  263,  263,
   40,   41,  268,  268,   59,  271,  271,   45,  318,  257,
  276,  276,  322,  279,  279,  263,  257,   59,  284,  284,
  268,   40,  263,  271,   40,   59,   59,  268,  276,   45,
  271,  279,   59,  257,   59,  276,  284,   59,  279,  263,
  257,   59,    7,  284,  268,   40,  263,  271,   59,  256,
  280,  268,  276,   59,  271,  279,   21,  257,   59,  276,
  284,   59,  279,  263,  275,  275,   59,  284,  268,   40,
   41,  271,  257,  275,  275,  256,  276,   59,  263,  279,
  390,  275,   40,  268,  284,   59,  271,  272,   59,  274,
   40,  275,  277,  278,  279,  275,  281,  257,  283,  257,
  275,   40,   41,  263,   59,  263,  275,   59,  268,   40,
  268,  271,  272,  271,  274,   59,  274,  277,  278,  279,
   59,  279,  257,  283,  282,   40,  257,  275,  263,   40,
   45,    0,  263,  268,   45,   59,  271,  268,   40,   41,
  271,   43,  273,   45,  279,  258,   10,  282,  279,  280,
  107,  105,  114,   -1,   -1,   -1,   -1,   59,   60,   -1,
   62,   -1,   40,   41,   -1,   43,   -1,   45,  256,   -1,
   -1,   -1,   -1,  257,  258,  256,  257,   -1,   -1,   -1,
  264,   59,   60,   -1,   62,   -1,   40,   41,   -1,   43,
  257,   45,   -1,  277,  278,   -1,  263,   -1,   -1,   -1,
  267,  268,  257,  258,  271,   59,   60,   -1,   62,  264,
   40,   41,  279,   -1,  256,   -1,   -1,  257,   -1,  257,
  258,   -1,   44,  263,   -1,   -1,  264,   -1,  268,   59,
   60,  271,   62,   -1,   40,   41,  276,   59,  256,  279,
   -1,  257,  258,   -1,  209,  210,   -1,  212,  264,   -1,
  256,   40,   41,   59,   60,  256,   62,   -1,  256,   -1,
   41,  256,  257,  256,   45,   -1,  231,   -1,  263,   -1,
   59,   40,   41,  268,  256,   -1,  271,   -1,   40,   -1,
  275,   -1,  256,   -1,  279,  256,  257,  258,   40,   -1,
   59,   -1,  263,   -1,   -1,  266,  267,  268,  269,  257,
  271,  256,   -1,   40,  256,  263,   -1,   40,  279,   -1,
  268,  269,   -1,  271,   -1,   -1,   -1,  256,  257,  258,
   -1,  279,   40,   -1,  263,   -1,   40,  266,  267,  268,
  269,   -1,  271,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  279,   40,  257,  258,   -1,   40,  257,  258,   -1,  264,
   -1,   -1,   -1,  264,  256,  257,  258,  259,  260,  261,
  262,  263,   40,   -1,  266,  267,  268,  269,   -1,  271,
   -1,   40,   -1,   -1,   -1,   -1,   -1,  279,  256,  257,
  258,  259,  260,  261,  262,  263,   40,   -1,  266,  267,
  268,  269,   -1,  271,   -1,   41,   40,   -1,   -1,   45,
   -1,  279,  256,  257,  258,  259,  260,  261,  262,  263,
   -1,   40,  266,  267,  268,  269,   -1,  271,   -1,   -1,
   40,   40,   -1,   -1,   -1,  279,  256,  257,  258,  259,
  260,  261,  262,  263,  256,  257,  266,  267,  268,  269,
   40,  271,   -1,   -1,   40,   -1,   -1,   -1,   -1,  279,
  256,  257,  258,  259,  260,  261,  262,  263,   -1,   40,
  266,  267,  268,  269,   -1,  271,   -1,  256,  257,  258,
   -1,   40,   40,  279,  263,   -1,  257,  258,  267,  268,
  269,   -1,  271,  264,   40,   -1,   -1,  256,  257,  258,
  279,   40,   -1,   -1,  263,  257,   -1,   -1,  267,  268,
  269,  263,  271,   40,   -1,  257,  268,   -1,   45,  271,
  279,  263,   -1,  275,   -1,   -1,  268,  279,  270,  271,
  257,   41,   -1,   -1,  257,   45,  263,  279,   -1,   -1,
  263,  268,   -1,  270,  271,  268,   40,  270,  271,  257,
   41,   45,  279,  257,   45,  263,  279,   -1,   -1,  263,
  268,   -1,  270,  271,  268,   -1,  270,  271,  257,   -1,
   -1,  279,  257,   -1,  263,  279,   -1,   -1,  263,  268,
   -1,  270,  271,  268,   -1,   -1,  271,   -1,  273,  257,
  279,   60,   -1,   62,  279,  263,   -1,   -1,  257,   -1,
  268,   -1,   -1,  271,  263,  273,   -1,   -1,   -1,  268,
   -1,  279,  271,  257,   -1,  274,   -1,   -1,   -1,  263,
  279,  257,  258,  257,  268,   -1,  270,  271,  264,  263,
   -1,   -1,   -1,   -1,  268,  279,  270,  271,  257,   -1,
   -1,   -1,   -1,   -1,  263,  279,   -1,  257,  257,  268,
   -1,   -1,  271,  263,  263,   -1,   -1,  276,  268,  268,
  279,  271,  271,  273,  273,   -1,   -1,  257,   -1,  279,
  279,  257,   -1,  263,   -1,   -1,   -1,  263,  268,   -1,
   -1,  271,  268,  273,   -1,  271,  257,  273,   -1,  279,
   -1,   -1,  263,  279,   -1,   -1,   -1,  268,  257,  257,
  271,   -1,  273,   -1,  263,  263,   -1,   -1,  279,  268,
  268,  257,  271,  271,  273,  273,   -1,  263,  257,   -1,
  279,  279,  268,   -1,  263,  271,   -1,  273,   -1,  268,
  257,  258,  271,  279,   -1,   14,  263,  264,   -1,   -1,
  279,   20,   -1,   -1,   -1,   -1,   -1,  257,  258,   -1,
  277,  278,   -1,   -1,  264,   -1,   -1,   36,   37,   -1,
   -1,   -1,   -1,  257,  258,   -1,  257,  258,   -1,  263,
  264,   -1,   51,  264,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  277,  278,   -1,   -1,   66,   -1,   -1,
  259,  260,  261,  262,  287,   -1,   -1,  290,   -1,  292,
  293,   -1,  295,  296,  297,  298,  299,   -1,   87,   -1,
   -1,   -1,   -1,   92,  262,   -1,  264,  265,  266,  267,
  268,  269,  270,   -1,   -1,  318,   -1,   -1,   -1,  322,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  291,  123,   -1,  294,
};
}
final static short YYFINAL=6;
final static short YYMAXTOKEN=285;
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
"DOUBLE","REPEAT","PRE","TRY","CATCH","TYPEDEF","ENDREPEAT","ELSE",
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
"declaracion : tipo funcion ';'",
"declaracion : TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"error_declaracion : tipo funcion error",
"error_declaracion : funcion ';'",
"tipo : ULONG",
"tipo : DOUBLE",
"control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"control : error_control",
"error_control : REPEAT IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' ';' condicion ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG condicion ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' ';' CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion CTE_ULONG ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' ')' bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG bloque_control ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' ENDREPEAT",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_control",
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
"funcion_type : FUNC '(' tipo ')' bloque_type",
"bloque_type : IDENTIFICADOR lista_de_variables",
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
"factor : CTE_DOUBLE",
"factor : CTE_ULONG",
"factor : '-' factor",
"factor : IDENTIFICADOR",
"comparador : '<'",
"comparador : '>'",
"comparador : IGUAL_IGUAL",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
};

//#line 268 "gramatica.y"

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
//#line 763 "Parser.java"
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
//#line 12 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado " +val_peek(2).sval);}
break;
case 3:
//#line 16 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 4:
//#line 17 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 11:
//#line 36 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 12:
//#line 37 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN per falta un END para cerrar el bloque}");}
break;
case 19:
//#line 50 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 20:
//#line 51 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
//#line 52 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
//#line 53 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
//#line 54 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 58 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 26:
//#line 60 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"}");}
break;
case 28:
//#line 65 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 66 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 30:
//#line 67 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 33:
//#line 76 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 35:
//#line 80 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 36:
//#line 81 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 37:
//#line 82 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 38:
//#line 83 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 39:
//#line 84 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 40:
//#line 85 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 41:
//#line 86 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 42:
//#line 87 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 43:
//#line 88 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 44:
//#line 89 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 45:
//#line 90 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta indicar el fin del ciclo con ENDREPEAT}");}
break;
case 51:
//#line 102 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 54:
//#line 110 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 55:
//#line 111 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 56:
//#line 112 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 60:
//#line 122 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 61:
//#line 123 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 62:
//#line 124 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 63:
//#line 125 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 64:
//#line 126 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 65:
//#line 127 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 66:
//#line 128 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 67:
//#line 129 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 68:
//#line 130 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 70:
//#line 138 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + val_peek(3).sval + "'}");}
break;
case 72:
//#line 142 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 73:
//#line 143 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 74:
//#line 144 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 75:
//#line 145 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 76:
//#line 149 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 77:
//#line 150 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 79:
//#line 155 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 80:
//#line 157 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 82:
//#line 162 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 83:
//#line 163 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 84:
//#line 164 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 85:
//#line 165 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 86:
//#line 166 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 87:
//#line 167 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 90:
//#line 175 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 96:
//#line 192 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 97:
//#line 193 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 98:
//#line 194 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 102:
//#line 202 "gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 103:
//#line 203 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 104:
//#line 204 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 105:
//#line 205 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 106:
//#line 206 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 107:
//#line 207 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 108:
//#line 208 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 109:
//#line 209 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 110:
//#line 211 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 111:
//#line 212 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 112:
//#line 213 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 113:
//#line 214 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 114:
//#line 215 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 115:
//#line 216 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 116:
//#line 217 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 117:
//#line 218 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 118:
//#line 220 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 119:
//#line 221 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 120:
//#line 222 "gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 122:
//#line 229 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 124:
//#line 233 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 126:
//#line 237 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 128:
//#line 241 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 129:
//#line 242 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 130:
//#line 245 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 131:
//#line 246 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 133:
//#line 251 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval);}
break;
case 134:
//#line 252 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval);}
break;
case 135:
//#line 253 "gramatica.y"
{chequearFactorNegado();}
break;
case 136:
//#line 254 "gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1268 "Parser.java"
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
