package chessgame;

import javax.swing.ImageIcon;

public class Rook extends Piece {
    boolean blockedUp=false,blockedDown=false,blockedLeft=false,blockedRight=false;
    
    Rook(Side side, int r, int c, char s){
        super(side,r,c,s);
        getImageB();
        getImageW();
    }
    @Override
    public boolean canMoveTo(Spot spot){
        Spot s=spot;//the spot being checked to move to
        int r=s.getRow(), c=s.getCol(); //the spots coordinates
        boolean Occupied=s.isOccupied();
        int pr = this.getRow(); int pc = this.getCol();
        //Can move up or down as long as in Col
        if((r>pr || r<pr) && c==pc){
            if(this.blockedUp==false){
                if(Occupied==true){
                    if(s.getPiece().getSide()!=this.side){
                        if(r>pr && pc==c){
                            this.blockedUp=true;
                            return true;
                        }
                    }
                    else{
                        this.blockedUp=true;
                        return false;
                    }
                }
                return true; //Piece isnt blocked
            }
            else if(this.blockedDown==false){
                if(Occupied==true){
                    if(s.getPiece().getSide()!=this.side){
                        if(r<pr && pc==c){
                            this.blockedDown=true;
                            return true;
                        }
                    }
                    else{
                        this.blockedDown=true;
                        return false;
                    }
                }
                return true; //Piece isnt blocked
            }
            return false;
        }
        if(r==pr && (c>pc || c<pc)){//Can move left or right as long as in Row
            if(this.blockedLeft==false){
                if(Occupied==true){
                    if(s.getPiece().getSide()!=this.side){//opposing faction piece
                        if(pr==r && c<pc){//in row to left of piece
                            this.blockedLeft=true;
                            return true;
                        }
                    }
                    else{
                        this.blockedLeft=true;
                        return false;
                    }
                }
                return true;
            }
            else if(this.blockedRight==false){
                if(Occupied==true){
                    if(s.getPiece().getSide()!=this.side){
                        if(r==pr && c>pc){//in row to the right of piece
                            this.blockedRight=true;
                            return true;
                        }
                    }
                    else{
                        this.blockedRight=true;
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        //cant move diagonally
        return false;
    }
    final void getImageB(){
        this.bImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/bRook.png"));
    }
    final void getImageW(){
        this.wImg = new ImageIcon(getClass().getClassLoader().getResource("ChessGame/Resources/wRook.png"));
    }
    @Override
    public ImageIcon image(){
        if(this.side==Side.WHITE){
            return this.wImg;
        }
        else
            return this.bImg;
    }
    @Override
    public void ResetCheck(){
        this.blockedUp=false;this.blockedDown=false;this.blockedLeft=false;this.blockedRight=false;
    }
}