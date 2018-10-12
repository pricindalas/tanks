package ktu.tanks.net;

import com.fasterxml.jackson.databind.ObjectMapper;
import ktu.tanks.models.Player;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class HttpRequestSender {

    private static final String host = "http://localhost:8000";

    public static Optional<Player> login(String username) {
        HttpURLConnection connection = null;
        Player resultPlayer = null;

        try {

            URL url = new URL(host + "/login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", String.valueOf(username.getBytes().length));
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.getOutputStream().write(username.getBytes());
            connection.getOutputStream().close();

            if (connection.getResponseCode() == 200) {
                int length = Integer.parseInt(connection.getHeaderField("Content-Length"));
                byte[] response = new byte[length];

                int size = connection.getInputStream().read(response);
                connection.getInputStream().close();

                String data = new String(response, 0, size);
                resultPlayer = new ObjectMapper().readValue(data, Player.class);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return Optional.ofNullable(resultPlayer);
    }

    public static <T> T post(Class<T> returnType, String body, String action) {

        ObjectMapper mapper = new ObjectMapper();

        HttpURLConnection connection = null;
        T response = null;

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
                response = mapper.readValue(responseBody, returnType);
            } else {
                throw new RuntimeException(connection.getResponseCode() + " " + connection.getResponseMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

        return response;
    }

}
