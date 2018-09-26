package chessgame;

import javax.swing.ImageIcon;

public class Bishop extends Piece {
    Bishop(Side side, int r, int c, char s){
        super(side,r,c,s);
        getImageB();
        getImageW();
    }
    @Override
    public boolean canMoveTo(Spot spot){
        Spot s=spot;//the spot being checked to move to
        int r=spot.getX(), c=spot.getY(); //the spots coordinates
        boolean Occupied=s.isOccupied();
        int pr = getRow(), pc = getCol();
        //both the row and col are same amount of square spaces diagonally from origin
        if((r-pr)==(c-pc) || (r-pr)*(-1)==(c-pc))
            return true;
        else
            return false;
    }
    final void getImageB(){
        this.bImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/bBishop.png"));
    }
    final void getImageW(){
        this.wImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/wBishop.png"));
    }
    @Override
    public ImageIcon image(){
        if(this.side==Side.WHITE){
            return this.wImg;
        }
        else
            return this.bImg;
    }
}