package piececheck;
/**
 *
 * @author Thoma
 */
public class Pawn extends Piece{
    Pawn(int r, int c, char s){
        super(r,c,s);
    }
    @Override
    public boolean canMoveTo(int r, int c){
        if((r-1)==getRow() && c==getCol())
            return true ;
        else
            return false;
    }
}
