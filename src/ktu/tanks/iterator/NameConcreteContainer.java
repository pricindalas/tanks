package ktu.tanks.iterator;

import ktu.tanks.health.Health;
import ktu.tanks.models.Player;

import java.util.List;

public class NameConcreteContainer implements NameContainer{

    private Player[] names = new Player[20];
    private int lenght = 1;

    @Override
    public NameIterator getIterator() {
        return new NameConcreteIterator();
    }

    @Override
    public void setIterator(){

    }

    private class NameConcreteIterator implements NameIterator {

        int index = 0;

        @Override
        public boolean hasNext() {

            if(index < lenght){
                return true;
            }
            return false;
        }

        @Override
        public Player next() {

            if(this.hasNext()){
                index++;
                return names[index];
            }
            return null;
        }

        @Override
        public int getIndex(){
            return lenght;
        }

        @Override
        public void add(Player name){
            names[lenght] = name;
            lenght++;
        }
    }
}
