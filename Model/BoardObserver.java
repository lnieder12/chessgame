package Model;

import java.util.ArrayList;

public interface BoardObserver {

    void caseHighlight(ArrayList<Position> moves);

    void setCaseImage(Position pos, String pName, Colors color);

    void displayEndgame(Colors color);

}
