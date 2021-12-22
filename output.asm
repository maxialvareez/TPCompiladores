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
_c@main DD ?
_var7 DD ?
_p@main@f DD ?
_a@main DD ?
_b@main DD ?

.code
start: 
FINIT 
MOV EBX, _b@main
MOV _p@main@f, EBX
CALL f@main
MOV EBX, _c@main
MOV _p@main@f, EBX
FINIT
invoke ExitProcess, 0 
f@main: 
RetornoFuncion: 
RET 
MOV EBX, _null
ADD EBX, _null
CMP EBX, _limiteSuperiorUint
JA LabelOverflowSuma
MOV _var7, EBX
MOV EBX, _var7
MOV _a@main, EBX
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