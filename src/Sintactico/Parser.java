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
   40,   39,   39,   39,   39,   41,   41,   41,   41,   41,
   41,   41,   41,   41,   41,   41,   41,   41,   41,   41,
   41,   41,   41,   41,   41,   41,   19,   19,   42,   42,
   43,   43,   25,   25,   25,   27,   27,   27,   45,   45,
   45,   45,   44,   44,   44,   44,   44,   44,
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
    4,    8,   14,   13,    1,    7,    7,    7,    7,    7,
    7,    7,    3,    8,   12,   12,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   13,    1,    3,    1,    3,
    1,    3,    1,    3,    3,    3,    3,    1,    2,    1,
    1,    1,    1,    1,    1,    1,    1,    1,
};
final static short yydefred[] = {                         0,
    0,    0,   31,   32,    0,    0,    0,    2,    5,    0,
    0,   27,   87,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    8,    9,    0,    0,    0,    0,    0,
   18,   34,   53,   59,   77,    0,    0,    0,    0,    3,
    6,    0,    0,    0,   84,   30,  152,  151,    0,  150,
    0,    0,    0,    0,    0,   95,  148,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    1,    0,    0,   11,   10,   19,   13,   20,   14,
   21,   15,   23,   16,   22,   17,    0,    0,    0,    0,
    0,    0,   28,   85,   24,    0,   29,   25,    0,   80,
    0,  149,   96,   94,    0,    0,   79,    0,    0,    0,
    0,    0,    0,    0,  156,  157,  155,  158,  153,  154,
    0,    0,    0,   12,    7,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   78,    0,   82,    0,  146,
  147,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   75,    0,    0,    0,    0,    0,    0,    0,   88,  108,
   91,    0,   92,   90,   89,    0,    0,    0,   98,    0,
    0,   60,    0,   62,    0,    0,    0,    0,   76,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  106,  115,   86,    0,    0,    0,   26,    0,   68,   69,
   71,    0,   70,   67,    0,    0,    0,    0,    0,    0,
   66,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   57,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  123,
    0,    0,  110,    0,  111,    0,  109,    0,    0,    0,
    0,    0,   65,   63,    0,   73,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  107,    0,    0,  101,  102,    0,
  103,  100,   99,   64,   61,   58,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   83,    0,  104,
   97,    0,   35,   37,   40,   41,    0,   43,   42,   39,
   38,   36,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   48,    0,   46,
   50,   33,  117,    0,    0,    0,    0,    0,    0,    0,
  120,  121,  122,    0,  119,  118,    0,  116,   51,   49,
   45,   47,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  124,  112,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  127,  128,  130,  133,  134,  135,    0,  132,  131,  129,
    0,    0,  126,  125,  136,  114,    0,  113,
};
final static short yydgoto[] = {                          6,
  158,   22,    8,    9,   23,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  168,   12,   70,  313,
   32,  339,  340,  341,   61,   33,   62,  173,   34,  174,
   91,   35,   45,  159,   13,   56,  278,  169,  191,  160,
  192,   63,   64,  121,   57,
};
final static short yysindex[] = {                      -157,
   23,  -26,    0,    0, -242,    0,   36,    0,    0, -240,
  -15,    0,    0,  387,  360,  155,   -3,  364,  -22,   79,
   36,  495,  205,    0,    0,  115,  378,  380,  393,  401,
    0,    0,    0,    0,    0,  -37, -250,   -9,   79,    0,
    0,   19,  390,  406,    0,    0,    0,    0,  360,    0,
  -28,  360, -173,   33,   32,    0,    0,   33,  476,    9,
   15,   33, -188,  545, -168,  396,  139,   45,  -50,   31,
   67,    0,   19,  495,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -12,   68,   71, -250,
   75, -250,    0,    0,    0, -134,    0,    0,   15,    0,
   84,    0,    0,    0,  360,  360,    0, -142,  -35,  360,
 -141,  360,  360,  360,    0,    0,    0,    0,    0,    0,
  360,   88,  -28,    0,    0, -128,  128, -127, -137,  495,
  495,  -39,  495,  495,    1,    0,   94,    0,  495,    0,
    0,  222,  222,  152, -188,  222,   33,   33,  545,   15,
    0,   97,   81,   90,  -49,   91,  222,  -20,    0,    0,
    0,  495,    0,    0,    0,  -31, -250,   92,    0,  495,
  364,    0, -133,    0, -123,  154, -109, -108,    0,  360,
  360,  455,  360,  360, -101,  120,  133,  119,  224, -106,
    0,    0,    0,   -8,  137,  142,    0,  231,    0,    0,
    0, -245,    0,    0,   22,  149,  490,  163,  304,  309,
    0,  140,  485,  172,  360,  241,   96,  145,  241,  131,
    6,  134,  143,  411,  248,    0,  187,  -62,  -60,  -57,
  127,  -55,  -54,  -53,  360,  493,  166,   50,  437,    0,
   79,   51,    0,  241,    0,  360,    0,  -46,  -46,  151,
  -46,  -46,    0,    0,  415,    0,  168,  175,  365,  405,
  407,  -29,  413,  428,  442,   53,  383,  -11,  360,  397,
  506,   64,   66,  459,    0,   72,  267,    0,    0, -154,
    0,    0,    0,    0,    0,    0,  280,  280,  280,  280,
   -7,  280,  280,  280,  280,  507,  364,  364,   11,   73,
  364,  523,    5,  551,   27,  364,  563,    0,  -36,    0,
    0,  265,    0,    0,    0,    0,  280,    0,    0,    0,
    0,    0,  351,  269,  282,  289,  301,  569,  302,  354,
  355,    2,  358,  363,  320,  367,  449,    0,  196,    0,
    0,    0,    0,  600,  608,  612,  321,  621,  333,  623,
    0,    0,    0, -235,    0,    0,  629,    0,    0,    0,
    0,    0,  360,  360,  360,  446,   79,  360,  632,  340,
  360,    0,    0,  360,   77,   78,   98,  522,  105,  107,
  114,  360,  639,  117,  122,  618,  622,  624,  627,    8,
  630,   34,  633,  130,  360,  634,  641,  416,  423,  432,
  441,  443,    3,  447,  450,  452,  665,  136,  453,  454,
    0,    0,    0,    0,    0,    0,  475,    0,    0,    0,
  457,  676,    0,    0,    0,    0,  461,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  419,    0,    0,    0,    0,    0,    0,  470,    0,
    0,    0,    0,  497,    0,    0,    0,  520,    0,    0,
  649,  596,   58,  448,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  688,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  526,    0,
  527,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  528,
    0,    0,    0,    0,    0,    0,    0,    0,  536,    0,
    0,    0,    0,    0,   63,    0,  625,  637,  472,  661,
    0,  527,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  539,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  352,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  543,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  555,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  678,    0,
    0,    0,    0,    0,    0,    0,  557,    0,    0,    0,
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
    0,    0,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
   89,   -2,    0,   24,  -14,    0,   -1,    0,    0,    0,
    0,    0,    0,  -13,  467,  735,    0,    0,  -16,  530,
    0,    0,  417,    0,  -33,    0,   21,  -75,    0,    0,
  751,    0,    0,  -77,    0,    0,  509,    0,    0,    0,
    0,  636,  648,    0,  -10,
};
final static int YYTABLESIZE=930;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         60,
   53,  162,   87,   67,   40,  144,   53,   96,  194,  183,
  128,  292,  100,   37,   38,   99,   42,   69,   72,   39,
  372,   76,   53,   53,  226,   53,    3,    4,  131,  299,
   41,    2,  220,  317,   54,   58,   65,   53,  227,  373,
  167,  102,  109,   46,   41,  332,  250,  298,  403,  111,
   39,   90,   53,  161,  163,  164,  165,  112,   92,  113,
  354,  417,   20,  331,  249,   76,  402,  175,  177,  326,
  178,  129,  107,   53,  105,   39,  135,  114,   53,  106,
  228,  185,  103,  104,  193,  334,   54,  150,    7,   21,
  270,  274,  405,  296,  140,  141,  122,   41,  137,    1,
  202,  310,  277,  138,  304,  126,  305,  130,  133,   53,
   74,  134,  307,  328,    2,  136,  137,  386,  387,    3,
    4,  138,  138,   52,  139,    5,  142,  146,  151,  153,
  156,  157,  147,  148,  170,   39,  199,  179,  388,  180,
  172,  172,  172,  189,  172,  391,  200,  392,  181,  184,
  197,  257,  195,  196,  393,  172,  190,  396,   39,   39,
  203,  204,  397,  205,  206,  208,  209,  210,  211,  198,
  407,  214,  215,   78,  172,  219,  422,  222,   39,  235,
  221,   41,  223,  225,  246,  262,  217,   76,  155,  248,
  231,   39,  251,   39,   59,  258,  238,  259,  242,   52,
  260,  252,  263,  264,  265,  269,  127,  229,  182,  280,
  277,  241,   76,  243,  245,  287,  247,   73,  266,  268,
   94,  232,  272,   76,  273,  172,   39,   53,  291,  276,
   36,  110,    2,  143,   68,   39,   14,    3,    4,    3,
    4,  275,   15,    5,   39,    3,    4,   16,    3,    4,
   17,    2,  300,  186,  303,  110,    3,    4,   19,  187,
  188,   39,    5,   39,    3,    4,  312,   66,    3,    4,
   39,  110,  166,   15,  110,  110,  353,  416,   16,   14,
   39,   17,  324,  325,  327,   15,  329,   39,  110,   19,
   16,  335,   14,   17,    2,  157,   18,  110,   15,    3,
    4,   19,  157,   16,   39,    5,   17,    2,   39,   18,
  338,  347,    3,    4,   19,  137,  110,  110,    5,  110,
  138,   39,   76,   76,  137,   76,  137,   76,   39,  138,
  110,  138,  110,   76,  370,   47,   48,  338,  110,  110,
   39,   39,   50,  110,  110,   76,  375,  376,  377,  379,
  380,  381,   66,   53,  384,    3,    4,  385,   15,   39,
  367,  390,  233,   16,  110,  394,   17,  234,   76,   18,
   77,  110,   39,  110,   19,   66,   66,  244,  408,   39,
  110,   15,   15,  110,  261,  154,   16,   16,  110,   17,
   17,    9,  212,  110,  124,   66,  110,   19,   19,  213,
  216,   15,  110,   39,   52,  288,   16,  277,   66,   17,
   66,   47,   48,  125,   15,  110,   15,   19,   50,   16,
  176,   16,   17,  201,   17,  171,   51,  171,   66,  110,
   19,   52,   19,   96,   15,  123,   80,  286,   82,   16,
   52,  297,   17,   66,  239,  289,  240,  290,   95,   15,
   19,   84,   66,  293,   16,  301,  256,   17,   15,   86,
  171,   66,   83,   16,   98,   19,   17,   15,  294,  254,
  361,  337,   16,  285,   19,   17,  271,   83,   66,   75,
   66,   52,  295,   19,   15,  378,   15,   66,  139,   16,
   52,   16,   17,   15,   17,  171,  218,   66,   16,   52,
   19,   17,   19,   15,   66,  224,  139,  360,   16,   19,
   15,   17,  140,  207,   18,   16,  108,  306,   17,   19,
   52,   66,  255,  308,  236,   66,   19,   15,   56,   52,
  140,   15,   16,  267,   52,   17,   16,   52,   66,   17,
  337,  344,  237,   19,   15,   66,  302,   19,  230,   16,
   52,   15,   17,  312,  345,   55,   16,   66,   66,   17,
   19,  346,  389,   15,   15,  323,   52,   19,   16,   16,
  110,   17,   17,  348,  350,  110,   66,   66,   54,   19,
   19,  330,   15,   15,   52,   81,   78,   16,   16,   66,
   17,   17,  357,  366,   76,   15,   66,   93,   19,   19,
   16,   72,   15,   17,  119,  369,  120,   16,    9,  333,
   17,   19,  383,   74,    9,   44,   47,   48,   19,    9,
   66,  336,    9,   50,    9,  343,   15,  349,  351,  352,
    9,   16,  355,   79,   17,   81,  143,  356,  143,  363,
  143,  358,   19,   47,   48,   93,   94,  364,   83,   49,
   50,  365,   47,   48,  143,  143,   85,  143,   49,   50,
  368,   97,  371,    3,    4,  144,  253,  144,  374,  144,
  284,  382,    3,    4,   83,   83,  398,  145,  395,  145,
  399,  145,  400,  144,  144,  401,  144,    4,  404,  141,
  411,  406,  409,   47,   48,  145,  145,  412,  145,  410,
   50,  142,   47,   48,  359,  139,  413,  141,  141,   50,
  141,   47,   48,  139,  139,  414,  139,  415,   50,  142,
  142,  418,  142,  421,  419,   56,  420,  423,  424,  140,
  425,  426,   47,   48,  427,  428,  105,  140,  140,   50,
  140,   47,   48,  309,   44,  145,   47,   48,   50,   47,
   48,   73,   55,   50,    0,  362,   50,  279,  281,  282,
  283,  149,   47,   48,   55,    0,    2,    0,    0,   50,
   71,    3,    4,    0,    0,   54,    0,    5,   47,   48,
    0,   52,   81,   78,    0,   50,   88,   89,  311,    0,
    0,   76,    0,    0,   93,    0,    0,    0,   72,    0,
    0,  101,    0,  115,  116,  117,  118,    0,    0,    0,
   74,    0,   44,    0,    0,    0,   55,  314,  315,  316,
  318,  319,  320,  321,  322,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  132,    0,    0,
    0,    0,  137,    0,    0,    0,  342,    0,    0,    0,
    0,  143,    0,  143,  143,  143,  143,  143,    0,    0,
    0,  143,  143,    0,  143,    0,    0,    0,    0,    0,
    0,    0,    0,  152,    0,    0,    0,    0,    0,    0,
  144,    0,  144,  144,  144,  144,  144,    0,    0,    0,
  144,  144,  145,  144,  145,  145,  145,  145,  145,    0,
    0,    0,  145,  145,    0,  145,  141,  141,  141,  141,
  141,    0,    0,    0,  141,  141,    0,  141,  142,  142,
  142,  142,  142,    0,    0,    0,  142,  142,    0,  142,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         16,
   14,   41,   40,   18,    7,   41,   20,   44,   40,   59,
   61,   41,   41,   40,  257,   49,  257,   40,   21,   40,
  256,   23,   36,   37,  270,   39,  277,  278,   41,   41,
    7,  272,   41,   41,   14,   15,   40,   51,  284,  275,
   40,   52,   59,   59,   21,   41,   41,   59,   41,   41,
   40,   61,   66,  131,  132,  133,  134,   43,   40,   45,
   59,   59,   40,   59,   59,   67,   59,  143,  144,   59,
  146,   41,   41,   87,   42,   40,   90,  266,   92,   47,
   59,  157,  256,  257,  162,   59,   66,  121,    0,    1,
   41,   41,   59,   41,  105,  106,  265,   74,   41,  257,
  176,  256,  257,   41,   41,   61,   41,   41,   41,  123,
   22,   41,   41,   41,  272,   41,   59,   41,   41,  277,
  278,   59,  257,   45,   41,  283,  269,  269,   41,  258,
  258,  269,  112,  113,   41,   40,  270,   41,   41,   59,
  142,  143,  144,  158,  146,   41,  270,   41,   59,   59,
   59,  227,  166,  167,   41,  157,  158,   41,   40,   40,
  270,  270,   41,  180,  181,  182,  183,  184,  270,  171,
   41,  186,   40,   59,  176,  282,   41,   41,   40,   40,
  194,  158,   41,  198,   40,   59,  188,  189,   61,   59,
  207,   40,   59,   40,   40,  258,  213,  258,  215,   45,
  258,   59,  258,  258,  258,   40,  257,   59,  258,   59,
  257,   40,  214,  216,  217,   41,  219,  257,  235,  236,
  257,   59,  239,  225,  241,  227,   40,  241,  258,  246,
  257,  267,  272,  269,  257,   40,  257,  277,  278,  277,
  278,  244,  263,  283,   40,  277,  278,  268,  277,  278,
  271,  272,  269,  274,  271,  267,  277,  278,  279,  280,
  281,   40,  283,   40,  277,  278,  274,  257,  277,  278,
   40,  267,  272,  263,  267,  267,  275,  275,  268,  257,
   40,  271,  297,  298,  299,  263,  301,   40,  267,  279,
  268,  306,  257,  271,  272,  269,  274,  267,  263,  277,
  278,  279,  269,  268,   40,  283,  271,  272,   40,  274,
  312,  326,  277,  278,  279,  258,  267,  267,  283,  267,
  258,   40,  324,  325,  267,  327,  269,  329,   40,  267,
  267,  269,  267,  335,  349,  257,  258,  339,  267,  267,
   40,   40,  264,  267,  267,  347,  363,  364,  365,  366,
  367,  368,  257,  367,  371,  277,  278,  374,  263,   40,
   40,  378,   59,  268,  267,  382,  271,   59,  370,  274,
  256,  267,   40,  267,  279,  257,  257,  282,  395,   40,
  267,  263,  263,  267,  258,  258,  268,  268,  267,  271,
  271,   40,  273,  267,  256,  257,  267,  279,  279,  280,
  282,  263,  267,   40,   45,   41,  268,  257,  257,  271,
  257,  257,  258,  275,  263,  267,  263,  279,  264,  268,
  269,  268,  271,  270,  271,  274,   40,  274,  257,  267,
  279,   45,  279,   44,  263,   40,   59,  270,   59,  268,
   45,   59,  271,  257,  273,   41,  275,   41,   59,  263,
  279,   59,  257,   41,  268,   59,  270,  271,  263,   59,
  274,  257,   44,  268,   59,  279,  271,  263,   41,   59,
  275,  276,  268,   59,  279,  271,   40,   59,  257,  275,
  257,   45,   41,  279,  263,   40,  263,  257,   41,  268,
   45,  268,  271,  263,  271,  274,  273,  257,  268,   45,
  279,  271,  279,  263,  257,  275,   59,   59,  268,  279,
  263,  271,   41,   59,  274,  268,   41,   59,  271,  279,
   45,  257,  275,  257,   40,  257,  279,  263,   59,   45,
   59,  263,  268,   41,   45,  271,  268,   45,  257,  271,
  276,  273,   58,  279,  263,  257,   41,  279,   59,  268,
   45,  263,  271,  274,  273,   59,  268,  257,  257,  271,
  279,  273,   41,  263,  263,   59,   45,  279,  268,  268,
  267,  271,  271,  273,  273,  267,  257,  257,   59,  279,
  279,   59,  263,  263,   59,   59,   59,  268,  268,  257,
  271,  271,  273,  273,   59,  263,  257,   59,  279,  279,
  268,   59,  263,  271,   60,  273,   62,  268,  257,   59,
  271,  279,  273,   59,  263,   59,  257,  258,  279,  268,
  257,   59,  271,  264,  273,  275,  263,   59,  275,  275,
  279,  268,  275,  256,  271,  256,   41,  275,   43,   40,
   45,  275,  279,  257,  258,  256,  257,   40,  256,  263,
  264,   40,  257,  258,   59,   60,  256,   62,  263,  264,
   40,  256,   40,  277,  278,   41,  256,   43,   40,   45,
  256,   40,  277,  278,  256,  257,   59,   41,   40,   43,
   59,   45,   59,   59,   60,   59,   62,    0,   59,   41,
  275,   59,   59,  257,  258,   59,   60,  275,   62,   59,
  264,   41,  257,  258,  256,  258,  275,   59,   60,  264,
   62,  257,  258,  266,  267,  275,  269,  275,  264,   59,
   60,  275,   62,   59,  275,  256,  275,  275,  275,  258,
  256,  275,  257,  258,   59,  275,   59,  266,  267,  264,
  269,  257,  258,  277,   10,  110,  257,  258,  264,  257,
  258,  257,  256,  264,   -1,  339,  264,  249,  250,  251,
  252,  114,  257,  258,   14,   -1,  272,   -1,   -1,  264,
   20,  277,  278,   -1,   -1,  256,   -1,  283,  257,  258,
   -1,  256,  256,  256,   -1,  264,   36,   37,  280,   -1,
   -1,  256,   -1,   -1,  256,   -1,   -1,   -1,  256,   -1,
   -1,   51,   -1,  259,  260,  261,  262,   -1,   -1,   -1,
  256,   -1,  256,   -1,   -1,   -1,   66,  288,  289,  290,
  291,  292,  293,  294,  295,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   87,   -1,   -1,
   -1,   -1,   92,   -1,   -1,   -1,  317,   -1,   -1,   -1,
   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,  269,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  123,   -1,   -1,   -1,   -1,   -1,   -1,
  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,
  266,  267,  256,  269,  258,  259,  260,  261,  262,   -1,
   -1,   -1,  266,  267,   -1,  269,  258,  259,  260,  261,
  262,   -1,   -1,   -1,  266,  267,   -1,  269,  258,  259,
  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,  269,
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
"control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"control : error_control",
"error_control : REPEAT IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR CTE_ULONG ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' ')' bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG bloque_repeat",
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')'",
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

//#line 291 "Gramatica.y"

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
//#line 727 "Parser.java"
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
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado " +val_peek(2).sval + "}");}
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
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
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
case 116:
//#line 224 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 117:
//#line 225 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 118:
//#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 119:
//#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 120:
//#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 121:
//#line 229 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 122:
//#line 230 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 123:
//#line 231 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 124:
//#line 232 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 125:
//#line 234 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 126:
//#line 235 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 127:
//#line 236 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 128:
//#line 237 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 129:
//#line 238 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 130:
//#line 239 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 131:
//#line 240 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 132:
//#line 241 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 133:
//#line 242 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 134:
//#line 243 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 135:
//#line 244 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 136:
//#line 245 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 138:
//#line 252 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 140:
//#line 256 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 142:
//#line 260 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  val_peek(1).sval + "}");}
break;
case 144:
//#line 264 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 145:
//#line 265 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 146:
//#line 268 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 147:
//#line 269 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 149:
//#line 274 "Gramatica.y"
{chequearFactorNegado();}
break;
case 150:
//#line 275 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + val_peek(0).sval + "}");}
break;
case 151:
//#line 276 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + val_peek(0).sval + "}");}
break;
case 152:
//#line 277 "Gramatica.y"
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
