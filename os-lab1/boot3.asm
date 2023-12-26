org 0x7c00
_start:
	;load the start address of msg into the source index register
	mov si,msg
	; call a function to print it.
	; This is a bit like calling a function in Java, 
	;except that the function parameters are set up before the call
	call printstring	
    
	jmp $
	
	
%include "printing.asm"

;this defines the message we want to print. 
;13 and 10 are the codes for a new line at the end of the string
;0 marks the end of the string
msg	  db "Hello World",10,13,0

times 510-($-$$) db 0

dw 0xaa55
