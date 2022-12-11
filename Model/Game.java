package Model;

public class Game {

    private Board board;

    private Player pWhite;

    private Player pBlack;

    public Game(Board pBoard, Player pW, Player pB)
    {
        board = pBoard;

        pWhite = pW;

        pBlack = pB;
    }

}
