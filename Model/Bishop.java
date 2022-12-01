package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Piece{

    public Bishop(Colors pColor)
    {
        super(pColor);
        value = 3;
        range = 8;
    }

    public ArrayList<int[]> moves()
    {
        return new ArrayList(Arrays.asList(new int[] {1,1}, new int[] {1,-1}, new int[] {-1,-1}, new int[] {-1,-1}));
    }

}
