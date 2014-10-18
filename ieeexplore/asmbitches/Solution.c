#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <stdint.h>

int main() {
	char *mem = malloc(0x10000);

	uint16_t bx;
	uint16_t cx;
	uint16_t dx;
	uint16_t di;
	uint16_t si;
	uint16_t bp;
	uint8_t ah, al;

	int nextByte;
	int i;

#if 0
	for (i = 0; i < 0x10000; i++)
		mem[i] = 0;
#endif
	di = 0x400;
	si = 0xC0; // 0x6
	cx = 0;

	// READ INPUT
	nextByte = getchar();
	while (nextByte != EOF) {
		mem[di] = (uint8_t) nextByte;
		di++;
		if (((char) nextByte) == '.')
			break;
		nextByte = getchar();
		cx--;
	}

	cx = ~cx; // 0x12
	dx = 0; // 0x14
	bp = cx; // 0x16

	__asm__(
		"pop    %%bx                        "
		"push   %%bx                        "
		"incb   (%%bx)                      "
		"jne    0x21                        "
		"inc    %%bx                        "
		"jmp    0x1a                        "
		"movw    $0x200,%%di                 "
		"movw    %%di,%%cx                   "
		"movw    %%di,%%ax                   "
		"rep stos %%al,%%es:(%%di)          "
		"movw    %%di,%%si                   "
		"lods   %%ds:(%%si),%%al            "
		"movw    %%ax,%%bx                   "
		"incb   (%%bx)                      "
		"cmp    $0x2e,%%bl                  "
		"jne    0x2c                        "
		"decb   (%%bx)                      "
		"pop    %%si                        "
		"push   %%si                        "
		"movw    %[bp],%%cx                   "
		"lods   %%ds:(%%si),%%al            "
		"movw    %%ax,%%bx                   "
		"decb   (%%bx)                      "
		"jl     0x18                        "
		"loop   0x3c                        "
		"inc    %[dx]                        "
		"pop    %%si                        "
		"push   %%si                        "
		"movw    %[bp],%%cx                   "
		"repz cmpsb %%es:(%%di),%%ds:(%%si) "
		"jne    0x18                        "
		"pop    %[bp]                        "
		: [dx] "=d" (dx) /* output */
		: [bp] "b" (bp) /* input */
	);


	printf("%02d\n", dx);
	
	return 0;
}
