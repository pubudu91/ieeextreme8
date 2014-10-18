
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
        int mem = sc.nextInt();//set memory size
        sc.nextLine();
        String line;
        String il;
        String io;
        String[] ia;
        Pattern parser0 = Pattern.compile("^(\\w+)? *(\\w+) +(\\w+)$");
        State state = new State();
        int counter = 0;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            Matcher m = parser0.matcher(line);
            m.find();
            il = m.group(1);
            if (!il.equals("")) {
                state.labels.put(il, counter);
            }
            Instruction ins = new Instruction();
            io = m.group(2).toLowerCase();
            ia = m.group(3).split(",");
            for(String iai : ia) {
                
            }
            counter++;
        }
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

    public Argument DecodeArgument(String ia) {
        Argument arg = new Argument();
        if(ia.startsWith("(")) {
            arg.meth = Argdres.Reference;
            arg.val = Integer.parseInt(ia.substring(0x01,ia.length()-0x01));
        } else if(ia.startsWith("#")) {
            arg.meth = Argdres.Constant;
            arg.val = Integer.parseInt(ia.substring(0x01));
        } else {
            arg.val = Integer.parseInt(ia);
        }
        return arg;
    }

    private enum Opcode {

        Print,
        Move,
        Add,
        Sub,
        And,
        Or,
        Xor,
        Comp,
        Jmp
    }

    private class Instruction {

        public Opcode op;
        public int cond;

    }

    private class Argument {

        public Argdres meth = Argdres.Adres;
        public int val;

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
        
        public abstract int fetchMem (int value, State state);
        
        public abstract int fetchAdress (int value, State state);
    }

    private class State {

        public ArrayList<Instruction> instructions = new ArrayList<>();
        public byte[] memory;
        public int pc = 0;
        public HashMap<String, Integer> labels = new HashMap<String, Integer>();

    }

    public static void main(String[] args) {
        new Solution().run();
    }

}
