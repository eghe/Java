
public class Book {
	public String title;
	public String author;
	public String publisher;
	public Integer numPages;
	
	Book(String title, String author, String publisher, Integer numPages) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.numPages = numPages;
	}
	
	public void showInfo() {
		System.out.println("-----");
		System.out.println("Author: " + author);
		System.out.println("Title: " + title);
		System.out.println("Publisher: " + publisher);
	}
}
