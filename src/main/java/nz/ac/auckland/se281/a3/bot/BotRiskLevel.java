package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotRiskLevel {

	public Action setActionRisk(Hand hand);

	public int setBetRisk();

}
