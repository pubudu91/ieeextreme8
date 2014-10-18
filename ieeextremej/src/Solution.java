
import java.util.Scanner;


/**
 *
 * @author kommusoft
 */
public class Solution {
    
    private class FS implements Comparable<FS>  {
        
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
        for(int i = 0; i < n; i++) {
            
        }
    }

}
