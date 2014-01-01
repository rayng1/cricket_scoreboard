package com.scoreboard.cricket;

import com.google.gson.Gson;

public class MatchProvider {

	private static final String ENDPOINT_URL = "http://cricscore-api.appspot.com/csa";
	private static final String MATCH_ID_PREFIX = "?id=";
	private static final String MATCH_DELIMITER = "+";

	private static final JsonClient jsonClient = new JsonClient();

	public Match[] retrieveMatches() {
		String url = ENDPOINT_URL;
		String output = jsonClient.retrieveJsonResponse(url);

		Gson gson = new Gson();
		Match[] matches = gson.fromJson(output, Match[].class);

		return matches;
	}

	public Match retrieveMatch(String matchId) {
		String url = ENDPOINT_URL + MATCH_ID_PREFIX + matchId;
		String output = jsonClient.retrieveJsonResponse(url);

		Gson gson = new Gson();
		Match[] matches = gson.fromJson(output, Match[].class);

		for (Match match : matches) {
			return match;
		}

		return null;
	}
}
