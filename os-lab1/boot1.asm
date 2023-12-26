org 0x7c00 

_start:
	; move 0x0e into the ah register
	; numbers starting with 0x are hexadecimal
	; this is a parameter for the interrupt service routine that
	; tells it we want to print a character
	mov ah, 0x0e
	; move 'a' into the al register
	; this is the character we want to print
	mov al, 'e'
	; call the BIOS routine to print the character by
	; sending interrupt number 0x10
	int 0x10
	; jump to the current memory location
	; i.e. loop forever
	jmp $
	
; fill the rest of our program with zeros,
; a boot loader needs to be 512 bytes long.
times 510-($-$$) db 0

; this identifies the program as a bootloader 
dw 0xaa55
