/**
 * This class is an exception that is thrown when passwords do not contain at least one uppercase alphabetic character.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class NoUpperAlphaException extends RuntimeException
{
	/**
	 * Default constructor.
	 */
	public NoUpperAlphaException()
	{
		super("The password must contain at least one uppercase alphabetic character.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message The message to be shown when the exception is thrown.
	 */
	public NoUpperAlphaException(String message)
	{
		super(message);
	}
}
