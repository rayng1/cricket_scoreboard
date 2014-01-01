package com.scoreboard.cricket;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatchDisplayTimerTask extends TimerTask
{
	private static final Logger logger = LoggerFactory.getLogger(MatchDisplayTimerTask.class);
	
	private MatchProvider matchProvider;

	private String matchId;
	
	@Override
	public void run() {
		Match match = matchProvider.retrieveMatch(matchId);
		logger.debug("Output from GSON....");
		System.out.println(match.getId());
		System.out.println(match.getDe());
		System.out.println(match.getSi());
		System.out.println("Please enter the number of the match you would like view: ");
	}
	
	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}
	
	public MatchProvider getMatchProvider() {
		return matchProvider;
	}

	public void setMatchProvider(MatchProvider matchProvider) {
		this.matchProvider = matchProvider;
	}
}