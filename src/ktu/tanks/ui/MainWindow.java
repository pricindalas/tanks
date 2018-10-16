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
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame implements Tickable, WindowListener, PlayerControlManager.PlayerControlActionListener {

    private GameViewPanel gameView;
    private GameTicker gameTicker;
    private GameTicker networkTicker;
    private Tank playerTank;
    private Player player;

    private final Toolkit toolkit;

    public MainWindow(Player player) {
        this.player = player;
        this.toolkit = Toolkit.getDefaultToolkit();

        this.getContentPane().add(new JPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tankeliai");

        playerTank = new Tank(player.getPosX(), player.getPosY(), player.getDirection(), 4, player.getName(), player.getHealth());
        gameView = new GameViewPanel(new ArrayList<>());

        gameView.getTanks().add(playerTank);

        this.add(gameView);
        this.addWindowListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.pack();
        this.setVisible(true);

        gameTicker = new GameTicker(this, 20);
        networkTicker = new GameTicker(() -> {
            Player[] players  = HttpRequestSender.postJson(Player[].class, player, "update");

            List<Tank> gameTanks = gameView.getTanks();

            for (Player pl : players) {
                boolean exists = false;
                for (Tank tank : gameTanks) {
                    if (tank.getPlayerName().equals(pl.getName())) {
                        exists = true;
                        tank.setX(pl.getPosX());
                        tank.setY(pl.getPosY());
                        tank.setDirection(pl.getDirection());
                    }
                }

                if (!exists) {
                    gameTanks.add(new Tank(pl.getPosX(), pl.getPosY(), pl.getDirection(), 10, pl.getName(), pl.getHealth()));
                }
            }


            if (players.length + 1 < gameTanks.size()) {

                List<Tank> tanksToRemove = new ArrayList<>();

                for (Tank tank: gameTanks) {
                    boolean exists = false;
                    for (Player pl : players) {
                        if (pl.getName().equals(tank.getPlayerName())) {
                            exists = true;
                        }
                    }

                    if (!exists && !player.getName().equals(tank.getPlayerName())) {
                        tanksToRemove.add(tank);
                        System.out.printf("Player added %s", tank.getPlayerName());
                    }
                }

                for (Tank tank : tanksToRemove) {
                    gameTanks.remove(tank);
                }

            }

        }, 50);

        PlayerControlManager playerControlManager = new PlayerControlManager(this);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(playerControlManager);
    }

    @Override
    public void tick() {
        playerTank.tick();
        player.setPosX(playerTank.getX());
        player.setPosY(playerTank.getY());
        player.setDirection(playerTank.getDirection());

        SwingUtilities.invokeLater(() -> gameView.repaint());

        toolkit.sync();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        gameTicker.start();
        networkTicker.start();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        gameTicker.stop();
        networkTicker.stop();
        String response = HttpRequestSender.post(player.getName(), "logout");
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
