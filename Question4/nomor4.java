
public class nomor4 {
   public static 
   void main(String[] args) {
    product p1 = new MusicDVD("Baby be Mine", 1982, 50000, 4);
    product p2 = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
    product p3 = new Vinyl("Song of The Wind", 1967, 350000, 12);

    product[] products = {p1, p2, p3};
    for (product p : products){
        System.out.println(p.getDescription());
    }
   }
}
class product {
    protected String title;
    protected int releaseYear;
    protected double price;
    public product(String title, int releaseYear, double price){
        this.title = title;
        this.releaseYear = releaseYear;
        this.price = price;
    }
    public String getDescription(){
        return "Title: " + title +
                "\nRelease Year: " + releaseYear +
                "\nPrice: " + price;
    }
}
class MusicDVD extends product{
    private int runtime;
    public MusicDVD(String title, int releaseYear, double price, int runtime){
        super(title, releaseYear, price);
        this.runtime = runtime;
    }
    @Override
    public String getDescription(){
        return super.getDescription()+
        "\nRuntime: " + runtime + "minutes";
    }
}
class Magazine extends product{
    private String author;
    private int numPages;

    public Magazine(String title, int releaseYear, double price, String author, int numPages){
      super(title, releaseYear, price);
      this.author = author;
      this.numPages = numPages;
    
    }
     @Override
    public String getDescription(){
        return super.getDescription()+
        "\nAuthor: " + author +
        "\nPages: " + numPages;
    }
}
class Vinyl extends product{
    private int size;
    public Vinyl(String title, int releaseYear, double price, int size){
        super(title, releaseYear, price);
        this.size = size;
    }
    @Override
    public String getDescription(){
        return super.getDescription()+
        "\nSize: " + size + " inches";
    }
    
}