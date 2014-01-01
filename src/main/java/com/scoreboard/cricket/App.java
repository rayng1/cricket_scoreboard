package com.scoreboard.cricket;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 * 
 */
public class App {

	private static Logger logger = LoggerFactory.getLogger(App.class);
	
	private static final int REFRESH_INTERVAL = 5000;

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
		
		Timer timer = new Timer();
		
		while (true) {
			System.out
					.println("Please enter the number of the match you would like view: ");

			if (in.hasNextInt()) {
				int selection = in.nextInt();
				timer.cancel();
				System.out.println("Retrieving match scorecard...");
				if (matchMap.containsKey(selection)) {
					String selectedMatchId = matchMap.get(selection).getId();
					
					MatchDisplayTimerTask task = new MatchDisplayTimerTask();
					task.setMatchProvider(matchProvider);
					task.setMatchId(selectedMatchId);
					timer = new Timer();
					timer.schedule(task, 0, REFRESH_INTERVAL);

				} else {
					System.out.println("Invalid match number.");
				}
			} else {
				char c = in.next().charAt(0);
				logger.debug("Character read in from input was: " + c);
				if (c == 'q') {
					System.out.println("Quitting program.");
					timer.cancel();
					in.close();
					break;
				} else {
					System.out.println("Invalid match number.");
				}
			}
		}
	}

}
