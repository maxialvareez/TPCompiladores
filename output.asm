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
_b@main@f2 DD ?
_b@main@f1 DD ?
_67 DD 67
_14 DD 14
_a@main DD ?
_11 DD 11
_b@main DD ?
_9 DD 9
_7 DD 7
_var7 DD ?
_4 DD 4
_3 DD 3
_var12 DD ?
_1 DD 1
_var2 DD ?
_d@main DD ?

.code
start: 
FINIT 
MOV EBX, _4
MOV _d@main, EBX
CALL f1@main
FINIT
invoke ExitProcess, 0 
f1@main: 
MOV EBX, _7
MOV _a@main, EBX
MOV EBX, _b@main@f1
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var2, EBX
RetornoFuncion: 
RET 
MOV EBX, _null
ADD EBX, _9
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var12, EBX
MOV EBX, _var12
MOV _d@main, EBX
MOV EBX, _67
MOV _d@main, EBX
CALL f2@main
f2@main: 
MOV EBX, _11
MOV _a@main, EBX
MOV EBX, _b@main@f2
ADD EBX, _3
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var7, EBX
RetornoFuncion: 
RET 
CMP null, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV EBX, _null
MOV _d@main, EBX
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