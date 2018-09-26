package piececheck;
public class King extends Piece{
    King(int r, int c, char s){
        super(r,c,s);
    }
    @Override
    public boolean canMoveTo(int r, int c){
        int pr = getRow(); int pc = getCol();
        //is one square up or down
        if(c>(pc+1) || c<(pc-1))
            return false;
        else if(r>(pr+1) || r<(pr-1))
            return false;
        else
            return true;
    }
}
