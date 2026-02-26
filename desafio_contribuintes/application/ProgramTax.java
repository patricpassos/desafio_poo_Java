package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class ProgramTax {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> payer = new ArrayList<>();
		
		System.out.print("How many taxpayers will you enter? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("\nEnter the data for the %d° taxpayer:", i + 1);
			System.out.print("\nAnnual income from salary: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Annual income from service provision: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Annual income from capital gains: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Medical expenses: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Educational expenses: ");
			double educationSpending = sc.nextDouble();
			
			TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending,educationSpending);
			payer.add(taxPayer);
		}
		
		
		
		
		sc.close();

	}

}
