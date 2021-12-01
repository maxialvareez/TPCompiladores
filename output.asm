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
_OverflowSuma DB "Overflow en suma", 0 
_hola DB hola, 0 
_b@main DD ?
_a@main DD ?

.code
start: 
FINIT 
MOV EBX, _b@main
MOV _a@main, EBX
invoke MessageBox, NULL, addr _hola, addr _hola, MB_OK 
FINIT
invoke ExitProcess, 0 
FINIT
LabelOverflowSuma: 
invoke MessageBox, NULL, addr _OverflowSuma, addr _OverflowSuma, MB_OK 
FINIT
invoke ExitProcess, 0
end start