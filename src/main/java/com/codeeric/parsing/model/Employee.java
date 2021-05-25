package com.codeeric.parsing.model;

/**
 * @ClassName: Employee this is where the CVS data to be assigned
 * @author: Enrique Tan
 * @date: May 25, 2021
 * @Description: This class will be accessed by ReadCSVWithScanner class but not the ParsingApplication class
 * @Remarks: this is barely the minimum, but I can put @entity or @repository for spring and jpa-hibernate implementation
 */
public class Employee {
    //Variable Declaration Section
    private int id;
    private String name;
    private String role;
    private float salary;

    public Employee(int id, String name, String role, float salary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.salary = salary;
    }

    public Employee() {
    }

    //Getter and Setter Section
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public float getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }


    //Setting field or column names of the CSV values
    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + id +
                ", Employee Name='" + name + '\'' +
                ", Employee Role='" + role + '\'' +
                ", Employee Salary='" + salary + '\'' +
                '}';
    }

}
