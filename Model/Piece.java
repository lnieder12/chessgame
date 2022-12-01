package Model;

import java.util.ArrayList;

public abstract class Piece {
    int value;

    int range;

    Colors color;

    public Piece (Colors pColor)
    {
        color = pColor;
    }

    abstract ArrayList<int[]> moves();

}
