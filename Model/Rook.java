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
    }

    public ArrayList<int[]> moves()
    {
        return new ArrayList(Arrays.asList(new int[] {1,0}, new int[] {-1,0}, new int[] {0,1}, new int[] {0,-1})); // Déplacements latéraux
    }
}
