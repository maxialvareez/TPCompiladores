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
_f1@main DD ?
_g@main@f1@f DD ?
_j@main@f1@f DD ?
_f@main@f1 DD ?
_a@main DQ ?
_i@main DD ?
_b@main DD ?
_u@main@f1 DD ?
_z@main DQ ?
_s@main@f1 DD ?
_c@main DD ?
_var5 DD ?
_var10 DD ?

.code
 f1@main:
FINIT 
MOV EBX, _s@main@f1
MOV _g@main@f1@f, EBX
CALL f@main@f1
MOV EBX, _f@main@f1
MOV _var5, EBX
MOV EBX, _u@main@f1
MOV _f1@main, EBX
RET 
f@main@f1:
FINIT 
MOV EBX, _g@main@f1@f
MOV _f@main@f1, EBX
RET 
start: 
FINIT 
MOV EBX, _c@main
MOV _b@main, EBX
MOV EBX, _b@main
MOV _u@main@f1, EBX
CALL f1@main
MOV EBX, _f1@main
MOV _var10, EBX
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