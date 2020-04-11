import java.util.*;

public class Main {

	int memberID = 0;
	int bookID = 0;
	int menuInput = 0;
	int quota = 0;
	String title = "";
	String memberName = "";
	String memberStatus = "";

	Vector<Book> vBook = new Vector<>();
	Vector<Member> vMember = new Vector<>();
	Scanner mainObj = new Scanner(System.in);

	public static void objectMain(Object mainObj) {
		System.out.println(mainObj);
	}

	public static void insertNewLine() {
		System.out.println("");
	}

	public void addBook() {
		do {
			System.out.print("Title [1-100]: ");
			title = mainObj.nextLine();
		} while (title.length() < 1 || title.length() > 100);
		vBook.add(new Book(title));
		System.out.println("Book added\n");
	}

	public void addMember() {
		do {
			System.out.print("Status [VIP/Regular]: ");
			memberStatus = mainObj.nextLine();
		} while (!(memberStatus.equals("VIP") || memberStatus.equals("Regular")));
		if (memberStatus.equals("Regular")) {
			do {
				System.out.print("Name [1-100]: ");
				memberName = mainObj.nextLine();
			} while (memberName.length() < 1 || memberName.length() > 100);

			vMember.add(new Member(memberName));
			System.out.println("Member added\n");
		} else if (memberStatus.equals("VIP")) {
			do {
				System.out.print("Name [1-100]: ");
				memberName = mainObj.nextLine();
			} while (memberName.length() < 1 || memberName.length() > 100);

			do {
				System.out.print("Quota [1-20]: ");
				quota = mainObj.nextInt();
				mainObj.nextLine();
			} while (quota < 1 || quota > 20);
			vMember.add(new MemberVIP(memberName, quota));
			System.out.println("Member added\n");
		}
	}

	public void borrowBook() {
		do {
			System.out.print("Member ID: ");
			memberID = mainObj.nextInt();
			mainObj.nextLine();
		} while (memberID < 1 || memberID > vMember.size());

		do {
			System.out.print("Book ID: ");
			bookID = mainObj.nextInt();
			mainObj.nextLine();
		} while (bookID < 1 || bookID > vBook.size());
		Member testMember = vMember.get(memberID - 1);
		if (Member.bookChecking(bookID) == null) {
			testMember.quotaValidation((Book) vBook.get(bookID - 1));
			System.out.println("Borrowing success.\n");
		} else {
			System.out.println("Book has already been borrowed.\n");
		}
	}

	public void returnBook() {
		do {
			System.out.print("Member ID: ");
			memberID = mainObj.nextInt();
			mainObj.nextLine();
		} while (memberID < 1 || memberID > vMember.size());
		do {
			System.out.print("Book ID: ");
			bookID = mainObj.nextInt();
			mainObj.nextLine();
		} while (bookID < 1 || bookID > vBook.size());
		if (Member.bookChecking(bookID).equals(0)) {
			System.out.println("Book has not been borrowed\n");
		} else {
			Member.returnBook(bookID);
			System.out.println("Book returned\n");
		}
	}

	public Main() {
		do {
			do {
				System.out.println("XYZ Library");
				System.out.println("======================\n");
				System.out.println("Members");
				System.out.println("=======");
				if (vMember.size() == 0) {
					System.out.println("Empty\n");
				} else {
					for (int i = 0; i < vMember.size(); i++) {
						Member newMember = vMember.get(i);
						System.out.print(newMember.idMember + "." + newMember.nameMember + " -- Borrowed books: \n");
						for (int j = 0; j < Member.vecBook.size(); j++) {
							Book newBook = Member.vecBook.get(j);
							System.out.print(newBook.bookId + ". " + newBook.bookTitle + "; \n");
						}						
					}
				}
				insertNewLine();
				System.out.println("Books");
				System.out.println("=====");
				if (vBook.size() == 0) {
					System.out.println("Empty\n");
				} else {
					for (int i = 0; i < vBook.size(); i++) {
						Book newBook = vBook.get(i);
						System.out.println(newBook.bookId + ". " + newBook.bookTitle);
					}
				}
				insertNewLine();
				System.out.println("1. Add Book");
				System.out.println("2. Add member");
				System.out.println("3. Borrow Book");
				System.out.println("4. Return Book");
				System.out.println("5. Exit");
				System.out.print("Input: ");
				menuInput = mainObj.nextInt();
				mainObj.nextLine();
			} while (menuInput < 1 || menuInput > 5);

			switch (menuInput) {
			case 1:
				addBook();
				break;
			case 2:
				addMember();
				break;
			case 3:
				borrowBook();
				break;
			case 4:
				returnBook();
				break;
			}
		} while (menuInput != 5);
	}

	public static void main(String[] args) {
		new Main();
	}
}
