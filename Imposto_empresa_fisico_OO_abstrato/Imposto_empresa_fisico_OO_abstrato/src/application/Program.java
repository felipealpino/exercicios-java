package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPlayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <TaxPlayer> list = new ArrayList<>();
		
		
		System.out.print("Enter the number of tax payers: ");
		int n  = sc.nextInt();
		
		for (int i=0; i<n; i++) {
			System.out.println("Tax payer #"+ (i+1)+" data:");
			System.out.print("Individual or company (i/c)? ");
			int ch = sc.next().charAt(0);
			sc.nextLine();
			
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Anual income: ");
			double annualIncome = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, annualIncome, healthExpenditures));
		
			} else {
				System.out.print("Number of employees: ");
				int numberEmployees = sc.nextInt();
				sc.nextLine();
				list.add(new Company(name, annualIncome, numberEmployees));
			}
		}
			System.out.println();
			System.out.println("TAXES PAID: ");
			double total = 0;
			for (int j=0; j<list.size(); j++) {
				System.out.println(list.get(j).getName()+": $ "+ String.format("%.2f",list.get(j).tax()));
				total += list.get(j).tax();
			}
			
			System.out.println("TOTAL TAXES: $ "+String.format("%.2f", total));
		
		
		
		
		sc.close();
	}

}
