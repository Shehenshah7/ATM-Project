package ATM_Project;

public class ATM {

	TransactionValidator tv = new TransactionValidator();
	public boolean authenticateUser(String accountNumber, int pin) {
		boolean a = false;
		for (int i = 0; i < Admin.count; i++) {

			if ((Admin.accounts[i].getAccNo().equals(accountNumber)) && (Admin.accounts[i].getPin()==pin)) {
				a = true;
				break;
			}

		}
		return a;

	}

	public void withdraw(double amount) {
		if(tv.isValidAmount(amount))
		{
			if(tv.hasSufficientBalance(Admin.accounts[Main.acI].getInitialBalance(), amount))
			{
				double bal = Admin.accounts[Main.acI].getInitialBalance()-amount;
				Admin.accounts[Main.acI].setInitialBalance(bal);
				System.out.println(ConsoleColors.GREEN+"*************** With draw Successful *************"+ConsoleColors.RESET);
			}
			else
			{
				System.out.println(ConsoleColors.RED+"!!! Insufficient funds !!!"+ConsoleColors.RESET);
			}
		}
		else
		{
			System.out.println(ConsoleColors.RED+"Entered Amount must be multiple of hundred"+ConsoleColors.RESET);
		}
		
	}
	public void deposit(double amount) {
		// Validate deposit conditions

		if (tv.isValidAmount(amount)) {
			double final_ = Admin.accounts[Main.acI].getInitialBalance() + amount;
			Admin.accounts[Main.acI].setInitialBalance(final_);
			System.out.println(ConsoleColors.GREEN+"********* Deposit Successful ************"+ConsoleColors.RESET);
		} 
		else {
			System.out.println(ConsoleColors.RED + "Entered Amount must be multiple of hundred"+ ConsoleColors.RESET);
		}
	}

	public double checkBalance() {
		
		return (Admin.accounts[Main.acI].getInitialBalance());
	}

}