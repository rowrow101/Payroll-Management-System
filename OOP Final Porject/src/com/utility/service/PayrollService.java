package com.utility.service;

import com.utility.model.Employee;

public class PayrollService {

    public double normalPay(Employee e) {
        int limit = 176;
        return e.getHours() <= limit ? e.getHours() * e.getWage() : limit * e.getWage();
    }

    public double overtimePay(Employee e) {
        int limit = 176;
        return e.getHours() > limit ? (e.getHours() - limit) * e.getWage() * 1.5 : 0;
    }

    public double totalPay(Employee e) {
        return normalPay(e) + overtimePay(e);
    }

    public double deductions(Employee e) {
        double total = totalPay(e);
        double sss = e.hasSSS() ? total * 0.045 : 0;
        double pagibig = e.hasPagibig() ? total * 0.02 : 0;
        double philhealth = e.hasPhilhealth() ? total * 0.05 : 0;
        double tax = total * 0.12;
        return sss + pagibig + philhealth + tax + e.getLoans();
    }

    public double net(Employee e) {
        return totalPay(e) - deductions(e) + e.getAllowance();
    }
}
