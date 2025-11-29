## PROJECT TITLE
##Payroll Management System

##DESCRIPTION/OVERVIEW

**The Payroll Management System** is a console-based Java application designed to automate and streamline the process of managing employee salary computations. It allows users to register employees, store their information, view and update employee records, and compute total salaries based on predefined rates and deductions. The system eliminates the need for manual calculations, reducing human error and improving efficiency in payroll processing. By providing a simple yet organized way to handle employee compensation, this system helps small businesses or school projects maintain accurate and reliable payroll records.

##OOP CONCEPTS APPLIED

This program uses basic Object Oriented Programming ideas to keep the payroll system organized. Encapsulation is shown in the Employee class which stores all information about an employee in one place, while the PayrollService class handles all payroll calculations. This also provides abstraction because the main program only calls simple methods like totalPay or net without needing to know how the formulas work.

The system follows the Single Responsibility Principle. The Employee class holds data, PayrollService does the computations, and the main class manages user interaction. This separation makes the program more modular, easier to maintain, and easier to update in the future. The methods in PayrollService are also reusable because they can work with any Employee object. Although the current version does not use inheritance or interfaces yet, these can be added later to support more advanced features.

##PROGRAM STRUCTURE

The program is divided into three main classes, each with a role. The Employee class (in com.utility.model) stores all employee information such as name, wage, hours, loans, allowance, sss, pagibig, and philhealth. The PayrollService class (in com.utility.service) handles all payroll calculations, including normal pay, overtime, total pay, deduction, and net salary. Finally, the PayrollManagementSystem class (in com.utility.main) serves as the console interface, reading user input, creating Employee objects, using PayrollService methods, and saving the results in a summary list. 


---

##HOW TO RUN THE PROGRAM

**Step 1:**
The program starts when you run java -cp out com.utility.main.PayrollManagementSystem, the main() method begins. A Scanner is created to read user input, and a PayrollService object is created to handle salary computations.

**Step 2:**
Menu is displayed. The program display the payroll menu containing three choices:
Compute Payroll
View Summary
Exit


It then waits for the user to input a number. This happens inside a while(true) loop so the menu continues to appear until the user chooses Exit.

**Step 3:**
If the user selects 1 (Compute Payroll) The program begins asking for employee information. It asks for:
-Employee name
-Wage per hour
-Total hours worked
-Loan deduction
-Allowance
-Y/N questions for SSS, PAG-IBIG
-PhilHealth


The ask() method processes the Y/N responses and converts them into boolean values.

**Step 4:**
An employee object is created. After gathering all inputs, the program creates a new Employee object using the information provided. This object is the one passed to PayrollService for salary calculations.

**Step 5:**
Normal pay and overtime pay are computed
-`normalPay()` checks if hours ≤ 176. If yes, all hours are normal pay. If more than 176, only the first 176 hours are counted as normal.
-`overtimePay()` calculates extra hours beyond 176 and multiplies them by 1.5 × wage.


**Step 6:**
Total pay and deductions
-`totalPay()` adds the normal pay and overtime pay.
-`deductions()` computes all deductions:
SSS = 4.5% of total pay (if selected)
PAG-IBIG = 2% (if selected)
PhilHealth = 5% (if selected)
Tax = 12% of total pay
Loans (as entered)
 All of these are added together to get the total deductions.


**Step 7:**
Net salary and record saving net() subtracts deductions from total pay and then adds the allowance. A text summary (Name, Normal Pay, Overtime, Total Pay, Deductions, Net Salary) is created and stored inside an ArrayList<String> called summary, so it can be viewed later.

**Step 8:**
If the user selects 2 (View Summary) The program prints all payroll records saved in the summary list. If the list is empty, it prints “No records.”

**Step 9:**
If the user selects 3 (Exit) The program prints “Thank you!” and exits the loop, ending the program.

**Step 10:**
Error handling while the program runs. If the user enters invalid input (for example, typing a letter instead of a number), the Exception block catches the error, prints “Invalid input! Please try again.”, clears the scanner buffer, and returns to the menu without crashing the program.

---

##SAMPLE OUTPUT
```
=== PAYROLL MENU ===
1. Compute Payroll
2. View Summary
3. Exit
Choice: 1
Employee Name: Juan Dela Cruz
Wage per hour: 120
Total hours worked: 180
Loan deduction: 500
Allowance: 1000 
Include SSS (Y/N): Y
Include PAG-IBIG (Y/N): N
Include PhilHealth (Y/N): Y

Payroll Added!


=== PAYROLL MENU ===
1. Compute Payroll
2. View Summary
3. Exit
Choice: 2

=== SUMMARY ===

Name: Juan Dela Cruz
Normal Pay: 21120.0
Overtime Pay: 720.0
Total Pay: 21840.0
Deductions: 5195.6
Net Salary: 17644.4
----------------

=== PAYROLL MENU ===
1. Compute Payroll
2. View Summary
3. Exit
Choice: 3
Thank you!
```

##AUTHOR AND ACKNOWLEDGE

##Authors:
-De Leon, Ronnick Ed P.
-dela Rosa, Art Jennel G.
-Lumanta, Ivan Yael D.

##Acknowledgements:
Instructor
Mentor
Friends
Students

##Other Sections you may include:
a. Future Enhancements
Adding persistent storage would allow employee records to be saved permanently. GUI interface could replace the console to make the program more user friendly. Input validation and error handling can be added to prevent invalid data. The system can also support multiple employees, with options to add, search, update, and delete records. 

b. References
https://www.youtube.com/watch?v=xk4_1vDrzzo


