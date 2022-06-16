public class Main {
public static int id;
public static void printSeparator(){
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
}
    public static void main(String[] args) {
        EmployeeBook employeesBook = new EmployeeBook();
        employeesBook.addEmployee("Elijah Brandon Powell",100000,1);
        employeesBook.addEmployee("Connor Jake Mitchell",120000,2);
        employeesBook.addEmployee("Dylan Hunter Lopez",200000,3);
        employeesBook.addEmployee("Jayden Ashton Martin",130000,3);
        employeesBook.addEmployee("Sebastian Andrew Cook",90000,3);
        employeesBook.addEmployee("Leslie Autumn Adams",150000,4);
        employeesBook.addEmployee("Paige Abigail Barnes",120000,4);
        employeesBook.addEmployee("Isabella Madeline Ross",100000,1);
        employeesBook.addEmployee("Arianna Grace Sanders",135000,5);
        employeesBook.addEmployee("Caroline Arianna Flores",111000,5);
        printSeparator();
        employeesBook.printAllEmployee();
        printSeparator();
        employeesBook.indexSalary(20);
        printSeparator();
        employeesBook.deportationOfficers();
        printSeparator();
        employeesBook.printSum();
        employeesBook.minSalary();
        employeesBook.maxSalary();
        printSeparator();
        employeesBook.minimumByValue(100000);
        printSeparator();
        employeesBook.maximumByValue(150000);
        printSeparator();
        employeesBook.removeEmployee("Caroline Arianna Flores");
        employeesBook.addEmployee("Marvin Thomas",130000,2);
        printSeparator();
        employeesBook.toChangeSalary("Elijah Brandon Powell", 150000);
        employeesBook.toChangeDepartment("Connor Jake Mitchell", 1);
        employeesBook.toChangeDepartment("Ivanov Ivan Ivanovich", 1); // Employee not found
        printSeparator();
        employeesBook.printAllEmployee();

    }
}