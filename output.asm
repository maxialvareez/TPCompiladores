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
_MENOR DB 'MENOR', 0 
_varRet21002 DD ?
_f1@main DD ?
_x@main DD ?
_MAYOR DB 'MAYOR', 0 
_a@main DD ?
_varRet11001 DD ?
_p@main@f DD ?
_y@main DD ?
_b@main DD ?
_9 DD 9
_z@main DD ?
_5 DD 5
_c@main DD ?
_4 DD 4
_3 DD 3
_var12 DD ?
_2 DD 2
_var2 DD ?

.code
start: 
FINIT 
MOV EBX, _2
MOV _b@main, EBX
MOV EBX, _b@main
MOV _p@main@f, EBX
CALL f@main0
f@main0: 
MOV EBX, _p@main@f
MOV _p@main@f, EBX
MOV EBX, _p@main@f
ADD EBX, _2
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var2, EBX
MOV EBX, _var2
MOV _varRet11001, EBX
MOV EBX, _3
MOV _p@main@f, EBX
CALL f@main1
f@main1: 
MOV EBX, _p@main@f
MOV _p@main@f, EBX
MOV EBX, _p@main@f
ADD EBX, _2
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var2, EBX
MOV EBX, _var2
MOV _varRet21002, EBX
MOV EBX, _varRet11001
ADD EBX, _varRet21002
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var12, EBX
MOV EBX, _var12
MOV _a@main, EBX
MOV EBX, _9
CMP _a@main, EBX
JAE Label19
MOV EBX, _5
MOV _a@main, EBX
invoke MessageBox, NULL, addr _MENOR, addr _MENOR, MB_OK 
JMP Label22
Label19: 
MOV EBX, _4
MOV _a@main, EBX
invoke MessageBox, NULL, addr _MAYOR, addr _MAYOR, MB_OK 
Label22: 
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