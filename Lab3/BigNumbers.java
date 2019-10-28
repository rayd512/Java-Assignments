import java.math.BigInteger;

public class BigNumbers {
	public static void main(String[] args) {
		System.out.println(num("hello".toCharArray(), 5));
	}
	public static BigInteger num(char[] p, int c) {
		BigInteger h = new BigInteger("14695981039346656037");
		BigInteger prime = new BigInteger("1099511628211");
		for(int i = 0; i < c; i++) {
			h = (h.multiply(prime)).xor(BigInteger.valueOf(Character.getNumericValue(p[i])));
		}
		return h;
	}
}