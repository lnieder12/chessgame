package Model;

public class Position {
    public int x; // Ligne

    public int y; // Colonne

    public Position(int pX, int pY)
    {
        x = pX;
        y = pY;
    }

    public Position()
    {

    }
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
        {
            return true;
        }
        if(!(obj instanceof Position))
            return false;

        Position other = (Position) obj;
        return x == other.x && y == other.y;
    }

}
