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
   38,   38,   35,   35,   35,   39,   39,   39,   36,   36,
   36,   36,   36,   36,   36,   11,   11,   12,   12,   12,
   12,   40,   40,   40,   40,   15,   15,   42,   42,   42,
   42,   41,   43,   43,   18,   18,   18,   44,   19,   19,
   47,   45,   45,   49,   49,   49,   49,   49,   48,   48,
   50,   20,   20,   52,   52,   52,   52,   52,   52,   51,
   46,   46,   46,   54,   53,   53,   53,   53,   55,   55,
   55,   55,   55,   55,   55,   55,   55,   55,   55,   55,
   55,   55,   55,   55,   55,   55,   55,   55,   55,   55,
   37,   37,   56,   56,   27,   27,   31,   31,   31,   33,
   33,   33,   58,   58,   58,   58,   58,   57,   57,   57,
   57,   57,   57,
};
short yylen[] = {                                         2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,    9,    1,    8,
    8,    8,    8,    8,    8,    8,    9,    3,    1,    2,
    2,    3,    1,    3,    1,    2,    1,    2,    1,    2,
    3,    1,    2,    2,    3,    5,    7,    1,    3,    1,
    2,    3,    1,    5,    1,    4,    5,    4,    4,    4,
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
short yydefred[] = {                                      0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,    0,  110,  113,    0,  175,    0,  174,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    9,
   10,   25,    0,    0,    0,    0,    0,   19,    0,   27,
   39,    0,    0,   62,    0,    0,   68,    0,   70,   91,
   97,    0,  172,    0,    0,    0,    0,    4,    7,    0,
    0,    0,  107,   35,  111,    0,    0,    0,    0,  109,
  132,  133,  138,    0,    0,    0,  177,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   49,    0,
    0,    0,    0,    0,    0,  120,  173,    1,    0,    0,
   12,   11,   20,   14,   21,   15,   22,   16,   24,   17,
   23,   18,   28,   26,  181,  182,  180,  183,  178,  179,
    0,    0,    0,    0,    0,    0,    0,   71,    0,    0,
    0,    0,    0,    0,   33,  108,   29,    0,   34,   30,
    0,    0,    0,    0,  134,  131,    0,    0,   65,    0,
    0,    0,    0,   92,    0,   73,    0,   75,    0,    0,
    0,   87,   13,    8,   51,    0,   50,    0,    0,    0,
    0,   98,    0,   99,    0,  121,  119,   72,   69,  114,
    0,    0,    0,  170,  171,    0,    0,    0,  117,    0,
  116,  115,    0,  105,    0,    0,    0,    0,    0,  146,
    0,    0,    0,   95,   90,   93,   88,   94,   89,    0,
   80,   82,    0,   81,   86,   52,   48,    0,    0,    0,
    0,    0,  103,    0,  100,   96,  101,   79,  118,  112,
    0,    0,    0,  123,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,   83,   66,    0,    0,
    0,    0,    0,    0,  102,  104,    0,    0,    0,   31,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   78,   76,    0,   84,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   77,   74,   85,   67,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  140,    0,    0,
    0,    0,    0,    0,    0,  143,  144,  145,    0,  142,
  141,    0,  139,    0,   41,   43,   44,    0,   46,   45,
   42,   40,    0,  126,  127,    0,  128,  125,  124,    0,
    0,    0,    0,  160,    0,    0,    0,    0,    0,  147,
  135,    0,    0,   57,    0,   55,   59,   47,   38,  106,
    0,  129,  122,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   60,   58,   54,   56,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  150,  151,  153,  156,  157,  158,    0,
  155,  154,  152,    0,    0,  149,  148,  159,  137,    0,
  136,
};
short yydgoto[] = {                                       6,
    7,   28,    8,    9,   29,   30,   31,   32,   33,   34,
   35,   77,   37,   38,   39,   40,   10,   61,   11,  233,
   12,   88,  218,  335,   41,   89,   42,  365,  366,  367,
   43,   44,   45,   46,  157,   47,   48,   49,  158,   50,
  172,   51,  224,   63,   13,   70,   14,   95,   15,   96,
  344,  234,   71,   72,   73,   52,  121,   53,
};
short yysindex[] = {                                    -82,
  172,   12,    0,    0, -241,    0,  199,    0,    0, -158,
   19,    0,  113,    0,    0,  782,    0,  208,    0,   75,
   48,  683,  218,  -36,  181,  208,  199,  342,  388,    0,
    0,    0,  141,  143,  148,  155,  372,    0,  382,    0,
    0,  546,    8,    0,   71, -157,    0,  -10,    0,    0,
    0, -135,    0,  -37, -153,   60,  208,    0,    0,  107,
   89,  393,    0,    0,    0,  226,  126,  144,  397,    0,
    0,    0,    0,  128,  443,   65,    0,   71,   71,  424,
  246,  -23,  792,  255, -112, -120,  -54,  100,    0, -113,
 -166, -110, -102,   46,  136,    0,    0,    0,  107,  342,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  208,  208,  208,  208,  208,  424,  208,    0,  208,  -22,
  140,  145, -153, -153,    0,    0,    0,  -75,    0,    0,
  153,  -28,  275,  208,    0,    0,  154,  190,    0,    8,
  -33,  -19,   68,    0,  683,    0,  -73,    0,  295,  -71,
  164,    0,    0,    0,    0, -179,    0,  208,  -39,  208,
    4,    0, -206,    0, -113,    0,    0,    0,    0,    0,
    8,   71,   71,    0,    0,  -64, -135,  546,    0,   85,
    0,    0,  -38,    0,  208,  523,  168,    7,  560,    0,
  208,   23,  208,    0,    0,    0,    0,    0,    0,  451,
    0,    0, -223,    0,    0,    0,    0,  151,  546,  463,
  238,  307,    0,  703,    0,    0,    0,    0,    0,    0,
  -29, -153,  321,    0,   51,  354,  -34,  208,  361,  534,
   52,   93,  373,   95,  401,  476,    0,    0,  314,  176,
  210,   38,  221,  227,    0,    0,  -13,  446,  454,    0,
  433,  683,  683,   30,   98,  683,  439,   22,  442,  465,
  683,  469,    0,    0,  402,    0, -133,  461,  490,  496,
   24,  500,  501,  486,   26,  488,  492,  274,  495,  515,
  552,  572,  502,  591,  287,  292,   41,  298,  308,  603,
  315,    0,    0,    0,    0,  296,  296,  296,  -27,  296,
  296,  296,  332,  332,  -46,  332,  332,    0,  561,  563,
  567,  323,  569,  632,  571,    0,    0,    0, -201,    0,
    0,  573,    0,  644,    0,    0,    0, -145,    0,    0,
    0,    0,  366,    0,    0,  -92,    0,    0,    0,  208,
  208,  208,  635,    0,  208,  208,  578,  671,  208,    0,
    0,  208,  415,    0,  358,    0,    0,    0,    0,    0,
   13,    0,    0,  115,  119,  121,  599,  122,  111,  138,
  208,  584,  139,  142,    0,    0,    0,    0,  568,  576,
  582,  583,   32,  588,  594,  605,  147,  208,  607,  614,
  355,  357,  375,  387,  399,   42,  404,  410,  411,  634,
  150,  416,  419,    0,    0,    0,    0,    0,    0,  440,
    0,    0,    0,  429,  643,    0,    0,    0,    0,  431,
    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  844,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  710,    0,    0,
    0,    0,    0,    0,    0,  991,    0,    0,    0,    0,
    0,   91,  857,    0,  752,    0,    0,    0,    0,    0,
    0,   17,    0,    0,    0,    0,    0,    0,    0,  485,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  938,    0,    0,    0,  427,  434,    0,
    0,    0,  844,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  712,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  441,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  896,  962,  982,    0,    0,    0,   25,  108,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   63,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  444,
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
  658,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  444,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,
};
short yygindex[] = {                                      0,
   58,   33,    0,   35,  -12,    0,   61,  386,    0,    0,
    0,   14,    0,    0,  694,    0,  745,  381,  715,    0,
    0,  642, -124,  750,    0,    0,  860,    0,  380,    0,
  -49,    0,   21,  711,  -57,    0,  -25,    0,    0,    0,
  -68,    0,    0,    0,    0,    0,    0,  -20,    0,    0,
  421,    0,  678,    0,    0,  622,    0,    3,
};
#define YYTABLESIZE 1258
short yytable[] = {                                      94,
   69,  232,  130,   57,  168,   26,  264,  205,   26,   84,
  257,  196,  346,  338,   36,   56,   26,  162,  189,  220,
   36,  207,  174,  160,  263,  150,   36,  284,   97,  197,
  128,   94,  247,  131,  132,   36,   78,   36,   79,   58,
   36,   59,   36,   57,  221,  222,  248,  239,   26,  225,
  122,   55,  123,  143,  360,   69,  138,  161,   27,   98,
  249,   59,  297,  243,  310,  162,  315,  171,  186,   57,
   68,  181,  406,  361,   26,  161,  216,   64,  217,   36,
  296,   36,   36,  162,  314,  100,  179,   82,  291,  102,
  405,  261,  269,   36,   36,  252,  281,   36,   60,  329,
  420,  213,   59,   78,  226,  154,  227,  171,  209,  190,
  368,  126,  124,    2,   57,  173,  198,  125,  202,   26,
  133,   53,  304,    3,    4,  230,  184,  185,  334,  102,
  129,  163,  138,  270,   59,  272,  305,  167,  293,   36,
  156,  156,  182,  183,  102,  165,  134,  137,  164,  163,
  166,  395,   57,  176,  177,  389,   36,   26,  170,  390,
  171,  391,  394,  372,  343,  144,  164,  148,   36,  235,
  237,  175,   36,  241,    1,  242,  180,  244,  396,  399,
  191,  194,  400,   57,   36,  192,  156,  410,   26,    2,
  425,  277,  195,  203,    3,    4,  211,  246,  214,  104,
    5,  106,   85,  102,  215,  228,  108,  238,   86,  250,
  343,   25,  265,  110,  268,  210,   26,   74,   17,  156,
   83,   17,  204,   36,   19,   26,   18,   19,   74,   17,
  154,   20,  127,  231,   21,   19,  206,   36,   57,    3,
    4,  161,   23,   26,   24,   90,  334,    3,    4,  289,
  290,  292,   26,  294,    3,    4,  127,   87,  300,   36,
   83,   17,   36,    3,    4,   57,   18,   19,   54,  136,
   26,   20,  161,  127,   21,   36,   36,   36,  322,   36,
  162,  309,   23,  161,   36,   57,   83,   17,  127,  127,
   26,  162,   18,   19,   57,  280,  253,   20,  127,   26,
   21,  178,   36,   36,   36,   36,  102,   36,   23,  156,
   24,  358,  127,   36,  201,  328,  419,  127,  127,   26,
   53,  151,  152,  208,  374,  375,  376,  378,  153,  379,
  380,   74,   17,  383,   57,   36,  384,   36,   19,   26,
  229,    3,    4,   80,  135,  136,  163,   36,  178,  102,
  102,  393,  102,   57,  102,  397,  163,  163,   26,  127,
  102,  127,  355,  164,  127,  254,  178,   26,   65,   16,
   17,   36,  411,  164,  164,   18,   19,  127,   36,  260,
   20,  127,  102,   21,    2,  127,   66,  127,  127,    3,
    4,   23,   67,   24,  364,    5,  103,   57,  105,  145,
   16,   17,   26,  107,  127,  127,   18,   19,  127,   91,
  109,   20,  262,  127,   21,    2,  127,   66,  102,  266,
    3,    4,   23,   67,   24,  364,    5,   57,   16,   17,
  112,  271,   26,  278,   18,   19,   57,   74,   17,   20,
  114,   26,   21,    2,   19,   22,  151,  152,    3,    4,
   23,  140,   24,  153,    5,   16,   17,    3,    4,  274,
  303,   18,   19,   57,   74,   17,   20,  279,   26,   21,
    2,   19,   22,  386,   85,    3,    4,   23,  282,   24,
   86,    5,   83,   17,  283,   64,  286,   26,   18,   19,
   57,  288,   63,   20,  287,   26,   21,  295,  141,   61,
  298,  306,   83,   17,   23,  142,   24,   26,   18,   19,
  163,   83,   17,   20,  159,   57,   21,   18,   19,  155,
   26,  251,   20,  299,   23,   21,   24,  301,  106,  164,
  307,   83,   17,   23,   57,   24,  308,   18,   19,   26,
  311,  312,   20,  106,  313,   21,  316,  199,  318,  200,
  317,   83,   17,   23,   57,   24,  223,   18,   19,   26,
  324,  326,   20,  236,  212,   21,  327,   26,  155,  334,
   83,   17,  330,   23,  267,   24,   18,   19,   26,   83,
   17,   20,  331,  276,   21,   18,   19,  155,  343,  333,
   20,   57,   23,   21,   24,  353,   26,  354,   99,  240,
  350,   23,  351,   24,   26,  119,  352,  120,  356,  256,
  359,   57,  362,    2,   83,   17,   26,  381,    3,    4,
   18,   19,  370,  398,    5,   20,  401,  111,   21,  414,
   57,  415,  387,  363,  402,   26,   23,  113,   24,  392,
  403,  404,   57,   26,   83,   17,  407,   26,  139,  416,
   18,   19,  408,   83,   17,   20,  273,  302,   21,   18,
   19,  417,  101,  409,   20,  412,   23,   21,   24,  147,
  385,   57,  413,  418,  377,   23,   26,   24,  421,   26,
   83,   17,   64,   57,  422,  423,   18,   19,   26,   63,
  426,   20,  424,  427,   21,  428,   61,  155,  149,   74,
   17,  430,   23,  429,   24,  431,   19,   83,   17,    2,
   57,    5,   69,   18,   19,   26,  130,   92,   20,   74,
   17,   21,   57,  371,   62,  245,   19,   26,  169,   23,
   81,   24,   83,   17,  345,  347,  348,  349,   18,   19,
  106,  106,   57,   20,  388,  146,   21,   26,  187,    0,
  275,   83,   17,    0,   23,    0,   24,   18,   19,    0,
    0,    0,   20,    0,    0,   21,  373,  319,    0,   93,
    0,   83,   17,   23,    0,   24,    0,   18,   19,   74,
   17,    0,   20,    0,    0,   21,   19,  320,    0,    0,
   74,   17,  167,   23,  167,   24,  167,   19,   93,   93,
    0,    0,    0,    0,  115,  116,  117,  118,   83,   17,
  167,  167,    0,  167,   18,   19,   74,   17,    0,   20,
   93,   76,   21,   19,  321,    0,   26,    0,   83,   17,
   23,  148,   24,    0,   18,   19,   26,    0,    0,   20,
    0,    0,   21,    0,  323,    0,    0,   83,   17,    0,
   23,    0,   24,   18,   19,   74,   17,    0,   20,   83,
   17,   21,   19,  325,    0,   18,   19,    0,    0,   23,
   20,   24,    0,   21,   93,  332,    0,  193,   93,    0,
    0,   23,    0,   24,  176,  176,  176,    0,   83,   17,
  176,   74,   17,    0,   18,   19,    0,  165,   19,   20,
   83,   17,   21,  176,  357,  176,   18,   19,    0,    0,
   23,   20,   24,    0,   21,  165,  165,    0,  165,  363,
    0,    0,   23,    0,   24,    0,    0,   83,   17,    0,
    0,    0,    0,   18,   19,    0,  166,    0,   20,   83,
   17,   21,    0,  382,    0,   18,   19,    0,    0,   23,
   20,   24,    0,   21,  166,  166,    0,  166,    0,   83,
   17,   23,    0,   24,    0,   18,   19,    0,    0,    0,
   20,    0,    0,   21,    0,  258,  259,  255,  176,  176,
  176,   23,  176,    0,  176,    0,    0,    0,  188,    0,
    0,    0,    0,    0,    0,    0,  176,  176,    0,  176,
    0,  285,  168,    0,  168,    0,  168,  167,    0,  167,
  167,  167,  167,  167,    0,    0,    0,  167,  167,    0,
  168,  168,  169,  168,  169,    0,  169,  219,  219,  219,
    0,  177,  177,  177,    0,  177,    0,  177,   74,   17,
  169,  169,    0,  169,   75,   19,    0,    0,   74,   17,
  177,    0,  177,    0,   75,   19,  336,  337,  339,  340,
  341,  342,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  219,
    0,    0,    0,    0,    0,    0,    0,  369,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  176,  176,  176,  176,    0,    0,    0,  176,
  176,    0,  165,    0,  165,  165,  165,  165,  165,    0,
    0,    0,  165,  165,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  166,    0,  166,  166,  166,  166,  166,    0,    0,
    0,  166,  166,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  176,    0,  176,  176,  176,  176,  176,
    0,    0,    0,  176,  176,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  168,    0,  168,
  168,  168,  168,  168,    0,    0,    0,  168,  168,    0,
    0,    0,    0,    0,    0,    0,    0,  169,    0,  169,
  169,  169,  169,  169,    0,    0,    0,  169,  169,  177,
  177,  177,  177,    0,    0,    0,  177,  177,
};
short yycheck[] = {                                      25,
   13,   40,   40,   40,   59,   45,   41,   41,   45,   22,
   40,   40,   59,   41,    1,  257,   45,   41,   41,   59,
    7,   41,   91,   81,   59,   75,   13,   41,   26,   58,
   41,   57,  256,   54,   55,   22,   16,   24,   18,    7,
   27,    7,   29,   40,  169,  170,  270,   41,   45,  256,
   43,   40,   45,   66,  256,   68,   44,   41,    1,   27,
  284,   27,   41,   41,   41,   41,   41,  274,  126,   40,
   13,  121,   41,  275,   45,   59,  256,   59,  258,   66,
   59,   68,   69,   59,   59,   28,   41,   40,   59,   29,
   59,   41,   41,   80,   81,  220,   59,   84,  257,   59,
   59,  159,   68,   83,  173,   41,  175,  274,   41,  130,
  256,  269,   42,  272,   40,  282,  142,   47,  144,   45,
   61,   59,  256,  277,  278,   41,  124,  125,  274,   69,
  266,   41,   44,   41,  100,   41,  270,  258,   41,  126,
   80,   81,  122,  123,   84,  258,   40,   59,   41,   59,
  263,   41,   40,  256,  257,   41,  143,   45,   59,   41,
  274,   41,   41,  256,  257,   40,   59,   40,  155,  195,
  196,  282,  159,  199,  257,  201,   41,  203,   41,   41,
   41,  257,   41,   40,  171,   41,  126,   41,   45,  272,
   41,  249,   40,   40,  277,  278,  270,  210,  270,   59,
  283,   59,  257,  143,   41,  270,   59,   40,  263,   59,
  257,   40,  238,   59,  240,  155,   45,  257,  258,  159,
  257,  258,  256,  210,  264,   45,  263,  264,  257,  258,
   41,  268,  267,  272,  271,  264,  256,  224,   40,  277,
  278,  265,  279,   45,  281,  282,  274,  277,  278,  262,
  263,  264,   45,  266,  277,  278,  267,   40,  271,  246,
  257,  258,  249,  277,  278,   40,  263,  264,  257,  257,
   45,  268,  256,  267,  271,  262,  263,  264,  291,  266,
  256,  258,  279,  267,  271,   40,  257,  258,  267,  267,
   45,  267,  263,  264,   40,  258,   59,  268,  267,   45,
  271,  256,  289,  290,  291,  292,  246,  294,  279,  249,
  281,  324,  267,  300,   40,  275,  275,  267,  267,   45,
  258,  257,  258,  256,  350,  351,  352,  353,  264,  355,
  356,  257,  258,  359,   40,  322,  362,  324,  264,   45,
  256,  277,  278,  269,  256,  257,  256,  334,  256,  289,
  290,  377,  292,   40,  294,  381,  266,  267,   45,  267,
  300,  267,   40,  256,  267,   59,  256,   45,  256,  257,
  258,  358,  398,  266,  267,  263,  264,  267,  365,   59,
  268,  267,  322,  271,  272,  267,  274,  267,  267,  277,
  278,  279,  280,  281,  334,  283,  256,   40,  256,  256,
  257,  258,   45,  256,  267,  267,  263,  264,  267,   24,
  256,  268,   59,  267,  271,  272,  267,  274,  358,   59,
  277,  278,  279,  280,  281,  365,  283,   40,  257,  258,
   59,   59,   45,  258,  263,  264,   40,  257,  258,  268,
   59,   45,  271,  272,  264,  274,  257,  258,  277,  278,
  279,   59,  281,  264,  283,  257,  258,  277,  278,   59,
   59,  263,  264,   40,  257,  258,  268,  258,   45,  271,
  272,  264,  274,   59,  257,  277,  278,  279,  258,  281,
  263,  283,  257,  258,  258,   59,   41,   45,  263,  264,
   40,   59,   59,  268,   41,   45,  271,   59,  273,   59,
   59,   41,  257,  258,  279,  280,  281,   45,  263,  264,
  256,  257,  258,  268,  269,   40,  271,  263,  264,  274,
   45,   59,  268,   59,  279,  271,  281,   59,   44,  275,
   41,  257,  258,  279,   40,  281,   41,  263,  264,   45,
   41,   41,  268,   59,   59,  271,   59,  273,  275,  275,
   59,  257,  258,  279,   40,  281,  171,  263,  264,   45,
   59,  275,  268,   41,  270,  271,  275,   45,  274,  274,
  257,  258,  275,  279,   41,  281,  263,  264,   45,  257,
  258,  268,  275,  270,  271,  263,  264,  274,  257,  275,
  268,   40,  279,  271,  281,  273,   45,  275,  257,   40,
   40,  279,   40,  281,   45,   60,   40,   62,   40,  224,
   40,   40,   40,  272,  257,  258,   45,   40,  277,  278,
  263,  264,  257,   40,  283,  268,   59,  256,  271,  275,
   40,  275,  275,  276,   59,   45,  279,  256,  281,   41,
   59,   59,   40,   45,  257,  258,   59,   45,  256,  275,
  263,  264,   59,  257,  258,  268,  256,  256,  271,  263,
  264,  275,  275,   59,  268,   59,  279,  271,  281,  273,
  256,   40,   59,  275,   40,  279,   45,  281,  275,   45,
  257,  258,  256,   40,  275,  275,  263,  264,   45,  256,
  275,  268,   59,  275,  271,  256,  256,  274,  256,  257,
  258,   59,  279,  275,  281,  275,  264,  257,  258,    0,
   40,    0,  269,  263,  264,   45,   59,   24,  268,  257,
  258,  271,   40,  343,   10,  275,  264,   45,   87,  279,
   20,  281,  257,  258,  314,  315,  316,  317,  263,  264,
  256,  257,   40,  268,  365,   68,  271,   45,  127,   -1,
  275,  257,  258,   -1,  279,   -1,  281,  263,  264,   -1,
   -1,   -1,  268,   -1,   -1,  271,  346,  273,   -1,   25,
   -1,  257,  258,  279,   -1,  281,   -1,  263,  264,  257,
  258,   -1,  268,   -1,   -1,  271,  264,  273,   -1,   -1,
  257,  258,   41,  279,   43,  281,   45,  264,   54,   55,
   -1,   -1,   -1,   -1,  259,  260,  261,  262,  257,  258,
   59,   60,   -1,   62,  263,  264,  257,  258,   -1,  268,
   76,   40,  271,  264,  273,   -1,   45,   -1,  257,  258,
  279,   40,  281,   -1,  263,  264,   45,   -1,   -1,  268,
   -1,   -1,  271,   -1,  273,   -1,   -1,  257,  258,   -1,
  279,   -1,  281,  263,  264,  257,  258,   -1,  268,  257,
  258,  271,  264,  273,   -1,  263,  264,   -1,   -1,  279,
  268,  281,   -1,  271,  130,  273,   -1,  133,  134,   -1,
   -1,  279,   -1,  281,   41,   42,   43,   -1,  257,  258,
   47,  257,  258,   -1,  263,  264,   -1,   41,  264,  268,
  257,  258,  271,   60,  273,   62,  263,  264,   -1,   -1,
  279,  268,  281,   -1,  271,   59,   60,   -1,   62,  276,
   -1,   -1,  279,   -1,  281,   -1,   -1,  257,  258,   -1,
   -1,   -1,   -1,  263,  264,   -1,   41,   -1,  268,  257,
  258,  271,   -1,  273,   -1,  263,  264,   -1,   -1,  279,
  268,  281,   -1,  271,   59,   60,   -1,   62,   -1,  257,
  258,  279,   -1,  281,   -1,  263,  264,   -1,   -1,   -1,
  268,   -1,   -1,  271,   -1,  231,  232,  275,   41,   42,
   43,  279,   45,   -1,   47,   -1,   -1,   -1,  129,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   59,   60,   -1,   62,
   -1,  257,   41,   -1,   43,   -1,   45,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,
   59,   60,   41,   62,   43,   -1,   45,  168,  169,  170,
   -1,   41,   42,   43,   -1,   45,   -1,   47,  257,  258,
   59,   60,   -1,   62,  263,  264,   -1,   -1,  257,  258,
   60,   -1,   62,   -1,  263,  264,  307,  308,  309,  310,
  311,  312,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  220,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  338,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,
   -1,   -1,  266,  267,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  256,   -1,  258,  259,  260,  261,  262,   -1,   -1,
   -1,  266,  267,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  256,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  259,
  260,  261,  262,   -1,   -1,   -1,  266,  267,
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
"error_condicion_if : condicion ')'",
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
#line 681 "Gramatica.y"

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
#line 779 "y.tab.c"
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
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 72:
#line 250 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta un parentesis en la condicion'}");}
break;
case 76:
#line 259 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 77:
#line 260 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 78:
#line 261 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 79:
#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 80:
#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 81:
#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 82:
#line 267 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 83:
#line 268 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 84:
#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 85:
#line 270 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 86:
#line 274 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[-1].sval  + "'}");
           Terceto t = new Terceto("Impresion", yyvsp[-1].sval, null);
           adminTercetos.agregarTerceto(t);
           }
break;
case 87:
#line 279 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Impresión : '" + yyvsp[0].sval  + "'}");
            Terceto t = new Terceto("Impresion", "", null);
            adminTercetos.agregarTerceto(t);
           }
break;
case 88:
#line 286 "Gramatica.y"
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
#line 296 "Gramatica.y"
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
#line 306 "Gramatica.y"
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
#line 320 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 93:
#line 321 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 94:
#line 322 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 95:
#line 323 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 98:
#line 332 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 99:
#line 333 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 100:
#line 334 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 101:
#line 335 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 105:
#line 345 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);
			        lista_variables = (ArrayList<String>) yyvsp[-2].obj;
			        lista_variables.add(yyvsp[0].sval);
			        yyval = new ParserVal(lista_variables);
			        }
break;
case 106:
#line 350 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");
			                        lista_variables.add(yyvsp[0].sval);
                                    yyval = new ParserVal(lista_variables);
                                    }
break;
case 108:
#line 358 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 109:
#line 362 "Gramatica.y"
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
#line 375 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 112:
#line 378 "Gramatica.y"
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
#line 407 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta la palabra FUNC}");}
break;
case 115:
#line 408 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 116:
#line 409 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 117:
#line 410 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 118:
#line 411 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 119:
#line 414 "Gramatica.y"
{
                DatosSimbolo ds = Main.tablaSimbolos.getDatos(yyvsp[0].sval); /* el identificador ya esta agregado en la tabla de simbolos (se hace en el lexico)*/
                ds.setUso("NombreParametro");
                ds.setTipo(yyvsp[-1].sval);
                Main.tablaSimbolos.setDatosSimbolo(yyvsp[0].sval, ds);
                yyval = new ParserVal(yyvsp[0].sval);

                }
break;
case 121:
#line 425 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 124:
#line 433 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 125:
#line 434 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 126:
#line 435 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 127:
#line 436 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 128:
#line 437 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 129:
#line 438 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 134:
#line 451 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 139:
#line 461 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 140:
#line 462 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 141:
#line 463 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 142:
#line 464 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 143:
#line 465 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 144:
#line 466 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 145:
#line 467 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 146:
#line 468 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 147:
#line 469 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 148:
#line 471 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 149:
#line 472 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 150:
#line 473 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 151:
#line 474 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 152:
#line 475 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 153:
#line 476 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 154:
#line 477 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 155:
#line 478 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 156:
#line 479 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 157:
#line 480 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 158:
#line 481 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 159:
#line 482 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 160:
#line 483 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 161:
#line 489 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 162:
#line 490 "Gramatica.y"
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
case 163:
#line 512 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 164:
#line 513 "Gramatica.y"
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
case 165:
#line 534 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 166:
#line 535 "Gramatica.y"
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
case 167:
#line 558 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 168:
#line 561 "Gramatica.y"
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
case 169:
#line 581 "Gramatica.y"
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
case 170:
#line 603 "Gramatica.y"
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
case 171:
#line 623 "Gramatica.y"
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
case 172:
#line 643 "Gramatica.y"
{ yyval = new ParserVal((Operando)yyvsp[0].obj);}
break;
case 173:
#line 647 "Gramatica.y"
{ if (chequearFactorNegado()){
                                  Operando operando = (Operando) yyvsp[0].obj;
                                  yyval = new ParserVal(new Operando(operando.getTipo(), "-" + operando.getValor())) ;
                               }
                            }
break;
case 174:
#line 652 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");
            yyval = new ParserVal(new Operando("DOUBLE", yyvsp[0].sval));
        }
break;
case 175:
#line 655 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");
         yyval = new ParserVal(new Operando("ULONG", yyvsp[0].sval));
         }
break;
case 176:
#line 658 "Gramatica.y"
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
case 178:
#line 671 "Gramatica.y"
{ yyval = new ParserVal("<");}
break;
case 179:
#line 672 "Gramatica.y"
{ yyval = new ParserVal(">");}
break;
case 180:
#line 673 "Gramatica.y"
{ yyval = new ParserVal("==");}
break;
case 181:
#line 674 "Gramatica.y"
{ yyval = new ParserVal(">=");}
break;
case 182:
#line 675 "Gramatica.y"
{ yyval = new ParserVal("<=");}
break;
case 183:
#line 676 "Gramatica.y"
{ yyval = new ParserVal("<>");}
break;
#line 1758 "y.tab.c"
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
