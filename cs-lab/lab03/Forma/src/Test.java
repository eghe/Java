
public class Test {
	public static void main(String [] str) {
		Forma t = new Triunghi("green", 1.2f, 3.4f);
		Forma c = new Cerc("blue", 2);
		
		System.out.println("Triunghi: ");
		System.out.println(t.toString());
		System.out.println(t.getArie());
		
		System.out.println("\nCerc: ");
		System.out.println(c.toString());
		System.out.println(c.getArie());
		
		Forma t2 = new Triunghi("yellow", 2.2f, 1.4f);
		System.out.println("Triunghi equals: " + t.equals(t2));
		
		Forma [] forms = new Forma[5];
		forms[0] = t;
		forms[1] = c;
		forms[2] = new Triunghi("grey", 1.2f, 3.4f);
		forms[3] = new Cerc("orange", 2);
		forms[4] = new Cerc("violet", 2);

		System.out.println("----");
		for(int i = 0; i < forms.length; i++) {
			System.out.println(forms[i].toString());
			if(forms[i] instanceof Triunghi)
				((Triunghi)forms[i]).printDimTriunghi();
			else
				((Cerc)forms[i]).printDimCerc();
		}
	}
}
