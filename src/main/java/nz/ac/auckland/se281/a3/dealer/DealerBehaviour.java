package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public interface DealerBehaviour {

	public Action decideDealerAction(Hand hand);

	public Action decideDealerAction(Hand hand, List<Player> players);

}
