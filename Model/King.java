package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class King extends Piece{

    boolean asMoved;

    public King(Colors pColor)
    {
        super(pColor);
        asMoved = false;
        value = 0;
        range = 1;
    }

    public ArrayList<Position> moves()
    {
        return new ArrayList(Arrays.asList(new Position (1,0), new Position (-1,0), new Position (0,1), new Position (0,-1) // Déplacements latéraux
                                        , new Position (1,1), new Position (1,-1), new Position (-1,-1), new Position (-1,-1))); // Déplacements diagonales
    }

}
