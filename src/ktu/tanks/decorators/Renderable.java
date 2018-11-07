package ktu.tanks.decorators;

import ktu.tanks.ui.Viewport;

import java.awt.*;

public interface Renderable {
    void render(Graphics g, Viewport viewport);
}
