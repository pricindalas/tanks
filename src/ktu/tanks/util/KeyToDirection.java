package ktu.tanks.util;

import ktu.tanks.Direction;

public class KeyToDirection {
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
