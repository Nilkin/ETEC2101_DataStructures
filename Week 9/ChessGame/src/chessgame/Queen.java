package chessgame;

import javax.swing.ImageIcon;

public class Queen extends Piece {
    Queen(Side side, int r, int c, char s){
        super(side,r,c,s);
        getImageB();
        getImageW();
    }
    @Override
    public boolean canMoveTo(Spot spot){
        Spot s=spot;//the spot being checked to move to
        int r=spot.getRow(), c=spot.getCol(); //the spots coordinates
        boolean Occupied=s.isOccupied();
        int pr = getRow(), pc = getCol();
        //both the row and col are same amount of square spaces diagonally from origin
        if((r-pr)==(c-pc) || (r-pr)*(-1)==(c-pc))
            return true;
        //Can move up or down as long as in Col
        else if((r>pr || r<pr) && c==pc)
            return true;
        //Can move left or right as long as in Row
        else if(r==pr && (c>pc || c<pc))
            return true;
        else
            return false;
    }
    final void getImageB(){
        this.bImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/bQueen.png"));
    }
    final void getImageW(){
        this.wImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/wQueen.png"));
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