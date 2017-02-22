// cu mostenire
public class CoadaM extends Array {
	int tail, n;
	
	public CoadaM() {
		super();
		tail = -1;
		n = 10;
		// head will be 0
	}
	
	public CoadaM(int n) {
		super(n);
		tail = -1;
		this.n = n;
	}
	
	public void enqueue(int x) {
		if( !isFull() ) {
			tail = tail + 1;
			for(int i = tail - 1; i >= 0; i--) {
				super.set(i + 1, super.get(i));
			}
			super.set(0, x);
		}
	}
	
	public void dequeue() {
		if( !isEmpty() ) {
			super.set(tail, 0);
			tail = tail - 1;
		}
	}
	
	public boolean isFull() {
		return tail >= n - 1;
	}
	
	public boolean isEmpty() {
		return tail == -1;
	}
	
	public static void main(String [] str) {
		CoadaM coada = new CoadaM();
		coada.enqueue(1);
		coada.enqueue(2);
		coada.enqueue(3);
		coada.enqueue(4);
		coada.enqueue(5);
		
		System.out.println(coada);
		
		coada.dequeue();
		coada.dequeue();
		
		System.out.println(coada);
	}
}
