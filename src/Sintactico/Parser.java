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
    0,    0,    3,    3,    1,    1,    2,    2,    5,    5,
    6,    6,    7,    7,    7,    7,    7,    7,   13,   13,
   13,   13,   13,    4,    4,    4,    4,   18,   18,   18,
   14,   14,    8,    8,   21,   21,   21,   21,   21,   21,
   21,   21,   21,   21,   20,   22,   22,   23,   23,   23,
   24,   12,   12,   26,   26,   26,    9,    9,    9,   28,
   28,   28,   30,   30,   30,   29,   29,   29,   29,   29,
   29,   29,   29,   29,   10,   11,   11,   32,   32,   32,
   32,   15,   15,   15,   33,   16,   16,   35,   35,   35,
   35,   35,   35,   31,   31,   36,   17,   17,   38,   38,
   38,   38,   38,   38,   37,   34,   34,   34,   40,   40,
   40,   39,   39,   39,   41,   41,   41,   41,   41,   41,
   41,   41,   42,   41,   41,   41,   41,   41,   41,   41,
   41,   41,   41,   41,   19,   19,   43,   43,   44,   44,
   25,   25,   25,   27,   27,   27,   46,   46,   46,   46,
   45,   45,   45,   45,   45,   45,
};
final static short yylen[] = {                            2,
    3,    1,    2,    3,    1,    2,    3,    1,    1,    2,
    2,    3,    2,    2,    2,    2,    2,    1,    2,    2,
    2,    2,    2,    3,    3,    6,    1,    3,    3,    2,
    1,    1,   11,    1,   10,   10,   10,   10,   10,   10,
   10,   10,   10,   10,    3,    1,    2,    1,    2,    1,
    2,    3,    1,    2,    2,    2,    7,    9,    1,    1,
    5,    1,    4,    5,    4,    6,    6,    6,    6,    6,
    6,    6,    8,    8,    4,    4,    1,    3,    3,    3,
    3,    3,    1,    1,    2,    6,    1,    5,    5,    5,
    5,    5,    5,    2,    1,    2,    6,    1,    5,    5,
    5,    5,    5,    6,    2,    2,    5,    1,    4,    4,
    4,    8,   11,    1,    7,    7,    7,    7,    7,    7,
    7,    3,    0,   20,   11,   11,   11,   11,   11,   11,
   12,   11,   11,   11,    1,    3,    1,    3,    1,    3,
    1,    3,    3,    3,    3,    1,    2,    1,    1,    1,
    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   31,   32,    0,    0,    0,    2,    5,    0,
    0,   27,   87,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,    9,    0,    0,    0,    0,    0,
   18,   34,   53,   59,   77,    0,    0,    0,    0,    3,
    6,    0,    0,    0,   84,   30,  150,  149,    0,  148,
    0,    0,    0,    0,    0,   95,  146,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,   11,   10,   19,   13,   20,   14,
   21,   15,   23,   16,   22,   17,    0,    0,    0,    0,
    0,    0,   28,   85,   24,    0,   29,   25,    0,   80,
    0,  147,   96,   94,    0,    0,   79,    0,    0,    0,
    0,    0,    0,    0,  154,  155,  153,  156,  151,  152,
    0,    0,    0,   12,    7,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   78,    0,   82,    0,  144,
  145,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   75,    0,    0,    0,    0,    0,    0,    0,   88,  108,
   91,    0,   92,   90,   89,    0,    0,    0,   98,    0,
    0,   60,    0,   62,    0,    0,    0,    0,   76,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  106,
  114,   86,    0,    0,    0,   26,    0,   68,   69,   71,
    0,   70,   67,    0,    0,    0,    0,    0,    0,   66,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   57,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  122,    0,  110,
    0,  111,    0,  109,    0,    0,    0,    0,    0,   65,
   63,    0,   73,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  107,    0,    0,  101,  102,    0,  103,  100,   99,   64,
   61,   58,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   83,    0,  104,   97,    0,   35,   37,   40,
   41,    0,   43,   42,   39,   38,   36,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   48,    0,   46,   50,   33,  116,    0,    0,    0,
    0,    0,    0,    0,  119,  120,  121,    0,  118,  117,
  115,   51,   49,   45,   47,    0,    0,    0,    0,    0,
    0,    0,    0,  123,  112,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  133,  125,  128,  129,
  130,    0,  127,  126,  134,  113,  132,    0,  131,    0,
    0,    0,    0,    0,    0,    0,    0,  124,
};
final static short yydgoto[] = {                          6,
  158,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  168,   12,   70,  308,
   32,  333,  334,  335,   61,   33,   62,  173,   34,  174,
   91,   35,   45,  159,   13,   56,  274,  169,  190,  160,
  191,  375,   63,   64,  121,   57,
};
final static short yysindex[] = {                      -175,
  -14,  -33,    0,    0, -236,    0,   26,    0,    0, -213,
  -42,    0,    0,  475,  250,  108,   10,  591,   -6,  158,
   26, -171,  434,    0,    0,  -44,  -40,  136,  305,  360,
    0,    0,    0,    0,    0,  -11, -201,   -7,  158,    0,
    0,   69,  111,  361,    0,    0,    0,    0,  250,    0,
  -39,  250, -169,   38,   51,    0,    0,   38,  506,   14,
    3,   38, -241,  605, -154,  614,  106, -159, -216,   19,
   74,    0,   69, -171,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   43,   75,   76, -201,
   79, -201,    0,    0,    0, -134,    0,    0,    3,    0,
   83,    0,    0,    0,  250,  250,    0, -144,   -8,  250,
 -143,  250,  250,  250,    0,    0,    0,    0,    0,    0,
  250,   89,  -39,    0,    0, -123, -200, -122, -130, -171,
 -171,   57, -171, -171,  -36,    0,  103,    0, -171,    0,
    0,  451,  451,  230, -241,  451,   38,   38,  605,    3,
    0,  109,   86,   95,  -49,  100,  451,  -37,    0,    0,
    0, -171,    0,    0,    0,   39, -201,  101,    0, -171,
  591,    0, -119,    0, -118,  232, -108,  -94,    0,  250,
  250,  639,  250,  250,  -91,   70,    5,  472, -101,    0,
    0,    0,   59,  145,  148,    0,  479,    0,    0,    0,
 -219,    0,    0,   88,   90,  648,  112,  116,  119,    0,
  151,  631,  273,  503,   28,  153,  503,  129,   -3,  135,
  138,  364,  505,    0,  253,  -59,  -51,  -47,  -45,  154,
  169,  175,  250,  665,  250,   21,  160,    0,  158,    0,
  503,    0,  250,    0,  177,  177,  104,  177,  177,    0,
    0,  380,    0,  123,  397,  409,  411,  413,   -5,  420,
  421,  422,   23,  591,  415,  147,  591,  670,   34,   48,
    0,   52,  209,    0,    0, -161,    0,    0,    0,    0,
    0,    0,  193,  193,  193,  193,  -29,  193,  193,  193,
  193,  410,  515,  522,  535,  591,  547,  412,  -35,  416,
  -41,  417,    0,   96,    0,    0,  548,    0,    0,    0,
    0,  193,    0,    0,    0,    0,    0,  195,  428,  437,
  560,  439,  572,  440,  210,  217,  -50,  221,  222,  238,
  385,    0,  424,    0,    0,    0,    0,  250,  250,  351,
  158,  250,  450,  250,    0,    0,    0, -240,    0,    0,
    0,    0,    0,    0,    0,   64,   72,  675,   77,   78,
   80,  250,   81,    0,    0,  446,  458,  459,    8,  463,
    2,  466,   91,  474,  251,  260,  278,  279,  281,  -46,
  282,  288,  289,  290,  291,  536,    0,    0,    0,    0,
    0,  325,    0,    0,    0,    0,    0,  250,    0,   92,
  591,  573,  543,  250,   93,  526,  314,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  133,    0,    0,    0,    0,    0,    0,  467,    0,
    0,    0,    0,  478,    0,    0,    0,  490,    0,    0,
  366,  142,  271,  174,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  586,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  499,    0,
  500,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  501,
    0,    0,    0,    0,    0,    0,    0,    0,  525,    0,
    0,    0,    0,    0,  406,    0,  311,  335,  215,  389,
    0,  500,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  540,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  590,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  546,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  551,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  552,    0,    0,    0,    0,    0,    0,
    0,  581,    0,    0,    0,    0,    0,    0,    0,    0,
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
   31,  659,    0,   16,  -17,    0,  -15,    0,    0,    0,
    0,    0,    0,   -9,  334,  608,    0,    0,  -16,  656,
    0,    0,  286,    0,  -27,    0,   25,  737,    0,    0,
  865,    0,    0,  326,    0,    0, -177,    0,    0,    0,
    0,    0,  511,  508,    0,  -32,
};
final static int YYTABLESIZE=988;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         60,
   67,  100,   39,  167,   53,  327,   37,   76,  348,  183,
   53,  312,  392,  259,   78,  364,   46,  329,   80,  102,
   38,   99,   41,  326,  114,   20,   53,   53,   87,   53,
    7,   21,  144,   69,  365,  288,   41,  247,   54,   58,
  127,   53,  109,   42,   39,  112,  128,  113,  380,   65,
  224,   76,   74,   90,  111,  246,   53,  154,    2,  129,
  382,  267,  155,  292,  225,   39,  379,   39,  275,  277,
  278,  279,  140,  141,  300,    3,    4,   53,  193,  105,
  135,    1,   53,  131,  106,   73,  103,  104,  301,   41,
   54,  107,  302,  150,  305,  273,    2,  162,  306,  218,
    2,    3,    4,  126,  366,    3,    4,    5,   92,   39,
  122,    5,  367,   53,  130,  133,  134,  370,  371,  136,
  372,  374,  138,  139,  142,  146,  172,  172,  172,  151,
  172,  384,  401,  406,  153,  156,  147,  148,  157,   96,
  188,  172,  189,  170,  180,   39,  226,   59,  227,  179,
  198,  199,   52,  181,   96,  197,  194,  195,  184,  196,
  172,  202,  276,  204,  205,  207,  208,  209,  213,   95,
  230,  215,   76,   41,  231,  203,   83,  232,  210,  223,
  217,  141,  141,  219,  141,  220,  141,  245,  221,  229,
  233,   83,  243,  248,   82,  236,  249,   76,  255,  268,
  141,  141,   52,  141,   52,  296,  256,   76,  182,  172,
  257,   77,  258,  137,  137,   79,  263,  265,  266,   14,
  269,  110,  270,   36,  347,   15,  272,  157,  391,   53,
   16,  110,  137,   17,    2,  166,  186,    3,    4,    3,
    4,   19,   14,  187,  307,    5,  293,  295,   15,  297,
   68,  299,  287,   16,  138,  138,   17,    2,  110,   18,
  143,   66,    3,    4,   19,    3,    4,   15,    5,   39,
  157,   39,   16,  138,  110,   17,  321,   76,  323,   76,
  110,   76,   14,   19,   66,  110,  214,  110,   15,  110,
   15,  332,   39,   16,   52,   16,   17,    2,   17,   18,
  110,   18,    3,    4,   19,   76,   19,   76,    5,  241,
  135,  135,  239,   73,  110,    3,    4,  332,  110,    3,
    4,  356,  357,  359,  360,  361,   66,  363,    2,  135,
  110,   53,   15,    3,    4,    3,    4,   16,  110,    5,
   17,  369,  211,  110,  110,  373,  110,  110,   19,  212,
  142,  142,   94,  142,  110,  142,  110,  110,  110,  110,
  273,  124,   66,   84,   47,   48,   93,   94,   15,  142,
  142,   50,  142,   16,  143,  143,   17,  143,  110,  143,
  125,  400,  110,  402,   19,  110,   76,  405,   83,   83,
  358,   81,  282,  143,  143,   52,  143,  141,  141,  141,
  141,  141,  141,  141,  141,  139,  139,  141,  141,  141,
  141,  260,  141,  110,   47,   48,   47,   48,   86,   98,
  141,   50,  251,   50,  139,  139,  261,  139,  140,  140,
  137,  137,  262,  273,    3,    4,  137,  283,  281,  137,
  137,  137,  137,  353,  137,  136,  136,  140,  140,  284,
  140,  285,  137,  286,   39,  294,  161,  163,  164,  165,
  289,  290,  291,   39,  136,  303,  307,  338,  318,  337,
  325,  138,  138,   39,  328,  330,  339,  138,  342,  344,
  138,  138,  138,  138,  345,  138,   66,  192,   66,  362,
   39,  346,   15,  138,   15,  349,  350,   16,  176,   16,
   17,  200,   17,  171,  376,  171,   47,   48,   19,   66,
   19,   39,  351,   50,   51,   15,  377,  378,   39,   52,
   16,  381,  253,   17,  383,   56,  171,  135,  135,   66,
  386,   19,  385,  135,  387,   15,   55,  135,  135,  135,
   16,  135,   39,   17,   39,  237,  108,  238,   54,  135,
   52,   19,  388,  389,   39,  390,  393,   52,   81,   78,
   83,   39,  394,  395,  396,  397,  142,  142,  142,  142,
  142,  142,  142,  142,   39,  398,  142,  142,  142,  142,
  399,  142,  404,   76,  407,    4,   39,   39,  408,  142,
  143,  143,  143,  143,  143,  143,  143,  143,   93,  341,
  143,  143,  143,  143,   72,  143,  304,   47,   48,   74,
  105,   39,   39,  143,   50,   85,   97,   44,  355,  250,
  145,  149,  139,  139,  139,  139,  139,  139,  139,    9,
   39,  139,  139,  139,  139,  280,  139,    0,    0,   44,
  352,    0,    0,    0,  139,  140,  140,  140,  140,  140,
  140,  140,    0,  123,  140,  140,  140,  140,   52,  140,
    0,    0,  136,  136,  119,   40,  120,  140,  136,    0,
  234,   66,  136,  136,  136,   52,  136,   15,    0,   72,
   66,  110,   16,   52,  136,   17,   15,    0,  235,    0,
   66,   16,   52,   19,   17,    0,   15,  206,  354,  331,
    0,   16,   19,    0,   17,  264,  228,   66,   75,   52,
  298,    0,   19,   15,   52,  368,    0,    0,   16,   52,
    0,   17,   56,    0,  171,    0,    0,    0,   66,   19,
    0,   47,   48,   55,   15,   66,    0,   49,   50,   16,
    0,   15,   17,    0,  216,   54,   16,    0,    0,   17,
   19,    3,    4,  222,   52,   81,   78,   19,    0,   66,
    0,   66,   47,   48,    0,   15,    0,   15,    0,   50,
   16,   66,   16,   17,    0,   17,   18,   15,   66,  252,
   76,   19,   16,   19,   15,   17,    0,  319,    0,   16,
    0,   66,   17,   19,  320,   93,    0,   15,    0,    0,
   19,   72,   16,   66,   66,   17,   74,  322,    0,   15,
   15,    0,    0,   19,   16,   16,   66,   17,   17,  324,
    0,    0,   15,  331,    0,   19,   19,   16,   66,   66,
   17,    0,  340,    0,   15,   15,   44,    0,   19,   16,
   16,    0,   17,   17,  343,  403,    9,   66,    0,    0,
   19,   19,    9,   15,    0,    0,    0,    9,   16,    0,
    9,   17,    9,  115,  116,  117,  118,    0,    9,   19,
   47,   48,  240,  242,    0,  244,   49,   50,   55,  175,
  177,    0,  178,    0,   71,    0,    0,   47,   48,    0,
    3,    4,    0,  185,   50,   47,   48,    0,    0,  271,
   88,   89,   50,    0,   47,   48,    0,    0,    0,    0,
    0,   50,  201,    0,    0,  101,    0,    0,    0,    0,
    0,   47,   48,    0,    0,    0,   47,   48,   50,    0,
   55,   47,   48,   50,    0,    0,    0,    0,   50,  309,
  310,  311,  313,  314,  315,  316,  317,    0,    0,    0,
    0,  132,    0,    0,    0,    0,  137,    0,    0,    0,
    0,  254,    0,    0,    0,    0,    0,  336,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  152,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         16,
   18,   41,   40,   40,   14,   41,   40,   23,   59,   59,
   20,   41,   59,   59,   59,  256,   59,   59,   59,   52,
  257,   49,    7,   59,  266,   40,   36,   37,   40,   39,
    0,    1,   41,   40,  275,   41,   21,   41,   14,   15,
  257,   51,   59,  257,   40,   43,  263,   45,   41,   40,
  270,   67,   22,   61,   41,   59,   66,  258,  272,   41,
   59,   41,  263,   41,  284,   40,   59,   40,  246,  247,
  248,  249,  105,  106,   41,  277,  278,   87,   40,   42,
   90,  257,   92,   41,   47,  257,  256,  257,   41,   74,
   66,   41,   41,  121,  256,  257,  272,   41,  276,   41,
  272,  277,  278,  263,   41,  277,  278,  283,   40,   40,
  265,  283,   41,  123,   41,   41,   41,   41,   41,   41,
   41,   41,  257,   41,  269,  269,  142,  143,  144,   41,
  146,   41,   41,   41,  258,  258,  112,  113,  269,   44,
  158,  157,  158,   41,   59,   40,   59,   40,   59,   41,
  270,  270,   45,   59,   44,  171,  166,  167,   59,   59,
  176,  270,   59,  180,  181,  182,  183,  184,  186,   59,
   59,  187,  188,  158,   59,  270,   44,   59,  270,  197,
  282,   40,   41,  193,   43,   41,   45,   59,   41,  206,
   40,   59,   40,   59,   59,  212,   59,  213,  258,   40,
   59,   60,   45,   62,   45,   59,  258,  223,  258,  225,
  258,  256,  258,   40,   41,  256,  233,  234,  235,  257,
  237,  267,  239,  257,  275,  263,  243,  269,  275,  239,
  268,  267,   59,  271,  272,  272,  274,  277,  278,  277,
  278,  279,  257,  281,  274,  283,  264,  265,  263,  267,
  257,  268,  258,  268,   40,   41,  271,  272,  267,  274,
  269,  257,  277,  278,  279,  277,  278,  263,  283,   40,
  269,   40,  268,   59,  267,  271,  294,  293,  296,  295,
  267,  297,  257,  279,  257,  267,  282,  267,  263,  267,
  263,  307,   40,  268,   45,  268,  271,  272,  271,  274,
  267,  274,  277,  278,  279,  321,  279,  323,  283,  282,
   40,   41,   40,  257,  267,  277,  278,  333,  267,  277,
  278,  338,  339,  340,  341,  342,  257,  344,  272,   59,
  267,  341,  263,  277,  278,  277,  278,  268,  267,  283,
  271,  358,  273,  267,  267,  362,  267,  267,  279,  280,
   40,   41,  257,   43,  267,   45,  267,  267,  267,  267,
  257,  256,  257,   59,  257,  258,  256,  257,  263,   59,
   60,  264,   62,  268,   40,   41,  271,   43,  267,   45,
  275,  398,  267,  401,  279,  267,  402,  404,  256,  257,
   40,  256,  270,   59,   60,   45,   62,  256,  257,  258,
  259,  260,  261,  262,  263,   40,   41,  266,  267,  268,
  269,  258,  271,  267,  257,  258,  257,  258,   59,   59,
  279,  264,   59,  264,   59,   60,  258,   62,   40,   41,
  257,  258,  258,  257,  277,  278,  263,   41,   59,  266,
  267,  268,  269,   59,  271,   40,   41,   59,   60,   41,
   62,   41,  279,   41,   40,   41,  131,  132,  133,  134,
   41,   41,   41,   40,   59,  257,  274,   40,   59,  275,
   59,  257,  258,   40,   59,   59,   40,  263,   40,   40,
  266,  267,  268,  269,  275,  271,  257,  162,  257,   40,
   40,  275,  263,  279,  263,  275,  275,  268,  269,  268,
  271,  270,  271,  274,   59,  274,  257,  258,  279,  257,
  279,   40,  275,  264,   40,  263,   59,   59,   40,   45,
  268,   59,  270,  271,   59,   59,  274,  257,  258,  257,
  280,  279,   59,  263,  275,  263,   59,  267,  268,  269,
  268,  271,   40,  271,   40,  273,   41,  275,   59,  279,
   45,  279,  275,  275,   40,  275,  275,   59,   59,   59,
  256,   40,  275,  275,  275,  275,  256,  257,  258,  259,
  260,  261,  262,  263,   40,   40,  266,  267,  268,  269,
  256,  271,   40,   59,   59,    0,   40,   40,  275,  279,
  256,  257,  258,  259,  260,  261,  262,  263,   59,   40,
  266,  267,  268,  269,   59,  271,  273,  257,  258,   59,
   59,   40,   40,  279,  264,  256,  256,   10,  333,  256,
  110,  114,  257,  258,  259,  260,  261,  262,  263,   40,
   40,  266,  267,  268,  269,  256,  271,   -1,   -1,   59,
  256,   -1,   -1,   -1,  279,  257,  258,  259,  260,  261,
  262,  263,   -1,   40,  266,  267,  268,  269,   45,  271,
   -1,   -1,  257,  258,   60,    7,   62,  279,  263,   -1,
   40,  257,  267,  268,  269,   45,  271,  263,   -1,   21,
  257,  267,  268,   45,  279,  271,  263,   -1,   58,   -1,
  257,  268,   45,  279,  271,   -1,  263,   59,  275,  276,
   -1,  268,  279,   -1,  271,   41,   59,  257,  275,   45,
   41,   -1,  279,  263,   45,   41,   -1,   -1,  268,   45,
   -1,  271,  256,   -1,  274,   -1,   -1,   -1,  257,  279,
   -1,  257,  258,  256,  263,  257,   -1,  263,  264,  268,
   -1,  263,  271,   -1,  273,  256,  268,   -1,   -1,  271,
  279,  277,  278,  275,  256,  256,  256,  279,   -1,  257,
   -1,  257,  257,  258,   -1,  263,   -1,  263,   -1,  264,
  268,  257,  268,  271,   -1,  271,  274,  263,  257,  275,
  256,  279,  268,  279,  263,  271,   -1,  273,   -1,  268,
   -1,  257,  271,  279,  273,  256,   -1,  263,   -1,   -1,
  279,  256,  268,  257,  257,  271,  256,  273,   -1,  263,
  263,   -1,   -1,  279,  268,  268,  257,  271,  271,  273,
   -1,   -1,  263,  276,   -1,  279,  279,  268,  257,  257,
  271,   -1,  273,   -1,  263,  263,  256,   -1,  279,  268,
  268,   -1,  271,  271,  273,  273,  257,  257,   -1,   -1,
  279,  279,  263,  263,   -1,   -1,   -1,  268,  268,   -1,
  271,  271,  273,  259,  260,  261,  262,   -1,  279,  279,
  257,  258,  214,  215,   -1,  217,  263,  264,   14,  143,
  144,   -1,  146,   -1,   20,   -1,   -1,  257,  258,   -1,
  277,  278,   -1,  157,  264,  257,  258,   -1,   -1,  241,
   36,   37,  264,   -1,  257,  258,   -1,   -1,   -1,   -1,
   -1,  264,  176,   -1,   -1,   51,   -1,   -1,   -1,   -1,
   -1,  257,  258,   -1,   -1,   -1,  257,  258,  264,   -1,
   66,  257,  258,  264,   -1,   -1,   -1,   -1,  264,  284,
  285,  286,  287,  288,  289,  290,  291,   -1,   -1,   -1,
   -1,   87,   -1,   -1,   -1,   -1,   92,   -1,   -1,   -1,
   -1,  225,   -1,   -1,   -1,   -1,   -1,  312,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  123,
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
"control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"control : error_control",
"error_control : REPEAT IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG ')'",
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
"error_bloque_ejecucion_funcion : BEGIN bloque_sentencias END",
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
"factor : '-' factor",
"factor : CTE_DOUBLE",
"factor : CTE_ULONG",
"factor : IDENTIFICADOR",
"comparador : '<'",
"comparador : '>'",
"comparador : IGUAL_IGUAL",
"comparador : MAYOR_IGUAL",
"comparador : MENOR_IGUAL",
"comparador : DISTINTO",
};

//#line 290 "Gramatica.y"

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
//#line 731 "Parser.java"
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
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado " +val_peek(2).sval);}
break;
case 3:
//#line 16 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 4:
//#line 17 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 11:
//#line 36 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 12:
//#line 37 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN per falta un END para cerrar el bloque}");}
break;
case 19:
//#line 50 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
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
//#line 58 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 26:
//#line 60 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + val_peek(4).sval +"'}");}
break;
case 28:
//#line 65 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 66 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 30:
//#line 67 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 33:
//#line 76 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 35:
//#line 80 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 36:
//#line 81 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 37:
//#line 82 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ':='}");}
break;
case 38:
//#line 83 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 39:
//#line 84 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 40:
//#line 85 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 41:
//#line 86 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 42:
//#line 87 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 43:
//#line 88 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 44:
//#line 89 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 51:
//#line 104 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 52:
//#line 107 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + val_peek(2).sval + ":= " + val_peek(0).sval +"}");}
break;
case 54:
//#line 112 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 55:
//#line 113 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 56:
//#line 114 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 63:
//#line 129 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 64:
//#line 130 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 65:
//#line 131 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 66:
//#line 134 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 67:
//#line 135 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 68:
//#line 136 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 69:
//#line 137 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 70:
//#line 138 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 71:
//#line 139 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 72:
//#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 73:
//#line 141 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 74:
//#line 142 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 76:
//#line 150 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + val_peek(3).sval + "'}");}
break;
case 78:
//#line 154 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 79:
//#line 155 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 80:
//#line 156 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 81:
//#line 157 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 82:
//#line 161 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 83:
//#line 162 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 85:
//#line 167 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 86:
//#line 169 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 88:
//#line 174 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 89:
//#line 175 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 90:
//#line 176 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 91:
//#line 177 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 92:
//#line 178 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 93:
//#line 179 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 96:
//#line 187 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 99:
//#line 195 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 100:
//#line 196 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 101:
//#line 197 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 102:
//#line 198 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 103:
//#line 199 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 104:
//#line 200 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 109:
//#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 110:
//#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 111:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 115:
//#line 223 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 116:
//#line 224 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 117:
//#line 225 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 118:
//#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 119:
//#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 120:
//#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 121:
//#line 229 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 122:
//#line 230 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 123:
//#line 231 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 124:
//#line 233 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 125:
//#line 234 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 126:
//#line 235 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 127:
//#line 236 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 128:
//#line 237 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 129:
//#line 238 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 130:
//#line 239 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 131:
//#line 240 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 132:
//#line 242 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 133:
//#line 243 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 134:
//#line 244 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 136:
//#line 251 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 138:
//#line 255 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 140:
//#line 259 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 142:
//#line 263 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 143:
//#line 264 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 144:
//#line 267 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 145:
//#line 268 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 147:
//#line 273 "Gramatica.y"
{chequearFactorNegado();}
break;
case 148:
//#line 274 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");}
break;
case 149:
//#line 275 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");}
break;
case 150:
//#line 276 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1276 "Parser.java"
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
