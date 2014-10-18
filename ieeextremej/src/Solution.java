
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Solution {

    public int full;
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
        this.full = sc.nextInt();
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
        
    }
    
    private int solve (int f0, int from, int to) {
        FS fsf = this.fss[from];
        FS fst = this.fss[to];
        int need = fst.d-fsf.d;
        if(need <= f0) {
            return 0x00;
        } else {
            FS fsc = cheapest(from,to);
            need = Math.min(fsf.d-fsc.d,this.full);
            int c = fsc.d*
        }
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
