org 0x7c00

_start:

	; move 0x0e into the ah register
	; numbers starting with 0x are hexadecimal
	; this is a parameter for the interrupt service routine that
	; tells it we want to print a character
	mov ah, 0x0e   

_marker:
	;push the character 'a' into the stack
	push 'o'
	push 'l'
	push 'l'
	push 'e'
	push 'h'
	;pop the top of the stack into the ax register
	pop ax
	;print the character
	mov ah, 0x0e  	
	int 0x10
	
	pop ax
	mov ah, 0x0e
	int 0x10
	pop ax
	mov ah, 0x0e
	int 0x10
	pop ax
	mov ah, 0x0e
	int 0x10
	pop ax
	mov ah, 0x0e
	int 0x10
	
	; jump to the current memory location
	; i.e. loop forever
	jmp $

;fill the rest of our program with zeros
times 510-($-$$) db 0

;this identifies the program as a bootloader
dw 0xaa55
