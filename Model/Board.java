package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Board {

    private Colors turn = Colors.WHITE;
    private Piece[][] board;

    private BoardObserver obs;

    public Board()
    {
        board = new Piece[8][8];

        // Ajoute toutes les pièces dans l'ordre (si on lit de gauche à droite depuis A1 jusqu'à H2)
        // Pièces blanches
        ArrayList<Piece> pp1 = new ArrayList<>();
        pp1.add(new Rook(Colors.WHITE));
        pp1.add(new Knight(Colors.WHITE));
        pp1.add(new Bishop(Colors.WHITE));
        pp1.add(new Queen(Colors.WHITE));
        pp1.add(new King(Colors.WHITE));
        pp1.add(new Bishop(Colors.WHITE));
        pp1.add(new Knight(Colors.WHITE));
        pp1.add(new Rook(Colors.WHITE));
        for(int i = 0; i < 8; i++)
            pp1.add(new Pawn(Colors.WHITE));


        // Ajoute les pièces dans le bon ordre en bas du plateau (commencent par la case A1/[0][0])
        for(int i = 0; i < pp1.size(); i++)
            board[i/8][i%8] = pp1.get(i);

        // Pièces noires
        ArrayList<Piece> pp2 = new ArrayList<>();
        pp2.add(new Rook(Colors.BLACK));
        pp2.add(new Knight(Colors.BLACK));
        pp2.add(new Bishop(Colors.BLACK));
        pp2.add(new Queen(Colors.BLACK));
        pp2.add(new King(Colors.BLACK));
        pp2.add(new Bishop(Colors.BLACK));
        pp2.add(new Knight(Colors.BLACK));
        pp2.add(new Rook(Colors.BLACK));
        for(int i = 0; i < 8; i++)
            pp2.add(new Pawn(Colors.BLACK));

        // Ajoute les pièces dans le bon ordre en haut du plateau (commencent par la case H8/[7][7])
        for(int j = 0; j < pp2.size(); j++)
            board[7 - j/8][j%8] = pp2.get(j);
    }

    private Piece getPiece(Position pos)
    {
        return board[pos.x][pos.y];
    }

    private void setPiece(Position pos, Piece p)
    {
        board[pos.x][pos.y] = p;
    }

    private boolean isChecked(Colors color)
    {
        Piece p;
        Position kPos = null;
        for(int x = 0; x < 8; x++)
        {
            if(kPos != null)
                break;
            for(int y = 0; y < 8; y++)
            {

                p = getPiece(new Position(x, y));
                if(p != null) {
                    if (p.getColor() == color && p.getName().equals("King")) {
                        kPos = new Position(x, y);
                        break;
                    }
                }
            }
        }

        List<Position> qMoves = new Queen(Colors.WHITE).moves();
        ArrayList<Position> knMoves = new Knight(Colors.WHITE).moves();

        Position testCase = new Position();
        Piece cP;

        // Tests des mises en échecs par un Pion

        int x;
        if(color == Colors.WHITE)
        {
            x = 1;
        }
        else
        {
            x = -1;
        }
        testCase.x = kPos.x + x;
        if(!(testCase.x > 7 || testCase.x < 0)) {
            testCase.y = kPos.y + 1;
            if(!(testCase.y > 7 || testCase.y < 0)) {
                cP = getPiece(testCase);
                if (cP != null && cP.getName().equals("Pawn") && !cP.getColor().equals(color))
                    return true;
            }
            testCase.y = kPos.y + -1;
            if(!(testCase.y > 7 || testCase.y < 0)) {
                cP = getPiece(testCase);
                if (cP != null && cP.getName().equals("Pawn") && !cP.getColor().equals(color))
                    return true;
            }
        }
        Iterator<Position> itr;
        Position move;
        // Tests des mises en échecs par des pièces hors Roi, Pions et Cavalier
        for(int i = 1; i <= 8; i++)
        {
            itr = qMoves.iterator();
            while(itr.hasNext())
            {
                move = itr.next();
                testCase.x = kPos.x + (move.x * i);
                testCase.y = kPos.y + (move.y * i);
                // Vérifie si on sort du plateau
                if(testCase.x > 7 || testCase.x < 0 || testCase.y > 7 || testCase.y < 0)
                    itr.remove();
                // Si case visée pas vide
                else if(getPiece(testCase) != null)
                {
                    // Piece de la case
                    cP = getPiece(testCase);
                    // Si piece de la case visée une pièce adverse et n'est pas un Pion
                    if(cP.getColor() != color && !cP.getName().equals("Pawn")) {
                        // Si les déplacements de la pièce adverses vont vers le roi, ainsi que la portée (pour éliminer le roi)
                        if(cP.moves().contains(move) && cP.getRange() >= i)
                        {
                            // Alors le roi est en échec
                            return true;
                        }

                    }
                    itr.remove();
                }
            }
        }

        // Tests des mises en échecs par un Cavalier
        for(Position mo : knMoves)
        {
            testCase.x = kPos.x + (mo.x);
            testCase.y = kPos.y + (mo.y);
            // Vérifie si on sort du plateau
            if(!(testCase.x > 7 || testCase.x < 0 || testCase.y > 7 || testCase.y < 0))
            {
                // Si case visée pas vide
                if(getPiece(testCase) != null)
                {
                    // Piece de la case
                    cP = getPiece(testCase);
                    // Si piece de la case visée une pièce adverse et n'est pas un Pion
                    if(cP.getColor() != color && !cP.getName().equals("Pawn")) {
                        // Si les déplacements de la pièce adverses vont vers le roi, ainsi que la portée (pour éliminer le roi)
                        if(cP.moves().contains(mo))
                        {
                            // Alors le roi est en échec
                            return true;
                        }

                    }
                }
            }
        }

        return false;
    }

    public void checkMate()
    {

        if(isChecked(turn))
        {
            boolean endgame = true;
            Piece p;
            Position po = new Position();
            ArrayList<Position> moves = new ArrayList<>();
            for(int i = 0; i < 8; i++)
            {
                if(!moves.isEmpty()) {
                    endgame = false;
                    break;
                }
                for(int ii = 0; ii < 8; ii++)
                {
                    po.x = i;
                    po.y = ii;
                    p = getPiece(po);
                    if(p != null && p.getColor().equals(turn))
                        moves = validMoves(po);
                    if(!moves.isEmpty()){
                        endgame = false;
                        break;
                    }
                }
            }
            if(endgame)
            {
                obs.displayEndgame(turn);
            }
        }

    }

    // Renvoie la liste des coordonnées du plateau atteignable par la pièce sur la position pos
    private ArrayList<Position> validMoves(Position pos)
    {
        ArrayList<Position> reachableCases = new ArrayList<>();
        Piece piece = getPiece(pos);
        if(piece != null) {
            ArrayList<Position> moves = piece.moves();
            int range = piece.getRange();

            // Mouvements de capture du pion et mouvements de premier coup
            if(piece.getName().equals("Pawn"))
            {
                Pawn pawn = (Pawn) piece;
                int x;
                if(piece.getColor() == Colors.WHITE)
                    x = 1;
                else {
                    x = -1;
                    moves.get(0).x = -1;
                }
                if(!(pos.x + x < 0 || pos.x + x > 7)) {
                    Piece p;
                    if (!(pos.y - 1 < 0 || pos.y - 1 > 7)) {
                        p = getPiece(new Position(pos.x + x, pos.y - 1));
                        if (p != null)
                            if (p.getColor() != piece.getColor())
                                reachableCases.add(new Position(pos.x + x, pos.y - 1));
                    }
                    if (!(pos.y + 1 < 0 || pos.y + 1 > 7))
                    {
                        p = getPiece(new Position(pos.x + x, pos.y + 1));
                        if (p != null)
                            if (p.getColor() != piece.getColor())
                                reachableCases.add(new Position(pos.x + x, pos.y + 1));
                    }
                }
                if(!pawn.asMoved)
                    range++;
            }

            Iterator<Position> itr;
            Position mo;
            // S'éloigne pas à pas de la pièce jusqu'à sa portée maximale
            for(int i = 1; i <= range; i++)
            {
                itr = moves.iterator();
                while(itr.hasNext()){
                    mo = itr.next();
                    Position testCase = new Position();
                    testCase.x = pos.x + (mo.x * i);
                    testCase.y = pos.y + (mo.y * i);
                    // Vérifie si on sort du plateau
                    if(testCase.x > 7 || testCase.x < 0 || testCase.y > 7 || testCase.y < 0)
                        itr.remove();
                    // Si case visée vide
                    else if(getPiece(testCase) == null)
                        reachableCases.add(testCase);
                    // Si piece de la case visée une pièce adverse
                    else if(getPiece(testCase).getColor() != piece.getColor()) {
                        if(!piece.getName().equals("Pawn"))
                            reachableCases.add(testCase);
                        itr.remove();
                    }
                    // Si piece celle d'un allié
                    else
                        itr.remove();
                }
            }


            return testMoveCheck(pos, reachableCases);
        }
            return reachableCases;

    }
    private ArrayList<Position> testMoveCheck(Position pos, ArrayList<Position> testCases)
    {
        ArrayList<Position> finalCases = testCases;
        Piece[][] brd = new Piece[8][];
        for(int i = 0; i < 8; i++)
        {
            brd[i] = board[i].clone();
        }

        Colors color = getPiece(pos).getColor();
        Iterator<Position> itr = testCases.iterator();
        Position mo;
        while(itr.hasNext())
        {
            mo = itr.next();

            shadowMove(pos, mo);
            if(isChecked(color))
                itr.remove();
            for(int y = 0; y < 8; y++)
                board[y] = brd[y].clone();
        }
        board = brd;
        return finalCases;
    }


    private void shadowMove(Position initial, Position end)
    {
        setPiece(end, getPiece(initial));
        setPiece(initial, null);
    }

    public Piece movePiece(Position initial, Position end)
    {
        Piece rtr = getPiece(end);
        Piece ini = getPiece(initial);
        if(ini.getName().equals("Pawn"))
        {
            Pawn pawn = (Pawn) getPiece(initial);
            pawn.asMoved = true;
            if(end.x == 0 && ini.getColor().equals(Colors.BLACK))
                ini = new Queen(ini.getColor());
            if(end.x == 7 && ini.getColor().equals(Colors.WHITE))
                ini = new Queen(ini.getColor());
        }
        setPiece(end, ini);
        updateCase(end, getPiece(end));
        setPiece(initial, null);
        updateCase(initial, null);
        nextTurn();
        return rtr;
    }

    private void nextTurn()
    {
        if(turn.equals(Colors.WHITE))
            turn = Colors.BLACK;
        else
            turn = Colors.WHITE;
    }

    public void getMoves(Position pos)
    {
        ArrayList<Position> moves = new ArrayList<>();
        Piece p = getPiece(pos);
        if(p != null && p.getColor().equals(turn))
            moves = validMoves(pos);
        if(!moves.isEmpty())
        {
            obs.caseHighlight(moves);
        }
        else
            obs.caseHighlight(null);
    }

    private void updateCase(Position pos, Piece p)
    {
        String pname = "";
        Colors color = null;
        if(p != null) {
            pname = p.getName();
            color = p.getColor();
        }
        obs.setCaseImage(pos, pname, color);
    }

    public void setObserver(BoardObserver observer)
    {
        obs = observer;
        Position pos;
        for(int i = 0; i < 8; i++)
        {
            for(int ii = 0; ii < 8; ii++)
            {
                pos = new Position(i, ii);
                updateCase(pos, getPiece(pos));
            }
        }
    }

}
