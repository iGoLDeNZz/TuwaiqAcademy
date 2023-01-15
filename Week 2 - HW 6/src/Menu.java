import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    static void exercise7WithException() {
        System.out.println("----------- Exercise 7 ----------------");

        ArrayList<Integer> userNumbers = new ArrayList<Integer>();

        System.out.println("a. To Add Elements to the Array");
        System.out.println("b. Display elements of an array");
        System.out.println("c. Search the element within array");
        System.out.println("d. Sort the array");
        System.out.println("e. To exit");

        try {
            int choice = scanner.next().charAt(0);
            while (choice != 'e') {

                boolean exit = false;
                switch (choice) {
                    case 'a':
                        choiceA(userNumbers);
                        break;
                    case 'b':
                        choiceB(userNumbers);
                        break;
                    case 'c':
                        choiceC(userNumbers);
                        break;
                    case 'd':
                        choiceD(userNumbers);
                        break;
                    case 'e':
                        exit = true;
                        break;
                    default:
                        throw new InputMismatchException("Invalid input please choose from the menu a letter (from a to e).");
                }

                if (!exit) {
                    System.out.println("a. To Add Elements to the Array");
                    System.out.println("b. Display elements of an array");
                    System.out.println("c. Search the element within array");
                    System.out.println("d. Sort the array");
                    System.out.println("e. To exit");
                    choice = scanner.next().charAt(0);
                }
            }

            System.out.println("Thank you for using Yousef's Application");
            displayArray(userNumbers);
        } catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scanner.next();
        } catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            scanner.next();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    static void choiceA(ArrayList<Integer> numbers) throws InputMismatchException, Exception {
        numbers.clear();
        System.out.println("Please enter the number of elements to be added");
        int size = scanner.nextInt();
        if (size <= 0){
            throw new Exception("Please enter a positive array size");
        }
        addToList(numbers, size);
    }

    static void choiceB(ArrayList<Integer> numbers){
        displayArray(numbers);
    }

    static void choiceC(ArrayList<Integer> numbers) throws Exception {
        System.out.print("Please enter integer that you want to search: ");
        int input = scanner.nextInt();

        if (numbers.contains(input)){
            System.out.println(numbers.get(numbers.indexOf(input))+" is at index["+numbers.indexOf(input)+"]");
        } else
            throw new Exception(input+" is not in the array");

    }

    static void choiceD(ArrayList<Integer> numbers){
        Collections.sort(numbers);
        displayArray(numbers);
    }

    static void displayArray(ArrayList<Integer> numbers){
        System.out.println("Your list is: "+ numbers.toString());
    }

    static void addToList(ArrayList<Integer> numbers, int iterations) throws InputMismatchException {
        int element = -1;
        for (int i = 0; i < iterations; i++) {
            System.out.print("Please enter integer at index ["+i+"] to add: ");
            element = scanner.nextInt();
            numbers.add(element);
        }
        displayArray(numbers);
    }
}
