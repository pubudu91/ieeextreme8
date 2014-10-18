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

loop18:

#if 0
	//printf("at loop18\n");
	bx = 0xC0; // 0x18

loop1a:
	//printf("at loop1a\n");
	mem[bx]++;
	if (mem[bx] != 0)
		goto endloop1a;
	bx++;
	goto loop1a;
endloop1a:
	//printf("at endloop1a\n");

	di = 0x200; // 0x21
	cx = di;
	ah = (di >> 8) & 0xFF;
	al = di & 0xFF;

	// clear mem -> 0x21 till 0x28
	for (i = 0x200; i < 0x400; i++) {
		mem[i] = 0;
	}
	di = 0x400; //(due to increments in store)
	si = di; // 0x2a
#endif
	for (i = 0xC0; 1; i++) {
		mem[i]++;
		if (mem[i] != 0)
			break;
	}



#if 0
loop2c:
	//printf("at loop2c\n");
	al = mem[si++]; // 0x2c
	bx = 0x200 + al;
	mem[bx]++;
	if (al == '.') {
		mem[bx]--;
	} else {
		goto loop2c;
	}
#endif
	for (i = 0; i < bp; i++) {
		mem[0x200 + mem[0x400 + i]]++;
	}



#if 0
	// 0x38
	si = 0xC0;
	cx = bp; // 0x3a
loop3c:
	//printf("at loop3c\n");
	al = mem[si++]; // 0x3c
	bx = 0x200 + al; // 0x3d
	int flag = ((int8_t)mem[bx]) < (int8_t) 1;
	mem[bx]--; // 0x3f
	// emulate the jump less after the dec:
	//if (mem[bx] == 0xFF) // TODO CORRECT???
	//if (mem[bx] == 0x7F || mem[bx] & 128) // TODO CORRECT???
	//if (mem[bx] == 0) // TODO CORRECT???
	//if (mem[bx] & 128) // TODO CORRECT???
	//if (((int8_t)mem[bx]) < 0) // TODO CORRECT???
	if (flag)
		goto loop18; // 0x41
	//0x43
	cx--;
	if (cx != 0)
		goto loop3c; 
#endif
	for (i = 0; i < bp; i++) {
		mem[0x200 + mem[0xC0 + i]]--;
		if ((int8_t) mem[0x200 + mem[0xC0 + i]] < 0)
			goto loop18;
	}



	dx++; // 0x45


#if 0
	si = 0xC0; // 0x46
	cx = bp; // 0x48
	while (cx != 0) {
		cx--;
		if (mem[di++] != mem[si++])
			break;
	}
	if (cx != 0)
		goto loop18;
#endif

	for (i = 0; i < bp; i++) {
		if(mem[0xC0 + i] != mem[0x400 + i])
			goto loop18;
	}



	printf("%02d\n", dx);
	
	return 0;
}
