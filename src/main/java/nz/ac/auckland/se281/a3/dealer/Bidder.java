package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

/**
 * sets the behaviours of the dealer if if were to adopt the Highest Bidder
 * strategy, in which the dealer aims to only beat the player with the highest
 * bid made
 * 
 * @author Bradley
 *
 */
public class Bidder implements DealerBehaviour {

	public Bidder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action decideDealerAction(Hand hand) {
		return null;

	}

	/**
	 * decided on the action to be taken (Hit or Hold) if the highest bidder
	 * strategy is to be used. confirms the cases in which a hit or a hold would be
	 * used and then returns that action
	 * 
	 * @param hand    - hand of the dealer
	 * @param players a List of the current players
	 * @return the action to be taken by the dealer
	 */
	@Override
	public Action decideDealerAction(Hand hand, List<Player> players) {

		// gets the bet of the first player and makes this the largest bet/target player
		Player currentTarget = players.get(0);
		int currentTargetBid = players.get(0).getHand().getBet();

		// for loop compares each players bid, updates the target bid/target player if a
		// larger bid is found
		for (int i = 1; i < players.size(); i++) {

			// collects the next players bid to be compared to the current largest
			Player nextTarget = players.get(i);
			int nextTargetBid = players.get(i).getHand().getBet();

			// if a new largest bid is found, updates the currentTarget to the new bid value
			if (nextTargetBid > currentTargetBid) {
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

}
