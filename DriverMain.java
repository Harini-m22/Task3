package task3;

import java.util.Scanner;

// Taxable interface with salesTax and incomeTax constants and calcTax method
interface Taxable {
    double SALES_TAX = 0.07;
    double INCOME_TAX = 0.105;

    double calcTax();
}

// Employee class implementing Taxable to calculate income tax
class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        return salary * INCOME_TAX;
    }

    public String toString() {
        return "Employee ID: " + empId + ", Name: " + name + ", Salary: " + salary;
    }
}

// Product class implementing Taxable to calculate sales tax
class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * SALES_TAX;
    }

    public String toString() {
        return "Product ID: " + pid + ", Price: " + price + ", Quantity: " + quantity;
    }
}

// DriverMain class to accept employee and product information from the user
public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Employee details input
        System.out.println("Enter Employee ID: ");
        int empId = scanner.nextInt();
        System.out.println("Enter Employee Name: ");
        String name = scanner.next();
        System.out.println("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(empId, name, salary);
        System.out.println(emp);
        System.out.println("Income Tax: " + emp.calcTax());

        // Product details input
        System.out.println("Enter Product ID: ");
        int pid = scanner.nextInt();
        System.out.println("Enter Product Price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter Product Quantity: ");
        int quantity = scanner.nextInt();

        Product product = new Product(pid, price, quantity);
        System.out.println(product);
        System.out.println("Sales Tax per unit: " + product.calcTax());

        scanner.close();
    }
}

//OUTPUT
//        Enter Employee ID:
//        1
//        Enter Employee Name:
//        john
//        Enter Employee Salary:
//        2000
//        Employee ID: 1, Name: john, Salary: 2000.0
//        Income Tax: 210.0
//        Enter Product ID:
//        1
//        Enter Product Price:
//        200
//        Enter Product Quantity:
//        2
//        Product ID: 1, Price: 200.0, Quantity: 2
//        Sales Tax per unit: 14.000000000000002