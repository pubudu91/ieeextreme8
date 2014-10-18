import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Solution {

	public static void main(String[] args) {
		class Pair implements Comparable<Pair> {
			public int val;
			public int label;
			public Pair(int val, int label) {
				this.val = val;
				this.label = label;
			}
			public int compareTo(Pair other) {
				int a = ((Integer) val).compareTo(other.val);
				if (a != 0)
					return a;
				else
					return ((Integer) label).compareTo(other.label);
			}
			public boolean equals(Object other) {
				return compareTo((Pair) other) == 0;
			}
			public int hashCode() {
				return val * 4242 + label;
			}
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		int[] array = new int[n+m];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		// explicitly add the 'overspill'
		for (int i = n; i < n+m; i++) {
			array[i] = array[i-n];
		}


		int smallerNumElem;
		int largerNumElem;
		TreeSet<Pair> smaller = new TreeSet<Pair>(); // at least k elements
		TreeSet<Pair> larger = new TreeSet<Pair>();
		
		for (int i = 0; i < m; i++) {
			smaller.add(new Pair(array[i], i));
		}
		for (int i = 0; i < m-k; i++) {
			larger.add(smaller.pollLast());
		}
		if (smaller.size() != k)
			System.out.println("FUCK");
		if (larger.size() != m-k)
			System.out.println("FUCK2");
		// smaller.last() is the k smallest!

		int kmin = smaller.last().val;
		for (int i = m; i < n+m; i++) {
			Pair toRemove = new Pair(array[i-m], i-m);
			if (smaller.contains(toRemove)) {
				smaller.remove(toRemove);
				if (!larger.isEmpty())
					smaller.add(larger.pollFirst()); // make sure always k elements in smaller
			} else {
				larger.remove(toRemove);
			}

			Pair toAdd = new Pair(array[i], i);

			Pair oldkSmallest = smaller.last();
			//hack because k >= 2 in cases, blah
			if (larger.isEmpty()) {
				smaller.add(toAdd);
			} else {

				if (toAdd.val < oldkSmallest.val) {
					smaller.add(toAdd);
					larger.add(smaller.pollLast());
				} else {
					larger.add(toAdd);
				}

			}
			if (smaller.size() != k)
				System.out.println("FUCK3");
			if (larger.size() != m-k)
				System.out.println("FUCK4");

			kmin = Math.min(kmin, smaller.last().val);
		}
		System.out.println(kmin);
	}

}
