package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

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

	Random rand;

	@Override
	public Action setActionRisk(Hand hand) {

		if (hand.getScore() >= 19) {
			return Action.HOLD;
		} else if (hand.getScore() < 19) {
			return Action.HIT;
		}

		return null;

	}

	@Override
	public int setBetRisk() {

		int minBet = 50;
		int maxBet = 100;

		int betNum = rand.nextInt((maxBet - minBet) + 1) + minBet;

		return betNum;

	}

}
