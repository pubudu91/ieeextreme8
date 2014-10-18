
import java.util.HashMap;
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

    private void query(int pi, long da, int pj) {
        this.visi = new boolean[names.size()];
        expand(pi, da);
    }

    private void expand(int pi, long da) {

        Tree<Flight>[] fli = fls[];

    }

    private class Flight implements Comparable<Flight> {

        public long from;
        public long to;

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
            da |= sc.nextInt();
            int pj = hm.get(sc.next());
            long db = sc.nextInt();
            db *= 1440;
            db |= sc.nextInt();
            Flight fli = new Flight(da, db);
            fls[pi][pj].add(fli);
        }
        this.fls = fls;
        for (int qi = 0x00; qi < q; qi++) {
            int pi = hm.get(sc.next());
            long da = sc.nextInt();
            da *= 1440;
            da |= sc.nextInt();
            int pj = hm.get(sc.next());
            query(pi, da, pj);
        }
    }

}
