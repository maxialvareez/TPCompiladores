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
_ENTREENFUNCION DB 'ENTREENFUNCION', 0 
_MENOR DB 'MENOR', 0 
_var1 DD ?
_a@main DD ?
_6 DD 6
_varRet8 DD ?
_3 DD 3
_2 DD 2
_b@main DD ?
_b@main@f DD ?

.code
start: 
FINIT 
MOV EBX, _3
MOV _b@main, EBX
MOV EBX, _b@main
MOV _b@main@f, EBX
CALL f@main
f@main: 
MOV EBX, _b@main@f
ADD EBX, _2
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var1, EBX
MOV EBX, _var1
MOV _b@main@f, EBX
MOV EBX, _6
CMP _b@main@f, EBX
JAE Label7
MOV EBX, _2
MOV _b@main@f, EBX
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
Label7: 
MOV EBX, _b@main@f
MOV _varRet8, EBX
MOV EBX, _varRet8
MOV _b@main, EBX
MOV EBX, _6
CMP _b@main, EBX
JAE Label18
MOV EBX, _2
MOV _b@main, EBX
invoke MessageBox, NULL, addr _ENTREENFUNCION, addr _ENTREENFUNCION, MB_OK 
Label18: 
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