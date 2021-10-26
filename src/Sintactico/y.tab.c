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
    5,    6,    6,    8,    8,    8,    8,    8,    8,   14,
   14,   14,   14,   14,    7,    7,    7,   16,    4,    4,
    4,    4,   21,   21,   21,   17,   17,    9,    9,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   23,
   25,   25,   26,   26,   26,   27,   13,   13,   29,   29,
   29,   10,   10,   10,   31,   31,   31,   33,   33,   33,
   32,   32,   32,   32,   32,   32,   32,   32,   32,   11,
   12,   12,   35,   35,   15,   15,   37,   37,   37,   37,
   36,   38,   38,   18,   18,   18,   39,   19,   19,   42,
   42,   42,   42,   42,   42,   40,   40,   43,   20,   20,
   45,   45,   45,   45,   45,   45,   44,   41,   41,   41,
   47,   46,   46,   46,   46,   48,   48,   48,   48,   48,
   48,   48,   48,   48,   48,   48,   48,   48,   48,   48,
   48,   48,   48,   48,   48,   48,   48,   22,   22,   49,
   49,   50,   50,   28,   28,   28,   30,   30,   30,   34,
   34,   34,   34,   34,   51,   51,   51,   51,   51,   51,
};
short yylen[] = {                                         2,
    3,    2,    1,    2,    3,    1,    2,    3,    1,    1,
    2,    2,    3,    2,    2,    2,    2,    2,    1,    2,
    2,    2,    2,    2,    1,    2,    1,    2,    3,    3,
    6,    1,    3,    3,    2,    1,    1,   11,    1,   10,
   10,   10,   10,   10,   10,   10,   10,   10,   11,    3,
    1,    2,    1,    2,    1,    2,    3,    1,    2,    2,
    3,    7,    9,    1,    1,    5,    1,    4,    5,    4,
    6,    6,    6,    6,    6,    6,    6,    8,    8,    4,
    4,    1,    3,    4,    4,    1,    3,    3,    4,    4,
    3,    1,    2,    3,    1,    1,    2,    6,    1,    5,
    5,    5,    5,    5,    5,    2,    1,    2,    6,    1,
    5,    5,    5,    5,    5,    6,    2,    2,    1,    1,
    2,    8,   14,   13,    1,    7,    7,    7,    7,    7,
    7,    7,    3,    8,   12,   12,   12,   12,   12,   12,
   12,   12,   12,   12,   12,   13,    8,    1,    3,    1,
    3,    1,    3,    1,    3,    3,    3,    3,    1,    2,
    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,
};
short yydefred[] = {                                      0,
    0,    0,   36,   37,    0,    0,    0,    3,    6,    0,
    0,   32,   99,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    9,   10,   25,    0,    0,    0,
    0,    0,   19,    0,   27,   39,   58,   64,   82,   86,
    0,    0,    0,    0,    4,    7,    0,    0,    0,   96,
   35,    0,  162,    0,  161,    0,    0,  164,    0,  159,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  107,    1,
    0,    0,   12,   11,   20,   14,   21,   15,   22,   16,
   24,   17,   23,   18,   28,   26,    0,    0,    0,    0,
    0,   33,   97,   29,    0,   34,   30,    0,   61,    0,
   83,    0,  160,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  168,  169,  167,  170,  165,  166,    0,    0,
   13,    8,    0,    0,    0,    0,   87,    0,   88,    0,
  108,  106,    0,    0,    0,    0,    0,    0,    0,   94,
   84,   81,  157,  158,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   80,    0,    0,    0,    0,   92,    0,
   89,   85,   90,    0,    0,    0,    0,    0,  100,  119,
  120,  125,  103,    0,  104,  102,  101,    0,    0,    0,
  110,    0,   65,    0,   67,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   91,   93,    0,    0,    0,    0,
    0,  121,  118,    0,   98,    0,    0,    0,   31,    0,
   73,   74,   76,    0,   75,   72,    0,    0,    0,    0,
    0,    0,   71,    0,    0,    0,    0,    0,  133,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   62,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,   70,   68,    0,   78,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,  113,  114,
    0,  115,  112,  111,   69,   66,   63,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
   95,    0,  116,  109,    0,   40,   42,   45,   46,    0,
   48,   47,   44,   43,   41,  127,    0,    0,    0,    0,
    0,    0,    0,  130,  131,  132,    0,  129,  128,    0,
  126,    0,   53,    0,   51,   55,   49,   38,    0,    0,
    0,    0,  147,    0,    0,    0,    0,    0,  134,  122,
    0,   56,   54,   50,   52,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  137,  138,  140,  143,  144,  145,    0,  142,  141,
  139,    0,    0,  136,  135,  146,  124,    0,  123,
};
short yydgoto[] = {                                       6,
  177,   23,    8,    9,  178,   25,   26,   27,   28,   29,
   30,   31,   32,   33,   34,   35,   10,   48,   11,  190,
   12,   77,  336,   36,  364,  365,  366,   64,   37,   65,
  194,   38,  195,   60,   39,  137,   40,  170,   50,   78,
  179,   13,   79,  299,  191,  180,  181,  182,   66,   67,
  129,
};
short yysindex[] = {                                    682,
  158,  -32,    0,    0, -208,    0,  177,    0,    0, -206,
  -31,    0,    0,  130,  -35,  560,   50,  511,  -24,   25,
  189,  177,  696,  322,    0,    0,    0,  -47,  -38,   36,
   69,  113,    0,  122,    0,    0,    0,    0,    0,    0,
  -27, -158,   -3,  -35,    0,    0,   53,  141,  340,    0,
    0,   73,    0,  604,    0,  386,  -35,    0,   63,    0,
   63,  325,  -19,   71,   63, -199,  686, -205,  323,  205,
   24,  132, -193, -194, -180,  -99,   -9,   93,    0,    0,
   53,  696,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  -17,   99,  103, -158,
 -158,    0,    0,    0, -132,    0,    0,  601,    0,   71,
    0,  -10,    0,  -35,  -35, -122,  -26,  -35, -110,  -35,
  -35,  -35,    0,    0,    0,    0,    0,    0,  -35,  123,
    0,    0,  -93,  367,  -92,  537,    0, -236,    0, -193,
    0,    0, -106,  133,  133,   -4,  133,  133,  -37,    0,
    0,    0,    0,    0,  341,  341,  214, -199,  341,   63,
   63,  686,   71,    0,  110,  112,  -42,  118,    0,  528,
    0,    0,    0,  341,  240,  138,   59,  345,    0,    0,
    0,    0,    0,  133,    0,    0,    0,  -21, -158,  121,
    0,  511,    0,  -87,    0,  -86,  244,  -79,  -76,  -35,
  -35,  562,  -35,  -35,    0,    0,  -71,  161,  574,  259,
  -35,    0,    0,  168,    0,   -6,  198,  228,    0,  360,
    0,    0,    0, -214,    0,    0,   14,   74,  698,   84,
   86,   87,    0,  -35,  658,  342,   27,  644,    0,  -35,
   28,  -35,  327,    3,  344,  347,  343,  377,    0,  274,
  162,  164,  165,  151,  166,  167,  185,   30,  385,  -12,
  -35,  391,  667,   31,   35,  393,   41,  207,  207,  -45,
  207,  207,    0,    0,  374,    0,  149,  428,  431,  433,
  434,    4,  446,  448,  451,  420,  511,  511,  398,   42,
  511,  432,   16,  435,  -55,  511,  437,  241,    0,    0,
  -95,    0,    0,    0,    0,    0,    0,  230,  230,  230,
  230,  -36,  230,  230,  230,  230,  227,  402,  419,  423,
  438,  447,  450,  234,  235,  -48,  251,  258,  459,  260,
    0,    9,    0,    0,  484,    0,    0,    0,    0, -233,
    0,    0,    0,    0,    0,    0,  465,  496,  499,  286,
  506,  488,  520,    0,    0,    0, -229,    0,    0,  522,
    0,  406,    0,  295,    0,    0,    0,    0,  -35,  -35,
  -35,  648,    0,  -35,  -35,  538,  507,  -35,    0,    0,
  -35,    0,    0,    0,    0,   43,   45,   46,  694,   51,
   57,   62,  -35,  544,   77,   81,  491,  529,  532,  533,
   18,  535,  -50,  536,   82,  -35,  547,  551,  336,  352,
  358,  361,  362,   15,  363,  376,  379,  598,   83,  410,
  430,    0,    0,    0,    0,    0,    0,  404,    0,    0,
    0,  445,  609,    0,    0,    0,    0,  449,    0,
};
short yyrindex[] = {                                      0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,  710,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  497,    0,    0,    0,
    0,  768,    0,    0,    0,    0,    0,    0,  411,    0,
  422,    0,    0,  612,  780,   76,   20,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  725,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,  441,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  588,    0,  792,
  804,  306,  674,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  458,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  470,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  510,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  669,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,
};
short yygindex[] = {                                      0,
  126,   56,    0,  114,   32,    0,  -18,    6,    0,    0,
    0,  -14,    0,    0,  717,    0,  886,  444,  734,    0,
    0,    2,  577,    0,    0,  394,    0,  -20,    0,  829,
  726,    0,    0,   40,    0,  -49,    0,    0,    0,   70,
  -16,    0,    0, -119,    0,  572,    0,    0,  632,  640,
    0,
};
#define YYTABLESIZE 1102
short yytable[] = {                                      58,
   58,   58,  189,  328,  340,   84,   58,   42,  416,   57,
  357,   86,   97,  301,  157,   72,  203,   63,  216,  171,
   88,  119,  367,  145,  139,   74,  379,   51,  289,   58,
  152,  143,   24,  110,  243,   44,  184,  136,   24,   58,
  335,   58,   58,  270,  313,  380,  288,   58,   43,   70,
   47,   84,  105,   24,   58,  249,  326,  100,  414,  130,
  150,  269,   45,  117,   44,    2,  122,  262,  266,  250,
  286,  294,  251,  428,  325,  295,  413,   80,  150,  136,
  136,  297,  322,  397,  133,  398,  399,  138,  172,   68,
  173,  402,  101,   58,   90,  112,  113,  403,   44,   58,
   58,  140,  404,   58,  114,   58,   58,   58,  163,  115,
   98,   99,  108,  120,   58,  121,  148,  407,    3,    4,
   46,  408,  418,  433,  150,    7,   22,   92,  183,  185,
  186,  187,  252,  144,  148,   46,  193,  193,  193,  147,
  193,  169,  255,  148,  256,  257,  155,  112,   82,  300,
  302,  303,  304,  153,  154,  193,  141,  142,  159,   84,
  333,  298,  174,  164,  165,  168,  146,  215,  200,   56,
  201,   94,   44,  220,   57,  206,  204,  211,  193,  219,
   96,  334,  221,  222,  105,   58,   58,   58,   58,   58,
  225,   84,  135,  226,   58,   46,   58,   21,  233,  104,
  234,  227,  228,  230,  231,  232,  210,  242,   85,  282,
  237,  298,  241,  174,   58,  202,   44,   87,  174,   58,
   58,   52,   53,   58,   41,   58,  356,   58,   55,   84,
  254,  193,   71,   57,  188,  258,  260,  335,  245,  264,
  118,  265,  156,  267,   44,  151,   58,  118,   58,    3,
    4,  248,   14,   44,  118,    3,    4,  118,   15,    3,
    4,  312,  290,   16,  293,  103,   17,    2,  246,  175,
    3,    4,    3,    4,   19,  176,   20,  150,    5,   44,
  118,   69,  118,   44,  118,  150,  150,   15,  150,  427,
   46,   89,   16,  118,  118,   17,  118,  118,  240,   84,
   84,  118,   84,   19,   84,   20,   73,  118,  118,  118,
   84,  118,  118,   44,  212,   14,  363,  118,  318,  319,
  321,   15,  323,  118,   91,  374,   16,  329,  118,   17,
    2,   84,  175,  148,   44,    3,    4,   19,  176,   20,
  118,    5,  148,  118,  148,  363,  151,  118,  118,  118,
  118,  350,  118,  118,   58,   58,   58,   58,   84,   58,
   58,   44,  108,   58,  151,  116,   58,   57,   93,   57,
  386,  387,  388,  390,   58,  391,  392,   95,   58,  395,
   44,  261,  396,  377,   44,  268,   52,   53,  134,   14,
  401,   58,   54,   55,  405,   15,  102,  103,  107,   44,
   16,  274,  271,   17,    2,  272,  175,  419,  281,    3,
    4,   19,  176,   20,   14,    5,   44,  118,  307,  278,
   15,  279,  280,  283,  284,   16,  111,  167,   17,    2,
   57,   18,  306,   14,    3,    4,   19,   44,   20,   15,
    5,   44,  285,  287,   16,   52,   53,   17,    2,  291,
   18,  296,   55,    3,    4,   19,  320,   20,   44,    5,
  131,   69,   44,  298,  383,    3,    4,   15,  308,   60,
   69,  309,   16,  310,  311,   17,   15,   44,  317,  132,
   59,   16,  197,   19,   17,   20,  314,  192,  315,   44,
  324,  316,   19,  327,   20,  330,   69,  331,   44,   57,
   69,  346,   15,  335,  369,  352,   15,   16,  354,  355,
   17,   16,  208,  223,   17,   69,  105,  192,   19,  209,
   20,   15,   19,   44,   20,  358,   16,   44,   77,   17,
   69,  238,  359,  239,  361,  370,   15,   19,  371,   20,
   95,   16,   69,  276,   17,  375,   44,  192,   15,  409,
   44,   69,   19,   16,   20,   95,   17,   15,  372,  378,
  373,  381,   16,  151,   19,   17,   20,   44,   79,  384,
  362,  151,  151,   19,  151,   20,   44,  393,   69,   52,
   53,   52,   53,  406,   15,   54,   55,  410,   55,   16,
  411,  412,   17,  415,  417,  106,   83,   69,  273,   62,
   19,   69,   20,   15,   57,  420,   57,   15,   16,  421,
  422,   17,   16,  235,  192,   17,   69,  214,   57,   19,
  229,   20,   15,   19,  166,   20,  423,   16,  149,  305,
   17,  236,  424,   69,  247,  425,  426,  429,   19,   15,
   20,  111,   52,   53,   16,   57,  149,   17,   57,   55,
  430,  275,  152,  431,   69,   19,  432,   20,   69,  436,
   15,  382,    3,    4,   15,   16,   60,  438,   17,   16,
  152,  152,   17,  152,  347,   69,   19,   59,   20,   69,
   19,   15,   20,  263,  434,   15,   16,  389,   57,   17,
   16,  348,   57,   17,   69,  349,   57,   19,  259,   20,
   15,   19,   57,   20,  435,   16,   69,  292,   17,    2,
  351,   57,   15,  105,  153,   69,   19,   16,   20,  437,
   17,   15,  353,  439,    5,   77,   16,  117,   19,   17,
   20,  360,  153,  153,  400,  153,   75,   19,   57,   20,
   69,  332,   57,   49,   69,  127,   15,  128,  213,  158,
   15,   16,   95,   95,   17,   16,  253,  385,   17,  362,
  376,  162,   19,   69,   20,   79,   19,   69,   20,   15,
    0,    0,    0,   15,   16,    0,    0,   17,   16,  394,
    0,   17,    0,    0,   69,   19,    0,   20,    0,   19,
   15,   20,    0,   69,    0,   16,    0,    0,   17,   15,
    0,    0,  205,    0,   16,    0,   19,   17,  163,  163,
  163,    0,  163,    0,  163,   19,   52,   53,   52,   53,
  154,    0,  154,   55,  154,   55,  163,  163,    0,  163,
   52,   53,  155,    0,  155,    0,  155,   55,  154,  154,
    0,  154,   59,   61,  156,  149,  156,    0,  156,    0,
  155,  155,    0,  155,  149,    0,  149,   52,   53,  109,
   52,   53,  156,  156,   55,  156,    0,   55,    0,  152,
  152,  152,  152,  152,    0,    0,    0,  152,  152,    0,
  152,  196,  198,    0,  199,  337,  338,  339,  341,  342,
  343,  344,  345,    0,    0,    0,    0,   59,    0,  207,
   52,   53,    0,    0,   52,   53,   76,   55,    0,    0,
    0,   55,    0,    0,   52,   53,  368,    0,    0,    0,
    0,   55,  224,   52,   53,    0,   76,   76,    0,    0,
   55,  153,  153,  153,  153,  153,    0,    0,    1,  153,
  153,   76,  153,    0,  123,  124,  125,  126,  160,  161,
   52,   53,   81,    2,   52,   53,    0,   55,    3,    4,
    0,   55,    0,    0,    5,    0,    0,    2,    0,    0,
    0,    0,    3,    4,    0,  277,    0,    0,    5,    0,
    0,    0,   76,    0,    0,  149,   76,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,  163,    0,  163,  163,  163,  163,  163,
    0,    0,    0,  163,  163,  154,  163,  154,  154,  154,
  154,  154,    0,    0,    0,  154,  154,  155,  154,  155,
  155,  155,  155,  155,    0,    0,    0,  155,  155,  156,
  155,  156,  156,  156,  156,  156,    0,    0,    0,  156,
  156,    0,  156,  217,  218,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,  244,
};
short yycheck[] = {                                      14,
   15,   16,   40,   59,   41,   24,   21,   40,   59,   45,
   59,   59,   40,   59,   41,   40,   59,   16,   40,  256,
   59,   41,  256,   41,   74,   20,  256,   59,   41,   44,
   41,   41,    1,   54,   41,   40,   41,  274,    7,   54,
  274,   56,   57,   41,   41,  275,   59,   62,  257,   18,
  257,   70,   44,   22,   69,  270,   41,   61,   41,  265,
   41,   59,    7,   62,   40,  272,  266,   41,   41,  284,
   41,   41,   59,   59,   59,   41,   59,   22,   59,  274,
  274,   41,   41,   41,   61,   41,   41,  282,  138,   40,
  140,   41,   40,  108,   59,   56,   57,   41,   40,  114,
  115,  282,   41,  118,   42,  120,  121,  122,  129,   47,
   41,   42,   40,   43,  129,   45,   41,   41,  277,  278,
    7,   41,   41,   41,  257,    0,    1,   59,  145,  146,
  147,  148,   59,   41,   59,   22,  155,  156,  157,   41,
  159,  136,   59,   41,   59,   59,  269,  108,   23,  269,
  270,  271,  272,  114,  115,  174,  256,  257,  269,  178,
  256,  257,  269,   41,  258,  258,   97,  184,   59,   40,
   59,   59,   40,  192,   45,  170,   59,   40,  197,   59,
   59,  301,  270,  270,   44,  200,  201,  202,  203,  204,
  270,  210,   61,  270,  209,   82,  211,   40,  270,   59,
   40,  200,  201,  202,  203,  204,  175,   40,  256,   59,
  209,  257,  211,  269,  229,  258,   40,  256,  269,  234,
  235,  257,  258,  238,  257,  240,  275,  242,  264,  248,
  229,  250,  257,   45,  272,  234,  235,  274,   41,  238,
  267,  240,  269,  242,   40,  256,  261,  267,  263,  277,
  278,  220,  257,   40,  267,  277,  278,  267,  263,  277,
  278,  258,  261,  268,  263,  257,  271,  272,   41,  274,
  277,  278,  277,  278,  279,  280,  281,  258,  283,   40,
  267,  257,  267,   40,  267,  266,  267,  263,  269,  275,
  177,  256,  268,  267,  267,  271,  267,  267,   40,  318,
  319,  267,  321,  279,  323,  281,  282,  267,  267,  267,
  329,  267,  267,   40,  256,  257,  335,  267,  287,  288,
  289,  263,  291,  267,  256,   40,  268,  296,  267,  271,
  272,  350,  274,  258,   40,  277,  278,  279,  280,  281,
  267,  283,  267,  267,  269,  364,   41,  267,  267,  267,
  267,  320,  267,  267,  369,  370,  371,  372,  377,  374,
  375,   40,   40,  378,   59,   41,  381,   45,  256,   45,
  369,  370,  371,  372,  389,  374,  375,  256,  393,  378,
   40,   40,  381,  352,   40,   59,  257,  258,  257,  257,
  389,  406,  263,  264,  393,  263,  256,  257,   59,   40,
  268,   59,   59,  271,  272,   59,  274,  406,  258,  277,
  278,  279,  280,  281,  257,  283,   40,  267,  270,  258,
  263,  258,  258,  258,  258,  268,   41,   61,  271,  272,
   45,  274,   59,  257,  277,  278,  279,   40,  281,  263,
  283,   40,  258,   59,  268,  257,  258,  271,  272,   59,
  274,   59,  264,  277,  278,  279,   59,  281,   40,  283,
  256,  257,   40,  257,   59,  277,  278,  263,   41,   59,
  257,   41,  268,   41,   41,  271,  263,   40,   59,  275,
   59,  268,  269,  279,  271,  281,   41,  274,   41,   40,
   59,   41,  279,   59,  281,   59,  257,  257,   40,   59,
  257,  275,  263,  274,   40,   59,  263,  268,  275,  275,
  271,  268,  273,  270,  271,  257,   59,  274,  279,  280,
  281,  263,  279,   40,  281,  275,  268,   40,   59,  271,
  257,  273,  275,  275,  275,   40,  263,  279,   40,  281,
   44,  268,  257,  270,  271,   40,   40,  274,  263,   59,
   40,  257,  279,  268,  281,   59,  271,  263,  273,   40,
  275,   40,  268,  258,  279,  271,  281,   40,   59,  275,
  276,  266,  267,  279,  269,  281,   40,   40,  257,  257,
  258,  257,  258,   40,  263,  263,  264,   59,  264,  268,
   59,   59,  271,   59,   59,  256,  275,  257,  256,   40,
  279,  257,  281,  263,   45,   59,   45,  263,  268,   59,
  275,  271,  268,   40,  274,  271,  257,  273,   45,  279,
   59,  281,  263,  279,  258,  281,  275,  268,   41,  256,
  271,   58,  275,  257,  275,  275,  275,  275,  279,  263,
  281,   41,  257,  258,  268,   45,   59,  271,   45,  264,
  275,  275,   41,  275,  257,  279,   59,  281,  257,  256,
  263,  256,  277,  278,  263,  268,  256,   59,  271,  268,
   59,   60,  271,   62,  273,  257,  279,  256,  281,  257,
  279,  263,  281,   40,  275,  263,  268,   40,   45,  271,
  268,  273,   45,  271,  257,  273,  256,  279,   41,  281,
  263,  279,   45,  281,  275,  268,  257,   41,  271,    0,
  273,   45,  263,  256,   41,  257,  279,  268,  281,  275,
  271,  263,  273,  275,    0,  256,  268,   59,  279,  271,
  281,  273,   59,   60,   41,   62,   20,  279,   45,  281,
  257,  298,   45,   10,  257,   60,  263,   62,  177,  118,
  263,  268,  256,  257,  271,  268,   59,  364,  271,  276,
  273,  122,  279,  257,  281,  256,  279,  257,  281,  263,
   -1,   -1,   -1,  263,  268,   -1,   -1,  271,  268,  273,
   -1,  271,   -1,   -1,  257,  279,   -1,  281,   -1,  279,
  263,  281,   -1,  257,   -1,  268,   -1,   -1,  271,  263,
   -1,   -1,  275,   -1,  268,   -1,  279,  271,   41,   42,
   43,   -1,   45,   -1,   47,  279,  257,  258,  257,  258,
   41,   -1,   43,  264,   45,  264,   59,   60,   -1,   62,
  257,  258,   41,   -1,   43,   -1,   45,  264,   59,   60,
   -1,   62,   14,   15,   41,  258,   43,   -1,   45,   -1,
   59,   60,   -1,   62,  267,   -1,  269,  257,  258,  256,
  257,  258,   59,   60,  264,   62,   -1,  264,   -1,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,   -1,
  269,  156,  157,   -1,  159,  309,  310,  311,  312,  313,
  314,  315,  316,   -1,   -1,   -1,   -1,   69,   -1,  174,
  257,  258,   -1,   -1,  257,  258,   21,  264,   -1,   -1,
   -1,  264,   -1,   -1,  257,  258,  340,   -1,   -1,   -1,
   -1,  264,  197,  257,  258,   -1,   41,   42,   -1,   -1,
  264,  258,  259,  260,  261,  262,   -1,   -1,  257,  266,
  267,   56,  269,   -1,  259,  260,  261,  262,  120,  121,
  257,  258,  257,  272,  257,  258,   -1,  264,  277,  278,
   -1,  264,   -1,   -1,  283,   -1,   -1,  272,   -1,   -1,
   -1,   -1,  277,  278,   -1,  250,   -1,   -1,  283,   -1,
   -1,   -1,   97,   -1,   -1,  100,  101,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  256,   -1,  258,  259,  260,  261,  262,
   -1,   -1,   -1,  266,  267,  256,  269,  258,  259,  260,
  261,  262,   -1,   -1,   -1,  266,  267,  256,  269,  258,
  259,  260,  261,  262,   -1,   -1,   -1,  266,  267,  256,
  269,  258,  259,  260,  261,  262,   -1,   -1,   -1,  266,
  267,   -1,  269,  188,  189,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,  216,
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
"error_control : REPEAT '(' IDENTIFICADOR '=' CTE_ULONG ';' condicion ';' CTE_ULONG ')' error",
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
"invocacion : IDENTIFICADOR '(' factor ')'",
"invocacion : error_invocacion",
"error_invocacion : IDENTIFICADOR '(' ')'",
"error_invocacion : IDENTIFICADOR '(' factor error",
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
#line 319 "Gramatica.y"

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
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Se detectó un BEGIN pero falta un END para cerrar el bloque}");}
break;
case 20:
#line 51 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 21:
#line 52 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 22:
#line 53 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 23:
#line 54 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 24:
#line 55 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 28:
#line 63 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 29:
#line 68 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de variables}");}
break;
case 31:
#line 70 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función de definición de tipo llamada '" + yyvsp[-4].sval +"'}");}
break;
case 33:
#line 75 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 34:
#line 76 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ';'}");}
break;
case 35:
#line 77 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta indicar el tipo de la función " + yyvsp[-1].sval + "}");}
break;
case 38:
#line 86 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Sentencia REPEAT}");}
break;
case 40:
#line 90 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '('}");}
break;
case 41:
#line 91 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el identificador }");}
break;
case 42:
#line 92 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta '='}");}
break;
case 43:
#line 93 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante ULONG}");}
break;
case 44:
#line 94 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 45:
#line 95 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta la condición}");}
break;
case 46:
#line 96 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ';'}");}
break;
case 47:
#line 97 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta una constante CTE_ULONG}");}
break;
case 48:
#line 98 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta ')'}");}
break;
case 49:
#line 99 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {REPEAT mal declarado, falta el bloque de sentencias}");}
break;
case 56:
#line 114 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó una sentencia mal declarada, falta ';'");}
break;
case 57:
#line 117 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Asignacion : " + yyvsp[-2].sval + ":= " + yyvsp[0].sval +"}");}
break;
case 59:
#line 122 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el identificador del lado izquierdo de la asignación}");}
break;
case 60:
#line 123 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta ':=' en la asignación}");}
break;
case 61:
#line 124 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta una expresión aritmética del lado derecho de la asignación}");}
break;
case 68:
#line 139 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, si hay una sola sentencia de ejecución no debe estar entre BEGIN y END}");}
break;
case 69:
#line 140 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta ';' después del END}");}
break;
case 70:
#line 141 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada: una sola sentencia de ejecución entre un BEGIN y END, y falta ';' después del END}");}
break;
case 71:
#line 144 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Selección mal declarada, falta el IF}");}
break;
case 72:
#line 145 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta '('}");}
break;
case 73:
#line 146 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta la condición}");}
break;
case 74:
#line 147 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta ')'}");}
break;
case 75:
#line 148 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el THEN}");}
break;
case 76:
#line 149 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias}");}
break;
case 77:
#line 150 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF o ELSE}");}
break;
case 78:
#line 151 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el bloque de sentencias del ELSE}");}
break;
case 79:
#line 152 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {IF mal declarado, falta el ENDIF}");}
break;
case 81:
#line 160 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Invocación a la función '" + yyvsp[-3].sval + "'}");}
break;
case 83:
#line 164 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el parámetro}");}
break;
case 84:
#line 165 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Invocación de función mal declarada, falta el ')'}");}
break;
case 87:
#line 174 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la  sentencia ejecutable después del TRY}");}
break;
case 88:
#line 175 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra CATCH}");}
break;
case 89:
#line 176 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta el bloque de sentencias ejecutables despues del CATCH}");}
break;
case 90:
#line 177 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {No se permiten Try y Catch anidados}");}
break;
case 94:
#line 187 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {se leyo el Identificador -> " + yyvsp[0].sval);}
break;
case 95:
#line 188 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador :" + yyvsp[0].sval + "}");}
break;
case 97:
#line 193 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Sentencia mal declarada, falta ',' entre los identificadores}");}
break;
case 98:
#line 196 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Declaración de función llamada '"+ yyvsp[-4].sval +"'" );}
break;
case 100:
#line 201 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el FUNC");}
break;
case 101:
#line 202 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el nombre}");}
break;
case 102:
#line 203 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta '(' }");}
break;
case 103:
#line 204 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta el parámetro}");}
break;
case 104:
#line 205 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta ')'}");}
break;
case 105:
#line 206 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función mal declarada, falta bloque de sentencias}");}
break;
case 108:
#line 214 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Parámetro mal declarado, falta el nombre identificador}");}
break;
case 111:
#line 222 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Falta la palabra FUNC}");}
break;
case 112:
#line 223 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un '('}");}
break;
case 113:
#line 224 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta indicar el tipo}");}
break;
case 114:
#line 225 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ')'}");}
break;
case 115:
#line 226 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un ';'}");}
break;
case 116:
#line 227 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Función TYPE mal declarada, falta un el bloque de dicha función}");}
break;
case 121:
#line 240 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Funcion mal declarada, falta el bloque de sentencias ejecutables}");}
break;
case 126:
#line 250 "Gramatica.y"
{System.out.println("Error sintáctico: Linea " + Lexico.linea + " se detectó un error en una funcion, falta el BEGIN");}
break;
case 127:
#line 251 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables");}
break;
case 128:
#line 252 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN");}
break;
case 129:
#line 253 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' ");}
break;
case 130:
#line 254 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno");}
break;
case 131:
#line 255 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' ");}
break;
case 132:
#line 256 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' ");}
break;
case 133:
#line 257 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una función, falta indicar el retorno ");}
break;
case 134:
#line 258 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END ");}
break;
case 135:
#line 260 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el BEGIN}");}
break;
case 136:
#line 261 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 137:
#line 262 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta la condicion del PRE}");}
break;
case 138:
#line 263 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')'}");}
break;
case 139:
#line 264 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, ';' despuÉs se la sentencia PRE}");}
break;
case 140:
#line 265 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el bloque de sentencias ejecutables}");}
break;
case 141:
#line 266 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el RETURN}");}
break;
case 142:
#line 267 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta '(' }");}
break;
case 143:
#line 268 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar el retorno}");}
break;
case 144:
#line 269 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ')' }");}
break;
case 145:
#line 270 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta ';' }");}
break;
case 146:
#line 271 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta el END }");}
break;
case 147:
#line 272 "Gramatica.y"
{System.out.println("[ERROR SINTÁCTICO] [Linea " + Lexico.linea + "] {Error en una funcion, falta indicar un retorno }");}
break;
case 149:
#line 279 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación OR }");}
break;
case 151:
#line 283 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: AND}");}
break;
case 153:
#line 287 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: " +  yyvsp[-1].sval + "}");}
break;
case 155:
#line 291 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: SUMA }");}
break;
case 156:
#line 292 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: RESTA}");}
break;
case 157:
#line 295 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: MULTIPLICACIÓN}");}
break;
case 158:
#line 296 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Se realizó la operación: DIVISION}");}
break;
case 160:
#line 301 "Gramatica.y"
{chequearFactorNegado();}
break;
case 161:
#line 302 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante DOUBLE: " + yyvsp[0].sval + "}");}
break;
case 162:
#line 303 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Constante ULONG: " + yyvsp[0].sval + "}");}
break;
case 163:
#line 304 "Gramatica.y"
{System.out.println("[Sintáctico] [Linea " + Lexico.linea + "] {Identificador: " + yyvsp[0].sval +"}");}
break;
#line 1270 "y.tab.c"
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
