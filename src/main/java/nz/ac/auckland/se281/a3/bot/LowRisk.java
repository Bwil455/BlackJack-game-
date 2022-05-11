package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

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

	Random rand;

	@Override
	public Action setActionRisk(Hand hand) {
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		} else if (hand.getScore() < 17) {
			return Action.HIT;
		}

		return null;

	}

	@Override
	public int setBetRisk() {

		int minBet = 1;
		int maxBet = 50;

		int betNum = rand.nextInt((maxBet - minBet) + 1) + minBet;

		return betNum;

	}

}
