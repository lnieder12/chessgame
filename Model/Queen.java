package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen extends Piece{
    public Queen(Colors pColor){
        super(pColor);
        value = 9;
        range = 8;
    }

    public ArrayList<int[]> moves()
    {
        return new ArrayList(Arrays.asList(new int[] {1,0}, new int[] {-1,0}, new int[] {0,1}, new int[] {0,-1} // Déplacements latéraux
                                        , new int[] {1,1}, new int[] {1,-1}, new int[] {-1,-1}, new int[] {-1,-1})); // Déplacements diagonales
    }

}
