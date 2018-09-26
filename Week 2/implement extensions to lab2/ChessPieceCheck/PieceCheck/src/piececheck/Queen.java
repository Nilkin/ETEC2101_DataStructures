package piececheck;
public class Queen extends Piece {
    Queen(int r, int c, char s){
        super(r,c,s);
    }
    @Override
    public boolean canMoveTo(int r, int c){
        int pr = getRow(), pc = getCol();
        //both the row and col are same amount of square spaces diagonally from origin
        if((r-pr)==(c-pc) || (r-pr)*(-1)==(c-pc))
            return true;
        //Can move up or down as long as in Col
        else if((r>pr || r<pr) && c==pc)
            return true;
        //Can move left or right as long as in Row
        else if(r==pr && (c>pc || c<pc))
            return true;
        else
            return false;
    }
    
}
