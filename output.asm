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
_c@main DD ?
_b@main DD ?
_var2 DD ?
_1500000 DD 1500000
_15000606 DD 15000606

.code
start: 
FINIT 
MOV EBX, _1500000
MOV _b@main, EBX
MOV EBX, _15000606
MOV _c@main, EBX
MOV EBX, _b@main
ADD EBX, _c@main
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var2, EBX
MOV EBX, _var2
MOV _b@main, EBX
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