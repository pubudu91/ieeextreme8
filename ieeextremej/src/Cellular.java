
import java.util.Scanner;

/**
 *
 * @author kommusoft
 */
public class Cellular {
    
    private int n;
    private int r;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Cellular().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        this.r = sc.nextInt();
        int m = sc.nextInt();
        this.n = sc.nextInt();
        long so = sc.nextLong(), s = so+0x01;
        int i;
        for(i = 0x01; i <= m && so != s; i++) {
            printState(i,so,n);
            s = so;
            so = next(s);
        }
        if(i <= m && so == s) {
            printState(i,so,n);
        }
    }
    
    private long next (long s) {
        long res = 0x00l;
        for(int m = this.n-0x02; m >= 0x00; m--) {
            //System.out.print(Long.toBinaryString((s>>>m)&0x07));
            //System.out.print("->");
            long bi = s>>>m;
            bi &= 0x07;
            long b = (r>>bi)&0x01;
            b <<= m+0x01;
            res |= b;
            //System.out.println(Long.toBinaryString(((r>>((s>>>m)&0x07))&0x01)));
        }
        res |= ((r>>>((s<<0x01)&0x07))&0x01);
        return res;
    }
    
    private void printState (int it, long state, int n) {
        String num = ""+it;
        System.out.print(num);
        for(int i = num.length(); i < 4; i++) {
            System.out.print(' ');
        }
        System.out.print('-');
        for(long m = n-0x01; m >= 0x00; m--) {
            if(((state>>>m)&0x01) != 0x00) {
                System.out.print('*');
            } else {
                System.out.print(' ');
            }
        }
        System.out.print('-');
        System.out.println();
    }

}