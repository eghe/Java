public class CountTaskRunner extends AbstractTaskRunner {

	static int cnt = 0;
	
	CountTaskRunner(Strategy strategy) {
		super(strategy);
	}

	@Override
	protected void action(Task task) {
		System.out.println("CountTaskRunner, executed: " + (++cnt));
	}
}
