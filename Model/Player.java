package Model;

import java.util.ArrayList;

public class Player {

    private Colors color;
    private int points;
    private String name;

    private ArrayList<Piece> capturedPieces;

    public Player(String pName, Colors pColor)
    {

        color = pColor;

        points = 0;

        name = pName;

        capturedPieces = new ArrayList<>();

    }

    public void addPoints(int pts)
    {
        points += pts;
    }

    public void addCapturedPiece(Piece p)
    {
        capturedPieces.add(p);
    }

}
