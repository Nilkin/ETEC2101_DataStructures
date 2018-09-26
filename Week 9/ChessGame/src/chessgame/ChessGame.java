package chessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;


public class ChessGame {
    public static void main(String[] args) {
        //set Window
        JFrame win = new JFrame("ChessBoard");
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setSize(800,600);
        win.getContentPane().setLayout(new BorderLayout());
        //set TopPanel
        JPanel topPanel = new JPanel();
        win.getContentPane().add(topPanel,BorderLayout.NORTH);
        topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.X_AXIS));
        //set CenterPanel
        JPanel centerPanel = new JPanel();
        win.getContentPane().add(centerPanel,BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(8,8));
        //set rightPanel
        JPanel rightPanel = new JPanel();
        win.getContentPane().add(rightPanel,BorderLayout.EAST);
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));

        
        //Side Labels, and Time placement Labels
        JLabel Black = new JLabel("Black"); JLabel White = new JLabel("White");
        JLabel BlTime = new JLabel("00:05:00"); JLabel WhTime = new JLabel("00:05:00");
        //black label and time label
        rightPanel.add(Black); rightPanel.add(BlTime);
        //white label and time label
        rightPanel.add(White); rightPanel.add(WhTime);
        
        //Array Of WhiteChessPieces & Array of BlackChessPieces
        ArrayList<Piece> WhitePieces = new ArrayList();
        ArrayList<Piece> BlackPieces = new ArrayList();
        //SetJButton Array
        Spot[][] Board = new Spot[8][8];
        //Set DLL for Undo and Redo
        DLinkedList<ArrayList> MoveHistory = new DLinkedList();
        
        //add Pieces and set Board
        for (int r=0;r<8;r++){ 
            for(int c=0;c<8;c++){
                Spot tile;
                Piece p;
                if(r==0||r==7){ //differ from white back row and black back row
                    if(r==0){ //(white) top of bord pieces
                        if(c==0||c==7)
                            p = new Rook(Side.WHITE,r,c,'R');
                        else if(c==1||c==6)
                            p = new Knight(Side.WHITE,r,c,'N');
                        else if(c==2||c==5)
                            p = new Bishop(Side.WHITE,r,c,'B');
                        else if(c==3)
                            p = new Queen(Side.WHITE,r,c,'Q');
                        else
                            p = new King(Side.WHITE,r,c,'K');
                        WhitePieces.add(p);
                        tile = new Spot(true,p,r,c);
                    }
                    else{
                        if(c==0||c==7)
                            p = new Rook(Side.BLACK,r,c,'R');
                        else if(c==1||c==6)
                            p = new Knight(Side.BLACK,r,c,'N');
                        else if(c==2||c==5)
                            p = new Bishop(Side.BLACK,r,c,'B');
                        else if(c==3)
                            p = new Queen(Side.BLACK,r,c,'Q');
                        else
                            p = new King(Side.BLACK,r,c,'K');
                        BlackPieces.add(p);
                        tile = new Spot(true,p,r,c);
                    }
                }
                else if(r==1||r==6){ //Set Pawns
                    if(r==1){
                        p = new Pawn(Side.WHITE,r,c,'P');
                        WhitePieces.add(p);
                    }
                    else{
                        p = new Pawn(Side.BLACK,r,c,'P');
                        BlackPieces.add(p);
                    }
                    tile = new Spot(true,p,r,c);
                }
                else{tile = new Spot(r,c);}
                //Checks the pattern of the tiles using modulo 2 and turns them black or white
                if((c%2==1 && r%2==1)||(c%2==0 && r%2==0)){
                    tile.setBackground(Color.WHITE);
                    tile.setColor(Color.WHITE);
                }
                else{
                    tile.setBackground(Color.BLACK);
                    tile.setColor(Color.BLACK);
                }
                
                tile.setIcon(tile.Icon());
                tile.addActionListener((ActionEvent ev) ->{ //set ActionListener for each tile, this is where the spot check takes place
                    boolean tileClicked = false;
                    for(int m=0;m<8;m++){
                        for(int n=0;n<8;n++){
                            if(tile.getPiece()!=null){
                                tile.getPiece().ResetCheck();
                                if(tile.getPiece().canMoveTo(Board[m][n])){
                                    Board[m][n].setBackground(Color.RED);
                                    Board[m][n].setHighlighted(true,tile.getPiece(),m,n);
                                    System.out.println("canMoveTo"+Board[m][n].getRow()+","+Board[m][n].getCol()); //Piece can move to these tyles
                                    System.out.println("my piece is"+" "+tile.getPiece().getSymbol());
                                }
                            }
                            else if(tile.Highlighted==true && tile.isOccupied()==false){ //set the new tiles Icon and Piece
                                    //List for Putting in Node
                                    ArrayList Move = new ArrayList();
                                    //Get Piece being moved, and Spot its originally from
                                    Piece MoveAble = tile.getMoveAblePiece();
                                    if (MoveAble.getSymbol()=='P')
                                        MoveAble.hasMoved = true;
                                    Spot Change = Board[MoveAble.getRow()][MoveAble.getCol()];
                                    Move.add(MoveAble);
                                    Move.add(MoveAble.getRow());
                                    Move.add(MoveAble.getCol());
                                    MoveHistory.insert(Move);
                                    MoveHistory.truncate();//cuts the list off where the cursor is when a move is made
                                    //set Original spot conditions to false and change Icon
                                    Change.setPiece(null);
                                    Change.IconSetter(); Change.setIcon(Change.Icon());
                                    //Set the Pieces new location, set tiles piece and status then update Icon
                                    MoveAble.setCol(tile.getCol()); MoveAble.setRow(tile.getRow());
                                    tile.setPiece(MoveAble); tile.changeStatus(true);
                                    tile.IconSetter(); tile.setIcon(tile.Icon());
                                    //End turn and set reset highlights and backgrounds
                                    tileClicked=true;
                            }
                            if (tileClicked==true){
                                Board[m][n].setBackground(Board[m][n].getColor());
                                Board[m][n].setHighlighted(false,null,m,n);
                            }
                        }
                    }
                    System.out.println("Im a tile");
                });
                Board[r][c] = tile;
                centerPanel.add(Board[r][c]);
            }
        }
        //Set the Window and add the buttons
        JMenuBar mbar = new JMenuBar();
        win.setJMenuBar(mbar);
        JMenu file = new JMenu("File");
        mbar.add(file);
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem redo = new JMenuItem("Redo");
        JMenuItem undo = new JMenuItem("Undo");
        quit.addActionListener((ActionEvent ev) -> {
            System.exit(0);
        });
        redo.addActionListener((ActionEvent ev) -> {
            ArrayList RedoHistory;
            if(MoveHistory.canRetreat()){
                //Set Node back one and get the contents
                MoveHistory.retreat();
                RedoHistory = MoveHistory.get();
            }
        });
        undo.addActionListener((ActionEvent ev) -> {
            System.out.println("IM Undoing stuff!!");
        });
        file.add(quit);
        mbar.add(undo);
        mbar.add(redo);
        //Set the window Visible
        win.setVisible(true);
    }
    
}
