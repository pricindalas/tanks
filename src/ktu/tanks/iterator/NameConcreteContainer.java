package ktu.tanks.iterator;

import ktu.tanks.health.Health;

import java.util.List;

public class NameConcreteContainer implements NameContainer{

    private List<String> names;

    @Override
    public NameIterator getIterator() {
        return new NameConcreteIterator();
    }

    private class NameConcreteIterator implements NameIterator {

        int index;

        @Override
        public boolean hasNext() {

            if(index < names.size()){
                return true;
            }
            return false;
        }

        @Override
        public String next() {

            if(this.hasNext()){
                index++;
                return names.get(index);
            }
            return null;
        }
    }
}
