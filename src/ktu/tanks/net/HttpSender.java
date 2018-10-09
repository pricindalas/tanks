package ktu.tanks.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpSender {

    public static int sendRequest(String address) {
        HttpURLConnection connection = null;
        int read = 0;

        try {
            URL url = new URL(address);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setDoOutput(false);
            connection.setDoInput(true);

            InputStream inputStream = connection.getInputStream();
            read = inputStream.read();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return read;
    }

}
