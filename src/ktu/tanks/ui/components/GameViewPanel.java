package ktu.tanks.ui.components;

import ktu.tanks.decorators.Renderable;
import ktu.tanks.entities.base.PlayerEntity;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameViewPanel extends JComponent {

    private static final int SIZE = 512;

    private List<PlayerEntity> tanks;

    private final Color bgColor = new Color(128, 128, 128);
    private final Color textColor = new Color(0, 0, 0);

    private int ticks = 0;

    public GameViewPanel(List<PlayerEntity> tanks) {
        Dimension dimension = new Dimension();
        dimension.width = SIZE;
        dimension.height = SIZE;
        this.setPreferredSize(dimension);
        this.tanks = tanks;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, SIZE, SIZE);
        //System.out.printf("Rendering frame, %d tanks\n", tanks.size());
        for (Renderable tank : tanks) {
            tank.render(g);
        }
        g.setColor(textColor);
        g.drawString(String.valueOf(ticks++), 10, 10);
    }

    public List<PlayerEntity> getTanks() {
        return tanks;
    }
}
