

public class ContainerFactory implements IFactory {

	public static final ContainerFactory Instance = new ContainerFactory();
	private ContainerFactory() {}
	
	@Override
	public Container createContainer(Strategy strategy) {
		System.out.println("Strat: " + strategy);
		if(strategy == Strategy.FIFO)
			return new Stack();
		if(strategy == Strategy.LIFO)
			return new  Queue();
		return null;
	}

}
