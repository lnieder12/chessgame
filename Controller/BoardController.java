package Controller;

import Model.Game;
import Model.Position;

public class BoardController {

    private Game game;

    public BoardController(Game pGame)
    {
        game = pGame;
    }

    public void getMoves(Position posClick)
    {
        game.getMoves(posClick);
    }

    public void movePiece(Position posClick)
    {
        game.movePiece(posClick);
    }

}
