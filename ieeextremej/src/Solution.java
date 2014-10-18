
import java.util.Arrays;
import java.util.Collections;

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
        //System.out.println(score("3","3"));
        //Sytem.out.println(score("7","7"));
        //System.out.println(score("R","R"));
        //System.out.println(score("T","T"));
        //Scanner sc = new Scanner(System.in);
        System.out.println(levenshtein(9, new int[]{6, 3, 7, 4, 2, 20, 17, 16, 10}, new int[]{3, 5, 4, 7, 50, 20, 16, 17, 10}));
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
        int[][] matrix = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            matrix[0][i] = 0;
            matrix[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int dr = matrix[i - 0x01][j - 0x01];
                int cost = dr + score(ra[i - 0x01], rb[j - 0x01]);
                cost = Math.max(cost, matrix[i - 0x01][j]);
                cost = Math.max(cost, matrix[i][j - 0x01]);
                matrix[i][j] = cost;
            }
        }
        System.out.println(Arrays.deepToString(matrix).replace("], [", "],\n["));
        return matrix[n][n];
    }

    public int score(String a, String b) {
        return score(parse(a), parse(b));
    }

    public int score(int a, int b) {
        if (a == 50 || b == 50) {
            return Math.min(a, b);
        } else if (a == b) {
            if (a != 20) {
                return Math.min(15, a);
            } else {
                return 20;
            }
        } else {
            return 0x00;
        }
    }

}
