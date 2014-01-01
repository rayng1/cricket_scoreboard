package com.scoreboard.cricket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonClient {

	private static Logger logger = LoggerFactory.getLogger(JsonClient.class);
	
	public String retrieveJsonResponse(String endpointUrl) {

		String output = "";

		try {

			URL url = new URL(endpointUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String line;
			logger.debug("Output from Server....");
			while ((line = br.readLine()) != null) {
				logger.debug(line);
				output = output.concat(line);
			}

			conn.disconnect();
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return output;
	}
}
