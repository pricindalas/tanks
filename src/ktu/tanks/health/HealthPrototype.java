package ktu.tanks.health;

import ktu.tanks.converters.PositionConverter;
import ktu.tanks.decorators.Renderable;
import ktu.tanks.ui.Viewport;

import java.awt.*;

public abstract class HealthPrototype implements Renderable, Cloneable{
    private int healthId;
    private int indX;
    private int indY;
    private int time;

    private HealthManager healthManager;

    public HealthPrototype shallowCopy() {
        try {
            return (HealthPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public HealthPrototype deepCopy() {
//        try {
//            HealthPrototype qwe = (HealthPrototype) super.clone();
//            qwe.wings = (Wings) qwe.wings.clone();
//            return qwe;
//        } catch (CloneNotSupportedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return null;
//    }

    public HealthPrototype(int healthId) {
        time = 0;
        int randomNum = 0 + (int)(Math.random() * ((10 - 0) + 1));
        this.indX = randomNum;
        this.indY = randomNum;
        this.healthId = healthId;
    }

    public int getHealthId() {
        return healthId;
    }

    public void setHealthId(int healthId) {
        this.healthId = healthId;
    }

    public int getIndX() {
        return indX;
    }

    public void setIndX(int indX) {
        this.indX = indX;
    }

    public int getTime() {
        return time;
    }

    public void incTime(){
        time++;
    }

    public int getIndY() {
        return indY;
    }

    public void setIndY(int indY) {
        this.indY = indY;
    }

    public HealthManager getHealthManager() {
        return healthManager;
    }

    public void setHealthManager(HealthManager healthManager) {
        this.healthManager = healthManager;
    }

    @Override
    public void render(Graphics g, Viewport viewport) {
        g.drawImage(healthManager.getHealthImage(healthId), viewport.transformX(PositionConverter.IndToPos(indX)), viewport.transformY(PositionConverter.IndToPos(indY)), null);
    }
}