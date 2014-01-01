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
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out
					.println("Please enter the number of the match you would like view: ");

			int selection = in.nextInt();

			System.out.println("Retrieving match scorecard...");
			Match match = matchProvider.retrieveMatch(matchMap.get(selection)
					.getId());

			logger.debug("Output from GSON....");
			System.out.println(match.getId());
			System.out.println(match.getDe());
			System.out.println(match.getSi());

		}
	}
}
