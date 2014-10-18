
import java.util.Scanner;


/**
 *
 * @author kommusoft
 */
public class Solution {
    
    private class Item {
        
        public String name;
        public int weight;
        public int value;
        
        
    }

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int k = sc.nextInt();
        int tot = r*k;
        sc.nextLine();
        while(sc.hasNextLine()) {
            sc.next("\\w+");
            if(sc.equals("END")) {
                break;
            }
            sc.nextLine();
        }
    }

}
