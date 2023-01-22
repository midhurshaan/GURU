import java.util.Scanner;

public class Account {
	Scanner key = new Scanner(System.in);
	private double budget = 0.00; 
	public String name;
	private String password;
	boolean verif = false; 
	String[] wants = new String[0];
	double[] wantAmount = new double[0];
	String[] needs = new String[0];
	double[] needsAmount = new double[0]; 
	double savings = 0.00;
	double totalSpending = 0.00;
	private double savingGoal = 100;
	
	
	public void setsavingGoal(double sav) {
		savingGoal = sav;
	}
	
	public void setBudgeAndSav(double bud, double sav) {
		budget = bud;
		savingGoal = sav;
	}
	
	public Account() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String[] getWants() {
		return wants;
	}
	
	public void addWants(String w, double amount) {
		if (wants.length == 0) {    // When making the first account 
			wants = new String[1];
			wants[0] = w;
			wantAmount = new double[1];
			wantAmount[0] = amount;
			return;
		}
		String[] holder = new String[wants.length + 1]; 
		for (int i = 0; i < wants.length; i++) {
			holder[i] = wants[i];
		}
		holder[holder.length-1] = w;
		wants = holder.clone();
		
		double[] holder2 = new double[wantAmount.length + 1];
		for (int i = 0; i < wantAmount.length; i++) {
			holder2[i] = wantAmount[i];
		}
		holder2[holder2.length-1] = amount;
		wantAmount = holder2.clone();
		return;
	}
	
	public void showWants() {
		for (int i = 0; i < wants.length; i++) {
			System.out.println(wants[i] + "\n" + wantAmount[i] + "$");
		}
	}
	
	public void editWants(String w, double amount) {
		for (int i = 0; i < wants.length; i++) {
			if (w.equals(wants[i])){
				int ind = i;
				wantAmount[i] = amount;
			}
		}
	}
	// yuh
	public void addNeeds(String w, double amount) {
		if (needs.length == 0) {    // When making the first account 
			needs = new String[1];
			needs[0] = w;
			needsAmount = new double[1];
			needsAmount[0] = amount;
			return;
		}
		String[] holder = new String[needs.length + 1]; 
		for (int i = 0; i < needs.length; i++) {
			holder[i] = needs[i];
		}
		holder[holder.length-1] = w;
		needs = holder.clone();
		
		double[] holder2 = new double[needsAmount.length + 1];
		for (int i = 0; i < needsAmount.length; i++) {
			holder2[i] = needsAmount[i];
		}
		holder2[holder2.length-1] = amount;
		needsAmount = holder2.clone();
		return;
	}
	//yuh
	
	public void showNeeds() {
		for (int i = 0; i < needs.length; i++) {
			System.out.println(needs[i] + "\n" + needsAmount[i] + "$");
		}
	}
	
	public void editNeeds(String w, double amount) {
		for (int i = 0; i < needs.length; i++) {
			if (w.equals(needs[i])){
				int ind = i;
				needsAmount[i] = amount;
			}
		}
	}
	
	
	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public void calTotalSpending() {
		double t = 0;
		for (int i = 0; i < wantAmount.length; i++) {
			t += wantAmount[i];
		}
		
		for (int i = 0; i < needs.length; i++) {
			t += needsAmount[i];
		}
		totalSpending = t;
	}
	
	public double getTotal() {
		return totalSpending;
	}
	
	
	public void calSavings() {
		savings = (budget - totalSpending);
	}
	
	public double getSavings() {
		this.calSavings();
		return savings;
	}
	
	public void checkPassword() {
		System.out.println("Please enter your password: ");
		String tempPass = key.next();
		if (tempPass.equals(password)) {
			verif = true;
			System.out.println("Password accepted");
		}
	}
	
	public boolean checkPassword(String password) {
		if (this.password.equals(password))
			return true;
		return false; 
	}
	
	public void changePassword(String newPass) {
		if (verif == false) {
			System.out.println("Password not entered/correct");
			return;
		}
		this.password = newPass;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public void getBudgetBreakdown() {
		if (budget == 0) {
			System.out.println("You have no budget initialize, please set up your budget!");
			return;
		}
		
		System.out.println("Your current needs are:");
		this.showNeeds();
		System.out.println("Your current wants are:");
		this.showWants();
	}
}
