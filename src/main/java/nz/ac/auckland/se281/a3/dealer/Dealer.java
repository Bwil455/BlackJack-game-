package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * You should change this class for Task 2
 * 
 * @param <Player>
 *
 */
public class Dealer extends Participant {

	protected List<Player> players;

	public Dealer(String name, List<Player> players) {
		super(name);
		this.players = players;

	}

	@SuppressWarnings("unused")
	@Override
	public Action decideAction(Hand hand) {

		DealerBehaviour winnerStrat = createWinnerStrat();
		DealerBehaviour bidderStrat = createBidderStrat();

		for (int i = 0; i < players.size(); i++) {

			Player currentPlayer = players.get(i);

			int wins = currentPlayer.getNetWins();

			if (wins >= 2) {
				return winnerStrat.decideDealerAction(hand, players);
			} else {
				return bidderStrat.decideDealerAction(hand, players);
			}
		}

		return null;

	}

	public DealerBehaviour createWinnerStrat() {

		return new Winner();
	}

	public DealerBehaviour createBidderStrat() {
		return new Bidder();
	}

}
