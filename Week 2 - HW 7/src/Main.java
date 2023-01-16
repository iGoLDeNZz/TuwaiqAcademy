import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Account acc1 = new Account("1", "Yousef", 1000);
        Account acc2 = new Account("2", "Saad", 200);

        Employee emp1 = new Employee("1","Yousef Almassad", 10000.0);

        System.out.println("Please enter an amount to credit/deposit from the account.");
        System.out.println("Current balance: "+acc1.getBalance());
        System.out.print("Amount to deposit/debit:");

        credit(acc1);

        System.out.println("Please enter an amount to withdraw/debit from the account: ");
        System.out.println("Current balance: "+acc1.getBalance());
        System.out.print("Amount to withdraw/debit:");

        debit(acc1);

        System.out.println("Please enter an amount to transfer from your account: ");
        System.out.println("Current balance: "+acc1.getBalance());
        System.out.print("Amount to transfer:");

        transfer(acc1,acc2);


        System.out.println("Please enter an amount to raise the employee: ");
        System.out.println("Current salary: "+emp1.getSalary());
        System.out.print("Amount to raise:");

        raise(emp1);

    }
    public static void debit(Account account){
        try {
            int amount = scanner.nextInt();
            int newBalance = testDebit(account, amount);
            if (newBalance != -1)
                System.out.println("new balance: "+ newBalance);
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number");
            scanner.next();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public static int testDebit(Account account, int amount){
        try {
            return account.debit(amount);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void credit(Account account){
        try {
            int amount = scanner.nextInt();
            int newBalance = testCredit(account, amount);
            if (newBalance != -1)
                System.out.println("new balance: "+ newBalance);
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number");
            scanner.next();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static int testCredit(Account account, int amount){
        try {
            return account.credit(amount);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void transfer(Account fromAccount, Account toAccount){
        try {
            int amount = scanner.nextInt();
            int newBalance = testTransfer(fromAccount, toAccount, amount);
            if (newBalance != -1)
                System.out.println("new balance: "+ newBalance);
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number");
            scanner.next();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static int testTransfer(Account fromAccount, Account toAccount, int amount){
        try {
            return fromAccount.transferTo(toAccount, amount);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    public static void raise(Employee employee){
        try {
            double percent = scanner.nextDouble();
            double newSalary = testRaise(employee, percent);
            if (newSalary != -1)
                System.out.println("new salary after raise: "+ newSalary);
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a number");
            scanner.next();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static double testRaise(Employee employee, double percent){
        try {
            return employee.raisedSalary(percent);
        } catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

}