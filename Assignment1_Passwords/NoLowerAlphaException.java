/**
 * This class is an exception that is thrown when passwords do not contain at least one lowercase alphabetic character.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class NoLowerAlphaException extends RuntimeException
{
	/**
	 * Default constructor.
	 */
	public NoLowerAlphaException()
	{
		super("The password must contain at least one lowercase alphabetic character.");
	}
	
	/**
	 * Parameterized constructor.
	 * @param message The message to be shown when the exception is thrown.
	 */
	public NoLowerAlphaException(String message)
	{
		super(message);
	}
}
