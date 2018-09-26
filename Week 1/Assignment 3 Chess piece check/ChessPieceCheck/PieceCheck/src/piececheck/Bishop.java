package piececheck;
public class Bishop extends Piece {
    Bishop(int r, int c, char s){
        super(r,c,s);
    }
    @Override
    public boolean canMoveTo(int r, int c){
        int pr = getRow(), pc = getCol();
        //both the row and col are same amount of square spaces diagonally from origin
        if((r-pr)==(c-pc) || (r-pr)*(-1)==(c-pc))
            return true;
        else
            return false;
    }
}
