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
_a@main DD ?
_11 DD 11
_var0 DD ?
_90 DD 90

.code
start: 
FINIT 
MOV EBX, _11
ADD EBX, _90
CMP EBX, _limiteSuperiorULONG
JA LabelOverflowSuma
MOV _var0, EBX
MOV EBX, _var0
MOV _a@main, EBX
FINIT
invoke ExitProcess, 0 
FINIT
LabelOverflowSuma: 
invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK 
FINIT
invoke ExitProcess, 0
end start