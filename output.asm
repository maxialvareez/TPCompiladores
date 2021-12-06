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
_a@main@f DD ?
_z@main DD ?
_var8 DD ?
_x@main DD ?
_6 DD 6
_14 DD 14
_4 DD 4
_12 DD 12
_11 DD 11
_10 DD 10
_y@main@f DD ?

.code
start: 
FINIT 
MOV EBX, _11
MOV _x@main, EBX
MOV EBX, _12
MOV _x@main, EBX
CALL f@main
MOV EBX, _z@main
MOV _a@main@f, EBX
FINIT
invoke ExitProcess, 0 
f@main: 
MOV EBX, _14
MOV _y@main@f, EBX
RetornoFuncion: 
RET 
MOV EBX, _null
ADD EBX, _4
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var8, EBX
MOV EBX, _var8
MOV _x@main, EBX
MOV EBX, _10
MOV _x@main, EBX
MOV EBX, _6
MOV _z@main, EBX
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