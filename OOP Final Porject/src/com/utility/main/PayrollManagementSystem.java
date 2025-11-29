package com.utility.main;

import com.utility.model.Employee;
import com.utility.service.PayrollService;
import java.util.ArrayList;
import java.util.Scanner;

public class PayrollManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PayrollService service = new PayrollService();
        ArrayList<String> summary = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n=== PAYROLL MENU ===");
                System.out.println("1. Compute Payroll");
                System.out.println("2. View Summary");
                System.out.println("3. Exit");
                System.out.print("Choice: ");

                int c = sc.nextInt();
                sc.nextLine();

                if (c == 1) {
                    System.out.print("Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Wage per hour: ");
                    double wage = sc.nextDouble();

                    System.out.print("Total hours worked: ");
                    int hours = sc.nextInt();

                    System.out.print("Loan deduction: ");
                    double loan = sc.nextDouble();

                    System.out.print("Allowance: ");
                    double allowance = sc.nextDouble();

                    boolean sss = ask(sc, "Include SSS (Y/N): ");
                    boolean pagibig = ask(sc, "Include PAG-IBIG (Y/N): ");
                    boolean philhealth = ask(sc, "Include PhilHealth (Y/N): ");

                    Employee e = new Employee(name, wage, hours, loan, allowance, sss, pagibig, philhealth);

                    double normal = service.normalPay(e);
                    double ot = service.overtimePay(e);
                    double total = service.totalPay(e);
                    double deduct = service.deductions(e);
                    double net = service.net(e);

                    String record =
                            "\nName: " + e.getName() +
                            "\nNormal Pay: " + normal +
                            "\nOvertime Pay: " + ot +
                            "\nTotal Pay: " + total +
                            "\nDeductions: " + deduct +
                            "\nNet Salary: " + net;

                    summary.add(record);
                    System.out.println("\nPayroll Added!\n");

                } else if (c == 2) {
                    System.out.println("\n=== SUMMARY ===");
                    if (summary.isEmpty())
                        System.out.println("No records.");
                    else
                        summary.forEach(r -> System.out.println(r + "\n----------------"));
                } else if (c == 3) {
                    System.out.println("Thank you!");
                    break;
                } else {
                    System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                sc.nextLine();
            }
        }
    }

    static boolean ask(Scanner sc, String msg) {
        System.out.print(msg);
        char c = sc.next().charAt(0);
        return c == 'Y' || c == 'y';
    }
}
