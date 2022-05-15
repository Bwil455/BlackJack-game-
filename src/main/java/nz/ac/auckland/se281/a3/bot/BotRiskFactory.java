package nz.ac.auckland.se281.a3.bot;

public class BotRiskFactory {

	/**
	 * createRiskAndBet creates instances of RandomRisk, LowRisk or HighRisk classes
	 * depending on the string passed into the method
	 * 
	 * @param riskLevel The risk level passed into the method is inputed by the user
	 *                  and can only be LR, HR or R
	 * @return Creates new instance depending on what string is passed into the
	 *         method
	 */
	public static BotRiskLevel createRiskAndBet(String riskLevel) {

		switch (riskLevel) {

		// if R is passed, creates new instance of RandomRisk
		case "R":
			return new RandomRisk();

		// if LR is passed, creates new instance of LowRisk
		case "LR":
			return new LowRisk();

		// if HR is passed, creates new instance of HighRisk
		case "HR":
			return new HighRisk();
		}
		return null;

	}

}
