package ATM_Project;

import java.util.*;

public class Admin {
	
	public static int count=0;
	Scanner sc = new Scanner(System.in);
	private int AdminPin=1234;
	public int size;
	public static Account[] accounts;
	
	
	public Admin(int size)
	{
		this.size=size;
		 accounts=new Account[this.size];
		
	}
	
	public int getAdminPin() {
		return AdminPin;
	}

	public void createAccount()
	{
		if(accounts.length>count)
		{
			Account acc = new Account();
			System.out.println("Enter Name:");
			String ac = sc.next();
			acc.setUsername(ac);
			
			System.out.println("Enter Location");
			String loc = sc.next();
			acc.setLocation(loc);
			
			System.out.println("Enter Account Number");
			String acN = sc.next();
			acc.setAccNo(acN);
			
			System.out.println("Enter Initial Blanace");
			double bal = sc.nextDouble();
			acc.setInitialBalance(bal);
			
			System.out.println("Enter Pin");
			int pin = sc.nextInt();
			acc.setPin(pin);
			
			accounts[this.count]=acc;
			this.count++;
			
			System.out.println(ConsoleColors.GREEN+"*********** Account Created Successfully ********"+ConsoleColors.RESET);
			
			System.out.println(ConsoleColors.BLUE+"<---------------Your Account Details are------------->"+ConsoleColors.RESET);
			
			System.out.println(acc);
		}
		else
		{
			System.out.println(ConsoleColors.RED+"Bank is full of users...!"+ConsoleColors.GREEN);
		}
	
	}

	public void setAdminPin(int adminPin) {
		if(String.valueOf(adminPin).length()==4)
			AdminPin = adminPin;
		else
			System.out.println(ConsoleColors.RED+"Admin pin must be the size of 4"+ConsoleColors.RESET);
	}
	
	public void viewAllAccounts()
	{
		if(count > 0)
		{
			for(int i=0;i<this.count;i++)
			{
				System.out.println(ConsoleColors.YELLOW+"<-------------- Account-"+(i+1)+"-------------------------------->"+ConsoleColors.RESET);
				System.out.println(accounts[i]);
				
			}
		}
		else
		{
			System.out.println(ConsoleColors.RED+"!!! No Accounts Added to display !!!"+ConsoleColors.RESET);
		}
	}

	public void deleteAccount(String AccountNumber)
	{
		//boolean nothere = true;
		for(int i=0;i<this.count;i++)
		{
			
			if(accounts[i].getAccNo().equals(AccountNumber))
			{
				for(int j=i;j<this.count-1;j++)
				{
					
					accounts[j]=accounts[j+1];
					//nothere=false;
					
					
				}
				this.count--;	
				System.out.println(ConsoleColors.GREEN+"Account Deleted successfully...!"+ConsoleColors.RESET);
			}
			else
			{
				System.out.println(ConsoleColors.RED+"There is no such type of Account number in my bank"+ConsoleColors.RESET);
				break;
			}
			
		}
		
		
	}


}