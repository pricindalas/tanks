package ktu.tanks.ui.components;

import ktu.tanks.ui.Tank;

import javax.swing.*;
import java.awt.*;

public class GameViewPanel extends JComponent {

    private static final int SIZE = 512;

    private Tank player;

    private final Color bgColor = new Color(128, 128, 128);
    private final Color textColor = new Color(0, 0, 0);

    private int ticks = 0;

    public GameViewPanel(Tank player) {
        Dimension dimension = new Dimension();
        dimension.width = SIZE;
        dimension.height = SIZE;
        this.setPreferredSize(dimension);
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, SIZE, SIZE);
        player.render(g);
        g.setColor(textColor);
        g.drawString(String.valueOf(ticks++), 10, 10);
    }
}
