
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author kommusoft
 */
public class Solution {
    
    private class Item implements Comparable<Item> {
        
        public String name;
        public int weight;
        public int value;
        public int take;
        
        @Override
        public int compareTo(Item t) {
            return ((Integer) (t.value * weight)).compareTo(t.weight * value);
        }
        
    }
    
    public static void main(String[] args) {
        new Solution().run();
    }
    
    private void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int k = sc.nextInt();
        int tot = r * k;
        sc.nextLine();
        sc.useDelimiter("[\n\t\r,]+");
        ArrayList<Item> itms = new ArrayList<>();
        Pattern p = Pattern.compile("[^,]+");
        Item itm;
        
        while (sc.hasNextLine()) {
            String nm = sc.next(p);
            System.out.println(nm);
            if (nm.equals("END")) {
                break;
            } else {
                itm = new Item();
                itm.name = nm;
                itm.weight = sc.nextInt();
                itm.value = sc.nextInt();
                itms.add(itm);
            }
        }
        Collections.sort(itms);
        int rem = tot;
        for(Item itmi : itms) {
            int wgh = itmi.weight;
            int take = rem/wgh;
            itmi.take = take;
            rem -= wgh*take;
        }
    }
    
}
