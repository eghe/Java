package Bash;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import Bash.BashUtils.Echo;

public class Bash {
    public Path currentDirectory;
    public StringBuffer history;

    private CommandPublisher publisher;
    private static final String EXIT = "exit";

    public Bash() {
        // TODO 2 Initialize history and currentDirectory;
        history = new StringBuffer();
        currentDirectory = Paths.get(".");

        // TODO 2 Instantiate a new command publisher
        publisher = new BashCommandPublisher() ;

        // TODO 4 & 5 & 6 & 7
        // CommandSubscribers know how to execute the commands. Subscribe some to the Command publisher.
        CommandSubscriber echo = new BashUtils().new Echo();
        publisher.subscribe(echo);
        
        CommandSubscriber cd = new BashUtils().new Cd();
        publisher.subscribe(cd);
        
        CommandSubscriber ls = new BashUtils().new Ls();
        publisher.subscribe(ls);
        
        CommandSubscriber history = new BashUtils().new History();
        publisher.subscribe(history);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // TODO 3 Read commands from the command line
            String input = scanner.nextLine();

            // TODO 3 If we read the "exit" string then we should stop the program.
            if(input.equals("exit")) {
            	break;
            }
            
            // TODO 3 Create an anonymous class which extends Thread.
            // It has to implement the 'run' method. From the 'run' method publish the command
            // so that the CommandSubscribers start executing it.
            // Don't forget to start the thread by calling the 'start' method on it!

            Thread t = new Thread() {
            	public void run() {
            		Command command = new Command(input, Bash.this);
            		publisher.publish(command);
            	}
            };
            t.start();
        }
    }

    // TODO 1: Create an inner class which implements the CommandPublisher interface.
    // 1. The class should contain an ArrayList of CommandSubscribers
    // 2. The class should implement the subscribe and publish methods.

    class BashCommandPublisher implements CommandPublisher {

    	ArrayList<CommandSubscriber> subscribers;
    	
    	BashCommandPublisher() {
    		subscribers = new ArrayList<CommandSubscriber>();
    	}
    	
		@Override
		public void subscribe(CommandSubscriber subscriber) {
			// TODO Auto-generated method stub
			subscribers.add(subscriber);
		}

		@Override
		public void publish(Command command) {
			// TODO Auto-generated method stub
			for(CommandSubscriber s : subscribers) {
				s.executeCommand(command);
			}
		}
    }
    
    void setCurrentDirectory(Path dir) {
    	currentDirectory = dir;
    }
    
    void appendToHistory(String command) {
    	history.append(" | " + command);
    }
}
