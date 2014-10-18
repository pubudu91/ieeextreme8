
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Solution {
    
    private int n;
    private int r;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        this.r = sc.nextInt();
        int m = sc.nextInt();
        this.n = sc.nextInt();
        long s = sc.nextLong();
        printState(1,s,n); 
    }
    
    private static long next (long r) {
        long res = 0x00;
        for(int m = n-0x01; m > 0x00; m--) {
            res |= (r>>((r>>m)&0x07))<<(m+0x01);
        }
    }
    
    private static int pattern (long dat) {
        return (r>>dat)&0x01;
    }
    
    private static void printState (int it, long state, int n) {
        String num = ""+it;
        System.out.print(num);
        for(int i = num.length(); i < 3; i++) {
            System.out.print(' ');
        }
        System.out.print('-');
        for(long m = n-0x01; m >= 0x00; m--) {
            if(((state>>m)&0x01) != 0x00) {
                System.out.print('*');
            } else {
                System.out.print(' ');
            }
        }
        System.out.print('-');
    }

}