
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

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        int[] rs = new int[r];
        for (int i = 0; i < r; i++) {
            rs[i] = Integer.parseInt(sc.nextLine().replaceAll(" ", ""), 0x02);
        }
        int k = 0x00;
        ArrayList<Integer> err1 = new ArrayList<Integer>();
        for (int i1 = 0x00; i1 < r - 0x01; i1++) {
            int res = (rs[i1] ^ rs[i1 + 0x01]) & (~(rs[i1 + 0x01] ^ rs[r - 0x01]));
            if (res == 0x00) {
                err1.add(i1);
            }
        }
        ArrayList<Integer> err2 = new ArrayList<Integer>();
        for (int i1 = 0x00; i1 < r - 0x02; i1++) {
            for (int i2 = i1+0x01; i2 < r - 0x01; i2++) {
                int res = (rs[i1] ^ rs[i1 + 0x01]) & (~(rs[i1 + 0x01] ^ rs[i2])) & (~(rs[i2] ^ rs[i2 + 0x01]));
                if (res == 0x00) {
                    err2.add((i1<<0x10)+i2);
                }
            }
        }
        System.out.println(err1.size()+err2.size());
        for(Integer e : err1) {
            System.out.println("i_1="+(e+0x01));
        }
        for(Integer e : err2) {
            System.out.println("i1="+((e>>0x10)+0x01)+" i2="+((e & 0xff)+0x01));
        }
    }

}
