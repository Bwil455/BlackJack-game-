package nz.ac.auckland.se281.a3.bot;

import java.util.concurrent.ThreadLocalRandom;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

/**
 * Sets the behaviours of associated with the Random setting of the bots. This
 * Strategy causes the bot to bet a completely random amount of chips, and
 * completely randomises the action that they will take in regards to holding or
 * hitting.
 * 
 * 
 * @author Bradley
 *
 */
public class RandomRisk implements BotRiskLevel {
	/**
	 * Sets the action that will be taken by the bot, as it is random, rng will be
	 * used to decide which action should be taken. Depending on the random number,
	 * either 0 or 1 it will return hold or hit respectively
	 * 
	 * @return the action that is to be taken by the bot
	 */
	@Override
	public Action setActionRisk(Hand hand) {

		// Creates a random number to be either 0 or 1.
		int randAction = ThreadLocalRandom.current().nextInt(0, 2);

		// Decides which action should be taken depending on the value of randAction
		if (randAction == 0) {
			return Action.HOLD;
		} else if (randAction == 1) {
			return Action.HIT;
		}

		return null;

	}

	/**
	 * Sets the bet number that the bots will select. Uses a random number between 1
	 * and 100 and returns that number to be used
	 * 
	 * @return the bet amount that is to be used by the bot
	 */
	@Override
	public int setBetRisk() {

		// Initialises the upper and lower bounds of the random number
		int minBet = 1;
		int maxBet = 100;

		// Creates random number and returns it to be used
		int betNum = ThreadLocalRandom.current().nextInt(minBet, maxBet + 1);

		return betNum;

	}

}
