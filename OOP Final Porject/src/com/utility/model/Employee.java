package com.utility.model;

public class Employee extends Person {
    private double wage;
    private int hours;
    private double loans;
    private double allowance;
    private boolean sss, pagibig, philhealth;

    public Employee(String name, double wage, int hours, double loans,
                    double allowance, boolean sss, boolean pagibig, boolean philhealth) {
        super(name);
        this.wage = wage;
        this.hours = hours;
        this.loans = loans;
        this.allowance = allowance;
        this.sss = sss;
        this.pagibig = pagibig;
        this.philhealth = philhealth;
    }

    // encapsulated getters
    public double getWage() { return wage; }
    public int getHours() { return hours; }
    public double getLoans() { return loans; }
    public double getAllowance() { return allowance; }
    public boolean hasSSS() { return sss; }
    public boolean hasPagibig() { return pagibig; }
    public boolean hasPhilhealth() { return philhealth; }

    @Override
    public double computePay() {    // polymorphism
        return wage * hours;
    }
}
