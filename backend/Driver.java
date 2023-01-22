import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Data data = new Data();
		int choiceInput = 0;
		int choiceInput2;
		String name;
		String garb;
		Scanner key = new Scanner(System.in);
		int p;
		Account n = new Account();

		String inter;
		double amo;
		double amon;

		int holdInd = 0;
		int m = 0;
		boolean on = true;

		System.out.println("Welcome to Accenture's Budgeting Software. Let there be change!");

		do {

			System.out.println("Please choose to login or sign-up: ");

			String input = key.next();

			int count = 0;

			on = true;

			if ((input.toLowerCase()).equals("login")) {

				while (on) {

					System.out.println("Please enter your username: ");

					String user = key.next();

					if (Data.nameIsRegistered(user)) {

						holdInd = Data.getInd(user);

						System.out.println("Enter Password: ");

						String password = key.next();

						if (Data.verifInd(holdInd, password)) {

							n = Data.getAcc(holdInd);

							on = false;

						} else {
							System.out.println("Invalid password. Please try again. ");

							count++;

							if (count == 5) {

								System.out.println(
										"No attempts remaining! Exiting system for security reasons. Have a great day!");

								System.exit(0);
							}
						}
					}
				}
			}

			if ((input.toLowerCase()).equals("sign-up")) {

				while (on) {

					System.out.println("Please enter an username");

					name = key.next();

					if (Data.nameIsRegistered(name)) {

						System.out.println("Sorry this username is taken.");

					} else {

						System.out.println("Username is valid.");

						while (on) {

							System.out.println("Please enter password (7 to 10 characters)");

							String passwordCreate = key.next();

							if ((passwordCreate.length() >= 7) && (passwordCreate.length() <= 10)) {

								n = new Account(name, passwordCreate);

								System.out.println("Password accepted!");

								System.out.println("Account successfully made!");

								on = false;

								Data.updateStatics(n);

								holdInd = Data.getInd(name);

							}

							System.out.println("Invalid password");

						}

					}

				}

			}

			do {
			System.out.println("What would you like to do?" + "\n  1. Edit|Set Budget" + "\n  2. View Budget Breakdown"
					+ "\n  3. View statistics" + "\n  4. Get tips" + "\n  5. Change login" + "\n  0. To quit");

			System.out.println("Please enter your choice and press <Enter>:");
			choiceInput = key.nextInt();

			switch (choiceInput) {

			case 1:
				p = 7;
				inner: do {

					System.out.println("What would you like to do?" + "\n  1. Edit budget"
							+ "\n  2. Edit interests | cost" + "\n  3. Edit needs | cost" + "\n  4. Edit money spending"
							+ "\n  5. Set budget amount and savings goal" + "\n  0. Exit current option");

					System.out.println("Please enter your choice and press <Enter>:");

					choiceInput2 = key.nextInt();

					switch (choiceInput2) {

					case 1:
						System.out.println("Please enter your savings target");
						amo = key.nextDouble();
						System.out.println("$" + amo + " has been updated as your savings target!");
						n.setsavingGoal(amo);
						Data.updateStatics(n);
						garb = key.nextLine();
						break;

					case 2:
						System.out.println("Please enter a given interest you're paying for!");
						inter = key.next();
						System.out.println("Please enter the amount that you're paying for it!");
						amo = key.nextDouble();
						n.addWants(inter, amo);
						Data.updateStatics(n);
						System.out.println("Interest " + inter + " at amount $" + amo + " has been added!");
						garb = key.nextLine();
						break;

					case 3:
						System.out.println("Please enter a given need you're paying for!");
						inter = key.next();
						System.out.println("Please enter the amount that you're paying for it!");
						amo = key.nextDouble();
						n.addNeeds(inter, amo);
						Data.updateStatics(n);
						System.out.println(inter + " at amount $" + amo + " has been added!");
						garb = key.nextLine();
						break;

					case 4:
						System.out.println("Please enter your budget amount");
						double bud = key.nextDouble();
						n.setBudget(bud);
						Data.updateStatics(n);
						System.out.println("Your budget now reads $" + n.getBudget());
						garb = key.nextLine();
						break;

					case 5:
						System.out.println("Please enter your budget amount");
						amo = key.nextDouble();
						System.out.println("Please enter your savings goal");
						amon = key.nextDouble();
						n.setBudgeAndSav(amo, amon);
						Data.updateStatics(n);
						System.out.println("Budget of $" + amo + " and saving goal of $" + amon + " has been added!");
						garb = key.nextLine();
						break;

					case 0:
						choiceInput2 = -1;
						choiceInput = 0;
						break inner;
					}
				} while (choiceInput2 >= 0);
				break;

			case 2:
				n.getBudgetBreakdown();
				break;

			case 3:
				break;

			case 4:
				if (n.getSavings() > 0) {
					System.out.println("Your savings is on track! Continue the good work!");
					break;
				}

				else {
					System.out.println("You're running short of your savings goal as it reads" + n.getSavings());
					break;
				}

			case 5:
				m = 5;
				break;

			case 0:
				choiceInput = 5;
				m = 0;
				break;

			}
		}
			while (choiceInput != 5);

		} while (m != 0);
		System.out.println("Thank you for using our services");

		key.close();

	}
}