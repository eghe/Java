
public class Test {
	public static void test1() {
		long start = System.nanoTime();
		Integer a = new Integer(10 + 1);
		long end = System.nanoTime();
		System.out.println(end - start);
		
		start = System.nanoTime();
		Integer b = 10 + 1;
		end = System.nanoTime();
		System.out.println(end - start);
	}
	
	public static void test2() {
		long start = System.nanoTime();
		String str = new String("abc");
		long end = System.nanoTime();
		System.out.println(end - start);
		
		start = System.nanoTime();
		String str2 = "abc";
		end = System.nanoTime();
		System.out.println(end - start);
	}
	
	public static void main(String [] str) {
		Test.test1();
		Test.test2();
	}
}
