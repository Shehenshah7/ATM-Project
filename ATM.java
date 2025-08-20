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

	public void withdraw(double amount) throws InvalidException{
		if(tv.isValidAmount(amount))
		{
			if(tv.hasSufficientBalance(Admin.accounts[Main.acI].getInitialBalance(), amount))
			{
				double bal = Admin.accounts[Main.acI].getInitialBalance()-amount;
				Admin.accounts[Main.acI].setInitialBalance(bal);
				System.out.println(ConsoleColors.GREEN+"*************** Withdrawal Successfully *************"+ConsoleColors.RESET);

				
			}
			else {
				throw new InvalidException(ConsoleColors.BLUE+"Insufficient Funds"+ConsoleColors.RESET);
			}
		}
		else
			throw new InvalidException(ConsoleColors.BLUE+"Amount should  be greater than 0 and also multiple of 100"+ConsoleColors.RESET);
	}
	
	public void deposit(double amount) throws InvalidException{
		// Validate deposit conditions

		if (tv.isValidAmount(amount)) {
			double final_ = Admin.accounts[Main.acI].getInitialBalance() + amount;
			Admin.accounts[Main.acI].setInitialBalance(final_);
			System.out.println(ConsoleColors.GREEN+"********* Deposited Successfully ************"+ConsoleColors.RESET);
		} 
		else
			throw new InvalidException(ConsoleColors.BLUE+"Amount should not be less than or Equal to 0"+ConsoleColors.RESET);
	}

	public double checkBalance() {
		
		return (Admin.accounts[Main.acI].getInitialBalance());
	}

}