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
_varRet26 DQ ?
_varRet22 DQ ?
_g@main@f1@f DQ ?
_j@main@f1@f DD ?
_a@main DQ ?
_i@main DD ?
_b@main DD ?
_u@main@f1 DQ ?
_z@main DQ ?
_s@main@f1 DD ?
_c@main DD ?

.code
start: 
FINIT 
MOV EBX, _c@main
MOV _b@main, EBX
FLD _a@main
FSTP _u@main@f1
CALL f1@main0
f1@main0: 
FLD _a@main
FSTP _g@main@f1@f
CALL f@main@f11
f@main@f11: 
FLD _g@main@f1@f
FSTP _varRet22
FLD _u@main@f1
FSTP _varRet26
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
invoke ExitProcess, 0
end start