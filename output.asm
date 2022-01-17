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
_var11 DD ?
_f@main DD ?
_HOLA DB 'HOLA', 0 
_MENOR DB 'MENOR', 0 
_var1 DD ?
_MAYOR DB 'MAYOR', 0 
_5 DD 5
_4 DD 4
_2 DD 2
_1 DD 1
_b@main DD ?
_var14 DD ?
_b@main@f DD ?

.code
 f@main:
FINIT 
MOV EBX, _b@main@f
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var1, EBX
MOV EBX, _var1
MOV _b@main@f, EBX
invoke MessageBox, NULL, addr _HOLA, addr _HOLA, MB_OK 
MOV EBX, _b@main@f
MOV _f@main, EBX
RET 
start: 
FINIT 
MOV EBX, _2
MOV _b@main, EBX
MOV EBX, _b@main
MOV _b@main@f, EBX
CALL f@main
MOV EBX, _1
MOV _b@main@f, EBX
CALL f@main
MOV EBX, _f@main
ADD EBX, _f@main
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var11, EBX
MOV EBX, _4
MOV _b@main@f, EBX
CALL f@main
MOV EBX, _var11
ADD EBX, _f@main
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var14, EBX
MOV EBX, _var14
MOV _b@main, EBX
MOV EBX, _5
CMP _b@main, EBX
JAE Label21
MOV EBX, _1
MOV _b@main, EBX
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
JMP Label24
Label21: 
MOV EBX, _1
MOV _b@main, EBX
invoke MessageBox, NULL, addr _MAYOR, addr _MAYOR, MB_OK 
Label24: 
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