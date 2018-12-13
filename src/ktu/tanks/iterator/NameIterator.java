package ktu.tanks.iterator;

import ktu.tanks.models.Player;

public interface NameIterator {

    public boolean hasNext();
    public Player next();
    public void add(Player player);
    public int getIndex();
//    public Player get();

}
