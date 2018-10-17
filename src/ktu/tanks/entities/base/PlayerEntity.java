package ktu.tanks.entities.base;

public abstract class PlayerEntity extends Entity {

    protected String playerName;

    public PlayerEntity(String playerName) {
        super();
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
