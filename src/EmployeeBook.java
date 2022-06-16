import java.util.Arrays;
import java.util.Collection;
import java.util.DoubleSummaryStatistics;

public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {

        this.employees = new Employee[10];
    }

    public void printSeparator() {
        System.out.println("=================================================");
    }

    public void printSeparator2() {
        System.out.println("-------------------------------------------------");
    }

    public void addEmployee(String fioEmployee, float salary, int department) {
        if (size >= employees.length) {
            System.out.println("The company does not need new employees");
        } else {
            Employee newEmployee = new Employee(fioEmployee, salary, department);
            employees[size++] = newEmployee;
            Employee.counter = size + 1;
        }
    }

    public void removeEmployee(String fioEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFio().equals(fioEmployee)) {
                employees[i] = null;
                if (i != employees.length - 1) {
                    System.arraycopy(employees, i + 1, employees, i, size - i);
                }
                size--;
                Employee.counter--;
                System.out.println("Employee " + fioEmployee + " is removed");
            }
        }
    }

    public void printAllEmployee() {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            System.out.println(employee.getFio() + ": " + employee.getDepartment() + " " + employee.getSalary());
        }
    }

    public float printSum() {
        float sum = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            sum += employee.getSalary();
        }
        System.out.println("Company expenses per month: " + sum);
        System.out.println("Company avg expenses per month: " + sum / employees.length);
        return sum;
    }

    public float minSalary() {
        float min = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (min >= employee.getSalary() || min == 0)
                min = employee.getSalary();
        }
        System.out.println("Min Salary: " + min);
        return min;
    }

    public float maxSalary() {
        float max = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (max <= employee.getSalary())
                max = employee.getSalary();
        }
        System.out.println("Max Salary: " + max);
        return max;
    }

    public void indexSalary(float indexPercent) {
        System.out.println("Salaries with indexation");
        printSeparator();
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            employee.setSalary(employee.getSalary() * indexPercent / 100 + employee.getSalary());
            System.out.println(employee.getFio() + ": " + employee.getDepartment() + " " + employee.getSalary());
        }
    }

    public void deportationOfficers() {
        for (int i = 1; i <= 5; i++) {
            float sumSalaryDep = 0;
            float maxSalaryDep = 0;
            float minSalaryDep = 0;
            int employeeDep = 0;
            System.out.println("Department: " + i);
            for (int j = 0; j < employees.length; j++) {
                Employee employee = employees[j];
                if (i == employee.getDepartment()) {
                    System.out.println(employee.id + " " + employee.getFio() + ": " + " " + employee.getSalary());
                    sumSalaryDep += employee.getSalary();
                    employeeDep += 1;
                    if (maxSalaryDep <= employee.getSalary())
                        maxSalaryDep = employee.getSalary();
                    if (minSalaryDep >= employee.getSalary() || minSalaryDep == 0)
                        minSalaryDep = employee.getSalary();
                }
            }
            printSeparator2();
            System.out.println("Department's salary: " + sumSalaryDep);
            System.out.println("Department's max salary: " + maxSalaryDep);
            System.out.println("Department's min salary: " + minSalaryDep);
            System.out.println("Department's avg salary: " + sumSalaryDep / employeeDep);
            printSeparator();
        }
    }
    public float minimumByValue(float minValue){
        System.out.println("Employees whose salary is less than: " + minValue);
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (minValue > employee.getSalary() || minValue == 0)
                System.out.println(employee.id + " " + employee.getFio() + " " + employee.getSalary());
        }
        return minValue;
    }

    public float maximumByValue(float maxValue){
        System.out.println("Employees whose salary of more than: " + maxValue);
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (maxValue <= employee.getSalary() || maxValue == 0)
                System.out.println(employee.id + " " + employee.getFio() + " " + employee.getSalary());
        }
        return maxValue;
    }

    public void toChangeSalary(String fio, float salary) {
        boolean toChange = false;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (fio == employee.getFio()) {
                employee.setSalary(salary);
                toChange = true;
            }

        }
        if (toChange)
            System.out.println("The salary change is successful by " + salary + " for the employee: " + fio);
        else
            System.out.println(fio + " - not found, the salary change is not successful");
    }

    public void toChangeDepartment(String fio, int department) {
        boolean toChange = false;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (fio == employee.getFio()) {
                employee.setDepartment(department);
                toChange = true;
            }

        }
        if (toChange)
            System.out.println("The department change is successful by " + department + " for the employee: " + fio);
        else
            System.out.println(fio + " - not found, the department change is not successful");

    }

    public int getSize(){

        return size;
    }
}
