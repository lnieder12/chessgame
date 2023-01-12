package Model;

import Controller.BoardController;

public class Game {

    private Position selectedPiece = null;
    private Board board;

    private Player pWhite;

    private Player pBlack;

    public Game(Board pBoard, Player pW, Player pB)
    {
        board = pBoard;

        pWhite = pW;

        pBlack = pB;
    }

    public void movePiece(Position end)
    {
        if(selectedPiece != null) {
            Piece newP = board.movePiece(selectedPiece, end);
            if (newP != null) {
                if (newP.getColor() == Colors.WHITE)
                    pWhite.addCapturedPiece(newP);
                else
                    pBlack.addCapturedPiece(newP);
            }
        }
        board.checkMate();
    }

    public void getMoves(Position pos)
    {
        selectedPiece = pos;
        board.getMoves(pos);
    }



}
