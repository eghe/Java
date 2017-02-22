
public class PasswordMaker {
	private final int MAGIC_NUMBER = 10;
	private final String MAGIC_STRING;
	private final String ALPHABET =  "abcdefghiklmnopqrstxy1234567890";
	private String firstName;
	private String lastName;
	private int age;
	
	public PasswordMaker(String firstName, String lastName, int age) {
		RandomStringGenerator gen1 = new RandomStringGenerator(20, ALPHABET);
		MAGIC_STRING = gen1.next();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getPassword() {
		RandomStringGenerator gen2 = new RandomStringGenerator(10, MAGIC_STRING);
		String str = gen2.next();
		
		String pwd;
		pwd = firstName.substring(firstName.length() - age % 3);
		pwd += str;
		Integer i = age + lastName.length();
		pwd += i.toString();
		
		return pwd;
	}
	
	public static void main(String [] str) {
		PasswordMaker pwd = new PasswordMaker("Georgiana", "Elena", 25);
		System.out.println(pwd.getPassword());
	}
}
