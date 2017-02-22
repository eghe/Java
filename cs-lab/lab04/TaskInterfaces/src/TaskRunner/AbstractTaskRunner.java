import java.util.ArrayList;

public abstract class AbstractTaskRunner {
	private Strategy strategy;
	Container tasksCont;
	
	AbstractTaskRunner(Strategy strategy) {
		this.strategy = strategy;
		tasksCont =ContainerFactory.Instance.createContainer(strategy);
	}
	
	protected void addTask(Task task) {
		tasksCont.push(task);
	}
	
	protected void executeAll() {
		int size = tasksCont.size();
		for(int i = 0; i < size; i++) {
			Task task = tasksCont.pop();
			task.execute();
			action(task);
		}
	}
	
	protected abstract void action(Task task);
}
