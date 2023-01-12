package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Rook extends Piece{

    boolean asMoved;

    public Rook(Colors pColor){
        super(pColor);
        asMoved = false;
        value = 5;
        range = 8;
        name = "Rook";
    }

    public ArrayList<Position> moves()
    {
        return new ArrayList(Arrays.asList(new Position (1,0), new Position (-1,0), new Position (0,1), new Position (0,-1))); // Déplacements latéraux
    }
}
