import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class BowlingGameTest {

	@Test
	public void testScoreThreeStrikes() throws BowlingException {
		// given

		BowlingGame bg = new BowlingGame(); // when

		bg.roll(10);
		bg.roll(10);
		bg.roll(10);

		int actual = bg.score();
		int expected = 60; // then
		assertEquals(expected, actual);

	}

	@Test
	public void testScoreFullGame() throws BowlingException {
		// given

		BowlingGame bg = new BowlingGame();
		// when

		bg.roll(10);

		bg.roll(9);
		bg.roll(1);

		bg.roll(5);
		bg.roll(5);

		bg.roll(7);
		bg.roll(2);

		bg.roll(10);

		bg.roll(10);

		bg.roll(10);

		bg.roll(9);
		bg.roll(0);

		bg.roll(8);
		bg.roll(2);

		bg.roll(9);
		bg.roll(1);

		bg.roll(10);

		int actual = bg.score();
		int expected = 187;
		// then
		assertEquals(expected, actual);

	}

	@Test(expected = BowlingException.class)
	public void testScoreTooMuchRolls() throws BowlingException {
		// given

		BowlingGame bg = new BowlingGame();
		// when

		bg.roll(10);

		bg.roll(9);
		bg.roll(1);

		bg.roll(5);
		bg.roll(5);

		bg.roll(7);
		bg.roll(2);

		bg.roll(10);

		bg.roll(10);

		bg.roll(10);

		bg.roll(9);
		bg.roll(0);

		bg.roll(8);
		bg.roll(2);

		bg.roll(9);
		bg.roll(1);

		bg.roll(2);
		bg.roll(1);

		// then
		fail("Game over");
	}

	@Test
	public void testIsFinished() throws BowlingException {
		// given

		BowlingGame bg = new BowlingGame();
		// when
		bg.roll(10);

		bg.roll(9);
		bg.roll(1);

		bg.roll(5);
		bg.roll(5);

		bg.roll(7);
		bg.roll(2);

		bg.roll(10);

		bg.roll(10);

		bg.roll(10);

		bg.roll(7);
		bg.roll(2);

		bg.roll(7);
		bg.roll(2);

		bg.roll(5);
		bg.roll(5);

		bg.roll(5);

		boolean actual = bg.isFinished();
		boolean expected = true;
		// then
		assertEquals(expected, actual);

	}

}
