public class Test {

	public static void main(String [] str) {
		Task t1 = new Task1();
		t1.execute();
		
		Task t2 = new Task2();
		t2.execute();
		
		Task t3 = new Task3();
		t3.execute();
		
		Queue q = new Queue();
		q.push(t1);
		q.push(t2);
		q.push(t3);
		
		System.out.println("------");
		int size = q.size();
		for(int  i = 0; i < size; i++) {
			q.pop().execute();
		}
		
		q.push(t1);
		q.push(t2);
		q.push(t3);
		
		Queue qCp = new Queue();
		qCp.transferFrom(q);
		
		System.out.println("------");
		System.out.println("Size queue q: " + q.size());
		size = qCp.size();
		for(int  i = 0; i < size; i++) {
			qCp.pop().execute();
		}
		
		Stack s = new Stack();
		s.push(t1);
		s.push(t2);
		s.push(t3);
		
		System.out.println("Stack:");
		System.out.println("------");
		size = s.size();
		for(int i = 0; i < size; i++) {
			s.pop().execute();
		}
		
		s.push(t1);
		s.push(t2);
		s.push(t3);
		
		Stack sCp = new Stack();
		sCp.transferFrom(s);
		size = sCp.size();
		
		System.out.println("------");
		for(int i = 0; i < size; i++) {
			sCp.pop().execute();
		}
		
		// Task 3
		Container s1 = ContainerFactory.Instance.createContainer(Strategy.FIFO);
		Container s2 = ContainerFactory.Instance.createContainer(Strategy.LIFO);
		
		s1.push(t1);
		s2.push(t2);
		
		int size1 = s1.size();
		System.out.println("FIFO: ------");
		for(int i = 0; i < size1; i++) {
			s1.pop().execute();
		}
		
		int size2 = s2.size();
		System.out.println("LIFO: ------");
		for(int i = 0; i < size2; i++) {
			s2.pop().execute();
		}
		
		CountTaskRunner countTask = new CountTaskRunner(Strategy.FIFO);
		countTask.addTask(t1);
		countTask.addTask(t2);
		countTask.executeAll();
		
		PrintTaskRunner printTask = new PrintTaskRunner(Strategy.FIFO);
		printTask.addTask(t1);
		printTask.addTask(t2);
		printTask.executeAll();
		
		RedoTaskRunner redoTask = new RedoTaskRunner(Strategy.FIFO);
		redoTask.addTask(t1);
		redoTask.addTask(t2);
		redoTask.executeAll();
		System.out.println("===");
		redoTask.reexecuteTasks();
		
		DelayPrintTaskRunner delayTask = new DelayPrintTaskRunner(Strategy.FIFO);
		delayTask.addTask(t1);
		delayTask.addTask(t2);
		delayTask.executeAll();
	}
}
