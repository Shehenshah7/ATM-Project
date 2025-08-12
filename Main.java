package ATM_Project;

import java.util.*;

public class Main {

	public int count = 0;
	public static int acI;
	public static int acN;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Bank size:");
		int size = sc.nextInt();
		Admin ad = new Admin(size);
		ATM am = new ATM();

		while (true) {
			System.out.println(ConsoleColors.GREEN + "******** options ********" + ConsoleColors.RESET);
			System.out.println("1.Admin Users\n2.AccountHolders\n3.Exit\nChoose your Choice");
			int ch1 = sc.nextInt();
			switch (ch1) {
			case 1: {
				
				
				System.out.println("Enter pin :");
				int pin = sc.nextInt();

				if(ad.getAdminPin() == pin) {

					boolean running = true;
					while (running) {
						System.out.println(ConsoleColors.GREEN + "******** options ********" + ConsoleColors.RESET);
						System.out.println("1.View All Accounts\n2.Delete Account\n3.Exit\nEnter your Option");
						int choice = sc.nextInt();

						switch (choice) {
						case 1: {

							ad.viewAllAccounts();
							break;
						}
						case 2: {
							if(Admin.count > 0)
							{
								System.out.println("Enter Account Number:");
								String Acn = sc.next();
								ad.deleteAccount(Acn);
								break;
							}
							else
							{
								System.out.println(ConsoleColors.RED+"No Accounts to display"+ConsoleColors.RESET);
								break;
							}
						}

						case 3: {

							running = false;
							break;
						}
						default:
							System.out.println(ConsoleColors.YELLOW + "Enter valid option" + ConsoleColors.RESET);
							break;

						}
					}

				} else {
					System.out.println(ConsoleColors.RED + " !!!! Pin is Incorrect try again by executing again!!!!!"
							+ ConsoleColors.RESET);
				}

				break;

			}

			case 2: {
				boolean running = true;
				while (running) {
					System.out.println(ConsoleColors.GREEN + "******** options ********" + ConsoleColors.RESET);
					System.out.println("1.New User\n2.Existing User\n3.exit\nChoose option");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						ad.createAccount();
						break;
					}

					case 2: {

						if (Admin.count > 0) {

							System.out.println("Enter Account Number");
							String acn = sc.next();
							for (int i = 0; i < Admin.count; i++) {
								if (Admin.accounts[i].getAccNo().equals(acn)) {

									System.out.println("Enter Pin:");
									int pin = sc.nextInt();
									if (Admin.accounts[i].getPin() == pin ) {
										
										acI = i;

										boolean run = true;
										while (run) {
											System.out.println(ConsoleColors.GREEN + "******** options ********"
													+ ConsoleColors.RESET);
											System.out.println(
													"1.Withdraw\n2.Deposit\n3.Balance Inquiry\n4.Exit\nChoose your Option");
											int choice1 = sc.nextInt();

											switch (choice1) {
											case 1: {

												System.out.println("Enter amount to Withdraw");
												double amount = sc.nextDouble();
												am.withdraw(amount);
												break;
											}

											case 2: {
												System.out.println("Enter amount to Deposit");
												double amount = sc.nextDouble();
												am.deposit(amount);
												break;
											}
											case 3: {

												int an2 = (acn.length() / 2);
												String afn = acn.substring(0, an2);
												String afnr = afn.replaceAll(".", "x");
												String an22 = acn.substring(an2, acn.length());
												System.out.println("Your AccNo:" + ConsoleColors.GREEN + afnr + an22
														+ ConsoleColors.RESET);
												System.out.println("Your balance:" + am.checkBalance());
												break;

											}
											case 4: {
												run = false;
												break;
											}
											default:
												System.out.println(
														ConsoleColors.YELLOW + "Invalid option" + ConsoleColors.RESET);
												break;
											}
										}

									} else {
										System.out.println(ConsoleColors.RED + " Incorrect pin please run again" + ConsoleColors.RESET);
										//break;
										
										
									}

								} else {
									System.out.println(
											ConsoleColors.RED + "Invalid Account" + ConsoleColors.RESET);
									
								}

							}

						}
						else
						{
							System.out.println(ConsoleColors.RED+" No Accounts to Display"+ConsoleColors.RESET);
							
						}

						break;

					}

					case 3: {
						running = false;
						break;
					}
					default:
						System.out.println(ConsoleColors.YELLOW + "Invalid option" + ConsoleColors.RESET);
						break;
					}
				}
				
				
				break;

			}
			case 3: 
				System.out.println(ConsoleColors.GREEN+"*********  Thank you visit Again *************"+ConsoleColors.RESET);
				System.exit(00);
				break;
			default:
				System.out.println(ConsoleColors.YELLOW + "Enter a valid option" + ConsoleColors.RESET);
				break;
		}
	}
		

}
	

}