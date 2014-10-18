
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        
        public int totalW () {
            return this.take*this.weight;
        }
        
        public int totalV () {
            return this.take*this.value;
        }

        @Override
        public String toString() {
            return String.format("%s,%s,%s,%s",this.name,this.take,this.take*this.weight,this.take*this.value);
        }
        
    }
    
    private class Sorter implements Comparator<Item> {

        @Override
        public int compare(Item t, Item t1) {
            return t.name.compareTo(t1.name);
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
        Pattern p = Pattern.compile("[^,\n\t\r]+");
        Item itm;
        
        while (sc.hasNextLine()) {
            String nm = sc.next(p);
            System.out.println("nw");
            if (nm.toLowerCase().equals("end")) {
                System.out.println("ENDED NWO");
                break;
            } else {
                itm = new Item();
                itm.name = nm;
                itm.weight = sc.nextInt();
                itm.value = sc.nextInt();
                itms.add(itm);
                System.out.println("ADDED");
            }
        }
        System.out.println("STARt");
        Collections.sort(itms);
        int rem = tot;
        for(Item itmi : itms) {
            int wgh = itmi.weight;
            int take = rem/wgh;
            itmi.take = take;
            rem -= wgh*take;
        }
        Collections.sort(itms,new Sorter());
        int v = 0x00;
        int w = 0x00;
        for(Item itmi : itms) {
            if(itmi.take > 0) {
                System.out.println(itmi);
                w += itmi.totalW();
                v += itmi.totalV();
            }
        }
        System.out.println(String.format("%s,%s",w,v));
        System.out.println(String.format("Each robber gets: %.2f",(double) v/r));
    }
    
}
