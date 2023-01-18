package Products;

public class Movie extends Product {

    private String director;

    public Movie() {
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public double getDiscount() {
        //10% discount
        setPrice(getPrice()*(1-0.1));
        return getPrice();
    }

    public void print(){
        System.out.println("-------- Movie info --------");
        System.out.println("The movie is: "+ this.getName()+". Price: "+ this.getPrice()+"$. \nBy: "+ this.getDirector());
        System.out.println();
        System.out.println("Price after 10% discount: "+this.getDiscount()+"$\n\n");
    }
}
