public class Book {
	public String bookTitle;
	public int bookId;
	public static int increment;

	static {
		Book.increment = 0;
	}

	public Book(String title) {
		this.bookId = ++increment;
		this.bookTitle = title;
	}
}
