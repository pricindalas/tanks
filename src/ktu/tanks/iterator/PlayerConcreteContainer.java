package ktu.tanks.iterator;

import ktu.tanks.models.Player;

public class PlayerConcreteContainer implements PlayerContainer {

    private Player[] players = new Player[20];
    private int lenght = 1;

    @Override
    public PlayerIterator getIterator() {
        return new PlayerConcreteIterator();
    }

    @Override
    public void setIterator(){

    }

    private class PlayerConcreteIterator implements PlayerIterator {

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
                return players[index];
            }
            return null;
        }

        @Override
        public int getIndex(){
            return lenght;
        }

        @Override
        public void add(Player player){
            players[lenght] = player;
            lenght++;
        }
    }
}
