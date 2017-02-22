
public class Forma {
	String culoare;
	
	public Forma() {
		culoare = "Red";
	}
	
	public Forma(String culoare) {
		this.culoare = culoare;
	}
	
	public float getArie() {
		return 0;
	}
	
	public String toString() {
		return culoare;
	}
}

class Triunghi extends Forma {
	float  inaltime, baza;
	
	public Triunghi() {
		super();
	}
	
	public Triunghi(String culoare, float inaltime, float baza) {
		super(culoare);
		this.inaltime = inaltime;
		this.baza = baza;
	}
	
	public float getArie() {
		return (inaltime * baza) / 2;
	}
	
	public String toString() {
		return "Triunghi: " + super.toString() + " " + getArie();
	}
	
	public boolean equals(Triunghi t) {
		return inaltime == t.inaltime && 
				baza == t.baza;
	}
	
	public void printDimTriunghi() {
		System.out.println("* Triunghi: h: " + inaltime + " b: " + baza);
	}
}

class Cerc extends Forma {
	float raza;
	final float PI = 3.14f;
	
	public Cerc() {
		super();
	}
	
	public Cerc(String culoare, float raza) {
		super(culoare);
		this.raza = raza;
	}
	
	public float getArie() {
		return PI * raza * raza;
	}
	
	public String toString() {
		return "Cerc: " + super.toString() + " " + getArie();
	}
	
	public void printDimCerc() {
		System.out.println("* Cerc: r: " + raza);
	}
}
