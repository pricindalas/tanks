package ktu.tanks;

import ktu.tanks.converters.KeyToDirectionConverter;
import ktu.tanks.entities.HeavyTank;
import ktu.tanks.entities.LightTank;
import ktu.tanks.entities.Mediator;
import ktu.tanks.entities.TankMediator;
import ktu.tanks.entities.base.Tank;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerControlManager implements KeyEventDispatcher {

    private boolean isKeyDown;
    private PlayerControlActionListener playerControlActionListener;

    public PlayerControlManager(PlayerControlActionListener playerControlActionListener) {
        this.playerControlActionListener = playerControlActionListener;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        switch (e.getID()) {
            case KeyEvent.KEY_PRESSED:
                if (isKeyDown)
                    break;

                isKeyDown = true;
                System.out.println("Code : " + e.getKeyCode());
                Direction direction = KeyToDirectionConverter.getDirection(e.getKeyCode());
                if (e.getKeyCode() == 32){
                    Tank hTank = new HeavyTank();
                    Tank lTank = new LightTank();

                    Mediator med = new TankMediator();
                    med.registerHeavy(hTank);
                    med.registerLight(lTank);

                    med.heavyAttack();
                }
                if (direction != null) {
                    playerControlActionListener.startMoving(KeyToDirectionConverter.getDirection(e.getKeyCode()));
                }

                break;
            case KeyEvent.KEY_RELEASED:
                isKeyDown = false;
                playerControlActionListener.stopMoving();
                break;
        }

        return false;
    }

    public interface PlayerControlActionListener {
        void startMoving(Direction direction);
        void stopMoving();
    }
}
