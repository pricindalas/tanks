package ktu.tanks.strategy;

import ktu.tanks.strategy.base.SelectionAlgorithm;

public class PlayerNameAlgorithm extends SelectionAlgorithm {
    @Override
    public String getTankType(String name) {
        int temp = 0;
        for (char character : name.toCharArray()){
            temp = temp + (character - 48);
        }
        if ((temp % 2) == 0) return "heavyTank";
        return "lightTank";
    }
}
