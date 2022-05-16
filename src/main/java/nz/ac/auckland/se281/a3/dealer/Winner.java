package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class Winner implements DealerBehaviour {

	public Winner() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action decideDealerAction(Hand hand, List<Player> players) {

		Player currentTarget = players.get(0);

		int mostWins = currentTarget.getNetWins();

		// Assess which player has the highest number of net wins and so becomes the
		// dealers target
		for (int i = 1; i < players.size(); i++) {
			Player nextTarget = players.get(i);
			int nextMostWins = nextTarget.getNetWins();

			if (nextMostWins > mostWins) {
				mostWins = nextMostWins;
				currentTarget = nextTarget;
			}
		}

		if (currentTarget.getHand().isBlackJack() && hand.getScore() < 17) {
			return Action.HIT;
		} else if (currentTarget.getHand().isBlackJack() && hand.getScore() > 17) {
			return Action.HOLD;
		} else if (currentTarget.getHand().getScore() > hand.getScore()) {
			return Action.HIT;
		} else if (currentTarget.getHand().getScore() < hand.getScore()) {
			return Action.HOLD;
		}

		return null;
	}

	@Override
	public Action decideDealerAction(Hand hand) {

		return null;
	}

}
