
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Fuel {

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
        new Fuel().run();
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
            fi.c = 0;
            fss[0] = fi;
            int k = 1;
            for (int i = 1; i <= n; i++) {
                fi = new FS();
                fi.d = sc.nextInt();
                if (fi.d < l) {
                    fi.c = sc.nextInt();
                    fss[k++] = fi;
                }
            }
            fi = new FS();
            fi.d = l;
            fi.c = 0;
            fss[k] = fi;
            Arrays.sort(fss);
            this.fss = fss;
            try {
                System.out.println(solve(t, 0, k));
            } catch (Exception e) {
                System.out.println(-1);
            }

        }
    }

    private int solve(int f0, int from, int to) throws Exception {
        FS fsf = this.fss[from];
        FS fst = this.fss[to];
        int need = fst.d - fsf.d;
        if (need <= f0) {
            return 0x00;
        } else {
            FS fsc = cheapest(from, to);
            if (fsc == null) {
                throw new Exception();
            }
            int idx = this.index;
            int dist = fst.d - fsc.d;
            int hleft = f0 - (fsc.d - fsf.d);
            int left = Math.max(0, hleft);
            need = Math.min(dist, this.full);
            int c = (need - left) * fsc.c;
            //System.out.println("" + (need - left) + "x" + fsc.c + "=" + c);
            if (hleft < left) {
                c += solve(f0, from, idx);
            }
            if (dist > need) {
                c += solve(need, idx, to);
            }
            return c;
        }
    }

    public FS cheapest(int from, int to) {
        int c = Integer.MAX_VALUE;
        FS min = null;
        FS[] fss = this.fss;
        to = Math.min(fss.length - 0x01, to);
        FS fi;
        int mini = -1;
        for (int i = from + 0x01; i < to; i++) {
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