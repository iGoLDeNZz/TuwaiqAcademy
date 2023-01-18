import Products.Book;
import Products.Movie;
import Products.Product;

public class Main {
    public static void main(String[] args) {

        Book book = new Book("Clean Code", 100, "Uncle Bob");
        book.print();

        Movie movie = new Movie("Interstellar", 20, "Christofer Nolan");
        movie.print();


        Point p = new Point();
        p.setYSpeed(1);
        p.setXSpeed(1);
        test(p);

    }

    static void test(Point point){
        point.currentPosition();

        point.moveUp();
        point.currentPosition();

        point.moveDown();
        point.currentPosition();

        point.moveRight();
        point.currentPosition();

        point.moveLeft();
        point.currentPosition();
    }
}