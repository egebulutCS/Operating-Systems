org 0x7c00
;hex val keylogger
_start:

	mov ah, 0x00
	int 0x16
	
	mov ah, 0x0e
	int 0x10
	
	jmp _start
	
times 510-($-$$) db 0

dw 0xaa55
