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
_var9 DD ?
_z@main DD ?
_var3 DD ?
_9 DD 9
_x@main DD ?
_6 DD 6
_4 DD 4
_12 DD 12
_3 DD 3
_10 DD 10
_1 DD 1
_y@main@f DD ?

.code
start: 
FINIT 
MOV EBX, _9
MOV _x@main, EBX
MOV EBX, _12
MOV _x@main, EBX
CALL f@main
MOV EBX, _f@main
ADD EBX, _4
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var9, EBX
MOV EBX, _var9
MOV _x@main, EBX
JMP Label14
Label12: 
MOV EBX, _10
MOV _x@main, EBX
Label14: 
MOV EBX, _6
MOV _z@main, EBX
FINIT
invoke ExitProcess, 0 
f@main: 
JAE Label12
MOV EBX, _a@main@f
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var3, EBX
RetornoFuncion: 
RET 
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