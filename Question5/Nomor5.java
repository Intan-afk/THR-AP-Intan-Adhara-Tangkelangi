import java.util.*;
public class Nomor5 {
public static void main(String[] args) {
    Stack<Book> stack = new Stack<>();
    stack.push(new Book("Why Black Moves First", "Wesley So", 2025));
    stack.push(new GeneralBook("Inside Black Moves First", "Dr. Isaac Kleiner", 1997, "Documentary"));
    stack.push(new ChildrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));

    while(!stack.isEmpty()){
        Book b = stack.pop();
        b.getInfo();
    }
}

}
class Book {
    protected String title;
    protected String author;
    protected int year;
    public Book(String title, String author, int year){
        if (title.length() > 255){
            throw new IllegalArgumentException("Title must be under 255 characters");
        }
        if (author.length() >= 50){
            throw new IllegalArgumentException("Author must be under 50 characters");
        }
        if (year <= 1800 || year >= 2026){
            throw new IllegalArgumentException("Year must be between 1800 and 2026");
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public void getInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year of Publication: " + year);
    }
}
class GeneralBook extends Book{
    private String genre;
    public GeneralBook(String title, String author, int year, String genre){
        super(title, author, year);
        if (genre.length() > 30){
            throw new IllegalArgumentException("Genre max 30 characters");
        }
        this.genre = genre;
    }
    @Override
    public void getInfo(){
        super.getInfo();
        System.out.println("Genre: "+ genre);
        System.out.println();
    }
}
class ChildrenBook extends Book {
    private int minAge;
    private boolean hasVisualisation;
    public ChildrenBook(String title, String author, int year, int minAge, boolean hasVisualisation){
        super(title, author, year);
        if (minAge <= 3 || minAge >= 12){
            throw new IllegalArgumentException("Age must be between 3 and 12");
        }
        this.minAge = minAge;
        this.hasVisualisation = hasVisualisation;
    }
    @Override
    public void getInfo(){
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: "+ (hasVisualisation?"Yes":"No"));
        System.out.println();
    }
}
