public class HourlyEmployee extends Employee{
    private double hours;//加班小时
    private double rate;//时薪

    public HourlyEmployee(String name, int id, double baseSalary, double hours, double rate) {
        super(name, id, baseSalary);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + hours*rate;
    }
}
