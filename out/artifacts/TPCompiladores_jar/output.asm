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
_var1 DD ?
_DISTINTOS DB 'DISTINTOS', 0 
_a@main DD ?
_7 DD 7
_6 DD 6
_2 DD 2
_b@main DD ?
_IGUALES DB 'IGUALES', 0 

.code
start: 
FINIT 
MOV EBX, _7
MOV _a@main, EBX
MOV EBX, _6
ADD EBX, _2
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var1, EBX
MOV EBX, _var1
MOV _b@main, EBX
JE Label7
invoke MessageBox, NULL, addr _DISTINTOS, addr _DISTINTOS, MB_OK 
JMP Label9
Label7: 
invoke MessageBox, NULL, addr _IGUALES, addr _IGUALES, MB_OK 
Label9: 
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