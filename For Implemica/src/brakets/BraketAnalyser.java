package brakets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BraketAnalyser {

	public static StringBuilder binar(int a) {
		int b;
		StringBuilder sb = new StringBuilder();

		while (a != 0) {
			b = a % 2;
			a = a / 2;
			sb.append(b);
		}
		return sb;
	};
	
	/**
	 * @param N the number of bracket pairs
	 * @return the number of combinations
	 */
	public static int getCombinationQuantity(int N) {
		return (int) Math.pow(2.0, (2 * N));
	};

	/**
	 * Get input data from user
	 * @return number of pairs of brackets
	 */
	public static int getN() {
		System.out.println("Input N please:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 0;
		try {
			N = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.err.println("Make shure You have typed the NUMBER!!!");
			e.printStackTrace();
			return getN();
		}
		return N;
	};
	
	
	//MAIN METHOD--------------------------
	public static void main(String[] args) {
		
		StringBuilder sb;
		StringBuilder braketsSb;
		
		int N = getN();
		int combinationQuantity = getCombinationQuantity(N);
		//System.out.println("CombinationQuantity = " + combinationQuantity);
		
		int numberOfCorrectCombinations = 0;
		for (int i = 0; i < combinationQuantity; i++) {

			sb = binar(i);
			int answer = 0;
			if (sb.length() == (2 * N)) {
				// System.out.println(sb);
				
				
				
				/* Next steps presents the heart of algorithm.
				 * 
				 * 1. While loop constructs all brackets combinations.*/
				 
				int k = i;
				int b = 0;
				braketsSb = new StringBuilder();
				while (k != 0) {
					b = k % 2;
					k /= 2;
					if (b == 0) {
						braketsSb.append('(');
						answer++;
					} else {
						braketsSb.append(')');
						answer--;
					}
					if (answer < 0 || answer > N) {
						break;
					}
				}
							
				// 2.  And if combination is correct, we increase by 1 the answer value
							
				if (answer == 0 && braketsSb.length() == 2 * N) {
					System.out.println(braketsSb);
					numberOfCorrectCombinations++;
				}
			}
		}
		System.out.println("Number of variants: " + numberOfCorrectCombinations);
	}
};