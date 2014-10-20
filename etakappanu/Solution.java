import java.util.Scanner;
import java.util.TreeSet;
import java.lang.Math;

public class Solution {

	public static void main(String[] args) {
		class Card {
			public char val;
			public int sameRowScore;  // score due to combining with card in same row
			public int otherRowScore; // score due to combining with card in other row
			public Card(char val) {
				this.val = val;
				this.sameRowScore = 0;
				this.otherRowScore = 0;
			}
			public int matchingScore() { // score for a matching card
				switch (val) {
					case 'R': return 50;
					case 'A': return 20;
					case 'K':
					case 'Q':
					case 'J': return 15;
					case 'T': return 10;
					default: return val - '0';
				}
			}
			public void updateOtherRowScore(Card other) { // card must be from other row
				int matchScore; // extra score due to a match
				if (this.val == 'R') {
					matchScore = other.matchingScore();
				} else if (other.val == 'R') {
					matchScore = this.matchingScore();
				} else if (this.val == other.val) {
					matchScore = matchingScore();
				} else {
					return; // incompatible cards
				}
				otherRowScore = Math.max(otherRowScore, matchScore + other.sameRowScore);
			}
			public void updateSameRowScore(Card other) { // card must be from same row
				sameRowScore = Math.max(sameRowScore, other.otherRowScore);
			}
		}

		// READ CASES
		Scanner sc = new Scanner(System.in);
		while (true) {
			int numCases = sc.nextInt();
			if (numCases == 0)
				break;
			for (int i = 0; i < numCases; i++) {
				int n = sc.nextInt(); sc.nextLine();
				Card[][] cards = new Card[2][n];
				for (int j = 0; j < 2; j++) {
					String str = sc.nextLine();
					String[] vals = str.split(" ");
					for (int k = 0; k < n; k++) {
						cards[j][k] = new Card(vals[k].charAt(0));
					}
				}

				// PROCESS CASE
				int bestScore = 0;
				for (int k = n-1; k >= 0; k--) {
					for (int row = 0; row < 2; row++) {
						// compute best score of card [row][k]
						Card card = cards[row][k];
						int cardScore = -1;
						// keep cards in the same column for last, because special case
						for (int column = k+1; column < n; column++) { // go to right
							// through a match in the other row
							int otherRowScore = card.getMatchScore(cards[1-row][column]);
							cardScore = Math.max(cardScore, otherRowScore);

							// through a new card in the same row
							int sameRowScore = card.score + cards[row][column].score;
							cardScore = Math.max(cardScore, sameRowScore);

							System.out.println("row "+row+", col "+column+" otherRowScore "+otherRowScore+", sameRowScore "+sameRowScore);
						}
						card.score = cardScore;
						bestScore = Math.max(bestScore, cardScore);
					}
					// Now there is still the possibility that the best 
					// path is by directly combining from the same column 
					// (index k from other row)
					int matchScore = cards[0][k].getOnlyMatchingPartScore(cards[1][k]);
					if (matchScore >= 0) {
						System.out.println("column k "+k+" colum-match, scores "+(matchScore + cards[1][k].score)+", "+(matchScore + cards[0][k].score));
						cards[0][k].score = Math.max(cards[0][k].score, matchScore + cards[1][k].score);
						cards[1][k].score = Math.max(cards[1][k].score, matchScore + cards[0][k].score);
						bestScore = Math.max(bestScore, cards[0][k].score);
						bestScore = Math.max(bestScore, cards[1][k].score);
					}
				}
				System.out.println(bestScore);
			}
		}
	}
}

