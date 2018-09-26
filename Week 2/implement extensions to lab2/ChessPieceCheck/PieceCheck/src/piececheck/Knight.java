package piececheck;
public class Knight extends Piece{
    Knight(int r, int c, char s){
        super(r,c,s);
    }
    @Override
    public boolean canMoveTo(int r, int c){
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
}
