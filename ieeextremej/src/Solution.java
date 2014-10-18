
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
    private TreeSet<Flight>[][] fls;
    private boolean[] visi;
    private PriorityQueue<Traveler> pq = new PriorityQueue<>();

    private void query(int pi, long da, int target) {
        pq.clear();
        this.visi = new boolean[names.size()];
        expand(pi, da);
        while (pq.size() > 0x00) {
            Traveler t = pq.remove();
            if (t.pj == target) {
                printDate(t.da - 60);
                return;
            } else {
                expand(t.pj, t.da);
            }
        }
        System.out.println("No trip on XSL");

    }

    private void expand(int pi, long da) {
        if (!visi[pi]) {
            Flight flt = new Flight(da);
            int p = visi.length;
            TreeSet<Flight>[] fli = fls[pi];
            boolean[] visi = this.visi;
            visi[pi] = true;
            for (int pj = 0; pj < p; pj++) {
                if (!visi[pj]) {
                    TreeSet<Flight> flij = fli[pj];
                    Flight flu = flij.ceiling(flt);
                    if (flu != null) {
                        //System.out.print("schedule to " + pj + " at ");
                        //printDate(flu.from);
                        pq.add(new Traveler(pj, flu.to + 60));
                    }
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

    private class Traveler implements Comparable<Traveler> {

        public int pj;
        public long da;

        public Traveler(int pj, long da) {
            this.pj = pj;
            this.da = da;
        }

        @Override
        public int compareTo(Traveler t) {
            return ((Long) da).compareTo(t.da);
        }

    }

    private class Flight implements Comparable<Flight> {

        public long from;
        public long to;

        public Flight(long from) {
            this(from, 0x00);
        }

        public Flight(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public boolean dominates(Flight f) {
            return f.from <= this.from && f.to >= this.to;
        }

        @Override
        public int compareTo(Flight t) {
            return ((Long) this.from).compareTo(t.from);
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
        TreeSet<Flight>[][] fls = (TreeSet<Flight>[][]) new TreeSet[p][p];
        for (int pi = 0x00; pi < p; pi++) {
            for (int pj = 0x00; pj < p; pj++) {
                fls[pi][pj] = new TreeSet<Flight>();
            }
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
            Flight fli = new Flight(da, db);
            TreeSet<Flight> tij = fls[pi][pj];
            boolean rem;
            do {
                rem = false;
                Flight alt = tij.floor(fli);
                if (alt != null) {
                    if (fli.dominates(alt)) {
                        tij.remove(alt);
                        rem = true;
                    } else if (alt.dominates(fli)) {
                        fli = null;
                    }
                }
            } while (rem);
            if (fli != null) {
                fls[pi][pj].add(fli);
            }
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
