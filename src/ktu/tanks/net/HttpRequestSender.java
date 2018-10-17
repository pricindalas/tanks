package ktu.tanks.net;

import com.fasterxml.jackson.databind.ObjectMapper;
import ktu.tanks.models.Player;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class HttpRequestSender {

    public static String host = "http://localhost:8000";

    public static Optional<Player> login(String username) {
        Player resultPlayer = postJson(Player.class, username, "login");
        return Optional.ofNullable(resultPlayer);
    }

    public static String post(String body, String action) {
        HttpURLConnection connection = null;
        String response = null;

        try {
            byte[] requestBody = body.getBytes();
            URL url = new URL(host + "/" + action);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-length", String.valueOf(requestBody.length));
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.getOutputStream().write(requestBody);
            connection.getOutputStream().close();

            if (connection.getResponseCode() == 200) {
                int size = Integer.parseInt(connection.getHeaderField("Content-Length"));
                byte[] responseBody = new byte[size];
                int bytesRead = connection.getInputStream().read(responseBody);
                connection.getInputStream().close();
                response = new String(responseBody, 0, bytesRead);
            } else {
                System.err.println(connection.getResponseCode() + " " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        return response;
    }

    public static <T> T postJson(Class<T> respsonseType, Object data, String action) {
        ObjectMapper mapper = new ObjectMapper();
        T response = null;

        try {
            String result;

            if (data instanceof String) {
                result = post((String) data, action);
            } else {
                String body = mapper.writeValueAsString(data);
                result = post(body, action);
            }

            response = mapper.readValue(result, respsonseType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

}
