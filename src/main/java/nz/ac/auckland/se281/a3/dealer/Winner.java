package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

/**
 * sets the behaviours of the dealer if if were to adopt the Highest Winner
 * strategy, in which the dealer aims to only beat the player with the highest
 * net wins
 * 
 * @author Bradley
 *
 */
public class Winner implements DealerBehaviour {

	public Winner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * decided on the action to be taken (Hit or Hold) if the highest winner
	 * strategy is to be used. confirms the cases in which a hit or a hold would be
	 * used and then returns that action
	 * 
	 * @param hand    passes in the hand of the dealer
	 * @param players a List of the current players
	 * @return the action to be taken by the dealer
	 */

	@Override
	public Action decideDealerAction(Hand hand, List<Player> players) {

		// gets the net wins of the first player and makes this the net wins/target
		// player
		Player currentTarget = players.get(0);
		int mostWins = currentTarget.getNetWins();

		// for loop compares each players net wins, updates the largest net wins/target
		// player if a
		// larger net wins is found
		for (int i = 1; i < players.size(); i++) {
			Player nextTarget = players.get(i);
			int nextMostWins = nextTarget.getNetWins();

			if (nextMostWins > mostWins) {
				mostWins = nextMostWins;
				currentTarget = nextTarget;
			}
		}

		// decided in which cases the dealer should hit or hold depending on the target
		// players hand and returns that action
		if (currentTarget.getHand().isBlackJack() && hand.getScore() < 17) {
			return Action.HIT;
		} else if (currentTarget.getHand().isBlackJack() && hand.getScore() > 17) {
			return Action.HOLD;
		} else if (currentTarget.getHand().getScore() > hand.getScore() && !currentTarget.getHand().isBust()) {
			return Action.HIT;
		} else if (currentTarget.getHand().getScore() <= hand.getScore()) {
			return Action.HOLD;
		} else if (currentTarget.getHand().isBust()) {
			return Action.HOLD;
		}

		return null;
	}

	@Override
	public Action decideDealerAction(Hand hand) {

		return null;
	}

}
