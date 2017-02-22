public class Stack implements Container{
	Task [] data;
	int peek;
	int n;
	
	Stack() {
		this.n = 10;
		this.peek = -1;
		this.data = new Task[this.n];
	}
	
	Stack(int n) {
		this.n = n;
		this.peek = -1;
		this.data = new Task[this.n];
	}
	
	@Override
	public Task pop() {
		if(! isEmpty() ) {
			Task tmp = data[peek];
			peek = peek - 1;
			return tmp;
		}
		return null;
	}

	@Override
	public Task push(Task t) {
		if(! isFull() ) {
			peek = peek + 1;
			data[peek] = t;
			return t;
		} 
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return peek + 1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return peek == -1;
	}
	
	public boolean isFull() {
		return peek >= n;
	}

	@Override
	public void transferFrom(Container c) {
		// TODO Auto-generated method stub
		
		Stack tmp = new Stack(c.capacity());
		
		int size = c.size();
		for(int i = 0; i < size; i++) {
			tmp.push(c.pop());
		}
		
		n = c.capacity();
		for(int i = 0; i < size; i++) {
			push(tmp.pop());
		}
	}

	@Override
	public int capacity() {
		return n;
	}

}
