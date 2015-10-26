
import java.util.LinkedList;
import java.util.List;

public class BowlingGame implements BowlingGameResultCalculator {

	private List<Round> rounds = new LinkedList<Round>();

	int getSize() {
		return rounds.size();
	}

	public void roll(int numberOfPins) throws BowlingException {

		if (isFinished()) {
			throw new BowlingException("Game over");
		} else if (rounds.isEmpty()) {
			Round temp = new Round();
			temp.setRoll(numberOfPins);
			rounds.add(temp);
		}

		else if (rounds.get(rounds.size() - 1).isComplete()) {
			Round temp = new Round();
			rounds.get(rounds.size() - 1).setNext(temp);
			temp.setRoll(numberOfPins);
			rounds.add(temp);
		}

		else {
			rounds.get(rounds.size() - 1).setRoll(numberOfPins);
		}
	}

	public int score() {

		int totalResult = 0;

		if (rounds.size() < 11) {
			for (int i = 0; i < rounds.size(); i++) {

				Round currentRound = rounds.get(i);
				totalResult = totalResult + currentRound.getRoundScore();
				int bonus = getBonus(currentRound);
				totalResult = totalResult + bonus;
			}
		} else {
			for (int i = 0; i < rounds.size() - 1; i++) {

				Round currentRound = rounds.get(i);
				totalResult = totalResult + currentRound.getRoundScore();
				int bonus = getBonus(currentRound);
				totalResult = totalResult + bonus;
			}

		}

		return totalResult;
	}

	public int getBonus(Round runda) {
		int result = 0;

		if (runda.hasNext()) {

			if (runda.getRoll1() == 10) {
				result = result + runda.next().getRoundScore();
				if ((runda.next().hasNext()) && (runda.next().getRoll1() == 10)) {
					result = result + runda.next().next().getRoll1();
				}
			}

			else if (runda.getRoundScore() == 10) {
				result = result + runda.next().getRoll1();
			}

		}
		return result;
	}

	@Override
	public boolean isFinished() {
		if ((rounds.size() < 11) || ((rounds.size() == 10) && (getBonus(rounds.get(rounds.size() - 1)) != 0))) {
			return false;
		} else
			return true;

	}

	public static void main(String[] args) throws BowlingException {
		BowlingGame bg = new BowlingGame();
		// when

		bg.roll(10);
		bg.roll(9);
		bg.roll(1);

		int actual = bg.score();

		System.out.println(actual);

	}

}
