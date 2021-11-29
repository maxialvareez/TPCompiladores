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
    4,    4,   21,   21,   17,   17,    9,    9,   25,   25,
   25,   25,   25,   25,   25,   25,   22,   22,   26,   26,
   26,   23,   24,   28,   28,   29,   29,   29,   30,   13,
   13,   32,   32,   32,   10,   36,   10,   10,   34,   34,
   39,   35,   35,   35,   40,   40,   40,   37,   37,   37,
   37,   37,   37,   37,   11,   11,   12,   12,   12,   12,
   41,   41,   41,   41,   15,   15,   42,   42,   45,   44,
   44,   44,   43,   46,   46,   18,   18,   18,   47,   19,
   19,   50,   48,   48,   52,   52,   52,   52,   52,   52,
   51,   51,   53,   20,   20,   55,   55,   55,   55,   55,
   55,   54,   49,   49,   49,   57,   56,   56,   56,   56,
   59,   59,   59,   59,   59,   59,   59,   59,   59,   59,
   59,   59,   59,   59,   59,   59,   59,   59,   58,   58,
   60,   60,   60,   60,   60,   38,   38,   61,   61,   27,
   27,   31,   31,   31,   33,   33,   33,   63,   63,   63,
   63,   63,   62,   62,   62,   62,   62,   62,
};
short yylen[] = {                                         2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    2,
    6,    1,    3,    2,    1,    1,    9,    1,    8,    8,
    8,    8,    8,    8,    8,    9,    3,    1,    2,    2,
    3,    1,    3,    1,    2,    1,    2,    1,    2,    3,
    1,    2,    2,    3,    5,    0,    8,    1,    3,    1,
    3,    1,    5,    1,    4,    5,    4,    4,    4,    4,
    4,    5,    7,    8,    4,    3,    4,    4,    4,    1,
    3,    4,    4,    4,    3,    1,    2,    1,    2,    2,
    3,    4,    3,    1,    2,    3,    1,    1,    2,    2,
    1,    2,    6,    1,    5,    5,    5,    5,    5,    6,
    2,    1,    2,    6,    1,    5,    5,    5,    5,    5,
    6,    2,    2,    1,    1,    2,    8,   10,    9,    1,
    7,    7,    7,    7,    7,    7,    7,    3,    8,    9,
    9,    9,    9,    9,    9,    9,   10,    5,    5,    1,
    4,    4,    4,    4,    5,    1,    3,    1,    3,    1,
    3,    1,    3,    3,    3,    3,    1,    2,    1,    1,
    1,    1,    1,    1,    1,    1,    1,    1,
};
short yydefred[] = {                                      0,
    0,    0,   35,   36,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  111,  114,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    9,   10,   25,    0,
    0,    0,    0,    0,   19,    0,   27,   38,   61,    0,
   68,   70,   90,    0,   96,   98,    0,    0,    4,    7,
    0,    0,    0,  108,   34,   30,  112,    0,    0,    0,
    0,    0,  110,  134,  135,    0,  140,  160,    0,  180,
    0,  179,    0,    0,  182,    0,  177,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   48,   99,   97,    0,
    0,    0,    0,    0,    0,    1,    0,   12,   11,   20,
   14,   21,   15,   22,   16,   24,   17,   23,   18,   28,
   26,    0,    0,    0,  100,    0,    0,    0,    0,    0,
   33,  109,   29,    0,    0,    0,    0,    0,    0,    0,
  136,  133,    0,    0,   64,    0,    0,    0,    0,   91,
  178,    0,    0,    0,   72,    0,   74,    0,    0,    0,
   86,   13,    8,   50,    0,   49,    0,    0,    0,    0,
  186,  187,  185,  188,  183,  184,    0,    0,    0,   71,
    0,   69,    0,    0,  104,    0,  101,   95,    0,    0,
  122,    0,    0,    0,    0,    0,  106,    0,    0,  148,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   94,
   89,   92,   87,   93,   88,  175,  176,    0,   79,   81,
    0,   80,   85,   51,   47,    0,    0,    0,    0,    0,
  102,    0,    0,    0,    0,    0,   78,  103,  105,  123,
  121,  115,    0,    0,    0,  125,  116,  119,    0,  118,
  117,    0,    0,    0,    0,    0,    0,    0,  162,  164,
    0,  163,  161,    0,    0,    0,    0,   82,   65,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,   31,
  120,  113,    0,    0,    0,    0,    0,    0,    0,  158,
    0,    0,  165,  159,    0,    0,   77,   75,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   76,   73,   83,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  142,  145,  146,  147,    0,  144,  143,    0,    0,
    0,    0,    0,    0,  141,    0,   84,   67,    0,   40,
   42,   43,    0,   45,   44,   41,   39,    0,  128,  129,
    0,  130,  127,  126,  149,  137,    0,    0,    0,    0,
    0,    0,    0,    0,    0,   56,    0,   54,   58,   46,
   37,  107,    0,  131,  124,  139,  154,  155,  156,    0,
  153,  152,  151,  150,   59,   57,   53,   55,  157,  138,
};
short yydgoto[] = {                                       6,
    7,   25,    8,    9,   26,   27,   28,   29,   30,   31,
   32,   33,   34,   35,   36,   37,   10,   53,   11,  235,
   12,   86,  216,  350,   38,   87,   91,  377,  378,  379,
   92,   39,   93,   40,  146,  261,   41,   94,   42,  147,
   43,   44,  115,   45,   46,  176,   54,   13,   63,   14,
  180,   15,  181,  359,  236,   64,   65,   66,   67,   68,
   95,  167,   77,
};
short yysindex[] = {                                    404,
   11, -220,    0,    0, -196,    0,   11,    0,    0, -233,
  -44,    0,  -39,    0,    0,  415,  395,  -22,   28,  306,
  -35,  152,  395,   11, -136,  164,    0,    0,    0,  -36,
  147,  157,  348,  358,    0,  398,    0,    0,    0, -198,
    0,    0,    0, -202,    0,    0,   35,   33,    0,    0,
   68,  -34,  -42,    0,    0,    0,    0,   30,   34,  121,
  -20,  173,    0,    0,    0,  104,    0,    0,  130,    0,
  381,    0,  140,  395,    0,   49,    0,   49,  185,   59,
  -38,   85, -154, -153,  117,  113,    0,    0,    0, -108,
  450,   95,   49,   83,  -82,    0, -136,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  185,  315, -179,    0, -122, -122, -122,  -28, -122,
    0,    0,    0,  -67,  153,   86,  216,  395,  458,  395,
    0,    0,  154,  306,    0,   95,   41,   46,   56,    0,
    0,  395,  395,  306,    0,  -75,    0,  105,  -74,  156,
    0,    0,    0,    0, -105,    0,  395,  496,  395,  -76,
    0,    0,    0,    0,    0,    0,  395,  395,  395,    0,
  395,    0,  395,  -71,    0,  206,    0,    0,  -88,  159,
    0,  -27,  160,    3,  161,  162,    0,  395,  460,    0,
  395,  215,  236,  -14,  384,   32,   38,  395,  251,    0,
    0,    0,    0,    0,    0,    0,    0,  268,    0,    0,
   50,    0,    0,    0,    0,  146,  450,  501,  148,  322,
    0,   95,   49,   49,  -82,  450,    0,    0,    0,    0,
    0,    0,  -11, -122,  337,    0,    0,    0,   89,    0,
    0,   52,  393,   65,   91,  171,  114,  376,    0,    0,
   96,    0,    0,  102,  388,  399,  277,    0,    0,  163,
  167,  179,  204,  -48,  217,  218,   18,  441,  472,    0,
    0,    0,  432,  442,   17,  459,  461,  395,  471,    0,
  395,  395,    0,    0,  462,  395,    0,    0,  402,  131,
  185,  488,  492,  494,  -32,  497,  503,  469,   76,  478,
  483,  275,  278,  279,  -13,  284,  286,  103,  482,  111,
  116,  124,  289,  125,    0,    0,    0,  310,  298,  297,
  297,  297,    4,  297,  297,  297,  319,  319,  -49,  319,
  319,    0,    0,    0,    0, -208,    0,    0,  520,  521,
   19,  522,  523,  525,    0,  529,    0,    0,  294,    0,
    0,    0, -173,    0,    0,    0,    0,  335,    0,    0,
  -69,    0,    0,    0,    0,    0,  321,  323,  325,   -4,
  327,  331,  334,  336,  421,    0,  143,    0,    0,    0,
    0,    0,   87,    0,    0,    0,    0,    0,    0, -206,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  597,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  406,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  548,    0,
    0,    0,    0,    0,    0,  443,    0,  447,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   48,  408,  560,    0,  -37,    0,  612,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  467,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  332,    0,    0,    0,    0,    0,  132,    0,    0,    0,
    0,  430,  572,  584,   70,   69,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  349,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  349,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  562,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   27,   23,    0,   42,  714,    0,  -26,   -1,    0,    0,
    0,   -9,    0,    0,  601,    0,  651,  266,    0,    0,
    0,  541,  -95,  426,    0,    0, -116,    0,  253,    0,
  -40,    0,    9,  610,  487,    0,    0,  664,    0,    0,
    0,    0,  -79,    0,    0,    0,    0,    0,    0,    0,
  -86,    0,    0, -215,    0,  575,    0,  582,    0,    0,
  476,    0,  -58,
};
#define YYTABLESIZE 973
short yytable[] = {                                      99,
   23,  124,  151,  166,   85,  120,   75,   75,  324,  361,
  295,  184,  234,   75,   56,  141,  123,   23,   60,   23,
   89,  166,  101,   51,   76,   78,  249,   24,  267,   49,
  136,  183,  185,  186,  178,   99,   47,   60,   52,   61,
  217,  217,  217,  238,  353,  336,   96,  365,   50,  399,
   23,   97,  145,  145,  390,   99,  226,  305,  298,  370,
   48,   75,  219,  220,   75,   50,  366,   81,  400,   23,
  112,  113,  252,  128,  116,  304,  177,  369,  253,  114,
  221,  201,  380,  206,  207,  145,  203,   60,  168,   23,
  142,  129,  273,  117,  113,  143,  205,  239,   23,   99,
  349,  217,   50,  154,  156,  276,  168,  118,  155,  169,
  167,  175,  360,  362,  363,  364,  329,  208,   75,   75,
   75,  145,  264,  172,   23,  191,  222,  169,  167,  272,
  124,  277,   75,   75,  328,    2,  284,  168,   50,  169,
    3,    4,  285,  339,   23,  385,    5,   75,   75,   75,
  214,  342,  215,  281,    3,    4,  343,   75,   75,   75,
  130,   75,  134,   75,  344,  346,   99,  230,  231,   73,
   23,  159,   99,  160,  229,  157,  223,  224,   75,   75,
  140,   75,   23,  173,  145,   75,  384,  358,   75,  187,
   52,   23,  188,  198,  209,  212,  213,  113,  227,  232,
  237,  240,  241,   23,  262,  103,  265,  358,   75,  294,
  278,   55,   23,  121,  122,  105,   57,   16,  166,  100,
   99,   83,  119,   17,   23,  323,  150,   84,   18,  166,
   99,   19,    2,   75,   58,  131,   16,    3,    4,   21,
   59,   22,   17,    5,  233,   23,   79,   18,    3,    4,
   19,    2,  171,   58,   23,   23,    3,    4,   21,   59,
   22,  335,    5,  145,  145,    3,    4,   16,   75,   75,
  389,   75,   75,   17,  192,   23,   75,  349,   18,    3,
    4,   19,    2,  171,   20,  171,   16,    3,    4,   21,
   23,   22,   17,    5,    3,    4,  200,   18,  171,   75,
   19,  202,  125,  168,  171,  258,   16,   23,   21,   59,
   22,  204,   17,  168,  168,   16,   23,   18,  171,  259,
   19,   17,  376,  144,  169,  167,   18,  148,   21,   19,
   22,  171,  144,   23,  169,  169,  167,   21,  170,   22,
  152,   16,   16,  122,  271,   23,  170,   17,   17,  171,
  376,  283,   18,   18,   23,   19,   19,  171,  189,  153,
  190,   16,  171,   21,   21,   22,   22,   17,  171,  171,
   16,  170,   18,   83,  210,   19,   17,  171,  144,   84,
  266,   18,  171,   21,   19,   22,  279,   16,  280,   52,
  171,  171,   21,   17,   22,  270,  137,  138,   18,   16,
  317,   19,  102,  139,  144,   17,  107,   88,   16,   21,
   18,   22,  104,   19,   17,  282,  109,  397,  375,   18,
   16,   21,   19,   22,  250,   74,   17,  286,   74,   16,
   21,   18,   22,  274,   19,   17,  292,   74,   98,   74,
   18,   16,   21,   19,   22,  133,  290,   17,  170,  107,
  291,   21,   18,   22,   73,   19,  111,  288,  144,   74,
  316,  293,   16,   21,  107,   22,  170,  170,   17,  170,
  171,   16,   16,   18,  296,  297,   19,   17,   17,  396,
  228,  300,   18,   18,   21,   19,   19,  246,  171,  171,
  302,  171,   16,   21,   21,   22,   22,  195,   17,  243,
  303,   63,   74,   18,   74,   62,   19,   16,  248,  165,
  309,  166,  301,   17,   21,   74,   22,  306,   18,  307,
  313,   19,  340,  255,   16,   60,   74,  327,  320,   21,
   17,   22,  321,   16,  322,   18,  330,  325,   19,   17,
   74,  331,  256,  326,   18,   74,   21,   19,   22,  332,
   16,  289,  333,  334,  218,   21,   17,   22,  337,  263,
  338,   18,   16,  345,   19,  347,  149,  348,   17,  375,
  349,   16,   21,   18,   22,  358,   19,   17,  367,  368,
  371,  372,   18,  373,   21,   19,   22,  374,  181,  181,
  181,  382,  181,   21,  181,  386,    2,  387,  174,  388,
  172,  391,  172,  106,  172,  392,  181,  181,  393,  181,
  394,    5,  173,  108,  173,   66,  173,   69,  172,  172,
  132,  172,   90,  383,  174,  158,  174,   80,  174,  398,
  173,  173,    0,  173,  211,  132,  135,   69,   70,  127,
   69,   70,  174,  174,   72,  174,  225,   72,    0,   69,
   70,   69,   70,  110,  287,    0,   72,  315,   72,    0,
    1,  107,  107,  170,    0,  170,  170,  170,  170,  170,
    0,   69,   70,  170,  170,    2,  395,   71,   72,    0,
    3,    4,    0,    0,    0,  171,    5,  171,  171,  171,
  171,  171,    0,    0,    0,  171,  171,  260,   63,    0,
    0,    0,   62,    0,    0,    0,    0,    0,  161,  162,
  163,  164,    0,    0,   69,   70,   69,   70,    0,    0,
    0,   72,   60,   72,    0,    0,   62,   69,   70,    0,
    0,    0,    0,   82,   72,    0,    0,    0,   69,   70,
    0,    0,    0,    0,    0,   72,  351,  352,  354,  355,
  356,  357,   69,   70,    0,    0,    0,   69,   70,   72,
    0,    0,    0,    0,   72,    0,  179,  182,  179,  179,
  179,  126,    0,    0,   62,    0,  318,  319,  381,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  194,  196,  197,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  181,    0,  181,  181,  181,  181,  181,
    0,    0,    0,  181,  181,  172,    0,  172,  172,  172,
  172,  172,    0,    0,    0,  172,  172,  173,    0,  173,
  173,  173,  173,  173,  179,    0,    0,  173,  173,  174,
  193,  174,  174,  174,  174,  174,    0,  199,    0,  174,
  174,  242,  244,    0,  245,    0,    0,    0,  251,    0,
    0,  254,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  268,  269,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  247,  275,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  299,    0,    0,
    0,  257,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  308,  310,    0,  311,  312,    0,    0,    0,  314,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  341,
};
short yycheck[] = {                                      26,
   40,   44,   41,   41,   40,   40,   16,   17,   41,   59,
   59,   40,   40,   23,   59,   74,   59,   40,   58,   40,
   22,   59,   59,  257,   16,   17,   41,    1,   40,    7,
   71,  118,  119,  120,  114,   62,  257,   58,  272,   13,
  157,  158,  159,   41,   41,   59,   24,  256,    7,  256,
   40,   25,   79,   80,   59,   82,  173,   41,   41,   41,
  257,   71,  158,  159,   74,   24,  275,   40,  275,   40,
  269,  274,   41,   40,   40,   59,  256,   59,   41,  282,
  160,   41,  256,  142,  143,  112,   41,   58,   41,   40,
   42,   58,   41,   61,  274,   47,   41,  184,   40,  126,
  274,  218,   61,  258,  258,   41,   59,   40,  263,   41,
   41,  113,  328,  329,  330,  331,   41,  144,  128,  129,
  130,  148,  218,   41,   40,   40,  167,   59,   59,   41,
   44,   41,  142,  143,   59,  272,   41,   43,   97,   45,
  277,  278,   41,   41,   40,  361,  283,  157,  158,  159,
  256,   41,  258,   40,  277,  278,   41,  167,  168,  169,
   40,  171,   59,  173,   41,   41,  193,  256,  257,   40,
   40,   59,  199,  282,  176,   59,  168,  169,  188,  189,
   41,  191,   40,  266,  211,  195,  256,  257,  198,  257,
   59,   40,   40,   40,  270,  270,   41,  274,  270,   41,
   41,   41,   41,   40,   59,   59,   59,  257,  218,  258,
   40,  256,   40,  256,  257,   59,  256,  257,  256,  256,
  247,  257,  257,  263,   40,  258,  265,  263,  268,  267,
  257,  271,  272,  243,  274,  256,  257,  277,  278,  279,
  280,  281,  263,  283,  272,   40,  269,  268,  277,  278,
  271,  272,  267,  274,   40,   40,  277,  278,  279,  280,
  281,  275,  283,  290,  291,  277,  278,  257,  278,  279,
  275,  281,  282,  263,   59,   40,  286,  274,  268,  277,
  278,  271,  272,  267,  274,  267,  257,  277,  278,  279,
   40,  281,  263,  283,  277,  278,  256,  268,  267,  309,
  271,  256,  273,  256,  267,  256,  257,   40,  279,  280,
  281,  256,  263,  266,  267,  257,   40,  268,  267,  270,
  271,  263,  349,  274,  256,  256,  268,  269,  279,  271,
  281,  267,  274,   40,  266,  267,  267,  279,  256,  281,
  256,  257,  257,  257,  256,   40,  256,  263,  263,  267,
  377,  256,  268,  268,   40,  271,  271,  267,  273,  275,
  275,  257,  267,  279,  279,  281,  281,  263,  267,  267,
  257,  256,  268,  257,  270,  271,  263,  267,  274,  263,
   59,  268,  267,  279,  271,  281,  273,  257,  275,  258,
  267,  267,  279,  263,  281,   59,  257,  258,  268,  257,
  270,  271,  256,  264,  274,  263,   59,  256,  257,  279,
  268,  281,  256,  271,  263,   40,   59,  275,  276,  268,
  257,  279,  271,  281,   41,   45,  263,   40,   45,  257,
  279,  268,  281,   41,  271,  263,  258,   45,  275,   45,
  268,  257,  279,  271,  281,  273,  284,  263,   41,   44,
  284,  279,  268,  281,   40,  271,   59,   59,  274,   45,
   59,  258,  257,  279,   59,  281,   59,   60,  263,   62,
   41,  257,  257,  268,  258,  258,  271,  263,  263,   59,
  275,   41,  268,  268,  279,  271,  271,  273,   59,   60,
   59,   62,  257,  279,  279,  281,  281,   40,  263,   40,
   59,   59,   45,  268,   45,   59,  271,  257,  273,   60,
   40,   62,   41,  263,  279,   45,  281,   59,  268,   59,
   59,  271,   41,  273,  257,   59,   45,   59,   41,  279,
  263,  281,   41,  257,   41,  268,   59,   41,  271,  263,
   45,   59,  275,   41,  268,   45,  279,  271,  281,  275,
  257,  275,  275,  275,   59,  279,  263,  281,  275,   59,
  275,  268,  257,  275,  271,  256,   80,  270,  263,  276,
  274,  257,  279,  268,  281,  257,  271,  263,   59,   59,
   59,   59,  268,   59,  279,  271,  281,   59,   41,   42,
   43,  257,   45,  279,   47,  275,    0,  275,  112,  275,
   41,  275,   43,  256,   45,  275,   59,   60,  275,   62,
  275,    0,   41,  256,   43,  284,   45,  269,   59,   60,
   59,   62,   22,  358,   41,   85,   43,   18,   45,  377,
   59,   60,   -1,   62,  148,   61,  256,  257,  258,   58,
  257,  258,   59,   60,  264,   62,  171,  264,   -1,  257,
  258,  257,  258,  256,  256,   -1,  264,  256,  264,   -1,
  257,  256,  257,  256,   -1,  258,  259,  260,  261,  262,
   -1,  257,  258,  266,  267,  272,  256,  263,  264,   -1,
  277,  278,   -1,   -1,   -1,  256,  283,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  211,  256,   -1,
   -1,   -1,  256,   -1,   -1,   -1,   -1,   -1,  259,  260,
  261,  262,   -1,   -1,  257,  258,  257,  258,   -1,   -1,
   -1,  264,  256,  264,   -1,   -1,   13,  257,  258,   -1,
   -1,   -1,   -1,   20,  264,   -1,   -1,   -1,  257,  258,
   -1,   -1,   -1,   -1,   -1,  264,  321,  322,  323,  324,
  325,  326,  257,  258,   -1,   -1,   -1,  257,  258,  264,
   -1,   -1,   -1,   -1,  264,   -1,  116,  117,  118,  119,
  120,   58,   -1,   -1,   61,   -1,  290,  291,  353,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  128,  129,  130,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  256,   -1,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,   -1,  258,
  259,  260,  261,  262,  184,   -1,   -1,  266,  267,  256,
  127,  258,  259,  260,  261,  262,   -1,  134,   -1,  266,
  267,  188,  189,   -1,  191,   -1,   -1,   -1,  195,   -1,
   -1,  198,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  233,  234,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  192,  243,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  267,   -1,   -1,
   -1,  208,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  278,  279,   -1,  281,  282,   -1,   -1,   -1,  286,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  309,
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
#line 862 "Gramatica.y"

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
case 31:
#line 94 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada " + yyvsp[-4].sval +"'}");
    	        System.out.println("*************** "+ yyvsp[-1].sval);
    	        if (yyvsp[-1].sval.equals(yyvsp[-4].sval)){
    	            String nuevoLexema = yyvsp[-4].sval+ "@" + ambito;
    	            if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(yyvsp[-4].sval, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("TypeDef");
                        ds.setTipo(yyvsp[-2].sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                    }
    	        }
                else
                    System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {" + yyvsp[-5].sval + " y " + yyvsp[-1].sval +" deben tener el mismo nombre}");

    	        }
break;
case 33:
#line 115 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
#line 116 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
#line 122 "Gramatica.y"
{yyval = new ParserVal("ULONG");}
break;
case 36:
#line 124 "Gramatica.y"
{yyval = new ParserVal("DOUBLE");}
break;
case 37:
#line 127 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");
        if((yyvsp[-6].sval != null) && (yyvsp[-4].sval != null)){
            Terceto t = new Terceto("+", yyvsp[-6].sval, yyvsp[-2].sval);
            t.setTipo("ULONG");
            adminTercetos.agregarTerceto(t);
            t = new Terceto("BI", null, null);
            adminTercetos.agregarTerceto(t);
            adminTercetos.desapilar(); /*para completar BF*/
            adminTercetos.desapilarRepeat();
            t = new Terceto("Label"+adminTercetos.cantTercetos(),null,null);
            adminTercetos.agregarTerceto(t);
        }
    }
break;
case 39:
#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 40:
#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la asignación}");}
break;
case 41:
#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 42:
#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 43:
#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 44:
#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 45:
#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 46:
#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 47:
#line 154 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion del repeat: "+ yyvsp[-2].sval + " := "+ yyvsp[0].sval + "}");
                    String ambitoVariable = Main.tablaSimbolos.verificarAmbito(yyvsp[-2].sval, ambito);
                    if(ambitoVariable != null) {
                        String tipoIdentificador = Main.tablaSimbolos.getDatos(ambitoVariable).getTipo();
                        if(tipoIdentificador.equals("ULONG")){
                            Terceto t = new Terceto(":=", ambitoVariable, yyvsp[0].sval);
                            t.setTipo("ULONG");
                            adminTercetos.agregarTerceto(t);
                            t = new Terceto("Label"+adminTerceto.cantTercetos(), null, null);
                            t.setTipo("ULONG");
                            adminTerceto.agregarTerceto(t);
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
case 48:
#line 174 "Gramatica.y"
{ yyval = new ParserVal(null); }
break;
case 49:
#line 177 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 50:
#line 178 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 51:
#line 179 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 52:
#line 183 "Gramatica.y"
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
case 59:
#line 210 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó una sentencia mal declarada, falta ';' despues del BREAK}");}
break;
case 60:
#line 213 "Gramatica.y"
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
case 62:
#line 238 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 63:
#line 239 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 64:
#line 240 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 65:
#line 244 "Gramatica.y"
{
            if(yyvsp[-3].sval != null){
                adminTercetos.desapilar();
                Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t);
                }
            }
break;
case 66:
#line 252 "Gramatica.y"
{
	        if(yyvsp[-2].sval != null){
                Terceto t = new Terceto("BI", null, null);
                adminTercetos.agregarTerceto(t);
                adminTercetos.desapilar();
                Terceto t1 = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                adminTercetos.agregarTerceto(t1);
                adminTercetos.apilar(t.getNumero());
            }
            }
break;
case 67:
#line 262 "Gramatica.y"
{
                if(yyvsp[-6].sval != null) {
                   adminTercetos.desapilar();
                   Terceto t = new Terceto("Label"+Integer.toString(adminTercetos.cantidadTercetos()), null, null);
                   adminTercetos.agregarTerceto(t);
            }
       }
break;
case 69:
#line 274 "Gramatica.y"
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
#line 290 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 75:
#line 298 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 76:
#line 299 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 77:
#line 300 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 78:
#line 303 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 79:
#line 304 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 80:
#line 305 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 81:
#line 306 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 82:
#line 307 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 83:
#line 311 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 84:
#line 312 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 85:
#line 317 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[-1].sval  + "'}");
           Terceto t = new Terceto("Impresion", yyvsp[-1].sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 86:
#line 322 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[0].sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 87:
#line 329 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");

               if (yyvsp[-1].sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(yyvsp[-3].sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(yyvsp[-3].sval).getTipo() == "ULONG"){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                        yyval = new ParserVal(ambitoFuncion);
                    }
                    else
                        if(ambitoFuncion == null){
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+yyvsp[-3].sval+" esta fuera de alcance");
                            yyval = new ParserVal(null);
                        }
                        else{
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " se invocó a la función "+yyvsp[-3].sval+" con un parámetro de otro tipo");
                            yyval = new ParserVal(null);
                        }
               }
            }
break;
case 88:
#line 350 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");
                 if (yyvsp[-1].sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(yyvsp[-3].sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(yyvsp[-3].sval).getTipo() == "DOUBLE"){
                        Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                        adminTercetos.agregarTerceto(t);
                         yyval = new ParserVal(ambitoFuncion);
                    }
                    else
                        if(ambitoFuncion == null){
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+yyvsp[-3].sval+" esta fuera de alcance");
                             yyval = new ParserVal(null);
                        }
                        else{
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " se invocó a la función "+yyvsp[-3].sval+" con un parámetro de otro tipo");
                             yyval = new ParserVal(null);
                        }
                }
            }
break;
case 89:
#line 370 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");
                 if (yyvsp[-1].sval != null){
                    String ambitoFuncion= Main.tablaSimbolos.verificarAmbito(yyvsp[-3].sval, ambito);
                    if(ambitoFuncion != null && Main.tablaSimbolos.getDatos(yyvsp[-3].sval).getTipo() == Main.tablaSimbolos.getDatos(yyvsp[-1].sval).getTipo()){
                        String ambitoParametro = Main.tablaSimbolos.verificarAmbito(yyvsp[-1].sval, ambito);
                        if (ambitoParametro != null){
                            Terceto t = new Terceto("InvocacionFuncion", ambitoFuncion, null);
                            adminTercetos.agregarTerceto(t);
                             yyval = new ParserVal(yyvsp[-3].sval);
                        }
                    }
                    else
                        if(ambitoFuncion == null){
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " la función "+yyvsp[-3].sval+" esta fuera de alcance");
                            yyval = new ParserVal(null);
                        }
                        else{
                            System.out.println("Error semántico: Linea " + Lexico.linea+ " se invocó a la función "+yyvsp[-3].sval+" con un parámetro de otro tipo");
                        }
                 }


            }
break;
case 91:
#line 396 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 92:
#line 397 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 93:
#line 398 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
#line 399 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
#line 402 "Gramatica.y"
{adminTercetos.desapilar();}
break;
case 97:
#line 407 "Gramatica.y"
{ adminTercetos.desapilar();
                                      Terceto t = new Terceto("BI", null, null);
                                      adminTercetos.agregarTerceto(t);
                                      adminTercetos.apilar(t.getNumero());
}
break;
case 99:
#line 415 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 100:
#line 418 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 101:
#line 419 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 102:
#line 420 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 106:
#line 430 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);
			        lista_variables = (ArrayList<String>) yyvsp[-2].obj;
			        lista_variables.add(yyvsp[0].sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 107:
#line 435 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");
			                        lista_variables.add(yyvsp[0].sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 109:
#line 443 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 110:
#line 447 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ yyvsp[0].sval +"'" );
            if(yyvsp[-1].sval != null && yyvsp[0].sval != null ){ /*si se declaró bien y se cumplen los PRE (en caso de haberlos)*/
                if (yyvsp[0].sval.equals("PRE")){
                   ambito = ambito.substring(0,ambito.lastIndexOf("@"));

                    Terceto t = new Terceto("RetornoFuncion", yyvsp[0].sval, null);
                    adminTercetos.agregarTerceto(t);

                     t = new Terceto("FinFuncion", yyvsp[-1].sval, null);
                    adminTercetos.agregarTerceto(t);

                    yyval = new ParserVal(yyvsp[-1].sval);
            }
                else {
                    ambito = ambito.substring(0,ambito.lastIndexOf("@"));
                    Terceto t = new Terceto("RetornoFuncion", yyvsp[-1].sval, null);
                    adminTercetos.agregarTerceto(t);
                    yyval = new ParserVal(yyvsp[-1].sval);
            }
           }
            else
                 yyval = new ParserVal(null);
         }
break;
case 112:
#line 473 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 113:
#line 476 "Gramatica.y"
{
                    parametroCopiaValor = yyvsp[-1].sval;
                    if (!parametroCopiaValor.equals("")){
                        String nuevoLexema = yyvsp[-3].sval + "@" + ambito;
                        if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                            Main.tablaSimbolos.reemplazarLexema(yyvsp[-3].sval, nuevoLexema);
                            DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                            ds.setUso("NombreFuncion");
                            ds.setTipo(yyvsp[-5].sval);
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
case 115:
#line 506 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta indicar el tipo}");}
break;
case 116:
#line 507 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 117:
#line 508 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 118:
#line 509 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 119:
#line 510 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 120:
#line 511 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 121:
#line 514 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(yyvsp[0].sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(yyvsp[-1].sval);
                Main.tablaSimbolos.setDatosSimbolo(yyvsp[0].sval, ds);
                yyval = new ParserVal(yyvsp[0].sval);
                }
break;
case 123:
#line 524 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 124:
#line 528 "Gramatica.y"
{
           System.out.println("Bloque type: " + yyvsp[0].sval + "****************");
            if (yyvsp[-3].sval != null && yyvsp[0].sval != null){

                   System.out.println("Le paso al principal: " + yyvsp[0].sval + "****************");
                    yyval = new ParserVal(yyvsp[0].sval);
                 }

            else
                yyval = new ParserVal(null);
    }
break;
case 126:
#line 542 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 127:
#line 543 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 128:
#line 544 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 129:
#line 545 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 130:
#line 546 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 131:
#line 547 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 132:
#line 550 "Gramatica.y"
{
    	        lista_variables = (ArrayList<String>)yyvsp[0].obj;
    	        for(String lexema: lista_variables){
                    String nuevoLexema = lexema + "@" + ambito;
                    if (!Main.tablaSimbolos.existeLexema(nuevoLexema)){
                        Main.tablaSimbolos.reemplazarLexema(lexema, nuevoLexema);
                        DatosSimbolo ds = Main.tablaSimbolos.getDatos(nuevoLexema);
                        ds.setUso("VariableTypeDef");
                        ds.setTipo(yyvsp[-1].sval);
                        Main.tablaSimbolos.setDatosSimbolo(nuevoLexema, ds);
                    }
                    else{
                        System.out.println("[ERROR SEMÁNTICO] [Linea " + Lexico.linea + "] {Ya se declaró la variable de función " + lexema + " en este ámbito}");
                        Main.tablaSimbolos.eliminarSimbolo(lexema);

                    }
                }
                yyval = new ParserVal (yyvsp[-1].sval);
}
break;
case 133:
#line 574 "Gramatica.y"
{
                if (yyvsp[0].sval != null)
                    yyval = new ParserVal (yyvsp[0].sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 134:
#line 580 "Gramatica.y"
{
                if (yyvsp[0].sval != null)
                    yyval = new ParserVal (yyvsp[0].sval);
                else
                    yyval = new ParserVal (null);
           }
break;
case 135:
#line 586 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 136:
#line 589 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 137:
#line 593 "Gramatica.y"
{
                        if (yyvsp[-6].sval != null && yyvsp[-3].sval != null){
                            yyval = new ParserVal ("SINPRE");
                        }
                        else
                            yyval = new ParserVal (null);
             }
break;
case 138:
#line 601 "Gramatica.y"
{
			            if (yyvsp[-8].sval != null && yyvsp[-3].sval != null){
			                yyval = new ParserVal ("PRE");
			            }
			            else
			                yyval = new ParserVal (null);
			 }
break;
case 139:
#line 608 "Gramatica.y"
{
                        if (yyvsp[-7].sval != null && yyvsp[-3].sval != null){
                            yyval = new ParserVal ("PRE");
                        }
                        else
                             yyval = new ParserVal (null);
             }
break;
case 140:
#line 616 "Gramatica.y"
{ yyval = new ParserVal (null);}
break;
case 141:
#line 619 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 142:
#line 620 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 143:
#line 621 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 144:
#line 622 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 145:
#line 623 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 146:
#line 624 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 147:
#line 625 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 148:
#line 626 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 149:
#line 627 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 150:
#line 629 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 151:
#line 630 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' después se la sentencia PRE}");}
break;
case 152:
#line 631 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 153:
#line 632 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 154:
#line 633 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 155:
#line 634 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 156:
#line 635 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 157:
#line 636 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 158:
#line 637 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 159:
#line 641 "Gramatica.y"
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
case 161:
#line 654 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la palabra 'PRE' }");}
break;
case 162:
#line 655 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ':' }");}
break;
case 163:
#line 656 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 164:
#line 657 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 165:
#line 658 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 166:
#line 661 "Gramatica.y"
{ Operando op = (Operando)yyvsp[0].obj;
                            if(op != null){
                                yyval = new ParserVal(op.getValor());
                            }
                            else
                                 yyval = new ParserVal(null);
                        }
break;
case 167:
#line 668 "Gramatica.y"
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
case 168:
#line 690 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 169:
#line 691 "Gramatica.y"
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
case 170:
#line 712 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 171:
#line 713 "Gramatica.y"
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
case 172:
#line 736 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 173:
#line 739 "Gramatica.y"
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
case 174:
#line 759 "Gramatica.y"
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
case 175:
#line 781 "Gramatica.y"
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
case 176:
#line 801 "Gramatica.y"
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
case 177:
#line 821 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 178:
#line 825 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) yyvsp[0].obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 179:
#line 830 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", yyvsp[0].sval));
        }
break;
case 180:
#line 833 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");
         yyval = new ParserVal(new Operando("ULONG", yyvsp[0].sval));
         }
break;
case 181:
#line 836 "Gramatica.y"
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
case 182:
#line 845 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocacion de funcion}");
                       String ambitoVariable = Main.tablaSimbolos.verificarAmbito(yyvsp[0].sval, ambito);
                       yyval = new ParserVal(new Operando(Main.tablaSimbolos.getDatos(ambitoVariable).getTipo(), ambitoVariable));
                       }
break;
case 183:
#line 852 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 184:
#line 853 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 185:
#line 854 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 186:
#line 855 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 187:
#line 856 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 188:
#line 857 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
#line 1913 "y.tab.c"
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
