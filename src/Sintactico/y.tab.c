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
   38,   35,   35,   35,   39,   39,   39,   36,   36,   36,
   36,   36,   36,   36,   11,   11,   12,   12,   12,   12,
   40,   40,   40,   40,   15,   15,   42,   42,   42,   42,
   41,   43,   43,   18,   18,   18,   44,   19,   19,   47,
   45,   45,   49,   49,   49,   49,   49,   48,   48,   50,
   20,   20,   52,   52,   52,   52,   52,   52,   51,   46,
   46,   46,   54,   53,   53,   53,   53,   55,   55,   55,
   55,   55,   55,   55,   55,   55,   55,   55,   55,   55,
   55,   55,   55,   55,   55,   55,   55,   55,   55,   37,
   37,   56,   56,   27,   27,   31,   31,   31,   33,   33,
   33,   58,   58,   58,   58,   58,   57,   57,   57,   57,
   57,   57,
};
short yylen[] = {                                         2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,    1,    8,
    8,    8,    8,    8,    8,    8,    9,    3,    1,    2,
    2,    3,    1,    3,    1,    2,    1,    2,    1,    2,
    3,    1,    2,    2,    3,    5,    7,    1,    3,    1,
    3,    1,    5,    1,    4,    5,    4,    4,    4,    4,
    4,    5,    6,    7,    4,    3,    4,    4,    4,    1,
    3,    4,    4,    4,    4,    1,    3,    3,    4,    4,
    3,    1,    2,    3,    1,    1,    2,    2,    1,    2,
    5,    1,    4,    4,    4,    4,    5,    2,    1,    2,
    6,    1,    5,    5,    5,    5,    5,    6,    2,    2,
    1,    1,    2,    8,   14,   13,    1,    7,    7,    7,
    7,    7,    7,    7,    3,    8,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   12,   12,   13,    8,    1,
    3,    1,    3,    1,    3,    1,    3,    3,    3,    3,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    1,
    1,    1,
};
short yydefred[] = {                                      0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  109,  112,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   39,   62,    0,
   68,   70,   90,   96,    0,    0,    0,    0,    4,    7,
    0,    0,    0,  106,   35,  110,    0,    0,    0,    0,
  108,  131,  132,  137,    0,  174,    0,  173,    0,    0,
  176,    0,  171,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   49,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  119,    0,    1,    0,    0,   12,   11,
   20,   14,   21,   15,   22,   16,   24,   17,   23,   18,
   28,   26,    0,    0,    0,    0,    0,    0,   33,  107,
   29,    0,   34,   30,    0,    0,    0,    0,  133,  130,
    0,    0,   65,    0,    0,    0,    0,   91,  172,    0,
    0,    0,   72,    0,   74,    0,    0,    0,   86,   13,
    8,   51,    0,   50,    0,    0,    0,    0,   97,    0,
   98,    0,  120,  118,  180,  181,  179,  182,  177,  178,
    0,    0,    0,   71,    0,   69,  113,    0,    0,  116,
    0,  115,  114,    0,  104,    0,    0,    0,    0,    0,
  145,    0,    0,    0,   94,   89,   92,   87,   93,   88,
  169,  170,    0,   79,   81,    0,   80,   85,   52,   48,
    0,    0,    0,    0,    0,  102,    0,   99,   95,  100,
    0,    0,    0,    0,    0,   78,  117,  111,    0,    0,
    0,  122,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   82,   66,    0,    0,    0,    0,
    0,    0,  101,  103,    0,    0,    0,   31,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   77,   75,    0,   83,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   76,
   73,   84,   67,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  139,    0,    0,    0,    0,
    0,    0,    0,  142,  143,  144,    0,  141,  140,    0,
  138,    0,   41,   43,   44,    0,   46,   45,   42,   40,
    0,  125,  126,    0,  127,  124,  123,    0,    0,    0,
    0,  159,    0,    0,    0,    0,    0,  146,  134,    0,
    0,   57,    0,   55,   59,   47,   38,  105,    0,  128,
  121,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   60,   58,   54,   56,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  149,  150,  152,  155,  156,  157,    0,  154,  153,
  151,    0,    0,  148,  147,  158,  136,    0,  135,
};
short yydgoto[] = {                                       6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   52,   11,  231,
   12,   83,  211,  333,   38,   84,   89,  363,  364,  365,
   90,   39,   91,   40,  144,   41,   92,   42,  145,   43,
  159,   44,  217,   54,   13,   61,   14,   93,   15,   94,
  342,  232,   62,   63,   64,   95,  171,   73,
};
short yysindex[] = {                                    562,
  118,  -31,    0,    0, -227,    0,  137,    0,    0, -176,
  -18,    0,  -38,    0,    0,  513,  563,  -37,  -14,  421,
  149,    6,  277,  137,  566,  242,    0,    0,    0,  -49,
   15,   95,  104,  151,    0,  367,    0,    0,    0, -217,
    0,    0,    0,    0,  -28,  -90,   27,  563,    0,    0,
   37,  131,  386,    0,    0,    0,  156,   40,   93,  259,
    0,    0,    0,    0,   75,    0,  236,    0,  389,  563,
    0,   36,    0,   36,  268,   46,  -17,  521,  175, -152,
 -140,  -46,   69,    0, -137, -198, -136,  -64,  599,  121,
   36,  126,  109,    0, -105,    0,   37,  566,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  268,  -13,  128,  132,  -90,  -90,    0,    0,
    0,  -62,    0,    0,  161,  146,  176,  563,    0,    0,
  162,  465,    0,  121,  -33,   50,  106,    0,    0,  563,
  563,  421,    0,  -67,    0,  195,  -65,  172,    0,    0,
    0,    0,  -77,    0,  563,  517,  563,   39,    0, -231,
    0, -137,    0,    0,    0,    0,    0,    0,    0,    0,
  563,  563,  563,    0,  563,    0,    0,  563,  155,    0,
  110,    0,    0,  -26,    0,  563,  127,  166,   16,  538,
    0,  563,   17,  563,    0,    0,    0,    0,    0,    0,
    0,    0,  288,    0,    0, -209,    0,    0,    0,    0,
  280,  599,  568,  369,  382,    0,  440,    0,    0,    0,
  121,   36,   36, -105,  599,    0,    0,    0,  -19,  -90,
  383,    0,   19,  394,  -23,  563,  403,  543,   24,  167,
  412,   54,  408,  289,    0,    0,  207,  190,  201,    4,
  214,  224,    0,    0,   -2,  180,  462,    0,  443,  421,
  421,  318,   57,  421,  452,  -10,  456,  470,  421,  474,
    0,    0,  409,    0, -121,  483,  503,  507,  -21,  509,
  524,  484,   28,  515,  520,  297,  314,  339,  343,  358,
  531,  362,  329,  334,  -44,  342,  353,  377,  357,    0,
    0,    0,    0,  399,  399,  399,  -36,  399,  399,  399,
  379,  379,  -43,  379,  379,    0,  615,  640,  645,  216,
  646,  381,  647,    0,    0,    0, -233,    0,    0,  650,
    0,  400,    0,    0,    0, -185,    0,    0,    0,    0,
  437,    0,    0,  -58,    0,    0,    0,  563,  563,  563,
  558,    0,  563,  563,  658,  420,  563,    0,    0,  563,
  426,    0,  233,    0,    0,    0,    0,    0,  165,    0,
    0,   59,   63,   64,  560,   78,  270,   79,  563,  665,
   80,   88,    0,    0,    0,    0,  648,  651,  661,  662,
   -6,  668,  675,  676,  102,  563,  678,  680,  431,  434,
  457,  466,  471,   73,  472,  476,  478,  685,  111,  481,
  489,    0,    0,    0,    0,    0,    0,  493,    0,    0,
    0,  490,  709,    0,    0,    0,    0,  497,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  773,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  439,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  671,    0,    0,    0,    0,    0,
    0,  448,    0,  461,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   23,  532,
  683,    0,    0,    0,   49,    0,    0,  780,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  469,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    8,    0,    0,    0,    0,    0,    0,    0,    0,
  610,  695,  707,  101,   86,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  514,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  723,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  514,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   72,  141,    0,   85,   -9,    0,  -20,   -5,    0,    0,
    0,  -16,    0,    0,  764,    0,   -1,  446,  787,    0,
    0,  726, -119,  453,    0,    0,  673,    0,  447,    0,
  -48,    0,  502,  791,  -47,    0,  -56,    0,    0,    0,
  -59,    0,    0,    0,    0,    0,    0,  -12,    0,    0,
  491,    0,  752,    0,    0,  637,    0,   44,
};
#define YYTABLESIZE 974
short yytable[] = {                                      71,
   71,   48,   48,   60,  336,  100,   71,  196,   46,  102,
   79,  114,  155,  230,  327,  344,   86,  262,  134,  308,
  255,   88,  358,  149,  218,   77,  161,  180,  147,   47,
  295,   71,  115,  116,  404,  261,  214,  215,  282,  100,
   55,  359,  158,   88,   88,   48,  245,  127,  294,   60,
   71,  113,  403,   71,  143,  143,  237,  241,  100,  259,
  246,   71,  279,  162,  267,  179,   53,   88,  313,  189,
  366,  193,   24,  104,  247,  158,  118,  140,   48,  128,
   51,  162,  141,  160,   59,   48,  312,  117,  332,  160,
  198,   50,  143,  250,  270,    2,   98,  291,  206,  387,
  219,  181,  220,  388,  389,  152,  100,  160,   50,   71,
  153,   71,   88,  139,  132,  184,   88,  154,  392,  394,
  397,  203,  221,   71,   71,  143,  163,  157,  398,  233,
  235,  418,   48,  239,  302,  240,  158,  242,   71,   71,
   71,  161,  408,   50,  163,  162,  200,   49,  303,  177,
  228,  423,  216,  106,   71,   71,   71,   23,   71,  161,
  178,   71,  108,  172,   96,  173,  176,  234,  182,   71,
   71,   70,  183,   71,  122,   71,   48,   71,  209,  263,
  210,  266,   50,  201,  202,  187,    3,    4,   82,  121,
   70,  163,  164,  244,  185,   48,   71,  370,  341,  275,
  186,  194,  204,  188,  207,  236,  101,  268,  122,  110,
   80,  254,  208,  341,   48,  192,   81,   56,   16,   71,
  284,   71,  195,  100,   17,   45,  143,  256,  257,   18,
  326,   75,   19,    2,   48,   57,  307,  332,    3,    4,
   21,   58,   22,  175,    5,  229,   48,  148,    3,    4,
  287,  288,  290,  283,  292,  353,  175,    3,    4,  298,
  175,  278,   78,    3,    4,   53,  100,  100,   17,  100,
  103,  100,   48,   18,    3,    4,   19,  100,  162,  320,
   70,   48,  175,  175,   21,  175,   22,   85,  162,  162,
  175,  372,  373,  374,  376,   78,  377,  378,   48,  100,
  381,   17,   78,  382,  160,  197,   18,   48,   17,   19,
  393,  362,  356,   18,  146,  160,   19,   21,  391,  142,
  175,   70,  395,  175,   21,  175,   22,   48,   48,  175,
  175,   71,   71,   71,   71,  100,   71,   71,  248,  409,
   71,  163,  362,   71,  175,  175,  175,  417,  129,   16,
  105,  163,  163,   48,  175,   17,  161,   48,   71,  107,
   18,  199,   71,   19,    2,  227,   57,  161,  175,    3,
    4,   21,   58,   22,   16,    5,  289,  175,   48,   71,
   17,  174,   48,   65,   66,   18,  119,  120,   19,    2,
   68,   20,  175,   16,    3,    4,   21,   48,   22,   17,
    5,   48,   65,   66,   18,   80,  109,   19,    2,   68,
   20,   81,   78,    3,    4,   21,   48,   22,   17,    5,
   48,  120,  174,   18,  226,  112,   19,  251,  125,  138,
  150,   78,   78,  175,   21,  126,   22,   17,   17,   48,
  252,  258,   18,   18,  124,   19,   19,  276,  190,  151,
  191,   78,  260,   21,   21,   22,   22,   17,  277,   48,
   48,  264,   18,   78,  205,   19,  272,  301,  142,   17,
  269,  280,   78,   21,   18,   22,  274,   19,   17,   48,
  142,  281,  105,   18,  384,   21,   19,   22,  351,   78,
  352,  133,   65,   66,   21,   17,   22,  105,   78,   68,
   18,  286,  285,   19,   17,  138,   64,  385,  361,   18,
  293,   21,   19,   22,  296,   78,   99,   72,   74,   63,
   21,   17,   22,  304,   78,  174,   18,   61,  297,   19,
   17,  131,  299,   65,   66,   18,  175,   21,   19,   22,
   68,  142,  311,  305,   78,   78,   21,  306,   22,  309,
   17,   17,   69,    3,    4,   18,   18,   70,   19,   19,
  132,   70,  243,  273,  310,   70,   21,   21,   22,   22,
   78,  316,  164,  314,   78,  213,   17,  238,  315,   72,
   17,   18,   70,  265,   19,   18,  317,   70,   19,  322,
  164,  164,   21,  164,   22,   78,   21,  375,   22,   78,
  390,   17,   70,  324,   70,   17,   18,   70,  325,   19,
   18,  318,   70,   19,   78,  319,  328,   21,   78,   22,
   17,   21,  111,   22,   17,   18,  249,  329,   19,   18,
  321,  331,   19,   78,  323,  341,   21,   78,   22,   17,
   21,  123,   22,   17,   18,  135,  136,   19,   18,  330,
  165,   19,  137,  355,  348,   21,   78,   22,  169,   21,
  170,   22,   17,  271,  300,    3,    4,   18,  165,  165,
   19,  165,  332,  222,  223,  361,   78,   78,   21,  349,
   22,  383,   17,   17,  350,  354,  357,   18,   18,  360,
   19,   19,  380,  368,  105,  105,   78,  379,   21,   21,
   22,   22,   17,   64,  396,  412,  399,   18,  413,  400,
   19,  175,  175,  175,  253,  175,   63,  175,   21,  401,
  402,  135,  136,  166,   61,  166,  405,  166,  137,  175,
  175,  414,  175,  406,  407,  167,  410,  167,  411,  167,
  415,  166,  166,  422,  166,  416,  419,  168,  426,  168,
  420,  168,  421,  167,  167,  424,  167,  334,  335,  337,
  338,  339,  340,  425,  427,  168,  168,  428,  168,   65,
   66,  429,    2,   65,   66,   67,   68,   65,   66,    5,
   68,  129,   69,   67,   68,   87,  369,  164,  367,  164,
  164,  164,  164,  164,   65,   66,   53,  164,  164,   65,
   66,   68,  343,  345,  346,  347,   68,  156,   76,  386,
  130,  224,    0,    0,   65,   66,   65,   66,    1,   65,
   66,   68,   97,   68,   65,   66,   68,  212,  212,  212,
    0,   68,    0,    2,  371,    0,    0,    2,    3,    4,
    0,    0,    3,    4,    5,    0,    0,    0,    5,    0,
  225,    0,    0,    0,    0,    0,    0,  165,  166,  167,
  168,    0,    0,    0,    0,  165,    0,  165,  165,  165,
  165,  165,    0,    0,    0,  165,  165,    0,    0,    0,
    0,    0,    0,    0,    0,  212,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  175,    0,  175,  175,
  175,  175,  175,    0,    0,    0,  175,  175,  166,    0,
  166,  166,  166,  166,  166,    0,    0,    0,  166,  166,
  167,    0,  167,  167,  167,  167,  167,    0,    0,    0,
  167,  167,  168,    0,  168,  168,  168,  168,  168,    0,
    0,    0,  168,  168,
};
short yycheck[] = {                                      16,
   17,   40,   40,   13,   41,   26,   23,   41,   40,   59,
   20,   40,   59,   40,   59,   59,   22,   41,   67,   41,
   40,   23,  256,   41,  256,   40,   86,   41,   76,  257,
   41,   48,   45,   46,   41,   59,  156,  157,   41,   60,
   59,  275,  274,   45,   46,   40,  256,   57,   59,   59,
   67,  269,   59,   70,   75,   76,   41,   41,   79,   41,
  270,   78,   59,   41,   41,  113,   59,   69,   41,  126,
  256,  128,    1,   59,  284,  274,   40,   42,   40,   40,
  257,   59,   47,  282,   13,   40,   59,   61,  274,   41,
   41,    7,  113,  213,   41,  272,   25,   41,  146,   41,
  160,  114,  162,   41,   41,  258,  127,   59,   24,  126,
  263,  128,  114,   70,   40,  117,  118,  258,   41,   41,
   41,  142,  171,  140,  141,  146,   41,   59,   41,  186,
  187,   59,   40,  190,  256,  192,  274,  194,  155,  156,
  157,   41,   41,   59,   59,  282,   41,    7,  270,   41,
   41,   41,  158,   59,  171,  172,  173,   40,  175,   59,
  266,  178,   59,   43,   24,   45,   41,   41,   41,  186,
  187,   45,   41,  190,   44,  192,   40,  194,  256,  236,
  258,  238,   98,  140,  141,   40,  277,  278,   40,   59,
   45,  256,  257,  203,  257,   40,  213,  256,  257,  247,
   40,   40,  270,   58,  270,   40,  256,   41,   44,   59,
  257,  217,   41,  257,   40,   40,  263,  256,  257,  236,
   41,  238,  256,  244,  263,  257,  247,  229,  230,  268,
  275,  269,  271,  272,   40,  274,  258,  274,  277,  278,
  279,  280,  281,  267,  283,  272,   40,  265,  277,  278,
  260,  261,  262,  255,  264,   40,  267,  277,  278,  269,
  267,  258,  257,  277,  278,  258,  287,  288,  263,  290,
  256,  292,   40,  268,  277,  278,  271,  298,  256,  289,
   45,   40,  267,  267,  279,  267,  281,  282,  266,  267,
  267,  348,  349,  350,  351,  257,  353,  354,   40,  320,
  357,  263,  257,  360,  256,  256,  268,   40,  263,  271,
   41,  332,  322,  268,  269,  267,  271,  279,  375,  274,
  267,   45,  379,  267,  279,  267,  281,   40,   40,  267,
  267,  348,  349,  350,  351,  356,  353,  354,   59,  396,
  357,  256,  363,  360,  267,  267,  267,  275,  256,  257,
  256,  266,  267,   40,  267,  263,  256,   40,  375,  256,
  268,  256,  379,  271,  272,  256,  274,  267,  267,  277,
  278,  279,  280,  281,  257,  283,   59,  267,   40,  396,
  263,  256,   40,  257,  258,  268,  256,  257,  271,  272,
  264,  274,  267,  257,  277,  278,  279,   40,  281,  263,
  283,   40,  257,  258,  268,  257,  256,  271,  272,  264,
  274,  263,  257,  277,  278,  279,   40,  281,  263,  283,
   40,  257,  256,  268,  270,   59,  271,   59,  273,   41,
  256,  257,  257,  267,  279,  280,  281,  263,  263,   40,
   59,   59,  268,  268,   59,  271,  271,  258,  273,  275,
  275,  257,   59,  279,  279,  281,  281,  263,  258,   40,
   40,   59,  268,  257,  270,  271,   59,   59,  274,  263,
   59,  258,  257,  279,  268,  281,  270,  271,  263,   40,
  274,  258,   44,  268,   59,  279,  271,  281,  273,  257,
  275,  256,  257,  258,  279,  263,  281,   59,  257,  264,
  268,   59,   41,  271,  263,   41,   59,  275,  276,  268,
   59,  279,  271,  281,   59,  257,  275,   16,   17,   59,
  279,  263,  281,   41,  257,  256,  268,   59,   59,  271,
  263,  273,   59,  257,  258,  268,  267,  279,  271,  281,
  264,  274,   59,   41,  257,  257,  279,   41,  281,   41,
  263,  263,   40,  277,  278,  268,  268,   45,  271,  271,
   40,   45,  275,  275,   41,   45,  279,  279,  281,  281,
  257,  275,   41,   59,  257,   59,  263,   40,   59,   78,
  263,  268,   45,   41,  271,  268,  273,   45,  271,   59,
   59,   60,  279,   62,  281,  257,  279,   40,  281,  257,
   41,  263,   45,  275,   45,  263,  268,   45,  275,  271,
  268,  273,   45,  271,  257,  273,  275,  279,  257,  281,
  263,  279,  256,  281,  263,  268,   59,  275,  271,  268,
  273,  275,  271,  257,  273,  257,  279,  257,  281,  263,
  279,  256,  281,  263,  268,  257,  258,  271,  268,  273,
   41,  271,  264,  273,   40,  279,  257,  281,   60,  279,
   62,  281,  263,  256,  256,  277,  278,  268,   59,   60,
  271,   62,  274,  172,  173,  276,  257,  257,  279,   40,
  281,  256,  263,  263,   40,   40,   40,  268,  268,   40,
  271,  271,  273,  257,  256,  257,  257,   40,  279,  279,
  281,  281,  263,  256,   40,  275,   59,  268,  275,   59,
  271,   41,   42,   43,  275,   45,  256,   47,  279,   59,
   59,  257,  258,   41,  256,   43,   59,   45,  264,   59,
   60,  275,   62,   59,   59,   41,   59,   43,   59,   45,
  275,   59,   60,   59,   62,  275,  275,   41,  256,   43,
  275,   45,  275,   59,   60,  275,   62,  305,  306,  307,
  308,  309,  310,  275,  275,   59,   60,   59,   62,  257,
  258,  275,    0,  257,  258,  263,  264,  257,  258,    0,
  264,   59,  269,  263,  264,   22,  341,  256,  336,  258,
  259,  260,  261,  262,  257,  258,   10,  266,  267,  257,
  258,  264,  312,  313,  314,  315,  264,   82,   18,  363,
   59,  175,   -1,   -1,  257,  258,  257,  258,  257,  257,
  258,  264,  257,  264,  257,  258,  264,  155,  156,  157,
   -1,  264,   -1,  272,  344,   -1,   -1,  272,  277,  278,
   -1,   -1,  277,  278,  283,   -1,   -1,   -1,  283,   -1,
  178,   -1,   -1,   -1,   -1,   -1,   -1,  259,  260,  261,
  262,   -1,   -1,   -1,   -1,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  213,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,  259,
  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,   -1,
  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,
  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,
  266,  267,  256,   -1,  258,  259,  260,  261,  262,   -1,
   -1,   -1,  266,  267,
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
"seleccion : IF condicion_if THEN bloque_if ENDIF",
"seleccion : IF condicion_if THEN bloque_if ELSE bloque_if ENDIF",
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
"error_seleccion : IF condicion_if THEN bloque_if ELSE ENDIF",
"error_seleccion : IF condicion_if THEN bloque_if ELSE bloque_if error",
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
#line 680 "Gramatica.y"

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
#line 719 "y.tab.c"
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
            if(yyvsp[-2].sval != null){
                adminTercetos.desapilar();
                Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantTercetos()), null, null);
                adminTercetos.agregarTerceto(t);
                }
            }
break;
case 69:
#line 236 "Gramatica.y"
{
                if(yyvsp[-2].sval != null){
                    Terceto t = new Terceto("BF", yyvsp[-2].sval, null);
                    adminTercetos.agregarTerceto(t);
                    adminTercetos.apilar(t.getNumero());
                    yyval = new ParserVal(yyvsp[-2].sval);
                }
                else
                    yyval = new ParserVal(null);
              }
break;
case 71:
#line 249 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 75:
#line 258 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 76:
#line 259 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 77:
#line 260 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 78:
#line 263 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 79:
#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 80:
#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 81:
#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 82:
#line 267 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 83:
#line 268 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 84:
#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 85:
#line 273 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[-1].sval  + "'}");
           Terceto t = new Terceto("Impresion", yyvsp[-1].sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 86:
#line 278 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[0].sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 87:
#line 285 "Gramatica.y"
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
case 88:
#line 295 "Gramatica.y"
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
#line 305 "Gramatica.y"
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
case 91:
#line 319 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 92:
#line 320 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 93:
#line 321 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
#line 322 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 97:
#line 331 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 98:
#line 332 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 99:
#line 333 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 100:
#line 334 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 104:
#line 344 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);
			        lista_variables = (ArrayList<String>) yyvsp[-2].obj;
			        lista_variables.add(yyvsp[0].sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 105:
#line 349 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");
			                        lista_variables.add(yyvsp[0].sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 107:
#line 357 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 108:
#line 361 "Gramatica.y"
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
case 110:
#line 374 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 111:
#line 377 "Gramatica.y"
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
case 113:
#line 406 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 114:
#line 407 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 115:
#line 408 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 116:
#line 409 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 117:
#line 410 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 118:
#line 413 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(yyvsp[0].sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(yyvsp[-1].sval);
                Main.tablaSimbolos.setDatosSimbolo(yyvsp[0].sval, ds);
                yyval = new ParserVal(yyvsp[0].sval);

                }
break;
case 120:
#line 424 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 123:
#line 432 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 124:
#line 433 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 125:
#line 434 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 126:
#line 435 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 127:
#line 436 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 128:
#line 437 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 133:
#line 450 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 138:
#line 460 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 139:
#line 461 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 140:
#line 462 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 141:
#line 463 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 142:
#line 464 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 143:
#line 465 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 144:
#line 466 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 145:
#line 467 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 146:
#line 468 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 147:
#line 470 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 148:
#line 471 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 149:
#line 472 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 150:
#line 473 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 151:
#line 474 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 152:
#line 475 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 153:
#line 476 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 154:
#line 477 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 155:
#line 478 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 156:
#line 479 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 157:
#line 480 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 158:
#line 481 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 159:
#line 482 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 160:
#line 488 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 161:
#line 489 "Gramatica.y"
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
case 162:
#line 511 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 163:
#line 512 "Gramatica.y"
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
case 164:
#line 533 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 165:
#line 534 "Gramatica.y"
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
case 166:
#line 557 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 167:
#line 560 "Gramatica.y"
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
case 168:
#line 580 "Gramatica.y"
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
case 169:
#line 602 "Gramatica.y"
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
case 170:
#line 622 "Gramatica.y"
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
case 171:
#line 642 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 172:
#line 646 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) yyvsp[0].obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 173:
#line 651 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", yyvsp[0].sval));
        }
break;
case 174:
#line 654 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");
         yyval = new ParserVal(new Operando("ULONG", yyvsp[0].sval));
         }
break;
case 175:
#line 657 "Gramatica.y"
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
case 177:
#line 670 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 178:
#line 671 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 179:
#line 672 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 180:
#line 673 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 181:
#line 674 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 182:
#line 675 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
#line 1694 "y.tab.c"
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
