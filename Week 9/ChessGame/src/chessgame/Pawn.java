package chessgame;

import javax.swing.ImageIcon;

public class Pawn extends Piece{
    Pawn(Side side,int r, int c, char s){
        super(side,r,c,s);
        getImageB();
        getImageW();
    }
    @Override
    public boolean canMoveTo(Spot spot){
        Spot s=spot;//the spot being checked to move to
        int r=spot.getRow(), c=spot.getCol(); //the spots coordinates
        boolean Occupied=s.isOccupied();
        if(Occupied==false){
            if(this.side==Side.WHITE){
                if (this.hasMoved==false){
                    if(((r-2)==getRow() && c==getCol()) || ((r-1)==getRow() && c==getCol()))
                        return true ;
                }
                else if((r-1)==getRow() && c==getCol())
                        return true ;
            }
            else if(this.side==Side.BLACK){
                if (this.hasMoved==false){
                    if(((r+2)==getRow() && c==getCol()) || ((r+1)==getRow() && c==getCol()))
                        return true ;
                }
                else if((r+1)==getRow() && c==getCol())
                        return true ;
            }
        }
        return false;
    }
    final void getImageB(){
        this.bImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/bPawn.png"));
    }
    final void getImageW(){
        this.wImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/wPawn.png"));
    }
    @Override
    public ImageIcon image(){
        if(this.side==Side.WHITE){
            getImageW();
            return this.wImg;
        }
        else
            getImageB();
            return this.bImg;
    }
}
