
public class BookstoreCheck {
	public static boolean isDuplicated(Book b1, Book b2) {
		if(b1.author.equals(b2.author) && b1.title.equals(b2.title) &&
				b1.publisher.equals(b2.publisher) && b1.numPages.equals(b2.numPages)) {
			return true;
		}
		return false;
	}
	
	public static boolean isLonger(Book b1, Book b2) {
		return b1.numPages.compareTo(b2.numPages) > 0;
	}
}
