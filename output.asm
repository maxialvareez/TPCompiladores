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
_varRet4 DD ?
_x@main DD ?
_a@main DD ?
_p@main@f DD ?
_y@main DD ?
_b@main DD ?
_z@main DD ?
_c@main DD ?
_3 DD 3
_var12 DD ?
_2 DD 2
_var3 DD ?
_1 DD 1
_var1 DD ?

.code
start: 
FINIT 
MOV EBX, _null
MOV _x@main, EBX
MOV EBX, _x@main
MOV _z@main, EBX
MOV EBX, _b@main
MOV _p@main@f, EBX
CALL f@main
f@main: 
MOV EBX, _p@main@f
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var1, EBX
MOV EBX, _var1
MOV _p@main@f, EBX
MOV EBX, _p@main@f
ADD EBX, _2
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var3, EBX
MOV EBX, _var3
MOV _varRet4, EBX
MOV EBX, _3
MOV _p@main@f, EBX
CALL f@main
f@main: 
MOV EBX, _p@main@f
ADD EBX, _1
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var1, EBX
MOV EBX, _var1
MOV _p@main@f, EBX
MOV EBX, _p@main@f
ADD EBX, _2
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var3, EBX
MOV EBX, _var3
MOV _varRet4, EBX
MOV EBX, _varRet4
ADD EBX, _varRet4
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var12, EBX
MOV EBX, _var12
MOV _a@main, EBX
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