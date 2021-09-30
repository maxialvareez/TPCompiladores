#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "Gramatica.y"
package Sintactico;
import Principal.*;
#line 9 "y.tab.c"
#define IDENTIFICADOR 257
#define CTE_UINT 258
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
#define UINT 284
#define ENDREPEAT 285
#define ELSE 286
#define YYERRCODE 256
short yylhs[] = {                                        -1,
    0,    0,    3,    3,    1,    1,    2,    2,    2,    6,
    7,    7,    5,    5,    5,    5,    5,    5,   13,   13,
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
short yylen[] = {                                         2,
    3,    1,    2,    3,    1,    2,    1,    3,    1,    2,
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
short yydefred[] = {                                      0,
    0,    0,   32,    0,   31,    0,    0,    2,    5,    0,
    0,   27,   81,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    7,    0,    9,    0,    0,    0,    0,    0,
   18,   34,   53,   59,   71,    0,    0,    0,    0,    3,
    6,    0,    0,    0,   78,   30,  136,  134,    0,  133,
    0,    0,    0,    0,    0,   89,    0,    0,    0,    0,
  132,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    1,    0,    0,    0,   11,   10,   19,   13,   20,   14,
   21,   15,   23,   16,   22,   17,    0,    0,    0,    0,
    0,    0,   28,   79,   24,    0,   29,   25,    0,   74,
    0,  135,   90,   88,    0,   73,    0,  140,  141,  139,
  142,  137,  138,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   12,    8,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   72,    0,   76,    0,    0,
    0,    0,    0,    0,  130,  131,    0,    0,    0,    0,
   69,    0,    0,    0,    0,    0,    0,   82,   95,    0,
   85,    0,   86,   84,   83,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   93,  101,   70,   80,    0,   26,   62,
   63,   65,    0,   64,   61,    0,    0,    0,    0,    0,
    0,   60,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   97,    0,   98,   96,    0,
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
short yydgoto[] = {                                       6,
  157,   22,    8,    9,  280,   24,   25,   26,   27,   28,
   29,   30,   31,   10,   43,   11,  167,   12,   54,  281,
   32,  282,  283,   33,   34,   91,   35,   45,  158,   13,
   56,  254,  184,  159,  185,  355,   57,   58,   59,  114,
   60,   61,
};
short yysindex[] = {                                   -224,
  183,  -29,    0, -193,    0,    0,  201,    0,    0, -195,
   41,    0,    0,  172,  558,  -37,   36,    0,  -26,   25,
  201, -171,    0,  268,    0,  -40,   19,   31,  127,  130,
    0,    0,    0,    0,    0,  -39, -189,   23,   25,    0,
    0,   52,  332,  303,    0,    0,    0,    0,  558,    0,
    8,  558, -221, -162,   68,    0, -155,  478,   48,   57,
    0, -162,  588,  -15, -150,  251,   60,  123,  -14,   77,
    0,   52, -171,  219,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   20,   90,   91, -189,
   93, -189,    0,    0,    0, -135,    0,    0, -162,    0,
   94,    0,    0,    0,  558,    0,  558,    0,    0,    0,
    0,    0,    0,  558,  558,  558,  558,  558, -143,  -31,
 -141,   95,    0,    0, -128,  365, -121, -131, -171,    8,
 -171,  -23, -171, -171, -133,    0,   99,    0, -171, -155,
  478,   48,   57,   57,    0,    0,    0,    0, -127,    0,
    0,   86,   88,  -34,   96,    0,  160,    0,    0,  103,
    0, -171,    0,    0,    0,  106,   98, -171,  278,  295,
 -122,  299,  314,  558,  558,  131,  558,  558,  329, -217,
  238, -124,  338,    0,    0,    0,    0, -189,    0,    0,
    0,    0,  -28,    0,    0,  -35,  -13,  571,   61,   82,
   84,    0,  109,  579,  339,  357,  231,  357,  121,  129,
  126, -108,  -85,  -70,  -67,  404,  -64,  -63,  -62,  558,
  622,  558,  -10,  600,   25,    0,  357,    0,    0,  558,
  -60,    0,    0,  364,  157,  158,  205,  346,   -2,  360,
  368,  371,   12,    0,   27,  316,    0,  649,   32,   33,
    0,   34,  162,    0,  374,  381,  381,  381,  381,  266,
  381,  381,  381,  381,  378,  385,  154,  402,    0,  409,
  386,   -4,  388,  -44,  389,    0,  -27,    0,  430,    0,
    5,    0,    0,   17,   58,   62,   85,   87,   89,  114,
  135,  137,  177,  413,  419,  428,  420,  441,  425,  195,
  199,   -9,  203,  212,  216,    0,    0,    0,    0,    0,
    0,    0,    0,  139,    0,    0,    0,    0,    0,    0,
  558,  558,  610,   25,  558,  456,  558,    0,    0,    0,
 -209,    0,    0,    0,    0,   38,   53,  661,   55,   56,
   65,  558,   69,    0,    0,  439,  445,  459,   10,  465,
  -25,  468,   73,  496,  220,  237,  240,  285,  306,   49,
  315,  330,  340,  351,  366,  551,    0,    0,    0,    0,
    0,  383,    0,    0,    0,    0,    0,  558,    0,   78,
    0,  453,  573,  558,   92,  587,  372,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  427,    0,    0,    0,    0,    0,    0,  431,    0,
    0,    0,    0,  433,    0,    0,  539,  520,  491,  633,
    0,  452,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  651,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  457,    0,
  462,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  469,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  474,  563,
  535,  513,  674,  686,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  462,
    0,  485,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  505,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  509,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  595,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  528,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   81,   -5,    0,   51,   -1,    3,    0,    0,    0,    0,
    0,    0,    0,   -7,  408,  658,    0,    0,  -11,  709,
    0,  673,    0,    0,    0,  774,    0,    0,  -91,    0,
    0,    0,    0,    0,    0,    0,  564,  572,  583,    0,
    1,  -30,
};
#define YYTABLESIZE 996
short yytable[] = {                                      23,
   87,   40,   63,   62,   64,   23,   53,   52,   69,  149,
   37,   39,   53,   68,  304,   71,   96,  162,   78,   23,
   66,  102,   76,  213,  177,  121,  128,   69,   53,   53,
  247,   53,    1,  362,  103,  104,  302,   99,  261,  161,
  163,  164,  165,   53,   39,  214,  344,    2,  100,  331,
  360,  120,  265,    3,  301,  203,   39,   41,    4,    5,
  131,   42,  204,   38,   76,  345,   53,  267,  359,   52,
  187,   41,  273,  274,  275,   65,    2,   80,  346,   53,
    7,   21,  135,   90,   53,   72,  145,  146,    3,   82,
  115,   92,  116,  347,    5,  350,  351,   39,  117,   46,
    2,   39,   73,  118,  105,  352,    3,  372,  106,  354,
  107,    4,    5,  364,  122,  143,  144,  129,  381,  217,
  125,  138,   53,   41,   39,  147,   39,  150,   39,  152,
  133,  134,  386,  136,  139,  151,  155,  156,  166,  168,
  218,  171,  219,  186,  174,  188,  175,  192,  220,  169,
  170,  172,  173,   39,  178,  182,  189,  208,  179,  183,
  230,  233,  196,  197,  199,  200,  201,   76,   76,  231,
   76,   76,  235,  193,   39,   52,   39,   76,   39,  207,
  210,   76,  205,  127,  232,   84,  216,  236,   86,  198,
  237,   76,  223,  240,  241,  242,  253,  256,  257,   39,
  226,  228,  229,   76,   23,   23,   23,   41,  243,  245,
  246,   51,  249,  250,  234,   77,   52,   53,  252,   47,
   48,  251,   20,  176,  156,   23,   50,   36,   74,   94,
   67,  105,   76,   72,   15,  105,  272,  148,    3,   16,
   39,  211,   17,  156,    5,  258,  266,  268,    2,  270,
   19,  105,  105,  105,    3,  260,  105,  212,  130,    4,
    5,   74,  105,   52,   76,  330,   76,   15,   76,  296,
   39,  298,   16,   74,   79,   17,  105,   39,  105,   15,
  279,   47,   48,   19,   16,    3,   81,   17,   50,  308,
   39,    5,  279,  105,   76,   19,   76,    3,  105,  105,
  105,  310,    3,    5,  105,   39,  287,   39,    5,  336,
  337,  339,  340,  341,   74,  343,   53,   39,   74,  105,
   15,  105,  105,  371,   15,   16,  349,  105,   17,   16,
  353,  105,   17,  279,   39,  105,   19,  279,   39,  105,
   19,   74,  311,   74,  105,   74,  312,   15,  105,   15,
  105,   15,   16,   39,   16,   17,   16,   17,  105,   17,
  279,   98,  279,   19,  279,   19,  380,   19,   39,  313,
   74,  315,  385,  316,  269,   96,   15,   39,  225,  126,
   76,   16,   83,  382,   17,   85,  259,   47,   48,  279,
   95,   74,   19,   74,   50,   74,   39,   15,  317,   15,
  262,   15,   16,   39,   16,   17,   16,   17,  263,   17,
  279,  264,  279,   19,  279,   19,   14,   19,  276,  318,
   39,  319,   15,  335,   39,  154,  295,   16,   47,   48,
   17,    2,  278,  180,   49,   50,  293,    3,   19,   14,
  181,   39,    4,    5,  300,   15,  303,  305,   39,    3,
   16,  320,  321,   17,    2,    5,   18,   14,  322,  325,
    3,   19,  239,   15,  327,    4,    5,  324,   16,  328,
   77,   17,    2,  329,   18,   47,   48,  332,    3,   19,
   39,   49,   50,    4,    5,   77,  333,   74,  307,   56,
  334,   55,   39,   15,   74,  342,    3,  356,   16,  366,
   15,   17,    5,  357,   18,   16,  123,   74,   17,   19,
   54,  367,  227,   15,  368,   52,   19,  358,   16,  206,
   75,   17,   74,  361,   74,  124,  363,   72,   15,   19,
   15,  125,   70,   16,   74,   16,   17,  112,   17,  113,
   15,  279,   75,   87,   19,   16,   19,  190,   17,  125,
  125,   74,  125,  126,  365,   74,   19,   15,   97,  369,
  123,   15,   16,   66,  191,   17,   16,   68,  194,   17,
   74,  126,  126,   19,  126,  124,   15,   19,  123,  121,
  370,   16,  105,  195,   17,   74,   45,   93,   94,  373,
  378,   15,   19,  124,   74,   74,   16,  121,  202,   17,
   15,   15,   52,  122,  374,   16,   16,   19,   17,   17,
  209,  224,  384,   74,  375,   52,   19,   19,  221,   15,
   74,  122,  153,   52,   16,  376,   15,   17,  119,  215,
   18,   16,   52,  255,   17,   19,  222,   74,  379,  248,
  377,   74,   19,   15,   52,  387,  388,   15,   16,  338,
    4,   17,   16,   92,   52,   17,  279,  294,   74,   19,
  277,  238,  244,   19,   15,   74,   52,   44,  140,   16,
  105,   15,   17,  127,  297,  127,   16,  127,  141,   17,
   19,  299,   77,   77,   74,  306,   56,   19,   55,  271,
   15,  127,  127,   52,  127,   16,  142,   74,   17,    0,
  323,  348,    0,   15,    0,   52,   19,   54,   16,   74,
    0,   17,   52,  326,  128,   15,  128,   75,  128,   19,
   16,    0,    0,   17,   72,  383,  129,    0,  129,   70,
  129,   19,  128,  128,    0,  128,  108,  109,  110,  111,
   87,    0,    0,    0,  129,  129,  125,  129,  125,  125,
  125,  125,  125,    0,    0,    0,  125,  125,    0,  125,
   66,    0,    0,    0,   68,    0,    0,    0,  126,    0,
  126,  126,  126,  126,  126,  123,    0,  123,  126,  126,
    0,  126,    0,   45,    0,  123,  123,   55,  123,    0,
  124,    0,  124,   70,  121,    0,  121,    0,    0,    0,
  124,  124,    0,  124,    0,  121,    0,  121,    0,   88,
   89,    0,    0,    0,   47,   48,    0,    0,  122,    0,
  122,   50,    0,    0,  101,    0,    0,   47,   48,  122,
    0,  122,    0,    0,   50,   47,   48,    0,    0,    0,
    0,    0,   50,    0,   47,   48,    0,   55,    0,    0,
    0,   50,    0,    0,    0,    0,   47,   48,    0,    0,
  132,    0,    0,   50,    0,  137,   47,   48,    0,    0,
    0,    0,    0,   50,    0,    0,    0,    0,   47,   48,
    0,    0,    0,    0,    0,   50,    0,    0,  127,    0,
  127,  127,  127,  127,  127,    0,    0,    0,  127,  127,
    0,  127,    0,  160,    0,   47,   48,    0,    0,    0,
    0,    0,   50,    0,    0,    0,    0,   47,   48,    0,
    0,    0,    0,    0,   50,    0,    0,    0,    0,  128,
    0,  128,  128,  128,  128,  128,    0,    0,    0,  128,
  128,  129,  128,  129,  129,  129,  129,  129,    0,    0,
    0,  129,  129,  309,  129,    0,  309,  309,  309,    0,
  309,  309,  309,  309,  309,  284,  285,  286,  288,  289,
  290,  291,  292,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  309,    0,    0,    0,
    0,    0,    0,    0,    0,  314,
};
short yycheck[] = {                                       1,
   40,    7,   40,   15,   16,    7,   14,   45,   20,   41,
   40,   40,   20,   40,   59,   21,   44,   41,   59,   21,
   18,   52,   24,   59,   59,   41,   41,   39,   36,   37,
   41,   39,  257,   59,  256,  257,   41,   49,   41,  131,
  132,  133,  134,   51,   40,   59,  256,  272,   41,   59,
   41,   63,   41,  278,   59,  273,   40,    7,  283,  284,
   41,  257,  280,  257,   66,  275,   74,   41,   59,   45,
  162,   21,   41,   41,   41,   40,  272,   59,   41,   87,
    0,    1,   90,   61,   92,  257,  117,  118,  278,   59,
   43,   40,   45,   41,  284,   41,   41,   40,   42,   59,
  272,   40,   22,   47,  267,   41,  278,   59,   41,   41,
  266,  283,  284,   41,  265,  115,  116,   41,   41,   59,
   61,  257,  130,   73,   40,  269,   40,  269,   40,  258,
   41,   41,   41,   41,   41,   41,  258,  269,  272,   41,
   59,  269,   59,   41,   59,   40,   59,  270,   40,  147,
  148,  149,  150,   40,   59,  157,   59,  282,  156,  157,
   40,  270,  174,  175,  176,  177,  178,  169,  170,   41,
  172,  173,  258,  171,   40,   45,   40,  179,   40,  181,
  188,  183,  180,   61,   59,   59,  198,  258,   59,   59,
  258,  193,  204,  258,  258,  258,  257,   41,   41,   40,
  206,  207,  208,  205,  206,  207,  208,  157,  220,  221,
  222,   40,  224,  225,  212,  256,   45,  225,  230,  257,
  258,  227,   40,  258,  269,  227,  264,  257,  257,  257,
  257,  267,  234,  257,  263,  267,  248,  269,  278,  268,
   40,  270,  271,  269,  284,   41,  244,  245,  272,  247,
  279,  267,  267,  267,  278,  258,  267,  286,   40,  283,
  284,  257,  267,   45,  266,  275,  268,  263,  270,  267,
   40,  269,  268,  257,  256,  271,  267,   40,  267,  263,
  276,  257,  258,  279,  268,  278,  256,  271,  264,  285,
   40,  284,  276,  267,  296,  279,  298,  278,  267,  267,
  267,  285,  278,  284,  267,   40,   41,   40,  284,  321,
  322,  323,  324,  325,  257,  327,  324,   40,  257,  267,
  263,  267,  267,  275,  263,  268,  338,  267,  271,  268,
  342,  267,  271,  276,   40,  267,  279,  276,   40,  267,
  279,  257,  285,  257,  267,  257,  285,  263,  267,  263,
  267,  263,  268,   40,  268,  271,  268,  271,  267,  271,
  276,   59,  276,  279,  276,  279,  378,  279,   40,  285,
  257,  285,  384,  285,   59,   44,  263,   40,   40,  257,
  382,  268,  256,  381,  271,  256,   41,  257,  258,  276,
   59,  257,  279,  257,  264,  257,   40,  263,  285,  263,
   41,  263,  268,   40,  268,  271,  268,  271,   41,  271,
  276,   41,  276,  279,  276,  279,  257,  279,  257,  285,
   40,  285,  263,  285,   40,   61,  273,  268,  257,  258,
  271,  272,   59,  274,  263,  264,   59,  278,  279,  257,
  281,   40,  283,  284,   59,  263,   59,   59,   40,  278,
  268,  275,   40,  271,  272,  284,  274,  257,   40,   40,
  278,  279,   59,  263,   40,  283,  284,   40,  268,  275,
   44,  271,  272,  275,  274,  257,  258,  275,  278,  279,
   40,  263,  264,  283,  284,   59,  275,  257,   59,   59,
  275,   59,   40,  263,  257,   40,  278,   59,  268,  280,
  263,  271,  284,   59,  274,  268,  256,  257,  271,  279,
   59,  275,  282,  263,  275,   59,  279,   59,  268,  282,
   59,  271,  257,   59,  257,  275,   59,   59,  263,  279,
  263,   41,   59,  268,  257,  268,  271,   60,  271,   62,
  263,  276,  275,   59,  279,  268,  279,  270,  271,   59,
   60,  257,   62,   41,   59,  257,  279,  263,  256,  275,
   41,  263,  268,   59,  270,  271,  268,   59,  270,  271,
  257,   59,   60,  279,   62,   41,  263,  279,   59,   41,
  275,  268,  267,  270,  271,  257,   59,  256,  257,  275,
   40,  263,  279,   59,  257,  257,  268,   59,  270,  271,
  263,  263,   45,   41,  275,  268,  268,  279,  271,  271,
  273,  273,   40,  257,  275,   45,  279,  279,   40,  263,
  257,   59,  258,   45,  268,  275,  263,  271,   41,   59,
  274,  268,   45,  270,  271,  279,   58,  257,  256,   40,
  275,  257,  279,  263,   45,   59,  275,  263,  268,   40,
    0,  271,  268,   59,   45,  271,  276,  273,  257,  279,
  253,  258,   41,  279,  263,  257,   45,   10,  105,  268,
  267,  263,  271,   41,  273,   43,  268,   45,  107,  271,
  279,  273,  256,  257,  257,  256,  256,  279,  256,   41,
  263,   59,   60,   45,   62,  268,  114,  257,  271,   -1,
  273,   41,   -1,  263,   -1,   45,  279,  256,  268,  257,
   -1,  271,  256,  273,   41,  263,   43,  256,   45,  279,
  268,   -1,   -1,  271,  256,  273,   41,   -1,   43,  256,
   45,  279,   59,   60,   -1,   62,  259,  260,  261,  262,
  256,   -1,   -1,   -1,   59,   60,  256,   62,  258,  259,
  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,  269,
  256,   -1,   -1,   -1,  256,   -1,   -1,   -1,  256,   -1,
  258,  259,  260,  261,  262,  256,   -1,  258,  266,  267,
   -1,  269,   -1,  256,   -1,  266,  267,   14,  269,   -1,
  256,   -1,  258,   20,  256,   -1,  258,   -1,   -1,   -1,
  266,  267,   -1,  269,   -1,  267,   -1,  269,   -1,   36,
   37,   -1,   -1,   -1,  257,  258,   -1,   -1,  256,   -1,
  258,  264,   -1,   -1,   51,   -1,   -1,  257,  258,  267,
   -1,  269,   -1,   -1,  264,  257,  258,   -1,   -1,   -1,
   -1,   -1,  264,   -1,  257,  258,   -1,   74,   -1,   -1,
   -1,  264,   -1,   -1,   -1,   -1,  257,  258,   -1,   -1,
   87,   -1,   -1,  264,   -1,   92,  257,  258,   -1,   -1,
   -1,   -1,   -1,  264,   -1,   -1,   -1,   -1,  257,  258,
   -1,   -1,   -1,   -1,   -1,  264,   -1,   -1,  256,   -1,
  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,
   -1,  269,   -1,  130,   -1,  257,  258,   -1,   -1,   -1,
   -1,   -1,  264,   -1,   -1,   -1,   -1,  257,  258,   -1,
   -1,   -1,   -1,   -1,  264,   -1,   -1,   -1,   -1,  256,
   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,  256,  269,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,  281,  269,   -1,  284,  285,  286,   -1,
  288,  289,  290,  291,  292,  257,  258,  259,  260,  261,
  262,  263,  264,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  314,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  287,
};
#define YYFINAL 6
#ifndef YYDEBUG
#define YYDEBUG 0
#endif
#define YYMAXTOKEN 286
#if YYDEBUG
char *yyname[] = {
"end-of-file",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,"'('","')'","'*'","'+'","','","'-'",0,"'/'",0,0,0,0,0,0,0,0,0,0,
"':'","';'","'<'","'='","'>'",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
0,0,0,0,0,0,0,0,0,"IDENTIFICADOR","CTE_UINT","MAYOR_IGUAL","MENOR_IGUAL",
"IGUAL_IGUAL","DISTINTO","ASIGNACION","CTE_DOUBLE","CADENA","AND","OR","IF",
"THEN","ENDIF","PRINT","FUNC","RETURN","BEGIN","END","BREAK","ULONG","DOUBLE",
"REPEAT","PRE","TRY","CATCH","TYPEDEF","UINT","ENDREPEAT","ELSE",
};
char *yyrule[] = {
"$accept : programa",
"programa : IDENTIFICADOR bloque_declarativo bloque_ejecutable",
"programa : error_programa",
"error_programa : bloque_declarativo bloque_ejecutable",
"error_programa : IDENTIFICADOR bloque_ejecutable bloque_declarativo",
"bloque_declarativo : declaracion",
"bloque_declarativo : bloque_declarativo declaracion",
"bloque_ejecutable : sentencia_ejecucion",
"bloque_ejecutable : BEGIN bloque_sentencias END",
"bloque_ejecutable : error_bloque_ejecutable",
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
#line 266 "Gramatica.y"

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
#line 649 "y.tab.c"
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
#line 12 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado " +yyvsp[-2].sval);}
break;
case 3:
#line 16 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 4:
#line 17 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 11:
#line 34 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 12:
#line 35 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN per falta un END para cerrar el bloque}");}
break;
case 19:
#line 48 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 20:
#line 49 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
#line 50 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
#line 51 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
#line 52 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
#line 56 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 26:
#line 58 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + yyvsp[-4].sval +"}");}
break;
case 28:
#line 63 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
#line 64 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 30:
#line 65 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + yyvsp[-1].sval + "}");}
break;
case 33:
#line 74 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 35:
#line 78 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 36:
#line 79 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 37:
#line 80 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 38:
#line 81 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante UINT}");}
break;
case 39:
#line 82 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 40:
#line 83 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 41:
#line 84 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 42:
#line 85 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_UINT}");}
break;
case 43:
#line 86 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 44:
#line 87 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 45:
#line 88 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta indicar el fin del ciclo con ENDREPEAT}");}
break;
case 51:
#line 100 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 54:
#line 108 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 55:
#line 109 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 56:
#line 110 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 60:
#line 120 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 61:
#line 121 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 62:
#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 63:
#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 64:
#line 124 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 65:
#line 125 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 66:
#line 126 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 67:
#line 127 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 68:
#line 128 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 70:
#line 136 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + yyvsp[-3].sval + "'}");}
break;
case 72:
#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 73:
#line 141 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 74:
#line 142 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 75:
#line 143 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 76:
#line 147 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);}
break;
case 77:
#line 148 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");}
break;
case 79:
#line 153 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 80:
#line 155 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ yyvsp[-4].sval +"'" );}
break;
case 82:
#line 160 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 83:
#line 161 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 84:
#line 162 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 85:
#line 163 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 86:
#line 164 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 87:
#line 165 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 90:
#line 173 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 96:
#line 190 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el TRY}");}
break;
case 97:
#line 191 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, la sentencia ejecutable después del TRY}");}
break;
case 98:
#line 192 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta el CATCH}");}
break;
case 102:
#line 200 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 103:
#line 201 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 104:
#line 202 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el RETURN");}
break;
case 105:
#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta '(' ");}
break;
case 106:
#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta indicar el retorno");}
break;
case 107:
#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta ')' ");}
break;
case 108:
#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta ';' ");}
break;
case 109:
#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {rror en una funcion, falta el END ");}
break;
case 110:
#line 209 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 111:
#line 210 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 112:
#line 211 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 113:
#line 212 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 114:
#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 115:
#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 116:
#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 117:
#line 216 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 118:
#line 218 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 119:
#line 219 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 120:
#line 220 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 122:
#line 227 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval + "||" + yyvsp[0].sval + "}");}
break;
case 124:
#line 231 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval + "&&" + yyvsp[0].sval+ "}");}
break;
case 126:
#line 235 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval +yyvsp[-1].sval+ yyvsp[0].sval + "}");}
break;
case 128:
#line 239 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval +"+"+ yyvsp[0].sval+ "}");}
break;
case 129:
#line 240 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval +"-"+ yyvsp[0].sval+ "}");}
break;
case 130:
#line 243 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval +"*"+ yyvsp[0].sval+ "}");}
break;
case 131:
#line 244 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " + yyvsp[-2].sval +"/"+ yyvsp[0].sval+ "}");}
break;
case 133:
#line 249 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval);}
break;
case 134:
#line 250 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante UINT: " + yyvsp[0].sval);}
break;
case 135:
#line 251 "Gramatica.y"
{chequearFactorNegado();}
break;
case 136:
#line 252 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + yyvsp[0].sval +"}");}
break;
#line 1145 "y.tab.c"
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
