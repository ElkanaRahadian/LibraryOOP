public class MemberVIP extends Member {

	public int borrowQuota;

	public MemberVIP(String nameMember, int quotaBorrowing) {
		super(nameMember);
		this.borrowQuota = quotaBorrowing;
	}

	@Override
	public void quotaValidation(Book newBook) {
		if (vecBook.size() < this.borrowQuota) {
			vecBook.add(newBook);
			System.out.println("Book has already been borrowed");
		} else {
			System.out.println("Maximum borrowing exceeded.");
		}
	}
}
