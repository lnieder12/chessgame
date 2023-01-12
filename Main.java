import Model.*;
import View.*;
import Controller.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args)
    {

        Board board = new Board();
        //System.out.println(board.getPiece(new Position(0, 4)).getClass().getSimpleName());

        Player pW = new Player(Colors.WHITE);
        Player pB = new Player(Colors.BLACK);


        Game game = new Game(board, pW, pB);

        BoardController bControl = new BoardController(game);

        PlayerController pControl = new PlayerController(pW, pB);

        try {
            Window salut = new Window(bControl, pControl);
            board.setObserver(salut);
            pW.setObserver(salut);
            pB.setObserver(salut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
