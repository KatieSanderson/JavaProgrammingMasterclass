package Section20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Networking {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");
//            URL url = new URL("http://example.org/somepage.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(30000);

            int responseCode = connection.getResponseCode();
            System.out.println("Respones code : " + responseCode);

            if (responseCode != 200) {
                System.out.println("Error reading webpage");
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }

//            urlConnection.setDoOutput(true);
//            urlConnection.connect();
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("======>" + entry.getKey());
//                for (String string : value) {
//                    System.out.println("Value = " + string);
//                }
//            }
//            inputStream.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
