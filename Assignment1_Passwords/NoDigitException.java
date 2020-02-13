/**
 * This class is an exception that is thrown when passwords do not contain at least one digit.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class NoDigitException extends RuntimeException
{
	/**
	 * Default constructor.
	 */
	public NoDigitException()
	{
		super("The password must contain at least one digit.");
	}

	/**
	 * Parameterized constructor.
	 * @param message The message to be shown when the exception is thrown.
	 */
	public NoDigitException(String message)
	{
		super(message);
	}
}
