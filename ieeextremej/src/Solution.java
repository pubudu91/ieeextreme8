
import java.util.Arrays;
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
        /*System.out.println(score("A", "A"));
         System.out.println(score("2", "2"));
         System.out.println(score("3", "3"));
         System.out.println(score("4", "4"));
         System.out.println(score("5", "5"));
         System.out.println(score("6", "6"));
         System.out.println(score("7", "7"));
         System.out.println(score("8", "8"));
         System.out.println(score("9", "9"));
         System.out.println(score("T", "T"));
         System.out.println(score("J", "J"));
         System.out.println(score("Q", "Q"));
         System.out.println(score("K", "K"));*/
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n <= 0) {
                return;
            }
            sc.nextLine();
            String[] la = sc.nextLine().split(" ");
            String[] lb = sc.nextLine().split(" ");
            int[] va = new int[la.length];
            int[] vb = new int[lb.length];
            for (int i = 0; i < n; i++) {
                va[i] = parse(la[i]);
                vb[i] = parse(lb[i]);
            }
            System.out.println(levenshtein(n, va, vb));
        }
    }

    public int parse(String c) {
        switch (c.toLowerCase().charAt(0x00)) {
            case 'a':
                return 20;
            case 't':
                return 10;
            case 'j':
                return 15;
            case 'q':
                return 16;
            case 'k':
                return 17;
            case 'r':
                return 50;
            default:
                return 0x02 + (c.charAt(0) - '2');
        }
    }

    public int levenshtein(int n, int[] ra, int[] rb) {
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            matrix[0][i] = 0;
            matrix[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int dr = matrix[i - 0x01][j - 0x01];
                int rai = ra[i - 0x01];
                int rbj = rb[j - 0x01];
                //System.out.println(Arrays.deepToString(matrix));
                int costa = dr + score(rai, rbj);
                int costb = matrix[i - 0x01][j];
                int costc = matrix[i][j - 0x01];
                matrix[i][j] = Math.max(costa, Math.max(costb, costc));
            }
        }
        return 0x02 * matrix[n][n];
    }

    public int score(String a, String b) {
        return score(parse(a), parse(b));
    }
    
    public int sinscore (int a) {
        if(a >= 15 && a <= 17) {
            return 15;
        } else {
            return a;
        }
    }

    public int score(int a, int b) {
        if (a == 50 || b == 50) {
            return Math.min(sinscore(a),sinscore(b));
        } else if (a == b) {
            if (a != 20) {
                return sinscore(a);
            } else {
                return 20;
            }
        } else {
            return 0x00;
        }
    }

}
