package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Sales;

public class salesAnalysis {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		//C:\Temp\bd_sale.csv
		System.out.print("Enter the file path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			List<Sales> listSales = new ArrayList<>();
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);
				Sales sale = new Sales(month, year, seller, items, total);
				listSales.add(sale);
				line = br.readLine();
			}
			
			Map<String, Double> totalSaller = listSales.stream()
					.collect(Collectors.groupingBy(x -> x.getSeller(), Collectors.summingDouble(y -> y.getTotal())));
					
			totalSaller.forEach((seller, total) -> System.out.println(seller + " - " + total));
			
			
		} catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
