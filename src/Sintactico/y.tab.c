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
   26,   26,   24,   27,   27,   28,   28,   28,   29,   13,
   13,   31,   31,   31,   10,   10,   10,   33,   33,   33,
   35,   35,   35,   34,   34,   34,   34,   34,   34,   34,
   34,   34,   11,   11,   12,   12,   12,   12,   36,   36,
   36,   36,   15,   15,   38,   38,   38,   38,   37,   39,
   39,   18,   18,   18,   40,   19,   19,   43,   41,   41,
   45,   45,   45,   45,   45,   44,   44,   46,   20,   20,
   48,   48,   48,   48,   48,   48,   47,   42,   42,   42,
   50,   49,   49,   49,   49,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   51,   51,   51,   51,
   51,   51,   51,   51,   51,   51,   51,   23,   23,   52,
   52,   53,   53,   30,   30,   30,   32,   32,   32,   55,
   55,   55,   55,   55,   54,   54,   54,   54,   54,   54,
};
short yylen[] = {                                         2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,    1,    8,
    8,    8,    8,    8,    8,    8,    9,    3,    1,    2,
    2,    3,    3,    1,    2,    1,    2,    1,    2,    3,
    1,    2,    2,    3,    7,    9,    1,    1,    5,    1,
    4,    5,    4,    6,    6,    6,    6,    6,    6,    6,
    8,    8,    4,    3,    4,    4,    4,    1,    3,    4,
    4,    4,    4,    1,    3,    3,    4,    4,    3,    1,
    2,    3,    1,    1,    2,    2,    1,    2,    5,    1,
    4,    4,    4,    4,    5,    2,    1,    2,    6,    1,
    5,    5,    5,    5,    5,    6,    2,    2,    1,    1,
    2,    8,   14,   13,    1,    7,    7,    7,    7,    7,
    7,    7,    3,    8,   12,   12,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   13,    8,    1,    3,    1,
    3,    1,    3,    1,    3,    3,    3,    3,    1,    2,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
};
short yydefred[] = {                                      0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  107,  110,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   39,   61,   67,
   88,   94,    0,    0,    0,    0,    4,    7,    0,    0,
    0,  104,   35,  108,    0,    0,    0,    0,  106,  129,
  130,  135,    0,  172,    0,  171,    0,    0,  174,    0,
  169,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   49,    0,    0,    0,    0,
    0,    0,  117,    1,    0,    0,   12,   11,   20,   14,
   21,   15,   22,   16,   24,   17,   23,   18,   28,   26,
    0,    0,    0,    0,    0,   33,  105,   29,    0,   34,
   30,    0,    0,    0,    0,  131,  128,    0,    0,   64,
    0,    0,    0,    0,   89,  170,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  178,  179,  177,  180,  175,
  176,    0,    0,   84,   13,    8,   51,    0,   50,    0,
    0,    0,    0,   95,    0,   96,    0,  118,  116,    0,
  111,  114,    0,  113,  112,    0,  102,    0,    0,    0,
    0,    0,  143,    0,    0,    0,   92,   87,   90,   85,
   91,   86,  167,  168,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   83,   52,   48,    0,    0,    0,    0,
  100,    0,   97,   93,   98,    0,  115,  109,    0,    0,
    0,  120,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   68,    0,   70,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   99,  101,    0,    0,    0,
    0,   31,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   76,   77,   79,    0,   78,
   75,    0,    0,    0,    0,    0,    0,   74,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   65,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  137,    0,    0,    0,    0,    0,    0,    0,
  140,  141,  142,    0,  139,  138,    0,  136,   73,   71,
    0,   81,    0,    0,   41,   43,   44,    0,   46,   45,
   42,   40,    0,  123,  124,    0,  125,  122,  121,    0,
    0,    0,    0,  157,    0,    0,    0,    0,    0,  144,
  132,    0,   72,   69,   66,    0,   56,    0,   54,   58,
   47,   38,  103,    0,  126,  119,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   59,   57,   53,
   55,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  147,  148,  150,  153,
  154,  155,    0,  152,  151,  149,    0,    0,  146,  145,
  156,  134,    0,  133,
};
short yydgoto[] = {                                       6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   50,   11,  221,
   12,   85,   91,  335,   38,   86,  368,  369,  370,   75,
   39,   76,  235,   40,  236,   41,  164,   42,  212,   52,
   13,   59,   14,   92,   15,   93,  344,  222,   60,   61,
   62,   77,   78,  152,   71,
};
short yysindex[] = {                                   -118,
   84,  -25,    0,    0, -212,    0,  159,    0,    0, -108,
    7,    0,   28,    0,    0,  540,  582,  177,   13,  459,
  116,   11,   67,  159,  -88,  281,    0,    0,    0,  -41,
  -40,   98,  139,  422,    0,  431,    0,    0,    0,    0,
    0,    0,  -19, -185,   15,  582,    0,    0,   42,  330,
  442,    0,    0,    0,  -37,   46,  140,  290,    0,    0,
    0,    0,   59,    0,  190,    0,   55,  582,    0,   95,
    0,   95,  387,    9,  110,   95, -160,  646,   29,  553,
  187, -241, -141,  334,   71,    0, -133, -254, -135,  -83,
   19,  117,    0,    0,   42,  -88,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   -7,  120,  126, -185, -185,    0,    0,    0,  -76,    0,
    0,  151,  143,  188,  582,    0,    0,  157,  566,    0,
  110,   -6,    6,   94,    0,    0,  582,  582,  -69,  -12,
  582,  -67,  582,  582,  582,    0,    0,    0,    0,    0,
    0,  582,  165,    0,    0,    0,    0, -153,    0,  582,
  415,  582,  479,    0, -200,    0, -133,    0,    0,  -61,
    0,    0,   97,    0,    0,  -32,    0,  582,  595,  179,
   21,  556,    0,  582,   22,  582,    0,    0,    0,    0,
    0,    0,    0,    0,  302,  302,  208, -160,  302,   95,
   95,  646,  110,    0,    0,    0,  119,  623,  123,  162,
    0,  131,    0,    0,    0,  302,    0,    0,  -17, -185,
  178,    0,   31,  263,  -15,  582,  324,  609,   34,   36,
  339,   48,  459,    0,  145,    0,  169,  223,  200,  205,
  199,  220,  146,  225,  226,    0,    0,  215,   -5,  447,
  454,    0,  437,  459,  459,  311,   49,  459,  444,   -1,
  449,  -45,  459,  450,  331,    0,    0,    0, -201,    0,
    0,  474,  475,  488,  -29,  500,  501,    0,  461,   26,
  491,  495,  217,  332,  351,  352,  384,  496,  385,  291,
  292,  -50,  297,  303,  412,  309,  446,  413,    0,  243,
  343,  343,  343,  -36,  343,  343,  343,  320,  320,  -43,
  320,  320,    0,  564,  578,  581,  255,  586,  432,  588,
    0,    0,    0, -191,    0,    0,  589,    0,    0,    0,
  451,    0,  369,  433,    0,    0,    0, -161,    0,    0,
    0,    0,  389,    0,    0,  -63,    0,    0,    0,  582,
  582,  582,  598,    0,  582,  582,  619,  458,  582,    0,
    0,  582,    0,    0,    0,  472,    0,  264,    0,    0,
    0,    0,    0,  -34,    0,    0,   50,   53,   56,  626,
   61,   82,   90,  582,  620,   92,   93,    0,    0,    0,
    0,  590,  618,  627,  638,   14,  651,  113,  660,   99,
  582,  666,  682,  469,  471,  481,  484,  485,   12,  493,
  498,  503,  690,  102,  513,  515,    0,    0,    0,    0,
    0,    0,  506,    0,    0,    0,  517,  695,    0,    0,
    0,    0,  520,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  764,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  405,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  710,    0,    0,    0,    0,    0,    0,  478,
    0,  487,    0,    0,  575,  722,  -28,   60,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  766,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  489,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  516,    0,  734,
  746,  466,  658,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  492,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  505,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  712,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  107,   35,    0,   30,   -9,    0,  -20,  511,    0,    0,
    0,  -16,    0,    0,  754,    0,  778,  443,  770,    0,
    0,  715,   25,  572,    0,    0,    0,  434,    0,  -38,
    0,    8,  632,    0,    0,    0,  -49,    0,    0,    0,
    0,    0,    0,  -11,    0,    0, -231,    0,  743,    0,
    0,  668,  662,    0,  -27,
};
#define YYTABLESIZE 1027
short yytable[] = {                                      69,
   69,   69,   46,   58,  338,   98,   69,  220,  324,  119,
   81,  305,  158,  294,   44,  346,  157,  100,  102,  163,
  111,  158,  249,   70,   72,  256,  131,  165,  197,   69,
  158,  112,  113,  172,  188,  279,   48,   98,  166,  292,
  136,   47,   74,  255,   45,  124,  190,   58,   69,  142,
   46,   69,   79,   48,  409,  213,   69,  291,   94,  170,
   98,  227,  231,   69,  360,   53,  310,   46,  299,  154,
  423,  253,  408,  163,  261,  114,  262,  345,  347,  348,
  349,  115,  300,  361,  309,  125,   48,   70,  264,  288,
  392,    3,    4,  393,  371,  135,  394,  140,  129,  173,
  160,  397,  205,   98,  206,  145,   69,   24,   69,  193,
  194,   68,  334,  203,  376,  214,  159,  215,  160,   57,
   69,   69,  398,   23,   69,   48,   69,   69,   69,  162,
  399,   96,  402,  403,  192,   69,  137,  218,    1,  413,
  163,  138,  428,   69,   69,   69,  167,  181,   49,  185,
  200,  201,  143,    2,  144,   84,  104,  171,    3,    4,
  174,   69,   69,    2,    5,   69,  175,   69,   95,   69,
   46,  411,  168,  169,  234,  234,  234,  241,  234,   46,
  177,  244,  179,    2,  207,  209,  210,   68,    3,    4,
  178,   69,  375,  343,    5,  234,  186,  106,   46,  195,
  180,  199,  223,  225,  275,  204,  229,  216,  230,   69,
  232,   69,  265,  343,   99,  101,   73,  234,  226,   80,
  245,   68,  117,  216,  323,   17,   46,  184,  304,  158,
   18,   43,  243,   19,   68,  122,  252,  334,  158,  219,
  158,   21,  123,   22,  284,  285,  287,   46,  289,  187,
  257,  141,  260,  295,  141,  298,  196,    3,    4,    3,
    4,  189,   46,   98,   98,  141,   98,   80,   98,    3,
    4,    3,    4,   17,   98,  141,  317,   98,   18,  234,
  141,   19,   46,   54,   16,  141,  422,  141,  141,   21,
   17,   22,   87,  153,  355,   18,   98,  141,   19,    2,
  141,   55,  141,   46,    3,    4,   21,   56,   22,  358,
    5,  132,  133,  367,  141,  141,  141,  160,  134,  141,
   46,  254,  141,   63,   64,  160,  160,  141,  160,   46,
   66,    3,    4,   69,   69,   69,   69,   98,   69,   69,
   16,   46,   69,    3,    4,   69,   17,  367,  141,  191,
   46,   18,  217,  103,   19,    2,  141,   20,  141,  141,
    3,    4,   21,   69,   22,  141,    5,   69,  141,  286,
   46,   46,   82,  119,  377,  378,  379,  381,   83,  382,
  383,  216,  258,  386,   69,  141,  387,   80,  118,  141,
   46,   46,  160,   17,  105,  126,   16,  263,   18,   63,
   64,   19,   17,  274,  396,  246,   66,   18,  400,   21,
   19,    2,  141,   55,  266,   16,    3,    4,   21,   56,
   22,   17,    5,   46,   46,  414,   18,  139,  141,   19,
    2,   68,   20,   63,   64,    3,    4,   21,  267,   22,
   66,    5,  155,   80,   80,  130,   63,   64,  103,   17,
   17,   46,   46,   66,   18,   18,  272,   19,   19,   68,
  182,  156,  183,  103,   80,   21,   21,   22,   22,  270,
   17,   46,   46,  208,  271,   18,  238,  273,   19,   80,
  108,  233,  276,  277,  278,   17,   21,  281,   22,  110,
   18,  313,  268,   19,  282,  283,  233,   46,   46,   80,
  121,   21,  290,   22,  330,   17,  161,  293,  296,  364,
   18,   80,  332,   19,  301,  302,  233,   17,   46,  308,
   80,   21,   18,   22,  161,   19,   17,  353,  303,  354,
  389,   18,   88,   21,   19,   22,   63,   80,  390,  366,
  306,  307,   21,   17,   22,   62,   80,   60,   18,  311,
   80,   19,   17,  312,  319,   97,  159,   18,   80,   21,
   19,   22,  128,   82,   17,  321,  322,   80,   21,   18,
   22,  325,   19,   17,  159,  233,  343,  326,   18,   67,
   21,   19,   22,  328,   68,  116,  117,   80,   80,   21,
   82,   22,  129,   17,   17,  228,   83,   68,   18,   18,
   68,   19,   19,  350,  314,  297,  135,   80,   80,   21,
   21,   22,   22,   17,   17,  162,  334,  351,   18,   18,
  352,   19,   19,  315,  316,  356,   68,  359,  362,   21,
   21,   22,   22,  162,  162,  224,  162,  380,  365,   68,
   80,   80,   68,   63,   64,  373,   17,   17,  404,  259,
   66,   18,   18,   68,   19,   19,  318,  320,  384,  401,
  103,  103,   21,   21,   22,   22,  395,   68,   80,   80,
   68,   63,   64,  211,   17,   17,  405,  107,   66,   18,
   18,  242,   19,   19,  327,  406,  109,  331,   80,   80,
   21,   21,   22,   22,   17,   17,  407,  120,  163,   18,
   18,  329,   19,   19,  357,  150,  363,  151,  366,  410,
   21,   21,   22,   22,   80,   80,  163,  163,  412,  163,
   17,   17,  247,  161,  415,   18,   18,  388,   19,   19,
  385,  161,  161,   63,  161,   80,   21,   21,   22,   22,
  416,   17,   62,  417,   60,  418,   18,   80,  427,   19,
  173,  173,  173,  433,  173,  419,  173,   21,  420,  421,
   82,  431,  164,    2,  164,    5,  164,  424,  173,  173,
  127,  173,  425,  159,  165,   89,  165,  426,  165,   51,
  164,  164,  159,  164,  159,  374,  166,  429,  166,  430,
  166,  432,  165,  165,  434,  165,   63,   64,  161,  127,
   90,  391,   65,   66,  166,  166,  202,  166,  198,   63,
   64,    0,   63,   64,    0,   65,   66,    0,    0,   66,
   90,   90,  132,  133,    0,    0,    0,  237,  239,  134,
  240,    0,  162,  162,  162,  162,  162,    0,   63,   64,
  162,  162,    0,  162,   90,   66,    0,  248,    0,    0,
    0,   63,   64,    0,   63,   64,    0,    0,   66,    0,
    0,   66,    0,    0,    0,   63,   64,    0,    0,  269,
    0,    0,   66,  336,  337,  339,  340,  341,  342,   63,
   64,    0,   63,   64,    0,    0,   66,    0,   90,   66,
    0,  176,   90,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  146,  147,  148,  149,    0,  372,
    0,    0,    0,    0,    0,  163,  163,  163,  163,  163,
    0,    0,    0,  163,  163,    0,  163,    0,    0,    0,
    0,  333,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  173,    0,  173,  173,  173,
  173,  173,    0,    0,    0,  173,  173,  164,  173,  164,
  164,  164,  164,  164,    0,    0,    0,  164,  164,  165,
  164,  165,  165,  165,  165,  165,  250,  251,    0,  165,
  165,  166,  165,  166,  166,  166,  166,  166,    0,    0,
    0,  166,  166,    0,  166,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  280,
};
short yycheck[] = {                                      16,
   17,   18,   40,   13,   41,   26,   23,   40,   59,   44,
   20,   41,   41,   59,   40,   59,  258,   59,   59,  274,
   40,  263,   40,   16,   17,   41,   65,  282,   41,   46,
   59,   43,   44,   41,   41,   41,    7,   58,   88,   41,
   68,    7,   18,   59,  257,   55,   41,   57,   65,   41,
   40,   68,   40,   24,   41,  256,   73,   59,   24,   41,
   81,   41,   41,   80,  256,   59,   41,   40,  270,   41,
   59,   41,   59,  274,   41,   61,   41,  309,  310,  311,
  312,   40,  284,  275,   59,   40,   57,   80,   41,   41,
   41,  277,  278,   41,  256,   41,   41,   73,   40,  111,
   41,   41,  256,  124,  258,  266,  123,    1,  125,  137,
  138,   45,  274,  152,  346,  165,  258,  167,   59,   13,
  137,  138,   41,   40,  141,   96,  143,  144,  145,   59,
   41,   25,   41,   41,   41,  152,   42,   41,  257,   41,
  274,   47,   41,  160,  161,  162,  282,  123,  257,  125,
  143,  144,   43,  272,   45,   40,   59,   41,  277,  278,
   41,  178,  179,  272,  283,  182,   41,  184,  257,  186,
   40,   59,  256,  257,  195,  196,  197,   59,  199,   40,
  257,   59,   40,  272,  160,  161,  162,   45,  277,  278,
   40,  208,  256,  257,  283,  216,   40,   59,   40,  269,
   58,  269,  178,  179,   59,   41,  182,  269,  184,  226,
  186,  228,  233,  257,  256,  256,   40,  238,   40,  257,
   59,   45,  257,  269,  275,  263,   40,   40,  258,  258,
  268,  257,  208,  271,   45,  273,   59,  274,  267,  272,
  269,  279,  280,  281,  254,  255,  256,   40,  258,  256,
  226,  267,  228,  263,  267,  265,  269,  277,  278,  277,
  278,  256,   40,  284,  285,  267,  287,  257,  289,  277,
  278,  277,  278,  263,  295,  267,  286,  298,  268,  300,
  267,  271,   40,  256,  257,  267,  275,  267,  267,  279,
  263,  281,  282,  265,   40,  268,  317,  267,  271,  272,
  267,  274,  267,   40,  277,  278,  279,  280,  281,  319,
  283,  257,  258,  334,  267,  267,  267,  258,  264,  267,
   40,   59,  267,  257,  258,  266,  267,  267,  269,   40,
  264,  277,  278,  350,  351,  352,  353,  358,  355,  356,
  257,   40,  359,  277,  278,  362,  263,  368,  267,  256,
   40,  268,  256,  256,  271,  272,  267,  274,  267,  267,
  277,  278,  279,  380,  281,  267,  283,  384,  267,   59,
   40,   40,  257,   44,  350,  351,  352,  353,  263,  355,
  356,  269,   59,  359,  401,  267,  362,  257,   59,  267,
   40,   40,   59,  263,  256,  256,  257,   59,  268,  257,
  258,  271,  263,  258,  380,  275,  264,  268,  384,  279,
  271,  272,  267,  274,  270,  257,  277,  278,  279,  280,
  281,  263,  283,   40,   40,  401,  268,   41,  267,  271,
  272,   45,  274,  257,  258,  277,  278,  279,  270,  281,
  264,  283,  256,  257,  257,  256,  257,  258,   44,  263,
  263,   40,   40,  264,  268,  268,  258,  271,  271,   45,
  273,  275,  275,   59,  257,  279,  279,  281,  281,  270,
  263,   40,   40,   59,  270,  268,  269,  258,  271,  257,
   59,  274,  258,  258,  270,  263,  279,   41,  281,   59,
  268,  275,  270,  271,   41,   59,  274,   40,   40,  257,
   59,  279,   59,  281,   59,  263,   41,   59,   59,   59,
  268,  257,  270,  271,   41,   41,  274,  263,   40,   59,
  257,  279,  268,  281,   59,  271,  263,  273,   41,  275,
   59,  268,   22,  279,  271,  281,   59,  257,  275,  276,
   41,   41,  279,  263,  281,   59,  257,   59,  268,   59,
   59,  271,  263,   59,   59,  275,   41,  268,  257,  279,
  271,  281,  273,   59,  263,  275,  275,  257,  279,  268,
  281,  275,  271,  263,   59,  274,  257,  275,  268,   40,
  279,  271,  281,  275,   45,  256,  257,  257,  257,  279,
  257,  281,   40,  263,  263,   40,  263,   45,  268,  268,
   45,  271,  271,   40,  273,  275,   41,  257,  257,  279,
  279,  281,  281,  263,  263,   41,  274,   40,  268,  268,
   40,  271,  271,  273,  273,   40,   45,   40,   40,  279,
  279,  281,  281,   59,   60,   41,   62,   40,  270,   45,
  257,  257,   45,  257,  258,  257,  263,  263,   59,   41,
  264,  268,  268,   45,  271,  271,  273,  273,   40,   40,
  256,  257,  279,  279,  281,  281,   41,   45,  257,  257,
   45,  257,  258,  163,  263,  263,   59,  256,  264,  268,
  268,   59,  271,  271,  273,   59,  256,  275,  257,  257,
  279,  279,  281,  281,  263,  263,   59,  256,   41,  268,
  268,  256,  271,  271,  273,   60,  256,   62,  276,   59,
  279,  279,  281,  281,  257,  257,   59,   60,   59,   62,
  263,  263,  212,  258,   59,  268,  268,  256,  271,  271,
  273,  266,  267,  256,  269,  257,  279,  279,  281,  281,
   59,  263,  256,  275,  256,  275,  268,  256,   59,  271,
   41,   42,   43,   59,   45,  275,   47,  279,  275,  275,
  256,  256,   41,    0,   43,    0,   45,  275,   59,   60,
   59,   62,  275,  258,   41,   22,   43,  275,   45,   10,
   59,   60,  267,   62,  269,  343,   41,  275,   43,  275,
   45,  275,   59,   60,  275,   62,  257,  258,   84,   57,
   23,  368,  263,  264,   59,   60,  145,   62,  141,  257,
  258,   -1,  257,  258,   -1,  263,  264,   -1,   -1,  264,
   43,   44,  257,  258,   -1,   -1,   -1,  196,  197,  264,
  199,   -1,  258,  259,  260,  261,  262,   -1,  257,  258,
  266,  267,   -1,  269,   67,  264,   -1,  216,   -1,   -1,
   -1,  257,  258,   -1,  257,  258,   -1,   -1,  264,   -1,
   -1,  264,   -1,   -1,   -1,  257,  258,   -1,   -1,  238,
   -1,   -1,  264,  302,  303,  304,  305,  306,  307,  257,
  258,   -1,  257,  258,   -1,   -1,  264,   -1,  111,  264,
   -1,  114,  115,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  259,  260,  261,  262,   -1,  338,
   -1,   -1,   -1,   -1,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,  269,   -1,   -1,   -1,
   -1,  300,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,  269,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
  269,  258,  259,  260,  261,  262,  219,  220,   -1,  266,
  267,  256,  269,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,  269,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  249,
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
"control : REPEAT '(' asignacion_repeat ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"control : error_control",
"error_control : REPEAT asignacion_repeat ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' ';' condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat condicion ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' ';' CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion CTE_ULONG ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion ';' ')' bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion ';' CTE_ULONG bloque_repeat",
"error_control : REPEAT '(' asignacion_repeat ';' condicion ';' CTE_ULONG ')' error",
"asignacion_repeat : IDENTIFICADOR ASIGNACION CTE_ULONG",
"asignacion_repeat : error_asignacion_repeat",
"error_asignacion_repeat : ASIGNACION CTE_ULONG",
"error_asignacion_repeat : IDENTIFICADOR CTE_ULONG",
"error_asignacion_repeat : IDENTIFICADOR ASIGNACION error",
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
#line 369 "Gramatica.y"

private Lexico lexico;
private AdministradorTercetos adminTercetos;
private String ambito;
private ArrayList<String> lista_variables;  //lista de declaración de variables

public Parser(Lexico lexico, AdministradorTercetos adminTercetos)
{
  this.lexico= lexico;
  this.adminTercetos = adminTercetos;
  this.ambito = "main";
  this.lista_variables = new ArrayList<String>();
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
	int id = Main.tablaSimbolos.getId(lexema);
	if(id == Lexico.CTE_ULONG){
		System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una constante ULONG fuera de rango}");
		Main.tablaSimbolos.eliminarSimbolo(lexema);
	}
	else if (id == Lexico.CTE_DOUBLE) {
		double valor = -1*Double.parseDouble(lexema);
		if(( valor > 2.2250738585272014e-308 && valor < 1.7976931348623157e+308) || (valor > -1.7976931348623157e+308 && valor < -2.2250738585072014e-308) || (valor == 0.0))
                	Main.tablaSimbolos.modificarSimbolo(lexema, String.valueOf(valor));
                else {
                	System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "]  {Se detectó una constante DOUBLE fuera de rango}");
	               	Main.tablaSimbolos.eliminarSimbolo(lexema);
	 	}
	}
}
#line 723 "y.tab.c"
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
       	        /*TODO : asignar tipo de funcion (Main.tablaSimbolos.get*/

    	        }
break;
case 31:
#line 94 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + yyvsp[-4].sval +"'}");}
break;
case 33:
#line 99 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
#line 100 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
#line 101 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + yyvsp[-1].sval + "}");}
break;
case 36:
#line 107 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 37:
#line 109 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 38:
#line 112 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 40:
#line 116 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
#line 117 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 42:
#line 118 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 43:
#line 119 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 44:
#line 120 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
#line 121 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 46:
#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 47:
#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 48:
#line 126 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion del repeat: "+ yyvsp[-2].sval + " := "+ yyvsp[0].sval + "}");}
break;
case 50:
#line 130 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 51:
#line 131 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 52:
#line 132 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 59:
#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 60:
#line 150 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + yyvsp[-2].sval + ":= " + yyvsp[0].sval +"}");}
break;
case 62:
#line 155 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 63:
#line 156 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 64:
#line 157 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 71:
#line 172 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 72:
#line 173 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 73:
#line 174 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 74:
#line 177 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 75:
#line 178 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 76:
#line 179 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 77:
#line 180 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 78:
#line 181 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 79:
#line 182 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 80:
#line 183 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 81:
#line 184 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 82:
#line 185 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 83:
#line 189 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[-1].sval  + "'}");}
break;
case 84:
#line 190 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[0].sval  + "'}");}
break;
case 85:
#line 194 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");}
break;
case 86:
#line 195 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");}
break;
case 87:
#line 196 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");}
break;
case 89:
#line 200 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 90:
#line 201 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 91:
#line 202 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 92:
#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
#line 212 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 96:
#line 213 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 97:
#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 98:
#line 215 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 102:
#line 225 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);
			        lista_variables = (ArrayList<String>) yyvsp[-2].obj;
			        lista_variables.add(yyvsp[0].sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 103:
#line 230 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");
			                        lista_variables.add(yyvsp[0].sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 105:
#line 238 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 106:
#line 241 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ yyvsp[0].sval +"'" );}
break;
case 108:
#line 245 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 111:
#line 252 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 112:
#line 253 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 113:
#line 254 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 114:
#line 255 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 115:
#line 256 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 118:
#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 121:
#line 272 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 122:
#line 273 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 123:
#line 274 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 124:
#line 275 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 125:
#line 276 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 126:
#line 277 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 131:
#line 290 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 136:
#line 300 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 137:
#line 301 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 138:
#line 302 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 139:
#line 303 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 140:
#line 304 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 141:
#line 305 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 142:
#line 306 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 143:
#line 307 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 144:
#line 308 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 145:
#line 310 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 146:
#line 311 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 147:
#line 312 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 148:
#line 313 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 149:
#line 314 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 150:
#line 315 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 151:
#line 316 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 152:
#line 317 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 153:
#line 318 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 154:
#line 319 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 155:
#line 320 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 156:
#line 321 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 157:
#line 322 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 159:
#line 329 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 161:
#line 333 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 163:
#line 337 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  yyvsp[-1].sval + "}");}
break;
case 165:
#line 341 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 166:
#line 342 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 167:
#line 345 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 168:
#line 346 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 170:
#line 351 "Gramatica.y"
{chequearFactorNegado();}
break;
case 171:
#line 352 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");}
break;
case 172:
#line 353 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");}
break;
case 173:
#line 354 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + yyvsp[0].sval +"}");}
break;
#line 1347 "y.tab.c"
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
