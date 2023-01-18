package Products;

public class Book extends Product {

    private String author;

    public Book() {
    }

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public double getDiscount() {
        //15% discount
        setPrice(getPrice()*(1-0.10));
        return getPrice();
    }

    public void print(){
        System.out.println("-------- Book info --------");
        System.out.println("The book is: "+ this.getName()+". Price: "+ this.getPrice()+"$. \nBy: "+ this.getAuthor());
        System.out.println();
        System.out.println("Price after 15% discount: "+this.getDiscount()+"$\n\n");
    }
}
