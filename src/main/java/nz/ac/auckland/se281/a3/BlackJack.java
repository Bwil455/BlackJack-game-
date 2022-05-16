package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.bot.BotRiskFactory;
import nz.ac.auckland.se281.a3.bot.BotRiskLevel;
import nz.ac.auckland.se281.a3.dealer.Dealer;

/**
 * Unless it is specified in the JavaDoc, you cannot change any methods.
 * 
 * You can add new methods and/or new instance fields
 */
public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;

	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
	}

	/**
	 * Thi constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * Gets the strategy desired by the user through an input, then uses that
	 * strategy to create the bots according to that strategy. The bots will then
	 * make decisions based on the risk level that was decided by the user
	 */
	protected void initBots() {

		// Strategy level form user is generated first
		String botStrategyString = getBotStrategy();

		// The strategy chosen is then used to create a new instance of that risk
		// level(low, high or random)
		BotRiskLevel riskStrat = BotRiskFactory.createRiskAndBet(botStrategyString);

		// Initialise the bots with their respective names, and then use the new
		// instance BotRiskLevel, to determine the action and bet behaviours
		Bot bot1 = new Bot("Bot1", riskStrat);
		Bot bot2 = new Bot("Bot2", riskStrat);

		players.add(bot1);
		players.add(bot2);

	}

	/**
	 * Creates a new instance of the dealer to be used in the BlackJack game
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		dealer = new Dealer("Dealer", players);

	}

	/**
	 * Determines how many players won in that particular round, and adjusts each
	 * players win, lose and net win stats
	 * 
	 * @return returns void as no values are needed, it is used to update variables
	 *         of the players
	 */
	protected void whoWonRound() {

		// for loop carries out the logic of checking whether each player has won, if
		// won it updates their win variable
		for (int i = 0; i < players.size(); i++) {

			if (players.get(i).getHand().isBlackJack() && !dealer.getHand().isBlackJack()) {
				players.get(i).setWins(1);
			} else if (players.get(i).getHand().getScore() > dealer.getHand().getScore()
					&& !players.get(i).getHand().isBust()) {
				players.get(i).setWins(1);
			} else if (dealer.getHand().isBust() && !players.get(i).getHand().isBust()) {
				players.get(i).setWins(1);
			} else {
				players.get(i).setLoses(1); // if none of the previous situation are triggered, the dealer has won,
											// therefore adjusts players loses variable
			}
		}

	}

	/**
	 * updates the wins and loses of each of the players. Then prints out updates
	 * after every rounds informing the user as to how many chips each player has
	 * lost
	 * 
	 * @param round the number of the round that is being played
	 */
	protected void printAndUpdateResults(int round) {

		// whoWonRound simply checks how many players have won in a round, how many have
		// lost and adjusts their wins and loses variables appropriately
		whoWonRound();

	}

	/**
	 * TODO This method should print the statistic of the game when it ends
	 */
	protected void printGameStatistics() {

	}

}
