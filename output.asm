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
_OverflowSuma DB "Overflow en suma", 0 
_c@main DD ?
_var6 DD ?
_var4 DD ?
_var2 DD ?
_d@main DD ?
_a@main DD ?
_4 DD 4
_3 DD 3
_e@main DD ?
_2 DD 2
_b@main DD ?

.code
start: 
FINIT 
MOV EBX, _2
MOV _a@main, EBX
MOV EBX, _3
MOV _b@main, EBX
MOV EBX, _a@main
SUB EBX, _b@main
MOV _var2, EBX
MOV EBX, _var2
MOV _c@main, EBX
MOV EBX, _c@main
SUB EBX, _4
MOV _var4, EBX
MOV EBX, _var4
MOV _d@main, EBX
MOV EBX, _c@main
SUB EBX, _d@main
MOV _var6, EBX
MOV EBX, _var6
MOV _e@main, EBX
FINIT
invoke ExitProcess, 0 
FINIT
LabelOverflowSuma: 
invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK 
FINIT
invoke ExitProcess, 0
end start