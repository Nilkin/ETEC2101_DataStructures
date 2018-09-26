package chessgame;

import javax.swing.ImageIcon;

public class King extends Piece{
    King(Side side, int r, int c, char s){
        super(side,r,c,s);
        getImageB();
        getImageW();
    }
    @Override
    public boolean canMoveTo(Spot spot){
        Spot s=spot;//the spot being checked to move to
        int r=spot.getRow(), c=spot.getCol(); //the spots coordinates
        boolean Occupied=s.isOccupied();
        int pr = getRow(); int pc = getCol();
        //is one square up or down
        if(c>(pc+1) || c<(pc-1))
            return false;
        else if(r>(pr+1) || r<(pr-1))
            return false;
        else
            return true;
    }
    final void getImageB(){
        this.bImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/bKing.png"));
    }
    final void getImageW(){
        this.wImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/wKing.png"));
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