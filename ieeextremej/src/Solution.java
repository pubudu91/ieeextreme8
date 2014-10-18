
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
                ins.args.add(decodeArgument(iai));
            }
            counter++;
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

    public enum Opcode {

        Print{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Move{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Add{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Sub{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        And{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Or{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Xor{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Comp{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },
        Jmp{

            @Override
            public void run(Instruction instruction, State state) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        public abstract void run(Instruction instruction, State state);
    }

    private class Instruction {

        public Opcode op;
        public int cond;
        public ArrayList<Argument> args = new ArrayList<>();

        private void run(State state) {
            op.run(this,state);
        }

    }

    private class Argument {

        public Argdres meth = Argdres.Adres;
        public int val;

        private void store(State state, byte val) {
            meth.fetchAdress(val, state);
        }

        private byte load(State state) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
        public abstract int fetchMem (int value, State state);
        
        public abstract int fetchAdress (int value, State state);
    }

    private class State {

        public ArrayList<Instruction> instructions = new ArrayList<>();
        public byte[] memory;
        public int pc = 0;
        public HashMap<String, Integer> labels = new HashMap<String, Integer>();

        private void run() {
            while(pc < instructions.size()) {
                Instruction ins = instructions.get(pc++);
                ins.run(this);
            }
        }
        
        public byte Load (Argument arg) {
            return arg.load(this);
        }
        
        public void Store (Argument arg) {
            arg.store(this);
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }

}
