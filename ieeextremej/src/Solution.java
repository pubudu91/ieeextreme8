
import java.util.ArrayList;
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
        ArrayList<Item> itms = new ArrayList<>();
        Item itm;
        while(sc.hasNextLine()) {
            String nm = sc.next("\\w+");
            if(nm.equals("END")) {
                break;
            } else {
                itm = new Item();
                itm.name = nm;
                itm.weight = sc.nextInt();
                itm.value = sc.nextInt();
                itms.add(itm);
            }
            sc.nextLine();
        }
    }

}
