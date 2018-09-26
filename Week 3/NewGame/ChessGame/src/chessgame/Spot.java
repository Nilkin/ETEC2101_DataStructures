package chessgame;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Spot extends JButton {
    boolean Occupied; boolean Highlighted; Piece piece; Piece moveAblePiece; int x,y, MAPPiecesRow, MAPPiecesCol; ImageIcon image; Color color;
    public Spot(boolean state, Piece p, int x, int y){
        this.Occupied = state; //this sets the spot as occupied by its set piece
        this.piece = p; //this is the piece occuping the spot
        this.x=x; this.y=y; //This is the Spots position
        this.Highlighted=false; //no spots highlighted at start
        IconSetter();
    }
    public Spot(int x, int y){
        this.Occupied = false;
        this.piece = null;
        this.x=x; this.y=y;
        this.Highlighted=false;
        IconSetter();
    }
    public Piece getPiece(){
        if(this.piece!=null)
            return this.piece;
        else return null;
    }
    public Piece getMoveAblePiece(){
        if(this.moveAblePiece!=null)
            return this.moveAblePiece;
        else return null;
    }
    public boolean isOccupied(){
        return this.Occupied;
    }
    public void changeStatus(boolean state){
        this.Occupied = state;
    }
    public void setPiece(Piece p){
        if(p!=null){
            this.piece = p;
            changeStatus(true);
        }
        else{
            this.piece = null;
            changeStatus(false);
        }
    }
    public int getRow(){
        return this.x;
    }
    public int getCol(){
        return this.y;
    }
    public int getMoveRow(){
        return this.MAPPiecesRow;
    }
    public int getMoveCol(){
        return this.MAPPiecesCol;
    }
    void IconSetter(){
        if(isOccupied()==true){
            this.image = piece.image();
        }
        else
            this.image = new ImageIcon(new BufferedImage(45,45,BufferedImage.TYPE_INT_ARGB));
    }
    public ImageIcon Icon(){
        return this.image;
    }
    public void setColor(Color c){
        this.color=c;
    }
    public Color getColor(){
        return this.color;
    }
    public void setHighlighted(boolean c, Piece moveAblePiece, int piecesRow, int piecesCol){
        this.Highlighted=c;
        this.moveAblePiece=moveAblePiece; //the piece that can be moved to the spot next clicked if its also highlighted
        this.MAPPiecesRow=piecesRow;
        this.MAPPiecesCol=piecesCol;
    }
}
