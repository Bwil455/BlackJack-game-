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

	private List<Player> players;

	public Dealer(String name, List<Player> players) {
		super(name);
		this.players = players;

	}

	/**
	 * Decides the dealers behaviour depending on largest number of net wins a
	 * player has. The default strategy of the dealer is highest Bidder or strategy
	 * dictated by bidderStrat. If the highest number of net wins reaches 2 or above
	 * it will switch onto Highest Winner strategy
	 * 
	 * @param hand hand of the dealer
	 * @return returns the decideDealerAction of the specific strategy
	 */
	@Override
	public Action decideAction(Hand hand) {

		// Creates an instance of each of the strategies to be called later
		DealerBehaviour winnerStrat = createWinnerStrat();
		DealerBehaviour bidderStrat = createBidderStrat();

		// finds the wins of the first player, used as a comparison to find the highest
		// number of net wins
		Player firstPlayer = players.get(0);
		int mostWins = firstPlayer.getNetWins();

		// for loop scans through the players List - comparing an updating the mostWins
		// variable
		for (int i = 0; i < players.size(); i++) {

			Player currentPlayer = players.get(i);

			int wins = currentPlayer.getNetWins();

			if (wins > mostWins) {
				mostWins = wins;
			}
		}

		// Decides which of the strategies should be used depending on what the highest
		// number of net wins is
		if (mostWins >= 2) {
			return winnerStrat.decideDealerAction(hand, players);
		} else {
			return bidderStrat.decideDealerAction(hand, players);
		}

	}

	/**
	 * creates an instance of the Winner Strategy to be used by the Dealer
	 * 
	 * @return the new instance of the Winner class
	 */
	public DealerBehaviour createWinnerStrat() {

		return new Winner();
	}

	/**
	 * creates an instance of the Bidder Strategy to be used by the Dealer
	 * 
	 * @return the new instance of the Bidder class
	 * 
	 */
	public DealerBehaviour createBidderStrat() {
		return new Bidder();
	}

}
