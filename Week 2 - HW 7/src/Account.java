public class Account {

    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) throws Exception{
        if (amount > 0)
            return this.balance += amount;
        else
            throw new Exception("You cannot deposit a negative amount!");
    }

    public int debit(int amount) throws Exception{
        if (hasAmount(amount))
            return this.balance -= amount;
        else
            throw new Exception("No sufficient balance!");
    }

    public int transferTo(Account account, int amount) throws Exception{
        if (hasAmount(amount)){
            account.credit(amount);
            return debit(amount);
        } else
            throw new Exception("No sufficient balance!");
    }

    private boolean hasAmount(int amount){
        return this.balance >= amount;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
