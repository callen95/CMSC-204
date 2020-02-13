import java.util.ArrayList;

/**
 * This class prompts a user to create a password to be validated.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class PasswordCheckerUtility
{
	/**
	 * Returns true for valid passwords. Throws exceptions for invalid passwords.
	 * Valid if password is greater than or equal to six characters, has at least one
	 * uppercase alphabetic character, has at least one lowercase alphabetic
	 * character, and has no more than two of the same character in a sequence.
	 * @param pwdString The password in type String.
	 * @return True if the password is valid and false if the password is not valid.
	 * @throws LengthException if the password length is less than 6
	 * @throws NoUpperAlphaException if the password does not contain a uppercase alphabetic character
	 * @throws NoLowerAlphaException if the password does not contain a lowercase alphabetic character
	 * @throws NoDigitException if the password does not contain a digit
	 * @throws InvalidSequenceException if the password has characters repeated more than twice in sequence
	 */
	static boolean isValidPassword(String pwdString) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, InvalidSequenceException
	{
		if (pwdString.length() < 6)
			throw new LengthException();
		
		for (int i = 0; i < pwdString.length(); i++)
			if (pwdString.charAt(i) >= 48 && pwdString.charAt(i) <= 57)
				break;
			else
				if (i != pwdString.length() - 1)
					continue;
				else
					throw new NoDigitException();
		
		for (int i = 0; i < pwdString.length(); i++)
			if (pwdString.charAt(i) >= 65 && pwdString.charAt(i) <= 90)
				break;
			else
				if (i != pwdString.length() - 1)
					continue;
				else
					throw new NoUpperAlphaException();
		
		for (int i = 0; i < pwdString.length(); i++)
			if (pwdString.charAt(i) >= 97 && pwdString.charAt(i) <= 122)
				break;
			else
				if (i != pwdString.length() - 1)
					continue;
				else
					throw new NoLowerAlphaException();
		
		for (int i = 2; i < pwdString.length(); i++)
			if (pwdString.charAt(i) == pwdString.charAt(i - 1) && pwdString.charAt(i - 1) == pwdString.charAt(i - 2))
				throw new InvalidSequenceException();
		
		return true;
	}
	
	/**
	 * Returns true for password lengths greater than or equal to six but less than or equal to nine.
	 * @param pwdString The password in type String.
	 * @return True if the password is weak and false if the password is not weak.
	 */
	static boolean isWeakPassword(String pwdString)
	{
		if (pwdString.length() >= 6 && pwdString.length() <= 9)
			return true;
		
		return false;
	}
	
	/**
	 * Returns an ArrayList of invalid passwords (weak passwords are not considered invalid).
	 * @param passwords An ArrayList of passwords.
	 * @return Invalid passwords and their exception messages.
	 */
	static ArrayList<String> validPasswords(ArrayList<String> passwords)
	{
		ArrayList<String> invalidPwds = new ArrayList<>();
		
		for (int i = 0; i < passwords.size(); i++)
			try
			{
				isValidPassword(passwords.get(i));
			}
			catch (LengthException e)
			{
				invalidPwds.add(passwords.get(i) + " " + e.getMessage());
			}
			catch (NoDigitException e)
			{
				invalidPwds.add(passwords.get(i) + " " + e.getMessage());
			}
			catch (NoUpperAlphaException e)
			{
				invalidPwds.add(passwords.get(i) + " " + e.getMessage());
			}
			catch (NoLowerAlphaException e)
			{
				invalidPwds.add(passwords.get(i) + " " + e.getMessage());
			}
			catch (InvalidSequenceException e)
			{
				invalidPwds.add(passwords.get(i) + " " + e.getMessage());
			}
		
		return invalidPwds;
	}
}
