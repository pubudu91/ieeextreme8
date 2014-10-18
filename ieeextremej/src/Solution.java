
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kommusoft
 */
public class Solution {

    private ArrayList<FS> fss;
    private int full;
    private int split;

    private int solve(int fuel, int offset, int length, int from, int to) throws Exception {
        if (fuel >= length) {
            return 0;
        } else {
            FS fsm = minimum(from, to);
            if (fsm == null) {
                throw new Exception();
            }
            int idx = this.split;
            int x01 = fsm.dist;
            int d0 = x01 - offset;
            int d1 = length + offset - x01;//the total amount of fuel needed
            int need = Math.min(d1, this.full);
            int left = Math.max(fuel - d0, 0);
            int tank = need - left;
            int c = tank * fsm.cost;
            if (d0 > fuel) {
                c += solve(fuel, offset, d0, from, idx);
            }
            if (d1 > need) {
                c += solve(need, x01, d1, idx+0x01, to);
            }
            return c;
        }
    }

    private FS minimum(int from, int to) {
        int minc = Integer.MAX_VALUE;
        int mini = -1;
        FS minf = null;
        for (int i = to-0x01; i >= from; i--) {
            FS fsi = fss.get(i);
            if (fsi.cost < minc) {
                minf = fsi;
                mini = i;
                minc = fsi.cost;
            }
        }
        this.split = mini;
        return minf;
    }

    private class FS implements Comparable<FS> {

        public int dist;
        public int cost;

        public FS(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }

        @Override
        public int compareTo(FS t) {
            return ((Integer) this.dist).compareTo(t.dist);
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (; test > 0; test--) {
            solveTest(sc);

        }
    }

    private void solveTest(Scanner sc) {
        ArrayList<FS> fss = new ArrayList<>();
        int nGas = sc.nextInt();
        int full = sc.nextInt();
        int start = sc.nextInt();
        int length = sc.nextInt();

        for (int i = 0; i < nGas; i++) {
            int di = sc.nextInt();
            int ci = sc.nextInt();
            if (di < length) {
                fss.add(new FS(di, ci));
            }
        }
        Collections.sort(fss);
        this.fss = fss;
        this.full = full;
        try {
            int c = solve(start, 0, length, 0x00, fss.size());
            System.out.println(c);
        } catch (Exception ex) {
            System.out.println(-1);
        }
    }

}
