package ktu.tanks.health;

import ktu.tanks.converters.PositionConverter;
import ktu.tanks.ui.Renderable;
import ktu.tanks.ui.Viewport;

import java.awt.*;

public class Health extends HealthPrototype {


    public Health(int healthId) {
        super(healthId);
    }

    @Override
    public HealthPrototype shallowCopy() {
        try {
            HealthPrototype clone = (HealthPrototype) super.clone();
            int randomNum = 0 + (int)(Math.random() * ((10 - 0) + 1));
            clone.setIndX(randomNum);
            randomNum = 0 + (int)(Math.random() * ((10 - 0) + 1));
            clone.setIndY(randomNum);
            return clone;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

//    @Override
//    public void render(Graphics g, Viewport viewport) {
//        g.drawImage(healthManager.getHealthImage(healthId), viewport.transformX(PositionConverter.IndToPos(indX)), viewport.transformY(PositionConverter.IndToPos(indY)), null);
//    }
}
