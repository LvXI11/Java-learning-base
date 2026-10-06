public class SalesEmployee extends Employee{
    private double saleAmount;//销售额
    private double commission;//提成比例

    public SalesEmployee(String name, int id, double baseSalary, double saleAmount, double commission) {
        super(name, id, baseSalary);
        this.saleAmount = saleAmount;
        this.commission = commission;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + saleAmount*commission;
    }
}
