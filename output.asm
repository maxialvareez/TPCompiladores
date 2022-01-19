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
_REPEAT DB 'REPEAT', 0 
_c@main DD ?
_z@main DQ ?
_var7 DD ?
_a@main DQ ?
_10 DD 10
_1 DD 1
_b@main DD ?
_i@main DD ?

.code
 start: 
FINIT 
MOV EBX, _1
MOV _i@main, EBX
Label1: 
MOV EBX, _10
CMP _i@main, EBX
JAE Label10
invoke MessageBox, NULL, addr _REPEAT, addr _REPEAT, MB_OK 
BREAK: 
JMP Label10
MOV EBX, _i@main
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var7, EBX
MOV EBX, _var7
MOV _i@main, EBX
JMP Label1
Label10: 
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