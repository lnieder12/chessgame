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

    public ArrayList<int[]> moves()
    {
        return new ArrayList(Arrays.asList(new int[] {2,1}, new int[] {2,-1}, new int[] {1,2}, new int[] {-1,2} // Déplacements en L
                , new int[] {-2,1}, new int[] {-2,-1}, new int[] {1,-2}, new int[] {-1,-2}));
    }

}
