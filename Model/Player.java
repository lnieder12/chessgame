package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {

    private PlayerObserver obs;
    private Colors color;
    private Integer points;
    private String name;

    private ArrayList<Piece> capturedPieces;

    public Player(Colors pColor)
    {

        color = pColor;

        points = 0;

        capturedPieces = new ArrayList<>();

    }

    private void addPoints(int pts)
    {
        points += pts;
        updateScore();
    }

    public void addCapturedPiece(Piece p)
    {
        int i;
        for(i = 0; i < capturedPieces.size(); i++)
            if(capturedPieces.get(i).value < p.value)
                break;
            else if(capturedPieces.get(i).value == p.value && capturedPieces.get(i).range < p.range)
                break;

        capturedPieces.add(i, p);
        updateCapturedPiece();
        addPoints(p.value);
    }

    public void updateName()
    {
        obs.displayName(name, color);
    }

    public void updateScore()
    {
        obs.displayScore(points, color);
    }

    public void updateCapturedPiece()
    {
        obs.displayCapturedPiece(capturedPieces, color);
    }

    public void setObserver(PlayerObserver observer)
    {
        obs = observer;
    }

    public void setName(String pName)
    {
        name = pName;
        updateName();
    }
}
