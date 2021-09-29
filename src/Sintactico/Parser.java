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
   69,    0,    0,    0,    0,    0,    0,    0,   82,   95,
   85,    0,   86,   84,   83,    0,    0,    0,    0,    0,
    0,    0,    0,   70,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   93,  101,   80,    0,   26,   62,
   63,   65,    0,   64,   61,    0,    0,    0,    0,    0,
    0,   60,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   97,    0,   98,    0,   96,
    0,   57,   67,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   94,    0,    0,   91,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   77,    0,   58,    0,   48,
    0,   46,   50,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   51,   49,   35,   47,   37,
   40,   41,   44,    0,   43,   42,   39,   38,   36,  103,
    0,    0,    0,    0,    0,    0,    0,  106,  107,  108,
    0,  105,  104,  102,   33,    0,    0,    0,    0,    0,
    0,    0,    0,  109,   99,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  119,  111,  114,  115,
  116,    0,  113,  112,  120,  100,  118,    0,  117,    0,
    0,    0,    0,    0,    0,    0,    0,  110,
};
final static short yydgoto[] = {                          6,
  158,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  167,   12,   54,  281,
   32,  282,  283,   33,   34,   91,   35,   45,  159,   13,
   56,  254,  185,  160,  186,  355,   57,   58,   59,  114,
   60,   61,
};
final static short yysindex[] = {                       -98,
  222,  -23,    0, -239,    0,    0,  240,    0,    0, -219,
  -38,    0,    0,  -37,  291,  -34,    2,  873,   -7,  102,
  240,  -84,  341,    0,    0,  -43,  -31,  -14,    4,  225,
    0,    0,    0,    0,    0,  -21, -253,    8,  102,    0,
    0,   39,  344,  358,    0,    0,    0,    0,  291,    0,
  -11,  291, -184, -218,   20,    0, -191,  561,   56,   10,
    0, -218,  704,  -18, -174,   77,  317,   47,  111,   -2,
   40,    0,   39,  -84,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    3,   55,   59, -253,
   64, -253,    0,    0,    0, -160,    0,    0, -218,    0,
   71,    0,    0,    0,  291,    0,  291,    0,    0,    0,
    0,    0,    0,  291,  291,  291,  291,  291, -162,  -32,
 -141,   96,  -11,    0,    0, -122,  387, -120, -130,  -84,
  -84,   17,  -84,  -84, -132,    0,  103,    0,  -84, -191,
  561,   56,   10,   10,    0,    0,  873,  873,  640,  873,
    0,  104,   84,   89,  -46,   91,  873,  199,    0,    0,
    0,  -84,    0,    0,    0,  117,   92,  -84,  659,  669,
  684,  688,  703,    0,  291,  291,  383,  291,  291,  707,
   58,  265,  722, -124,    0,    0,    0, -253,    0,    0,
    0,    0,  -25,    0,    0,   36,   95,  400,   97,  112,
  123,    0,  127,  667,  731,  735,  258,  129,  735,  134,
   93,  754,  -82,  -81,  -79,  336,  -77,  -71,  -68,  291,
  755,  291,    5,  313,  102,    0,  735,    0,  291,    0,
  -65,    0,    0,  758,  156,  157,  160,  162,   -6,  163,
  167,  170,    9,  873,  469,  125,  873,  901,   21,   27,
    0,   29,  180,    0,  384,  778,  778,  778,  778,  644,
  778,  778,  778,  778,  401,  779,  802,  803,  873,  826,
  415,  -27,  416,  -52,  417,    0,   67,    0,  394,    0,
    7,    0,    0,   14,   54,  126,  128,  130,  151,  153,
  155,  176,  -56,  447,  452,  830,  462,  843,  476,  242,
  245,  -39,  250,  252,  255,    0,    0,    0,    0,    0,
    0,    0,    0,  178,    0,    0,    0,    0,    0,    0,
  291,  291,  380,  102,  291,  494,  291,    0,    0,    0,
 -220,    0,    0,    0,    0,   30,   35,  912,   37,   46,
   49,  291,   51,    0,    0,  483,  487,  491,  -19,  492,
  -47,  493,   52,  495,  273,  260,  281,  284,  286,   76,
  289,  293,  294,  297,  300,  526,    0,    0,    0,    0,
    0,  320,    0,    0,    0,    0,    0,  291,    0,   61,
  873,  855,  538,  291,   65,  520,  308,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  440,    0,    0,    0,    0,    0,    0,  399,    0,
    0,    0,    0,  405,    0,    0,  611,  410,  570,  498,
    0,  406,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  590,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  407,    0,
  413,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  427,
    0,    0,    0,    0,    0,    0,    0,    0,  432,  631,
  448,  594,  522,  546,    0,    0,    0,    0,    0,    0,
    0,  413,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  436,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  856,    0,    0,    0,    0,    0,    0,
    0,    0,  439,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  445,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  534,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  454,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   66,  524,    0,   44,  -16,    0,   86,    0,    0,    0,
    0,    0,    0,  -10,  342,  587,    0,    0,  -15,  920,
    0, -165,    0,    0,    0,   23,    0,    0,  -48,    0,
    0,    0,    0,    0,    0,    0,  497,  500,  485,    0,
  -12,   12,
};
final static int YYTABLESIZE=1207;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         62,
   64,   67,   51,   53,   70,   63,  304,   52,  149,   53,
   52,  362,  178,  302,   39,   78,   37,   38,   87,  331,
   46,  360,  121,   70,    3,   53,   53,   80,   53,  100,
    5,  301,   69,   99,  261,  344,   55,   42,  129,  359,
   53,   65,   71,  131,   82,  247,   39,  120,  105,  265,
   41,  117,    2,   39,  345,   53,  118,  162,   88,   89,
  106,  273,   84,  102,   41,    7,   21,  274,   90,  275,
  346,  103,  104,  101,  107,  347,   53,  350,   92,  135,
  130,   53,  161,  163,  164,  165,  351,   74,   55,  352,
  122,  354,  364,   39,  213,  133,  138,   39,  115,  134,
  116,  381,  143,  144,  136,  386,  147,  126,   76,  132,
   96,  139,   53,  187,  137,  309,  123,   41,  309,  309,
  309,   52,  309,  309,  309,  309,  309,  150,  145,  146,
  169,  170,  172,  173,  372,  153,  151,  156,  157,  166,
  180,  183,  175,  168,  174,  152,   52,  176,  309,  179,
  189,  232,   76,  214,  193,  217,  188,  209,    1,  196,
  197,  199,  200,  201,  205,   39,  220,   39,  229,   39,
  218,  128,   73,    2,  231,  235,  236,  210,  237,    3,
  240,  219,  216,  269,    4,    5,  241,    2,  223,  242,
   39,  253,   39,    3,   39,  234,  256,  257,    4,    5,
  258,   41,  259,  262,  243,  245,  246,  263,  249,  250,
  264,  177,   77,  252,   53,   39,  157,   39,  320,   47,
   48,  157,   47,   48,   79,   49,   50,  266,  268,   50,
  270,   66,  272,   36,  105,  330,  148,   15,   39,  105,
    3,   81,   16,  184,  211,   17,    5,  105,  105,   68,
  296,  260,  298,   19,   76,   76,    3,   76,   76,   83,
  212,   20,    5,   66,  105,   76,    3,  207,   76,   15,
   66,  105,    5,   73,   16,  105,   15,   17,   76,   39,
    3,   16,  279,   86,   17,   19,    5,  105,    2,  279,
   76,  308,   19,  105,    3,  105,  105,   39,  310,    4,
    5,  105,  105,  105,   39,  336,  337,  339,  340,  341,
   66,  343,  105,   53,   66,  105,   15,  105,  105,   76,
   15,   16,  349,   94,   17,   16,  353,  105,   17,  279,
  203,  105,   19,   47,   48,   52,   19,  204,  311,   49,
   50,  280,  280,  280,  280,  280,  280,  280,  280,  280,
  371,   76,  248,   76,    3,   76,   39,   52,   47,   48,
    5,  105,  380,  105,  382,   50,  280,  127,  385,  280,
  280,  280,  280,  280,  280,  280,  280,  280,  105,    3,
   39,   76,   66,   76,   66,    5,   66,   96,   15,  105,
   15,  105,   15,   16,  239,   16,   17,   16,   17,  280,
   17,  279,   95,  279,   19,  279,   19,   66,   19,   66,
  312,   66,  313,   15,  315,   15,   98,   15,   16,  338,
   16,   17,   16,   17,   52,   17,  279,   52,  279,   19,
  279,   19,   66,   19,   66,  316,  276,  317,   15,  318,
   15,  198,  278,   16,   52,   16,   17,  155,   17,  123,
  123,  279,  307,  279,   19,   14,   19,   56,  215,  293,
  319,   15,  335,   55,   54,   52,   16,   76,  123,   17,
    2,   75,  181,  300,  303,  305,    3,   19,   14,  182,
   85,    4,    5,   77,   15,   72,  321,  124,  124,   16,
   70,  322,   17,    2,   87,   18,   14,   66,   77,    3,
   19,  325,   15,   68,    4,    5,  124,   16,   39,  267,
   17,    2,   45,   18,   66,  327,  328,    3,   19,  329,
   15,   66,    4,    5,  332,   16,  333,   15,   17,  334,
   40,   18,   16,  342,  367,   17,   19,  127,  127,  227,
  127,  356,  127,   19,   72,  357,  206,   47,   48,  358,
  361,  363,  366,  365,   50,  368,  127,  127,  369,  127,
  370,  128,  128,  373,  128,  378,  128,  374,  375,   47,
   48,  376,  124,   66,  377,  379,   50,  384,  387,   15,
  128,  128,  388,  128,   16,  129,  129,   17,  129,    4,
  129,  125,   92,  238,  277,   19,   44,   66,  142,   93,
   94,  140,  105,   15,  129,  129,  141,  129,   16,  125,
  125,   17,    0,   97,    0,   75,    0,    0,    0,   19,
  112,    0,  113,    0,    0,    0,    0,    0,  125,  125,
    0,  125,    0,  126,  126,    0,   47,   48,    0,   47,
   48,    0,    0,   50,  154,    0,   50,    0,    0,  306,
  121,  121,  126,  126,   56,  126,   47,   48,    0,    0,
   55,   54,   52,   50,    0,  123,  123,  123,   75,  121,
  122,  122,  123,    0,    0,  123,  123,  123,  123,   39,
  123,    0,   72,   39,  287,    0,    0,   70,  123,  122,
    0,   87,    0,    0,   66,   77,   77,    0,   39,    0,
   68,    0,    0,  124,  124,  124,  221,    0,   39,   45,
  124,   52,    0,  124,  124,  124,  124,    0,  124,    0,
    0,    0,    0,   39,  222,   66,  124,   39,    0,  226,
  228,   15,  230,    0,    0,  105,   16,    0,    0,   17,
    0,    0,   39,    0,  119,    0,   39,   19,   52,    0,
  251,    0,    0,  127,  127,  127,  127,  127,  127,  127,
  127,   39,    0,  127,  127,  127,  127,    0,  127,    0,
  225,    0,    0,    0,   39,    0,  127,  128,  128,  128,
  128,  128,  128,  128,  128,    0,    0,  128,  128,  128,
  128,    0,  128,   39,    0,  244,    0,   39,    0,   52,
  128,  129,  129,  129,  129,  129,  129,  129,  129,    0,
    0,  129,  129,  129,  129,    0,  129,   39,   39,  108,
  109,  110,  111,    0,  129,  125,  125,  125,  125,  125,
  125,  125,  125,    0,    0,  125,  125,  125,  125,    0,
  125,   39,   39,    0,    0,    0,    0,    0,  125,  126,
  126,  126,  126,  126,  126,  126,  126,    0,    0,  126,
  126,  126,  126,    0,  126,   39,  121,  121,  121,  324,
    0,    0,  126,  121,    0,    0,    0,  121,  121,  121,
    0,  121,   39,    0,    0,    0,  122,  122,  122,  121,
    0,    0,    0,  122,   39,    9,   66,  122,  122,  122,
   66,  122,   15,    0,    0,    0,   15,   16,  171,  122,
   17,   16,   39,    0,   17,   66,    0,    0,   19,  279,
    0,   15,   19,   47,   48,   66,   16,    0,  190,   17,
   50,   15,    0,    0,    0,    0,   16,   19,  191,   17,
   66,  271,    0,    0,   66,   52,   15,   19,    0,    0,
   15,   16,  348,  192,   17,   16,   52,  194,   17,   66,
   47,   48,   19,   66,    0,   15,   19,   50,    0,   15,
   16,    0,  195,   17,   16,    0,  202,   17,   66,    0,
    0,   19,    0,    0,   15,   19,    0,   66,    0,   16,
    0,   66,   17,   15,  208,    0,    0,   15,   16,    0,
   19,   17,   16,  224,    0,   17,    0,    0,   18,   19,
   66,   47,   48,   19,   66,    0,   15,    0,   50,    0,
   15,   16,    0,  233,   17,   16,    0,  255,   17,    0,
    0,    0,   19,    0,   66,   66,   19,    0,    0,    0,
   15,   15,    0,    0,    0,   16,   16,    0,   17,   17,
    0,  294,    0,  279,    0,    0,   19,   19,   66,   66,
    0,    0,    0,    0,   15,   15,    0,    0,    0,   16,
   16,    0,   17,   17,  295,  297,    0,    0,    0,    0,
   19,   19,   66,    0,    0,    0,   66,    0,   15,    0,
    0,    0,   15,   16,    0,    0,   17,   16,  299,   66,
   17,    0,  323,    0,   19,   15,    0,    0,   19,    0,
   16,   66,    9,   17,    0,  326,    0,   15,    9,    0,
    0,   19,   16,    9,    0,   17,    9,  383,    9,   66,
    0,    0,    0,   19,    9,   15,    0,    0,    0,    0,
   16,    0,    0,   17,    0,    0,    0,    0,    0,    0,
    0,   19,    0,    0,    0,    0,    0,   47,   48,    0,
    0,    0,    0,    0,   50,    0,    0,    0,   47,   48,
    0,    0,    0,    0,    0,   50,  284,  285,  286,  288,
  289,  290,  291,  292,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  314,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         15,
   16,   18,   40,   14,   20,   40,   59,   45,   41,   20,
   45,   59,   59,   41,   40,   59,   40,  257,   40,   59,
   59,   41,   41,   39,  278,   36,   37,   59,   39,   41,
  284,   59,   40,   49,   41,  256,   14,  257,   41,   59,
   51,   40,   20,   41,   59,   41,   40,   63,  267,   41,
    7,   42,  272,   40,  275,   66,   47,   41,   36,   37,
   41,   41,   59,   52,   21,    0,    1,   41,   61,   41,
   41,  256,  257,   51,  266,   41,   87,   41,   40,   90,
   41,   92,  131,  132,  133,  134,   41,   22,   66,   41,
  265,   41,   41,   40,   59,   41,  257,   40,   43,   41,
   45,   41,  115,  116,   41,   41,  269,   61,   23,   87,
   44,   41,  123,  162,   92,  281,   40,   74,  284,  285,
  286,   45,  288,  289,  290,  291,  292,  269,  117,  118,
  147,  148,  149,  150,   59,  258,   41,  258,  269,  272,
  157,  158,   59,   41,   41,  123,   45,   59,  314,   59,
   59,   59,   67,   59,  171,   59,   40,  282,  257,  175,
  176,  177,  178,  179,  181,   40,   40,   40,   40,   40,
   59,   61,  257,  272,   41,  258,  258,  188,  258,  278,
  258,   59,  198,   59,  283,  284,  258,  272,  204,  258,
   40,  257,   40,  278,   40,  212,   41,   41,  283,  284,
   41,  158,   41,   41,  220,  221,  222,   41,  224,  225,
   41,  258,  256,  229,  225,   40,  269,   40,  275,  257,
  258,  269,  257,  258,  256,  263,  264,  244,  245,  264,
  247,  257,  248,  257,  267,  275,  269,  263,   40,  267,
  278,  256,  268,  158,  270,  271,  284,  267,  267,  257,
  267,  258,  269,  279,  169,  170,  278,  172,  173,  256,
  286,   40,  284,  257,  267,  180,  278,  182,  183,  263,
  257,  267,  284,  257,  268,  267,  263,  271,  193,   40,
  278,  268,  276,   59,  271,  279,  284,  267,  272,  276,
  205,  285,  279,  267,  278,  267,  267,   40,  285,  283,
  284,  267,  267,  267,   40,  321,  322,  323,  324,  325,
  257,  327,  267,  324,  257,  267,  263,  267,  267,  234,
  263,  268,  338,  257,  271,  268,  342,  267,  271,  276,
  273,  267,  279,  257,  258,   45,  279,  280,  285,  263,
  264,  256,  257,  258,  259,  260,  261,  262,  263,  264,
  275,  266,   40,  268,  278,  270,   40,   45,  257,  258,
  284,  267,  378,  267,  381,  264,  281,  257,  384,  284,
  285,  286,  287,  288,  289,  290,  291,  292,  267,  278,
   40,  296,  257,  298,  257,  284,  257,   44,  263,  267,
  263,  267,  263,  268,   59,  268,  271,  268,  271,  314,
  271,  276,   59,  276,  279,  276,  279,  257,  279,  257,
  285,  257,  285,  263,  285,  263,   59,  263,  268,   40,
  268,  271,  268,  271,   45,  271,  276,   45,  276,  279,
  276,  279,  257,  279,  257,  285,  257,  285,  263,  285,
  263,   59,   59,  268,   45,  268,  271,   61,  271,   40,
   41,  276,   59,  276,  279,  257,  279,   59,   59,   59,
  285,  263,  285,   59,   59,   59,  268,  382,   59,  271,
  272,   59,  274,   59,   59,   59,  278,  279,  257,  281,
  256,  283,  284,   44,  263,   59,   40,   40,   41,  268,
   59,   40,  271,  272,   59,  274,  257,   59,   59,  278,
  279,   40,  263,   59,  283,  284,   59,  268,   40,   41,
  271,  272,   59,  274,  257,   40,  275,  278,  279,  275,
  263,  257,  283,  284,  275,  268,  275,  263,  271,  275,
    7,  274,  268,   40,  275,  271,  279,   40,   41,  282,
   43,   59,   45,  279,   21,   59,  282,  257,  258,   59,
   59,   59,  280,   59,  264,  275,   59,   60,  275,   62,
  275,   40,   41,  275,   43,   40,   45,  275,  275,  257,
  258,  275,  256,  257,  275,  256,  264,   40,   59,  263,
   59,   60,  275,   62,  268,   40,   41,  271,   43,    0,
   45,  275,   59,  258,  253,  279,   10,  257,  114,  256,
  257,  105,  267,  263,   59,   60,  107,   62,  268,   40,
   41,  271,   -1,  256,   -1,  275,   -1,   -1,   -1,  279,
   60,   -1,   62,   -1,   -1,   -1,   -1,   -1,   59,   60,
   -1,   62,   -1,   40,   41,   -1,  257,  258,   -1,  257,
  258,   -1,   -1,  264,  258,   -1,  264,   -1,   -1,  256,
   40,   41,   59,   60,  256,   62,  257,  258,   -1,   -1,
  256,  256,  256,  264,   -1,  256,  257,  258,  256,   59,
   40,   41,  263,   -1,   -1,  266,  267,  268,  269,   40,
  271,   -1,  256,   40,   41,   -1,   -1,  256,  279,   59,
   -1,  256,   -1,   -1,  256,  256,  257,   -1,   40,   -1,
  256,   -1,   -1,  256,  257,  258,   40,   -1,   40,  256,
  263,   45,   -1,  266,  267,  268,  269,   -1,  271,   -1,
   -1,   -1,   -1,   40,   58,  257,  279,   40,   -1,  206,
  207,  263,  209,   -1,   -1,  267,  268,   -1,   -1,  271,
   -1,   -1,   40,   -1,   41,   -1,   40,  279,   45,   -1,
  227,   -1,   -1,  256,  257,  258,  259,  260,  261,  262,
  263,   40,   -1,  266,  267,  268,  269,   -1,  271,   -1,
   40,   -1,   -1,   -1,   40,   -1,  279,  256,  257,  258,
  259,  260,  261,  262,  263,   -1,   -1,  266,  267,  268,
  269,   -1,  271,   40,   -1,   41,   -1,   40,   -1,   45,
  279,  256,  257,  258,  259,  260,  261,  262,  263,   -1,
   -1,  266,  267,  268,  269,   -1,  271,   40,   40,  259,
  260,  261,  262,   -1,  279,  256,  257,  258,  259,  260,
  261,  262,  263,   -1,   -1,  266,  267,  268,  269,   -1,
  271,   40,   40,   -1,   -1,   -1,   -1,   -1,  279,  256,
  257,  258,  259,  260,  261,  262,  263,   -1,   -1,  266,
  267,  268,  269,   -1,  271,   40,  256,  257,  258,   40,
   -1,   -1,  279,  263,   -1,   -1,   -1,  267,  268,  269,
   -1,  271,   40,   -1,   -1,   -1,  256,  257,  258,  279,
   -1,   -1,   -1,  263,   40,   40,  257,  267,  268,  269,
  257,  271,  263,   -1,   -1,   -1,  263,  268,  269,  279,
  271,  268,   40,   -1,  271,  257,   -1,   -1,  279,  276,
   -1,  263,  279,  257,  258,  257,  268,   -1,  270,  271,
  264,  263,   -1,   -1,   -1,   -1,  268,  279,  270,  271,
  257,   41,   -1,   -1,  257,   45,  263,  279,   -1,   -1,
  263,  268,   41,  270,  271,  268,   45,  270,  271,  257,
  257,  258,  279,  257,   -1,  263,  279,  264,   -1,  263,
  268,   -1,  270,  271,  268,   -1,  270,  271,  257,   -1,
   -1,  279,   -1,   -1,  263,  279,   -1,  257,   -1,  268,
   -1,  257,  271,  263,  273,   -1,   -1,  263,  268,   -1,
  279,  271,  268,  273,   -1,  271,   -1,   -1,  274,  279,
  257,  257,  258,  279,  257,   -1,  263,   -1,  264,   -1,
  263,  268,   -1,  270,  271,  268,   -1,  270,  271,   -1,
   -1,   -1,  279,   -1,  257,  257,  279,   -1,   -1,   -1,
  263,  263,   -1,   -1,   -1,  268,  268,   -1,  271,  271,
   -1,  273,   -1,  276,   -1,   -1,  279,  279,  257,  257,
   -1,   -1,   -1,   -1,  263,  263,   -1,   -1,   -1,  268,
  268,   -1,  271,  271,  273,  273,   -1,   -1,   -1,   -1,
  279,  279,  257,   -1,   -1,   -1,  257,   -1,  263,   -1,
   -1,   -1,  263,  268,   -1,   -1,  271,  268,  273,  257,
  271,   -1,  273,   -1,  279,  263,   -1,   -1,  279,   -1,
  268,  257,  257,  271,   -1,  273,   -1,  263,  263,   -1,
   -1,  279,  268,  268,   -1,  271,  271,  273,  273,  257,
   -1,   -1,   -1,  279,  279,  263,   -1,   -1,   -1,   -1,
  268,   -1,   -1,  271,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  279,   -1,   -1,   -1,   -1,   -1,  257,  258,   -1,
   -1,   -1,   -1,   -1,  264,   -1,   -1,   -1,  257,  258,
   -1,   -1,   -1,   -1,   -1,  264,  257,  258,  259,  260,
  261,  262,  263,  264,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  287,
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

//#line 266 "Gramatica.y"

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
//#line 34 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 12:
//#line 35 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN per falta un END para cerrar el bloque}");}
break;
case 19:
//#line 48 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 20:
//#line 49 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
//#line 50 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
//#line 51 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
//#line 52 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
//#line 56 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 26:
//#line 58 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + val_peek(4).sval +"}");}
break;
case 28:
//#line 63 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
//#line 64 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 30:
//#line 65 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 33:
//#line 74 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 35:
//#line 78 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 36:
//#line 79 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 37:
//#line 80 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 38:
//#line 81 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante UINT}");}
break;
case 39:
//#line 82 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 40:
//#line 83 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 41:
//#line 84 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 42:
//#line 85 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_UINT}");}
break;
case 43:
//#line 86 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 44:
//#line 87 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 45:
//#line 88 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta indicar el fin del ciclo con ENDREPEAT}");}
break;
case 51:
//#line 100 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 54:
//#line 108 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 55:
//#line 109 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 56:
//#line 110 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 60:
//#line 120 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 61:
//#line 121 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 62:
//#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 63:
//#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 64:
//#line 124 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 65:
//#line 125 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 66:
//#line 126 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 67:
//#line 127 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 68:
//#line 128 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 70:
//#line 136 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + val_peek(3).sval + "'}");}
break;
case 72:
//#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 73:
//#line 141 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 74:
//#line 142 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 75:
//#line 143 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 76:
//#line 147 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);}
break;
case 77:
//#line 148 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");}
break;
case 79:
//#line 153 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 80:
//#line 155 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(4).sval +"'" );}
break;
case 82:
//#line 160 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 83:
//#line 161 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 84:
//#line 162 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 85:
//#line 163 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 86:
//#line 164 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 87:
//#line 165 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 90:
//#line 173 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 96:
//#line 190 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 97:
//#line 191 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 98:
//#line 192 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 102:
//#line 200 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 103:
//#line 201 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 104:
//#line 202 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el RETURN");}
break;
case 105:
//#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta '(' ");}
break;
case 106:
//#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta indicar el retorno");}
break;
case 107:
//#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta ')' ");}
break;
case 108:
//#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta ';' ");}
break;
case 109:
//#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el END ");}
break;
case 110:
//#line 209 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 111:
//#line 210 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 112:
//#line 211 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 113:
//#line 212 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 114:
//#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 115:
//#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 116:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 117:
//#line 216 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 118:
//#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 119:
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 120:
//#line 220 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 122:
//#line 227 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval + "||" + val_peek(0).sval + "}");}
break;
case 124:
//#line 231 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval + "&&" + val_peek(0).sval+ "}");}
break;
case 126:
//#line 235 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +val_peek(1).sval+ val_peek(0).sval + "}");}
break;
case 128:
//#line 239 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"+"+ val_peek(0).sval+ "}");}
break;
case 129:
//#line 240 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"-"+ val_peek(0).sval+ "}");}
break;
case 130:
//#line 243 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"*"+ val_peek(0).sval+ "}");}
break;
case 131:
//#line 244 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + val_peek(2).sval +"/"+ val_peek(0).sval+ "}");}
break;
case 133:
//#line 249 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval);}
break;
case 134:
//#line 250 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante UINT: " + val_peek(0).sval);}
break;
case 135:
//#line 251 "Gramatica.y"
{chequearFactorNegado();}
break;
case 136:
//#line 252 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1260 "Parser.java"
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
