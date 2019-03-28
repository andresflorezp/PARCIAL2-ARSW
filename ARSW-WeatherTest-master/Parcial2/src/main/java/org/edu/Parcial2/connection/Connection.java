package org.edu.Parcial2.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class Connection {

	private static final String USER_AGENT = "Mozilla/5.0";
	private static String city;
	private static String openWeatherMapKey = "c5d0d45f9dc4e3bf488c0316e2ca2364";
	private static String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q=" + city
			+ "&APPID=c5d0d45f9dc4e3bf488c0316e2ca2364";

	public static String connection() throws IOException {

		URL obj = new URL(GET_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);

		// The following invocation perform the connection implicitly before getting the
		// code
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			return (response.toString());
		} else {
			System.out.println("GET request not worked");
		}
		return null;
	}

	public static void setCity(String c) {
		GET_URL = "http://api.openweathermap.org/data/2.5/weather?q=" + c + "&APPID=227fac8f36cb40ed1efe0aec04f2417b";

	}

}
