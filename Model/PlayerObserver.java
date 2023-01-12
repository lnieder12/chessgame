package Model;

import java.util.ArrayList;


public interface PlayerObserver {

    void displayName(String name, Colors color);

    void displayScore(Integer score, Colors color);

    void displayCapturedPiece(ArrayList<Piece> pieceList, Colors color);

}
