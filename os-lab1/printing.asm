newline:
	mov ah, 0x0e
	mov al, 13
	int 0x10
	mov al, 10
	int 0x10
	ret
	
printstring:
   lodsb
   or al, al  ;zero=end of str
   jz done    ;get out
   mov ah, 0x0E
   int 0x10
   jmp printstring
done:
   ret	

 
;adapted from the 'babysteps' tutorial on OSDev Wiki
printhex16:
	mov di, outstr16
	mov ax, [hex16]
	mov si, hexstr
	mov cx, 4   ;four places
hexloop:
	rol ax, 4   ;leftmost will
	mov bx, ax   ; become
	and bx, 0x0f   ; rightmost
	mov bl, [si + bx];index into hexstr
	mov [di], bl
	inc di
	dec cx
	jnz hexloop

	mov si, outstr16
	call printstring
 
   ret   

hexstr   db '0123456789ABCDEF'
outstr16   db '0000', 0  ;register value string
hex16   dw    0  ; pass values to printreg16	  
