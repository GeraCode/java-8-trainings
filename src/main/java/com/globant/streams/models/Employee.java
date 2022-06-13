package com.globant.streams.models;

public class Employee{
    private final String name;
    private final String department;
    private final int salary;

    public Employee(String name, String department, int salary) {
      this.name = name;
      this.department = department;
      this.salary = salary;
    }

    public String getName() {
      return name;
    }

    public String getDepartment() {
      return department;
    }

    public int getSalary() {
      return salary;
    }

    @Override
    public String toString() {
      return "Employee{" +
          "name='" + name + '\'' +
          ", department='" + department + '\'' +
          ", salary=" + salary +
          '}';
    }
  }