package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class Bidder implements DealerBehaviour {

	public Bidder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action decideDealerAction(Hand hand) {
		return null;

	}

	@Override
	public Action decideDealerAction(Hand hand, List<Player> players) {

		Player currentTarget = players.get(0);
		int currentTargetBid = hand.getBet();

		for (int i = 1; i < players.size(); i++) {

			Player nextTarget = players.get(i);

		}

		return null;
	}

}
