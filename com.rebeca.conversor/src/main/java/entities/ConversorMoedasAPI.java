package entities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMoedasAPI {

	public static double getTaxa(String from, String to) throws Exception {
	    String apiKey = "3dfa8cdde7747b8f51305b04";
	    String urlStr = "https://api.exchangerate-api.com/v4/latest/" + from + "?access_key=" + apiKey + "&symbols=" + to;

	    URL url = new URL(urlStr);
	    HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    con.setRequestMethod("GET");

	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    StringBuilder content = new StringBuilder();
	    String inputLine;

	    while ((inputLine = in.readLine()) != null) {
	        content.append(inputLine);
	    }
	    in.close();
	    con.disconnect();

	    System.out.println("Resposta da API: " + content.toString());

	    JsonObject json = JsonParser.parseString(content.toString()).getAsJsonObject();

	 
	    if (json.has("success") && !json.get("success").getAsBoolean()) {
	        throw new Exception("Erro na API: " + json.getAsJsonObject("error").get("info").getAsString());
	    }

	    if (!json.has("rates")) {
	        throw new Exception("Campo 'rates' não encontrado na resposta da API.");
	    }

	    JsonObject rates = json.getAsJsonObject("rates");

	    if (!rates.has(to)) {
	        throw new Exception("Moeda de destino '" + to + "' não encontrada na resposta da API.");
	    }

	    return rates.get(to).getAsDouble();
	}

}
