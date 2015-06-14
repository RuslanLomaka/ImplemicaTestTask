package factorial;

import java.math.BigInteger;

public class factorialCalculation {
	public static void main(String[] args) {
		
		BigInteger a = BigInteger.ONE;
		for (int i = 1; i < 100; i++) {
			a = a.multiply(BigInteger.valueOf((long) i));
		}
		
		String A = a.toString();
		//System.out.println(A);
		//System.out.println(A.length());
		char[] b = new char[A.length()];
		A.getChars(0, A.length(), b, 0);
		System.out.println(b);
		int result = 0;
		for (int i = 0; i < A.length(); i++) {
			result += (int) Character.getNumericValue(b[i]);
		}
		System.out.println("Result=" + result);
	}
}