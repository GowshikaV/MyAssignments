package week2.day2;

public class Library {
	
	public String addBook(String bookTitle){
		System.out.println("Book added Successfully");
		System.out.println(bookTitle+" Book");
		return bookTitle;
		}
	public void issueBook() {
		System.out.println("Book issued successfully");
	}
	
	public static void main(String[] args) {
		Library addBook = new Library ();
		addBook.addBook("English");
		addBook.issueBook();
	}


}
