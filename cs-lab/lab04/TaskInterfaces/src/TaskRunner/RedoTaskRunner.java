public class RedoTaskRunner extends AbstractTaskRunner{

	private Stack tasks;
	
	RedoTaskRunner(Strategy strategy) {
		super(strategy);
		tasks = new Stack();
	}

	@Override
	protected void action(Task task) {
		System.out.println("RedoTaskRunner");
		tasks.push(task);
	}
	
	void reexecuteTasks() {
		int size = tasks.size();
		for(int i = 0; i < size; i++) {
			tasks.pop().execute();
		}
	}

}
