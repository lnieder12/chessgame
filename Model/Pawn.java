package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece{

    boolean asMoved;

    public Pawn(){
        asMoved = false;
        value = 1;
    }

    public ArrayList<int[]> moves()
    {
        return new ArrayList(Arrays.asList(new int[] {1,0}));
    }
}
