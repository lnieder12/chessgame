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

    public ArrayList<int[]> moves()
    {
        return new ArrayList(Arrays.asList(new int[] {1,0}, new int[] {-1,0}, new int[] {0,1}, new int[] {0,-1} // Déplacements latéraux
                                        , new int[] {1,1}, new int[] {1,-1}, new int[] {-1,-1}, new int[] {-1,-1})); // Déplacements diagonales
    }

}
