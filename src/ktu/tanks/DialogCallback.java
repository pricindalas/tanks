package ktu.tanks;

public interface DialogCallback {
    void dialogConfirmed(String username, String host);
    void usernameCanceled();
}
