package Controller;

import Model.Player;

public class PlayerController {
    Player wP;

    Player bP;

    public PlayerController(Player white, Player black)
    {
        wP = white;
        bP = black;
    }

    public void setNames(String wName, String bName)
    {
        wP.setName(wName);
        bP.setName(bName);
    }

}
