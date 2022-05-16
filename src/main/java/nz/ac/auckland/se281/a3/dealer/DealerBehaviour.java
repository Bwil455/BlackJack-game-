package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public interface DealerBehaviour {

	/**
	 * decided the actions that the dealer will perform in response to the hands of
	 * the target player
	 * 
	 * @param hand passes in the hand of the dealer
	 * @return the action that dealer will perform
	 */
	public Action decideDealerAction(Hand hand);

	/**
	 * decided the actions that the dealer will perform in response to the hands of
	 * the target player
	 * 
	 * @param hand passes in the hand of the dealer
	 * @return the action that dealer will perform
	 */
	public Action decideDealerAction(Hand hand, List<Player> players);

}
