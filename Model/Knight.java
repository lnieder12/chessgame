package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Knight extends Piece{

    public Knight(Colors pColor)
    {
        super(pColor);
        value = 3;
        range = 1;
    }

    public ArrayList<Position> moves()
    {
        return new ArrayList(Arrays.asList(new Position (2,1), new Position (2,-1), new Position (1,2), new Position (-1,2) // Déplacements en L
                , new Position (-2,1), new Position (-2,-1), new Position (1,-2), new Position (-1,-2)));
    }

}
