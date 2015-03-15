package com.scoreboard.cricket;

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
		
		CommandLineInterface cmdLine = new CommandLineInterface();
		cmdLine.setMatchProvider(matchProvider);
		cmdLine.run();
		
		/*
		SwingInterface swing = new SwingInterface();
		swing.run(); */
	}

}
