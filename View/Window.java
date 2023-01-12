package View;

import Controller.*;
import Model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;


import java.io.File;
import java.io.IOException;

import java.util.ArrayList;


public class Window extends JFrame implements BoardObserver, PlayerObserver{

    private final ImageIcon whiteKing = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/KingWHITE.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon whiteQueen = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/QueenWHITE.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon whiteRook = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/RookWHITE.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon whiteBishop = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/BishopWHITE.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon whiteKnight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/KnightWHITE.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon whitePawn = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/PawnWHITE.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon blackKing = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/KingBLACK.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon blackQueen = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/QueenBLACK.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon blackRook = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/RookBLACK.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon blackBishop = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/BishopBLACK.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon blackKnight = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/KnightBLACK.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private final ImageIcon blackPawn = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("chess_icons/PawnBLACK.png")).getScaledInstance(80, 80, Image.SCALE_SMOOTH));
    private BoardController bControl;

    private PlayerController pControl;

    public class PlayerInfo extends JPanel
    {
        JLabel playerName = new JLabel();
        JPanel capturedPiece = new JPanel();
        JLabel score = new JLabel();

        public PlayerInfo()
        {
            GridBagConstraints constraintsP = new GridBagConstraints();

            constraintsP.fill = GridBagConstraints.VERTICAL;
            constraintsP.gridx = 0;
            constraintsP.gridy = 0;
            constraintsP.gridwidth = 3;

            setBackground(Color.ORANGE);

            setLayout(new GridBagLayout());
            playerName.setText("BlackPlayer");
            capturedPiece.setLayout(new GridLayout(0,3));
            add(playerName,constraintsP);
            constraintsP.gridy = 1;
            add(capturedPiece, constraintsP);
            constraintsP.gridy = 2;
            score.setText("Score : 0");
            add(score, constraintsP);
        }

        public void setPlayerName(String name)
        {
            playerName.setText(name);
        }

        public void updateScore(String scoreT)
        {
            score.setText(scoreT);
        }

        public void addPieceIcon(ImageIcon icon)
        {
            capturedPiece.add(new JLabel(icon));
        }

        public void clearIcon()
        {
            capturedPiece.removeAll();
        }

        public String getName()
        {
            return playerName.getText();
        }


    }

    private PlayerInfo blackPlayerInfo = new PlayerInfo();

    private PlayerInfo whitePlayerInfo = new PlayerInfo();

    private JPanel board;


    public class JButtonB{
        boolean reach;

        JButton button;

        public JButtonB()
        {
            reach = false;
            button = new JButton();
        }
    }

    private JButtonB[][] chessBoardCases = new JButtonB[8][8];

    public Window(BoardController bControl, PlayerController pControl) throws IOException {

        this.bControl = bControl;
        this.pControl = pControl;

        JFrame mainMenu = new JFrame();

        GridBagConstraints constraintsM = new GridBagConstraints();

        constraintsM.fill = GridBagConstraints.HORIZONTAL;
        constraintsM.gridx = 0;
        constraintsM.gridy = 0;
        constraintsM.ipadx = 50;
        constraintsM.ipady = 15;

        mainMenu.setTitle("Chessgame");
        mainMenu.setSize(1200,800);
        mainMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainMenu.setLayout(new GridBagLayout());

        JLabel white = new JLabel("Joueur blanc :");
        JLabel black = new JLabel("Joueur noir :");
        JTextField bName = new JTextField();
        JTextField wName = new JTextField();
        JButton start = new JButton("Commencer");

        start.addActionListener(ActionEvent -> {
            mainMenu.setVisible(false);
            pControl.setNames(wName.getText(), bName.getText());
            setVisible(true);

        });

        mainMenu.add(white, constraintsM);
        constraintsM.gridy = 1;
        mainMenu.add(wName, constraintsM);
        constraintsM.gridx = 1;
        constraintsM.gridy = 0;
        constraintsM.gridheight = 2;
        mainMenu.add(start, constraintsM);
        constraintsM.gridx = 2;
        constraintsM.gridheight = 1;
        mainMenu.add(black, constraintsM);
        constraintsM.gridy = 1;
        mainMenu.add(bName, constraintsM);

        mainMenu.setVisible(true);



        setTitle("Chessgame");
        setSize(1200,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridBagLayout());
        board = new JPanel();
        board.setSize(800,800);
        board.setLayout(new GridLayout(8,8));
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;

        Insets margin = new Insets(0,0,0,0);

        for(int y = 0; y < 8; y++) {
            for (int i = 0; i < 8; i++) {
                JButtonB l = new JButtonB();
                l.button.setOpaque(true);
                l.button.setMargin(margin);
                //ImageIcon img = new ImageIcon(new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB));
                if (i % 2 == 1 && y % 2 == 1
                        || i % 2 == 0 && y % 2 == 0)
                    l.button.setBackground(Color.decode("#665b4a"));
                else
                    l.button.setBackground(Color.decode("#f0d9b5"));
                int finalY = y;
                int finalI = i;
                l.button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                l.button.addActionListener(actionEvent -> {actionOnClick(new Position(finalY, finalI));});
                chessBoardCases[y][i] = l;
            }
        }
        for(int yy = 0; yy < 8; yy++) {
            for (int ii = 0; ii < 8; ii++) {
                board.add(chessBoardCases[7-yy][ii].button);
            }
        }
        this.add(blackPlayerInfo,constraints);
        constraints.gridx = 1;
        this.add(board, constraints);
        constraints.gridx = 2;
        this.add(whitePlayerInfo, constraints);

        //setVisible(true);
    }


    public void setCaseImage(Position pos, String pName, Colors color)
    {
        ImageIcon img;
        img = choseIcon(pName, color);

        chessBoardCases[pos.x][pos.y].button.setIcon(img);
        caseHighlight(null);
    }

    private void actionOnClick(Position pos)
    {
        if(chessBoardCases[pos.x][pos.y].reach)
        {
            selectMove(pos);
        }
        else {
            selectPiece(pos);
        }
    }

    private void selectPiece(Position pos)
    {
        bControl.getMoves(pos);
    }

    private void selectMove(Position pos)
    {
        bControl.movePiece(pos);
    }
    public void caseHighlight(ArrayList<Position> moves) {
        for(int i = 0; i < 8; i++)
        {
            for(int ii = 0; ii < 8; ii++)
            {
                chessBoardCases[i][ii].button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                chessBoardCases[i][ii].reach = false;
            }
        }
        if(moves != null) {
            for (Position po : moves) {
                chessBoardCases[po.x][po.y].button.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.RED));
                chessBoardCases[po.x][po.y].reach = true;
            }
        }
    }

    public void displayName(String name, Colors color){
        if(color == Colors.WHITE)
        {
            whitePlayerInfo.setPlayerName(name);
        }
        else if(color == Colors.BLACK)
        {
            blackPlayerInfo.setPlayerName(name);
        }
    }

    public void displayScore(Integer score, Colors color){
        if(color == Colors.WHITE)
        {
            whitePlayerInfo.updateScore("Score: "+ score.toString());
        }
        else if(color == Colors.BLACK)
        {
            blackPlayerInfo.updateScore("Score: "+ score.toString());
        }
    }

    public void displayCapturedPiece(ArrayList<Piece> pieceList, Colors color){
        if(color == Colors.WHITE)
        {
            whitePlayerInfo.clearIcon();
            for (Piece p : pieceList) {
                whitePlayerInfo.addPieceIcon(choseIcon(p.getName(), p.getColor()));
            }
        }
        else if(color == Colors.BLACK)
        {
            blackPlayerInfo.clearIcon();
            for (Piece p : pieceList) {
                blackPlayerInfo.addPieceIcon(choseIcon(p.getName(), p.getColor()));
            }
        }
    }

    private ImageIcon choseIcon(String pName, Colors color)
    {
        ImageIcon img;
        if(color == Colors.WHITE) {
            switch (pName) {
                case "Rook":
                    img = whiteRook;
                    break;
                case "Bishop":
                    img = whiteBishop;
                    break;
                case "King":
                    img = whiteKing;
                    break;
                case "Knight":
                    img = whiteKnight;
                    break;
                case "Pawn":
                    img = whitePawn;
                    break;
                case "Queen":
                    img = whiteQueen;
                    break;
                default:
                    img = null;
            }
        }
        else if(color == Colors.BLACK)
        {
            switch (pName) {
                case "Rook":
                    img = blackRook;
                    break;
                case "Bishop":
                    img = blackBishop;
                    break;
                case "King":
                    img = blackKing;
                    break;
                case "Knight":
                    img = blackKnight;
                    break;
                case "Pawn":
                    img = blackPawn;
                    break;
                case "Queen":
                    img = blackQueen;
                    break;
                default:
                    img = null;
            }
        }
        else
            img = null;

        return img;
    }

    public void displayEndgame(Colors color)
    {
        JFrame end = new JFrame();
        end.setTitle("Chessgame");
        end.setSize(1200,800);
        end.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel text = new JLabel();
        if(color == Colors.WHITE)
            text.setText(blackPlayerInfo.getName() + " a gagné !");
        else if(color == Colors.BLACK)
            text.setText(whitePlayerInfo.getName() + " a gagné !");
        end.add(text);
        setVisible(false);
        end.setVisible(true);
    }

}
