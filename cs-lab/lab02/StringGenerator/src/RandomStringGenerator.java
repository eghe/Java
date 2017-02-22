import java.util.Random;

public class RandomStringGenerator {
	String str;
	int n;
	
	public RandomStringGenerator(int n, String str) {
		this.n = n;
		this.str = str;
	}
	
	public String next() {
		String tmp = str;
		char [] x = new char[n];
		
		int k = n;
		
		for(int i = 0; i < n; i++) {
			Random generator = new Random();
			/*int j = generator.nextInt(k);
			x[i] = tmp.charAt(j);
			tmp = tmp.substring(0, j) + tmp.substring(j + 1);
			k = k - 1;*/
			int j = generator.nextInt(n);
			x[i] = tmp.charAt(j);
		}
		
		String gen = new String(x);
		return gen;
	}
	
	public static void main(String [] str) {
		RandomStringGenerator gen = new RandomStringGenerator(5, "abcde");
		System.out.println(gen.next());
		System.out.println(gen.next());
		System.out.println(gen.next());
		System.out.println(gen.next());
		System.out.println(gen.next());
	}
}
