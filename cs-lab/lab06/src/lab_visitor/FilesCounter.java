package lab_visitor;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Stores the paths of all the Java files in a given directory. 
 */
public class FilesCounter extends SimpleFileVisitor<Path> {

	private ArrayList<Path> javaFiles;
	
	FilesCounter() {
		javaFiles = new ArrayList<Path>();
	}
	
    public ArrayList<Path> getJavaFiles() {
		return javaFiles;
	}
    
    //TODO - override visit method(s)
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
    		throws IOException
    {
    	javaFiles.add(file);
    	return FileVisitResult.CONTINUE;
    }
}