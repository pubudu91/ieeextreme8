
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        int tot = r * k;
        sc.nextLine();
        ArrayList<Item> itms = new ArrayList<>();
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Item itm;

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
            String nm = sc.next(p);
            if (nm.equals("END")) {
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
