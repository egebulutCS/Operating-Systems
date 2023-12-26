org 0x7c00
_start:
	;load the start address of msg into the source index register
	mov si,msg
	;call a function to print it.
	;This is a bit like calling a function in Java,
	;except that that function parameters are set up before the call
	call printstring	

	;clear ax    
	xor ax,ax
	;check the memory size
	int 0x12
	;show a message if there was an error
	jc error	
	;did the interrupt return a zero?
	test ax,ax
	jz error
	mov  word [hex16], ax ;look at register 
	call printhex16
	call newline
	jmp no_error
error:
	mov si, errormsg
	call printstring
no_error:
	jmp $
	
	
%include "printing.asm"

;this defines the message we want to print. 
;13 and 10 are the codes for a new line at the end of the string
;0 marks the end of the string
msg	 	  db "MyNewOS 0.1",10,13,0
errormsg	  db "Error",10,13,0

times 510-($-$$) db 0

dw 0xaa55
