package chessgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ChessBoard {
    //This is the Board Array
    Spot[][] Board = new Spot[8][8];
    //Array Of WhiteChessPieces & Array of BlackChessPieces
    ArrayList<Piece> WhitePieces = new ArrayList();
    ArrayList<Piece> BlackPieces = new ArrayList();
    public ChessBoard(){
        setBoard();
    }
    void setBoard(){ //sets the Squares on the Board
        Piece p;
        Spot tile;
        for(int row=0; row<8;row++){
            for(int col=0; col<8;){

                //Set the Spot Pieces
                if(row==0||row==7){ //differ from white back row and black back row
                    if(row==0){ //(white) top of bord pieces
                        if(col==0||col==7)
                            p = new Rook(Side.WHITE,row,col,'R');
                        else if(col==1||col==6)
                            p = new Knight(Side.WHITE,row,col,'N');
                        else if(col==2||col==5)
                            p = new Bishop(Side.WHITE,row,col,'B');
                        else if(col==3)
                            p = new Queen(Side.WHITE,row,col,'Q');
                        else
                            p = new King(Side.WHITE,row,col,'K');
                        WhitePieces.add(p);
                        tile = new Spot(true,p,row,col);
                    }
                    else{
                        if(col==0||col==7)
                            p = new Rook(Side.BLACK,row,col,'R');
                        else if(col==1||col==6)
                            p = new Knight(Side.BLACK,row,col,'N');
                        else if(col==2||col==5)
                            p = new Bishop(Side.BLACK,row,col,'B');
                        else if(col==3)
                            p = new Queen(Side.BLACK,row,col,'Q');
                        else
                            p = new King(Side.BLACK,row,col,'K');
                        BlackPieces.add(p);
                        tile = new Spot(true,p,row,col);
                    }
                }
                else if(row==1||row==6){ //Set Pawns
                    if(row==1){
                        p = new Pawn(Side.WHITE,row,col,'P');
                        WhitePieces.add(p);
                    }
                    else{
                        p = new Pawn(Side.BLACK,row,col,'P');
                        BlackPieces.add(p);
                    }
                    tile = new Spot(true,p,row,col);
                }
                else{tile = new Spot(row,col);} //spot doesnt have a piece
                
                //Differ the Color of the tiles based on the remainder
                if((col%2==1 && row%2==1)||(col%2==0 && row%2==0)){
                    tile.setBackground(Color.WHITE);
                    tile.setColor(Color.WHITE);
                }
                else{
                    tile.setBackground(Color.BLACK);
                    tile.setColor(Color.BLACK);
                }
                setSpotAction(tile);
                this.Board[row][col] = tile;   
            }
        }
    }

    void setSpotAction(Spot tile){
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
                        //Get Piece being moved, and Spot its originally from
                        Piece MoveAble = tile.getMoveAblePiece();
                        if (MoveAble.getSymbol()=='P')
                            MoveAble.hasMoved = true;
                        Spot Change = Board[MoveAble.getRow()][MoveAble.getCol()];
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
    }
}
