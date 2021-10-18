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
   35,   35,   35,   31,   31,   36,   17,   37,   34,   34,
   34,   39,   39,   39,   38,   38,   38,   40,   40,   40,
   40,   40,   40,   40,   40,   41,   40,   40,   40,   40,
   40,   40,   40,   40,   40,   40,   40,   19,   19,   42,
   42,   43,   43,   25,   25,   25,   27,   27,   27,   45,
   45,   45,   45,   44,   44,   44,   44,   44,   44,
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
    5,    5,    5,    2,    1,    2,    6,    2,    2,    5,
    1,    4,    4,    4,    8,   11,    1,    7,    7,    7,
    7,    7,    7,    7,    3,    0,   20,   11,   11,   11,
   11,   11,   11,   12,   11,   11,   11,    1,    3,    1,
    3,    1,    3,    1,    3,    3,    3,    3,    1,    2,
    1,    1,    1,    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   31,   32,    0,    0,    0,    2,    5,    0,
    0,   27,   87,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,    9,    0,    0,    0,    0,    0,
   18,   34,   53,   59,   77,    0,    0,    0,    0,    3,
    6,    0,    0,    0,   84,   30,  143,  142,    0,  141,
    0,    0,    0,    0,    0,   95,  139,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,   11,   10,   19,   13,   20,   14,
   21,   15,   23,   16,   22,   17,    0,    0,    0,    0,
    0,    0,   28,   85,   24,    0,   29,   25,    0,   80,
    0,  140,   96,   94,    0,    0,   79,    0,    0,    0,
    0,    0,    0,    0,  147,  148,  146,  149,  144,  145,
    0,    0,    0,   12,    7,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   78,    0,   82,    0,  137,
  138,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   75,    0,    0,    0,    0,    0,    0,    0,   88,  101,
   91,    0,   92,   90,   89,    0,    0,    0,    0,   60,
    0,   62,    0,    0,    0,    0,   76,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   99,  107,   86,
    0,   26,    0,   68,   69,   71,    0,   70,   67,    0,
    0,    0,    0,    0,    0,   66,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   57,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  115,    0,  103,    0,  104,    0,  102,    0,   65,   63,
    0,   73,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  100,
    0,    0,   64,   61,   58,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   97,    0,   35,   37,
   40,   41,    0,   43,   42,   39,   38,   36,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   83,    0,    0,   48,    0,   46,   50,   33,  109,
    0,    0,    0,    0,    0,    0,    0,  112,  113,  114,
    0,  111,  110,  108,   51,   49,   45,   47,    0,    0,
    0,    0,    0,    0,    0,    0,  116,  105,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  126,
  118,  121,  122,  123,    0,  120,  119,  127,  106,  125,
    0,  124,    0,    0,    0,    0,    0,    0,    0,    0,
  117,
};
final static short yydgoto[] = {                          6,
  158,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  167,   12,   70,  289,
   32,  316,  317,  318,   61,   33,   62,  171,   34,  172,
   91,   35,   45,  159,   13,   56,  287,  188,  160,  189,
  358,   63,   64,  121,   57,
};
final static short yysindex[] = {                       565,
    7,  -30,    0,    0, -244,    0,   20,    0,    0, -230,
  -18,    0,    0,  115,  365,  341,   22,  573,  -26,  373,
   20,  578,  421,    0,    0,  -48,  -38,   -2,   75,  128,
    0,    0,    0,    0,    0,  -21, -247,    2,  373,    0,
    0,   25,  131,  289,    0,    0,    0,    0,  365,    0,
  -19,  365, -206,   19,   -3,    0,    0,   19,  490,   13,
   28,   19, -207,  628, -197,  231,  228, -186, -224,   15,
   39,    0,   25,  578,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   64,   41,   43, -247,
   58, -247,    0,    0,    0, -163,    0,    0,   28,    0,
   60,    0,    0,    0,  365,  365,    0, -173,  -39,  365,
 -166,  365,  365,  365,    0,    0,    0,    0,    0,    0,
  365,   63,  -19,    0,    0, -152, -205, -150, -158,  578,
  578,   73,  578,  578, -159,    0,   74,    0,  578,    0,
    0,  440,  440,  179, -207,  440,   19,   19,  628,   28,
    0,   77,   57,   65,   16,   67,  440,  -28,    0,    0,
    0,  578,    0,    0,    0,   82,   71,  578,  573,    0,
 -147,    0, -145,  262, -138, -135,    0,  365,  365,  589,
  365,  365, -133,   81,   55,  442, -142,    0,    0,    0,
 -247,    0,  441,    0,    0,    0, -235,    0,    0,  -22,
   80,  627,   86,   88,  102,    0,  106,  581,  280,  460,
   53,  112,  460,  116,  298,  461,    0,  340, -105, -102,
 -100,  -52,  -90,  -86,  -85,  365,  600,  365,   26,  532,
    0,  373,    0,  460,    0,  365,    0,  118,    0,    0,
  353,    0,  -96,  141,  147,  148,  150,  -24,  152,  155,
  158,   33,  573,  192,  136,  573,  608,   37,   61,    0,
   66,  -55,    0,    0,    0,  -61,  -61,  -61,  -61,  -36,
  -61,  -61,  -61,  -61,  263,  470,  487,  488,  573,  500,
  332,  -25,  343,  -44,  352,  156,    0,  507,    0,    0,
    0,    0,  -61,    0,    0,    0,    0,    0,  139,  379,
  389,  524,  397,  531,  401,  169,  170,  -53,  171,  176,
  177,    0,  -40,  369,    0,  400,    0,    0,    0,    0,
  365,  365,  556,  373,  365,  414,  365,    0,    0,    0,
 -227,    0,    0,    0,    0,    0,    0,    0,   69,   76,
  617,   79,   92,   95,  365,  107,    0,    0,  413,  424,
  428,    5,  433,   50,  439,  108,  443,  226,  181,  236,
  245,  254,  -23,  264,  267,  269,  271,  274,  510,    0,
    0,    0,    0,    0,  296,    0,    0,    0,    0,    0,
  365,    0,  109,  573,  548,  518,  365,  110,  501,  286,
    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  636,    0,    0,    0,    0,    0,    0,  403,    0,
    0,    0,    0,  418,    0,    0,    0,  431,    0,    0,
  207,  138,  375,  299,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  563,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  438,    0,
  445,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  446,
    0,    0,    0,    0,    0,    0,    0,    0,  479,    0,
    0,    0,    0,    0,  398,    0,  164,  323,  349,  255,
    0,  445,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  516,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  555,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  528,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  545,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  568,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  514,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
final static short yygindex[] = {                         0,
   23,  472,    0,   11,  -17,    0,  -15,    0,    0,    0,
    0,    0,    0,  -11,  283,  564,    0,    0,  -16,  630,
    0,    0,  260,    0,  -29,    0,   72,  -74,    0,    0,
  859,    0,    0,  -43,    0,    0,    0,    0,    0,    0,
    0,  483,  486,    0,   -8,
};
final static int YYTABLESIZE=982;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         60,
   67,  144,   53,   96,  293,  331,  248,   76,   53,   37,
   78,   39,   38,   69,  310,  308,  271,   41,   87,   99,
   80,  100,    7,   21,   53,   53,   42,   53,  347,    3,
    4,   41,  127,  307,  217,  375,  219,  107,  128,   53,
   46,    2,  109,  102,   74,  363,   20,  348,  218,  103,
  104,   76,  154,  111,   53,  129,   82,  155,  114,   39,
  105,   65,   90,  362,   92,  106,  256,  122,  173,  175,
  112,  176,  113,  275,  181,   53,  126,  283,  135,  130,
   53,  133,  183,  134,   41,   54,   58,  161,  163,  164,
  165,  150,   39,  138,   39,  142,  140,  141,  136,  197,
  139,  284,  146,  151,  131,  153,  285,  156,  365,  349,
  157,   53,  166,  162,  168,  178,  350,  177,  190,  353,
   39,  191,  194,  179,  195,  182,  170,  170,  170,  192,
  170,  198,  354,   84,  199,  355,  206,   54,  220,  213,
  186,  170,  187,  243,  223,  226,  224,  357,  367,  384,
  389,  236,  244,  193,   51,  245,  238,  246,  170,   52,
  225,  200,  201,  203,  204,  205,  209,  249,   41,  211,
   76,  250,  251,  265,   96,  216,  262,  134,  134,  214,
  134,  266,  134,  147,  148,  222,   86,  267,  268,   95,
  269,  229,  272,   76,  279,  273,  134,  134,  274,  134,
   76,  286,  170,  135,  135,  247,  135,   77,  135,  252,
  254,  255,  288,  258,  110,  259,   94,   79,   39,  261,
   53,  330,  135,  135,  157,  135,   36,  110,   14,  143,
   68,   39,  277,  270,   15,  276,  278,  288,  280,   16,
  282,  110,   17,    2,  110,  184,  132,  132,    3,    4,
   19,  374,  185,   81,    5,    3,    4,    3,    4,  302,
   76,  304,   76,   14,   76,  132,  132,   39,  132,   15,
  123,  110,  315,  180,   16,   52,   14,   17,    2,  110,
   18,  110,   15,    3,    4,   19,   76,   16,   76,    5,
   17,    2,  110,   18,  133,  133,    3,    4,   19,  110,
  315,   39,    5,  110,  339,  340,  342,  343,  344,   66,
  346,   66,   53,  133,  133,   15,  133,   15,  157,  232,
   16,  299,   16,   17,  352,   17,   18,  110,  356,   73,
   83,   19,  110,   19,  234,  110,  210,   66,  130,  130,
    3,    4,  110,   15,    2,  110,  110,   98,   16,    3,
    4,   17,  110,  207,  110,    5,  240,  130,  110,   19,
  208,  110,  136,  136,  383,  136,  385,  136,  110,   76,
  388,   47,   48,  110,  110,  110,  110,   49,   50,   39,
   59,  136,  136,   85,  136,   52,   93,   94,  131,  131,
  306,    3,    4,  134,  134,  134,  134,  134,  134,  134,
  134,  309,  110,  134,  134,  134,  134,  131,  134,   52,
  311,  264,  312,  320,  128,  128,  134,   52,  321,  135,
  135,  135,  135,  135,  135,  135,  135,  336,  322,  135,
  135,  135,  135,  128,  135,   66,  325,  129,  129,   39,
  327,   15,  135,  328,  329,  332,   16,  174,   66,   17,
  333,  334,  169,  345,   15,  370,  129,   19,  110,   16,
   39,   56,   17,  132,  132,  132,  132,  132,  132,  132,
   19,  359,  132,  132,  132,  132,   55,  132,   40,   39,
   39,   39,  360,  124,   66,  132,  361,   47,   48,   54,
   15,  364,   72,   49,   50,   16,   52,  366,   17,   39,
   39,  368,  125,   81,   78,  369,   19,    3,    4,   39,
  371,  133,  133,  133,  133,  133,  133,  133,   66,  372,
  133,  133,  133,  133,   15,  133,   39,   39,  373,   16,
  108,  196,   17,  133,   52,  169,   66,   76,  376,   39,
   19,  377,   15,  378,   97,  379,   39,   16,  380,  381,
   17,  382,  230,  239,  231,  130,  130,  387,   19,  390,
  391,  130,    4,  324,  130,  130,  130,  130,  313,  130,
   39,  257,   98,   44,   93,  338,   52,  130,  136,  136,
  136,  136,  136,  136,  136,  136,   72,   39,  136,  136,
  136,  136,  145,  136,    9,  341,   66,   47,   48,  149,
   52,  136,   15,   74,   50,  131,  131,   16,  263,  242,
   17,  131,   39,  169,  131,  131,  131,  131,   19,  131,
  227,   47,   48,    0,  335,   52,   44,  131,   50,   47,
   48,  128,  128,   52,    0,    0,   50,  128,  228,    0,
  253,  128,  128,  128,   52,  128,    0,  202,  281,    3,
    4,    0,   52,  128,  129,  129,   66,  351,   56,    0,
  129,   52,   15,    0,  129,  129,  129,   16,  129,    0,
   17,   52,    0,   55,  337,  314,  129,   66,   19,   83,
    0,  233,  235,   15,  237,  221,   54,  119,   16,  120,
    0,   17,    0,   52,   83,   75,   66,   66,   66,   19,
   81,   78,   15,   15,   15,  260,    0,   16,   16,   16,
   17,   17,   17,  169,  212,  215,   66,   66,   19,   19,
   19,    0,   15,   15,    0,    0,   66,   16,   16,    0,
   17,   17,   15,   18,   76,  241,    0,   16,   19,   19,
   17,    0,  300,   66,   66,    0,   47,   48,   19,   15,
   15,    0,    0,   50,   16,   16,   66,   17,   17,  301,
  303,    0,   15,   66,    0,   19,   19,   16,    0,   15,
   17,   93,  305,    0,   16,    0,    0,   17,   19,    0,
   66,    0,  314,   72,    0,   19,   15,   66,   47,   48,
    0,   16,    0,   15,   17,   50,  323,    0,   16,    0,
   74,   17,   19,  326,   66,    0,    0,    0,    0,   19,
   15,    9,   47,   48,    0,   16,    0,    9,   17,   50,
  386,    1,    9,   44,    0,    9,   19,    9,    0,   66,
    0,    0,    0,    9,   73,   15,    2,   47,   48,    0,
   16,    3,    4,   17,   50,   47,   48,    5,    0,    2,
    0,   19,   50,    0,    3,    4,   47,   48,    0,    0,
    5,    0,    0,   50,   47,   48,    0,    0,    0,    0,
    0,   50,   55,   47,   48,    0,    0,    0,   71,    0,
   50,    0,    0,   47,   48,    0,  115,  116,  117,  118,
   50,   83,   83,    0,   88,   89,  290,  291,  292,  294,
  295,  296,  297,  298,    0,    0,    0,    0,    0,  101,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  319,    0,   55,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  132,    0,    0,    0,    0,
  137,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  152,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         16,
   18,   41,   14,   44,   41,   59,   59,   23,   20,   40,
   59,   40,  257,   40,   59,   41,   41,    7,   40,   49,
   59,   41,    0,    1,   36,   37,  257,   39,  256,  277,
  278,   21,  257,   59,  270,   59,   59,   41,  263,   51,
   59,  272,   59,   52,   22,   41,   40,  275,  284,  256,
  257,   67,  258,   41,   66,   41,   59,  263,  266,   40,
   42,   40,   61,   59,   40,   47,   41,  265,  143,  144,
   43,  146,   45,   41,   59,   87,  263,   41,   90,   41,
   92,   41,  157,   41,   74,   14,   15,  131,  132,  133,
  134,  121,   40,  257,   40,  269,  105,  106,   41,  174,
   41,   41,  269,   41,   41,  258,   41,  258,   59,   41,
  269,  123,  272,   41,   41,   59,   41,   41,  162,   41,
   40,   40,  270,   59,  270,   59,  142,  143,  144,   59,
  146,  270,   41,   59,  270,   41,  270,   66,   59,  282,
  158,  157,  158,  218,   59,   40,   59,   41,   41,   41,
   41,   40,  258,  169,   40,  258,   41,  258,  174,   45,
   59,  178,  179,  180,  181,  182,  184,  258,  158,  185,
  186,  258,  258,  270,   44,  193,   59,   40,   41,  191,
   43,   41,   45,  112,  113,  202,   59,   41,   41,   59,
   41,  208,   41,  209,   59,   41,   59,   60,   41,   62,
  216,  257,  218,   40,   41,  258,   43,  256,   45,  226,
  227,  228,  274,  230,  267,  232,  257,  256,   40,  236,
  232,  275,   59,   60,  269,   62,  257,  267,  257,  269,
  257,   40,   41,  258,  263,  253,  254,  274,  256,  268,
  257,  267,  271,  272,  267,  274,   40,   41,  277,  278,
  279,  275,  281,  256,  283,  277,  278,  277,  278,  277,
  276,  279,  278,  257,  280,   59,   60,   40,   62,  263,
   40,  267,  288,  258,  268,   45,  257,  271,  272,  267,
  274,  267,  263,  277,  278,  279,  302,  268,  304,  283,
  271,  272,  267,  274,   40,   41,  277,  278,  279,  267,
  316,   40,  283,  267,  321,  322,  323,  324,  325,  257,
  327,  257,  324,   59,   60,  263,   62,  263,  269,   40,
  268,   59,  268,  271,  341,  271,  274,  267,  345,  257,
  256,  279,  267,  279,  282,  267,  282,  257,   40,   41,
  277,  278,  267,  263,  272,  267,  267,   59,  268,  277,
  278,  271,  267,  273,  267,  283,   59,   59,  267,  279,
  280,  267,   40,   41,  381,   43,  384,   45,  267,  385,
  387,  257,  258,  267,  267,  267,  267,  263,  264,   40,
   40,   59,   60,  256,   62,   45,  256,  257,   40,   41,
   59,  277,  278,  256,  257,  258,  259,  260,  261,  262,
  263,   59,  267,  266,  267,  268,  269,   59,  271,   45,
   59,   59,  257,  275,   40,   41,  279,   45,   40,  256,
  257,  258,  259,  260,  261,  262,  263,   59,   40,  266,
  267,  268,  269,   59,  271,  257,   40,   40,   41,   40,
   40,  263,  279,  275,  275,  275,  268,  269,  257,  271,
  275,  275,  274,   40,  263,  275,   59,  279,  267,  268,
   40,   59,  271,  257,  258,  259,  260,  261,  262,  263,
  279,   59,  266,  267,  268,  269,   59,  271,    7,   40,
   40,   40,   59,  256,  257,  279,   59,  257,  258,   59,
  263,   59,   21,  263,  264,  268,   59,   59,  271,   40,
   40,   59,  275,   59,   59,  280,  279,  277,  278,   40,
  275,  257,  258,  259,  260,  261,  262,  263,  257,  275,
  266,  267,  268,  269,  263,  271,   40,   40,  275,  268,
   41,  270,  271,  279,   45,  274,  257,   59,  275,   40,
  279,  275,  263,  275,  256,  275,   40,  268,  275,   40,
  271,  256,  273,  256,  275,  257,  258,   40,  279,   59,
  275,  263,    0,   40,  266,  267,  268,  269,  286,  271,
   40,   40,   59,   10,   59,  316,   45,  279,  256,  257,
  258,  259,  260,  261,  262,  263,   59,   40,  266,  267,
  268,  269,  110,  271,   40,   40,  257,  257,  258,  114,
   45,  279,  263,   59,  264,  257,  258,  268,  256,  270,
  271,  263,   40,  274,  266,  267,  268,  269,  279,  271,
   40,  257,  258,   -1,  256,   45,   59,  279,  264,  257,
  258,  257,  258,   45,   -1,   -1,  264,  263,   58,   -1,
   41,  267,  268,  269,   45,  271,   -1,   59,   41,  277,
  278,   -1,   45,  279,  257,  258,  257,   41,  256,   -1,
  263,   45,  263,   -1,  267,  268,  269,  268,  271,   -1,
  271,   45,   -1,  256,  275,  276,  279,  257,  279,   44,
   -1,  210,  211,  263,  213,   59,  256,   60,  268,   62,
   -1,  271,   -1,  256,   59,  275,  257,  257,  257,  279,
  256,  256,  263,  263,  263,  234,   -1,  268,  268,  268,
  271,  271,  271,  274,  273,  275,  257,  257,  279,  279,
  279,   -1,  263,  263,   -1,   -1,  257,  268,  268,   -1,
  271,  271,  263,  274,  256,  275,   -1,  268,  279,  279,
  271,   -1,  273,  257,  257,   -1,  257,  258,  279,  263,
  263,   -1,   -1,  264,  268,  268,  257,  271,  271,  273,
  273,   -1,  263,  257,   -1,  279,  279,  268,   -1,  263,
  271,  256,  273,   -1,  268,   -1,   -1,  271,  279,   -1,
  257,   -1,  276,  256,   -1,  279,  263,  257,  257,  258,
   -1,  268,   -1,  263,  271,  264,  273,   -1,  268,   -1,
  256,  271,  279,  273,  257,   -1,   -1,   -1,   -1,  279,
  263,  257,  257,  258,   -1,  268,   -1,  263,  271,  264,
  273,  257,  268,  256,   -1,  271,  279,  273,   -1,  257,
   -1,   -1,   -1,  279,  257,  263,  272,  257,  258,   -1,
  268,  277,  278,  271,  264,  257,  258,  283,   -1,  272,
   -1,  279,  264,   -1,  277,  278,  257,  258,   -1,   -1,
  283,   -1,   -1,  264,  257,  258,   -1,   -1,   -1,   -1,
   -1,  264,   14,  257,  258,   -1,   -1,   -1,   20,   -1,
  264,   -1,   -1,  257,  258,   -1,  259,  260,  261,  262,
  264,  256,  257,   -1,   36,   37,  267,  268,  269,  270,
  271,  272,  273,  274,   -1,   -1,   -1,   -1,   -1,   51,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  293,   -1,   66,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   87,   -1,   -1,   -1,   -1,
   92,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  123,
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

//#line 281 "Gramatica.y"

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
//#line 719 "Parser.java"
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
case 102:
//#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 103:
//#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 104:
//#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 108:
//#line 214 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 109:
//#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 110:
//#line 216 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 111:
//#line 217 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 112:
//#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 113:
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 114:
//#line 220 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 115:
//#line 221 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 116:
//#line 222 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 117:
//#line 224 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 118:
//#line 225 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 119:
//#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 120:
//#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 121:
//#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 122:
//#line 229 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 123:
//#line 230 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 124:
//#line 231 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 125:
//#line 233 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 126:
//#line 234 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 127:
//#line 235 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 129:
//#line 242 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 131:
//#line 246 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 133:
//#line 250 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 135:
//#line 254 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 136:
//#line 255 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 137:
//#line 258 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 138:
//#line 259 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 140:
//#line 264 "Gramatica.y"
{chequearFactorNegado();}
break;
case 141:
//#line 265 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");}
break;
case 142:
//#line 266 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");}
break;
case 143:
//#line 267 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + val_peek(0).sval +"}");}
break;
//#line 1240 "Parser.java"
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
