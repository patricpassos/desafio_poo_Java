package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sale;

public class ProgramSalesAnalysis {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Sale> listSale = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);
				Sale sale = new Sale(month, year, seller, items, total);
				listSale.add(sale);
				line = br.readLine();
			}

			List<Sale> topFiveSales = listSale.stream()
					.filter(y -> y.getYear() == 2016)
					.sorted((av1, av2) -> av2.averagePrice().compareTo(av1.averagePrice()))
					.limit(5)
					.collect(Collectors.toList());

			System.out.println("Five top-selling items of 2016 with the highest average price");
			topFiveSales.forEach(System.out::println);

			double TotalSellerLogan = listSale.stream()
					.filter(m -> m.getMonth() == 1 || m.getMonth() == 7)
					.filter(s -> s.getSeller().equals("Logan"))
					.mapToDouble(t -> t.getTotal())
					.sum();
			System.out.println("\nTotal sales value of the Logan in months 1 and 7 = " + String.format("%.2f", TotalSellerLogan));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
