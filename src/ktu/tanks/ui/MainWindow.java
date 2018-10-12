package ktu.tanks.ui;

import ktu.tanks.Direction;
import ktu.tanks.GameTicker;
import ktu.tanks.PlayerControlManager;
import ktu.tanks.Tickable;
import ktu.tanks.models.Player;
import ktu.tanks.net.HttpRequestSender;
import ktu.tanks.ui.components.GameViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame implements Tickable, WindowListener, PlayerControlManager.PlayerControlActionListener {

    private GameViewPanel gameView;
    private GameTicker gameTicker;
    private Tank playerTank;
    private Player player;

    private final Toolkit toolkit;

    public MainWindow(Player player) {
        this.player = player;
        this.toolkit = Toolkit.getDefaultToolkit();

        this.getContentPane().add(new JPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tankeliai");

        playerTank = new Tank(0, 0, Direction.Down, 4);

        gameView = new GameViewPanel(playerTank);

        this.add(gameView);

        this.addWindowListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.pack();
        this.setVisible(true);

        gameTicker = new GameTicker(this, 20);

        PlayerControlManager playerControlManager = new PlayerControlManager(this);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(playerControlManager);
    }

    @Override
    public void tick() {
        playerTank.tick();

        SwingUtilities.invokeLater(() -> gameView.repaint());

        toolkit.sync();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        gameTicker.start();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        gameTicker.stop();
        //String response = HttpRequestSender.post(String.class, player.getName(), "logout");
    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {

    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }

    @Override
    public void startMoving(Direction direction) {
        playerTank.setDirection(direction);
        playerTank.setMoving(true);
    }

    @Override
    public void stopMoving() {
        playerTank.setMoving(false);
    }
}
