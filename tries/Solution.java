import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		for (long i = 0; i < T; i++) {
			long A = sc.nextLong();
			long L = sc.nextLong();
			long N = sc.nextLong();
            
            long bytesPerNode = 4 * A;

			double exponent = Math.floor(Math.log((double)N) / Math.log((double)A)); // TODO: + epsilon before floor?
			System.out.println("exponent "+exponent);
            long expandingDepth = (long)(0.5 + exponent); // depth of purely exponentially expanding part, including the root node
			System.out.println("expandingDepth "+expandingDepth);
            if (expandingDepth >= L) {
                long numNodes = (long) + (0.5 + (Math.pow((double)A, (double)L) - 1) / (double)(A - 1));
				System.out.println("numNodes "+numNodes);
                System.out.println(numNodes * bytesPerNode);
                continue;
            }
			long numExpanding = (long) (0.5 + (Math.pow((double)A, exponent+1) - 1) / (double)(A - 1));
			System.out.println("numExpanding "+numExpanding);
            long numFixedWidth = (long) (L - expandingDepth) * N;
			System.out.println("numFixedWidth "+numFixedWidth);

			System.out.println((numExpanding + numFixedWidth) * bytesPerNode);
		}
	}
}
