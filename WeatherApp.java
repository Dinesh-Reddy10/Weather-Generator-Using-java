import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter city name (e.g., Hyderabad or Hyderabad,IN): ");
        String city = sc.nextLine().trim();

        try {
            // read API key from environment variable
            String apiKey = System.getenv("OPENWEATHER_API_KEY");
            if (apiKey == null || apiKey.isEmpty()) {
                System.out.println("Error: OPENWEATHER_API_KEY is not set.");
                return;
            }

            String encodedCity = URLEncoder.encode(city, "UTF-8");
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q="
                    + encodedCity + "&appid=" + apiKey + "&units=metric";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            JsonObject json = new JsonParser().parse(response.toString()).getAsJsonObject();

            String name = json.get("name").getAsString();
            String country = json.getAsJsonObject("sys").get("country").getAsString();

            JsonObject main = json.getAsJsonObject("main");
            double temp = main.get("temp").getAsDouble();
            double feels = main.get("feels_like").getAsDouble();
            int humidity = main.get("humidity").getAsInt();

            JsonArray weatherArr = json.getAsJsonArray("weather");
            String description = weatherArr.size() > 0
                    ? weatherArr.get(0).getAsJsonObject().get("description").getAsString()
                    : "N/A";

            System.out.println("\n===== Current Weather =====");
            System.out.println("Location   : " + name + ", " + country);
            System.out.println("Condition  : " + description);
	    System.out.println("Temp       : " + temp + " \u00B0C (feels " + feels + " \u00B0C)");
            System.out.println("Humidity   : " + humidity + " %");

        } catch (Exception e) {
            System.out.println("Error fetching weather data: " + e.getMessage());
        }

        sc.close();
    }
}
