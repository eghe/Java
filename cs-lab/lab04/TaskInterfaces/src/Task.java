
import java.util.Random;

public interface Task {
	void execute();
}

class Task1 implements Task {
	public void execute() {
		System.out.println("Executing task1");
	}
}

class Task2 implements Task {
	public void execute() {
		Random r = new Random();
		System.out.println("Executing task2: " + r.nextInt(100));
	}
}

class Task3 implements Task {
	public void execute() {
		System.out.println("Executing task3");
	}
}