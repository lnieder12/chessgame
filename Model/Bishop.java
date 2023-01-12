package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Piece{

    public Bishop(Colors pColor)
    {
        super(pColor);
        value = 3;
        range = 8;
        name = "Bishop";
    }

    public ArrayList<Position> moves()
    {
        return new ArrayList(Arrays.asList(new Position (1,1), new Position (1,-1), new Position (-1,-1), new Position (-1,1))); // Déplacements diagonales
    }

}
