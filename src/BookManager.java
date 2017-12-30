import java.util.ArrayList;
import java.util.List;

public class BookManager {

	List<Book> bookList;
	
	BookManager() {
		bookList = new ArrayList<Book>();
	}
	
	void addBook(Book book) {
		this.bookList.add(book);
	}
	
	void removeBook(Book book) {
		this.bookList.remove(book);
	}
	
	List<Book> getAllBooks() {
		return this.bookList;
	}
	
	Book getBookByName(String name) {
		for(Book b : this.bookList) {
			if(b.getName().equals(name)) {
				return b;
			}
		}
		return null;
	}
	
	Book getBookByAuthor(String author) {
		for(Book b : this.bookList) {
			if(b.getAuthor().equals(author)) {
				return b;
			}
		}
		return null;
	}
}
