package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

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

	Random rand;

	@Override
	public Action setActionRisk(Hand hand) {

		int randAction = rand.nextInt((1 - 0) + 1) + 1;

		if (randAction == 0) {
			return Action.HOLD;
		} else if (randAction == 1) {
			return Action.HIT;
		}

		return null;

	}

	@Override
	public int setBetRisk() {

		int minBet = 1;
		int maxBet = 100;

		int betNum = rand.nextInt((maxBet - minBet) + 1) + minBet;

		return betNum;

	}

}
