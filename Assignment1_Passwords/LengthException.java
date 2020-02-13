/**
 * This class is an exception that is thrown when passwords are not at least 6 characters long.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class LengthException extends RuntimeException
{
	/**
	 * Default constructor.
	 */
	public LengthException()
	{
		super("The password must be at least 6 characters long.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message The message to be shown when the exception is thrown.
	 */
	public LengthException(String message)
	{
		super(message);
	}
}
