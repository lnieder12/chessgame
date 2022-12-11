package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece{

    boolean asMoved;

    public Pawn(Colors pColor)
    {
        super(pColor);
        asMoved = false;
        value = 1;
        range = 1;
    }

    public ArrayList<Position> moves()
    {
        return new ArrayList(Arrays.asList(new Position(1,0)));
    } // Vers l'avant
}
