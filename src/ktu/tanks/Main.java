package ktu.tanks;

import ktu.tanks.models.Player;
import ktu.tanks.net.HttpRequestSender;
import ktu.tanks.ui.MainWindow;
import ktu.tanks.ui.components.UserLoginDialog;

public class Main implements DialogCallback {

    private static UserLoginDialog loginDialog;

    public static void main(String[] args) {
        Main main = new Main();

        loginDialog = new UserLoginDialog(main);
        loginDialog.pack();
        loginDialog.setVisible(true);
    }

    @Override
    public void dialogConfirmed(String username, String address) {
        System.out.println("Parejo username: " + username);
        loginDialog.dispose();
        HttpRequestSender.host = String.format("http://%s", address);
        Player player = HttpRequestSender.login(username).orElseThrow(() -> new RuntimeException("Could not login"));

//        Player player = new Player(1, "generic", 100, 0, 0);

        new MainWindow(player);
    }

    @Override
    public void usernameCanceled() {
        System.out.println("Nepavyko suvesti");
        loginDialog.dispose();
    }

}
