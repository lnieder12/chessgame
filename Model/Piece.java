package Model;

import java.util.ArrayList;

public abstract class Piece {
    int value;

    int range;

    abstract ArrayList<int[]> moves();

}
