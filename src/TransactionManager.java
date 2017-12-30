import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {
	
	Map<User,List<Book>> transactions;
	
	public TransactionManager() {
		// TODO Auto-generated constructor stub
		transactions = new HashMap<>();
	}
	
	String lendBook(Book b, User u) {
		
		if(b.isLent()) {
			return "Book Already Lent To Another User!";
		}
		
		List<Book> lentBooksToTheUser = transactions.get(u);
		if(lentBooksToTheUser.size()==Constants.BOOKLIMIT) {
			return "Max Lending Limit Reached";
		} 
		
		if(lentBooksToTheUser.add(b)) {
			b.setLent(true);
			return "Book Lent To User";
		} else {
			return "Error Occurred While Lending!";
		}
		
	}
	
	String returnBook(Book b, User u) {
		List<Book> lentBooksToTheUser = transactions.get(u);
		
		if(lentBooksToTheUser.remove(b)) {
			b.setLent(false);
			return "Book Returned By User";
		} else {
			return "Error Occurred While Lending!";
		}
	}

	List<Book> getUsersLentBooks(User u) {
		return transactions.get(u);
	}
}
