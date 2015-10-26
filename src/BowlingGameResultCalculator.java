
public interface BowlingGameResultCalculator {
	public void roll(int numberOfPins) throws BowlingException;

	/**
	 * @return current game score
	 */
	public int score();

	/**
	 * @return true if a game is over, otherwise false
	 */
	public boolean isFinished();
}
