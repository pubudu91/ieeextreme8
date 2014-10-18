
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Solution {

    public FS[] fss;

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
        int n = sc.nextInt();
        int f = sc.nextInt();
        int t = sc.nextInt();
        int l = sc.nextInt();
        FS[] fss = new FS[n];
        for (int i = 0; i < n; i++) {
            FS fi = new FS();
            fi.d = sc.nextInt();
            fi.c = sc.nextInt();
            fss[i] = fi;
        }
        Arrays.sort(fss);
        this.fss = fss;
        int[] gas = new int[n];
    }

    public FS cheapest(int from, int to) {
        int c = Integer.MAX_VALUE;
        FS min = null;
        FS[] fss = this.fss;
        FS fi;
        for (int i = from; i < to; i++) {
            fi = fss[i];
            if (fi.c < c) {
                c = fi.c;
                min = fi;
            }
        }
        return min;
    }

}
