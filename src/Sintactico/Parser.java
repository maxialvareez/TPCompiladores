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
    4,    4,   21,   21,   21,   17,   17,    9,    9,   25,
   25,   25,   25,   25,   25,   25,   25,   22,   22,   26,
   26,   26,   23,   24,   28,   28,   29,   29,   29,   30,
   13,   13,   32,   32,   32,   10,   10,   10,   34,   34,
   39,   35,   36,   36,   36,   40,   40,   40,   37,   37,
   37,   37,   37,   37,   37,   11,   11,   12,   12,   12,
   12,   41,   41,   41,   41,   15,   15,   43,   43,   43,
   43,   42,   44,   44,   18,   18,   18,   45,   19,   19,
   48,   46,   46,   50,   50,   50,   50,   50,   49,   49,
   51,   20,   20,   53,   53,   53,   53,   53,   53,   52,
   47,   47,   47,   55,   54,   54,   54,   54,   56,   56,
   56,   56,   56,   56,   56,   56,   56,   56,   56,   56,
   56,   56,   56,   56,   56,   56,   56,   56,   56,   56,
   38,   38,   57,   57,   27,   27,   31,   31,   31,   33,
   33,   33,   59,   59,   59,   59,   59,   58,   58,   58,
   58,   58,   58,
};
final static short yylen[] = {                            2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,    1,    8,
    8,    8,    8,    8,    8,    8,    9,    3,    1,    2,
    2,    3,    1,    3,    1,    2,    1,    2,    1,    2,
    3,    1,    2,    2,    3,    5,    7,    1,    3,    1,
    3,    1,    1,    5,    1,    4,    5,    4,    4,    4,
    4,    4,    5,    6,    7,    4,    3,    4,    4,    4,
    1,    3,    4,    4,    4,    4,    1,    3,    3,    4,
    4,    3,    1,    2,    3,    1,    1,    2,    2,    1,
    2,    5,    1,    4,    4,    4,    4,    5,    2,    1,
    2,    6,    1,    5,    5,    5,    5,    5,    6,    2,
    2,    1,    1,    2,    8,   14,   13,    1,    7,    7,
    7,    7,    7,    7,    7,    3,    8,   12,   12,   12,
   12,   12,   12,   12,   12,   12,   12,   12,   13,    8,
    1,    3,    1,    3,    1,    3,    1,    3,    3,    3,
    3,    1,    2,    1,    1,    1,    1,    1,    1,    1,
    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  110,  113,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   39,   62,    0,
   68,   70,   91,   97,    0,    0,    0,    0,    4,    7,
    0,    0,    0,  107,   35,  111,    0,    0,    0,    0,
  109,  132,  133,  138,    0,  175,    0,  174,    0,    0,
  177,    0,  172,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   49,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  120,    0,    1,    0,    0,   12,   11,
   20,   14,   21,   15,   22,   16,   24,   17,   23,   18,
   28,   26,    0,    0,    0,    0,    0,    0,   33,  108,
   29,    0,   34,   30,    0,    0,    0,    0,  134,  131,
    0,    0,   65,    0,    0,    0,    0,   92,  173,    0,
    0,    0,   73,    0,   72,   75,    0,    0,    0,   87,
   13,    8,   51,    0,   50,    0,    0,    0,    0,   98,
    0,   99,    0,  121,  119,  181,  182,  180,  183,  178,
  179,    0,    0,    0,   71,    0,   69,  114,    0,    0,
  117,    0,  116,  115,    0,  105,    0,    0,    0,    0,
    0,  146,    0,    0,    0,   95,   90,   93,   88,   94,
   89,  170,  171,    0,   80,   82,    0,   81,   86,   52,
   48,    0,    0,    0,    0,    0,  103,    0,  100,   96,
  101,    0,    0,    0,    0,    0,   79,  118,  112,    0,
    0,    0,  123,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   83,   66,    0,    0,    0,
    0,    0,    0,  102,  104,    0,    0,    0,   31,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   78,   76,    0,   84,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   77,   74,   85,   67,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  140,    0,    0,    0,
    0,    0,    0,    0,  143,  144,  145,    0,  142,  141,
    0,  139,    0,   41,   43,   44,    0,   46,   45,   42,
   40,    0,  126,  127,    0,  128,  125,  124,    0,    0,
    0,    0,  160,    0,    0,    0,    0,    0,  147,  135,
    0,    0,   57,    0,   55,   59,   47,   38,  106,    0,
  129,  122,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   60,   58,   54,   56,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  150,  151,  153,  156,  157,  158,    0,  155,
  154,  152,    0,    0,  149,  148,  159,  137,    0,  136,
};
final static short yydgoto[] = {                          6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   52,   11,  232,
   12,   83,  212,  334,   38,   84,   89,  364,  365,  366,
   90,   39,   91,   40,  144,  145,   41,   92,   42,  146,
   43,  160,   44,  218,   54,   13,   61,   14,   93,   15,
   94,  343,  233,   62,   63,   64,   95,  172,   73,
};
final static short yysindex[] = {                       563,
  119,  -35,    0,    0, -180,    0,  138,    0,    0, -194,
   49,    0,  -37,    0,    0,  514,  564,  -24,   71,  422,
  -30,    7,  278,  138,  567,  243,    0,    0,    0,  354,
  368,  387,  404,  409,    0,  410,    0,    0,    0, -151,
    0,    0,    0,    0,  -28, -247,   77,  564,    0,    0,
  115,  132,  427,    0,    0,    0,  157,  122,   94,  260,
    0,    0,    0,    0,  130,    0,  518,    0,  390,  564,
    0,  146,    0,  146,  269,   47,  -33,  522,  176, -225,
  -84,  424,  123,    0,  -88, -245,  -92, -215,  -47,   30,
  146,  102,  153,    0,  -65,    0,  115,  567,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  269,  -39,  161,  162, -247, -247,    0,    0,
    0,  -51,    0,    0,  164,  147,  177,  564,    0,    0,
  167,  466,    0,   30,  -32,   51,   92,    0,    0,  564,
  564,  422,    0,  -59,    0,    0,  196,  -52,  226,    0,
    0,    0,    0, -107,    0,  564,  559,  564,   40,    0,
 -231,    0,  -88,    0,    0,    0,    0,    0,    0,    0,
    0,  564,  564,  564,    0,  564,    0,    0,  564,  156,
    0,  107,    0,    0,  -21,    0,  564,  128,  383,   17,
  237,    0,  564,   25,  564,    0,    0,    0,    0,    0,
    0,    0,    0,  289,    0,    0, -203,    0,    0,    0,
    0,  370,  -47,  569,  384,  395,    0,  441,    0,    0,
    0,   30,  146,  146,  -65,  -47,    0,    0,    0,  -19,
 -247,  413,    0,   45,  414,   -7,  564,  434,  544,   55,
  127,  444,   58,  449,  290,    0,    0,  208,  184,  191,
  121,  202,  246,    0,    0,  -15,  471,  475,    0,  460,
  422,  422,  319,   60,  422,  461,   -2,  468,  485,  422,
  490,    0,    0,  462,    0, -109,  489,  493,  525,    8,
  532,  534,  521,   43,  540,  546,  302,  315,  340,  344,
  359,  570,  363,  306,  316,   10,  358,  362,  378,  381,
    0,    0,    0,    0,  400,  400,  400,  -27,  400,  400,
  400,  418,  418,  151,  418,  418,    0,  636,  646,  648,
  217,  651,  382,  655,    0,    0,    0, -185,    0,    0,
  659,    0,  401,    0,    0,    0, -171,    0,    0,    0,
    0,  450,    0,    0,  -57,    0,    0,    0,  564,  564,
  564,  539,    0,  564,  564,  666,  421,  564,    0,    0,
  564,  470,    0,  234,    0,    0,    0,    0,    0,  110,
    0,    0,   64,   65,   73,  561,   79,  168,   80,  564,
  668,   82,   85,    0,    0,    0,    0,  652,  663,  669,
  674,    5,  677,  679,  681,   89,  564,  686,  688,  435,
  477,  482,  491,  494,   86,  498,  506,  508,  691,  103,
  509,  512,    0,    0,    0,    0,    0,    0,  542,    0,
    0,    0,  513,  695,    0,    0,    0,    0,  529,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  765,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  440,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  672,    0,    0,    0,    0,    0,
    0,  479,    0,  486,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   24,  533,
  684,    0,    0,    0,   20,    0,    0,  805,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  492,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  149,    0,    0,    0,    0,    0,    0,    0,
    0,  611,  696,  708,   50,   87,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  537,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  748,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  537,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   75,  112,    0,   91,   -9,    0,  -20,  503,    0,    0,
    0,  -16,    0,    0,  787,    0,   -1,  469,  800,    0,
    0,  730, -140,  453,    0,    0,  673,    0,  451,    0,
  -43,    0,   11,  795,  -53,  566,    0,  -56,    0,    0,
    0,  -66,    0,    0,    0,    0,    0,    0,  -10,    0,
    0, -149,    0,  773,    0,    0,  658,    0,   12,
};
final static int YYTABLESIZE=975;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         71,
   71,  181,   48,   60,   46,  100,   71,  150,  197,   82,
   79,  114,  170,  337,  171,   48,  215,  216,  231,  162,
  256,   88,  148,  134,  219,  283,   72,   74,  159,    3,
    4,   71,  153,  263,  115,  116,  161,  154,  296,  100,
  164,  165,  159,   88,   88,  405,   48,  127,  309,   60,
   71,  262,  246,   71,  143,  143,  295,  238,  100,  180,
  161,   71,   51,  404,  163,  242,  247,   88,  328,  190,
  359,  194,  173,  251,  174,   24,   47,    2,  161,   48,
  248,  139,  163,  314,  367,  260,   48,   59,   72,  360,
  162,  199,  143,  207,  220,  268,  221,   50,  271,   98,
  292,  313,  333,  182,  388,  389,  100,   55,  162,   71,
   77,   71,   88,  390,   50,  185,   88,  113,   49,  393,
  395,  204,  398,   71,   71,  399,  143,  164,  222,  409,
  234,  236,  201,   48,  240,   96,  241,  117,  243,   71,
   71,   71,  177,  424,  419,  164,  303,  229,  210,   50,
  211,  202,  203,  122,  118,   71,   71,   71,   23,   71,
  304,  128,   71,  344,  346,  347,  348,  269,  235,  132,
   71,   71,   70,  155,   71,  122,   71,   48,   71,  280,
  264,  158,  267,  223,  224,  159,  188,  140,   50,  163,
  121,   70,  141,  178,  245,  372,   48,   71,  371,  342,
  179,  183,  184,  187,  189,  186,  195,   53,  394,  345,
  205,  166,  167,  168,  169,   48,  193,  208,   56,   16,
   71,   45,   71,  196,  100,   17,   80,  143,  257,  258,
   18,  149,   81,   19,    2,   48,   57,    3,    4,    3,
    4,   21,   58,   22,   75,    5,  333,   48,    3,    4,
  230,  288,  289,  291,  284,  293,  354,    3,    4,  176,
  299,    3,    4,   78,  176,  308,  209,  100,  100,   17,
  100,  176,  100,   48,   18,  161,  239,   19,  100,  163,
  321,   70,   48,  176,  327,   21,  161,   22,   85,  163,
  163,  176,  373,  374,  375,  377,   78,  378,  379,   48,
  100,  382,   17,   78,  383,  162,  198,   18,   48,   17,
   19,  176,  363,  357,   18,  147,  162,   19,   21,  392,
  142,  176,   70,  396,  176,   21,  176,   22,   48,   48,
  176,  176,   71,   71,   71,   71,  100,   71,   71,  176,
  410,   71,  164,  363,   71,  176,  176,  200,  176,  129,
   16,  176,  164,  164,   48,  176,   17,  175,   48,   71,
  418,   18,  228,   71,   19,    2,  120,   57,  176,  176,
    3,    4,   21,   58,   22,   16,    5,  290,  279,   48,
   71,   17,  175,   48,   65,   66,   18,  119,  120,   19,
    2,   68,   20,  176,   16,    3,    4,   21,   48,   22,
   17,    5,   48,   65,   66,   18,   53,  342,   19,    2,
   68,   20,  102,   78,    3,    4,   21,   48,   22,   17,
    5,   48,  237,  175,   18,  227,  104,   19,  249,  125,
  138,  151,   78,   78,  176,   21,  126,   22,   17,   17,
   48,  277,  252,   18,   18,  106,   19,   19,  278,  191,
  152,  192,   78,  253,   21,   21,   22,   22,   17,  281,
   48,   48,  108,   18,   78,  206,   19,  110,  112,  142,
   17,  259,  261,   78,   21,   18,   22,  275,   19,   17,
   48,  142,  156,  106,   18,  124,   21,   19,   22,  352,
   78,  353,  265,   65,   66,   21,   17,   22,  106,   78,
   68,   18,  270,  282,   19,   17,  138,  273,  386,  362,
   18,  285,   21,   19,   22,  286,   78,   99,  287,  294,
  302,   21,   17,   22,   86,   78,  297,   18,  385,  305,
   19,   17,  131,  306,   65,   66,   18,   64,   21,   19,
   22,   68,  142,  298,   63,   78,   78,   21,  300,   22,
   61,   17,   17,   69,    3,    4,   18,   18,   70,   19,
   19,  132,   70,  244,  274,  307,   70,   21,   21,   22,
   22,   78,  310,  165,  311,   78,  317,   17,  376,  312,
  325,   17,   18,   70,  266,   19,   18,  318,   70,   19,
  326,  165,  165,   21,  165,   22,   78,   21,  315,   22,
   78,  391,   17,   70,  316,   70,   17,   18,   70,  101,
   19,   18,  319,   70,   19,   78,  320,  214,   21,   78,
   22,   17,   21,  103,   22,   17,   18,  250,  323,   19,
   18,  322,  329,   19,   78,  324,  330,   21,   78,   22,
   17,   21,  105,   22,   17,   18,  135,  136,   19,   18,
  331,  166,   19,  137,  356,  332,   21,   78,   22,  107,
   21,  217,   22,   17,  109,  111,    3,    4,   18,  166,
  166,   19,  166,  333,  342,  349,  362,   78,   78,   21,
   80,   22,  123,   17,   17,  350,   81,  351,   18,   18,
  355,   19,   19,  381,  358,  106,  106,   78,  361,   21,
   21,   22,   22,   17,  272,  380,  369,  397,   18,  413,
  400,   19,  176,  176,  176,  254,  176,  301,  176,   21,
  255,  401,  135,  136,  167,  384,  167,  402,  167,  137,
  176,  176,  403,  176,   64,  406,  168,  407,  168,  408,
  168,   63,  167,  167,  411,  167,  412,   61,  169,  423,
  169,  414,  169,  429,  168,  168,  415,  168,  335,  336,
  338,  339,  340,  341,    2,  416,  169,  169,  417,  169,
   65,   66,  420,  133,   65,   66,   67,   68,   65,   66,
  421,   68,  422,  425,   67,   68,  426,  428,  165,  368,
  165,  165,  165,  165,  165,   65,   66,  427,  165,  165,
   65,   66,   68,  430,    5,   69,  130,   68,   87,   53,
  370,  157,   76,  276,  387,   65,   66,   65,   66,    1,
   65,   66,   68,   97,   68,   65,   66,   68,  213,  213,
  213,  130,   68,  225,    2,    0,    0,    0,    2,    3,
    4,    0,    0,    3,    4,    5,    0,    0,    0,    5,
    0,  226,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  166,    0,  166,  166,
  166,  166,  166,    0,    0,    0,  166,  166,    0,    0,
    0,    0,    0,    0,    0,    0,  213,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  176,    0,  176,
  176,  176,  176,  176,    0,    0,    0,  176,  176,  167,
    0,  167,  167,  167,  167,  167,    0,    0,    0,  167,
  167,  168,    0,  168,  168,  168,  168,  168,    0,    0,
    0,  168,  168,  169,    0,  169,  169,  169,  169,  169,
    0,    0,    0,  169,  169,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         16,
   17,   41,   40,   13,   40,   26,   23,   41,   41,   40,
   20,   40,   60,   41,   62,   40,  157,  158,   40,   86,
   40,   23,   76,   67,  256,   41,   16,   17,  274,  277,
  278,   48,  258,   41,   45,   46,  282,  263,   41,   60,
  256,  257,  274,   45,   46,   41,   40,   57,   41,   59,
   67,   59,  256,   70,   75,   76,   59,   41,   79,  113,
   41,   78,  257,   59,   41,   41,  270,   69,   59,  126,
  256,  128,   43,  214,   45,    1,  257,  272,   59,   40,
  284,   70,   59,   41,  256,   41,   40,   13,   78,  275,
   41,   41,  113,  147,  161,   41,  163,    7,   41,   25,
   41,   59,  274,  114,   41,   41,  127,   59,   59,  126,
   40,  128,  114,   41,   24,  117,  118,  269,    7,   41,
   41,  142,   41,  140,  141,   41,  147,   41,  172,   41,
  187,  188,   41,   40,  191,   24,  193,   61,  195,  156,
  157,  158,   41,   41,   59,   59,  256,   41,  256,   59,
  258,  140,  141,   44,   40,  172,  173,  174,   40,  176,
  270,   40,  179,  313,  314,  315,  316,   41,   41,   40,
  187,  188,   45,  258,  191,   44,  193,   40,  195,   59,
  237,   59,  239,  173,  174,  274,   40,   42,   98,  282,
   59,   45,   47,   41,  204,  345,   40,  214,  256,  257,
  266,   41,   41,   40,   58,  257,   40,   59,   41,   59,
  270,  259,  260,  261,  262,   40,   40,  270,  256,  257,
  237,  257,  239,  256,  245,  263,  257,  248,  230,  231,
  268,  265,  263,  271,  272,   40,  274,  277,  278,  277,
  278,  279,  280,  281,  269,  283,  274,   40,  277,  278,
  272,  261,  262,  263,  256,  265,   40,  277,  278,  267,
  270,  277,  278,  257,  267,  258,   41,  288,  289,  263,
  291,  267,  293,   40,  268,  256,   40,  271,  299,  256,
  290,   45,   40,  267,  275,  279,  267,  281,  282,  266,
  267,  267,  349,  350,  351,  352,  257,  354,  355,   40,
  321,  358,  263,  257,  361,  256,  256,  268,   40,  263,
  271,  267,  333,  323,  268,  269,  267,  271,  279,  376,
  274,  267,   45,  380,  267,  279,  267,  281,   40,   40,
  267,  267,  349,  350,  351,  352,  357,  354,  355,  267,
  397,  358,  256,  364,  361,  267,  267,  256,  267,  256,
  257,  267,  266,  267,   40,  267,  263,  256,   40,  376,
  275,  268,  256,  380,  271,  272,  257,  274,  267,  267,
  277,  278,  279,  280,  281,  257,  283,   59,  258,   40,
  397,  263,  256,   40,  257,  258,  268,  256,  257,  271,
  272,  264,  274,  267,  257,  277,  278,  279,   40,  281,
  263,  283,   40,  257,  258,  268,  258,  257,  271,  272,
  264,  274,   59,  257,  277,  278,  279,   40,  281,  263,
  283,   40,   40,  256,  268,  270,   59,  271,   59,  273,
   41,  256,  257,  257,  267,  279,  280,  281,  263,  263,
   40,  258,   59,  268,  268,   59,  271,  271,  258,  273,
  275,  275,  257,   59,  279,  279,  281,  281,  263,  258,
   40,   40,   59,  268,  257,  270,  271,   59,   59,  274,
  263,   59,   59,  257,  279,  268,  281,  270,  271,  263,
   40,  274,   59,   44,  268,   59,  279,  271,  281,  273,
  257,  275,   59,  257,  258,  279,  263,  281,   59,  257,
  264,  268,   59,  258,  271,  263,   41,   59,  275,  276,
  268,   41,  279,  271,  281,   41,  257,  275,   59,   59,
   59,  279,  263,  281,   22,  257,   59,  268,   59,   41,
  271,  263,  273,   41,  257,  258,  268,   59,  279,  271,
  281,  264,  274,   59,   59,  257,  257,  279,   59,  281,
   59,  263,  263,   40,  277,  278,  268,  268,   45,  271,
  271,   40,   45,  275,  275,   41,   45,  279,  279,  281,
  281,  257,   41,   41,   41,  257,  275,  263,   40,   59,
  275,  263,  268,   45,   41,  271,  268,  273,   45,  271,
  275,   59,   60,  279,   62,  281,  257,  279,   59,  281,
  257,   41,  263,   45,   59,   45,  263,  268,   45,  256,
  271,  268,  273,   45,  271,  257,  273,   59,  279,  257,
  281,  263,  279,  256,  281,  263,  268,   59,   59,  271,
  268,  273,  275,  271,  257,  273,  275,  279,  257,  281,
  263,  279,  256,  281,  263,  268,  257,  258,  271,  268,
  273,   41,  271,  264,  273,  275,  279,  257,  281,  256,
  279,  159,  281,  263,  256,  256,  277,  278,  268,   59,
   60,  271,   62,  274,  257,   40,  276,  257,  257,  279,
  257,  281,  256,  263,  263,   40,  263,   40,  268,  268,
   40,  271,  271,  273,   40,  256,  257,  257,   40,  279,
  279,  281,  281,  263,  256,   40,  257,   40,  268,  275,
   59,  271,   41,   42,   43,  275,   45,  256,   47,  279,
  218,   59,  257,  258,   41,  256,   43,   59,   45,  264,
   59,   60,   59,   62,  256,   59,   41,   59,   43,   59,
   45,  256,   59,   60,   59,   62,   59,  256,   41,   59,
   43,  275,   45,   59,   59,   60,  275,   62,  306,  307,
  308,  309,  310,  311,    0,  275,   59,   60,  275,   62,
  257,  258,  275,  256,  257,  258,  263,  264,  257,  258,
  275,  264,  275,  275,  263,  264,  275,  275,  256,  337,
  258,  259,  260,  261,  262,  257,  258,  256,  266,  267,
  257,  258,  264,  275,    0,  269,   59,  264,   22,   10,
  342,   82,   18,  248,  364,  257,  258,  257,  258,  257,
  257,  258,  264,  257,  264,  257,  258,  264,  156,  157,
  158,   59,  264,  176,  272,   -1,   -1,   -1,  272,  277,
  278,   -1,   -1,  277,  278,  283,   -1,   -1,   -1,  283,
   -1,  179,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,  259,
  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  214,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,
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
"seleccion : IF condicion_if THEN bloque_then ENDIF",
"seleccion : IF condicion_if THEN bloque_then ELSE bloque_if ENDIF",
"seleccion : error_seleccion",
"condicion_if : '(' condicion ')'",
"condicion_if : error_condicion_if",
"error_condicion_if : '(' condicion error",
"bloque_then : bloque_if",
"bloque_if : sentencia_ejecucion",
"bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END ';'",
"bloque_if : error_bloque_if",
"error_bloque_if : BEGIN sentencia_ejecucion END ';'",
"error_bloque_if : BEGIN sentencia_ejecucion bloque_sentencias END error",
"error_bloque_if : BEGIN sentencia_ejecucion END error",
"error_seleccion : condicion_if THEN bloque_then ENDIF",
"error_seleccion : IF THEN bloque_then ENDIF",
"error_seleccion : IF condicion_if bloque_then ENDIF",
"error_seleccion : IF condicion_if THEN ENDIF",
"error_seleccion : IF condicion_if THEN bloque_then error",
"error_seleccion : IF condicion_if THEN bloque_then ELSE ENDIF",
"error_seleccion : IF condicion_if THEN bloque_then ELSE bloque_if error",
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

//#line 701 "Gramatica.y"

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
//#line 784 "Parser.java"
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
                Main.tablaSimbolos.getDatos(val_peek(1).sval).setTipo(val_peek(2).sval);
    	        }
break;
case 31:
//#line 93 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + val_peek(4).sval +"'}");}
break;
case 33:
//#line 98 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
//#line 99 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
//#line 100 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + val_peek(1).sval + "}");}
break;
case 36:
//#line 106 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 37:
//#line 108 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 38:
//#line 111 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if((val_peek(6).sval != null) && (val_peek(4).sval != null)){
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
case 40:
//#line 126 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
//#line 127 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 42:
//#line 128 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 43:
//#line 129 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 44:
//#line 130 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 131 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 46:
//#line 132 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 47:
//#line 133 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 48:
//#line 136 "Gramatica.y"
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
case 49:
//#line 153 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 50:
//#line 156 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 51:
//#line 157 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 52:
//#line 158 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 53:
//#line 162 "Gramatica.y"
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
case 60:
//#line 189 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 61:
//#line 192 "Gramatica.y"
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
//#line 217 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 64:
//#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 65:
//#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 66:
//#line 223 "Gramatica.y"
{
            if(val_peek(3).sval != null){
                adminTercetos.desapilar();
                }
            }
break;
case 67:
//#line 228 "Gramatica.y"
{
	        if(val_peek(5).sval != null){
                 adminTercetos.desapilar();
                 }
	 }
break;
case 69:
//#line 238 "Gramatica.y"
{

                System.out.println("ENTRO A CONDICION *****************************");
                if(val_peek(1).sval != null){
                    System.out.println("ENTRO AL IF *****************************");
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
//#line 254 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 72:
//#line 257 "Gramatica.y"
{
                adminTercetos.desapilar(); /*para completar BF*/
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.apilar(t.getNumero());

            }
break;
case 76:
//#line 273 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 77:
//#line 274 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 78:
//#line 275 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 79:
//#line 278 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 80:
//#line 279 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 81:
//#line 280 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 82:
//#line 281 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 83:
//#line 282 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 84:
//#line 283 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 85:
//#line 284 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 86:
//#line 288 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");
           Terceto t = new Terceto("Impresion", val_peek(1).sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 87:
//#line 293 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 88:
//#line 300 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                }
            }
break;
case 89:
//#line 310 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                }
            }
break;
case 90:
//#line 320 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + val_peek(3).sval + "'}");
                 if (val_peek(1).sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(val_peek(3).sval, ambito);
                    if(ambitoFuncion != null){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                    else
                        System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+val_peek(3).sval+" esta fuera de alcance");
                 }
            }
break;
case 92:
//#line 334 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 93:
//#line 335 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
//#line 336 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
//#line 337 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
//#line 346 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 99:
//#line 347 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 100:
//#line 348 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 101:
//#line 349 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 105:
//#line 359 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 106:
//#line 364 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 108:
//#line 372 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 109:
//#line 376 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ val_peek(0).sval +"'" );
            if(val_peek(1).sval != null){ /*si se declaró bien*/
                ambito = ambito.substring(0,ambito.lastIndexOf("@"));
                Terceto t = new Terceto("FinFuncion", val_peek(1).sval, null);
                adminTercetos.agregarTerceto(t);
                yyval = new ParserVal(val_peek(1).sval);
            }
            else
                 yyval = new ParserVal(null);
         }
break;
case 111:
//#line 389 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 112:
//#line 392 "Gramatica.y"
{
                    parametroCopiaValor = val_peek(1).sval;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = val_peek(3).sval + "@" + ambito;
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema(val_peek(3).sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("NombreFuncion");
                            Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);

                            ambito = ambito + "@" + val_peek(3).sval;
                            Main.tablaSimbolos.reemplazarLexema(parametroCopiaValor, parametroCopiaValor +"@"+ ambito); /* Se agrega el ambito al parametro (nombre de la función)*/

                            Terceto t = new Terceto("ComienzaFuncion", nuevoLexema, null);
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.agregarFuncion(nuevoLexema);

                            yyval = new ParserVal(nuevoLexema);
                        }
                        else{
                            System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La funcion '" + val_peek(3).sval + "' ya fue declarada en este ámbito}");
                            yyval = new ParserVal(null);  /* se setea null para luego comprobar si se declaró o no*/
                        }
                    }
                    parametroCopiaValor = "";
                    }
break;
case 114:
//#line 421 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 115:
//#line 422 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 116:
//#line 423 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 117:
//#line 424 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 118:
//#line 425 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 119:
//#line 428 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);

                }
break;
case 121:
//#line 439 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 124:
//#line 447 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 125:
//#line 448 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 126:
//#line 449 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 127:
//#line 450 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 128:
//#line 451 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 129:
//#line 452 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 134:
//#line 465 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 139:
//#line 475 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 140:
//#line 476 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 141:
//#line 477 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 142:
//#line 478 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 143:
//#line 479 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 144:
//#line 480 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 145:
//#line 481 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 146:
//#line 482 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 147:
//#line 483 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 148:
//#line 485 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 149:
//#line 486 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 150:
//#line 487 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 151:
//#line 488 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 152:
//#line 489 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 153:
//#line 490 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 154:
//#line 491 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 155:
//#line 492 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 156:
//#line 493 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 157:
//#line 494 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 158:
//#line 495 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 159:
//#line 496 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 160:
//#line 497 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 161:
//#line 503 "Gramatica.y"
{ Operando op = (Operando)val_peek(0).obj;
                            if(op != null){
                                yyval = new ParserVal(op.getValor());
                            }
                            else
                                 yyval = new ParserVal(null);
                        }
break;
case 162:
//#line 510 "Gramatica.y"
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
//#line 532 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 164:
//#line 533 "Gramatica.y"
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
//#line 554 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 166:
//#line 555 "Gramatica.y"
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
//#line 578 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 168:
//#line 581 "Gramatica.y"
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
case 169:
//#line 601 "Gramatica.y"
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
case 170:
//#line 623 "Gramatica.y"
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
case 171:
//#line 643 "Gramatica.y"
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
case 172:
//#line 663 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 173:
//#line 667 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) val_peek(0).obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 174:
//#line 672 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 175:
//#line 675 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 176:
//#line 678 "Gramatica.y"
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
case 178:
//#line 691 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 179:
//#line 692 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 180:
//#line 693 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 181:
//#line 694 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 182:
//#line 695 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 183:
//#line 696 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 1793 "Parser.java"
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
