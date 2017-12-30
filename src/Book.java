
public class Book {

	
	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}
	
	private String name;
	private String author;
	private boolean isLent;
	
	public boolean isLent() {
		return isLent;
	}
	public void setLent(boolean isLent) {
		this.isLent = isLent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Book: " + this.getName() + " by " + this.getAuthor();
	}
	
}
