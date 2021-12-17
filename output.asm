.386
.model flat, stdcall
option casemap :none
include \masm32\include\windows.inc
include \masm32\include\kernel32.inc
include \masm32\include\user32.inc
includelib \masm32\lib\kernel32.lib
includelib \masm32\lib\user32.lib

.data
_limiteSuperiorULONG DD 100
_limiteInferiorULONG DD 0
_divisorCeroULONG DD 0
_divisorCeroDOUBLE DD 0.0
_OverflowSuma DB "Overflow en suma", 0 
_DivisionCero DB "Division por cero", 0 
_MENOR DB 'MENOR', 0 
_9_0 DQ 9.0
_4_8 DQ 4.8
_2_0 DQ 2.0
_MAYOR DB 'MAYOR', 0 
_a@main DQ ?
_i@main DD ?
_10 DD 10
_b@main DD ?
_9 DD 9
_z@main DQ ?
_5 DD 5
_c@main DD ?
_4 DD 4
_55 DD 55
_var3 DD ?
_var2 DD ?

.code
start: 
FINIT 
FLD _4_8
FSTP _a@main
MOV EBX, _10
MOV _b@main, EBX
MOV EBX, _b@main
ADD EBX, _5
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var2, EBX
MOV EBX, _9
MUL EBX, _4
MOV _var3, EBX
CMP var2, null
JAE Label11
FLD _null
FSTP _a@main
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
JMP Label15
Label11: 
FLD _null
FSTP _a@main
invoke MessageBox, NULL, addr _MAYOR, addr _MAYOR, MB_OK 
Label15: 
FINIT
invoke ExitProcess, 0 
FINIT
LabelOverflowSuma: 
invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK 
LabelDivisionCero: 
invoke MessageBox, NULL, addr _DivisionCero, addr _DivisionCero, MB_OK 
FINIT
invoke ExitProcess, 0
end start