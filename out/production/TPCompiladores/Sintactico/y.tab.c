#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "Gramatica.y"
package Sintactico;
import Principal.*;
import CodigoIntermedio.*;
import java.util.ArrayList;
#line 11 "y.tab.c"
#define IDENTIFICADOR 257
#define CTE_ULONG 258
#define MAYOR_IGUAL 259
#define MENOR_IGUAL 260
#define IGUAL_IGUAL 261
#define DISTINTO 262
#define ASIGNACION 263
#define CTE_DOUBLE 264
#define CADENA 265
#define AND 266
#define OR 267
#define IF 268
#define THEN 269
#define ENDIF 270
#define PRINT 271
#define FUNC 272
#define RETURN 273
#define BEGIN 274
#define END 275
#define BREAK 276
#define ULONG 277
#define DOUBLE 278
#define REPEAT 279
#define PRE 280
#define TRY 281
#define CATCH 282
#define TYPEDEF 283
#define ELSE 284
#define YYERRCODE 256
short yylhs[] = {                                        -1,
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
   47,   47,   47,   55,   54,   54,   54,   54,   57,   57,
   57,   57,   57,   57,   57,   57,   57,   57,   57,   57,
   57,   57,   57,   57,   57,   57,   56,   56,   58,   58,
   58,   58,   58,   38,   38,   59,   59,   27,   27,   31,
   31,   31,   33,   33,   33,   61,   61,   61,   61,   61,
   60,   60,   60,   60,   60,   60,
};
short yylen[] = {                                         2,
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
    2,    1,    1,    2,    8,   10,    9,    1,    7,    7,
    7,    7,    7,    7,    7,    3,    8,    9,    9,    9,
    9,    9,    9,    9,   10,    5,    5,    1,    4,    4,
    4,    4,    5,    1,    3,    1,    3,    1,    3,    1,
    3,    3,    3,    3,    1,    2,    1,    1,    1,    1,
    1,    1,    1,    1,    1,    1,
};
short yydefred[] = {                                      0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  110,  113,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   39,   62,    0,
   68,   70,   91,   97,    0,    0,    0,    0,    4,    7,
    0,    0,    0,  107,   35,  111,    0,    0,    0,    0,
    0,  109,  132,  133,    0,  138,  158,    0,  178,    0,
  177,    0,    0,  180,    0,  175,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   49,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  120,    0,    1,    0,
    0,   12,   11,   20,   14,   21,   15,   22,   16,   24,
   17,   23,   18,   28,   26,    0,    0,    0,    0,    0,
    0,   33,  108,   29,    0,   34,   30,    0,    0,    0,
    0,    0,    0,  134,  131,    0,    0,    0,   65,    0,
    0,    0,    0,   92,  176,    0,    0,    0,   73,    0,
   72,   75,    0,    0,    0,   87,   13,    8,   51,    0,
   50,    0,    0,    0,    0,   98,    0,   99,    0,  121,
  119,  184,  185,  183,  186,  181,  182,    0,    0,    0,
   71,    0,   69,  114,    0,    0,  117,    0,  116,  115,
    0,  105,    0,    0,  146,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   95,   90,   93,   88,   94,   89,
  173,  174,    0,   80,   82,    0,   81,   86,   52,   48,
    0,    0,    0,    0,    0,  103,    0,  100,   96,  101,
    0,    0,    0,    0,    0,   79,  118,  112,    0,    0,
    0,  123,    0,    0,    0,    0,    0,    0,    0,  160,
  162,    0,  161,  159,    0,    0,    0,    0,   83,   66,
    0,    0,    0,    0,    0,    0,  102,  104,    0,    0,
    0,   31,    0,    0,    0,    0,    0,    0,    0,  156,
    0,    0,  163,  157,    0,    0,   78,   76,    0,   84,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   77,   74,   85,   67,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  140,  143,  144,  145,    0,  142,  141,    0,    0,    0,
    0,    0,    0,  139,    0,    0,   41,   43,   44,    0,
   46,   45,   42,   40,    0,  126,  127,    0,  128,  125,
  124,  147,  135,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   57,    0,   55,   59,   47,   38,  106,    0,
  129,  122,  137,  152,  153,  154,    0,  151,  150,  149,
  148,   60,   58,   54,   56,  155,  136,
};
short yydgoto[] = {                                       6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   74,   34,   35,   36,   37,   10,   52,   11,  241,
   12,   86,  221,  347,   38,   87,   92,  374,  375,  376,
   93,   39,   94,   40,  150,  151,   41,   95,   42,  152,
   43,  166,   44,  227,   54,   13,   62,   14,   96,   15,
   97,  356,  242,   63,   64,   65,   66,   67,   98,  178,
   76,
};
short yysindex[] = {                                    -84,
   34,  -29,    0,    0, -220,    0,   59,    0,    0, -182,
  -15,    0,   -4,    0,    0,  401,  451,  -18,   36,  310,
  152,  -38,  -42,   59,  474,  194,    0,    0,    0,  -45,
   78,  155,  302,  348,    0,  368,    0,    0,    0, -162,
    0,    0,    0,    0,  -39, -127,   50,  451,    0,    0,
   74,  112,  370,    0,    0,    0,   84,   -9,  115,   15,
  209,    0,    0,    0,   99,    0,    0,  132,    0,  446,
    0,   46,  451,    0,   24,    0,   24,  221,  103,  -34,
  414,  122, -225, -110,  -50,  106,    0, -114, -141, -104,
  -81,  547,  101,   24,    2,  140,    0,  -80,    0,   74,
  474,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  221,  -23,  146,  148, -127,
 -127,    0,    0,    0,  -67,    0,    0,  160,  123,  240,
  451,  423,  451,    0,    0,  161,  310,  376,    0,  101,
   26,   28,   29,    0,    0,  451,  451,  310,    0,  -75,
    0,    0,  142,  -68,  165,    0,    0,    0,    0, -136,
    0,  451,  468,  451,   91,    0, -177,    0, -114,    0,
    0,    0,    0,    0,    0,    0,    0,  451,  451,  451,
    0,  451,    0,    0,  451,  -61,    0,   51,    0,    0,
  -30,    0,  451,  431,    0,  451,  241,  260,   23,  442,
   42,   47,  451,  261,    0,    0,    0,    0,    0,    0,
    0,    0,  280,    0,    0, -165,    0,    0,    0,    0,
  159,  547,  491,  267,  329,    0,  327,    0,    0,    0,
  101,   24,   24,  -80,  547,    0,    0,    0,  -32, -127,
  359,    0,   52,  460,   68,  125,  170,  151,  184,    0,
    0,  133,    0,    0,   72,  380,  405,  281,    0,    0,
  168,  175,  185,  -35,  186,  202,    0,    0,  -12,  387,
  420,    0,  408,  411,  -11,  422,  435,  451,  434,    0,
  451,  451,    0,    0,  448,  451,    0,    0,  426,    0,
 -116,  452,  484,  489,    4,  494,  504,  487,   41,  495,
  498,  278,  289,  295,  -46,  296,  297,   77,  465,   82,
  139,   89,  301,  108,    0,    0,    0,    0,  305,  305,
  305,  -26,  305,  305,  305,  323,  323,   94,  323,  323,
    0,    0,    0,    0, -236,    0,    0,  524,  527,   21,
  533,  538,  549,    0,  551,  306,    0,    0,    0, -140,
    0,    0,    0,    0,  355,    0,    0,  -72,    0,    0,
    0,    0,    0,  339,  341,  344,  -43,  346,  347,  353,
  356,  427,    0,  177,    0,    0,    0,    0,    0,    6,
    0,    0,    0,    0,    0,    0, -228,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  636,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  391,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  558,    0,    0,
    0,    0,    0,    0,  440,    0,  456,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   62,  506,  570,    0,    0,    0,   76,    0,    0,
  638,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  457,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  100,    0,    0,    0,    0,    0,    0,    0,    0,
  534,  582,  594,  120,  396,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  374,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  374,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  586,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   71,   39,    0,   44,  654,    0,  -21,  361,    0,    0,
    0,   -1,    0,    0,  624,    0,  -19,  294,  640,    0,
    0,  566, -129,  413,    0,    0,  522,    0,  283,    0,
  -53,    0,   25,  637,  -27,  399,    0,  672,    0,    0,
    0,  -57,    0,    0,    0,    0,    0,    0,   40,    0,
    0, -160,    0,  606,    0,  611,    0,    0,  488,    0,
   -8,
};
#define YYTABLESIZE 981
short yytable[] = {                                      33,
  117,   48,   73,   91,  103,   33,  156,  269,  162,  240,
   46,   33,  335,  105,  350,  387,  140,  187,   33,  362,
   33,   48,   33,  295,   33,   91,   91,  396,  298,  305,
  131,  168,  159,  224,  225,   48,   47,  160,  363,  103,
   75,   77,  183,   55,  323,   49,  397,  304,  132,  125,
   50,  154,   91,   59,   48,   33,  149,  149,   33,   33,
  103,  367,   99,  250,  145,  146,  206,   50,  208,  210,
  147,   24,   59,   23,   51,   80,   33,   33,  228,  366,
   33,  328,  253,   60,  118,  119,  144,  254,  186,    2,
  259,  238,  273,  264,  149,  101,  165,   91,   48,  327,
  191,   91,  166,   50,  260,   75,  116,  103,  276,  229,
  120,  230,  285,  121,   33,  377,  164,  338,  261,  219,
  166,  220,  341,   48,  231,  216,  213,   33,   33,  343,
   48,  149,  165,  346,  164,   33,  107,  211,  212,  317,
  167,   59,   48,  179,   50,  180,   33,  161,  345,    3,
    4,   33,  358,  318,  133,  125,  188,  137,   53,  165,
  165,   48,  196,   33,  164,  277,  357,  359,  360,  361,
  124,  138,    1,  284,  170,  171,  103,  169,  165,  342,
  184,   48,  103,  381,  355,  185,  189,    2,  190,  192,
  281,   85,    3,    4,  214,   33,   33,  382,    5,  193,
  203,  217,   33,  232,  233,  218,   83,   48,  236,  278,
  104,   33,   84,  109,   68,   69,   48,  262,   81,  270,
  271,   71,  294,  282,   17,   33,  103,   45,  334,   18,
  155,  386,   19,   48,    3,    4,  103,    3,    4,  149,
   21,  239,   22,   88,    3,    4,   33,  346,   48,  299,
   78,   56,   16,    3,    4,  182,   33,  181,   17,   33,
   48,  322,  123,   18,    3,    4,   19,    2,  182,   57,
  134,   16,    3,    4,   21,   58,   22,   17,    5,   48,
   48,  205,   18,  207,  209,   19,    2,  182,   57,  182,
   16,    3,    4,   21,   58,   22,   17,    5,  197,   48,
   48,   18,  141,  142,   19,    2,  237,   20,  182,  143,
    3,    4,   21,  182,   22,   16,    5,  166,  182,   48,
   48,   17,    3,    4,  373,  265,   18,  166,  166,   19,
    2,  164,   20,  106,  182,    3,    4,   21,  182,   22,
   81,    5,  164,  182,   33,   48,   17,   81,  182,   48,
  355,   18,  373,   17,   19,  182,  128,   53,   18,   81,
  111,   19,   21,   58,   22,   17,   48,  122,  123,   21,
   18,  153,   33,   19,  182,  165,  148,  157,   81,   81,
  181,   21,   89,   22,   17,   17,  165,  266,  283,   18,
   18,  182,   19,   19,  181,  194,  158,  195,   81,  182,
   21,   21,   22,   22,   17,  182,  113,   81,   83,   18,
  108,  215,   19,   17,   84,  148,  144,  272,   18,  286,
   21,   19,   22,  279,   81,  280,  115,  300,  127,   21,
   17,   22,  292,   81,  106,   18,  167,  290,   19,   17,
   72,  148,  293,  296,   18,   73,   21,   19,   22,  106,
   81,  394,  372,  138,  167,   21,   17,   22,   73,  297,
  301,   18,  200,  288,   19,   81,  302,   73,  102,  303,
  244,   17,   21,  309,   22,   73,   18,   81,   73,   19,
  306,  136,  251,   17,  316,  393,   73,   21,   18,   22,
   73,   19,  319,  307,  148,   73,   81,   81,   64,   21,
  274,   22,   17,   17,   73,  339,  313,   18,   18,   73,
   19,   19,   73,  247,   63,   61,   81,   81,   21,   21,
   22,   22,   17,   17,  320,  226,  223,   18,   18,  321,
   19,   19,  249,  256,  324,   73,   81,   81,   21,   21,
   22,   22,   17,   17,  325,  326,  168,   18,   18,  263,
   19,   19,  331,  329,  257,  289,  330,  110,   21,   21,
   22,   22,   81,  332,  168,  168,   81,  168,   17,  333,
  336,  337,   17,   18,  169,  344,   19,   18,  346,  355,
   19,  372,  364,   81,   21,  365,   22,  268,   21,   17,
   22,  368,  169,  169,   18,  169,  369,   19,  179,  179,
  179,  267,  179,  112,  179,   21,  176,  370,  177,  371,
  170,  379,  170,  383,  170,  384,  179,  179,  385,  179,
  388,  389,  171,  114,  171,  126,  171,  390,  170,  170,
  391,  170,  141,  142,  172,    2,  172,    5,  172,  143,
  171,  171,   69,  171,  130,   90,  106,  106,  380,   53,
  163,  167,  172,  172,   79,  172,  395,   68,   69,  291,
  287,  167,  167,   70,   71,  135,   61,  130,    0,  234,
   68,   69,    0,   82,    0,    0,   70,   71,    0,   68,
   69,  315,  392,  222,  222,  222,   71,   68,   69,    0,
   68,   69,    0,    0,   71,   64,    0,   71,   68,   69,
    0,  139,   68,   69,    0,   71,  235,   68,   69,   71,
  129,   63,   61,   61,   71,    0,   68,   69,    0,    0,
    0,   68,   69,   71,   68,   69,    0,    0,   71,    0,
  100,   71,  348,  349,  351,  352,  353,  354,    0,    0,
    0,    0,    0,    0,  222,    2,    0,   68,   69,    0,
    3,    4,    0,    0,   71,    0,    5,    0,    0,    0,
    0,  168,  378,  168,  168,  168,  168,  168,    0,    0,
    0,  168,  168,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  198,    0,    0,    0,    0,    0,  169,
  204,  169,  169,  169,  169,  169,    0,    0,    0,  169,
  169,    0,  199,  201,  202,  172,  173,  174,  175,    0,
    0,    0,    0,  179,    0,  179,  179,  179,  179,  179,
    0,    0,    0,  179,  179,  170,    0,  170,  170,  170,
  170,  170,    0,    0,    0,  170,  170,  171,    0,  171,
  171,  171,  171,  171,    0,    0,    0,  171,  171,  172,
  248,  172,  172,  172,  172,  172,    0,    0,    0,  172,
  172,    0,    0,    0,  243,  245,  258,  246,    0,    0,
    0,  252,    0,    0,  255,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  275,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  308,
  310,    0,  311,  312,    0,    0,    0,  314,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  340,
};
short yycheck[] = {                                       1,
   40,   40,   45,   23,   26,    7,   41,   40,   59,   40,
   40,   13,   59,   59,   41,   59,   70,   41,   20,  256,
   22,   40,   24,   59,   26,   45,   46,  256,   41,   41,
   40,   89,  258,  163,  164,   40,  257,  263,  275,   61,
   16,   17,   41,   59,   41,    7,  275,   59,   58,   44,
    7,   79,   72,   58,   40,   57,   78,   79,   60,   61,
   82,   41,   24,   41,   73,   42,   41,   24,   41,   41,
   47,    1,   58,   40,  257,   40,   78,   79,  256,   59,
   82,   41,   41,   13,   45,   46,   41,   41,  116,  272,
  256,   41,   41,  223,  116,   25,  274,  117,   40,   59,
  120,  121,   41,   60,  270,   81,  269,  129,   41,  167,
   61,  169,   41,   40,  116,  256,   41,   41,  284,  256,
   59,  258,   41,   40,  178,  153,  148,  129,  130,   41,
   40,  153,  274,  274,   59,  137,   59,  146,  147,  256,
  282,   58,   40,   43,  101,   45,  148,  258,   41,  277,
  278,  153,   59,  270,   40,   44,  117,   59,   59,  274,
   41,   40,   40,  165,   59,   41,  327,  328,  329,  330,
   59,   40,  257,   41,  256,  257,  198,  282,   59,   41,
   41,   40,  204,  256,  257,  266,   41,  272,   41,  257,
   40,   40,  277,  278,  270,  197,  198,  358,  283,   40,
   40,  270,  204,  179,  180,   41,  257,   40,  270,   40,
  256,  213,  263,   59,  257,  258,   40,   59,  257,  239,
  240,  264,  258,   40,  263,  227,  248,  257,  275,  268,
  265,  275,  271,   40,  277,  278,  258,  277,  278,  261,
  279,  272,  281,  282,  277,  278,  248,  274,   40,  269,
  269,  256,  257,  277,  278,  267,  258,  256,  263,  261,
   40,  258,  257,  268,  277,  278,  271,  272,  267,  274,
  256,  257,  277,  278,  279,  280,  281,  263,  283,   40,
   40,  256,  268,  256,  256,  271,  272,  267,  274,  267,
  257,  277,  278,  279,  280,  281,  263,  283,   59,   40,
   40,  268,  257,  258,  271,  272,  256,  274,  267,  264,
  277,  278,  279,  267,  281,  257,  283,  256,  267,   40,
   40,  263,  277,  278,  346,   59,  268,  266,  267,  271,
  272,  256,  274,  256,  267,  277,  278,  279,  267,  281,
  257,  283,  267,  267,  346,   40,  263,  257,  267,   40,
  257,  268,  374,  263,  271,  267,  273,  258,  268,  257,
   59,  271,  279,  280,  281,  263,   40,  256,  257,  279,
  268,  269,  374,  271,  267,  256,  274,  256,  257,  257,
  256,  279,   22,  281,  263,  263,  267,   59,  256,  268,
  268,  267,  271,  271,  256,  273,  275,  275,  257,  267,
  279,  279,  281,  281,  263,  267,   59,  257,  257,  268,
  256,  270,  271,  263,  263,  274,   41,   59,  268,   40,
  279,  271,  281,  273,  257,  275,   59,   41,   59,  279,
  263,  281,  258,  257,   44,  268,   41,  270,  271,  263,
   40,  274,  258,  258,  268,   45,  279,  271,  281,   59,
  257,  275,  276,   40,   59,  279,  263,  281,   45,  258,
   41,  268,   40,   59,  271,  257,   59,   45,  275,   59,
   40,  263,  279,   40,  281,   45,  268,  257,   45,  271,
   59,  273,   41,  263,   59,   59,   45,  279,  268,  281,
   45,  271,   41,   59,  274,   45,  257,  257,   59,  279,
   41,  281,  263,  263,   45,   41,   59,  268,  268,   45,
  271,  271,   45,  273,   59,   59,  257,  257,  279,  279,
  281,  281,  263,  263,   41,  165,   59,  268,  268,   41,
  271,  271,  273,  273,   41,   45,  257,  257,  279,  279,
  281,  281,  263,  263,   41,   59,   41,  268,  268,   59,
  271,  271,  275,   59,  275,  275,   59,  256,  279,  279,
  281,  281,  257,  275,   59,   60,  257,   62,  263,  275,
  275,  275,  263,  268,   41,  275,  271,  268,  274,  257,
  271,  276,   59,  257,  279,   59,  281,  227,  279,  263,
  281,   59,   59,   60,  268,   62,   59,  271,   41,   42,
   43,  275,   45,  256,   47,  279,   60,   59,   62,   59,
   41,  257,   43,  275,   45,  275,   59,   60,  275,   62,
  275,  275,   41,  256,   43,  256,   45,  275,   59,   60,
  275,   62,  257,  258,   41,    0,   43,    0,   45,  264,
   59,   60,  269,   62,   59,   22,  256,  257,  355,   10,
   85,  256,   59,   60,   18,   62,  374,  257,  258,  261,
  256,  266,  267,  263,  264,   60,   13,   57,   -1,  182,
  257,  258,   -1,   20,   -1,   -1,  263,  264,   -1,  257,
  258,  256,  256,  162,  163,  164,  264,  257,  258,   -1,
  257,  258,   -1,   -1,  264,  256,   -1,  264,  257,  258,
   -1,  256,  257,  258,   -1,  264,  185,  257,  258,  264,
   57,  256,  256,   60,  264,   -1,  257,  258,   -1,   -1,
   -1,  257,  258,  264,  257,  258,   -1,   -1,  264,   -1,
  257,  264,  320,  321,  322,  323,  324,  325,   -1,   -1,
   -1,   -1,   -1,   -1,  223,  272,   -1,  257,  258,   -1,
  277,  278,   -1,   -1,  264,   -1,  283,   -1,   -1,   -1,
   -1,  256,  350,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  130,   -1,   -1,   -1,   -1,   -1,  256,
  137,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,  131,  132,  133,  259,  260,  261,  262,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
  197,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,   -1,   -1,  193,  194,  213,  196,   -1,   -1,
   -1,  200,   -1,   -1,  203,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  244,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  278,
  279,   -1,  281,  282,   -1,   -1,   -1,  286,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  309,
};
#define YYFINAL 6
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 284
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,"IDENTIFICADOR","CTE_ULONG","MAYOR_IGUAL","MENOR_IGUAL",
"IGUAL_IGUAL","DISTINTO","ASIGNACION","CTE_DOUBLE","CADENA","AND","OR","IF",
"THEN","ENDIF","PRINT","FUNC","RETURN","BEGIN","END","BREAK","ULONG","DOUBLE",
"REPEAT","PRE","TRY","CATCH","TYPEDEF","ELSE",
};
char *yyrule[] = {
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
"bloque_ejecucion_funcion : BEGIN pre_condicion ';' bloque_sentencias RETURN '(' condicion ')' ';' END",
"bloque_ejecucion_funcion : BEGIN pre_condicion ';' RETURN '(' condicion ')' ';' END",
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
#endif
#ifndef YYSTYPE
typedef int YYSTYPE;
#endif
#define yyclearin (yychar=(-1))
#define yyerrok (yyerrflag=0)
#ifdef YYSTACKSIZE
#ifndef YYMAXDEPTH
#define YYMAXDEPTH YYSTACKSIZE
#endif
#else
#ifdef YYMAXDEPTH
#define YYSTACKSIZE YYMAXDEPTH
#else
#define YYSTACKSIZE 500
#define YYMAXDEPTH 500
#endif
#endif
int yydebug;
int yynerrs;
int yyerrflag;
int yychar;
short *yyssp;
YYSTYPE *yyvsp;
YYSTYPE yyval;
YYSTYPE yylval;
short yyss[YYSTACKSIZE];
YYSTYPE yyvs[YYSTACKSIZE];
#define yystacksize YYSTACKSIZE
#line 715 "Gramatica.y"

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
#line 718 "y.tab.c"
#define YYABORT goto yyabort
#define YYACCEPT goto yyaccept
#define YYERROR goto yyerrlab
int
yyparse()
{
    register int yym, yyn, yystate;
#if YYDEBUG
    register char *yys;
    extern char *getenv();

    if (yys = getenv("YYDEBUG"))
    {
        yyn = *yys;
        if (yyn >= '0' && yyn <= '9')
            yydebug = yyn - '0';
    }
#endif

    yynerrs = 0;
    yyerrflag = 0;
    yychar = (-1);

    yyssp = yyss;
    yyvsp = yyvs;
    *yyssp = yystate = 0;

yyloop:
    if (yyn = yydefred[yystate]) goto yyreduce;
    if (yychar < 0)
    {
        if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, reading %d (%s)\n", yystate,
                    yychar, yys);
        }
#endif
    }
    if ((yyn = yysindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: state %d, shifting to state %d (%s)\n",
                    yystate, yytable[yyn],yyrule[yyn]);
#endif
        if (yyssp >= yyss + yystacksize - 1)
        {
            goto yyoverflow;
        }
        *++yyssp = yystate = yytable[yyn];
        *++yyvsp = yylval;
        yychar = (-1);
        if (yyerrflag > 0)  --yyerrflag;
        goto yyloop;
    }
    if ((yyn = yyrindex[yystate]) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
    {
        yyn = yytable[yyn];
        goto yyreduce;
    }
    if (yyerrflag) goto yyinrecovery;
#ifdef lint
    goto yynewerror;
#endif
yynewerror:
    yyerror("syntax error");
#ifdef lint
    goto yyerrlab;
#endif
yyerrlab:
    ++yynerrs;
yyinrecovery:
    if (yyerrflag < 3)
    {
        yyerrflag = 3;
        for (;;)
        {
            if ((yyn = yysindex[*yyssp]) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: state %d, error recovery shifting\
 to state %d\n", *yyssp, yytable[yyn]);
#endif
                if (yyssp >= yyss + yystacksize - 1)
                {
                    goto yyoverflow;
                }
                *++yyssp = yystate = yytable[yyn];
                *++yyvsp = yylval;
                goto yyloop;
            }
            else
            {
#if YYDEBUG
                if (yydebug)
                    printf("yydebug: error recovery discarding state %d\n",
                            *yyssp);
#endif
                if (yyssp <= yyss) goto yyabort;
                --yyssp;
                --yyvsp;
            }
        }
    }
    else
    {
        if (yychar == 0) goto yyabort;
#if YYDEBUG
        if (yydebug)
        {
            yys = 0;
            if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
            if (!yys) yys = "illegal-symbol";
            printf("yydebug: state %d, error recovery discards token %d (%s)\n",
                    yystate, yychar, yys);
        }
#endif
        yychar = (-1);
        goto yyloop;
    }
yyreduce:
#if YYDEBUG
    if (yydebug)
        printf("yydebug: state %d, reducing by rule %d (%s)\n",
                yystate, yyn, yyrule[yyn]);
#endif
    yym = yylen[yyn];
    yyval = yyvsp[1-yym];
    switch (yyn)
    {
case 1:
#line 14 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +yyvsp[-2].sval + "'}");}
break;
case 2:
#line 15 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +yyvsp[-1].sval + "'}");}
break;
case 4:
#line 19 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 5:
#line 20 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 12:
#line 39 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 13:
#line 40 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 20:
#line 53 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
#line 54 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
#line 55 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
#line 56 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
#line 57 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
#line 65 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
#line 70 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");
    	        String tipoVariable = yyvsp[-2].sval;
    	        lista_variables = (ArrayList<String>)yyvsp[-1].obj;
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
#line 90 "Gramatica.y"
{
                Main.tablaSimbolos.getDatos(yyvsp[-1].sval).setTipo(yyvsp[-2].sval);
    	        }
break;
case 31:
#line 93 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + yyvsp[-4].sval +"'}");}
break;
case 33:
#line 98 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
#line 99 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
#line 100 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + yyvsp[-1].sval + "}");}
break;
case 36:
#line 106 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 37:
#line 108 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 38:
#line 111 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if((yyvsp[-6].sval != null) && (yyvsp[-4].sval != null)){
            Terceto t = new Terceto("+", yyvsp[-6].sval, yyvsp[-2].sval);
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
#line 126 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
#line 127 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 42:
#line 128 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 43:
#line 129 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 44:
#line 130 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
#line 131 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 46:
#line 132 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 47:
#line 133 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 48:
#line 136 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion del repeat: "+ yyvsp[-2].sval + " := "+ yyvsp[0].sval + "}");
                    String ambitoVariable = Main.tablaSimbolos.verificarAmbito(yyvsp[-2].sval, ambito);
                    if(ambitoVariable != null) {
                        String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                        if(tipoIdentificador.equals("ULONG")){
                            Terceto t = new Terceto(":=", ambitoVariable, yyvsp[0].sval);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.apilar(t.getNumero());
                            yyval = new ParserVal(ambitoVariable);
                        }
                        else
                            System.out.println("Error semántico: Linea " + Lexico.linea + " los tipos son incompatibles");
                    }
                    else
                        System.out.println("Error semántico: Linea " + Lexico.linea + " la variable " + yyvsp[-2].sval +" no fue declarada");
                    }
break;
case 49:
#line 153 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 50:
#line 156 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 51:
#line 157 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 52:
#line 158 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 53:
#line 162 "Gramatica.y"
{
                                Operando op = (Operando)yyvsp[0].obj;
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
#line 189 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 61:
#line 192 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + yyvsp[-2].sval + ":= " + yyvsp[0].sval +"}");
            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(yyvsp[-2].sval, ambito);
            if(ambitoVariable != null){
                String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                Operando op = (Operando)yyvsp[0].obj;
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
                System.out.println("Error semántico: Linea " + Lexico.linea + " la variable " + yyvsp[-2].sval +" no fue declarada");
            }

        }
break;
case 63:
#line 217 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 64:
#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 65:
#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 66:
#line 223 "Gramatica.y"
{
            if(yyvsp[-3].sval != null){
                adminTercetos.desapilar();
                }
            }
break;
case 67:
#line 228 "Gramatica.y"
{
	        if(yyvsp[-5].sval != null){
                 adminTercetos.desapilar();
                 }
	 }
break;
case 69:
#line 238 "Gramatica.y"
{

                System.out.println("ENTRO A CONDICION *****************************");
                if(yyvsp[-1].sval != null){
                    System.out.println("ENTRO AL IF *****************************");
                    Terceto t = new Terceto("BF", yyvsp[-1].sval, null);
                    adminTercetos.agregarTerceto(t);
                    adminTercetos.apilar(t.getNumero());
                    yyval = new ParserVal(yyvsp[-1].sval);
                }
                else
                    yyval = new ParserVal(null);
              }
break;
case 71:
#line 254 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 72:
#line 257 "Gramatica.y"
{
                adminTercetos.desapilar(); /*para completar BF*/
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.apilar(t.getNumero());

            }
break;
case 76:
#line 273 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 77:
#line 274 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 78:
#line 275 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 79:
#line 278 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 80:
#line 279 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 81:
#line 280 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 82:
#line 281 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 83:
#line 282 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 84:
#line 283 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 85:
#line 284 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 86:
#line 288 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[-1].sval  + "'}");
           Terceto t = new Terceto("Impresion", yyvsp[-1].sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 87:
#line 293 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[0].sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 88:
#line 300 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");
                if (yyvsp[-1].sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(yyvsp[-3].sval, ambito);
                    if(ambitoFuncion != null){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                }
            }
break;
case 89:
#line 310 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");
                 if (yyvsp[-1].sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(yyvsp[-3].sval, ambito);
                    if(ambitoFuncion != null){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                }
            }
break;
case 90:
#line 320 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");
                 if (yyvsp[-1].sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(yyvsp[-3].sval, ambito);
                    if(ambitoFuncion != null){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                    }
                    else
                        System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+yyvsp[-3].sval+" esta fuera de alcance");
                 }
            }
break;
case 92:
#line 334 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 93:
#line 335 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
#line 336 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
#line 337 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
#line 346 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 99:
#line 347 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 100:
#line 348 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 101:
#line 349 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 105:
#line 359 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);
			        lista_variables = (ArrayList<String>) yyvsp[-2].obj;
			        lista_variables.add(yyvsp[0].sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 106:
#line 364 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");
			                        lista_variables.add(yyvsp[0].sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 108:
#line 372 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 109:
#line 376 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ yyvsp[0].sval +"'" );
            if(yyvsp[-1].sval != null){ /*si se declaró bien*/
                ambito = ambito.substring(0,ambito.lastIndexOf("@"));
                Terceto t = new Terceto("FinFuncion", yyvsp[-1].sval, null);
                adminTercetos.agregarTerceto(t);
                yyval = new ParserVal(yyvsp[-1].sval);
            }
            else
                 yyval = new ParserVal(null);
         }
break;
case 111:
#line 389 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 112:
#line 392 "Gramatica.y"
{
                    parametroCopiaValor = yyvsp[-1].sval;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = yyvsp[-3].sval + "@" + ambito;
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema(yyvsp[-3].sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("NombreFuncion");
                            Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);

                            ambito = ambito + "@" + yyvsp[-3].sval;
                            Main.tablaSimbolos.reemplazarLexema(parametroCopiaValor, parametroCopiaValor +"@"+ ambito); /* Se agrega el ambito al parametro (nombre de la función)*/

                            Terceto t = new Terceto("ComienzaFuncion", nuevoLexema, null);
                            adminTercetos.agregarTerceto(t);
                            adminTercetos.agregarFuncion(nuevoLexema);

                            yyval = new ParserVal(nuevoLexema);
                        }
                        else{
                            System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {La funcion '" + yyvsp[-3].sval + "' ya fue declarada en este ámbito}");
                            yyval = new ParserVal(null);  /* se setea null para luego comprobar si se declaró o no*/
                        }
                    }
                    parametroCopiaValor = "";
                    }
break;
case 114:
#line 421 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 115:
#line 422 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 116:
#line 423 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 117:
#line 424 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 118:
#line 425 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 119:
#line 428 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(yyvsp[0].sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(yyvsp[-1].sval);
                Main.tablaSimbolos.setDatosSimbolo(yyvsp[0].sval, ds);
                yyval = new ParserVal(yyvsp[0].sval);

                }
break;
case 121:
#line 439 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 124:
#line 447 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 125:
#line 448 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 126:
#line 449 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 127:
#line 450 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 128:
#line 451 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 129:
#line 452 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 134:
#line 465 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 139:
#line 475 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 140:
#line 476 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 141:
#line 477 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 142:
#line 478 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 143:
#line 479 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 144:
#line 480 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 145:
#line 481 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 146:
#line 482 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 147:
#line 483 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 148:
#line 485 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 149:
#line 486 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 150:
#line 487 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 151:
#line 488 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 152:
#line 489 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 153:
#line 490 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 154:
#line 491 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 155:
#line 492 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 156:
#line 493 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 157:
#line 497 "Gramatica.y"
{
                      if(yyvsp[-1].sval != null){
                         Terceto t = new Terceto("BF", yyvsp[-1].sval, null);
                         adminTercetos.agregarTerceto(t);
                         adminTercetos.apilar(t.getNumero());
                         yyval = new ParserVal(yyvsp[-1].sval);
                     }
                     else
                         yyval = new ParserVal(null);
                   }
break;
case 159:
#line 510 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 160:
#line 511 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 161:
#line 512 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 162:
#line 513 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 163:
#line 514 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 164:
#line 517 "Gramatica.y"
{ Operando op = (Operando)yyvsp[0].obj;
                            if(op != null){
                                yyval = new ParserVal(op.getValor());
                            }
                            else
                                 yyval = new ParserVal(null);
                        }
break;
case 165:
#line 524 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");

	                    Operando op1 = (Operando)yyvsp[-2].obj;
                        Operando op2 = (Operando)yyvsp[0].obj;
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
case 166:
#line 546 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 167:
#line 547 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");
	                    Operando op1 = (Operando)yyvsp[-2].obj;
                        Operando op2 = (Operando)yyvsp[0].obj;
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
case 168:
#line 568 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 169:
#line 569 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  yyvsp[-1].sval + "}");

		                            Operando op1 = (Operando)yyvsp[-2].obj;
                                    Operando op2 = (Operando)yyvsp[0].obj;
                                    if(op1 != null && op2 !=null){
                                        if (op1.getTipo().equals(op2.getTipo())){
                                            Terceto t = new Terceto(yyvsp[-1].sval, op1.getValor(), op2.getValor());
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
#line 592 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 171:
#line 595 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");
	    Operando op1 = (Operando)yyvsp[-2].obj;
                        Operando op2 = (Operando)yyvsp[0].obj;
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
case 172:
#line 615 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");
	    Operando op1 = (Operando)yyvsp[-2].obj;
                        Operando op2 = (Operando)yyvsp[0].obj;
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
case 173:
#line 637 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");
                Operando op1 = (Operando)yyvsp[-2].obj;
                        Operando op2 = (Operando)yyvsp[0].obj;
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
case 174:
#line 657 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");
                Operando op1 = (Operando)yyvsp[-2].obj;
                Operando op2 = (Operando)yyvsp[0].obj;
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
case 175:
#line 677 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 176:
#line 681 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) yyvsp[0].obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 177:
#line 686 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", yyvsp[0].sval));
        }
break;
case 178:
#line 689 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");
         yyval = new ParserVal(new Operando("ULONG", yyvsp[0].sval));
         }
break;
case 179:
#line 692 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + yyvsp[0].sval +"}");
	            String ambitoVariable = Main.tablaSimbolos.verificarAmbito(yyvsp[0].sval, ambito);
                	if(ambitoVariable != null)
                        yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                    else {
                        System.out.println("[Error semántico: Linea " + Lexico.linea + " la variable " + yyvsp[0].sval +" no fue declarada");
                        yyval = new ParserVal(null);
	                }
	          }
break;
case 181:
#line 705 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 182:
#line 706 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 183:
#line 707 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 184:
#line 708 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 185:
#line 709 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 186:
#line 710 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
#line 1735 "y.tab.c"
    }
    yyssp -= yym;
    yystate = *yyssp;
    yyvsp -= yym;
    yym = yylhs[yyn];
    if (yystate == 0 && yym == 0)
    {
#if YYDEBUG
        if (yydebug)
            printf("yydebug: after reduction, shifting from state 0 to\
 state %d\n", YYFINAL);
#endif
        yystate = YYFINAL;
        *++yyssp = YYFINAL;
        *++yyvsp = yyval;
        if (yychar < 0)
        {
            if ((yychar = yylex()) < 0) yychar = 0;
#if YYDEBUG
            if (yydebug)
            {
                yys = 0;
                if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
                if (!yys) yys = "illegal-symbol";
                printf("yydebug: state %d, reading %d (%s)\n",
                        YYFINAL, yychar, yys);
            }
#endif
        }
        if (yychar == 0) goto yyaccept;
        goto yyloop;
    }
    if ((yyn = yygindex[yym]) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn];
    else
        yystate = yydgoto[yym];
#if YYDEBUG
    if (yydebug)
        printf("yydebug: after reduction, shifting from state %d \
to state %d\n", *yyssp, yystate);
#endif
    if (yyssp >= yyss + yystacksize - 1)
    {
        goto yyoverflow;
    }
    *++yyssp = yystate;
    *++yyvsp = yyval;
    goto yyloop;
yyoverflow:
    yyerror("yacc stack overflow");
yyabort:
    return (1);
yyaccept:
    return (0);
}
