package ktu.tanks.converters;

import ktu.tanks.Direction;

public class KeyToDirectionConverter {
    public static Direction getDirection(int code) {
        switch (code) {
            case 87:
                return Direction.Up;
            case 65:
                return Direction.Left;
            case 83:
                return Direction.Down;
            case 68:
                return Direction.Right;
            default:
                return null;
        }
    }
}
