.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib

.data
_limiteSuperiorULONG DD 4294967295
_limiteInferiorULONG DD 0
_divisorCeroULONG DD 0
_divisorCeroDOUBLE DD 0.0
_OverflowSuma DB "Overflow en suma", 0 
_DivisionCero DB "Division por cero", 0 
_HOLA DB 'HOLA', 0 
_MENOR DB 'MENOR', 0 
_var4 DQ ?
_var1 DQ ?
_1_0 DQ 1.0
_MAYOR DB 'MAYOR', 0 
_b@main DQ ?
_varRet4 DQ ?
_b@main@f DQ ?
_var11_2bytes DW ?
_3_0 DQ 3.0

.code
start: 
FINIT 
FLD _1_0
FSTP _b@main
FLD _b@main
FSTP _b@main@f
CALL f@main
f@main: 
FLD _b@main@f
FADD _1_0
FSTP _var1
FLD _var1
FSTP _b@main@f
invoke MessageBox, NULL, addr _HOLA, addr _HOLA, MB_OK 
FLD _b@main@f
FADD _1_0
FSTP _var4
FLD _var4
FSTP _varRet4
FLD _varRet4
FSTP _b@main
FLD _b@main
FCOMP _3_0
FSTSW _var11_2bytes
MOV AX , _var11_2bytes
SAHF
JAE Label16
FLD _1_0
FSTP _b@main
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
JMP Label19
Label16: 
FLD _1_0
FSTP _b@main
invoke MessageBox, NULL, addr _MAYOR, addr _MAYOR, MB_OK 
Label19: 
FINIT
invoke ExitProcess, 0 
FINIT
LabelOverflowSuma: 
invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK 
FINIT
LabelDivisionCero: 
invoke MessageBox, NULL, addr _DivisionCero, addr _DivisionCero, MB_OK 
FINIT
invoke ExitProcess, 0
end start