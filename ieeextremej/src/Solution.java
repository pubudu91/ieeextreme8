
import java.util.Scanner;


/**
 *
 * @author kommusoft
 */
public class Solution {
    
    private class FS implements Comparable<FS> {
        
        public int dist;
        public int cost;
        
        public FS (int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }

        @Override
        public int compareTo(FS t) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(; test > 0; test--) {
            int nGas = sc.nextInt();
            int full = sc.nextInt();
            int start = sc.nextInt();
            int length = sc.nextInt();
            
            for(int i = 0; i < nGas; i++) {
                
            }
        }
    }

}
