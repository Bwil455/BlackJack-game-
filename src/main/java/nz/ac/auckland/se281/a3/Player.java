package nz.ac.auckland.se281.a3;

import nz.ac.auckland.se281.a3.bot.BotRiskLevel;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {

	BotRiskLevel risk;

	public Player(String name) {
		super(name);
	}

	public abstract int makeABet();

}
