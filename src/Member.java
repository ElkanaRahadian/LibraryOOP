import java.util.Vector;

public class Member {
	public String nameMember;
	public int idMember;
	public static int memberIncrement;
	static Vector<Book> vecBook = new Vector<>();

	public Member(String nameMember) {
		this.idMember = ++memberIncrement;
		this.nameMember = nameMember;
	}

	public static Book bookChecking(int book) {
		for (int i = 0; i < vecBook.size(); i++) {
			Book newBook = vecBook.get(i);
			if (newBook.bookId == book) {
				return newBook;
			}
		}
		return null;
	}

	public void quotaValidation(Book newBook) {
		if (vecBook.size() > 3) {
			System.out.println("Maximum borrowing exceeded.");
		} else {
			vecBook.add(newBook);
		}
	}

	public static void returnBook(int book) {
		Book newBook = bookChecking(book);
		vecBook.remove(newBook);
	}
}
