import java.util.Scanner;

public class BookstoreTest {
	public static void main(String [] args) {
		 Scanner s = new Scanner(System.in);
		 
		 System.out.println("Enter book1");
	     String title = s.nextLine();
	     String author = s.nextLine();
	     String publisher = s.nextLine();
	     Integer numPages = s.nextInt();
	     
	     if(numPages == 0) {
	    	 System.out.println("Num pages is 0 for " + title + " " + author);
	    	 numPages = s.nextInt();
	     }
	     s.nextLine();
	     
	     Book b1 = new Book(title, author, publisher, numPages);
	     
	     System.out.println("Enter book2");
	     title = s.nextLine();
	     author = s.nextLine();
	     publisher = s.nextLine();
	     numPages = s.nextInt();
	     
	     if(numPages == 0) {
	    	 System.out.println("Num pages is 0 for " + title + " " + author);
	    	 numPages = s.nextInt();
	     }
	     
	     Book b2 = new Book(title, author, publisher, numPages);
	     
	     b1.showInfo();
	     b2.showInfo();
	     
	     System.out.println("Book1 == Book2? " + BookstoreCheck.isDuplicated(b1, b2));
	     System.out.println("Book1 == Book2? " + BookstoreCheck.isLonger(b1, b2));
	}
}
