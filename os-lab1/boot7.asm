org 0x7c00
;image display
_start:

	mov al, 0x13
	mov ah, 0x00
	int 0x10
	
	mov cx, 800
	mov dx, 2000
	
	mov ah, 0x0C
	mov al, 0x0B
	int 0x10
	
	mov cx, 801
	mov dx, 2000
	
	mov ah, 0x0C
	mov al, 0x0B
	int 0x10
	
	jmp $
	
times 510-($-$$) db 0

dw 0xaa55
