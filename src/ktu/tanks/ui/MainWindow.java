package ktu.tanks.ui;

import ktu.tanks.Direction;
import ktu.tanks.GameTicker;
import ktu.tanks.PlayerControlManager;
import ktu.tanks.Tickable;
import ktu.tanks.adapters.PlayerAdapter;
import ktu.tanks.command.ControlInvoker;
import ktu.tanks.decorators.NamedPlayerEntity;
import ktu.tanks.entities.PlayerEntity;
import ktu.tanks.entities.base.Entity;
import ktu.tanks.factories.TankFactory;
import ktu.tanks.health.HealthPrototype;
import ktu.tanks.models.Player;
import ktu.tanks.net.HttpRequestSender;
import ktu.tanks.tiles.Tile;
import ktu.tanks.health.Health;
import ktu.tanks.ui.components.GameViewPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindow extends JFrame implements Tickable, WindowListener, PlayerControlManager.PlayerControlActionListener, ViewportObserver {

    private GameViewPanel gameView;
    private GameTicker gameTicker;
    private GameTicker powerTicker;
    private GameTicker networkTicker;
    private PlayerEntity playerEntity;
    private Player player;
    private ControlInvoker control;

    private List<Health> healths;

    private final Toolkit toolkit;

    public MainWindow(Player player) {
        this.toolkit = Toolkit.getDefaultToolkit();

        this.getContentPane().add(new JPanel());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Tankeliai");

        playerEntity = new PlayerEntity(player.getName(), getPlayerTank(player));
        playerEntity = new NamedPlayerEntity(playerEntity);
        this.player = new PlayerAdapter(playerEntity);
        control = new ControlInvoker();

        gameView = new GameViewPanel(new ArrayList<>());

        gameView.getPlayers().add(playerEntity);
        gameView.getViewport().attachObserver(this);

        this.add(gameView);
        this.addWindowListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);
        this.pack();
        this.setVisible(true);

        gameTicker = new GameTicker(this, 20);
        powerTicker = new GameTicker(() -> {
            Health health = gameView.getHealthPrototype();
            healths = gameView.getHealths();
            if (healths.size() <= 10){
                System.out.printf("New health. %d", healths.size());
                System.out.printf("\n");
                Health hl = (Health) health.shallowCopy();
                System.out.printf("Time: %d ", hl.getTime());
                System.out.printf("\n");
                healths.add(hl);
            }
            gameView.setHealths(healths);
        }
        , 5000);
        networkTicker = new GameTicker(() -> {
            Player[] players  = HttpRequestSender.postJson(Player[].class, this.player, "update");

            List<PlayerEntity> gameTanks = gameView.getPlayers();

            for (Player pl : players) {
                boolean exists = false;
                for (PlayerEntity plEntity : gameTanks) {
                    if (plEntity.getPlayerName().equals(pl.getName())) {
                        exists = true;
                        plEntity.getEntity().setX(pl.getPosX());
                        plEntity.getEntity().setY(pl.getPosY());
                        plEntity.getEntity().setDirection(pl.getDirection());
                    }
                }

                if (!exists) {
                    System.out.printf("Player %s joined.\n", pl.getName());
                    gameTanks.add(new NamedPlayerEntity(new PlayerEntity(pl.getName(), getPlayerTank(pl))));
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
        playerEntity.getEntity().tick();
        gameView.getViewport().moveTo(playerEntity.getEntity().getX(), playerEntity.getEntity().getY());

        SwingUtilities.invokeLater(() -> gameView.repaint());

        toolkit.sync();
    }

    @Override
    public void windowOpened(WindowEvent windowEvent) {
        gameTicker.start();
        networkTicker.start();
        powerTicker.start();
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        gameTicker.stop();
        networkTicker.stop();
        powerTicker.stop();
        gameView.getViewport().detachObserver(this);
        String response = HttpRequestSender.post(player.getName(), "logout");
        System.out.println(response);
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
        switch (direction){
            case Up:
                control.moveUp(playerEntity);
                break;
            case Down:
                control.moveDown(playerEntity);
                break;
            case Left:
                control.moveLeft(playerEntity);
                break;
            case Right:
                control.moveRight(playerEntity);
                break;
        }
    }

    @Override
    public void stopMoving() {
        control.stop(playerEntity);
    }

    private Entity getPlayerTank(Player player) {
        Entity tank = new TankFactory().produce("heavyTank");
        tank.setX(player.getPosX());
        tank.setY(player.getPosY());
        tank.setDirection(player.getDirection());
        tank.setHealth(player.getHealth());
        return tank;
    }

    @Override
    public void update(Viewport viewport) {
        System.out.println(viewport.getIndX() + " " + viewport.getIndY());
        Tile[] tiles = HttpRequestSender.postJson(Tile[].class, viewport, "level");
        gameView.setTiles(tiles);
        System.out.println("Tiles: " + tiles.length);
    }
}
