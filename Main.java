package com;

public class Main {

	public static void main(String[] args) {
		PayrollSystem payroll=new PayrollSystem();
		FullTimeEmployee emp1=new FullTimeEmployee("Niharika", 1, 25000.0);
		PartTimeEmployee emp2=new PartTimeEmployee("Teja",2,40,100);
		payroll.addEmployee(emp1);
		payroll.addEmployee(emp2);
		System.out.println("Initial EMployee Details:");
		payroll.displayEmployee();
		System.out.println("Removing Employees");
		payroll.removeEmployee(2);
		System.out.println("Remaining employee details");
		payroll.displayEmployee();

	}

}
