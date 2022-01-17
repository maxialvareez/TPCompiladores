.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib

.data
_limiteSuperiorULONG DD 1000000000
_limiteInferiorULONG DD 0
_divisorCeroULONG DD 0
_divisorCeroDOUBLE DD 0.0
_OverflowSuma DB "Overflow en suma", 0 
_DivisionCero DB "Division por cero", 0 
_var11 DQ ?
_f@main DD ?
_HOLA DB 'HOLA', 0 
_MENOR DB 'MENOR', 0 
_4_0 DQ 4.0
_var1 DQ ?
_var_10 DQ ?
_1_0 DQ 1.0
_MAYOR DB 'MAYOR', 0 
_var13_2bytes DW ?
_var_8 DQ ?
_7_0 DQ 7.0
_b@main DQ ?
_b@main@f DQ ?

.code
 f@main:
FINIT 
FLD _b@main@f
FADD _1_0
FSTP _var1
FLD _var1
FSTP _b@main@f
invoke MessageBox, NULL, addr _HOLA, addr _HOLA, MB_OK 
FLD _b@main@f
FSTP _f@main
RET 
start: 
FINIT 
FLD _1_0
FSTP _b@main
FLD _b@main
FSTP _b@main@f
CALL f@main
FLD _f@main
FSTP _var_8
FLD _4_0
FSTP _b@main@f
CALL f@main
FLD _f@main
FSTP _var_10
FLD _var_8
FADD _var_10
FSTP _var11
FLD _var11
FSTP _b@main
FLD _b@main
FCOMP _7_0
FSTSW _var13_2bytes
MOV AX , _var13_2bytes
SAHF
JAE Label18
FLD _1_0
FSTP _b@main
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
JMP Label21
Label18: 
FLD _1_0
FSTP _b@main
invoke MessageBox, NULL, addr _MAYOR, addr _MAYOR, MB_OK 
Label21: 
FINIT
invoke ExitProcess, 0 
FINIT
LabelOverflowSuma: 
invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK 
invoke ExitProcess, 0 
FINIT
LabelDivisionCero: 
invoke MessageBox, NULL, addr _DivisionCero, addr _DivisionCero, MB_OK 
FINIT
end start