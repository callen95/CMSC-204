/**
 * This class is an exception that is thrown when passwords contain more than two of the same character in sequence.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class InvalidSequenceException extends RuntimeException
{
	/**
	 * Default constructor.
	 */
	public InvalidSequenceException()
	{
		super("The password cannot contain more than two of the same character in sequence.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message The message to be shown when the exception is thrown.
	 */
	public InvalidSequenceException(String message)
	{
		super(message);
	}
}
