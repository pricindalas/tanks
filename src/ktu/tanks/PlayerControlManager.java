package ktu.tanks;

import ktu.tanks.converters.KeyToDirectionConverter;

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
                Direction direction = KeyToDirectionConverter.getDirection(e.getKeyCode());

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
