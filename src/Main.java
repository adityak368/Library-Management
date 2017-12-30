import java.util.Scanner;

public class Main {

	static void printMenu() {
		System.out.println("1. Add books to the system.");
		System.out.println("2. Add users to the system.");
		System.out.println("3. Lend books to users.");
		System.out.println("4. Return books to the library.");
		System.out.println("6. Search a book by Author.");
		System.out.println("6. Search a user by name");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		printMenu();
		
		BookManager bookManager = new BookManager();
		TransactionManager tranManager = new TransactionManager();
		UserManager userManager = new UserManager();
		
		Constants.OPTIONS option = Constants.OPTIONS.QUIT;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			if (scan.hasNextInt()) {
				if ((option = Constants.OPTIONS.values()[scan.nextInt()-1]) != Constants.OPTIONS.QUIT) {
					switch (option) {
					case ADDBOOK:
						scan.nextLine();
						System.out.println("Enter Name of the book");
						String name = scan.nextLine();
						System.out.println("Enter Author of the book");
						String author = scan.nextLine();
						Book b = new Book(name,author);
						bookManager.addBook(b);
						System.out.println("Successfully Added Book");
						break;
					case ADDUSER:
						scan.nextLine();
						System.out.println("Enter name of the user");
						String username = scan.nextLine();
						User u = new User(username);
						userManager.addUser(u);
						System.out.println("Successfully Added User");
						break;
					case LENDBOOK:
						scan.nextLine();
						System.out.println("Enter name of the book to lend");
						String lendbookname = scan.nextLine();
						System.out.println("Enter name of the user to lend");
						String lendname = scan.nextLine();
						User lenduser = userManager.getUser(lendname);
						Book lendbook = bookManager.getBookByName(lendbookname);
						if(lenduser!=null && lendbook!=null) {
							System.out.println(tranManager.lendBook(lendbook, lenduser));
						} else {
							System.out.println("User or Book was not Found");
						}
						break;
					case RETURNBOOK:
						scan.nextLine();
						System.out.println("Enter name of the book to return");
						String returnbookname = scan.nextLine();
						System.out.println("Enter name of the user to return");
						String returnname = scan.nextLine();
						User returnuser = userManager.getUser(returnname);
						Book returnbook = bookManager.getBookByName(returnbookname);
						if(returnuser!=null && returnbook!=null) {
							System.out.println(tranManager.returnBook(returnbook, returnuser));
						} else {
							System.out.println("User or Book was not Found");
						}
						break;
					case SEARCHBOOK:
						scan.nextLine();
						System.out.println("Enter author of the book to search");
						String searchbookname = scan.nextLine();
						Book searchedBook = bookManager.getBookByAuthor(searchbookname);
						if(searchedBook!=null)
							System.out.println(searchedBook);
						else
							System.out.println("Book Does Not Exists");
						break;
					case SEARCHUSER:
						scan.nextLine();
						System.out.println("Enter name of the user to search");
						String searchuser = scan.nextLine();
						User searchedUser = userManager.getUser(searchuser);
						if(searchedUser!=null)
							System.out.println(searchedUser);
						else
							System.out.println("User Does Not Exists");
						break;
					case QUIT:
						System.out.println("Bye!");
						System.exit(0);
						break;
					default:
						System.out.println("Unknown Option");
						break;
					}
					printMenu();
				} else {
					System.exit(0);
				}
		    } else {
		        System.out.println("Invalid Option!");
		        System.exit(0);
		    }
		}
		
	}

}
