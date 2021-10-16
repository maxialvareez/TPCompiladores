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
   13,   13,    4,    4,    4,    4,   18,   18,   18,   14,
   14,    8,    8,   21,   21,   21,   21,   21,   21,   21,
   21,   21,   21,   21,   20,   22,   22,   23,   23,   23,
   24,   12,   12,   25,   25,   25,    9,    9,    9,   26,
   26,   27,   27,   27,   27,   27,   27,   27,   27,   27,
   10,   11,   11,   29,   29,   29,   29,   15,   15,   15,
   30,   16,   16,   32,   32,   32,   32,   32,   32,   28,
   28,   33,   17,   34,   31,   31,   31,   36,   36,   36,
   35,   35,   35,   37,   37,   37,   37,   37,   37,   37,
   38,   37,   37,   37,   37,   37,   37,   37,   37,   37,
   37,   37,   19,   19,   39,   39,   40,   40,   41,   41,
   41,   43,   43,   43,   44,   44,   44,   44,   42,   42,
   42,   42,   42,   42,
};
final static short yylen[] = {                            2,
    3,    1,    2,    3,    1,    2,    3,    1,    1,    2,
    2,    3,    1,    2,    2,    2,    2,    1,    2,    2,
    2,    2,    3,    3,    6,    1,    3,    3,    2,    1,
    1,   12,    1,   11,   11,   11,   11,   11,   11,   11,
   11,   11,   11,   12,    3,    1,    2,    1,    2,    1,
    2,    3,    1,    2,    2,    2,    7,    9,    1,    1,
    5,    6,    6,    6,    6,    6,    6,    6,    8,    8,
    4,    4,    1,    3,    3,    3,    3,    3,    1,    1,
    2,    6,    1,    5,    5,    5,    5,    5,    5,    2,
    1,    2,    5,    2,    2,    5,    1,    4,    4,    4,
    8,   11,    1,    7,    7,    7,    7,    7,    7,    7,
    0,   20,   11,   11,   11,   11,   11,   11,   12,   11,
   11,   11,    1,    3,    1,    3,    1,    3,    1,    3,
    3,    3,    3,    1,    1,    1,    2,    1,    1,    1,
    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   30,   31,    0,    0,    0,    2,    5,    0,
    0,   26,   83,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,    9,   13,    0,    0,    0,    0,
   18,   33,   53,   59,   73,    0,    0,    0,    0,    3,
    6,    0,    0,    0,   80,   29,  138,  136,    0,  135,
    0,    0,    0,    0,    0,   91,    0,    0,    0,    0,
  134,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,   11,   10,   19,   14,   20,   15,
   22,   16,   21,   17,    0,    0,    0,    0,    0,    0,
   27,   81,   23,    0,   28,   24,    0,   76,    0,  137,
   92,   90,    0,   75,    0,  142,  143,  141,  144,  139,
  140,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   12,    7,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   74,    0,   78,    0,    0,    0,    0,
    0,    0,  132,  133,    0,    0,    0,    0,   71,    0,
    0,    0,    0,    0,    0,    0,    0,   84,   97,   87,
    0,   88,   86,   85,    0,    0,    0,    0,   60,    0,
    0,    0,    0,    0,   72,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   95,  103,   82,    0,
   25,    0,   64,   65,   67,    0,   66,   63,    0,    0,
    0,    0,    0,    0,    0,   62,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   57,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   99,    0,  100,    0,   98,    0,    0,   69,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   96,    0,    0,
   93,   61,   58,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   79,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   48,    0,   46,   50,   34,   36,    0,   39,
   40,   43,    0,   42,   41,   38,   37,   35,  105,    0,
    0,    0,    0,    0,    0,    0,  108,  109,  110,    0,
  107,  106,  104,   51,   49,   45,   47,   32,   44,    0,
    0,    0,    0,    0,    0,    0,    0,  111,  101,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  121,  113,  116,  117,  118,    0,  115,  114,  122,  102,
  120,    0,  119,    0,    0,    0,    0,    0,    0,    0,
    0,  112,
};
final static short yydgoto[] = {                          6,
  157,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  166,   12,   54,  288,
   32,  314,  315,  316,   33,  170,   34,   89,   35,   45,
  158,   13,   56,  261,  187,  159,  188,  369,   57,   58,
   59,  112,   60,   61,
};
final static short yysindex[] = {                      -184,
   15,  -27,    0,    0, -187,    0,   57,    0,    0, -241,
   18,    0,    0,  588,  621,  341,  -25,  570,   25,  180,
   57,  539,  332,    0,    0,    0,  -39,   39,  122,  124,
    0,    0,    0,    0,    0,  -21, -214,   11,  180,    0,
    0,   50,  446,  178,    0,    0,    0,    0,  621,    0,
  -11,  621, -156, -188,   43,    0, -174,  679,   24,   19,
    0, -188,  598,  -20, -163,  596,   96,   51,   85,   -3,
   62,    0,   50,  539,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   -9,   66,   73, -214,   77, -214,
    0,    0,    0, -140,    0,    0, -188,    0,   79,    0,
    0,    0,  621,    0,  621,    0,    0,    0,    0,    0,
    0,  621,  621,  621,  621,  621, -148,  -38, -146,   86,
  -11,    0,    0, -132,  -44, -130, -139,  539,  539,   -2,
  539,  539, -143,    0,   97,    0,  539, -174,  679,   24,
   19,   19,    0,    0,  438,  438,  192,  438,    0,   98,
   88,   89, -123,  -12,   90,  438,  -29,    0,    0,    0,
  539,    0,    0,    0,  100,   92,  539,  570,    0, -133,
 -118,  239, -115, -114,    0,  621,  621,  101,  315,  621,
  621, -113,   76,   75,  442, -108,    0,    0,    0, -214,
    0,  570,    0,    0,    0, -208,    0,    0,   94,  109,
  621,  645,  137,  138,  139,    0,  119,  105,  459,  463,
   28,  129,  463,  143,  472,    0,  265,  -79,  -76,  140,
  -73,  456,  -70,  -69,  -68,  621,  619,  621,    4,  374,
  180,    0,  463,    0,  621,    0,  -55,  147,    0,  -62,
  169,  177,  144,  317,  369,   16,  371,  372,  376,   13,
  570,  286,  141,  570,  636,   17,   30,    0,   41,  179,
    0,    0,    0,  165,  165,  400,  165,  165,  -33,  165,
  165,  165,  165,  383,  487,  500,  518,  570,  527,  392,
  -34,  394,   32,  395,    0,   -4,  412,  403,  406,  165,
  408,  413,  -47,  418,  420,  421,  424,  432,  184,  452,
  453,  531,  454,  550,  458,  220,  225,  -53,  229,  233,
  236,  314,    0,  284,    0,    0,    0,    0,  457,    0,
    0,    0,  261,    0,    0,    0,    0,    0,    0,  621,
  621,  461,  180,  621,  483,  621,    0,    0,    0, -242,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   42,
   44,  648,   45,   46,   63,  621,   78,    0,    0,  465,
  466,  478,  -23,  479,   37,  486,   81,  497,  266,  291,
  294,  299,  300,  -24,  301,  302,  303,  305,  326,  521,
    0,    0,    0,    0,    0,  346,    0,    0,    0,    0,
    0,  621,    0,   83,  570,  557,  568,  621,   84,  561,
  351,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  635,    0,    0,    0,    0,    0,    0,  350,    0,
    0,    0,    0,  381,    0,    0,  405,  218,  356,  132,
    0,  397,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  629,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  409,    0,  414,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  455,    0,    0,
    0,    0,    0,    0,    0,    0,  489,  429,  263,  388,
  164,  325,    0,    0,    0,    0,    0,    0,    0,  414,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  492,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  569,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  503,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  509,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  562,    0,    0,    0,    0,
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
    0,    0,
};
final static short yygindex[] = {                         0,
   22,  543,    0,   21,  -16,    0,  -14,    0,    0,    0,
    0,    0,    0,  -10,  370,  624,    0,    0,  -15,  652,
    0,    0,  328,    0,    0,  741,    0,   23,    0,    0,
  -80,    0,    0,    0,    0,    0,    0,    0,  537,  547,
  546,    0,   -8,   -6,
};
final static int YYTABLESIZE=958;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   64,   67,  147,   53,   70,  340,  308,  293,   76,   53,
   39,  322,   37,  358,   65,   42,  154,  374,   85,   78,
  119,    7,   21,   70,  307,   53,   53,   41,   53,   98,
    2,  129,  359,   97,  386,  373,   55,  127,  161,   94,
   53,   41,   71,   74,  254,  100,  180,  118,  160,  162,
  163,  164,   76,  274,   20,   53,  270,  282,   86,   87,
  115,  216,    3,    4,   69,  116,  113,   39,  114,   38,
  283,   88,    1,   99,   53,  217,   46,  133,  103,   53,
  189,  284,  360,  104,  361,  364,  365,    2,   55,   90,
  310,  105,    3,    4,   41,  376,   39,   80,    5,  101,
  102,  120,  128,  366,  141,  142,  131,  130,  143,  144,
   53,  124,  135,  132,   39,   39,  136,  134,  368,  137,
  145,  378,  148,  395,  400,  151,  149,  155,  165,  156,
  169,  169,  169,  169,  178,   39,  193,  167,  175,  190,
  185,  169,  186,  150,  227,  126,  176,  177,  181,   52,
  191,  194,  218,  192,  197,  198,  206,  169,  226,  201,
  199,  200,  228,  203,  204,  205,  209,  219,  235,  211,
   76,  129,  129,  213,  129,  215,  129,   41,  241,  214,
   82,  242,   84,  237,  244,  220,  222,  247,  248,  249,
  129,  129,  229,  129,   76,  223,  224,  225,  243,  278,
   76,  260,  169,  130,  130,  262,  130,  263,  130,  264,
  250,  252,  253,  152,  256,  257,   77,  265,  153,  259,
   53,  339,  130,  130,   52,  130,  287,   14,  103,   36,
  146,   39,  103,   15,  275,  277,   96,  279,   16,  281,
  287,   17,    2,  103,  183,  179,  103,    3,    4,   19,
  385,  184,   92,    5,   73,    3,    4,  125,  125,  302,
   76,  304,   76,  103,   76,    3,    4,    3,    4,    2,
  103,   14,  313,  269,    3,    4,  125,   15,   39,  103,
    5,   68,   16,  103,   66,   17,    2,   76,   18,   76,
   15,    3,    4,   19,   79,   16,  103,    5,   17,  313,
  156,   18,  126,  126,   39,  156,   19,  103,  103,  233,
  103,  103,  103,   14,  350,  351,  353,  354,  355,   15,
  357,  126,   53,   39,   16,   39,  276,   17,    2,  103,
   18,   66,   66,    3,    4,   19,  363,   15,   15,    5,
  367,  125,   16,   16,  103,   17,   17,  103,  207,  103,
  103,  122,   66,   19,   19,  208,  210,  267,   15,   52,
  103,   47,   48,   16,  131,  131,   17,  131,   50,  131,
  123,   39,  345,  202,   19,  103,  394,   81,  396,   83,
   63,   76,  399,  131,  131,   52,  131,  129,  129,  129,
  129,  129,  129,  129,  129,  127,  127,  129,  129,  129,
  129,  266,  129,  103,  103,  103,  103,  103,   56,  268,
  129,  271,  272,  255,  127,  127,  273,  127,   52,  130,
  130,  130,  130,  130,  130,  130,  130,  128,  128,  130,
  130,  130,  130,   95,  130,  285,   47,   48,  287,   55,
  290,  299,  130,   50,  123,  123,  128,  128,   66,  128,
  306,   39,  309,  311,   15,   54,    3,    4,  329,   16,
  172,  317,   17,  123,  318,  168,  320,   52,  124,  124,
   19,  321,   77,  125,  125,  125,  324,   39,  325,  326,
  125,   39,  327,  125,  125,  125,  125,  124,  125,   94,
  328,  330,  331,  334,  337,   66,  125,  336,  231,  338,
  352,   15,   39,  341,   93,   52,   16,  342,  195,   17,
  343,   39,  168,   74,  246,  348,  349,   19,  126,  126,
  126,   66,  356,  370,  371,  126,   39,   15,  126,  126,
  126,  126,   16,  126,  239,   17,  372,  375,  168,   39,
   66,  126,   66,   19,  377,  380,   15,   72,   15,   40,
   89,   16,  103,   16,   17,  379,   17,   39,  346,  312,
  392,   68,   19,   72,   19,  381,   39,   70,  382,  344,
  333,   47,   48,  383,  384,  387,  388,  389,   50,  390,
  131,  131,  131,  131,  131,  131,  131,  131,   66,   39,
  131,  131,  131,  131,   15,  131,   39,   47,   48,   16,
  391,  393,   17,  131,   50,   56,   75,  398,    9,   39,
   19,  127,  127,  127,  127,  127,  127,  127,  127,  401,
   94,  127,  127,  127,  127,  402,  127,   51,    4,  286,
   47,   48,   52,   44,  127,  121,   55,   50,  117,  138,
   52,  347,   52,  128,  128,  128,  128,  128,  128,  128,
  128,  139,   54,  128,  128,  128,  128,  140,  128,  251,
  123,  123,  123,   52,   52,   52,  128,  123,   66,   77,
    0,  123,  123,  123,   15,  123,  280,    0,   79,   16,
   52,    0,   17,  123,  124,  124,  124,  312,  362,   52,
   19,  124,   52,   79,   66,  124,  124,  124,   66,  124,
   15,   91,   92,  221,   15,   16,    0,  124,   17,   16,
   74,  168,   17,  245,  212,   66,   19,   47,   48,   66,
   19,   15,  103,    0,   50,   15,   16,    0,   66,   17,
   16,  230,    0,   17,   15,    0,   18,   19,  110,   16,
  111,   19,   17,   66,   72,    0,  238,   89,    0,   15,
   19,    0,  232,  234,   16,  236,   66,   17,   68,  300,
    0,    0,   15,    0,   70,   19,    0,   16,    0,    0,
   17,    0,  301,    0,   66,  258,    0,    0,   19,    0,
   15,    0,    0,   66,    0,   16,    0,   66,   17,   15,
  303,    0,    0,   15,   16,   73,   19,   17,   16,  305,
    0,   17,    0,  332,    0,   19,   66,    0,    0,   19,
    2,    0,   15,   66,    0,    3,    4,   16,    0,   15,
   17,    5,  335,    0,   16,    9,   66,   17,   19,  397,
    0,    9,   15,    0,    0,   19,    9,   16,    0,    9,
   17,    9,    0,    0,   47,   48,    0,    9,   19,    0,
   49,   50,   47,   48,   47,   48,    0,    0,   49,   50,
    0,   50,    0,    0,    3,    4,    0,    0,    0,    0,
    0,    0,    3,    4,    0,   47,   48,   47,   48,    0,
    0,    0,   50,    0,   50,    0,  171,  173,  174,    0,
   79,   79,   47,   48,    0,    0,  182,    0,    0,   50,
    0,   47,   48,    0,   47,   48,    0,    0,   50,    0,
    0,   50,  196,    0,    0,    0,  289,    0,  291,  292,
  294,  295,  296,  297,  298,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  106,  107,  108,
  109,  319,    0,    0,  323,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  240,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         15,
   16,   18,   41,   14,   20,   59,   41,   41,   23,   20,
   40,   59,   40,  256,   40,  257,   61,   41,   40,   59,
   41,    0,    1,   39,   59,   36,   37,    7,   39,   41,
  272,   41,  275,   49,   59,   59,   14,   41,   41,   44,
   51,   21,   20,   22,   41,   52,   59,   63,  129,  130,
  131,  132,   67,   41,   40,   66,   41,   41,   36,   37,
   42,  270,  277,  278,   40,   47,   43,   40,   45,  257,
   41,   61,  257,   51,   85,  284,   59,   88,  267,   90,
  161,   41,   41,   41,   41,   41,   41,  272,   66,   40,
   59,  266,  277,  278,   74,   59,   40,   59,  283,  256,
  257,  265,   41,   41,  113,  114,   41,   85,  115,  116,
  121,   61,   90,   41,   40,   40,  257,   41,   41,   41,
  269,   41,  269,   41,   41,  258,   41,  258,  272,  269,
  145,  146,  147,  148,  258,   40,  270,   41,   41,   40,
  157,  156,  157,  121,   40,   61,   59,   59,   59,   45,
   59,  270,   59,  168,  270,  270,  270,  172,   40,   59,
  176,  177,   58,  179,  180,  181,  183,   59,   40,  184,
  185,   40,   41,  282,   43,  192,   45,  157,  258,  190,
   59,  258,   59,   41,  258,  201,  202,  258,  258,  258,
   59,   60,  208,   62,  209,   59,   59,   59,   59,   59,
  215,  257,  217,   40,   41,   59,   43,  270,   45,   41,
  226,  227,  228,  258,  230,  231,  256,   41,  263,  235,
  231,  275,   59,   60,   45,   62,  274,  257,  267,  257,
  269,   40,  267,  263,  251,  252,   59,  254,  268,  255,
  274,  271,  272,  267,  274,  258,  267,  277,  278,  279,
  275,  281,  257,  283,  257,  277,  278,   40,   41,  276,
  275,  278,  277,  267,  279,  277,  278,  277,  278,  272,
  267,  257,  287,  258,  277,  278,   59,  263,   40,  267,
  283,  257,  268,  267,  257,  271,  272,  302,  274,  304,
  263,  277,  278,  279,  256,  268,  267,  283,  271,  314,
  269,  274,   40,   41,   40,  269,  279,  267,  267,  282,
  267,  267,  267,  257,  330,  331,  332,  333,  334,  263,
  336,   59,  333,   40,  268,   40,   41,  271,  272,  267,
  274,  257,  257,  277,  278,  279,  352,  263,  263,  283,
  356,  257,  268,  268,  267,  271,  271,  267,  273,  267,
  267,  256,  257,  279,  279,  280,  282,   41,  263,   45,
  267,  257,  258,  268,   40,   41,  271,   43,  264,   45,
  275,   40,   59,   59,  279,  267,  392,  256,  395,  256,
   40,  396,  398,   59,   60,   45,   62,  256,  257,  258,
  259,  260,  261,  262,  263,   40,   41,  266,  267,  268,
  269,  258,  271,  267,  267,  267,  267,  267,   59,   41,
  279,   41,   41,   40,   59,   60,   41,   62,   45,  256,
  257,  258,  259,  260,  261,  262,  263,   40,   41,  266,
  267,  268,  269,  256,  271,  257,  257,  258,  274,   59,
   41,   59,  279,  264,   40,   41,   59,   60,  257,   62,
   59,   40,   59,   59,  263,   59,  277,  278,  275,  268,
  269,   59,  271,   59,   59,  274,   59,   59,   40,   41,
  279,   59,   59,  256,  257,  258,   59,   40,   59,   59,
  263,   40,   59,  266,  267,  268,  269,   59,  271,   44,
   59,   40,   40,   40,  275,  257,  279,   40,   40,  275,
   40,  263,   40,  275,   59,   45,  268,  275,  270,  271,
  275,   40,  274,   59,   59,   59,  256,  279,  256,  257,
  258,  257,   40,   59,   59,  263,   40,  263,  266,  267,
  268,  269,  268,  271,  270,  271,   59,   59,  274,   40,
  257,  279,  257,  279,   59,  280,  263,   59,  263,    7,
   59,  268,  267,  268,  271,   59,  271,   40,  275,  276,
   40,   59,  279,   21,  279,  275,   40,   59,  275,  256,
   40,  257,  258,  275,  275,  275,  275,  275,  264,  275,
  256,  257,  258,  259,  260,  261,  262,  263,  257,   40,
  266,  267,  268,  269,  263,  271,   40,  257,  258,  268,
  275,  256,  271,  279,  264,  256,  275,   40,   40,   40,
  279,  256,  257,  258,  259,  260,  261,  262,  263,   59,
   59,  266,  267,  268,  269,  275,  271,   40,    0,  260,
  257,  258,   45,   10,  279,   40,  256,  264,   41,  103,
   45,  314,   45,  256,  257,  258,  259,  260,  261,  262,
  263,  105,  256,  266,  267,  268,  269,  112,  271,   41,
  256,  257,  258,   45,  256,   45,  279,  263,  257,  256,
   -1,  267,  268,  269,  263,  271,   41,   -1,   44,  268,
   45,   -1,  271,  279,  256,  257,  258,  276,   41,   45,
  279,  263,   45,   59,  257,  267,  268,  269,  257,  271,
  263,  256,  257,   59,  263,  268,   -1,  279,  271,  268,
  256,  274,  271,  258,  273,  257,  279,  257,  258,  257,
  279,  263,  267,   -1,  264,  263,  268,   -1,  257,  271,
  268,  273,   -1,  271,  263,   -1,  274,  279,   60,  268,
   62,  279,  271,  257,  256,   -1,  275,  256,   -1,  263,
  279,   -1,  210,  211,  268,  213,  257,  271,  256,  273,
   -1,   -1,  263,   -1,  256,  279,   -1,  268,   -1,   -1,
  271,   -1,  273,   -1,  257,  233,   -1,   -1,  279,   -1,
  263,   -1,   -1,  257,   -1,  268,   -1,  257,  271,  263,
  273,   -1,   -1,  263,  268,  257,  279,  271,  268,  273,
   -1,  271,   -1,  273,   -1,  279,  257,   -1,   -1,  279,
  272,   -1,  263,  257,   -1,  277,  278,  268,   -1,  263,
  271,  283,  273,   -1,  268,  257,  257,  271,  279,  273,
   -1,  263,  263,   -1,   -1,  279,  268,  268,   -1,  271,
  271,  273,   -1,   -1,  257,  258,   -1,  279,  279,   -1,
  263,  264,  257,  258,  257,  258,   -1,   -1,  263,  264,
   -1,  264,   -1,   -1,  277,  278,   -1,   -1,   -1,   -1,
   -1,   -1,  277,  278,   -1,  257,  258,  257,  258,   -1,
   -1,   -1,  264,   -1,  264,   -1,  146,  147,  148,   -1,
  256,  257,  257,  258,   -1,   -1,  156,   -1,   -1,  264,
   -1,  257,  258,   -1,  257,  258,   -1,   -1,  264,   -1,
   -1,  264,  172,   -1,   -1,   -1,  265,   -1,  267,  268,
  269,  270,  271,  272,  273,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  259,  260,  261,
  262,  290,   -1,   -1,  293,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  217,
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
"sentencia_ejecucion : control",
"sentencia_ejecucion : seleccion ';'",
"sentencia_ejecucion : impresion ';'",
"sentencia_ejecucion : invocacion ';'",
"sentencia_ejecucion : asignacion ';'",
"sentencia_ejecucion : error_ejecucion",
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
"control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat ';'",
"control : error_control",
"error_control : REPEAT IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' ';' condicion ';' CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG condicion ';' CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' ';' CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion CTE_ULONG ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' ')' bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG bloque_repeat ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' ';'",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat error",
"bloque_repeat : BEGIN bloque_control END",
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
"seleccion : IF '(' condicion ')' THEN bloque_if ENDIF",
"seleccion : IF '(' condicion ')' THEN bloque_if ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"bloque_if : sentencia_ejecucion",
"bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END ';'",
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

//#line 274 "Gramatica.y"

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
//#line 711 "Parser.java"
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
//#line 57 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 25:
//#line 59 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"}");}
break;
case 27:
//#line 64 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
//#line 65 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 66 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 32:
//#line 75 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 34:
//#line 79 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 35:
//#line 80 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 36:
//#line 81 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 37:
//#line 82 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 38:
//#line 83 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 39:
//#line 84 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 40:
//#line 85 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 41:
//#line 86 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 42:
//#line 87 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 43:
//#line 88 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 44:
//#line 89 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';' al final}");}
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
case 62:
//#line 128 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 63:
//#line 129 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 64:
//#line 130 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 65:
//#line 131 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 66:
//#line 132 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 67:
//#line 133 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 68:
//#line 134 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 69:
//#line 135 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 70:
//#line 136 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 72:
//#line 144 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + val_peek(3).sval + "'}");}
break;
case 74:
//#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 75:
//#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 76:
//#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 77:
//#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 78:
//#line 155 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 79:
//#line 156 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 81:
//#line 161 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 82:
//#line 163 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 84:
//#line 168 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 85:
//#line 169 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 86:
//#line 170 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 87:
//#line 171 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 88:
//#line 172 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 89:
//#line 173 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 92:
//#line 181 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 98:
//#line 198 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 99:
//#line 199 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 100:
//#line 200 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 104:
//#line 208 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 105:
//#line 209 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 106:
//#line 210 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 107:
//#line 211 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 108:
//#line 212 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 109:
//#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 110:
//#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 111:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 112:
//#line 217 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 113:
//#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 114:
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 115:
//#line 220 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 116:
//#line 221 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 117:
//#line 222 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 118:
//#line 223 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 119:
//#line 224 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 120:
//#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 121:
//#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 122:
//#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 124:
//#line 235 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 126:
//#line 239 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 128:
//#line 243 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 130:
//#line 247 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 131:
//#line 248 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 132:
//#line 251 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 133:
//#line 252 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 135:
//#line 257 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");}
break;
case 136:
//#line 258 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");}
break;
case 137:
//#line 259 "Gramatica.y"
{chequearFactorNegado();}
break;
case 138:
//#line 260 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1216 "Parser.java"
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
