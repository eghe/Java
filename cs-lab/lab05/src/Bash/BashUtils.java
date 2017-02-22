package Bash;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

enum Commands {
    CD("cd"),
    LS("ls"),
    ECHO("echo"),
    HISTORY("history");

    private final String text;

    private Commands(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

public class BashUtils {

    // Implement some inner classes here: Echo, Cd, Ls, History

    // example: class Cd { ... }

    // Decide if they should be static or non-static.

    // TODO 4 Create Echo class
	class Echo implements CommandSubscriber{
		@Override
		public void executeCommand(Command c) {
			String cmd = c.getCommand();
			if(cmd.startsWith(Commands.ECHO.toString())) {
				c.getBash().appendToHistory(cmd);
				String text = cmd.replaceFirst(Commands.ECHO.toString(), "");
				text = text.trim(); // assign back the variable
				System.out.println(text);
			}
		}
	}

    // TODO 5 Create Cd class
	class Cd implements CommandSubscriber {

		@Override
		public void executeCommand(Command c) {
			String cmd = c.getCommand();
			if(cmd.startsWith(Commands.CD.toString())) {
				c.getBash().appendToHistory(cmd);
				String dir = cmd.replaceAll(Commands.CD.toString(), "");
				dir = dir.trim();
				
				Path currentDir = Paths.get(".");
				String pDir = currentDir.toString().concat(dir);

				c.getBash().setCurrentDirectory(Paths.get(dir));
				System.out.println("Cd in: " + c.getBash().currentDirectory);
			}
		}
	}

    // TODO 6 Create the Ls class
	class Ls implements CommandSubscriber {

		@Override
		public void executeCommand(Command c) {
			String cmd = c.getCommand();
			if(cmd.startsWith(Commands.LS.toString()) &&
					cmd.endsWith(Commands.LS.toString())) {
				c.getBash().appendToHistory(cmd);
				File folder = new File(c.getBash().currentDirectory.toString());
				System.out.println("Ls in: " + c.getBash().currentDirectory);
				for(File f : folder.listFiles()) {
					System.out.println(f);
				}
			}
		}
	}
    // TODO 7 Create the History class
	class History implements CommandSubscriber {

		@Override
		public void executeCommand(Command c) {
			String cmd = c.getCommand();
			if(cmd.startsWith(Commands.HISTORY.toString())) {
				System.out.println(c.getBash().history.toString());
			}
		}
	}
}
