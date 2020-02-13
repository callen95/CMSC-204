/**
 * This class is an exception that is thrown when passwords do not match.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class UnmatchedException extends RuntimeException
{
	/**
	 * Default constructor.
	 */
	public UnmatchedException()
	{
		super("The passwords do not match.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message The message to be shown when the exception is thrown.
	 */
	public UnmatchedException(String message)
	{
		super(message);
	}
}
