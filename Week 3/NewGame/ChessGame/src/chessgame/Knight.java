package chessgame;

import javax.swing.ImageIcon;

public class Knight extends Piece{
    Knight(Side side, int r, int c, char s){
        super(side,r,c,s);
        this.side=side;
        getImageB();
        getImageW();
    }
    @Override
    public boolean canMoveTo(Spot spot){
        Spot s=spot;//the spot being checked to move to
        int r=spot.getRow(), c=spot.getCol(); //the spots coordinates
        boolean Occupied=s.isOccupied();
        int pr = getRow(); int pc = getCol();
        //move 2 up then left or right
        if((r==(pr+2) && c==(pc+1)) || (r==(pr+2) && c==(pc-1)))
            return true;
        //move 2 down then left or right
        else if((r==(pr-2) && c==(pc+1)) || (r==(pr-2) && c==(pc-1)))
            return true;
        //move 2 right then up or down
        else if((r==(pr+1) && c==(pc+2)) || (r==(pr-1) && c==(pc+2)))
            return true;
        //move 2 left then up or down
        else if((r==(pr+1) && c==(pc-2)) || (r==(pr-1) && c==(pc-2)))
            return true;
        //outside moveable range
        else
            return false;
    }
    final void getImageB(){
        this.bImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/bKnight.png"));
    }
    final void getImageW(){
        this.wImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/wKnight.png"));
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