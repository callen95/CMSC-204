import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	GradeBook a, b;

	@BeforeEach
	void setUp() throws Exception {
		a = new GradeBook(5);
		b = new GradeBook(5);
		a.addScore(90.0);
		a.addScore(97.1);
		a.addScore(99.9);
		a.addScore(80.0);
		a.addScore(50.0);
		b.addScore(95.5);
		b.addScore(70.0);
		b.addScore(70.0);
		b.addScore(89.5);
		b.addScore(100.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		a = b = null;
	}

	@Test
	void testAddScore() {
		assertTrue(a.toString().equals("90.0 97.1 99.9 80.0 50.0 "));
	}

	@Test
	void testSum() {
		assertEquals(417.0, a.sum(), .001);
	}

	@Test
	void testMinimum() {
		assertEquals(70.0, b.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		assertEquals(355, b.finalScore(), .001);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(5, a.getScoreSize());
	}

	@Test
	void testToString() {
		assertTrue(a.toString().equals("90.0 97.1 99.9 80.0 50.0 "));
	}

}
