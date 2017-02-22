import java.util.Date;

public class PrintTaskRunner extends AbstractTaskRunner {

	PrintTaskRunner(Strategy strategy) {
		super(strategy);
	}

	@Override
	protected void action(Task task) {
		System.out.println("PrintTaskRunner " + new Date());
	}
	
}
