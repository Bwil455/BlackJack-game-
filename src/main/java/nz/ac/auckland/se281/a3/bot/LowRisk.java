package nz.ac.auckland.se281.a3.bot;

import java.util.concurrent.ThreadLocalRandom;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * Sets the behaviours of associated with the LowRisk setting of the bots. This
 * Strategy causes the bot to bet less money, and hit at values further away
 * from 21.
 * 
 * @author Bradley
 *
 */
public class LowRisk implements BotRiskLevel {
	/**
	 * Sets the action that will be taken by the bot, as it is low risk, it will
	 * hold at values further from 21, and will only hit if their score is less than
	 * 17
	 * 
	 * @return the action that is to be taken by the bot
	 */
	public Action setActionRisk(Hand hand) {
		if (hand.getScore() >= 17) { // Compares their current score to decide if they should hold or hit and returns
										// that action
			return Action.HOLD;
		} else if (hand.getScore() < 17) {
			return Action.HIT;
		}

		return null;

	}

	/**
	 * Sets the bet number that the bots will select. Uses a random number between
	 * 10 and 50 and returns that number to be used
	 * 
	 * @return the bet amount that is to be used by the bot
	 */
	public int setBetRisk() {

		// these are the lower and upper bounds of the random number we want to generate
		int minBet = 10;
		int maxBet = 50;

		// Produces the random number and then returns the value to be used by the bot
		int betNum = ThreadLocalRandom.current().nextInt(minBet, maxBet + 1);

		return betNum;

	}

}
