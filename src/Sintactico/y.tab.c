#ifndef lint
static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";
#endif
#define YYBYACC 1
#line 2 "Gramatica.y"
package Sintactico;
import Principal.*;
#line 9 "y.tab.c"
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
    5,    6,    6,    7,    7,   10,    8,    8,    8,    8,
    8,    8,   16,   16,   16,   16,   16,    4,    4,    4,
    4,   21,   21,   21,   17,   17,   11,   11,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   23,   25,
   25,   26,   26,   26,   27,   15,   15,   29,   29,   29,
   12,   12,   12,   31,   31,   31,   33,   33,   33,   32,
   32,   32,   32,   32,   32,   32,   32,   32,   13,   14,
   14,   35,   35,   35,   35,    9,    9,   37,   37,   37,
   37,   36,   36,   38,   38,   18,   18,   18,   39,   19,
   19,   41,   41,   41,   41,   41,   41,   34,   34,   42,
   20,   20,   44,   44,   44,   44,   44,   44,   43,   40,
   40,   40,   46,   45,   45,   45,   45,   47,   47,   47,
   47,   47,   47,   47,   47,   47,   47,   47,   47,   47,
   47,   47,   47,   47,   47,   47,   47,   47,   47,   22,
   22,   48,   48,   49,   49,   28,   28,   28,   30,   30,
   30,   51,   51,   51,   51,   50,   50,   50,   50,   50,
   50,
};
short yylen[] = {                                         2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    3,    1,    2,    2,    2,    2,    2,
    2,    1,    2,    2,    2,    2,    2,    3,    3,    6,
    1,    3,    3,    2,    1,    1,   11,    1,   10,   10,
   10,   10,   10,   10,   10,   10,   10,   10,    3,    1,
    2,    1,    2,    1,    2,    3,    1,    2,    2,    2,
    7,    9,    1,    1,    5,    1,    4,    5,    4,    6,
    6,    6,    6,    6,    6,    6,    8,    8,    4,    4,
    1,    3,    3,    3,    3,    4,    1,    3,    3,    3,
    4,    3,    3,    1,    2,    3,    1,    1,    2,    6,
    1,    5,    5,    5,    5,    5,    5,    2,    1,    2,
    6,    1,    5,    5,    5,    5,    5,    6,    2,    2,
    1,    1,    2,    8,   14,   13,    1,    7,    7,    7,
    7,    7,    7,    7,    3,    8,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   12,   12,   13,    8,    1,
    3,    1,    3,    1,    3,    1,    3,    3,    3,    3,
    1,    2,    1,    1,    1,    1,    1,    1,    1,    1,
    1,
};
short yydefred[] = {                                      0,
    0,    0,   35,   36,    0,    0,    0,    3,    6,    0,
    0,   31,  101,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    9,   10,    0,    0,   15,    0,
    0,    0,    0,    0,   22,   38,   57,   63,   81,   87,
    0,    0,    0,    0,    4,    7,    0,    0,    0,   98,
   34,  165,  164,    0,  163,    0,    0,    0,    0,    0,
  109,  161,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    1,    0,
    0,   12,   11,    0,    0,    0,   16,   23,   17,   24,
   18,   25,   19,   27,   20,   26,   21,    0,    0,    0,
    0,    0,    0,   32,   99,   28,    0,   33,   29,    0,
   84,    0,  162,  110,  108,    0,    0,   83,    0,    0,
    0,    0,    0,    0,    0,  169,  170,  168,  171,  166,
  167,    0,    0,    0,   13,    8,    0,    0,    0,    0,
   89,    0,   90,    0,    0,   88,   14,    0,    0,    0,
    0,    0,   82,    0,   96,    0,  159,  160,    0,    0,
    0,    0,    0,    0,    0,    0,    0,   79,    0,    0,
    0,    0,    0,    0,    0,    0,   91,   86,    0,    0,
    0,    0,    0,  102,  121,  122,  127,  105,    0,  106,
  104,  103,    0,    0,    0,  112,    0,    0,   64,    0,
   66,    0,    0,    0,    0,   80,    0,    0,    0,    0,
    0,   93,   92,   95,    0,    0,    0,    0,    0,  123,
  120,    0,  100,    0,    0,    0,   30,    0,   72,   73,
   75,    0,   74,   71,    0,    0,    0,    0,    0,    0,
   70,    0,    0,    0,    0,    0,  135,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   61,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   69,   67,    0,   77,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  115,  116,    0,  117,
  114,  113,   68,   65,   62,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   97,    0,
  118,  111,    0,   39,   41,   44,   45,    0,   47,   46,
   43,   42,   40,  129,    0,    0,    0,    0,    0,    0,
    0,  132,  133,  134,    0,  131,  130,    0,  128,    0,
   52,    0,   50,   54,   37,    0,    0,    0,    0,  149,
    0,    0,    0,    0,    0,  136,  124,    0,   55,   53,
   49,   51,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  139,  140,
  142,  145,  146,  147,    0,  144,  143,  141,    0,    0,
  138,  137,  148,  126,    0,  125,
};
short yydgoto[] = {                                       6,
  182,   23,    8,    9,  183,   25,   26,   27,   28,   29,
   30,   31,   32,   33,   34,   35,   10,   48,   11,  195,
   12,   77,  344,   36,  372,  373,  374,   66,   37,   67,
  200,   38,  201,  102,   39,  141,   40,  176,   50,  184,
   13,   61,  307,  196,  185,  186,  187,   68,   69,  132,
   62,
};
short yysindex[] = {                                    497,
  122,  -29,    0,    0, -223,    0,  145,    0,    0, -177,
  -19,    0,    0,  507,  594,  366,   10,  476,  102,  164,
   72,  145,  597,  278,    0,    0,  110, -203,    0,  421,
  433,  439,  441,  444,    0,    0,    0,    0,    0,    0,
  -38, -173,    9,   72,    0,    0,   26,  351,  452,    0,
    0,    0,    0,  594,    0,  -36,  594, -133,   -1,   75,
    0,    0,   -1,  540,  -11,   77,   -1, -189,  560, -146,
  524,   24,   68,  459, -148, -195,   27,   91,    0,   26,
  597,    0,    0, -148, -145,   88,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  -27,   97,  104,
 -173,  105, -173,    0,    0,    0, -103,    0,    0,   77,
    0,  114,    0,    0,    0,  594,  594,    0, -118,    3,
  594, -113,  594,  594,  594,    0,    0,    0,    0,    0,
    0,  594,  116,  -36,    0,    0, -100,  162,  -98,  476,
    0, -209,    0, -105,   63,    0,    0,   63,  -14,   63,
   63,  -28,    0,  126,    0,   63,    0,    0,  287,  287,
  168, -189,  287,   -1,   -1,  560,   77,    0,  127,  113,
  118,  154,  123, -145, -102,  346,    0,    0,  287,  177,
  135,    5,  299,    0,    0,    0,    0,    0,   63,    0,
    0,    0,  -30, -173,  125,    0,   63,  476,    0,  -94,
    0,  -84,  197,  -83,  -82,    0,  594,  594,  -42,  594,
  594,    0,    0,    0,  -81,  159,  598,  206,  594,    0,
    0,  160,    0,   -3,  161,  165,    0,  308,    0,    0,
    0, -201,    0,    0,  -43,  115,  -39,  120,  131,  137,
    0,  594,  559,  169,   30,  615,    0,   72,   31,  594,
  151,   19,  153,  155,  458,  331,    0,  231,  156,  157,
  171,  324,  175,  180,  183,   33,  385,  -34,  594,  393,
  635,   41,   43,  394,   48,  -37,  -37,  -50,  -37,  -37,
    0,    0,  475,    0,  189,  420,  423,  425,  431,  112,
  432,  434,  443,  403,  476,  476,  348,   52,  476,  424,
   -8,  427,  106,  476,  437,  233,    0,    0, -121,    0,
    0,    0,    0,    0,    0,  217,  217,  217,  217,  -22,
  217,  217,  217,  217,  218,  369,  378,  390,  411,  438,
  415,  240,  249,  -46,  258,  261,  430,  265,    0,  117,
    0,    0,  442,    0,    0,    0,    0,  217,    0,    0,
    0,    0,    0,    0,  502,  503,  505,  250,  508,  449,
  511,    0,    0,    0, -233,    0,    0,  514,    0,  478,
    0,  251,    0,    0,    0,  594,  594,  594,  625,    0,
   72,  594,  523,  469,  594,    0,    0,  594,    0,    0,
    0,    0,   55,   57,   58,  640,   61,   65,   66,  594,
  533,   84,   86,  515,  525,  531,  537,   22,  538,  107,
  542,   87,  594,  554,  572,  317,  343,  379,  392,  398,
  -44,  400,  416,  429,  585,   90,  440,  450,    0,    0,
    0,    0,    0,    0,  446,    0,    0,    0,  454,  648,
    0,    0,    0,    0,  466,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  719,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  516,    0,    0,    0,
    0,    0,    0,  479,    0,    0,    0,    0,  480,    0,
    0,    0,  527,    0,    0,  574,  717,  237,   35,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  724,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  534,
    0,  539,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  569,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  586,    0,    0,    0,    0,
    0,  536,    0,  748,  768,   89,  785,    0,  539,    0,
    0,    0,    0,  488,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  593,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  603,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  605,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  668,
    0,    0,    0,    0,    0,    0,    0,  607,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
   36,   79,    0,  731,   17,    0,  -20,   29,   -6,    0,
    0,    0,    0,    0,    0,    0,  -13,  455,  733,    0,
    0,  -16,  588,    0,    0,  374,    0,  -32,    0,   47,
 -106,    0,    0,  825,    0,   -9,    0,    0,    0,  -40,
    0,    0, -165,    0,  567,    0,    0,  631,  641,    0,
  -25,
};
#define YYTABLESIZE 1054
short yytable[] = {                                      65,
   58,   98,   57,   83,  111,   57,  297,   58,  309,  224,
   42,  194,  365,  148,  435,  259,  237,   24,  348,  261,
   86,  110,  386,   24,  296,   44,  189,   58,   58,  122,
   58,  113,  334,   43,   72,    7,   22,  251,   24,   51,
  116,  387,   58,  161,   44,  117,  177,  120,   76,   70,
  333,   83,   87,  202,  204,   85,  205,   58,   81,  278,
   59,   63,  421,   44,  140,  103,  143,  144,  257,  101,
  270,  274,  215,  294,  146,  152,  125,  277,  140,   47,
  420,  302,  258,  303,   58,   45,  142,  152,  305,   58,
  157,  158,  330,  152,    2,  404,  232,  405,  406,  167,
   79,  409,   44,    3,    4,  410,  411,  188,  190,  191,
  192,  308,  310,  311,  312,  118,   57,   59,  133,  123,
   58,  124,  114,  115,  414,  140,  415,  425,  137,  153,
  440,  145,  178,  175,  341,  306,   84,  150,  199,  199,
  199,   74,  199,  342,  151,  153,  147,  153,  223,   44,
  159,  285,  321,  155,  156,  163,  168,  170,  199,  173,
  107,   21,   83,  179,  336,  423,  197,  206,  174,  164,
  165,  207,  212,  260,  219,  229,  208,  228,  263,  225,
  226,  211,  199,  227,   44,  230,  233,  234,  241,  264,
  235,  236,  238,  239,  240,  265,  218,   83,  242,  250,
  245,  253,  249,   44,  214,  254,  306,   44,  269,  276,
  252,  279,  210,  280,   52,   53,   44,   52,   53,  306,
  262,   55,  172,  121,   55,  266,  268,   41,  364,  272,
  434,  273,  121,  275,   58,   83,   44,  199,    3,    4,
    3,    4,   14,  193,  256,  248,    3,    4,   15,    3,
    4,  343,  298,   16,  301,  121,   17,    2,  121,  180,
  220,   14,    3,    4,   19,  181,   20,   15,    5,  121,
   44,  160,   16,    3,    4,   17,    2,  150,  180,  135,
   71,    3,    4,   19,  181,   20,   15,    5,  121,  381,
   44,   16,  152,  121,   17,  150,  121,  121,  136,  121,
  152,  152,   19,  152,   20,   83,   83,  121,   83,  121,
   83,  326,  327,  329,  121,  331,   83,   44,  121,   14,
  337,  121,  371,  121,  121,   15,   44,  121,   52,   53,
   16,  121,  121,   17,    2,   55,  180,   83,   44,    3,
    4,   19,  181,   20,  358,    5,  153,   44,    3,    4,
  121,  371,  121,  121,  153,  153,  121,  153,   73,  393,
  394,  395,  397,   83,  398,  399,   71,   58,  402,  320,
   44,  403,   15,  105,  179,  179,  384,   16,   14,  408,
   17,  121,  290,  412,   15,   44,  121,   44,   19,   16,
   20,   84,   17,    2,  107,   18,  426,  121,    3,    4,
   19,   14,   20,  121,    5,   64,  328,   15,   44,  106,
   57,  209,   16,  286,  287,   17,    2,   44,   18,  171,
   71,    3,    4,   19,   71,   20,   15,    5,  288,   44,
   15,   16,  291,   71,   17,   16,  203,  292,   17,   15,
  293,  198,   19,  295,   16,   75,   19,   17,   20,  216,
   44,  299,  304,   71,   44,   19,  217,   20,  315,   15,
  316,  325,   71,  317,   16,  318,  231,   17,   15,   44,
  198,  319,  322,   16,  323,   19,   17,   20,  246,   89,
  247,   44,  332,  324,   19,  335,   20,   71,   44,  339,
  343,   91,  354,   15,  150,  338,  360,   93,   16,   95,
  284,   17,   97,  150,  198,  150,   71,   71,   44,   19,
  109,   20,   15,   15,  362,   44,  282,   16,   16,  139,
   17,   17,  379,  363,  380,  391,  370,   94,   19,   19,
   20,   20,  366,  314,   71,  367,  390,   60,   59,  369,
   15,  376,  377,   71,  378,   16,   56,  382,   17,   15,
  385,   57,   82,  388,   16,   71,   19,   17,   20,   97,
  198,   15,  400,  134,   71,   19,   16,   20,   57,   17,
   15,  222,  413,  416,   97,   16,  151,   19,   17,   20,
  119,  289,  255,  417,   57,   58,   19,   71,   20,  418,
  121,  429,   56,   15,  151,  419,  422,   85,   16,  267,
  424,   17,   71,   57,   71,  283,  104,  105,   15,   19,
   15,   20,  427,   16,  154,   16,   17,  430,   17,  130,
  213,  131,   52,   53,   19,   71,   19,   82,   20,   55,
  428,   15,  154,  154,   71,  154,   16,  243,   57,   17,
   15,  355,   57,  439,   80,   16,   71,   19,   17,   20,
  356,  107,   15,  431,  271,  244,   19,   16,   20,   57,
   17,   76,  357,   78,  396,   48,  432,   71,   19,   57,
   20,   71,  433,   15,  436,  300,   88,   15,   16,   57,
  407,   17,   16,  359,   57,   17,   71,  361,   90,   19,
  437,   20,   15,   19,   92,   20,   94,   16,   71,   96,
   17,  443,  368,  438,   15,   71,  445,  108,   19,   16,
   20,   15,   17,  281,  441,  138,   16,  370,    2,   17,
   19,  383,   20,    5,  442,   71,  119,   19,  444,   20,
  313,   15,   71,  389,   60,   59,   16,   46,   15,   17,
  446,  401,   49,   16,   94,  392,   17,   19,  221,   20,
   94,  162,   46,    1,   19,   94,   20,  156,   94,  156,
  340,  156,   94,   52,   53,  166,   94,    0,    2,   54,
   55,   97,   97,    3,    4,  156,  156,    0,  156,    5,
   52,   53,   58,    3,    4,    0,   54,   55,  157,   56,
  157,    0,  157,  151,   85,    0,   52,   53,    0,    0,
    3,    4,  151,   55,  151,    0,  157,  157,  158,  157,
  158,   46,  158,    0,    0,   52,   53,    0,  126,  127,
  128,  129,   55,    0,   82,  155,  158,  158,    0,  158,
    0,  154,  154,  154,  154,  154,    0,    0,   60,  154,
  154,   80,  154,  155,  155,   78,  155,    0,  107,    0,
   52,   53,    0,   80,   52,   53,    0,   55,   76,    0,
   78,   55,   48,    0,    0,   99,  100,    0,    2,    0,
    0,   52,   53,    3,    4,    0,    0,    0,   55,    5,
  112,   52,   53,    0,    0,    0,    0,    0,   55,    0,
    0,   52,   53,    0,    0,   60,   52,   53,   55,    0,
    0,    0,    0,   55,  345,  346,  347,  349,  350,  351,
  352,  353,   46,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  149,    0,    0,    0,    0,  154,    0,    0,
    0,    0,    0,    0,    0,  375,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  169,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  156,    0,  156,  156,  156,  156,  156,    0,
    0,    0,  156,  156,    0,  156,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  157,    0,  157,  157,  157,  157,  157,
    0,    0,    0,  157,  157,    0,  157,    0,    0,    0,
    0,    0,    0,  158,    0,  158,  158,  158,  158,  158,
    0,    0,    0,  158,  158,    0,  158,    0,    0,    0,
    0,    0,  155,  155,  155,  155,  155,    0,    0,    0,
  155,  155,    0,  155,
};
short yycheck[] = {                                      16,
   14,   40,   45,   24,   41,   45,   41,   21,   59,   40,
   40,   40,   59,   41,   59,   59,   59,    1,   41,   59,
   27,   54,  256,    7,   59,   40,   41,   41,   42,   41,
   44,   57,   41,  257,   18,    0,    1,   41,   22,   59,
   42,  275,   56,   41,   40,   47,  256,   64,   20,   40,
   59,   72,  256,  160,  161,   27,  163,   71,   23,   41,
   14,   15,   41,   40,  274,   40,   76,   41,  270,   61,
   41,   41,  179,   41,   84,   41,  266,   59,  274,  257,
   59,   41,  284,   41,   98,    7,  282,  101,   41,  103,
  116,  117,   41,   59,  272,   41,  203,   41,   41,  132,
   22,   41,   40,  277,  278,   41,   41,  148,  149,  150,
  151,  277,  278,  279,  280,   41,   45,   71,  265,   43,
  134,   45,  256,  257,   41,  274,   41,   41,   61,   41,
   41,   41,  142,  140,  256,  257,  282,   41,  159,  160,
  161,   40,  163,  309,   41,   41,   59,   59,  189,   40,
  269,  258,   41,  257,   41,  269,   41,  258,  179,  258,
   44,   40,  183,  269,   59,   59,   41,   41,  140,  123,
  124,   59,  275,   59,   40,  270,   59,  198,   59,  193,
  194,   59,  203,   59,   40,  270,  270,  270,  270,   59,
  207,  208,  209,  210,  211,   59,  180,  218,   40,   40,
  217,   41,  219,   40,  176,   41,  257,   40,   40,   59,
  224,   59,   59,   59,  257,  258,   40,  257,  258,  257,
  237,  264,   61,  267,  264,  242,  243,  257,  275,  246,
  275,  248,  267,  250,  248,  256,   40,  258,  277,  278,
  277,  278,  257,  272,  228,   40,  277,  278,  263,  277,
  278,  274,  269,  268,  271,  267,  271,  272,  267,  274,
  256,  257,  277,  278,  279,  280,  281,  263,  283,  267,
   40,  269,  268,  277,  278,  271,  272,   41,  274,  256,
  257,  277,  278,  279,  280,  281,  263,  283,  267,   40,
   40,  268,  258,  267,  271,   59,  267,  267,  275,  267,
  266,  267,  279,  269,  281,  326,  327,  267,  329,  267,
  331,  295,  296,  297,  267,  299,  337,   40,  267,  257,
  304,  267,  343,  267,  267,  263,   40,  267,  257,  258,
  268,  267,  267,  271,  272,  264,  274,  358,   40,  277,
  278,  279,  280,  281,  328,  283,  258,   40,  277,  278,
  267,  372,  267,  267,  266,  267,  267,  269,  257,  376,
  377,  378,  379,  384,  381,  382,  257,  381,  385,  258,
   40,  388,  263,  257,  269,  269,  360,  268,  257,  396,
  271,  267,   59,  400,  263,   40,  267,   40,  279,  268,
  281,  282,  271,  272,   44,  274,  413,  267,  277,  278,
  279,  257,  281,  267,  283,   40,   59,  263,   40,   59,
   45,  258,  268,  258,  258,  271,  272,   40,  274,  258,
  257,  277,  278,  279,  257,  281,  263,  283,  258,   40,
  263,  268,  258,  257,  271,  268,  269,  258,  271,  263,
  258,  274,  279,   59,  268,  282,  279,  271,  281,  273,
   40,   59,   59,  257,   40,  279,  280,  281,  270,  263,
   41,   59,  257,   41,  268,   41,  270,  271,  263,   40,
  274,   41,   41,  268,   41,  279,  271,  281,  273,   59,
  275,   40,   59,   41,  279,   59,  281,  257,   40,  257,
  274,   59,  275,  263,  258,   59,   59,   59,  268,   59,
  270,  271,   59,  267,  274,  269,  257,  257,   40,  279,
   59,  281,  263,  263,  275,   40,   59,  268,  268,   61,
  271,  271,  273,  275,  275,  275,  276,   40,  279,  279,
  281,  281,  275,   59,  257,  275,   59,   59,   59,  275,
  263,   40,   40,  257,   40,  268,   40,   40,  271,  263,
   40,   45,  275,   40,  268,  257,  279,  271,  281,   44,
  274,  263,   40,   40,  257,  279,  268,  281,   45,  271,
  263,  273,   40,   59,   59,  268,   41,  279,  271,  281,
   41,  258,  275,   59,   45,   59,  279,  257,  281,   59,
  267,  275,   59,  263,   59,   59,   59,   59,  268,   41,
   59,  271,  257,   45,  257,  275,  256,  257,  263,  279,
  263,  281,   59,  268,   41,  268,  271,  275,  271,   60,
  275,   62,  257,  258,  279,  257,  279,   59,  281,  264,
   59,  263,   59,   60,  257,   62,  268,   40,   45,  271,
  263,  273,   45,   59,   59,  268,  257,  279,  271,  281,
  273,   59,  263,  275,   40,   58,  279,  268,  281,   45,
  271,   59,  273,   59,   40,   59,  275,  257,  279,   45,
  281,  257,  275,  263,  275,   41,  256,  263,  268,   45,
   41,  271,  268,  273,   45,  271,  257,  273,  256,  279,
  275,  281,  263,  279,  256,  281,  256,  268,  257,  256,
  271,  256,  273,  275,  263,  257,   59,  256,  279,  268,
  281,  263,  271,  256,  275,  257,  268,  276,    0,  271,
  279,  273,  281,    0,  275,  257,   59,  279,  275,  281,
  256,  263,  257,  256,  256,  256,  268,    7,  263,  271,
  275,  273,   10,  268,  257,  372,  271,  279,  182,  281,
  263,  121,   22,  257,  279,  268,  281,   41,  271,   43,
  306,   45,  275,  257,  258,  125,  279,   -1,  272,  263,
  264,  256,  257,  277,  278,   59,   60,   -1,   62,  283,
  257,  258,  256,  277,  278,   -1,  263,  264,   41,  256,
   43,   -1,   45,  258,  256,   -1,  257,  258,   -1,   -1,
  277,  278,  267,  264,  269,   -1,   59,   60,   41,   62,
   43,   81,   45,   -1,   -1,  257,  258,   -1,  259,  260,
  261,  262,  264,   -1,  256,   41,   59,   60,   -1,   62,
   -1,  258,  259,  260,  261,  262,   -1,   -1,   14,  266,
  267,  256,  269,   59,   60,   21,   62,   -1,  256,   -1,
  257,  258,   -1,  257,  257,  258,   -1,  264,  256,   -1,
  256,  264,  256,   -1,   -1,   41,   42,   -1,  272,   -1,
   -1,  257,  258,  277,  278,   -1,   -1,   -1,  264,  283,
   56,  257,  258,   -1,   -1,   -1,   -1,   -1,  264,   -1,
   -1,  257,  258,   -1,   -1,   71,  257,  258,  264,   -1,
   -1,   -1,   -1,  264,  317,  318,  319,  320,  321,  322,
  323,  324,  182,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   98,   -1,   -1,   -1,   -1,  103,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,  348,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  134,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,
   -1,   -1,  266,  267,   -1,  269,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,  269,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,  269,   -1,   -1,   -1,
   -1,   -1,  258,  259,  260,  261,  262,   -1,   -1,   -1,
  266,  267,   -1,  269,
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
"sentencia_ejecucion : sentencia_ejecutable try_catch ';'",
"sentencia_ejecucion : error_sentencia_ejecucion",
"error_sentencia_ejecucion : try_catch error",
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
"try_catch : TRY sentencia_ejecutable CATCH bloque_catch",
"try_catch : error_try_catch",
"error_try_catch : sentencia_ejecutable CATCH bloque_catch",
"error_try_catch : TRY CATCH bloque_catch",
"error_try_catch : TRY sentencia_ejecutable bloque_catch",
"error_try_catch : TRY sentencia_ejecutable CATCH error",
"bloque_catch : BEGIN bloque_1 END",
"bloque_catch : BEGIN try_catch END",
"bloque_1 : sentencia_ejecutable",
"bloque_1 : bloque_1 sentencia_ejecutable",
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
#line 320 "Gramatica.y"

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
#line 714 "y.tab.c"
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
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +yyvsp[-2].sval + "'}");}
break;
case 2:
#line 13 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Programa llamado '" +yyvsp[-1].sval + "'}");}
break;
case 4:
#line 17 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se debe indicar un nombre para el programa}");}
break;
case 5:
#line 18 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "{Mal posicionamiento de sentencias declarativas");}
break;
case 12:
#line 37 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un END pero falta un BEGIN para iniciar el bloque}");}
break;
case 13:
#line 38 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN per falta un END para cerrar el bloque}");}
break;
case 16:
#line 48 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
#line 59 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
#line 60 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 25:
#line 61 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 26:
#line 62 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 27:
#line 63 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
#line 67 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 30:
#line 69 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + yyvsp[-4].sval +"'}");}
break;
case 32:
#line 74 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 33:
#line 75 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
#line 76 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + yyvsp[-1].sval + "}");}
break;
case 37:
#line 85 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 39:
#line 89 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 40:
#line 90 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 41:
#line 91 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 42:
#line 92 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 43:
#line 93 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 44:
#line 94 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 45:
#line 95 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 46:
#line 96 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 47:
#line 97 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 48:
#line 98 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 55:
#line 113 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 56:
#line 116 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + yyvsp[-2].sval + ":= " + yyvsp[0].sval +"}");}
break;
case 58:
#line 121 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 59:
#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 60:
#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 67:
#line 138 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 68:
#line 139 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 69:
#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 70:
#line 143 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 71:
#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 72:
#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 73:
#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 74:
#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 75:
#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 76:
#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 77:
#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 78:
#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 80:
#line 159 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación al procedimiento '" + yyvsp[-3].sval + "'}");}
break;
case 82:
#line 163 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el identificador}");}
break;
case 83:
#line 164 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el '('}");}
break;
case 84:
#line 165 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 85:
#line 166 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 88:
#line 175 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra TRY}");}
break;
case 89:
#line 176 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 90:
#line 177 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 91:
#line 178 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 93:
#line 182 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 96:
#line 190 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);}
break;
case 97:
#line 191 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");}
break;
case 99:
#line 196 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 100:
#line 198 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ yyvsp[-4].sval +"'" );}
break;
case 102:
#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 103:
#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 104:
#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 105:
#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 106:
#line 207 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 107:
#line 208 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 110:
#line 216 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 113:
#line 224 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 114:
#line 225 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 115:
#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 116:
#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 117:
#line 228 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 118:
#line 229 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 123:
#line 242 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 128:
#line 252 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 129:
#line 253 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 130:
#line 254 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 131:
#line 255 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 132:
#line 256 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 133:
#line 257 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 134:
#line 258 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 135:
#line 259 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 136:
#line 260 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 137:
#line 262 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 138:
#line 263 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 139:
#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 140:
#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 141:
#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 142:
#line 267 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 143:
#line 268 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 144:
#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 145:
#line 270 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 146:
#line 271 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 147:
#line 272 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 148:
#line 273 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 149:
#line 274 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 151:
#line 281 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 153:
#line 285 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 155:
#line 289 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  yyvsp[-1].sval + "}");}
break;
case 157:
#line 293 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 158:
#line 294 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 159:
#line 297 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 160:
#line 298 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 162:
#line 303 "Gramatica.y"
{chequearFactorNegado();}
break;
case 163:
#line 304 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");}
break;
case 164:
#line 305 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");}
break;
case 165:
#line 306 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + yyvsp[0].sval +"}");}
break;
#line 1278 "y.tab.c"
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
