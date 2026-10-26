public class EmployeeTest {

    public static void main(String[] args) {

        Employee[] employee = {new SalariedEmployee("月薪人员",1001,2000),
                new SalesEmployee("销售员",1002,2000,10000,0.1),
                new HourlyEmployee("钟点工",1003,3000,50,15),
                new Employee("普通员工",1004,3000)};

        double totalSalary = 0;
        for(Employee e : employee){
            totalSalary += e.getSalary();
            System.out.println(e.getInfo() + " 工资：" + e.getSalary());
        }
        System.out.println("总工资：" + totalSalary);

        System.out.println();
        System.out.println("---------------------");
        for(Employee e : employee){
            printSalary(e);
        }
    }

    //Polymorphism
    static void printSalary(Employee e){
        System.out.println(e.getInfo() + " 工资：" + e.getSalary());
    }
}
