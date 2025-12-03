package com.utility.service;

import com.utility.model.Employee;

public class PayrollService {

    public double normalPay(Employee e) {
        int limit = 176;
        if (e.getHours() <= limit) {
            return e.getHours() * e.getWage();
        } else {
            return limit * e.getWage();
        }
    }

    public double overtimePay(Employee e) {
        int limit = 176;
        if (e.getHours() > limit) {
            return (e.getHours() - limit) * e.getWage() * 1.5;
        } else {
            return 0;
        }

    }

    public double totalPay(Employee e) {
        return normalPay(e) + overtimePay(e);
    }

    public double deductions(Employee e) {
        double total = totalPay(e);
        double sss;
            if (e.hasSSS()) {
                sss = total * 0.045;
            } else {
                sss = 0;
            }

        double pagibig;
            if (e.hasPagibig()) {
                pagibig = total * 0.02;
            } else {
                pagibig = 0;
            }

        double philhealth;
            if (e.hasPhilhealth()) {
                philhealth = total * 0.05;
            } else {
                philhealth = 0;
            }

        double tax = total * 0.12;
        return sss + pagibig + philhealth + tax + e.getLoans();
    }

    public double net(Employee e) {
        return totalPay(e) - deductions(e) + e.getAllowance();
    }
}
