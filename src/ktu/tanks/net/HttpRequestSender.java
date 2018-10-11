package ktu.tanks.net;

import com.fasterxml.jackson.databind.ObjectMapper;
import ktu.tanks.models.Player;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class HttpRequestSender {

    private static final String host = "http://localhost:8000";

    public static Optional<Player> login(Player player) {
        HttpURLConnection connection = null;
        Player resultPlayer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String dataToSend = mapper.writeValueAsString(player);

            URL url = new URL(host + "/login");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", String.valueOf(dataToSend.getBytes().length));
            connection.setDoInput(true);
            connection.setDoOutput(true);

            connection.getOutputStream().write(dataToSend.getBytes());
            connection.getOutputStream().close();

            if (connection.getResponseCode() == 200) {
                byte[] response = new byte[1024];
                int size = connection.getInputStream().read(response);
                connection.getInputStream().close();

                String data = new String(response, 0, size);
                resultPlayer = mapper.readValue(data, Player.class);
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

}
