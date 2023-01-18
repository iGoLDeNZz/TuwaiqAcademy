import Products.Product;

public class Point implements Movable {

   private int x;
   private int y;
   private int xSpeed;
   private int ySpeed;


    public Point() {
        this.x = 0;
        this.y = 0;
        this.xSpeed = 0;
        this.ySpeed = 0;
    }

    public Point(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void setXSpeed(int speed) {
        this.xSpeed = speed;
    }

    @Override
    public void setYSpeed(int speed) {
        this.ySpeed = speed;
    }

    @Override
    public void moveUp() {
        System.out.println("Point has moved UP.");
        y+=ySpeed;
    }

    @Override
    public void moveDown() {
        System.out.println("Point has moved Down.");
        y-=ySpeed;
    }

    @Override
    public void moveRight() {
        System.out.println("Point has moved RIGHT.");
        x+=xSpeed;
    }

    @Override
    public void moveLeft() {
        System.out.println("Point has moved LEFT.");
        x-=xSpeed;
    }

    public void currentPosition(){
        System.out.println("Point current position: (x: "+x+",  y: "+y+")");
    }
}
