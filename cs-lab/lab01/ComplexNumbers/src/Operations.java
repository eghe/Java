
public class Operations {

	Complex add(Complex c1, Complex c2) {
		return new Complex(c1.re + c2.re, c1.im + c2.im);
	}
	
	Complex mult(Complex c1, Complex c2) {
		return new Complex(c1.re * c2.re - c1.im * c1.im, c1.re * c2.im + c1.im * c2.re);
	}
	
	public static void main(String [] args) {
		Complex c1 = new Complex(3,4);
		Complex c2 = new Complex(5,6);
		Operations op = new Operations();
		Complex c3 = op.add(c1, c2);
		Complex c4 = op.mult(c1, c2);		
		
		System.out.println(c3.re + " " + c3.im);
		System.out.println(c4.re + " " + c4.im);
	}
}
