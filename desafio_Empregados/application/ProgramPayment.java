package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class ProgramPayment {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Department name: ");
		String departmentName = sc.nextLine();
		System.out.print("Payday: ");
		int payday = sc.nextInt();
		
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Telephone: ");
		String telephone = sc.next();
		
		Department department = new Department(departmentName, payday, new Address(email, telephone));
		
		System.out.print("How many employees does the department have? ");
		int quantityEmployees = sc.nextInt();
		
		for(int i = 0; i < quantityEmployees; i++) {
			sc.nextLine();
			System.out.printf("Employee data %d:\n", i + 1);
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			department.addEmployee(employee);
			
		}
		
		
		
		sc.close();

	}

}
