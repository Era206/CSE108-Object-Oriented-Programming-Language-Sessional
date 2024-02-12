package com.company;

public class Department {

    private int id;
    private String name;
    private Employee [] employees;
    private int employeeCount;
    // add your code here
    // there can be at most 20 departments
    private static Department department[] = new Department[20];
    private static int departmentCount = 0;

    // you are not allowed to write any other constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
        this.employees = new Employee[10];
        department[departmentCount++] = this;
        // add your code here
    }

    // add your code here
    public void addEmployee(Employee e){
        employees[employeeCount++] = e;
    }
    public double getDepartmentSalary(){
        double deptSalary = 0;
        for(int i =0; i < employeeCount; i++) {
            deptSalary += employees[i].getSalary();
        }
        return deptSalary;
    }
    public Employee getMaxSalaryEmployee(){
        Employee max = employees[0];
        for(int i =0; i < employeeCount; i++){
            if(employees[i].getSalary() > max.getSalary())
                max = employees[i];
        }
        return max;
    }
    public static double getTotalSalary(){
        double totalSalary = 0;
        for(int i = 0; i < departmentCount; i++){
            totalSalary += department[i].getDepartmentSalary();
        }
        return totalSalary;
    }
}
