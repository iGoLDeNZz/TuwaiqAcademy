public class Main {
    public static void main(String[] args) {

        Square square = new Square(4,"red", true);
        System.out.println(square.toString());
        System.out.println("The area of the square is: "+square.getArea());
        System.out.println("The perimeter of the square is: "+square.getPerimeter());

        square.setSide(5);
        System.out.println(square.toString());
        System.out.println("The NEW area of the square is: "+square.getArea());
        System.out.println("The NEW perimeter of the square is: "+square.getPerimeter());





        Circle circle = new Circle("Blue",false, 1);
        System.out.println(circle.toString());
        System.out.println("The area of the circle is: "+circle.getArea());
        System.out.println("The perimeter of the circle is: "+circle.getPerimeter());

        circle.setRadius(2);
        System.out.println(circle.toString());
        System.out.println("The NEW area of the circle is: "+circle.getArea());
        System.out.println("The NEW perimeter of the circle is: "+circle.getPerimeter());
    }
}