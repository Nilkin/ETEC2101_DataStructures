package chessgame;

import java.util.ArrayList;
import javax.swing.ImageIcon;

abstract public class Piece {
    int Width=45, Height=45; //image dimensions
    int row,col;
    char s;
    Side side;
    ImageIcon wImg, bImg;
    boolean hasMoved=false;
    ArrayList<Spot> Checker = new ArrayList();
    Piece(Side side, int ri, int ci, char sym){
       this.side=side; this.row = ri; this.col = ci; this.s = sym;
    }
    public int getRow(){ 
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    public void setRow(int r){
        this.row=r;
    }
    public void setCol(int c){
        this.col=c;
    }
    public char getSymbol(){
        return this.s;
    }
    abstract boolean canMoveTo(Spot spot);
    
    public ImageIcon image(){
        if(this.side==Side.WHITE)
            return this.wImg;
        else
            return this.bImg;
    }
    public boolean sideCheck(Side s){
        if(s!=null)
            if (this.side==s)
                return true;
        return false;
    }
    public Side getSide(){
        return this.side;
    }
    public void ResetCheck(){
    }
}
