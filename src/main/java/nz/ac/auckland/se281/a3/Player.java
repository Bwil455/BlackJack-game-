package nz.ac.auckland.se281.a3;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	private int wins = 0;
	private int loses = 0;
	private int netWins = 0;

	public abstract int makeABet();

	public Player(String name) {
		super(name);
	}

	/**
	 * Calculates the net wins of the players if called by subtracting loses from
	 * their wins
	 * 
	 * @return returns the integer value of the net wins
	 */
	public int getNetWins() {
		netWins = this.getWins() - this.loses;

		return netWins;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		// instead of setting the value as the value passed, it increments the value by
		// what ever is passed into the setter
		this.wins = this.wins + wins;
	}

	public int getLoses() {
		return loses;
	}

	public void setLoses(int loses) {

		// instead of setting the value as the value passed, it increments the value by
		// what ever is passed into the setter
		this.loses = this.loses + loses;
	}

}
