
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Solution {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        long s = sc.nextLong();
        printState(1,s,n);
        
    }
    
    private static void printState (int it, long state, int n) {
        String num = ""+it;
        System.out.print(num);
        for(int i = num.length(); i < 3; i++) {
            System.out.print(' ');
        }
        System.out.print('-');
        for(long mask = 0x1l<<(n-0x01); mask != 0x00; mask >>= 0x01) {
            if((state&mask) != 0x00) {
                System.out.print('*');
            } else {
                System.out.print(' ');
            }
        }
        System.out.print('-');
    }

}
