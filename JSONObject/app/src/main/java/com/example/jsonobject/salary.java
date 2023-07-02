package com.example.jsonobject;

public class salary {
    private float basicSalary;
    private  int coefficientsSalary;

    public salary(float basicSalary, int coefficientsSalary) {
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(int coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
}
