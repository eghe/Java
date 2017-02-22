import java.util.Date;

public class DelayPrintTaskRunner extends PrintTaskRunner {

	DelayPrintTaskRunner(Strategy strategy) {
		super(strategy);
	}

	@Override
	protected void action(Task task) {
		System.out.println("DelayPrintTaskRunner " + new Date());
		
		try {
		    Thread.sleep(1000); // miliseconds
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
}
