package com.scoreboard.cricket;

import java.util.HashMap;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {

	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		MatchProvider matchProvider = new MatchProvider();

		Match[] matches = matchProvider.retrieveMatches();
		HashMap<Integer, Match> matchMap = new HashMap<Integer, Match>();

		int i = 1;
		for (Match match : matches) {
			matchMap.put(i, match);
			System.out.println(i + ") " + match.getT1() + " vs "
					+ match.getT2());
			i++;
		}
		System.out.println("q) Quit");
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out
					.println("Please enter the number of the match you would like view: ");

			if (in.hasNextInt()) {
				int selection = in.nextInt();

				System.out.println("Retrieving match scorecard...");
				if (matchMap.containsKey(selection)) {
					Match match = matchProvider.retrieveMatch(matchMap.get(
							selection).getId());

					logger.debug("Output from GSON....");
					System.out.println(match.getId());
					System.out.println(match.getDe());
					System.out.println(match.getSi());
				} else {
					System.out.println("Invalid match number.");
				}
			} else {
				char c = in.next().charAt(0);
				logger.debug("Character read in from input was: " + c);
				if (c == 'q') {
					System.out.println("Quitting program.");
					break;
				} else {
					System.out.println("Invalid match number.");
				}
			}
		}
	}
}
