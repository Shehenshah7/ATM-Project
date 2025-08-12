package ATM_Project;

import java.util.*;
public class Account {
	
	Scanner sc = new Scanner(System.in);
	private String Username,Location,AccNo;
	private int pin;
	private double InitialBalance;
	
	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}




	public String getLocation() {
		return Location;
	}




	public void setLocation(String location) {
		Location = location;
	}




	public String getAccNo() {
		return AccNo;
	}


	public void setAccNo(String accNo) {
	    if (accNo.length() >= 8 && accNo.length() <= 12) {
	        boolean exists = false;

	        for (int i = 0; i < Admin.count; i++) {
	            if (Admin.accounts[i] != null &&
	                Admin.accounts[i].getAccNo() != null &&
	                Admin.accounts[i].getAccNo().equals(accNo)) {
	                exists = true;
	                break;
	            }
	        }

	        if (exists) {
	            System.out.println(ConsoleColors.RED + "Account Number already exists! Please enter another:" + ConsoleColors.RESET);
	            String acc1 = sc.next();
	            setAccNo(acc1); // Recursively check the new one
	        } else {
	            AccNo = accNo;
	            System.out.println("Account number set: " + AccNo);
	        }
	    } else {
	        System.out.println(ConsoleColors.RED + "Account number must be 8-12 digits! Please enter again:." + ConsoleColors.RESET);
//	        System.out.println(ConsoleColors.RED+"Enter account number again"+ConsoleColors.RESET);
	        String acn=sc.next();
	        setAccNo(acn);
	    }
	}

	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		if(String.valueOf(pin).length()==4)
		{
			this.pin=pin;
		}
		else
		{
			System.out.println(ConsoleColors.RED+"Pin size must be 4"+ConsoleColors.RESET);
			System.out.println("Enter pin again");
			int pin1 = sc.nextInt();
			this.pin = pin1;
		}
		
	}


	public double getInitialBalance() {
		return InitialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		
		boolean five=true;
		
		if(five)
		{
			if((initialBalance>=500)) {
				InitialBalance = initialBalance;
				five = false;
			}
			else {
				System.out.println(ConsoleColors.RED+"Initial Balanace must be greater than or equal 500 to deposit"+ConsoleColors.RESET);
				System.out.println("Enter again");
				Double initbal = sc.nextDouble();
				setInitialBalance(initbal);
//				InitialBalance = initialBalance;
			}
		}
		else
		{
			InitialBalance = initialBalance;
		}
		
	}
	


	public String toString()
	{
		return "Name:"+getUsername()+"\nLocation:"+getLocation()+"\nAccountNumber:"+getAccNo()+"\nPin:"+getPin()+"\nInitial Balance:"+getInitialBalance()+"\n";
	}
	

}