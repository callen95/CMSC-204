import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests the methods of PasswordCheckerUtility.
 * @author Catherine Allen
 * @since February 12, 2020
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception {
		String[] pwds = {"12345", "123456", "12345A", "Abcdef", "1Abbbc", "1Abcde", "1Abbcdefgh"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(pwds));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than six characters long.
	 * This test should throw a LengthException for second the case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("1a2b3C4d5e"));
			PasswordCheckerUtility.isValidPassword("12345");
			assertTrue("Did not throw LengthException.", false);
		}
		catch(LengthException e)
		{
			assertTrue("Threw LengthException.", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw exception other than LengthException.", false);
		}
	}
	
	/**
	 * Test if the password has at least one upper case alpha character.
	 * This test should throw a NoUpperAlphaException for the second case.
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("xyz123ABC!"));
			PasswordCheckerUtility.isValidPassword("123456");
			assertTrue("Did not throw NoUpperAlphaException.", false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Threw NoUpperAlphaException.", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw exception other than NoUpperAlphaException.", false);
		}
	}
	
	/**
	 * Test if the password has at least one lower case alpha character.
	 * This test should throw a NoLowerAlphaException for the second case.
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("Str0ngP@ssw0rd"));
			PasswordCheckerUtility.isValidPassword("12345A");
			assertTrue("Did not throw NoLowerAlphaException.", false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Threw NoLowerAlphaException.", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw exception other than NoLowerAlphaException.", false);
		}
	}
	
	/**
	 * Test if the password is weak.
	 * This test should not throw an exception.
	 */
	@Test
	public void testIsWeakPassword()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isWeakPassword("1Abcde"));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Incorrectly threw exception.", false);
		}
	}
	
	/**
	 * Test if the password has more than two of the same character in sequence.
	 * This test should throw a InvalidSequenceException for the second case.
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("abcdE12345"));
			PasswordCheckerUtility.isValidPassword("1Abbbc");
			assertTrue("Did not throw InvalidSequenceException.", false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Threw InvalidSequenceException.", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw exception other than InvalidSequenceException.", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit.
	 * One test should throw a NoDigitException.
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try
		{
			assertTrue(PasswordCheckerUtility.isValidPassword("P@ssw0rdP@ss0rd"));
			PasswordCheckerUtility.isValidPassword("Abcdef");
			assertTrue("Did not throw NoDigitException.", false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Threw NoDigitException.", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw exception other than NoDigitException.", false);
		}
	}
	
	/**
	 * Test correct passwords.
	 * This test should not throw an exception.
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try
		{
			assertEquals(PasswordCheckerUtility.isValidPassword("1Abbcdefgh"), true);
			assertEquals(PasswordCheckerUtility.isValidPassword("123Aaabbcd"), true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Incorrectly threw exception.", false);
		}
	}
	
	/**
	 * Test the validPasswords method.
	 * Check the results of the ArrayList of Strings returned by the validPasswords method.
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.validPasswords(passwords);
		Scanner scan = new Scanner(results.get(0));
		assertEquals(scan.next(), "12345");
		String nextResults = scan.nextLine();
		assertTrue(nextResults.contains("long"));
		scan = new Scanner(results.get(1));
		assertEquals(scan.next(), "123456");
		nextResults = scan.nextLine();
		assertTrue(nextResults.contains("uppercase"));
		scan = new Scanner(results.get(2));
		assertEquals(scan.next(), "12345A");
		nextResults = scan.nextLine();
		assertTrue(nextResults.contains("lowercase"));
		scan = new Scanner(results.get(3));
		assertEquals(scan.next(), "Abcdef");
		nextResults = scan.nextLine();
		assertTrue(nextResults.contains("digit"));
		scan = new Scanner(results.get(4));
		assertEquals(scan.next(), "1Abbbc");
		nextResults = scan.nextLine();
		assertTrue(nextResults.contains("more than two"));
		scan = new Scanner(results.get(4));
	}
}
