package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Bill;

public class ProgramBar {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Bill bill = new Bill();

		System.out.print("Sexo: ");
		bill.gender = sc.next().charAt(0);
		System.out.print("Quantidade de cervejas: ");
		bill.beer = sc.nextInt();
		System.out.print("Quantidade de refrigerante: ");
		bill.softDrink = sc.nextInt();
		System.out.print("Quantidade de espetinhos: ");
		bill.barbecue = sc.nextInt();

		double consumo = bill.feeding();
		double couvert = bill.cover();
		double ingresso = bill.ticket();
		double totalGeral = bill.total();

		System.out.println("\nRELATÓRIO:");
		System.out.printf("Consumo = R$ %.2f\n", consumo);
		System.out.printf(couvert == 0.0 ? "Isento de Couvert\n" : "Couvert = R$ %.2f\n", couvert);
		System.out.printf("Ingresso = R$ %.2f\n", ingresso);
		System.out.printf("\nValor a pagar = R$ %.2f", totalGeral);

		sc.close();

	}

}
