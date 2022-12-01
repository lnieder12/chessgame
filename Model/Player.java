package Model;

import java.util.ArrayList;

public class Player {

    private ArrayList<Piece> pieces;

    private int points;

    private String name;

    public Player(String pName, Colors pColor)
    {
        pieces.add(new Rook(pColor));
        pieces.add(new Knight(pColor));
        pieces.add(new Bishop(pColor));
        pieces.add(new Queen(pColor));
        pieces.add(new King(pColor));
        pieces.add(new Bishop(pColor));
        pieces.add(new Knight(pColor));
        pieces.add(new Rook(pColor));
        for(int i = 0; i < 8; i++)
            pieces.add(new Pawn(pColor));

        points = 0;

        name = pName;

    }

    public boolean isChecked(){
        return false;
    }

    public ArrayList<Piece> getPieces(){
        return pieces;
    }

}
