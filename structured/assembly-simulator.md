# Assembly Simulator

Assembly Language is a low-level programming language that is specific to a particulars computer architecture. Each command has a specific structure:

label COMMAND OPERANDS

The commands are represented by mnemonics and perform low-level arithmetic and logical operations generally computed by an Arithmetic-Logic-Unit (ALU). Operands include constants, registers, and addresses that can trigger operations. Labels are used to mark the line of a command so that the ALU can jump or branch to that location to implement higher-level operations such as an if-statement or loop.

Task
Write an assembly language emulator for the Xtreme-8000 processor. The processor consists of an ALU and a register to store comparisons (only set using the COMP command). There are no accumulators, temporary data registers, or temporary address registers. The processor has a maximum of 256-byte memory that it can address through its commands. The full list of commands is:

IMAGE 1
Input
The input will contain:

0 <= Size of memory in bytes <= 0xFF
Program to execute 
Each line has an optional label, a command, and a list of comma separated operands 
(as needed for each command).
Output
Output the result of any print statement.

Note: There is a newline character at the end of the last line of the output.

Sample Input 1
0F 
PRINT 00,0F 
MOVE #FF,00 
PRINT 00,0F 
MOVE 00,01 
PRINT 00,0F 
ADD 00,02 
PRINT 00,0F 
ADD 01,02 
PRINT 00,0F

Sample Output 1
00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 00 
FF FF FF 00 00 00 00 00 00 00 00 00 00 00 00 00 
FF FF FE 00 00 00 00 00 00 00 00 00 00 00 00 00