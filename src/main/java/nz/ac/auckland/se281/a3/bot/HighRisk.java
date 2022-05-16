package nz.ac.auckland.se281.a3.bot;

import java.util.concurrent.ThreadLocalRandom;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * Sets the behaviours of associated with the HighRisk setting of the bots. This
 * Strategy causes the bots to bet more money, and hit at values closer to 21.
 * 
 * @author Bradley
 *
 */
public class HighRisk implements BotRiskLevel {
	/**
	 * Sets the action that will be taken by the bot, as it is high risk, it will
	 * hit at values closer to 21, and will only hold if their score is larger than
	 * 19
	 * 
	 * @param hand passes in the current hand of the bot
	 * @return the action that is to be taken by the bot
	 */
	@Override
	public Action setActionRisk(Hand hand) {

		if (hand.getScore() >= 19) { // Compares their current score to decide if they should hold or hit and returns
			return Action.HOLD; // that action
		} else if (hand.getScore() < 19) {
			return Action.HIT;
		}

		return null;

	}

	/**
	 * Sets the bet number that the bots will select. Uses a random number between
	 * 50 and 100 and returns that number to be used
	 * 
	 * @return the bet amount that is to be used by the bot
	 */
	@Override
	public int setBetRisk() {

		// Lower and upper bounds of the random number we wish to generate
		int minBet = 50;
		int maxBet = 100;

		// Creates the random number and returns it to be used by the bot
		int betNum = ThreadLocalRandom.current().nextInt(minBet, maxBet + 1);

		return betNum;

	}

}
