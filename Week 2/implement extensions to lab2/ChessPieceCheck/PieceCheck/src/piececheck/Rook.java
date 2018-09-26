package piececheck;
public class Rook extends Piece {
    Rook(int r, int c, char s){
        super(r,c,s);
    }
    @Override
    public boolean canMoveTo(int r, int c){
        int pr = getRow(); int pc = getCol();
        //Can move up or down as long as in Col
        if((r>pr || r<pr) && c==pc)
            return true;
        //Can move left or right as long as in Row
        else if(r==pr && (c>pc || c<pc))
            return true;
        //cant move diagonally
        else
            return false;
    }
}
