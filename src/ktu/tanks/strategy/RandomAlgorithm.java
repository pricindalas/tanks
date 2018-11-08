package ktu.tanks.strategy;

import ktu.tanks.strategy.base.SelectionAlgorithm;

import java.util.Random;

public class RandomAlgorithm extends SelectionAlgorithm {
    @Override
    public String getTankType(String name) {
        if (new Random().nextInt(100) < 50) return "heavyTank";
        return "lightTank";
    }
}
