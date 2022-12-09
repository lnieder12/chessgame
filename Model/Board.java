package Model;

import java.util.ArrayList;

public class Board {

    private Piece[][] board;

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
            board[7 - j/8][7 - j%8] = pp2.get(j);
    }

    public Piece getPiece(int[] pos)
    {
        return board[pos[0]][pos[1]];
    }

    public void setPiece(int[] pos, Piece p)
    {
        board[pos[0]][pos[1]] = p;
    }

    public boolean pieceChecked(Piece piece)
    {
        return false;
    }

    public int[][] validMoves(int[] pos)
    {
        int[][] reachableCases = new int[8][8];
        Piece piece = getPiece(pos);
        if(piece != null) {
            int[] testCase = new int[2];
            ArrayList<int[]> moves = piece.moves();
            for(int i = 0; i < piece.getRange(); i++)
            {
                for (int[] mo : moves) {
                    testCase[0] = pos[0] + mo[0];
                    testCase[1] = pos[1] + mo[1];
                    if(getPiece(testCase).getColor() != piece.getColor())
                        reachableCases[testCase[0]][testCase[1]] = 1;
                    else
                        moves.remove(mo);
                }
            }



        }
        return reachableCases;

    }

    public void movePiece(int[] initial, int[] end)
    {
        setPiece(end, getPiece(initial));
        setPiece(initial, null);
    }


}
