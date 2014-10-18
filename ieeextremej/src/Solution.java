
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Solution {

    public int full;
    public FS[] fss;
    public int index;

    private class FS implements Comparable<FS> {

        public int d;
        public int c;

        @Override
        public int compareTo(FS t) {
            return ((Integer) d).compareTo(t.d);
        }

    }

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (; test > 0; test--) {
            int n = sc.nextInt();
            this.full = sc.nextInt();
            int t = sc.nextInt();
            int l = sc.nextInt();
            FS[] fss = new FS[n + 0x02];
            FS fi;
            fi = new FS();
            fi.d = 0;
            fi.c = Integer.MAX_VALUE;
            fss[0] = fi;
            for (int i = 1; i <= n; i++) {
                fi = new FS();
                fi.d = sc.nextInt();
                fi.c = sc.nextInt();
                fss[i] = fi;
            }
            fi = new FS();
            fi.d = l;
            fi.c = Integer.MAX_VALUE;
            fss[n + 0x01] = fi;
            Arrays.sort(fss);
            this.fss = fss;
            System.out.println(solve(t, 0, n + 1));
        }
    }

    private int solve(int f0, int from, int to) {
        FS fsf = this.fss[from];
        FS fst = this.fss[to];
        int need = fst.d - fsf.d;
        if (need <= f0) {
            return 0x00;
        } else {
            FS fsc = cheapest(from, to);
            int idx = this.index;
            int dist = fst.d - fsc.d;
            int hleft = f0 - fsc.d;
            int left = Math.max(0, hleft);
            need = Math.min(dist - left, this.full);
            int c = need * fsc.c;
            if (hleft < left) {
                c += solve(f0, from, index);
            }
            if (dist - left > need) {
                c += solve(need, from, to);
            }
            return c;
        }
    }

    public FS cheapest(int from, int to) {
        from = Math.max(1,from);
        int c = Integer.MAX_VALUE;
        FS min = null;
        FS[] fss = this.fss;
        to = Math.min(fss.length-0x01,to);
        FS fi;
        int mini = -1;
        for (int i = from; i < to; i++) {
            fi = fss[i];
            if (fi.c < c) {
                c = fi.c;
                min = fi;
                mini = i;
            }
        }
        this.index = mini;
        return min;
    }

}
