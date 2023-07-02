package com.example.jsonobject;

public class employees {
    private String firtName;
    private String lastName;
    salary salary;

    public employees(String firtName, String lastName, com.example.jsonobject.salary salary) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public com.example.jsonobject.salary getSalary() {
        return salary;
    }

    public void setSalary(com.example.jsonobject.salary salary) {
        this.salary = salary;
    }
}
