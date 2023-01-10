import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
    }


    public static void exercise1(){
        System.out.println("------------- Exercise 1 ------------");
        System.out.println("Input first number: ");
        int number1 = scanner.nextInt();

        System.out.println("Input second number: ");
        int number2= scanner.nextInt();

        System.out.println(number1+" + "+ number2 +" = "+ (number1+number2));
        System.out.println(number1+" - "+ number2 +" = "+ (number1-number2));
        System.out.println(number1+" * "+ number2 +" = "+ (number1*number2));
        System.out.println(number1+" / "+ number2 +" = "+ (number1/number2));
        System.out.println(number1+" % "+ number2 +" = "+ (number1%number2));
    }

    public static void exercise2(){
        System.out.println("------------- Exercise 2 ------------");
        System.out.println("Input a String: ");
        String toBeLowercased = scanner.next();
        System.out.println(toBeLowercased.toLowerCase());

    }

    public static void exercise3(){
        System.out.println("------------- Exercise 3 ------------");
        System.out.println("Input a String: ");
        StringBuilder toBeReversed = new StringBuilder(scanner.next());
        System.out.println(toBeReversed.reverse());
    }

    public static void exercise4(){
        System.out.println("------------- Exercise 4 ------------");
        System.out.println("Skipped to day HW 3");
    }

    public static void exercise5(){
        System.out.println("------------- Exercise 5 ------------");
        System.out.println("Please enter your role: ");
        String role = scanner.next().toLowerCase();

        if (role.equals("admin"))
            System.out.println("welcome Admin");
        else if (role.equals("superuser"))
            System.out.println("welcome superuser");
        else if (role.equals("user"))
            System.out.println("welcome user");
        else
            System.out.println("invalid role");
    }

    public static void exercise6(){
        System.out.println("------------- Exercise 6 ------------");
        System.out.println("Input first number: ");
        int number1 = scanner.nextInt();

        System.out.println("Input second number: ");
        int number2= scanner.nextInt();

        System.out.println("Input third number: ");
        int number3= scanner.nextInt();

        String isEqual = (number1+number2) == number3 ? "true" : "false";
        System.out.println(isEqual);
    }

    public static void exercise7(){
        System.out.println("------------- Exercise 7 ------------");
        System.out.println("Input first number: ");
        int number1 = scanner.nextInt();

        System.out.println("Input second number: ");
        int number2= scanner.nextInt();

        System.out.println("Input third number: ");
        int number3= scanner.nextInt();

        int largest = number1>number2 ? number1 : number2;

        largest = largest>number3 ? largest : number3;

        System.out.println("The largest number is: "+ largest);
    }

    public static void exercise8(){
        System.out.println("------------- Exercise 8 ------------");
        System.out.println("Input number: ");
        int dayInNumber = scanner.nextInt();
        switch (dayInNumber){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("invalid input");
        }
    }
}