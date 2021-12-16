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
   29,   30,   13,   13,   32,   32,   32,   10,   35,   10,
   10,   33,   33,   38,   34,   34,   34,   39,   39,   39,
   36,   36,   36,   36,   36,   36,   36,   11,   11,   12,
   12,   12,   12,   40,   40,   40,   40,   15,   15,   41,
   41,   44,   43,   43,   43,   42,   45,   45,   18,   18,
   18,   46,   19,   19,   49,   47,   47,   51,   51,   51,
   51,   51,   51,   50,   50,   52,   20,   48,   48,   48,
   54,   53,   53,   53,   53,   53,   56,   56,   56,   56,
   56,   56,   56,   56,   56,   56,   56,   56,   56,   56,
   56,   56,   56,   55,   55,   57,   57,   57,   57,   57,
   37,   58,   58,   59,   59,   27,   27,   31,   31,   31,
   61,   61,   61,   62,   62,   62,   62,   62,   60,   60,
   60,   60,   60,   60,
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
    0,  175,    0,    0,  178,    0,    0,  173,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   51,  102,
  100,    0,  164,    0,    0,    0,    0,    6,    1,    0,
   13,   12,   23,   17,   24,   18,   25,   19,   27,   20,
   26,   21,   31,   29,    0,    0,    0,  103,    0,    0,
    0,    0,    0,   36,  112,   32,    0,    0,    0,    0,
    0,    0,    0,  131,  128,    0,    0,   67,    0,    0,
    0,    0,   94,  174,    0,    0,    0,    0,    0,   75,
    0,   77,    0,    0,    0,   89,    0,   14,    9,    0,
   53,    0,   52,    0,    0,    0,    0,  182,  183,  181,
  184,  179,  180,    0,   74,   72,    0,    0,    0,  107,
    0,  104,   98,    0,    0,  125,    0,    0,    0,    0,
    0,  109,    0,    0,  143,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   97,   92,   95,   90,   96,   91,
    0,    0,  171,  172,    0,   82,   84,    0,   83,   88,
   15,   16,   54,   50,    0,   55,    0,    0,    0,  105,
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
   12,   88,  225,  346,   38,   89,   93,  367,  368,  369,
   94,   39,   40,  151,  266,   41,   95,   42,  152,   43,
   44,  118,   45,   46,  181,   54,   13,   63,   14,  185,
   15,  186,   64,   65,   66,   67,   68,   96,   97,  174,
   77,   78,
};
final static short yysindex[] = {                       -95,
   80, -234,    0,    0, -191,    0,   80,    0,    0, -167,
  -45,    0,  -34,    0,    0,  -33,  344,  -36,   69,  103,
   71,  220,  344,   32,  268,  232,    0,    0,    0,  -41,
  -38,   60,   74,   91,    0,  114,    0,    0,    0, -152,
    0,    0,    0, -172,    0,    0,   78,   68,    0,    0,
   82,    2,  383,    0,    0,    0,    0,  -15,   -6,  102,
   13,  257,    0,    0,    0,   86,    0,    0,  104,    0,
  459,    0,   22,  344,    0,   85,   41,    0,   85,  258,
  135,  -13,  103,   61, -159, -112,  -51,   89,    0,    0,
    0, -133,    0,  490,    5, -116, -114,    0,    0,  268,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  258,  407, -197,    0, -192, -192,
 -192,  -23, -192,    0,    0,    0, -104,  115,  150,  286,
  344,   92,  344,    0,    0,  116,  379,    0,   85,    7,
   15,   27,    0,    0,  344,  344,  344,  344,  379,    0,
 -107,    0,  165, -106,  113,    0,  285,    0,    0,  470,
    0, -221,    0,  344,  482,  344, -109,    0,    0,    0,
    0,    0,    0,  344,    0,    0,  344,  344, -101,    0,
  398,    0,    0, -144,  133,    0,  -92,  154,   43,  156,
  159,    0,  344,  121,    0,  344,  306,  313,  160,  153,
  161,  163,  344,  325,    0,    0,    0,    0,    0,    0,
   41,   41,    0,    0,  332,    0,    0,  120,    0,    0,
    0,    0,    0,    0,  122,    0,  499,  126,  132,    0,
   85, -114,    0,    0,    0,    0,    0,    0,    0,  167,
  155,    0,    0,   51,    0,    0,  168,  260,  172,   52,
  287,  177,  295,    0,    0,   75,    0,    0,  314,  324,
  117,  353,    0,    0,   83,   84,  111,  129,  -48,  137,
  162, -192,    0,    0,    0,  349,  365,   35,  367,  371,
  344,  430,    0,  344,  344,    0,    0,  373,  344,    0,
    0,  140,  192,  258,  396,  400,  402,   -8,  410,  412,
  416,  184,  186,  189,  -56,  190,  194,  426,  461,  431,
  106,  437,  205,  440,    0,    0,    0,  228,  142,  219,
  219,  219,  -39,  219,  219,  219,  435,    0,    0,    0,
    0, -226,    0,    0,  438,  439,   39,  446,  449,  450,
    0,  451,    0,    0,  362,    0,    0,    0, -174,    0,
    0,    0,    0,  255,    0,    0,  210,  244,  247,  -54,
  248,  259,  272,  280,  144,    0,  211,    0,    0,    0,
    0,  302,    0,    0,    0,    0, -205,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   16,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  561,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  472,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  638,    0,
    0,    0,    0,    0,    0,  149,  586,    0,  198,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   56,    0,    6,  -40,    0,    0,  562,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  240,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  650,  662,    0,    0,    0,    0,    0,  284,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  356,  -28,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  303,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  303,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  512,    0,    0,
};
final static short yygindex[] = {                         0,
   37,   54,    0,    8,  643,    0,  -26,   -2,    0,    0,
    0,   -7,    0,    0,  551,    0,  611,  203,    0,    0,
    0,  491, -121,  443,    0,    0,  -91,    0,  213,    0,
   10,    0,  565,  536,    0,    0,  666,    0,    0,    0,
    0,  -88,    0,    0,    0,    0,    0,    0,    0,  -82,
    0,    0,  529,    0,  533,    0,    0,    0,  420,    0,
  -11,  -52,
};
final static int YYTABLESIZE=975;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                        102,
  162,  349,  332,   23,  377,   23,   73,  164,   75,   75,
  298,   74,  163,   56,   50,   75,  189,  104,  162,   91,
  106,  144,   47,   60,   23,   76,   79,  156,  183,  355,
  163,   50,  324,  131,  223,  102,  224,   24,  188,  190,
  191,  123,   60,  228,  229,  176,  161,  206,  356,   61,
  388,  132,   23,  150,  150,  208,   83,  102,  182,  127,
   49,  100,  143,   75,  161,   48,   75,  210,   50,  389,
   60,   23,  226,  226,  226,  305,  116,   99,  230,  360,
  139,  370,  147,  243,    3,    4,  233,  148,  150,   51,
   50,  275,  280,  304,  213,  214,  167,  359,  161,  345,
   23,  116,  102,  162,   52,  269,  244,   50,   82,  117,
   87,  237,  238,  180,  167,  287,  115,  119,  108,   23,
  160,  121,  215,   75,   75,   75,  150,  145,  120,  146,
  102,  200,  110,  211,  212,  226,   74,   75,   75,   75,
   75,  133,   23,   73,  137,  163,  339,  166,  167,  112,
  177,  178,  192,  220,  193,  203,   75,   75,   75,   23,
  248,    1,  216,  219,  116,   74,   75,   50,  234,   75,
   75,  102,  114,  239,   23,  291,    2,  102,  236,  240,
  267,    3,    4,  231,  270,   75,   75,    5,   75,  196,
  271,  150,   75,  255,  242,   75,  245,   74,  316,  246,
  254,  257,  383,  258,   23,   85,  272,   66,  276,  297,
   55,   86,  279,  273,  103,  162,  284,  105,  331,   75,
  376,   57,   16,   69,   70,  102,  162,  163,   17,   71,
   72,   23,   80,   18,  345,  102,   19,    2,  163,   58,
   75,   16,    3,    4,   21,   59,   22,   17,    5,  323,
   23,  155,   18,    3,    4,   19,   65,  128,  122,   23,
  175,  161,  205,   21,   59,   22,  150,  150,  134,   16,
  207,   23,  125,   75,   75,   17,   75,   75,  140,  141,
   18,   75,  209,   19,    2,  142,   58,   98,   16,    3,
    4,   21,   59,   22,   17,    5,   23,   23,   63,   18,
  277,   75,   19,    2,   74,   20,  274,  175,    3,    4,
   21,  167,   22,  167,    5,  107,  158,   16,  366,    3,
    4,  167,  167,   17,   23,   23,  281,   85,   18,  109,
  286,   19,    2,   86,  285,  159,   16,    3,    4,   21,
  366,   22,   17,    5,  197,   23,  111,   18,   69,   70,
   19,    2,   23,   20,  288,   72,    3,    4,   21,   16,
   22,  175,    5,  289,   23,   17,  293,  294,  295,  113,
   18,   23,  290,   19,    2,  263,   16,   69,   70,    3,
    4,   21,   17,   22,   72,    5,  296,   18,   74,  264,
   19,   16,   23,  149,  299,  315,  166,   17,   21,  382,
   22,   23,   18,  153,   66,   19,   16,  302,  149,   69,
   70,  344,   17,   21,  166,   22,   72,   18,   23,  300,
   19,   16,  194,  303,  195,  306,  127,   17,   21,  307,
   22,  313,   18,   16,  217,   19,  320,   23,  149,   17,
  321,  126,  322,   21,   18,   22,   23,   19,   16,  282,
  325,  283,  326,   65,   17,   21,  327,   22,  328,   18,
  329,  317,   19,  330,  333,  149,  335,   16,  334,  309,
   21,  338,   22,   17,   74,   90,   16,  340,   18,  341,
  342,   19,   17,  343,  373,  384,  365,   18,   16,   21,
   19,   22,  345,  354,   17,   63,  357,  358,   21,   18,
   22,  336,   19,   74,  361,   74,  101,  362,  363,  364,
   21,  372,   22,   16,   16,  110,   69,   70,  374,   17,
   17,  375,  378,   72,   18,   18,   74,   19,   19,  136,
  110,  149,  145,  379,  146,   21,   21,   22,   22,    2,
  227,   16,   16,   74,    3,    4,  380,   17,   17,  172,
    5,  173,   18,   18,  381,   19,   19,  268,  386,  221,
    2,    5,   16,   21,   21,   22,   22,   69,   17,   16,
  127,   72,   92,   18,  387,   17,   19,  165,  251,  385,
   18,   16,   81,   19,   21,  253,   22,   17,   16,  135,
  130,   21,   18,   22,   17,   19,  232,  260,    0,   18,
   69,   70,   19,   21,    0,   22,  261,   72,    0,   16,
   21,  166,   22,  166,    0,   17,  154,    0,   16,    0,
   18,  166,  166,   19,   17,    0,  168,  292,  168,   18,
  168,   21,   19,   22,    0,   16,    0,  365,  124,  125,
   21,   17,   22,    0,  168,  168,   18,  168,    0,   19,
  179,    0,    0,    0,   16,   62,    0,   21,    0,   22,
   17,    0,   84,   16,    0,   18,    0,    0,   19,   17,
    0,    0,  235,    0,   18,    0,   21,   19,  177,  177,
  177,    0,  177,    0,  177,   21,   69,   70,  218,    0,
  169,    0,  169,   72,  169,    0,  177,  177,    0,  177,
  129,    0,  170,   62,  170,    0,  170,    0,  169,  169,
    0,  169,    0,    0,  138,   69,   70,   69,   70,    0,
  170,  170,   72,  170,   72,  157,    0,  110,  110,  184,
  187,  184,  184,  184,    0,    0,    0,    0,   69,   70,
    0,    2,    0,    0,  222,   72,    3,    4,  168,  169,
  170,  171,    5,  265,    0,   69,   70,    0,    0,    0,
    0,    0,   72,  347,  348,  350,  351,  352,  353,    0,
    0,    0,  198,    0,    0,    0,    0,    0,    0,  204,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  371,    0,    0,    0,    0,  199,  201,  202,  184,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  318,  319,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  252,
    0,  168,    0,  168,  168,  168,  168,  168,    0,    0,
    0,  168,  168,    0,    0,    0,    0,  262,  247,  249,
    0,  250,    0,    0,    0,  256,    0,    0,  259,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  301,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  177,    0,  177,  177,  177,  177,  177,
    0,    0,    0,  177,  177,  169,    0,  169,  169,  169,
  169,  169,    0,  278,    0,  169,  169,  170,    0,  170,
  170,  170,  170,  170,    0,    0,    0,  170,  170,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  308,  310,    0,  311,
  312,    0,    0,    0,  314,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  337,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         26,
   41,   41,   59,   40,   59,   40,   40,   59,   16,   17,
   59,   45,   41,   59,    7,   23,   40,   59,   59,   22,
   59,   74,  257,   58,   40,   16,   17,   41,  117,  256,
   59,   24,   41,   40,  256,   62,  258,    1,  121,  122,
  123,   40,   58,  165,  166,   41,   41,   41,  275,   13,
  256,   58,   40,   80,   81,   41,   20,   84,  256,   44,
    7,   25,   41,   71,   59,  257,   74,   41,   61,  275,
   58,   40,  164,  165,  166,   41,  274,   24,  167,   41,
   71,  256,   42,   41,  277,  278,  178,   47,  115,  257,
   83,   41,   41,   59,  147,  148,   41,   59,  258,  274,
   40,  274,  129,  263,  272,  227,  189,  100,   40,  282,
   40,  256,  257,  116,   59,   41,  269,   40,   59,   40,
   84,   40,  149,  131,  132,  133,  153,   43,   61,   45,
  157,   40,   59,  145,  146,  227,   45,  145,  146,  147,
  148,   40,   40,   40,   59,  258,   41,   59,  282,   59,
  267,  266,  257,   41,   40,   40,  164,  165,  166,   40,
   40,  257,  270,  270,  274,   45,  174,  160,  270,  177,
  178,  198,   59,   41,   40,   59,  272,  204,  181,  272,
   59,  277,  278,  174,   59,  193,  194,  283,  196,   40,
   59,  218,  200,   41,   41,  203,   41,   45,   59,   41,
   41,   41,   59,   41,   40,  257,   40,   59,   41,  258,
  256,  263,   41,   59,  256,  256,   40,  256,  275,  227,
  275,  256,  257,  257,  258,  252,  267,  256,  263,  263,
  264,   40,  269,  268,  274,  262,  271,  272,  267,  274,
  248,  257,  277,  278,  279,  280,  281,  263,  283,  258,
   40,  265,  268,  277,  278,  271,   59,  273,  257,   40,
  256,  256,  256,  279,  280,  281,  293,  294,  256,  257,
  256,   40,  257,  281,  282,  263,  284,  285,  257,  258,
  268,  289,  256,  271,  272,  264,  274,  256,  257,  277,
  278,  279,  280,  281,  263,  283,   40,   40,   59,  268,
   41,  309,  271,  272,   45,  274,  256,  256,  277,  278,
  279,  256,  281,  258,  283,  256,  256,  257,  345,  277,
  278,  266,  267,  263,   40,   40,   40,  257,  268,  256,
  256,  271,  272,  263,   40,  275,  257,  277,  278,  279,
  367,  281,  263,  283,   59,   40,  256,  268,  257,  258,
  271,  272,   40,  274,   41,  264,  277,  278,  279,  257,
  281,  256,  283,   40,   40,  263,  284,  284,  258,  256,
  268,   40,  256,  271,  272,  256,  257,  257,  258,  277,
  278,  279,  263,  281,  264,  283,  258,  268,   45,  270,
  271,  257,   40,  274,  258,  256,   41,  263,  279,  256,
  281,   40,  268,  269,  256,  271,  257,   59,  274,  257,
  258,  270,  263,  279,   59,  281,  264,  268,   40,  258,
  271,  257,  273,   59,  275,   59,   44,  263,  279,   59,
  281,   59,  268,  257,  270,  271,   41,   40,  274,  263,
   41,   59,   41,  279,  268,  281,   40,  271,  257,  273,
   41,  275,   41,  256,  263,  279,   41,  281,  275,  268,
  275,  270,  271,  275,  275,  274,   41,  257,  275,   40,
  279,   41,  281,  263,   45,  256,  257,   41,  268,  275,
   41,  271,  263,  256,  275,  275,  276,  268,  257,  279,
  271,  281,  274,   59,  263,  256,   59,   59,  279,  268,
  281,   41,  271,   45,   59,   45,  275,   59,   59,   59,
  279,  257,  281,  257,  257,   44,  257,  258,  275,  263,
  263,  275,  275,  264,  268,  268,   45,  271,  271,  273,
   59,  274,   43,  275,   45,  279,  279,  281,  281,  272,
   59,  257,  257,   45,  277,  278,  275,  263,  263,   60,
  283,   62,  268,  268,  275,  271,  271,   59,  257,  275,
    0,    0,  257,  279,  279,  281,  281,  284,  263,  257,
   59,  269,   22,  268,  372,  263,  271,   87,  273,  367,
  268,  257,   18,  271,  279,  273,  281,  263,  257,   61,
   58,  279,  268,  281,  263,  271,  177,  273,   -1,  268,
  257,  258,  271,  279,   -1,  281,  275,  264,   -1,  257,
  279,  256,  281,  258,   -1,  263,   81,   -1,  257,   -1,
  268,  266,  267,  271,  263,   -1,   41,  275,   43,  268,
   45,  279,  271,  281,   -1,  257,   -1,  276,  256,  257,
  279,  263,  281,   -1,   59,   60,  268,   62,   -1,  271,
  115,   -1,   -1,   -1,  257,   13,   -1,  279,   -1,  281,
  263,   -1,   20,  257,   -1,  268,   -1,   -1,  271,  263,
   -1,   -1,  275,   -1,  268,   -1,  279,  271,   41,   42,
   43,   -1,   45,   -1,   47,  279,  257,  258,  153,   -1,
   41,   -1,   43,  264,   45,   -1,   59,   60,   -1,   62,
   58,   -1,   41,   61,   43,   -1,   45,   -1,   59,   60,
   -1,   62,   -1,   -1,  256,  257,  258,  257,  258,   -1,
   59,   60,  264,   62,  264,   83,   -1,  256,  257,  119,
  120,  121,  122,  123,   -1,   -1,   -1,   -1,  257,  258,
   -1,  272,   -1,   -1,  275,  264,  277,  278,  259,  260,
  261,  262,  283,  218,   -1,  257,  258,   -1,   -1,   -1,
   -1,   -1,  264,  321,  322,  323,  324,  325,  326,   -1,
   -1,   -1,  130,   -1,   -1,   -1,   -1,   -1,   -1,  137,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  349,   -1,   -1,   -1,   -1,  131,  132,  133,  189,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  293,  294,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  197,
   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,   -1,   -1,   -1,  215,  193,  194,
   -1,  196,   -1,   -1,   -1,  200,   -1,   -1,  203,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  272,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  256,   -1,  258,  259,  260,
  261,  262,   -1,  248,   -1,  266,  267,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  281,  282,   -1,  284,
  285,   -1,   -1,   -1,  289,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  309,
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
"error_asignacion : ASIGNACION expresion",
"error_asignacion : IDENTIFICADOR expresion",
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

//#line 960 "Gramatica.y"

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
	    Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una constante ULONG fuera de rango}");
		Main.tablaSimbolos.eliminarSimbolo(lexema);
	}
	else if (id == Lexico.CTE_DOUBLE) {
		double valor = -1*Double.parseDouble(lexema);
		if(( valor > 2.2250738585272014e-308 && valor < 1.7976931348623157e+308) || (valor > -1.7976931348623157e+308 && valor < -2.2250738585072014e-308) || (valor == 0.0)){
                	Main.tablaSimbolos.modificarSimbolo(lexema, String.valueOf(valor));
                	return true;
        }
        else {
            Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "]  {Se detectó una constante DOUBLE fuera de rango}");
            Main.tablaSimbolos.eliminarSimbolo(lexema);
	 	}
	}
	return false;
}
//#line 775 "Parser.java"
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
            int cantidad = adminTercetos.cantidadTercetos() -1;
            t =  new Terceto(":=", val_peek(6).sval, "["+ cantidad + "]");
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
//#line 153 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 43:
//#line 154 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 44:
//#line 155 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
//#line 156 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 46:
//#line 157 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 47:
//#line 158 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 48:
//#line 159 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 49:
//#line 160 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 50:
//#line 163 "Gramatica.y"
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
//#line 183 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 52:
//#line 186 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 53:
//#line 187 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 54:
//#line 188 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 55:
//#line 192 "Gramatica.y"
{
                                Operando op = (Operando)val_peek(0).obj;
                                if (op != null){
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
//#line 219 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 63:
//#line 222 "Gramatica.y"
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
//#line 262 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 66:
//#line 263 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 67:
//#line 264 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 68:
//#line 268 "Gramatica.y"
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
//#line 277 "Gramatica.y"
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
//#line 288 "Gramatica.y"
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
//#line 301 "Gramatica.y"
{
                Operando op = (Operando)val_peek(1).obj;
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
case 74:
//#line 315 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 78:
//#line 323 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 79:
//#line 324 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 80:
//#line 325 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 81:
//#line 328 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 82:
//#line 329 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 83:
//#line 330 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 84:
//#line 331 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 85:
//#line 332 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 86:
//#line 334 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 87:
//#line 335 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 88:
//#line 340 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(1).sval  + "'}");
           Terceto t = new Terceto("Impresion", val_peek(1).sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 89:
//#line 345 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + val_peek(0).sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 90:
//#line 352 "Gramatica.y"
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
//#line 388 "Gramatica.y"
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
//#line 423 "Gramatica.y"
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
//#line 473 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 95:
//#line 474 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 96:
//#line 475 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 97:
//#line 476 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
//#line 479 "Gramatica.y"
{adminTercetos.desapilar();
                                        Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                                        adminTercetos.agregarTerceto(t);}
break;
case 100:
//#line 486 "Gramatica.y"
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
//#line 497 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 103:
//#line 500 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 104:
//#line 501 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 105:
//#line 502 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 109:
//#line 512 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se leyo el Identificador -> " + val_peek(0).sval);
			        lista_variables = (ArrayList<String>) val_peek(2).obj;
			        lista_variables.add(val_peek(0).sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 110:
//#line 517 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + val_peek(0).sval + "}");
			                        lista_variables.add(val_peek(0).sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 112:
//#line 525 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 113:
//#line 529 "Gramatica.y"
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
//#line 559 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 116:
//#line 562 "Gramatica.y"
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
//#line 593 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta indicar el tipo}");}
break;
case 119:
//#line 594 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 120:
//#line 595 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 121:
//#line 596 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 122:
//#line 597 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 123:
//#line 598 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 124:
//#line 601 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(val_peek(0).sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(val_peek(1).sval);
                Main.tablaSimbolos.setDatosSimbolo(val_peek(0).sval, ds);
                yyval = new ParserVal(val_peek(0).sval);
                }
break;
case 126:
//#line 611 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 127:
//#line 615 "Gramatica.y"
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
//#line 646 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 129:
//#line 652 "Gramatica.y"
{
                if (val_peek(0).sval != null)
                    yyval = new ParserVal (val_peek(0).sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 130:
//#line 658 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 131:
//#line 661 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 132:
//#line 665 "Gramatica.y"
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
//#line 674 "Gramatica.y"
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
//#line 683 "Gramatica.y"
{
			            Operando op = (Operando)val_peek(3).obj;
			            if (val_peek(8).sval != null && op != null){
			                yyval = new ParserVal (op.getValor());
			            }
			            else
			                yyval = new ParserVal (null);
			 }
break;
case 135:
//#line 691 "Gramatica.y"
{
                        Operando op = (Operando)val_peek(3).obj;
                        if (val_peek(7).sval != null && op != null){
                            yyval = new ParserVal (op.getValor());
                        }
                        else
                             yyval = new ParserVal (null);
             }
break;
case 136:
//#line 700 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 137:
//#line 703 "Gramatica.y"
{Main.listaErrores.add("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 138:
//#line 704 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 139:
//#line 705 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 140:
//#line 706 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 141:
//#line 707 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 142:
//#line 708 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 143:
//#line 709 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 144:
//#line 710 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 145:
//#line 712 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 146:
//#line 713 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 147:
//#line 714 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 148:
//#line 715 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 149:
//#line 716 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 150:
//#line 717 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 151:
//#line 718 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 152:
//#line 719 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 153:
//#line 720 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 154:
//#line 724 "Gramatica.y"
{
                      Operando op = (Operando)val_peek(1).obj;
                      if (op != null){
                         Terceto t = new Terceto("BF", op.getValor(), null);
                         adminTercetos.agregarTerceto(t);
                         adminTercetos.apilar(t.getNumero());
                         yyval = new ParserVal(op.getValor());
                     }
                     else
                         yyval = new ParserVal(null);
                   }
break;
case 156:
//#line 738 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 157:
//#line 739 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 158:
//#line 740 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 159:
//#line 741 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 160:
//#line 742 "Gramatica.y"
{Main.listaErrores.add("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 161:
//#line 747 "Gramatica.y"
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
//#line 759 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 163:
//#line 761 "Gramatica.y"
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
//#line 784 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 165:
//#line 786 "Gramatica.y"
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
//#line 807 "Gramatica.y"
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
//#line 827 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 168:
//#line 831 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 169:
//#line 834 "Gramatica.y"
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
//#line 854 "Gramatica.y"
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
//#line 876 "Gramatica.y"
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
//#line 896 "Gramatica.y"
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
//#line 916 "Gramatica.y"
{ yyval = new ParserVal((Operando)val_peek(0).obj);}
break;
case 174:
//#line 920 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) val_peek(0).obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 175:
//#line 925 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", val_peek(0).sval));
        }
break;
case 176:
//#line 928 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");
         yyval = new ParserVal(new Operando("ULONG", val_peek(0).sval));
         }
break;
case 177:
//#line 931 "Gramatica.y"
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
//#line 940 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocacion de funcion}");
                       if(val_peek(0).sval != null){
                           String ambitoVariable = Main.tablaSimbolos.verificarAmbito(val_peek(0).sval, ambito);
                           yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                       }
                       /*TODO ELSE*/
                     }
break;
case 179:
//#line 950 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 180:
//#line 951 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 181:
//#line 952 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 182:
//#line 953 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 183:
//#line 954 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 184:
//#line 955 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
//#line 2066 "Parser.java"
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
