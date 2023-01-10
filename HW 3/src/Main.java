import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
        exercise9();
        exercise10();
    }

    public static void exercise1(){
        System.out.println("------------- Exercise 1 -------------");
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.print("FizzBuzz");
             else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
        }
    }

    public static void exercise2(){
        System.out.println("------------- Exercise 2 -------------");
        System.out.println("Input a string: ");
        String toBeReversed = scanner.next();
        String reversed = "";
        for (int i = 0; i < toBeReversed.length(); i++) {
            reversed = reversed + toBeReversed.charAt(toBeReversed.length()-1-i);
        }
        System.out.println(reversed);
    }

    public static void exercise3(){
        System.out.println("------------- Exercise 3 -------------");

        System.out.println("Input a positive number: ");
        int input = scanner.nextInt();

        while(input < 0){
            System.out.println("Invalid input!");
            System.out.println("Please enter a positive number");
            input = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println((i+1) +" * "+ input+" = "+ input*(i+1));
        }
    }

    public static void exercise4(){
        System.out.println("------------- Exercise 4 -------------");

        System.out.println("Input a number larger than 0: ");
        int input = scanner.nextInt();

        while(input < 1){
            System.out.println("Invalid input!");
            System.out.println("Please enter a positive number");
            input = scanner.nextInt();
        }

        int sum = 1;
        for (int i = 0; i < input; i++) {
            sum *= (i+1);
        }
        System.out.println("The factorial sum is: "+ sum);
    }

    public static void exercise5(){
        System.out.println("------------- Exercise 5 -------------");

        System.out.println("Input a number larger than 0: ");
        int number1 = scanner.nextInt();

        System.out.println("Input another number larger than 0: ");
        int number2 = scanner.nextInt();

        while(number1 < 1 || number2 < 1){
            System.out.println("Invalid input!");
            System.out.println("Input a number larger than 0: ");
            number1 = scanner.nextInt();

            System.out.println("Input another number larger than 0: ");
            number2 = scanner.nextInt();
        }

        int result = 1;
        for (int i = 0; i < number2; i++) {
            result *= number1;
        }
        System.out.println("The result: "+result);
    }

    public static void exercise6(){
        System.out.println("------------- Exercise 6 -------------");

        int sumOdd = 0;
        int sumEven = 0;

        System.out.print("Input a positive number and -1 to exit: ");
        int input = scanner.nextInt();
        while(input != -1){
            while(input < 0) {
                System.out.println("Invalid input!");
                System.out.println("Please enter a positive number");
                input = scanner.nextInt();
            }

            if (input % 2 == 0)
                sumEven += input;
            else
                sumOdd += input;

            System.out.print("Please enter another positive number or -1 to exit: ");
            input = scanner.nextInt();
        }

        System.out.println("Sum even numbers: "+sumEven);
        System.out.println("Sum odd numbers: "+sumOdd);
    }

    public static void exercise7(){
        System.out.println("------------- Exercise 7 -------------");


        System.out.print("Input a positive number: ");
        int input = scanner.nextInt();
        while(input < 0){
            System.out.println("Invalid input!");
            System.out.println("Please enter a positive number");
            input = scanner.nextInt();
        }

        boolean flag = false;
        for (int i = 2; i <= input / 2; ++i) {
            if (input % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(input + " is a prime number.");
        else
            System.out.println(input + " is not a prime number.");
    }

    public static void exercise8(){
        System.out.println("------------- Exercise 8 -------------");

        int countPositive = 0;
        int countNegative = 0;
        int countZero = 0;

        System.out.print("Input a number and -1 to exit: ");
        int input = scanner.nextInt();
        while(input != -1){
            if (input == 0)
                countZero++;
            else if (input > 0)
                countPositive++;
            else
                countNegative++;

            System.out.print("Please enter another number or -1 to exit: ");
            input = scanner.nextInt();
        }

        System.out.println("number of positives: "+countPositive);
        System.out.println("number of negatives: "+countNegative);
        System.out.println("number of zeros: "+countZero);
    }

    public static void exercise9() {
        System.out.println("------------- Exercise 9 -------------");

        for (int i = 0; i < 4; i++) {
            System.out.println("Week "+ (i+1));
            for (int j = 0; j < 7; j++) {
                System.out.println("Day "+ (j+1));
            }
        }
    }

    public static void exercise10(){
        System.out.println("------------- Exercise 10 -------------");

        System.out.print("Please input a string to check if palindrome: ");
        StringBuilder input = new StringBuilder(scanner.next());
        String reverse = input.reverse().toString();
        input.reverse(); //To get it back to original

        if (input.toString().equalsIgnoreCase(reverse))
            System.out.println("The string you entered ["+input+"] is palindrome.");
        else
            System.out.println("The string you entered ["+input+"] is not palindrome.");
    }



    }