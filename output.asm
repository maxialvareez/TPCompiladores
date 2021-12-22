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
_MENOR DB 'MENOR', 0 
_a@main DD ?
_MAYOR DB 'MAYOR', 0 
_3 DD 3
_2 DD 2
_b@main DD ?
_b@main@f DD ?

.code
start: 
FINIT 
MOV EBX, _3
MOV _b@main, EBX
CALL f@main
MOV EBX, _b@main
MOV _b@main@f, EBX
f@main: 
MOV EBX, _2
MOV _b@main@f, EBX
RetornoFuncion: 
RET 
MOV RetVal, EAX 
MOV EBX, _null
MOV _a@main, EBX
MOV EBX, _3
CMP _a@main, EBX
JAE Label13
MOV EBX, _a@main
MOV _a@main, EBX
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
JMP Label16
Label13: 
MOV EBX, _a@main
MOV _a@main, EBX
invoke MessageBox, NULL, addr _MAYOR, addr _MAYOR, MB_OK 
Label16: 
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