package ktu.tanks.converters;

public class PositionConverter {
    public static int PosToInd(int pos) {
        return pos / 64;
    }

    public static int IndToPos(int ind) {
        return ind * 64;
    }
}
