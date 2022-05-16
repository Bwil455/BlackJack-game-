package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotRiskLevel {

	/**
	 * sets the risk associated with the actions that the bot will decide, either
	 * hit or hold
	 * 
	 * @param hand passes in the current hand of the bot
	 * @return returns the action that the bot will perform
	 */
	public Action setActionRisk(Hand hand);

	/**
	 * sets the risk level of the betting logic. Changes how much the bots will bet
	 * every round
	 * 
	 * @return returns the amount the bot has bet
	 */
	public int setBetRisk();

}
