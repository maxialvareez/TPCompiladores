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
_var10 DD ?
_a@main@f DD ?
_z@main DD ?
_var3 DD ?
_x@main DD ?
_6 DD 6
_4 DD 4
_12 DD 12
_3 DD 3
_11 DD 11
_10 DD 10
_1 DD 1
_varRet4 DD ?
_y@main@f DD ?

.code
start: 
FINIT 
MOV EBX, _11
MOV _x@main, EBX
MOV EBX, _12
MOV _x@main, EBX
MOV EBX, _z@main
MOV _a@main@f, EBX
CALL f@main
f@main: 
MOV EBX, _3
CMP _a@main@f, EBX
JAE Label13
MOV EBX, _a@main@f
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var3, EBX
MOV _varRet4, EAX
MOV EAX 
MOV EBX, _varRet4
ADD EBX, _4
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var10, EBX
MOV EBX, _var10
MOV _x@main, EBX
JMP Label15
Label13: 
MOV EBX, _10
MOV _x@main, EBX
Label15: 
MOV EBX, _6
MOV _z@main, EBX
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