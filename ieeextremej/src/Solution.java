
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kommusoft
 */
public class Solution {
    
    public static void main (String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[] rs = new int[r];
        for(int i = 0; i < r; i++) {
            rs[i] = Integer.parseInt(sc.nextLine().replaceAll(" ",""),0x02);
        }
        int k = 0x00;
        ArrayList<Integer> err = new ArrayList<Integer>();
        for(int i1 = 0x00; i1 < r-0x01; i1++) {
            int res = (rs[i1]^rs[i1+0x01])&(~(rs[i1+0x01]^rs[r-0x01]));
        }
    }
    
}
