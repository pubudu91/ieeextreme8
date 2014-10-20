
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 *
 * @author kommusoft
 */
public class Solution {

    private HashMap<String, Integer> names;
    private TreeSet<Flight>[] fls;
    private boolean[] visi;
    private PriorityQueue<Flight> pq = new PriorityQueue<>();

    private void query(int pi, long da, int target) {
        if (pi == target){
            printDate(da);
            return;
        }
        pq.clear();
        this.visi = new boolean[names.size()];
        expand(true,pi, da);
        while (pq.size() > 0x00) {
            Flight t = pq.remove();
            System.out.println("On flight "+t.from+" "+t.to+" "+t.pla);
            if (t.pla == target) {
                printDate(t.to - 60);
                return;
            } else {
                expand(t.force, t.pla, t.to);
            }
        }
        System.out.println("No trip on XSL");

    }

    private void expand(boolean force, int pi, long da) {
        if (force || !visi[pi]) {
            int p = visi.length;
            TreeSet<Flight> fli = fls[pi];
            boolean[] visi = this.visi;
            visi[pi] = true;
            for (Flight fl : fli.tailSet(new Flight(0,da,0))) {
                if (!visi[fl.pla]) {
                    pq.add(fl);
                                System.out.println("ADD flight "+fl.from+" "+fl.to+" "+fl.pla);
                    Flight revisit = new Flight(fl.from+1,fl.to,pi);
                    revisit.force = true;
                                                    System.out.println("REV flight "+revisit.from+" "+revisit.to+" "+revisit.pla);
                    pq.add(revisit);
                }
            }
        }
    }

    public void printDate(long ar) {
        System.out.print(ar / 1440);
        System.out.print(' ');
        System.out.print(ar % 1440);
        System.out.println();
    }


    private class Flight implements Comparable<Flight> {

        public long from;
        public long to;
        public int pla;
        public boolean force;


        public Flight(long from, long to, int pla) {
            this.from = from;
            this.to = to;
            this.pla = pla;
        }
        
        @Override
        public int compareTo(Flight t) {
            if(this.to != t.to){
                return ((Long) this.to).compareTo(t.to);
            }else{
                return ((Long) this.from).compareTo(t.from);
            } 
        } 

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 29 * hash + (int) (this.from ^ (this.from >>> 32));
            hash = 29 * hash + (int) (this.to ^ (this.to >>> 32));
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Flight other = (Flight) obj;
            if (this.from != other.from) {
                return false;
            }
            if (this.to != other.to) {
                return false;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Pattern pat = Pattern.compile("[^ \r\n\t,]+");
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int f = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int pi = 0x00; pi < p; pi++) {
            hm.put(sc.nextLine(), pi);
        }
        TreeSet<Flight>[] fls = (TreeSet<Flight>[]) new TreeSet[p];
        for (int pi = 0x00; pi < p; pi++) {
                fls[pi] = new TreeSet<Flight>();
        }
        this.names = hm;
        sc.useDelimiter("[\n\t\r, ]+");
        for (int fi = 0x00; fi < f; fi++) {
            int pi = hm.get(sc.next());
            long da = sc.nextInt();
            da *= 1440;
            da += sc.nextInt();
            int pj = hm.get(sc.next());
            long db = sc.nextInt();
            db *= 1440;
            db += sc.nextInt();
            Flight fli = new Flight(da, db+60, pj);
            TreeSet<Flight> tij = fls[pi];
            fls[pi].add(fli);
        }
        this.fls = fls;
        for (int qi = 0x00; qi < q; qi++) {
            int pi = hm.get(sc.next());
            long da = sc.nextInt();
            da *= 1440;
            da += sc.nextInt();
            int pj = hm.get(sc.next());
            query(pi, da, pj);
        }
    }

}