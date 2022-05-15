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

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

	public int getNetWins() {
		netWins = this.wins - this.loses;

		return netWins;
	}

}
