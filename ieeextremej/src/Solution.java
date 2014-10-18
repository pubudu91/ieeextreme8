import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kommusoft
 */
public class Solution {

    private static int LT = 0x01;
    private static int EQ = 0x02;
    private static int GT = 0x04;
    private static int NE = 0x08;

    private void run() {
        Scanner sc = new Scanner(System.in);
        int mem = sc.nextInt(16);//set memory size
        sc.nextLine();
        String line;
        String il;
        String io;
        String[] ia;
        Pattern parser0 = Pattern.compile("^(\\w+ +)?(\\w+) +(.+)$");
        State state = new State();
        int counter = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            if (!line.equals("")) {
                Matcher m = parser0.matcher(line);
                m.find();
                il = m.group(1);
                if (il != null) {
                    state.labels.put(il, counter);
                }
                Instruction ins = new Instruction();
                io = m.group(2).toLowerCase();
                ins.op = decodeIns(io,ins);
                ia = m.group(3).split(",");
                for (String iai : ia) {
                    ins.args.add(decodeArgument(iai));
                }
                state.instructions.add(ins);
                counter++;
            } else {
                break;
            }
        }
        state.run();
    }

    public Opcode decodeIns(String io, Instruction ins) {
        switch (io) {
            case "print":
                return Opcode.Print;
            case "move":
                return Opcode.Move;
            case "add":
                return Opcode.Add;
            case "sub":
                return Opcode.Sub;
            case "and":
                return Opcode.And;
            case "or":
                return Opcode.Or;
            case "xor":
                return Opcode.Xor;
            case "comp":
                return Opcode.Comp;
            default:
                ins.cond = decodeCond(io.substring(1));
                return Opcode.Jmp;
        }
    }

    public int decodeCond(String io) {
        switch (io) {
            case "eq":
                return EQ;
            case "ne":
                return NE;
            case "gt":
                return GT;
            case "lt":
                return LT;
            case "ge":
                return GT | EQ;
            default:
                return LT | EQ;
        }
    }

    public Argument decodeArgument(String ia) {
        Argument arg = new Argument();
        arg.label = ia.trim();
        if (ia.startsWith("(")) {
            arg.meth = Argdres.Reference;
            arg.addr = (byte) Integer.parseInt(ia.substring(0x01, ia.length() - 0x01), 16)&0xff;
        } else if (ia.startsWith("#")) {
            arg.meth = Argdres.Constant;
            arg.addr = (byte) Integer.parseInt(ia.substring(0x01), 16)&0xff;
        } else {
            try {
                arg.addr = (byte) Integer.parseInt(ia, 16)&0xff;
            } catch (Exception e) {
            }
        }
        return arg;
    }

    public static void printHex(int val) {
        System.out.print(String.format("%02X",val).toUpperCase());
    }

    public enum Opcode {

        Print {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int b = instruction.args.get(0).address(state);
                        int e = b;
                        if (instruction.args.size() > 1) {
                            e = instruction.args.get(1).address(state);
                        }
                        //System.out.println(state.cmp);
                        //System.out.print('/');
                        printHex(state.memory[b++]);
                        for (; b <= e; b++) {
                            System.out.print(' ');
                            printHex(state.memory[b]);
                        }
                        System.out.println();
                    }
                },
        Move {

                    @Override
                    public void run(Instruction instruction, State state) {
                        state.store(instruction.args.get(1), state.load(instruction.args.get(0)));
                    }
                },
        Add {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int a = state.load(instruction.args.get(0));
                        int b = state.load(instruction.args.get(1));
                        state.store(instruction.args.get(1), (b + a)&0xff);
                    }
                },
        Sub {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int a = state.load(instruction.args.get(0));
                        int b = state.load(instruction.args.get(1));
                        state.store(instruction.args.get(1), (b - a)&0xff);
                    }
                },
        And {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int a = state.load(instruction.args.get(0));
                        int b = state.load(instruction.args.get(1));
                        state.store(instruction.args.get(1), (b & a)&0xff);
                    }
                },
        Or {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int a = state.load(instruction.args.get(0));
                        int b = state.load(instruction.args.get(1));
                        state.store(instruction.args.get(1), (b | a)&0xff);
                    }
                },
        Xor {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int a = state.load(instruction.args.get(0));
                        int b = state.load(instruction.args.get(1));
                        state.store(instruction.args.get(1), (b ^ a)&0xff);
                    }
                },
        Comp {

                    @Override
                    public void run(Instruction instruction, State state) {
                        int a = state.load(instruction.args.get(0));
                        int b = state.load(instruction.args.get(1));
                        int cmp = 0x00;
                        if (a == b) {
                            cmp |= EQ;
                        } else {
                            cmp |= NE;
                            if (a < b) {
                                cmp |= LT;
                            } else {
                                cmp |= GT;
                            }
                        }
                        state.cmp = cmp;
                    }
                },
        Jmp {

                    @Override
                    public void run(Instruction instruction, State state) {
                        if ((instruction.cond & state.cmp) != 0x00) {
                            state.jmp(instruction.args.get(0).label);
                        }
                    }
                };

        public abstract void run(Instruction instruction, State state);
    }

    private class Instruction {

        public Opcode op;
        public int cond;
        public ArrayList<Argument> args = new ArrayList<>();

        private void run(State state) {
            op.run(this, state);
        }

    }

    private class Argument {

        public Argdres meth = Argdres.Adres;
        public int addr;
        public String label;

        public int address(State state) {
            return meth.fetchAdress(this.addr, state);
        }

        private void store(State state, int val) {
            state.memory[meth.fetchAdress(this.addr, state)] = val&0xff;
        }

        private int load(State state) {
            return meth.fetchMem(this.addr, state);
        }

    }

    private enum Argdres {

        Adres {

                    @Override
                    public int fetchMem(int value, State state) {
                        return state.memory[value];
                    }

                    @Override
                    public int fetchAdress(int value, State state) {
                        return value;
                    }

                },
        Constant {

                    @Override
                    public int fetchMem(int value, State state) {
                        return value;
                    }

                    @Override
                    public int fetchAdress(int value, State state) {
                        return -0x01;
                    }
                },
        Reference {

                    @Override
                    public int fetchMem(int value, State state) {
                        return state.memory[state.memory[value]];
                    }

                    @Override
                    public int fetchAdress(int value, State state) {
                        return state.memory[value];
                    }
                };

        public abstract int fetchMem(int value, State state);

        public abstract int fetchAdress(int value, State state);
    }

    private class State {

        public ArrayList<Instruction> instructions = new ArrayList<>();
        public int[] memory = new int[0x100];
        public int pc = 0;
        public int cmp;
        public HashMap<String, Integer> labels = new HashMap<String, Integer>();

        private void run() {
            while (pc < instructions.size()) {
                Instruction ins = instructions.get(pc++);
                ins.run(this);
            }
        }

        public int load(Argument arg) {
            return arg.load(this);
        }

        public void store(Argument arg, int val) {
            arg.store(this, val);
        }

        public void jmp(String label) {
            pc = labels.get(label);
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }

}
