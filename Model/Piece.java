package Model;

import java.util.ArrayList;

public abstract class Piece {
    protected int value;

    protected int range;

    private Colors color;

    protected String name;

    public Piece (Colors pColor)
    {
        color = pColor;
    }

    public int getRange(){return range;}

    public Colors getColor(){return color;}

    abstract ArrayList<Position> moves();

    public String getName()
    {
        return name;
    }

}
