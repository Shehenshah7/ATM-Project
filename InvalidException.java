package ATM_Project;

public class InvalidException extends Exception {
	
	InvalidException(String message)
	{
		super(message);
		//System.out.println(ConsoleColors.RED+message+ConsoleColors.RESET);
	}
	
}