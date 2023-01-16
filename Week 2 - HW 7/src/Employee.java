public class Employee {

    private String id;
    private String name;
    private double salary;

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


    public double getAnnualSalary() {
        return salary*12;
    }

    public double raisedSalary(double percent) throws Exception{
        // from -1 to positive infinity is valid
        if (percent >= -100 )
            return salary*=(1+(percent/100.0));
        else
            throw new Exception("You cannot lower that salary more than 100% please inter a number from -100 to positive infinity");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

}
