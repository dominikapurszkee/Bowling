import java.util.LinkedList;
import java.util.List;

public class Round {

	private List<Integer> rolls = new LinkedList<Integer>();

	public int getRoll1() {
		return rolls.get(0);
	}

	Round next = null;

	public void setNext(Round next) {
		this.next = next;
	}

	public Round next() {
		return next;
	}

	public boolean hasNext() {
		return (next != null);
	}

	void setRoll(int pins) {

		rolls.add(pins);

	}

	public boolean isComplete() {
		if (rolls.size() == 2 || ((rolls.size() == 1) && (rolls.get(0) == 10)))
			return true;
		return false;
	}

	public int getRoundScore() {
		int result = 0;

		for (int i = 0; i < rolls.size(); i++) {
			result = result + rolls.get(i);
		}
		return result;
	}

}
