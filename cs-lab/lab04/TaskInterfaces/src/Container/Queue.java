public class Queue implements Container {
	private Task [] data;
	private int n; // max number of elements
	private int tail;

	public Queue() {
		this.n = 10;
		this.tail = -1;
		this.data = new Task[this.n];
	}
	
	Queue(int n) {
		this.n = n;
		this.tail = -1;
		this.data = new Task[this.n];
	}
	
	@Override
	public Task pop() {
		if( !isEmpty() ) {
			Task tmp = data[tail];
			data[tail] = null;
			tail = tail - 1;
			return tmp;
		}
		return null;
	}

	@Override
	public Task push(Task t) {
		if( !isFull() ) {
			tail = tail + 1;
			for(int i = tail - 1; i >= 0; i--) {
				data[i + 1] = data[i];
			}
			data[0] = t;
			return t;
		}
		return null;
	}

	@Override
	public int size() {
		return tail + 1;
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public void transferFrom(Container c) {
		n = c.capacity();
		int size = c.size();

		for(int i = 0; i < size; i++) {
			push(c.pop());
		}
	}

	public boolean isFull() {
		return tail >= n;
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return n;
	}
}
