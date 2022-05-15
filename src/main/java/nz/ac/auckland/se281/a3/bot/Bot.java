package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	protected BotRiskLevel risk;

	/**
	 * Bot constructor the creates instances of the bot class
	 * 
	 * @param name - name given to the bot that is used during the game
	 * @param risk - risk strategy that is to be used by the bot to decide it's
	 *             action and bet amount
	 */
	public Bot(String name, BotRiskLevel risk) {
		super(name);
		this.risk = risk;
	}

	/**
	 * Decides the action of the bot. uses setActionRisk of the specific strategy
	 * that the bot is constructed with to decide its behaviours.
	 * 
	 * @return returns the result of the setActionRisk method of the specific risk
	 *         level of the bot
	 */
	@Override
	public Action decideAction(Hand hand) {

		return risk.setActionRisk(hand);
	}

	/**
	 * Decides the betting amount of the bot. uses setBetRisk of the specific
	 * strategy that the bot is constructed with to decide its behaviours.
	 * 
	 * @return the bet amount that is decided by the setBetRisk method of the
	 *         specific risk level of the bot
	 */
	@Override
	public int makeABet() {

		int betAmount = this.risk.setBetRisk();

		return betAmount;

	}

}
