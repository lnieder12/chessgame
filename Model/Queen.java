package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen extends Piece{
    public Queen(Colors pColor){
        super(pColor);
        value = 9;
        range = 8;
        name = "Queen";
    }

    public ArrayList<Position> moves()
    {
        return new ArrayList(Arrays.asList(new Position (1,0), new Position (-1,0), new Position (0,1), new Position (0,-1) // Déplacements latéraux
                                        , new Position (1,1), new Position (1,-1), new Position (-1,-1), new Position (-1,1))); // Déplacements diagonales
    }

}
