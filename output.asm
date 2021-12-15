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
_b@main@g DQ ?
_b@main@f DQ ?
_j@main@g DD ?
_j@main@f DD ?
_1_4300000000000002 DQ 1.4300000000000002
_a@main DQ ?
_z@main@g DD ?
_u@main@f DD ?
_b@main DD ?
_6 DD 6
_3 DD 3
_1 DD 1

.code
start: 
FINIT 
FLD _1_4300000000000002
FSTP _a@main
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