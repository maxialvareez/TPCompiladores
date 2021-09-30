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
    0,    0,   32,    0,   31,    0,    0,    2,    5,    0,
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
final static short yysindex[] = {                      -225,
  214,  -28,    0, -226,    0,    0,  232,    0,    0, -218,
   -2,    0,    0,   24,  613,  505,   26,  843,  -26,  502,
  232,  556,  362,    0,    0,  -40,   80,  110,  118,  123,
    0,    0,    0,    0,    0,  -37, -229,   17,  502,    0,
    0,   36,  144,  313,    0,    0,    0,    0,  613,    0,
  -35,  613, -157, -186,   42,    0, -180,  434,   20,  -14,
    0, -186,  -34,  -11, -177,  264,  335,   31,  107,    2,
   53,    0,   36,  556,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -33,   55,   63, -229,
   64, -229,    0,    0,    0, -149,    0,    0, -186,    0,
   74,    0,    0,    0,  613,    0,  613,    0,    0,    0,
    0,    0,    0,  613,  613,  613,  613,  613, -159,  -25,
 -152,   77,  -35,    0,    0, -146,  -43, -129, -139,  556,
  556,  242,  556,  556, -137,    0,   96,    0,  556, -180,
  434,   20,  -14,  -14,    0,    0,  843,  843,  303,  843,
    0,   97,   81,   85, -117,  -36,   86,  843,  195,    0,
    0,    0,  556,    0,    0,    0,  106,   89,  556,  479,
  637,  647,  662,  677,    0,  613,  613,   90,  363,  613,
  613,  681,   71,  273,  704, -132,    0,    0,    0, -229,
    0,    0,    0,    0,  -31,    0,    0,   -7,   28,  613,
  759,  101,  113,  128,    0,  114,  112,  705,  717,  272,
  115,  717,  122,   94,  724,  -99,  -87,  130,  -85,  -46,
  -80,  -79,  -77,  613,  427,  613,    3,  638,  502,    0,
  717,    0,  613,    0,  -74,    0,    0,  741,  143,  150,
  -68,  152,  153,    9,  154,  155,  156,   10,  843,  386,
  149,  843,  678,   27,   29,    0,   38,  -59,    0,  145,
  750,  750,  164,  750,  750,  635,  750,  750,  750,  750,
  147,  751,  770,  774,  843,  789,  148,  -21,  158,  -42,
  351,    0,  -29,    0,  375,    0,   -5,    0,    0,   21,
  750,   22,   62,   69,  135,  136,  160,  161,  162,  174,
  410,  411,  798,  417,  802,  420,  190,  200,  -22,  205,
  212,  215,    0,    0,    0,    0,    0,  185,    0,    0,
    0,  750,    0,    0,    0,    0,    0,    0,  613,  613,
  663,  502,  613,  465,  613,    0,    0,    0, -235,    0,
    0,    0,    0,   43,   44,  707,   54,   56,   57,  613,
   60,    0,    0,  450,  458,  474,    1,  478,   34,  480,
   79,  494,  244,  263,  287,  288,  289,   16,  290,  292,
  293,  295,  302,  539,    0,    0,    0,    0,    0,  328,
    0,    0,    0,    0,    0,  613,    0,   82,  843,  825,
  546,  613,   95,  528,  314,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  514,    0,    0,    0,    0,    0,    0,  376,    0,
    0,    0,    0,  395,    0,    0,  605,  403,  472,  516,
    0,  396,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  590,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  400,    0,
  432,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  442,
    0,    0,    0,    0,    0,    0,    0,    0,  448,  622,
  443,  588,  540,  564,    0,    0,    0,    0,    0,    0,
    0,  432,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  449,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  826,    0,    0,    0,    0,
    0,    0,    0,    0,  459,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  464,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  529,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  490,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   45,  384,    0,   15,  -16,    0,   91,    0,    0,    0,
    0,    0,    0,  -10,  337,  587,    0,    0,  -15,  859,
    0, -171,    0,    0,    0, 1065,    0,    0,  -60,    0,
    0,    0,    0,    0,    0,    0,  496,  501,  497,    0,
   -9,  -27,
};
final static int YYTABLESIZE=1188;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   64,   67,   87,   53,   70,  100,  119,  131,   39,   53,
   52,   37,  244,   69,   96,  149,  311,  156,   78,  309,
  352,   41,  180,   70,  102,   53,   53,  117,   53,  121,
   38,    1,  118,   99,   39,   41,  339,  308,   42,  353,
   53,  368,  129,  252,    7,   21,    2,  120,    3,  267,
  271,  216,    3,    2,    5,   53,   46,    4,    5,  367,
   39,   39,  115,   51,  116,   65,   74,  279,   52,  280,
  162,  164,  165,  166,  380,   92,   53,   90,  281,  135,
  105,   53,  106,  354,  355,  107,  217,  122,   41,  145,
  146,  126,  370,  130,  358,  133,  359,  360,  103,  104,
  362,   39,  189,  134,  136,  143,  144,  138,   39,  147,
   39,  153,   53,   76,  139,  316,  150,  151,  316,  372,
  316,  316,  389,  316,  316,  316,  316,  316,  157,  158,
  170,  171,  173,  174,  167,  394,  169,  175,   80,  176,
  178,  182,  185,  177,  181,  190,  316,  191,  200,  212,
  316,  225,  236,  224,  233,  195,   52,   76,  239,  221,
  198,  199,  235,  202,  203,  204,  208,  128,   82,  226,
  240,  222,  242,   41,   39,   39,   84,  245,  246,  213,
  247,   86,  258,  261,  218,  220,  223,   96,  241,  263,
  262,  227,  264,  265,  268,  269,  270,  282,  238,   39,
   39,   39,   95,  284,  291,  300,  307,  275,  248,  250,
  251,  243,  254,  255,  154,   77,  310,  257,   53,  155,
  105,  179,   47,   48,   39,   66,  158,   94,   36,   50,
   68,   15,  272,  274,   39,  276,   16,  278,  214,   17,
    3,  105,    3,  148,    3,  105,    5,   19,    5,  186,
    5,   66,  338,   20,  215,  105,  303,   15,  305,  105,
   76,   76,   16,   76,   76,   17,  266,  105,  105,  105,
  285,   39,   76,   19,  210,   76,  105,   66,   66,  315,
   47,   48,  163,   15,   15,   76,   49,   50,   16,   16,
  379,   17,   17,  105,  105,  105,  285,  285,   76,   19,
   19,    3,  158,  123,  105,  317,  319,    5,   52,  105,
  105,   39,   39,  344,  345,  347,  348,  349,   66,  351,
  105,   53,  105,  105,   15,   66,  105,   66,   76,   16,
  357,   15,   17,   15,  361,   79,   16,  285,   16,   17,
   19,   17,   39,  206,  285,  105,  320,   19,  105,   19,
  207,  286,  286,  321,  286,  286,  286,  286,  286,  286,
  286,  105,   76,  127,   76,   81,   76,  105,   47,   48,
  388,   98,  390,   83,   39,   50,  393,  286,   85,  105,
  286,  286,  286,  286,  286,  286,  286,  286,  286,  286,
   40,   66,   66,   76,  105,   76,  105,   15,   15,   93,
   94,   39,   16,   16,   72,   17,   17,   52,  286,  312,
  285,  285,  286,   19,   19,  105,   66,   66,   66,  323,
  324,  201,   15,   15,   15,   39,  273,   16,   16,   16,
   17,   17,   17,  314,   56,  285,  285,  285,   19,   19,
   19,   66,  123,  123,  325,  326,  327,   15,  328,  329,
  330,   14,   16,   55,   54,   17,  333,   15,   52,  335,
  285,  123,   16,   19,  336,   17,    2,  249,  183,  343,
   14,   52,    3,   19,  337,  184,   15,    4,    5,  340,
   76,   16,  124,  124,   17,    2,  341,   18,   14,  342,
   75,    3,   19,  112,   15,  113,    4,    5,   73,   16,
   72,  124,   17,    2,  350,   18,   70,   87,  364,    3,
   19,  125,  125,    2,    4,    5,  365,   66,   39,    3,
   47,   48,   68,  374,    4,    5,   49,   50,   66,   66,
  125,  125,  366,  125,   15,   15,  369,  375,  371,   16,
   16,    3,   17,   17,   63,   18,   52,    5,   45,   52,
   19,   19,  373,  231,  209,  127,  127,   77,  127,   66,
  127,  376,  377,  378,  381,   15,  382,  383,   97,  384,
   16,  172,   77,   17,  127,  127,  385,  127,  386,  128,
  128,   19,  128,  387,  128,  392,  395,   92,  396,    4,
  124,   66,  230,  232,  283,  234,   44,   15,  128,  128,
  140,  128,   16,  129,  129,   17,  129,  141,  129,  125,
  142,    0,    0,   19,  256,    0,    0,    0,   66,   47,
   48,    0,  129,  129,   15,  129,   50,  126,  126,   16,
  313,   56,   17,    0,    0,    0,   75,    0,    0,    0,
   19,    0,   66,    0,  121,  121,  126,  126,   15,  126,
   55,   54,  105,   16,    0,   52,   17,   52,  123,  123,
  123,  122,  122,  121,   19,  123,    0,    0,  123,  123,
  123,  123,    0,  123,   39,  294,   39,  253,    0,    0,
  122,  123,   52,   47,   48,    0,   39,   75,    0,    0,
   50,    0,  108,  109,  110,  111,    0,   72,  124,  124,
  124,   39,  346,   70,   87,  124,    0,   52,  124,  124,
  124,  124,    0,  124,   66,    0,   39,    0,  277,   68,
   39,  124,   52,    0,    0,    0,    0,  125,  125,  125,
  125,  125,  125,  125,  125,   66,    0,  125,  125,  125,
  125,   15,  125,   39,  229,   45,   16,  356,  192,   17,
  125,   52,    0,    0,    0,    0,   39,   19,   47,   48,
    0,   47,   48,   39,    0,   50,    0,    0,   50,   77,
   77,  127,  127,  127,  127,  127,  127,  127,  127,    3,
   39,  127,  127,  127,  127,    5,  127,    0,    0,   39,
   39,    0,    0,    0,  127,  128,  128,  128,  128,  128,
  128,  128,  128,   52,    0,  128,  128,  128,  128,   39,
  128,    0,   73,   39,    0,    0,    0,  219,  128,  129,
  129,  129,  129,  129,  129,  129,  129,    2,   39,  129,
  129,  129,  129,    3,  129,    0,    0,  332,    4,    5,
    0,   39,  129,  126,  126,  126,  126,  126,  126,  126,
  126,    0,    0,  126,  126,  126,  126,    0,  126,    0,
  121,  121,  121,    0,   39,    9,  126,  121,    0,   47,
   48,  121,  121,  121,    0,  121,   50,  122,  122,  122,
    0,    0,   39,  121,  122,    0,    0,    0,  122,  122,
  122,   66,  122,   66,   47,   48,    0,   15,    0,   15,
  122,   50,   16,   66,   16,   17,  193,   17,    0,   15,
  285,    0,    0,   19,   16,   19,  194,   17,   66,   47,
   48,    0,    0,    0,   15,   19,   50,    0,    0,   16,
    0,  196,   17,   66,   47,   48,    0,   66,    0,   15,
   19,   50,    0,   15,   16,    0,  197,   17,   16,    0,
  205,   17,    0,    0,    0,   19,    0,    0,    0,   19,
   66,   66,    0,   47,   48,    0,   15,   15,    0,    0,
   50,   16,   16,   66,   17,   17,  211,  228,    0,   15,
   66,    0,   19,   19,   16,    0,   15,   17,    0,    0,
   18,   16,    0,  237,   17,   19,    0,   66,    0,    0,
    0,    0,   19,   15,    0,    0,   66,   66,   16,    0,
  260,   17,   15,   15,    0,   47,   48,   16,   16,   19,
   17,   17,   50,  301,    0,  285,   66,    0,   19,   19,
   66,    0,   15,    0,    0,    0,   15,   16,    0,    0,
   17,   16,  302,    0,   17,   66,  304,    0,   19,    0,
    0,   15,   19,    0,   66,    0,   16,    0,   66,   17,
   15,  306,    0,    0,   15,   16,    0,   19,   17,   16,
  331,    0,   17,    0,  334,    0,   19,    0,   55,    0,
   19,   66,    9,    0,   71,    0,    0,   15,    9,    0,
    0,    0,   16,    9,    0,   17,    9,  391,    9,   66,
   88,   89,    0,   19,    9,   15,    0,    0,    0,    0,
   16,    0,    0,   17,    0,  101,    0,    0,    0,    0,
  290,   19,  292,  293,  295,  296,  297,  298,  299,    0,
   55,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  318,
    0,  132,  322,    0,    0,    0,  137,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  152,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         15,
   16,   18,   40,   14,   20,   41,   41,   41,   40,   20,
   45,   40,   59,   40,   44,   41,   59,   61,   59,   41,
  256,    7,   59,   39,   52,   36,   37,   42,   39,   41,
  257,  257,   47,   49,   40,   21,   59,   59,  257,  275,
   51,   41,   41,   41,    0,    1,  272,   63,  278,   41,
   41,   59,  278,  272,  284,   66,   59,  283,  284,   59,
   40,   40,   43,   40,   45,   40,   22,   41,   45,   41,
  131,  132,  133,  134,   59,   40,   87,   61,   41,   90,
  267,   92,   41,   41,   41,  266,   59,  265,   74,  117,
  118,   61,   59,   41,   41,   41,   41,   41,  256,  257,
   41,   40,  163,   41,   41,  115,  116,  257,   40,  269,
   40,  258,  123,   23,   41,  287,  269,   41,  290,   41,
  292,  293,   41,  295,  296,  297,  298,  299,  258,  269,
  147,  148,  149,  150,  272,   41,   41,   41,   59,   59,
  258,  158,  159,   59,   59,   40,  318,   59,   59,  282,
  322,   40,   59,   40,   40,  172,   45,   67,  258,   59,
  176,  177,   41,  179,  180,  181,  183,   61,   59,   58,
  258,   59,  258,  159,   40,   40,   59,  258,  258,  190,
  258,   59,  257,   41,  200,  201,   59,   44,   59,  258,
   41,  207,   41,   41,   41,   41,   41,  257,  215,   40,
   40,   40,   59,   59,   41,   59,   59,   59,  224,  225,
  226,  258,  228,  229,  258,  256,   59,  233,  229,  263,
  267,  258,  257,  258,   40,  257,  269,  257,  257,  264,
  257,  263,  249,  250,   40,  252,  268,  253,  270,  271,
  278,  267,  278,  269,  278,  267,  284,  279,  284,  159,
  284,  257,  275,   40,  286,  267,  273,  263,  275,  267,
  170,  171,  268,  173,  174,  271,  258,  267,  267,  267,
  276,   40,  182,  279,  184,  185,  267,  257,  257,  285,
  257,  258,   41,  263,  263,  195,  263,  264,  268,  268,
  275,  271,  271,  267,  267,  267,  276,  276,  208,  279,
  279,  278,  269,   40,  267,  285,  285,  284,   45,  267,
  267,   40,   40,  329,  330,  331,  332,  333,  257,  335,
  267,  332,  267,  267,  263,  257,  267,  257,  238,  268,
  346,  263,  271,  263,  350,  256,  268,  276,  268,  271,
  279,  271,   40,  273,  276,  267,  285,  279,  267,  279,
  280,  261,  262,  285,  264,  265,  266,  267,  268,  269,
  270,  267,  272,  257,  274,  256,  276,  267,  257,  258,
  386,   59,  389,  256,   40,  264,  392,  287,  256,  267,
  290,  291,  292,  293,  294,  295,  296,  297,  298,  299,
    7,  257,  257,  303,  267,  305,  267,  263,  263,  256,
  257,   40,  268,  268,   21,  271,  271,   45,  318,   59,
  276,  276,  322,  279,  279,  267,  257,  257,  257,  285,
  285,   59,  263,  263,  263,   40,   41,  268,  268,  268,
  271,  271,  271,   59,   59,  276,  276,  276,  279,  279,
  279,  257,   40,   41,  285,  285,  285,  263,  275,   40,
   40,  257,  268,   59,   59,  271,   40,  263,   59,   40,
  276,   59,  268,  279,  275,  271,  272,   41,  274,  285,
  257,   45,  278,  279,  275,  281,  263,  283,  284,  275,
  390,  268,   40,   41,  271,  272,  275,  274,  257,  275,
   59,  278,  279,   60,  263,   62,  283,  284,  257,  268,
   59,   59,  271,  272,   40,  274,   59,   59,   59,  278,
  279,   40,   41,  272,  283,  284,   59,   59,   40,  278,
  257,  258,   59,  280,  283,  284,  263,  264,  257,  257,
   59,   60,   59,   62,  263,  263,   59,  275,   59,  268,
  268,  278,  271,  271,   40,  274,   45,  284,   59,   45,
  279,  279,   59,  282,  282,   40,   41,   44,   43,  257,
   45,  275,  275,  275,  275,  263,  275,  275,  256,  275,
  268,  269,   59,  271,   59,   60,  275,   62,   40,   40,
   41,  279,   43,  256,   45,   40,   59,   59,  275,    0,
  256,  257,  209,  210,  258,  212,   10,  263,   59,   60,
  105,   62,  268,   40,   41,  271,   43,  107,   45,  275,
  114,   -1,   -1,  279,  231,   -1,   -1,   -1,  257,  257,
  258,   -1,   59,   60,  263,   62,  264,   40,   41,  268,
  256,  256,  271,   -1,   -1,   -1,  275,   -1,   -1,   -1,
  279,   -1,  257,   -1,   40,   41,   59,   60,  263,   62,
  256,  256,  267,  268,   -1,  256,  271,   45,  256,  257,
  258,   40,   41,   59,  279,  263,   -1,   -1,  266,  267,
  268,  269,   -1,  271,   40,   41,   40,   40,   -1,   -1,
   59,  279,   45,  257,  258,   -1,   40,  256,   -1,   -1,
  264,   -1,  259,  260,  261,  262,   -1,  256,  256,  257,
  258,   40,   40,  256,  256,  263,   -1,   45,  266,  267,
  268,  269,   -1,  271,  256,   -1,   40,   -1,   41,  256,
   40,  279,   45,   -1,   -1,   -1,   -1,  256,  257,  258,
  259,  260,  261,  262,  263,  257,   -1,  266,  267,  268,
  269,  263,  271,   40,   40,  256,  268,   41,  270,  271,
  279,   45,   -1,   -1,   -1,   -1,   40,  279,  257,  258,
   -1,  257,  258,   40,   -1,  264,   -1,   -1,  264,  256,
  257,  256,  257,  258,  259,  260,  261,  262,  263,  278,
   40,  266,  267,  268,  269,  284,  271,   -1,   -1,   40,
   40,   -1,   -1,   -1,  279,  256,  257,  258,  259,  260,
  261,  262,  263,   45,   -1,  266,  267,  268,  269,   40,
  271,   -1,  257,   40,   -1,   -1,   -1,   59,  279,  256,
  257,  258,  259,  260,  261,  262,  263,  272,   40,  266,
  267,  268,  269,  278,  271,   -1,   -1,   40,  283,  284,
   -1,   40,  279,  256,  257,  258,  259,  260,  261,  262,
  263,   -1,   -1,  266,  267,  268,  269,   -1,  271,   -1,
  256,  257,  258,   -1,   40,   40,  279,  263,   -1,  257,
  258,  267,  268,  269,   -1,  271,  264,  256,  257,  258,
   -1,   -1,   40,  279,  263,   -1,   -1,   -1,  267,  268,
  269,  257,  271,  257,  257,  258,   -1,  263,   -1,  263,
  279,  264,  268,  257,  268,  271,  270,  271,   -1,  263,
  276,   -1,   -1,  279,  268,  279,  270,  271,  257,  257,
  258,   -1,   -1,   -1,  263,  279,  264,   -1,   -1,  268,
   -1,  270,  271,  257,  257,  258,   -1,  257,   -1,  263,
  279,  264,   -1,  263,  268,   -1,  270,  271,  268,   -1,
  270,  271,   -1,   -1,   -1,  279,   -1,   -1,   -1,  279,
  257,  257,   -1,  257,  258,   -1,  263,  263,   -1,   -1,
  264,  268,  268,  257,  271,  271,  273,  273,   -1,  263,
  257,   -1,  279,  279,  268,   -1,  263,  271,   -1,   -1,
  274,  268,   -1,  270,  271,  279,   -1,  257,   -1,   -1,
   -1,   -1,  279,  263,   -1,   -1,  257,  257,  268,   -1,
  270,  271,  263,  263,   -1,  257,  258,  268,  268,  279,
  271,  271,  264,  273,   -1,  276,  257,   -1,  279,  279,
  257,   -1,  263,   -1,   -1,   -1,  263,  268,   -1,   -1,
  271,  268,  273,   -1,  271,  257,  273,   -1,  279,   -1,
   -1,  263,  279,   -1,  257,   -1,  268,   -1,  257,  271,
  263,  273,   -1,   -1,  263,  268,   -1,  279,  271,  268,
  273,   -1,  271,   -1,  273,   -1,  279,   -1,   14,   -1,
  279,  257,  257,   -1,   20,   -1,   -1,  263,  263,   -1,
   -1,   -1,  268,  268,   -1,  271,  271,  273,  273,  257,
   36,   37,   -1,  279,  279,  263,   -1,   -1,   -1,   -1,
  268,   -1,   -1,  271,   -1,   51,   -1,   -1,   -1,   -1,
  262,  279,  264,  265,  266,  267,  268,  269,  270,   -1,
   66,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  291,
   -1,   87,  294,   -1,   -1,   -1,   92,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  123,
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
"declaracion : tipo funcion ';'",
"declaracion : TYPEDEF IDENTIFICADOR '=' tipo funcion_type ';'",
"declaracion : error_declaracion",
"error_declaracion : tipo lista_de_variables error",
"error_declaracion : tipo funcion error",
"error_declaracion : funcion ';'",
"tipo : UINT",
"tipo : DOUBLE",
"control : REPEAT '(' IDENTIFICADOR ASIGNACION CTE_UINT ';' condicion ';' CTE_UINT ')' bloque_control ENDREPEAT",
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

//#line 268 "Gramatica.y"

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
//#line 754 "Parser.java"
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
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"}");}
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
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 38:
//#line 83 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante UINT}");}
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
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_UINT}");}
break;
case 43:
//#line 88 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 44:
//#line 89 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 45:
//#line 90 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta indicar el fin del ciclo con ENDREPEAT}");}
break;
case 51:
//#line 102 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 54:
//#line 110 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 55:
//#line 111 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 56:
//#line 112 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 60:
//#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 61:
//#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 62:
//#line 124 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 63:
//#line 125 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 64:
//#line 126 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 65:
//#line 127 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 66:
//#line 128 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 67:
//#line 129 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 68:
//#line 130 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 70:
//#line 138 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + val_peek(3).sval + "'}");}
break;
case 72:
//#line 142 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 73:
//#line 143 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 74:
//#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 75:
//#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 76:
//#line 149 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 77:
//#line 150 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 79:
//#line 155 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 80:
//#line 157 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 82:
//#line 162 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 83:
//#line 163 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 84:
//#line 164 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 85:
//#line 165 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 86:
//#line 166 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 87:
//#line 167 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 90:
//#line 175 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 96:
//#line 192 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 97:
//#line 193 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 98:
//#line 194 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 102:
//#line 202 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 103:
//#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 104:
//#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el RETURN");}
break;
case 105:
//#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta '(' ");}
break;
case 106:
//#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta indicar el retorno");}
break;
case 107:
//#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta ')' ");}
break;
case 108:
//#line 208 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta ';' ");}
break;
case 109:
//#line 209 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el END ");}
break;
case 110:
//#line 211 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 111:
//#line 212 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 112:
//#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 113:
//#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 114:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 115:
//#line 216 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 116:
//#line 217 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 117:
//#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 118:
//#line 220 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 119:
//#line 221 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 120:
//#line 222 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 122:
//#line 229 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval + "||" + val_peek(0).sval + "}");}
break;
case 124:
//#line 233 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval + "&&" + val_peek(0).sval+ "}");}
break;
case 126:
//#line 237 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +val_peek(1).sval+ val_peek(0).sval + "}");}
break;
case 128:
//#line 241 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"+"+ val_peek(0).sval+ "}");}
break;
case 129:
//#line 242 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"-"+ val_peek(0).sval+ "}");}
break;
case 130:
//#line 245 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"*"+ val_peek(0).sval+ "}");}
break;
case 131:
//#line 246 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"/"+ val_peek(0).sval+ "}");}
break;
case 133:
//#line 251 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval);}
break;
case 134:
//#line 252 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante UINT: " + val_peek(0).sval);}
break;
case 135:
//#line 253 "Gramatica.y"
{chequearFactorNegado();}
break;
case 136:
//#line 254 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1259 "Parser.java"
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
