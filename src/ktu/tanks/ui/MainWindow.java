package ktu.tanks.ui;

import ktu.tanks.Direction;
import ktu.tanks.GameTicker;
import ktu.tanks.PlayerControlManager;
import ktu.tanks.Tickable;
import ktu.tanks.decorators.NamedPlayerEntity;
import ktu.tanks.entities.HeavyTank;
import ktu.tanks.entities.PlayerEntity;
import ktu.tanks.entities.base.Entity;
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
    PlayerEntity playerEntity;
    Player player;

    private final Toolkit toolkit;

    public MainWindow(Player player) {
        this.player = player;
        this.toolkit = Toolkit.getDefaultToolkit();

        this.getContentPane().add(new JPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tankeliai");

        playerEntity = new PlayerEntity(player.getName(), getPlayerTank(player));
        playerEntity = new NamedPlayerEntity(playerEntity);

        gameView = new GameViewPanel(new ArrayList<>());

        gameView.getTanks().add(playerEntity);

        this.add(gameView);
        this.addWindowListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.pack();
        this.setVisible(true);

        gameTicker = new GameTicker(this, 20);
        networkTicker = new GameTicker(() -> {
            Player[] players  = HttpRequestSender.postJson(Player[].class, player, "update");

            List<PlayerEntity> gameTanks = gameView.getTanks();

            for (Player pl : players) {
                boolean exists = false;
                for (PlayerEntity plEntity : gameTanks) {
                    if (plEntity.getPlayerName().equals(pl.getName())) {
                        exists = true;
                        plEntity.getPlayerEntity().setX(pl.getPosX());
                        plEntity.getPlayerEntity().setY(pl.getPosY());
                        plEntity.getPlayerEntity().setDirection(pl.getDirection());
                    }
                }

                if (!exists) {
                    System.out.printf("Player %s joined.\n", pl.getName());
                    gameTanks.add(new NamedPlayerEntity(new PlayerEntity(pl.getName(), getPlayerTank(pl))));
                    //gameTanks.add(new Tank2(pl.getPosX(), pl.getPosY(), pl.getDirection(), 10, pl.getName(), pl.getHealth()));
                }
            }


            if (players.length + 1 < gameTanks.size()) {

                List<PlayerEntity> tanksToRemove = new ArrayList<>();

                for (PlayerEntity tank: gameTanks) {
                    boolean exists = false;
                    for (Player pl : players) {
                        if (pl.getName().equals(tank.getPlayerName())) {
                            exists = true;
                        }
                    }

                    if (!exists && !player.getName().equals(tank.getPlayerName())) {
                        tanksToRemove.add(tank);
                        System.out.printf("Player %s disconnected.\n", tank.getPlayerName());
                    }
                }

                for (PlayerEntity tank : tanksToRemove) {
                    gameTanks.remove(tank);
                }

            }

        }, 20);

        PlayerControlManager playerControlManager = new PlayerControlManager(this);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(playerControlManager);
    }

    @Override
    public void tick() {
        playerEntity.getPlayerEntity().tick();
        player.setPosX(playerEntity.getPlayerEntity().getX());
        player.setPosY(playerEntity.getPlayerEntity().getY());
        player.setDirection(playerEntity.getPlayerEntity().getDirection());

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
        playerEntity.getPlayerEntity().setDirection(direction);
        playerEntity.getPlayerEntity().setMoving(true);
    }

    @Override
    public void stopMoving() {
        playerEntity.getPlayerEntity().setMoving(false);
    }

    private Entity getPlayerTank(Player player) {
        HeavyTank tank = new HeavyTank();
        tank.setModel("HT");
        tank.setX(player.getPosX());
        tank.setY(player.getPosY());
        tank.setDirection(player.getDirection());
        tank.setHealth(player.getHealth());
        tank.setMovementSpeed(5);

        return tank;
    }
}
