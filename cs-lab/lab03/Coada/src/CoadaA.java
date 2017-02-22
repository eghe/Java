
public class CoadaA {
	Array data;
	int tail;
	int n;
	
	public CoadaA() {
		data = new Array(10);
		this.tail = -1;
		this.n = 10;
	}
	
	public CoadaA(int n) {
		data = new Array(n);
		this.tail = -1;
		this.n = n;
	}
	
	public void enqueue(int x) {
		if(! isFull() ) {
			tail = tail + 1;
			for(int i = tail - 1; i >= 0; i--) {
				data.set(i + 1, data.get(i));
			}
			data.set(0, x);
		}
	}
	
	public void dequeue() {
		if(! isEmpty() ) {
			data.set(tail, 0);
			tail = tail - 1;
		}
	}
	
	public boolean isEmpty() {
		return tail == -1;
	}
	
	public boolean isFull() {
		return tail >= n;
	}
	
	public String toString() {
		return data.toString();
	}
	
	public static void main(String [] str) {
		CoadaA coada = new CoadaA();
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
