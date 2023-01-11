import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] arr = {50, -20, 0, 30, 40, 60, 10};
        boolean isEqual = exercise1(arr);
        System.out.println(isEqual);

        ArrayList<Integer> numbersEx2 = new ArrayList<Integer>();
        fillArray(numbersEx2);
        exercise2(numbersEx2);

        ArrayList<Integer> numbersEx3 = new ArrayList<Integer>();
        fillArray(numbersEx3);
        exercise3(numbersEx3);

        ArrayList<Integer> numbersEx4 = new ArrayList<Integer>();
        fillArrayEx4AndEx5(numbersEx4);
        Integer largerValue = exercise4(numbersEx4);
        System.out.println("Larger value between first and last element: "+largerValue);

        ArrayList<Integer> numbersEx5 = new ArrayList<Integer>();
        fillArrayEx4AndEx5(numbersEx5);
        ArrayList<Integer> numbersEx5Swapped = exercise5(numbersEx5);
        System.out.println("New array after swapping the first and last elements: "+numbersEx5Swapped.toString());

        ArrayList<String> wordsEx6 = new ArrayList<String>();
        fillArrayEx6(wordsEx6);
        ArrayList<String> newNumbersEx6 = exercise6(wordsEx6);
        System.out.println("Result: "+newNumbersEx6.toString());

        exercise7();
        exercise8();
        exercise9();
        exercise10();
    }

    static Boolean exercise1(int[] arr){
        System.out.println("----------- Exercise 1 ----------------");

        if (arr.length < 2)
            return false;

        if (arr[0] == arr[arr.length-1])
            return true;
        else
            return false;
    }

    static void exercise2(ArrayList<Integer> numbers){
        System.out.println("----------- Exercise 2 ----------------");

        Collections.sort(numbers);
        System.out.println("3 largest elements of the said array are: ");
        System.out.print(numbers.get(numbers.size() - 1));
        System.out.print(" - ");
        System.out.print(numbers.get(numbers.size() - 2));
        System.out.print(" - ");
        System.out.print(numbers.get(numbers.size() - 3));
    }

    static void fillArray(ArrayList<Integer> numbers){
        numbers.add(1);
        numbers.add(4);
        numbers.add(17);
        numbers.add(7);
        numbers.add(25);
        numbers.add(3);
        numbers.add(100);
    }

    static void fillArrayEx4AndEx5(ArrayList<Integer> numbers){
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
    }
    static void fillArrayEx6(ArrayList<String> words){
        words.add("cat");
        words.add("dog");
        words.add("red");
        words.add("is");
        words.add("am");
    }
    static void exercise3(ArrayList<Integer> numbers){
        System.out.println("----------- Exercise 3 ----------------");

        double average = getAverage(numbers);
        ArrayList<Integer> largerThanAverage = new ArrayList<Integer>();

        for (Integer number : numbers)
            if (number > average)
                largerThanAverage.add(number);

        System.out.println("The average of the said array is: "+average+" The numbers in the said array that are greater than the average are: "+largerThanAverage.toString());
    }

    static double getAverage(ArrayList<Integer> numbers){
        Integer sum = 0;
        for (Integer number : numbers)
            sum += number;

        return sum/numbers.size();
    }

    static Integer exercise4(ArrayList<Integer> numbers){
        System.out.println("----------- Exercise 4 ----------------");

        return (numbers.get(0) > numbers.get(numbers.size()-1) ? numbers.get(0) : numbers.get(numbers.size() - 1));
    }

    static ArrayList<Integer> exercise5(ArrayList<Integer> numbers){
        System.out.println("----------- Exercise 5 ----------------");
        ArrayList newArray = new ArrayList<Integer>(numbers);

        Integer first = numbers.get(0);
        Integer last = numbers.get(numbers.size()-1);

        newArray.set(0,last);
        newArray.set(newArray.size() - 1, first);

        return newArray;
    }

    static ArrayList<String> exercise6(ArrayList<String> words){
        System.out.println("----------- Exercise 6 ----------------");

        int longestWord = 0;
        for (String word : words)
            if (word.length() > longestWord)
                longestWord = word.length();


        ArrayList<String> newWords = new ArrayList<String>();
        for (String word : words)
            if (word.length() == longestWord)
                newWords.add(word);

        return newWords;
    }

    static void exercise7(){
        System.out.println("----------- Exercise 7 ----------------");

        ArrayList<Integer> userNumbers = new ArrayList<Integer>();

        System.out.println("a. To Add Elements to the Array");
        System.out.println("b. Display elements of an array");
        System.out.println("c. Search the element within array");
        System.out.println("d. Sort the array");
        System.out.println("e. To exit");

        int choice = scanner.next().charAt(0);
        while (choice != 'e'){

            boolean exit = false;
            switch (choice){
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
                    System.out.println("Invalid input please choose from the menu.");
            }

            if (!exit){
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
    }

    static void choiceA(ArrayList<Integer> numbers){
        numbers.clear();
        System.out.println("Please enter the number of elements to be added");
        int size = scanner.nextInt();
        addToList(numbers, size);
    }

    static void choiceB(ArrayList<Integer> numbers){
        displayArray(numbers);
    }

    static void choiceC(ArrayList<Integer> numbers){
        System.out.print("Please enter integer that you want to search: ");
        int input = scanner.nextInt();

        if (numbers.contains(input)){
            System.out.println(numbers.get(numbers.indexOf(input))+" is at index["+numbers.indexOf(input)+"]");
        } else {
            System.out.println(input+" is not in the array");
        }
    }

    static void choiceD(ArrayList<Integer> numbers){
        Collections.sort(numbers);
        displayArray(numbers);
    }

    static void displayArray(ArrayList<Integer> numbers){
        System.out.println("Your list is: "+ numbers.toString());
    }
    static void addToList(ArrayList<Integer> numbers, int iterations){
        int element = -1;
        for (int i = 0; i < iterations; i++) {
            System.out.print("Please enter integer at index ["+i+"] to add: ");
            element = scanner.nextInt();
            numbers.add(element);
        }
        displayArray(numbers);
    }

    static void exercise8(){
        System.out.println("----------- Exercise 8 ----------------");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        fillArrayEx8(numbers);

        System.out.print("Please enter an integer you want to search for: ");
        int searchInput = scanner.nextInt();
        int occurrences = 0;

        for (Integer number : numbers)
            if (searchInput == number)
                occurrences++;

        // 3 occurs 2 times
        if (occurrences > 1)
            System.out.println(searchInput+" occurs "+ occurrences+" times");
         else
            System.out.println(searchInput+" occurs "+ occurrences+" time");
    }

    static void fillArrayEx8(ArrayList<Integer> numbers){
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(5);
    }

    static void exercise9(){
        System.out.println("----------- Exercise 9 ----------------");

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        fillArrayEx9(numbers);

        ArrayList<Integer> oddNumbers = new ArrayList<Integer>();
        ArrayList<Integer> eveNnumbers = new ArrayList<Integer>();

        for (Integer number : numbers) {
            if (number % 2 == 0)
                eveNnumbers.add(number);
            else
                oddNumbers.add(number);
        }
        numbers.clear();

        for (Integer oddNum : oddNumbers)
            numbers.add(oddNum);

        for (Integer evenNum : eveNnumbers)
            numbers.add(evenNum);

        System.out.println(numbers.toString());
    }


    static void fillArrayEx9(ArrayList<Integer> numbers){
        numbers.add(2);
        numbers.add(3);
        numbers.add(40);
        numbers.add(1);
        numbers.add(5);
        numbers.add(9);
        numbers.add(4);
        numbers.add(10);
        numbers.add(7);
    }

    static void exercise10(){
        System.out.println("----------- Exercise 10 ----------------");

        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

        fillArrayEx10(arr1);
        fillArrayEx10(arr2);

        System.out.println(Arrays.equals(arr1.toArray(),arr2.toArray()));
    }

    static void fillArrayEx10(ArrayList<Integer> numbers){
        numbers.add(2);
        numbers.add(3);
        numbers.add(6);
        numbers.add(6);
        numbers.add(14);
    }
}