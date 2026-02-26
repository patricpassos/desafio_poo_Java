package entities;

public class TaxPayer {

	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}

	private double monthlySalary() {
		return salaryIncome / 12.0;
	}

	public boolean salaryTaxExempt() {
		return monthlySalary() < 3000.0;
	}

	public boolean salaryTax10() {
		return monthlySalary() < 5000.0;
	}

	public double salaryTax() {
		if (salaryTaxExempt()) {
			return 0.0;
		} else if (salaryTax10()) {
			return salaryIncome * 0.10;
		} else {
			return salaryIncome * 0.20;
		}
	}

	public double servicesTax() {
		return servicesIncome * 0.15;
	}

	public double capitalTax() {
		return capitalIncome * 0.20;
	}

	public double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public double taxRebate() {
		double deductibleExpenses = healthSpending + educationSpending;
		double deductibleTax = grossTax() * 0.30;
		return deductibleExpenses > deductibleTax ? deductibleTax : deductibleExpenses;
	}

	public double netTax() {
		return grossTax() - taxRebate();
	}

	@Override
	public String toString() {
		return "\nTotal gross tax: " + String.format("%.2f", grossTax()) + "\nTax abatement: "
				+ String.format("%.2f", taxRebate()) + "\nTax due: " + String.format("%.2f", netTax());
	}

}
